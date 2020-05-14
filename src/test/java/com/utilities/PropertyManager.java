package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager instance;
	private static final Object lock = new Object();
	private static String webBrowser;
	private static String webUrl;
	private static String implicitlyWait;
	private static String maximizeWindow;

	public PropertyManager getInstance() {
		if (instance == null) {
			synchronized (lock) {
				instance = new PropertyManager();
				instance.loadConfiguration();
			}

		}
		return instance;
	}

	// Load configuration file
	public void loadConfiguration() {

		String propertyFilePath = new ResourceManager().getCONFIGURATION_PATH();

		Properties config = new Properties();

		try {
			config.load(new FileInputStream(propertyFilePath));
		} catch (IOException e) {

			System.out.println("Properties file cannot be found");
		}

		// Get all properties from configuration.properties

		webBrowser = config.getProperty("web_browser");
		webUrl = config.getProperty("web_url");
		implicitlyWait = config.getProperty("implicitly_wait_in_seconds");
		maximizeWindow = config.getProperty("maximize_window");
	}

	public String getWebBrowser() {
		return webBrowser;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public String getMaximizeWindow() {
		return maximizeWindow;
	}

	public String getImplicitlyWait() {
		return implicitlyWait;
	}
}
