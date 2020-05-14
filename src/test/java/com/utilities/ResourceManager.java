package com.utilities;

public class ResourceManager {

	public String LOG4J_PATH;
	public String CONFIGURATION_PATH;
	public String DATASET_SPREADSHEET_PATH;

	public ResourceManager() {
		LOG4J_PATH = this.getClass().getClassLoader().getResource("log4j.xml").getPath();

		CONFIGURATION_PATH = this.getClass().getClassLoader().getResource("configuration.properties").getPath();
		
		DATASET_SPREADSHEET_PATH = this.getClass().getClassLoader().getResource("TestData.xlsx").getPath();

	}

	public String getLOG4J_PATH() {
		return LOG4J_PATH;
	}

	public String getCONFIGURATION_PATH() {
		return CONFIGURATION_PATH;
	}
	
	public String getDATASET_SPREADSHEET_PATH() {
		return DATASET_SPREADSHEET_PATH;
	}
	
}
