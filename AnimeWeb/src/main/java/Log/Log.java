package Log;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Log {
	private int id;
	private int level;
	private int userId;
	private String ip;
	private String src;
	private String content;
	private Date creatAt;
	private int status;
	static Map<Integer, String> levelMapping = new HashMap<>();
	static {
		levelMapping.put(0, "INFO");
		levelMapping.put(1, "ALERT");
		levelMapping.put(2, "WARNING");
		levelMapping.put(3, "DANGER");
	}
	public static int INFO = 0;
	public static int ALERT = 1;
	public static int WARNING = 2;
	public static int DANGER = 3;

	public Log() {
	}

	public Log(int level, int userId, String ip, String src, String content, Date creatAt, int status) {
		this.level = level;
		this.src = src;
		this.userId = userId;
		this.content = content;
		this.creatAt = creatAt;
		this.status = status;
		this.ip = ip;
	}

	public Log( int level,int userId,String ip, String src,  String content,int status) {
        this.level = level;
        this.src = src;
        this.userId = userId;
        this.content = content;
        this.status = status;
        this.ip = ip;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
