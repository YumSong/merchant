package com.lames.merchant.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
	
	private String url;
	private Map<String, String> headers = new HashMap<>();
	private Map<String, Part> files = new HashMap<>();
	
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
		if(contentType != null && contentType.startsWith(MUTIPART) && files.size() > 0) {
			uploadFile(conn);
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

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		for(Entry<String, Part> entry : entries){
			
			Part part = entry.getValue();
			bw.write("--" + boundary);
			bw.write("\r\n");
			bw.write("Content-Disposition: form-data; name=\""+entry.getKey()+"\"; filename=\"" + part.getHeader("filename")+ "\"");
			bw.write("\r\n");
			bw.write("Content-Type:" + part.getContentType());
			bw.write("\r\n\r\n");
			
			byte[] buf = new byte[8192];
			InputStream is = part.getInputStream();
			int len = 0;
			while((len = is.read(buf)) != -1) {
				bw.write(new String(buf,0,len));
			}
			bw.write("\r\n");
		}
		bw.write("--" + boundary + "--");
		bw.write("\r\n");
		bw.flush();
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
}
