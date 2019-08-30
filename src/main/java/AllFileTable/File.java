package AllFileTable;

public class File {

	public int getHesh() {
		return Hesh;
	}

	public void setHesh(int hesh) {
		Hesh = hesh;
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

	int Hesh;
	String name;
	String kind;
	String dir;
	String size;
	int uploader_UID;
	String upload_time;
	
	public File(int Hesh, String name, String kind, String dir, String size, int uploader_UID, String upload_time) {
		this.Hesh = Hesh;
		this.name = name;
		this.kind = kind;
		this.dir = dir;
		this.size = size;
		this.uploader_UID = uploader_UID;
		this.upload_time = upload_time;
	}
}
