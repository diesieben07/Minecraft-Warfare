package mcwarfare.common;

import static mcwarfare.common.MinecraftWarfare.conf;
import static mcwarfare.common.MinecraftWarfare.logger;
import static net.minecraftforge.common.Configuration.CATEGORY_GENERAL;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageLoader {

	private static final String DEFAULT_LANGUAGE = "en";
	
	public static void loadLanguages() {
		String language = conf.get(CATEGORY_GENERAL, "language", DEFAULT_LANGUAGE).value;
		InputStream stream = LanguageLoader.class.getResourceAsStream("/mcwarfare/resource/lang/" + language + ".lang");
		if (stream == null) {
			logger.warning("Language " + language + " not found. Using default.");
			stream = LanguageLoader.class.getResourceAsStream("/mcwarfare/resource/lang/" + DEFAULT_LANGUAGE + ".lang");
		}
		
		PropertyReader reader = new PropertyReader(stream);
		try {
			reader.read();
			for (Entry<String, String> entry : reader.getProperties().entrySet()) {
				LanguageRegistry.instance().addStringLocalization(entry.getKey(), entry.getValue());
			}
		} catch (IOException e) {
			logger.warning("Failed to load any language.");
		}
	}
}