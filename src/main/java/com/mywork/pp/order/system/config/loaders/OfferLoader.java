package com.mywork.pp.order.system.config.loaders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mywork.pp.order.system.objects.Offer;
/**
 * 
 * @author Pramod Patwa
 * Class will be responsible to load pre-configured offers
 */
public class OfferLoader {

	/**
	 * Map of pre-configured offer where key will be item code and 
	 * value will be configured offer
	 */
	private static Map<String, Offer> offerMap = new HashMap<String, Offer>();

	/**
	 * Lazy holder class to initialize offer map only single time
	 */
	private static class InstanceHolder {
		private static OfferLoader instance = new OfferLoader();
	}

	/**
	 * constructor will be responsingle to load offer single time
	 */
	private OfferLoader() {
		loadOffers();
	}

	/**
	 * Method will be used to get instance of loader.
	 * @return Instance of OfferLoader
	 */
	public static OfferLoader getInstance() {
		return InstanceHolder.instance;
	}

	/**
	 * Method will be used to get offer for preconfigured offer map.
	 * @param itemCode accept itemcode as key
	 * @return Offer for an item code
	 */
	public Offer getOffer(String itemCode) {		
		return offerMap.get(itemCode);
	}

	/**
	 * Will load pre-configured offers from offers.json localted and conf directory.
	 * Will throw exception if file is not present or not valid offer json file  
	 */
	private void loadOffers() {

		try {
			String rootDir = System.getProperty("user.dir");

			byte[] itemSource = Files.readAllBytes(Paths.get(rootDir + "/conf/offers.json"));

			ObjectMapper objectMapper = new ObjectMapper();
			offerMap = objectMapper.readValue(itemSource, new TypeReference<HashMap<String, Offer>>() {
			});
						
		} catch (Exception ex) {
			System.out.print("Error while loading offer file: " + ex.toString());
			throw new RuntimeException("Error while loading item file please make "
					+ "sure that offers.json file is placed in conf directory and in valid json format");
		}
	}

}
