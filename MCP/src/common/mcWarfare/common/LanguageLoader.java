package mcWarfare.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageLoader {
	public static void loadLanguages(InputStream stream, LanguageRegistry registry) {
		InputStreamReader inReader = new InputStreamReader(stream);		
		BufferedReader reader = new BufferedReader(inReader);
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				if (!line.startsWith("#")) {
					int colonIndex = line.indexOf(':');
					if (colonIndex > 0) {
						String key = line.substring(0, colonIndex);
						String value = line.substring(colonIndex + 1);
						registry.addStringLocalization(key, value);
					}
				}
			}
		} catch (IOException e) {
			// hmmm
		}
	}
}
