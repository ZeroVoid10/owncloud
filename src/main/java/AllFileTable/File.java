package AllFileTable;

import java.util.Map;

/**
 * @since 0.1.0 * @author James
 */
public class File {

	public int getHash() {
		return Hash;
	}

	public File setHash(int hash) {
		Hash = hash;
        return this;
	}

	public String getName() {
		return name;
	}

	public File setName(String name) {
		this.name = name;
        return this;
	}

	public String getKind() {
		return kind;
	}

	public File setKind(String kind) {
		this.kind = kind;
        return this;
	}

	public String getDir() {
		return dir;
	}

	public File setDir(String dir) {
		this.dir = dir;
        return this;
	}

	public String getSize() {
		return size;
	}

	public File setSize(String size) {
		this.size = size;
        return this;
	}

	public int getUploader_UID() {
		return uploader_UID;
	}

	public File setUploader_UID(int uploader_UID) {
		this.uploader_UID = uploader_UID;
        return this;
	}

	public String getUpload_time() {
		return upload_time;
	}

	public File setUpload_time(String upload_time) {
		this.upload_time = upload_time;
        return this;
	}

	
	public String getTag() {
		return tag;
	}

	public File setTag(String tag) {
		this.tag = tag;
        return this;
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
        this.name = map.get("upload-file")[0];
        this.tag = map.get("tags")[0];
    }

    private File() {
        super();
    }

    // Only for creating file from form
    public static File form2File(Map<String, String[]> map) {
        return new File(map);
    }

    // Use callfully
    public static File getNewFile() {
        return new File();
    }
}
