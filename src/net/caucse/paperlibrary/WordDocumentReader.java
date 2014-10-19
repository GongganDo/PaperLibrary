package net.caucse.paperlibrary;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class WordDocumentReader {
	private BufferedReader reader;
	private JsonParser parser;
	
	{
		parser = new JsonParser();
	}
	
	public WordDocumentReader(String path) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(path));
	}
	public WordDocumentReader(InputStream is) {
		reader = new BufferedReader(new InputStreamReader(is));
	}
	public WordDocumentReader(String path, Charset cs) throws FileNotFoundException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), cs));
	}
	public WordDocumentReader(InputStream is, Charset cs) {
		reader = new BufferedReader(new InputStreamReader(is, cs));
	}
	
	public WordDocument read() throws IOException {
		String data = reader.readLine();
		if (data == null) return null;
		
		WordDocument wd = new WordDocument();
		JsonElement element = parser.parse(data);
		JsonObject object = element.getAsJsonObject().getAsJsonObject("noun");
		for (Entry<String, JsonElement> entry : object.entrySet()) {
			wd.put(entry.getKey(), entry.getValue().getAsInt());
		}
		return wd;
	}
	
	public void close() throws IOException {
		reader.close();
	}
}
