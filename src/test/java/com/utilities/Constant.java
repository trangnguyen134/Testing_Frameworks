package com.utilities;

public class Constant {

	public static final String WEB_URL = new PropertyManager().getInstance().getWebUrl();

	public static final String BROWSER = new PropertyManager().getInstance().getWebBrowser();

	public static final String MAXIMIZE_WINDOW = new PropertyManager().getInstance().getMaximizeWindow();

    public static final int IMPLICITLY_WAIT = Integer.parseInt(new PropertyManager().getInstance().getImplicitlyWait());

}
