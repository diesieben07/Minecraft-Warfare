package mcwarfare.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PropertyReader {
	
	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	private static final String DEFAULT_SEPARATOR = ":";
	private static final String DEFAULT_COMMENT = "#";
		
	private final Reader reader;
	private boolean hasParsed = false;
	private String separator = DEFAULT_SEPARATOR;
	private String comment = DEFAULT_COMMENT;
	
	private Map<String, String> properties = new HashMap<String, String>();
	
	public PropertyReader(Reader reader) {
		this.reader = reader;
	}
	
	public PropertyReader(InputStream stream, Charset charset) {
		this(new InputStreamReader(stream,  charset));
	}
	
	public PropertyReader(InputStream stream) {
		this(stream, DEFAULT_CHARSET);
	}
	
	public PropertyReader(File file, Charset charset) throws FileNotFoundException {
		this(new FileInputStream(file), charset);
	}
	
	public PropertyReader(File file) throws FileNotFoundException {
		this(file, DEFAULT_CHARSET);
	}
	
	public PropertyReader setSeparator(String separator) {
		this.separator = separator;
		return this;
	}
	
	public PropertyReader setComment(String comment) {
		this.comment = comment;
		return this;
	}
	
	public void read() throws IOException {
		if (hasParsed) {
			throw new IllegalStateException("Already parsed!");
		}
		BufferedReader reader = new BufferedReader(this.reader);
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			int colonIndex = line.indexOf(separator);
			if (colonIndex > 0 && !line.startsWith(comment)) {
				String key = line.substring(0, colonIndex).trim();
				String value = line.substring(colonIndex + comment.length()).trim();
				properties.put(key, value);
			}
		}
		reader.close();
		hasParsed = true;
	}
	
	public Map<String, String> getProperties() {
		return Collections.<String,String>unmodifiableMap(properties);
	}
	
	public Set<Entry<String, String>> getEntrySet() {
		return getProperties().entrySet();
	}
}