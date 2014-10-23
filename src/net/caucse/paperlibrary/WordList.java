package net.caucse.paperlibrary;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gson.annotations.Expose;

public class WordList implements Iterable<List<String>> {
	
	@Expose
	private ArrayList<List<String>> words;
	
	private List<String> currentLine;
	
	@Expose
	private Date timestamp;
	
	{
		words = new ArrayList<List<String>>();
		currentLine = null;
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
		return currentLine.add(word);
	}
	
	public String get(int i) {
		return currentLine.get(i);
	}

	public String get(int lineNum, int wordIndex) {
		return words.get(lineNum).get(wordIndex);
	}
	
	public boolean newLine() {
		currentLine = new ArrayList<String>();
		return words.add(currentLine);
	}
	
	public int lineSize() {
		return words.size();
	}
	
	public int wordSize() {
		int size = 0;
		for (List<String> line : words) {
			size += line.size();
		}
		return size;
	}

	public Iterator<List<String>> iterator() {
		return words.iterator();
	}
	
	public boolean contains(String word) {
		return words.contains(word);
	}
	
	public int count(String word) {
		int c = 0;
		for (List<String> line : words) {
			for (String w : line) {
				if (w.equals(word)) ++c;
			}
		}
		return c;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	/*public List<String> subList(int fromIndex, int toIndex) {
		return words.subList(fromIndex, toIndex);
	}*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WordList [words=").append(words)
				.append(", timestamp=").append(timestamp).append("]");
		return builder.toString();
	}
}
