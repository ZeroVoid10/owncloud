package FileTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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
    
    public void add_file(int Hash, String name, String kind, String dir, String size, int uploader_UID, String tag) {
    	String sql = null;
    	try {
        	FileManagement fm = new FileManagement(MysqlConnection.getConnection());
        	File file = fm.getFile(Hash);
        	if(file == null) {
        		fm.add_file(Hash, name, kind, dir, size, uploader_UID, tag);
        		file = fm.getFile(Hash);
        		String upload_time = file.getUpload_time();
        		sql = "INSERT INTO test_file." + table_name + "(Hash, name, kind, dir, size, uploader_UID, upload_time, tag) VALUES (" + Hash + ",'"+
                		name + "','" + kind + "','" + dir + "','" + size + "'," + uploader_UID + ",'" + upload_time + "','" + tag + "');";
        	}
        	else
        		sql ="INSERT INTO test_file." + table_name + "(Hash, name, kind, dir, size, uploader_UID, upload_time, tag) VALUES (" + Hash + ",'"+
        				name + "','" + kind + "','" + dir + "','" + size + "'," + uploader_UID + ",now(),'" + tag + "');";
            Statement statement =mConnect.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("File " + name + " added");
        } catch (SQLException e) {
            if(e.getMessage().contains("PRIMARY")) 
                System.err.println("File "  + name + " existed");    
            }
     }
    
    public File getFile(int Hash) {
        String sql ="SELECT * FROM test_file." + table_name +" WHERE Hash = " + Hash + ";";
        String log;
        try {
            Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.first()) {
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                log = sdf.format(result.getTimestamp("upload_time"));
                File file =new File(
                		result.getInt("Hash"), 
                		result.getString("name"), 
                		result.getString("kind"),
                		result.getString("dir"),
                		result.getString("size"),
                		result.getInt("uploader_UID"),
                		log,
                		result.getString("tag"));            
            	statement.close();
                return file;
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
    		System.out.println("Hash: " + file.getHash());
    		System.out.println("name: " + file.getName());
    		System.out.println("kind: " + file.getKind());
	    	System.out.println("dir: " + file.getDir());
	    	System.out.println("size: " + file.getSize());
	    	System.out.println("uploader_UID: " + file.getUploader_UID());
	    	System.out.println("upload_time: " + file.getUpload_time());
	    	System.out.println("tag: " + file.getTag());
    	}catch(Exception ex) {
    		
    	}
    		
    }
    
    public int update_file_info(int Hash, String keyword, String new_info) {
    	int result =-1;
        File file =getFile(Hash);
        try {
        	if(file != null) {
	            String sql="UPDATE test_file." + table_name +" SET " + keyword + "= '"+new_info+ "' WHERE Hash = '"+Hash+"';";
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
    
    public void delete_file(int Hash) {
    	try {
            String sql="DELETE FROM test_file." + table_name + " WHERE Hash = '"+ Hash +"';";
            File file =getFile(Hash);
            if(file != null) {
            	Statement statement =mConnect.createStatement();
            	statement.executeUpdate(sql);
            	statement.close();
            	System.out.println("File Hash: " + Hash + " deleted");
            }else {
                System.err.println("File don't exist");
            }
        }catch(SQLException e) {}
    }
    
    public List<Integer> getFileList() {
    	List<Integer> Hashs = new ArrayList<Integer>();
    	try {
    		String sql = "SELECT * FROM test_file." + table_name + ";";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Hashs.add(result.getInt("Hash"));
            }
            return Hashs;
    	}catch(SQLException e) {}
    	return Hashs;
    }
    
    public List<File> order_by(String keyword, boolean ASC) {
    	List<File> files = new ArrayList<File>();
    	try {
    		String sql = null;
    		if(ASC) 
    			sql = "SELECT Hash FROM test_file." + table_name + " ORDER BY " + keyword + ";";
    		else
    			sql = "SELECT Hash FROM test_file." + table_name + " ORDER BY " + keyword + " DESC;";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	files.add(getFile(result.getInt("Hash")));
            }
            return files;
    	}catch(SQLException e) {}
    	return files;
    }
    
    public List<File> search_file(String keyword, String input) {
    	List<File> files = new ArrayList<File>();
    	try {
    		String sql = "SELECT Hash FROM test_file." + table_name + " WHERE " + keyword + " like '%" + input + "%';";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	files.add(getFile(result.getInt("Hash")));
            }
            if(files.size() == 0)
            	System.out.println("No result");
            return files;
    	}catch(SQLException e) {}
    	return files;
    }
    
}
