package com.lames.merchant.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {

	public static Object mapToBean(Map map , Class<?> type) {
		BeanInfo beanInfo;
		Object obj = null;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			
			obj = type.newInstance();
			
			if(map == null) {
				return obj;
			}
	        
	        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
	        
	        for(PropertyDescriptor descriptor : descriptors) {
	        	String propName = descriptor.getName();
	        	
	        	if(map.containsKey(propName)) {
	        		Object value = map.get(propName);
	        		if(value != null){
	        			if(value.getClass().isArray() && !descriptor.getPropertyType().isArray()) {
	        				value = Array.get(value, 0);
		        		}
		        		if(descriptor.getPropertyType().isAssignableFrom(value.getClass())) {
			        		descriptor.getWriteMethod().invoke(obj, value);
		        		}
	        		}
	        	}
	        }
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}  
        
		return obj; 
	}
	
	public static Map<String, Object> beanToMap(Object obj){
		Map<String, Object> map = new HashMap<>();
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			
	        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
	        
	        for(PropertyDescriptor descriptor : descriptors) {
	        	String propName = descriptor.getName();
	        	if(!"class".equals(propName)) {
	        		Object value = descriptor.getReadMethod().invoke(obj, new Object[0]);
        			map.put(propName, value);
	        	}
	        }
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	
}
