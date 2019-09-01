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
    
    public void add_file(int Hesh, String name, String kind, String dir, String size, int uploader_UID) {
        try {
            Statement statement =mConnect.createStatement();
            String sql ="INSERT INTO test_file.allfiles(Hesh, name, kind, dir, size, uploader_UID, upload_time) VALUES (" + Hesh + ",'"+
                name+"','"+kind+"','"+dir+"','" + size + "'," + uploader_UID + ",now()" + ");";
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("file " + name + " added");
        } catch (SQLException e) {
            if(e.getMessage().contains("PRIMARY")) 
                System.err.println("File "  + name + " existed");    
        }
     }
    
    public File getFile(int Hesh) {
        String sql ="SELECT * FROM test_file.allfiles WHERE Hesh = " + Hesh + ";";
        String log;
        try {
            Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.first()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
                log = sdf.format(result.getTimestamp("upload_time"));
                File file =new File(
                		result.getInt("Hesh"), 
                		result.getString("name"), 
                		result.getString("kind"),
                		result.getString("dir"),
                		result.getString("size"),
                		result.getInt("uploader_UID"),
                		log);            
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
    	try {
            String sql="UPDATE test_file.allfiles SET " + keyword + "= '"+new_info+ "' WHERE Hesh = '"+Hesh+"';";
            File file =getFile(Hesh);
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
    
    public void delete_file(int Hesh) {
    	try {
            String sql="DELETE FROM test_file.allfiles WHERE Hesh = '"+Hesh+"';";
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
    
    public List<Integer> order_by(String keyword, boolean ASC) {
    	List<Integer> Heshs = new ArrayList<Integer>();
    	try {
    		String sql = null;
    		if(ASC) 
    			sql = "SELECT Hesh FROM test_file.allfiles ORDER BY " + keyword + ";";
    		else
    			sql = "SELECT Hesh FROM test_file.allfiles ORDER BY " + keyword + " DESC;";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Heshs.add(result.getInt("Hesh"));
            }
            return Heshs;
    	}catch(SQLException e) {}
    	return Heshs;
    }
    
}
