package com.spsp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {
	
	public static int getProperties(String mame){
		Properties prop =  new Properties();
		int value = 0 ;
		try {
			InputStream in = Prop.class.getResourceAsStream("page.properties");
			prop.load(in);
			String object = (String) prop.get(mame);
			value = Integer.parseInt(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args) {
		name();
	}
	
	public static void name() {
		Properties properties = new Properties();
		InputStream path = Prop.class.getResourceAsStream("page.properties");
		try {
			properties.load(path);
			System.out.println(properties.get("num"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
