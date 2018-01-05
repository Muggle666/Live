package Live.model;

import java.io.Serializable;

public class LiveRedis implements Serializable {

	private static final long serialVersionUID = 1L;

	private String keyName;
	
	private String liveName;
	
	private String userName;
	
	private String content;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getLiveName() {
		return liveName;
	}

	public void setLiveName(String liveName) {
		this.liveName = liveName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
