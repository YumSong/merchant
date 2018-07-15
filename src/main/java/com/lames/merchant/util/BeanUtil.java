package com.lames.merchant.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class BeanUtil {

	public static Object beanToMap(Map<String, Object> map , Class<?> type) {
		BeanInfo beanInfo;
		Object obj = null;
		try {
			beanInfo = Introspector.getBeanInfo(type);
			
			obj = type.newInstance();
	        
	        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
	        
	        for(PropertyDescriptor descriptor : descriptors) {
	        	String propName = descriptor.getName();
	        	
	        	if(map.containsKey(propName)) {
	        		descriptor.getWriteMethod().invoke(obj, map.get(propName));
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
}
