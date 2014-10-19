package net.caucse.paperlibrary;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Document {
	private String title;
	private String content;
	private Date timestamp;
	
	public Document(String title, String content) {
		this.title = title;
		this.content = content;
		this.timestamp = null;
	}
	
	public Document(String title, String content, Date timestamp) {
		this.title = title;
		this.content = content;
		this.timestamp = timestamp;
	}
	
	public Document(String title, String content, String timestamp, DateFormat dateFormat) throws ParseException {
		this.title = title;
		this.content = content;
		this.timestamp = dateFormat.parse(timestamp);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return title;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [title=").append(title).append(", content=")
				.append(content).append(", timestamp=").append(timestamp)
				.append("]");
		return builder.toString();
	}
}
