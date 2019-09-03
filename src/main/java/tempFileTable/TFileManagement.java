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
	public int UID;
    public TFileManagement(Connection connection, int UID) {
        super();
        this.mConnect = connection;
        this.UID = UID;
    }
    
    public void add_file(List<Integer> Hashs) {
        try {
        	@SuppressWarnings("unused")
			boolean status = new CreateTable(MysqlConnection.getConnection(), UID).create_table();
        	FileManagement fm = new FileManagement(MysqlConnection.getConnection());
        	for(Integer i : Hashs) {
            	File file = fm.getFile(i);
            	String name = file.getName();
            	String kind = file.getKind();
            	String dir = file.getDir();
            	String size = file.getSize();
            	int uploader_UID = file.getUploader_UID();
            	String upload_time = file.getUpload_time();
            	Statement statement =mConnect.createStatement();
            	String sql ="INSERT INTO test_file.temptable" + String.valueOf(UID) + "(Hash, name, kind, dir, size, uploader_UID, upload_time) VALUES (" + i + ",'"+
                        name+"','"+kind+"','"+dir+"','" + size + "'," + uploader_UID + ",'" + upload_time + "');";
                statement.executeUpdate(sql);
                statement.close();
            }
        } catch (SQLException e) {
        }
     }
    
    public List<Integer> order_by(List<Integer> Hashs_before, String keyword, boolean ASC) {
    	add_file(Hashs_before);
    	List<Integer> Hashs = new ArrayList<Integer>();
    	try {
    		String sql = null;
    		if(ASC) 
    			sql = "SELECT Hash FROM test_file.temptable" + String.valueOf(UID) + " ORDER BY " + keyword + ";";
    		else
    			sql = "SELECT Hash FROM test_file.temptable" + String.valueOf(UID) + " ORDER BY " + keyword + " DESC;";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Hashs.add(result.getInt("Hash"));
            }
            delete_table();
            return Hashs;
    	}catch(SQLException e) {delete_table();}
    	delete_table();
    	return Hashs;
    }
    
    public List<Integer> search_file(List<Integer> Hashs_before, String keyword ,String file_name) {
    	add_file(Hashs_before);
    	List<Integer> Hashs = new ArrayList<Integer>();
    	try {
    		String sql = "SELECT Hash FROM test_file.temptable" + String.valueOf(UID) + " WHERE " + keyword + " like '%" + file_name + "%';";
    		Statement statement =mConnect.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
            	Hashs.add(result.getInt("Hash"));
            }
            delete_table();
            return Hashs;
    	}catch(SQLException e) {delete_table();}
    	delete_table();
    	return Hashs;
    }
    
    public void delete_table() {
    	try{
    		String sql = "DROP TABLE test_file.temptable" + String.valueOf(UID) + ";";
        	Statement statement = mConnect.createStatement();
            statement.executeUpdate(sql);
            statement.close();
    	}catch(SQLException e) {}
    	
    }
    
}
