package com.endava.moderator.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.endava.moderator.business.order.IOrderCalculator;
import com.endava.moderator.model.order.IOrder;

/**
 * Asigură acces la instrucţiuni.
 */
public class OrderCollectionFactory {
	private static String chargePackageName;
	private static Map<String, IOrderCalculator<IOrder>> orderCalculatorMap  = new TreeMap<>();

	static {
		@SuppressWarnings("rawtypes")
		Class<IOrderCalculator> chargeInstructionClass = IOrderCalculator.class;
		chargePackageName = chargeInstructionClass.getPackage().getName();
	}
	
	/** 
	 * Citeste clasele de tip instructiune (implementeaza interfata "IInstruction") din package-ul in care se contine clasa AbstractChargeInstruction.<br/>
	 * @return instanta de tip Map. Keie - ID-ul instructiunii, valoarea - clasa de tip instructiune.
	 * @throws ServiceException daca apar probleme la instantierea claselor de tip instructiune.
	 */
	public static Map<String, IOrderCalculator<IOrder>> getChargeInstructionMap() throws ServiceException {
		if (EmptyDetector.isNotEmpty(orderCalculatorMap)) {
			return orderCalculatorMap;
		}
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = chargePackageName.replace('.', '/');
		Enumeration<URL> resources;
		try {
			resources = classLoader.getResources(path);
		} catch (IOException e) {
			throw new ServiceException(e);
		}
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class<IOrderCalculator<IOrder>>> classes = new ArrayList<Class<IOrderCalculator<IOrder>>>();
		for (File directory : dirs) {
			classes.addAll(getClasses(directory, chargePackageName));
		}
		for (Class<IOrderCalculator<IOrder>> clazz : classes) {
			try {
				orderCalculatorMap.put(clazz.newInstance().getParameterClass().getName(), clazz.newInstance());
			} catch (InstantiationException e) {
				throw new ServiceException(e);
			} catch (IllegalAccessException e) {
				throw new ServiceException(e);
			}
		}
		return orderCalculatorMap;
	}

	/**
	 * Recursive method used to find all classes in a given directory and sub-directories. 
	 * @param directory The base directory 
	 * @param packageName The package name for classes found inside the base directory 
	 * @return The classes 
	 * @throws ServiceException 
	 */
	@SuppressWarnings("unchecked")
	private static List<Class<IOrderCalculator<IOrder>>> getClasses(File directory, String packageName) throws ServiceException {
		List<Class<IOrderCalculator<IOrder>>> classes = new ArrayList<Class<IOrderCalculator<IOrder>>>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				if (file.getName().contains(".")) {
					continue;
				}
				classes.addAll(getClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				Class<?> clazz;
				try {
					clazz = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
				} catch (ClassNotFoundException e) {
					throw new ServiceException(e);
				}
				if (! clazz.isInterface()) {
					try {
						Object o = clazz.newInstance();
						if (o instanceof IOrderCalculator) {
							classes.add((Class<IOrderCalculator<IOrder>>) clazz);
						}
					} catch(Exception e) {
						// Do noting by design
					}
					
				}
			}
		}
		return classes;
	}
}
