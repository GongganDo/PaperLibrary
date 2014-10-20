package net.caucse.paperlibrary;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordDocument {
	private HashMap<String, Integer> words;
	private Date timestamp;
	
	{
		words = new HashMap<String, Integer>(); 
	}
	
	public WordDocument() {
		this.timestamp = null;
	}
	
	public WordDocument(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public WordDocument(String timestamp, DateFormat dateFormat) throws ParseException {
		this.timestamp = dateFormat.parse(timestamp);
	}
	
	public void put(String word) {
		put(word, 1);
	}
	
	public void put(String word, int count) {
		Integer o_count = words.get(word);
		if (o_count == null) {
			words.put(word, count);
		} else {
			words.put(word, count + o_count);
		}
	}
	
	public void put(Map<String, Integer> map) {
		for (String key : map.keySet()) {
			put(key, map.get(key));
		}
	}
	
	public int get(String word) {
		try {
			return words.get(word);
		} catch (NullPointerException e) {
			return 0;
		}
	}
	
	public int size() {
		return words.size();
	}
	
	public Set<String> keySet() {
		return words.keySet();
	}
	
	public boolean containsKey(String word) {
		return words.containsKey(word);
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordDocument [words=").append(words)
				.append(", timestamp=").append(timestamp).append("]");
		return builder.toString();
	}
}
