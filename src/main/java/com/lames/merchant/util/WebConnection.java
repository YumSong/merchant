package com.lames.merchant.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Part;

public class WebConnection {
	
	private static final String MUTIPART= "multipart/form-data";
	private static final String STANDARD_FORM_DATA = "application/x-www-form-urlencoded";
	
	private String url;
	private Map<String, String> headers = new HashMap<>();
	private Map<String, Part> files = new HashMap<>();
	private Map<String, String> parameters = new HashMap<>(); 
	
	public WebConnection(String url) {
		if(url.startsWith("http")) {
			this.url = url;
		}else {
			this.url = "http://" + url;
		}
	}
	
	public void setHeader(String key, String value) {
		headers.put(key.toLowerCase(), value);
	}
	
	public void addFile(String name,Part file) {
		files.put(name,file);
	}
	
	public void setParameter(String key,String value) {
		parameters.put(key, value);
	}
	
	public String getParameter(String key) {
		return parameters.get(key);
	}
	
	public String get() throws IOException {
		URL ur = new URL(url);
		URLConnection conn = ur.openConnection();
		return inputStreamToString(conn.getInputStream());
	}
	
	public String post() throws IOException {
		URL ur = new URL(url);
		HttpURLConnection conn = (HttpURLConnection)ur.openConnection();
		conn.setDoOutput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Connection", "Keep-Alive");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setUseCaches(false);
		Set<Entry<String,String>> entries = headers.entrySet();
		for(Entry<String, String> entry : entries){
			conn.setRequestProperty(entry.getKey(), entry.getValue());
		}
		String contentType = headers.get("content-type");
		if(contentType != null) {
			if(contentType.startsWith(MUTIPART) && files.size() > 0) {
				uploadFile(conn);
			}else if(contentType.startsWith(STANDARD_FORM_DATA) && parameters.size() > 0) {
				outputParams(conn);
			}
		}
		System.out.println(conn.getResponseCode());
		return inputStreamToString(conn.getInputStream());
	}
	
	private String inputStreamToString(InputStream is) throws IOException {
		byte[] buf = new byte[1024];
		int len = 0;
		StringBuilder sb = new StringBuilder();
		while((len = is.read(buf)) != -1) {
			sb.append(new String(buf,0,len));
		}
		return sb.toString();
	}
	
	public void uploadFile(HttpURLConnection conn) throws IOException {
		String boundary = headers.get("content-type");
		boundary = getBoundary(boundary);
		conn.setRequestProperty("content-type", "multipart/form-data; boundary=" + boundary);
		Set<Entry<String,Part>> entries = files.entrySet();

		BufferedOutputStream bos = new BufferedOutputStream(conn.getOutputStream());
		for(Entry<String, Part> entry : entries){
			
			Part part = entry.getValue();
			bos.write(("--" + boundary).getBytes());
			bos.write(("\r\n").getBytes());
			bos.write(("Content-Disposition: form-data; name=\""+entry.getKey()+"\"; filename=\"" + part.getHeader("filename")+ "\"").getBytes());
			bos.write(("\r\n").getBytes());
			bos.write(("Content-Type:" + part.getContentType()).getBytes());
			bos.write(("\r\n\r\n").getBytes());
			
			byte[] buf = new byte[8192];
			InputStream is = part.getInputStream();
			int len = 0;
			while((len = is.read(buf)) != -1) {
				bos.write(buf,0,len);
			}
			bos.write(("\r\n").getBytes());
		}
		bos.write(("--" + boundary + "--").getBytes());
		bos.write(("\r\n").getBytes());
		bos.flush();
	}
	
	private String getBoundary(String str) {
		System.out.println(str);
		int index = str.indexOf(";");
		if(index > 0) {
			String bounudaryKV = str.substring(index + 1).trim();
			index = bounudaryKV.indexOf("=");
			System.out.println(index);
			if(bounudaryKV.startsWith("boundary") && index > 0) {
				return bounudaryKV.substring(index + 1);
			}
		}
		
		return "-----------------------------" + UUID.randomUUID();
	}
	
	private void outputParams(HttpURLConnection conn) throws IOException {
		StringBuilder sb = new StringBuilder();
		Set<Entry<String,String>> entries = parameters.entrySet();
		for(Entry<String, String> entry : entries){
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		BufferedOutputStream bos = new BufferedOutputStream(conn.getOutputStream());
		bos.write(sb.toString().getBytes());
	}
}
