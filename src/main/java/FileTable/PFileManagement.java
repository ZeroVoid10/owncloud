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
import tempFileTable.TFileManagement;


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
        	Statement statement =mConnect.createStatement();
            String sql ="INSERT INTO test_file." + table_name + "(Hesh) VALUES (" + Hesh + ");";
            statement.executeUpdate(sql);//执行语句
            statement.close();
            System.out.println("file " + name + " added");
        } catch (SQLException e) {
            if(e.getMessage().contains("PRIMARY")) 
                System.err.println("文件 "  + name + " 重复");    
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
            	System.err.println("无此文件");
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
    			System.err.println("无此文件");
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
        if(file != null) {
            FileManagement fm = new FileManagement(MysqlConnection.getConnection());
            fm.update_file_info(Hesh, keyword, new_info);
            result= 0;
            return result;
        }else {
        	result=2;
            System.err.println("无此文件");
            return result;
        }
    }
    
    public void delete_file(int Hesh) {
    	try {
            String sql="DELETE FROM test_file." + table_name + " WHERE Hesh = '"+ Hesh +"';";
            File file =getFile(Hesh);
            if(file != null) {
            	Statement statement =mConnect.createStatement();
            	statement.executeUpdate(sql);
            	statement.close();
            	System.out.println("file Hesh: " + Hesh + " deleted");
            }else {
                System.err.println("无此文件");
            }
        }catch(SQLException e) {}
    }
    
    public List<Integer> order_by(String keyword, boolean ASC) {
    	List<Integer> Heshs = new ArrayList<Integer>();
    	try {
    		String sql = "SELECT * FROM test_file." + table_name + ";";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Heshs.add(result.getInt("Hesh"));
            }
            TFileManagement tfm = new TFileManagement(MysqlConnection.getConnection());
            return tfm.order_by(Heshs, keyword, ASC);
    	}catch(SQLException e) {}
    	return Heshs;
    }
    
}
