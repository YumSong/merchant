package com.lames.merchant.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.lames.merchant.config.WebServiceConfig;


public class FileUtil {
	
	public static Properties loadReasource(String path) {
		InputStream is = WebServiceConfig.class.getClassLoader().getResourceAsStream(path);
		
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
