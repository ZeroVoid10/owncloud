package AllFileTable;

import java.util.Map;

public class File {

	public int getHash() {
		return Hash;
	}

	public void setHash(int hash) {
		Hash = hash;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getUploader_UID() {
		return uploader_UID;
	}

	public void setUploader_UID(int uploader_UID) {
		this.uploader_UID = uploader_UID;
	}

	public String getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}

	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	int Hash;
	String name;
	String kind;
	String dir;
	String size;
	int uploader_UID;
	String upload_time;
	String tag;
	
	public File(int Hash, String name, String kind, String dir, String size, int uploader_UID, String upload_time, String tag) {
		this.Hash = Hash;
		this.name = name;
		this.kind = kind;
		this.dir = dir;
		this.size = size;
		this.uploader_UID = uploader_UID;
		this.upload_time = upload_time;
		this.tag = tag;
	}

    private File(Map<String, String[]> map) {
        this.dir = map.get("upload-file")[0];
        this.tag = map.get("tags")[0];
    }

    // Only for creating file from form
    static File form2File(Map<String, String[]> map) {
        return new File(map);
    }
}
