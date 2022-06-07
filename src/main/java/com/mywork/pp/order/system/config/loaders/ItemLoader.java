package com.mywork.pp.order.system.config.loaders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywork.pp.order.system.objects.Item;

/**
 * 
 * @author Pramod Patwa
 * Class will be responsible to load pre-configured items
 */
public class ItemLoader {
	/**
	 * pre configured item map
	 */
	private static Map<String, Item> itemMap = new HashMap<String, Item>();

	/**
	 * Lazy loader class, will make sure to load file only once
	 */
	private static class InstanceHolder {
		public static ItemLoader instance = new ItemLoader();
	}
	
	/**
	 * Declare constructor as private to make singletone
	 * Load items on initialization
	 */
	private ItemLoader() {
		loadItems();
	}
	
	/**
	 * Method will be used to get instance of item loader class 
	 * @return Intance of item loader
	 */
	public static ItemLoader getInstance() {
		return InstanceHolder.instance;
	}

	/**
	 * Method should be used to get item detail using item code.
	 * @param itemCode will take item code as input 
	 * @return Item if found in pre-configured offer list else will return null
	 */
	public Item getItem(String itemCode) {		
		return itemMap.get(itemCode);
	}

	/**
	 * Method will be responsible to load pre-configured items from items.json file
	 * located at conf directory.
	 * Method will prepare map of items that will be used by program to perform order logic
	 */
	private void loadItems() {

		try {
			String rootDir = System.getProperty("user.dir");

			byte[] itemSource = Files.readAllBytes(Paths.get(rootDir + "/conf/items.json"));

			ObjectMapper objectMapper = new ObjectMapper();
			itemMap = objectMapper.readValue(itemSource, new TypeReference<HashMap<String, Item>>() {
			});
			
			System.out.println("Preconfigured Items are: "+ itemMap );
			
		} catch (Exception ex) {
			System.out.print("Error while loading item file: " + ex.toString());
			throw new RuntimeException("Error while loading item file please make "
					+ "sure that item.json file is placed in conf directory and in valid json format");
		}
	}

}
