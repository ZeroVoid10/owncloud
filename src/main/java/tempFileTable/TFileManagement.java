package tempFileTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import AllFileTable.FileManagement;
import AllFileTable.MysqlConnection;
import AllFileTable.File;

public class TFileManagement {

	public Connection mConnect;
    public TFileManagement(Connection connection) {
        super();
        this.mConnect = connection;
    }
    
    public void add_file(List<Integer> Heshs) {
        try {
        	@SuppressWarnings("unused")
			boolean status = new CreateTable(MysqlConnection.getConnection()).create_table();
        	FileManagement fm = new FileManagement(MysqlConnection.getConnection());
        	for(Integer i : Heshs) {
            	File file = fm.getFile(i);
            	String name = file.getName();
            	String kind = file.getKind();
            	String dir = file.getDir();
            	String size = file.getSize();
            	int uploader_UID = file.getUploader_UID();
            	String upload_time = file.getUpload_time();
            	Statement statement =mConnect.createStatement();
            	String sql ="INSERT INTO test_file.temptable(Hesh, name, kind, dir, size, uploader_UID, upload_time) VALUES (" + i + ",'"+
                        name+"','"+kind+"','"+dir+"','" + size + "'," + uploader_UID + ",'" + upload_time + "');";
                statement.executeUpdate(sql);//Ö´ÐÐÓï¾ä
                statement.close();
            }
        } catch (SQLException e) {
        }
     }
    
    public List<Integer> order_by(List<Integer> Heshs_before, String keyword, boolean ASC) {
    	add_file(Heshs_before);
    	List<Integer> Heshs = new ArrayList<Integer>();
    	try {
    		String sql = null;
    		if(ASC) 
    			sql = "SELECT Hesh FROM test_file.temptable ORDER BY " + keyword + ";";
    		else
    			sql = "SELECT Hesh FROM test_file.temptable ORDER BY " + keyword + " DESC;";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Heshs.add(result.getInt("Hesh"));
            }
            delete_table();
            return Heshs;
    	}catch(SQLException e) {delete_table();}
    	delete_table();
    	return Heshs;
    }
    
    public List<Integer> search_file(List<Integer> Heshs_before, String file_name) {
    	add_file(Heshs_before);
    	List<Integer> Heshs = new ArrayList<Integer>();
    	try {
    		String sql = "SELECT Hesh FROM test_file.temptable WHERE name like '%" + file_name + "%';";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Heshs.add(result.getInt("Hesh"));
            }
            delete_table();
            return Heshs;
    	}catch(SQLException e) {delete_table();}
    	delete_table();
    	return Heshs;
    }
    
    public void delete_table() {
    	try{
    		String sql = "DROP TABLE test_file.temptable;";
        	Statement statement = mConnect.createStatement();
            statement.executeUpdate(sql);//Ö´ÐÐÓï¾ä
            statement.close();
    	}catch(SQLException e) {}
    	
    }
    
}
