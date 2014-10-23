package net.caucse.paperlibrary;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.google.gson.Gson;


public class WordListReader {
	private BufferedReader reader;
	private Gson gson;
	
	{
		gson = new Gson();
	}
	
	public WordListReader(String path) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(path));
	}
	public WordListReader(InputStream is) {
		reader = new BufferedReader(new InputStreamReader(is));
	}
	public WordListReader(String path, Charset cs) throws FileNotFoundException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), cs));
	}
	public WordListReader(InputStream is, Charset cs) {
		reader = new BufferedReader(new InputStreamReader(is, cs));
	}
	
	public WordList read() throws IOException {
		String data = reader.readLine();
		if (data == null) return null;
		
		WordList wl = gson.fromJson(data, WordList.class);
		return wl;
	}
	
	public void close() throws IOException {
		reader.close();
	}
}
