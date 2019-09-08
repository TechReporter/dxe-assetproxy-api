package chikfille.crn.dxe.proxy.dxeassetproxyapi.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import chikfille.crn.dxe.proxy.dxeassetproxyapi.cofiguration.ResourceConfig;

@Component(value="DxeAssetProxyServiceImpl")
public class DxeAssetProxyServiceImpl implements DxeAssetProxyService {

	private static final Logger LOG = LoggerFactory.getLogger(DxeAssetProxyServiceImpl.class);

	@Autowired
	ResourceConfig resourceConfig;

	@Autowired
	RestTemplate restTemplate;

	static final String ACCESS_TOKEN="?access_token=";
	static final String CONTENT_TYPE="&content_type=";
	static final String LOCALE="&locale=";


	@Override
	public JsonNode allSpaceRecord(String assetType) {
		JsonNode jsonNode = null;
		String assetUrl = resourceConfig.getContentulBaseUrl().concat("/")
				.concat(assetType).concat(ACCESS_TOKEN).concat(resourceConfig.getAccessToken());
		String assetResponse = restTemplate.getForObject(assetUrl, String.class);
		if(!assetResponse.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				jsonNode = mapper.readTree(assetResponse);
				return jsonNode;
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}
		return null;
	}


	@Override
	public JsonNode singleSpacRecord(String assetType, String itemId) {
		JsonNode jsonNode = null;
		String assetUrl = resourceConfig.getContentulBaseUrl().concat("/")
				.concat(assetType).concat("/")
				.concat(itemId).concat(ACCESS_TOKEN).concat(resourceConfig.getAccessToken());
		String assetResponse = restTemplate.getForObject(assetUrl, String.class);
		if(!assetResponse.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				jsonNode = mapper.readTree(assetResponse);
				return jsonNode;
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public JsonNode recordByContentType(String assetType, String contentType) {
		JsonNode jsonNode = null;
		String assetUrl = resourceConfig.getContentulBaseUrl().concat("/")
				.concat(assetType).concat(ACCESS_TOKEN).concat(resourceConfig.getAccessToken())
				.concat(CONTENT_TYPE).concat(contentType);
		String assetResponse = restTemplate.getForObject(assetUrl, String.class);
		if(!assetResponse.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				jsonNode = mapper.readTree(assetResponse);
				return jsonNode;
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}
		return null;
	}


	@Override
	public JsonNode recordByCountryType(String itemId, String assetType, String countryType) {
		JsonNode jsonNode = null;
		String assetUrl = resourceConfig.getContentulBaseUrl().concat("/")
				.concat(assetType).concat("/")
				.concat(itemId).concat(ACCESS_TOKEN).concat(resourceConfig.getAccessToken())
				.concat(LOCALE).concat(countryType);
		String assetResponse = restTemplate.getForObject(assetUrl, String.class);
		if(!assetResponse.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				jsonNode = mapper.readTree(assetResponse);
				return jsonNode;
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}
		return null;
	}

}
