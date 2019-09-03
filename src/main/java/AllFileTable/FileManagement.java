package AllFileTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class FileManagement {

	public Connection mConnect;
    public FileManagement(Connection connection) {
        super();
        this.mConnect = connection;
    }
    
    public void add_file(int Hash, String name, String kind, String dir, String size, int uploader_UID, String tag) {
        try {
            Statement statement =mConnect.createStatement();
            String sql ="INSERT INTO test_file.allfiles(Hash, name, kind, dir, size, uploader_UID, upload_time, tag) VALUES (" + Hash + ",'"+
                name+"','"+kind+"','"+dir+"','" + size + "'," + uploader_UID + ",now(),'" + tag + "');";
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("file " + name + " added");
        } catch (SQLException e) {
            if(e.getMessage().contains("PRIMARY")) 
                System.err.println("File "  + name + " existed");    
        }
     }
    
    public File getFile(int Hash) {
        String sql ="SELECT * FROM test_file.allfiles WHERE Hash = " + Hash + ";";
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
    	try {
            String sql="UPDATE test_file.allfiles SET " + keyword + "= '"+new_info+ "' WHERE Hash = '"+Hash+"';";
            File file =getFile(Hash);
            if(file != null) {
            	Statement statement =mConnect.createStatement();
            	statement.executeUpdate(sql);
            	statement.close();
            	result= 0;
            }else {
                result=2;
                System.err.println("File don't exist");
            }
        }catch(SQLException e) {}
    	return result;
    }
    
    public void delete_file(int Hash) {
    	try {
            String sql="DELETE FROM test_file.allfiles WHERE Hash = '"+Hash+"';";
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
    
    public List<File> order_by(String keyword, boolean ASC) {
    	List<File> files = new ArrayList<File>();
    	try {
    		String sql = null;
    		if(ASC) 
    			sql = "SELECT Hash FROM test_file.allfiles ORDER BY " + keyword + ";";
    		else
    			sql = "SELECT Hash FROM test_file.allfiles ORDER BY " + keyword + " DESC;";
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
    		String sql = "SELECT Hash FROM test_file.allfiles WHERE " + keyword + " like '%" + input + "%';";
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
    
    public List<File> mult_search_file(String name, String kind, String uploader_UID, String tag) {
    	List<File> files = new ArrayList<File>();
    	String sql = "SELECT Hash FROM test_file.allfiles";
    	try {
    		if(name != "")
    			sql += (" WHERE name like '%" + name + "%'");
    		if(kind != "") {
    			if(name == "")
    				sql += (" WHERE kind like '%" + kind + "%'");
    			else
    				sql += (" AND kind like '%" + kind + "%'");
    		}
    		if(uploader_UID != "") {
    			if(name == "" && kind == "")
    				sql += (" WHERE uploader_UID like '%" + uploader_UID + "%'");
    			else
    				sql += (" AND uploader_UID like '%" + uploader_UID + "%'");
    		}
    		if(tag != "") {
    			if(name == "" && kind == "" && uploader_UID == "")
    				sql += (" WHERE tag like '%" + tag + "%'");
    			else
    				sql += (" AND tag like '%" + tag + "%'");
    		}
    		sql += ";";
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
