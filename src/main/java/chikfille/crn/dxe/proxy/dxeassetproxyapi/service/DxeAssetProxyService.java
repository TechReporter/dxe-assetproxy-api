package chikfille.crn.dxe.proxy.dxeassetproxyapi.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface DxeAssetProxyService {

	public JsonNode allSpaceRecord(String assetType);
	public JsonNode singleSpacRecord(String assetType, String itemId);
	public JsonNode recordByContentType(String assetType, String contentType);
	public JsonNode recordByCountryType(String itemId, String assetType, String countryType);
}
