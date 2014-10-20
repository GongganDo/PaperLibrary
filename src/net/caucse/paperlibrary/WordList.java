package net.caucse.paperlibrary;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WordList implements Iterable<String> {
	
	private ArrayList<String> words;
	private Date timestamp;
	
	{
		words = new ArrayList<String>();
	}
	
	public WordList() {
		this.timestamp = null;
	}
	
	public WordList(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public WordList(String timestamp, DateFormat dateFormat) throws ParseException {
		this.timestamp = dateFormat.parse(timestamp);
	}
	
	public boolean put(String word) {
		return words.add(word);
	}
	
	public String get(int i) {
		return words.get(i);
	}
	
	public int size() {
		return words.size();
	}

	public Iterator<String> iterator() {
		return words.iterator();
	}
	
	public boolean contains(String word) {
		return words.contains(word);
	}
	
	public int count(String word) {
		int c = 0;
		for (String w : words) {
			if (w.equals(word)) ++c;
		}
		return c;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public List<String> subList(int fromIndex, int toIndex) {
		return words.subList(fromIndex, toIndex);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordList [words=").append(words).append(", timestamp=")
				.append(timestamp).append("]");
		return builder.toString();
	}
}
