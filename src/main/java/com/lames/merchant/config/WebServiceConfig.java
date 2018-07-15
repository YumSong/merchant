package com.lames.merchant.config;

import java.util.Properties;


import com.lames.merchant.util.FileUtil;

public class WebServiceConfig implements Config{
	
	private static final String CONFIG_PATH = "webservice/service-server.properties";
	
	private static volatile WebServiceConfig instance = null;
	
	private Properties config;
	
	private WebServiceConfig() {}
	public static WebServiceConfig getConfig() {
		if(instance == null) {
			synchronized(WebServiceConfig.class) {
				init();
			}
		}
		return instance;
	}

	@Override
	public String get(String key) {
		return (String) config.get(key);
	}

	private static void init() {
		instance = new WebServiceConfig();
		instance.config = FileUtil.loadReasource(CONFIG_PATH);
	}
}
