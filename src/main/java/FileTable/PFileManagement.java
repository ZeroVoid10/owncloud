package FileTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import AllFileTable.FileManagement;
import AllFileTable.MysqlConnection;
import AllFileTable.File;


public class PFileManagement {

	public Connection mConnect;
	public String table_name;
	
    public PFileManagement(Connection connection, String table_name) {
        super();
        this.mConnect = connection;
        this.table_name = table_name;
    }
    
    public void add_file(int Hesh, String name, String kind, String dir, String size, int uploader_UID) {
        try {
        	FileManagement fm = new FileManagement(MysqlConnection.getConnection());
        	File file = fm.getFile(Hesh);
        	if(file == null) {
        		fm.add_file(Hesh, name, kind, dir, size, uploader_UID);
        	}
        	file = fm.getFile(Hesh);
        	String upload_time = file.getUpload_time();
        	Statement statement =mConnect.createStatement();
            String sql ="INSERT INTO test_file." + table_name + "(Hesh, name, kind, dir, size, uploader_UID, upload_time) VALUES (" + Hesh + ",'"+
            		name + "','" + kind + "','" + dir + "','" + size + "'," + uploader_UID + ",'" + upload_time + "');";
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("File " + name + " added");
        } catch (SQLException e) {
            if(e.getMessage().contains("PRIMARY")) 
                System.err.println("File "  + name + " existed");    
            }
     }
    
    public File getFile(int Hesh) {
        String sql ="SELECT * FROM test_file." + table_name +" WHERE Hesh = " + Hesh + ";";
        try {
            Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.first()) {
            	FileManagement fm = new FileManagement(MysqlConnection.getConnection());
                return fm.getFile(Hesh);
            }
            else {
            	System.err.println("File don't exist");
            	statement.close();
            	return null;
            }
            	
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    
    public void PrintFileInfos(File file) {
    	try{
    		if(file == null)
    			System.err.println("File don't exist");
    		System.out.println("Hesh: " + file.getHesh());
    		System.out.println("name: " + file.getName());
    		System.out.println("kind: " + file.getKind());
	    	System.out.println("dir: " + file.getDir());
	    	System.out.println("size: " + file.getSize());
	    	System.out.println("uploader_UID: " + file.getUploader_UID());
	    	System.out.println("upload_time: " + file.getUpload_time());
    	}catch(Exception ex) {
    		
    	}
    		
    }
    
    public int update_file_info(int Hesh, String keyword, String new_info) {
    	int result =-1;
        File file =getFile(Hesh);
        try {
        	if(file != null) {
	            FileManagement fm = new FileManagement(MysqlConnection.getConnection());
	            fm.update_file_info(Hesh, keyword, new_info);
	            String sql="UPDATE test_file." + table_name +" SET " + keyword + "= '"+new_info+ "' WHERE Hesh = '"+Hesh+"';";
	            Statement statement =mConnect.createStatement();
	            statement.executeUpdate(sql);
	            statement.close();
	            result= 0;
	            return result;
	        }else {
	        	result=2;
	            System.err.println("File don't exist");
	            return result;
	        }
        }catch(SQLException e) {
        }
    	return result;
    }
    
    public void delete_file(int Hesh) {
    	try {
            String sql="DELETE FROM test_file." + table_name + " WHERE Hesh = '"+ Hesh +"';";
            File file =getFile(Hesh);
            if(file != null) {
            	Statement statement =mConnect.createStatement();
            	statement.executeUpdate(sql);
            	statement.close();
            	System.out.println("File Hesh: " + Hesh + " deleted");
            }else {
                System.err.println("File don't exist");
            }
        }catch(SQLException e) {}
    }
    
    public List<Integer> getFileList() {
    	List<Integer> Heshs = new ArrayList<Integer>();
    	try {
    		String sql = "SELECT * FROM test_file." + table_name + ";";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Heshs.add(result.getInt("Hesh"));
            }
            return Heshs;
    	}catch(SQLException e) {}
    	return Heshs;
    }
    
    public List<File> order_by(String keyword, boolean ASC) {
    	List<File> files = new ArrayList<File>();
    	try {
    		String sql = null;
    		if(ASC) 
    			sql = "SELECT Hesh FROM test_file." + table_name + " ORDER BY " + keyword + ";";
    		else
    			sql = "SELECT Hesh FROM test_file." + table_name + " ORDER BY " + keyword + " DESC;";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	files.add(getFile(result.getInt("Hesh")));
            }
            return files;
    	}catch(SQLException e) {}
    	return files;
    }
    
    public List<File> search_file(String keyword, String input) {
    	List<File> files = new ArrayList<File>();
    	try {
    		String sql = "SELECT Hesh FROM test_file." + table_name + " WHERE " + keyword + " like '%" + input + "%';";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	files.add(getFile(result.getInt("Hesh")));
            }
            if(files.size() == 0)
            	System.out.println("No result");
            return files;
    	}catch(SQLException e) {}
    	return files;
    }
    
}
