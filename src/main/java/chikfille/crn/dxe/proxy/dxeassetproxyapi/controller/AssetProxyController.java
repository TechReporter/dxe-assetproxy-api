package chikfille.crn.dxe.proxy.dxeassetproxyapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import chikfille.crn.dxe.proxy.dxeassetproxyapi.service.DxeAssetProxyService;

@RestController
@RequestMapping(value="asset")
public class AssetProxyController {


	@Autowired
	private DxeAssetProxyService dxeAssetProxyService;

	@GetMapping(value="/contents/{assetType}")
	public ResponseEntity<JsonNode> allSpaceRecord(@PathVariable(value="assetType") String assetType) {
		return new ResponseEntity<>(dxeAssetProxyService.allSpaceRecord(assetType), HttpStatus.OK) ;
	}

	@GetMapping(value="/content/{assetType}/{itemId}")
	public ResponseEntity<JsonNode> singleSpaceRecord(@PathVariable("assetType") String assetType,
													@PathVariable("itemId") String itemId) {
		return new ResponseEntity<>(dxeAssetProxyService.singleSpacRecord(assetType, itemId), HttpStatus.OK) ;
	}
	
	@GetMapping(value="/itemTag/{assetType}/{contentType}")
	public ResponseEntity<JsonNode> recordByContentType(@PathVariable(value="assetType") String assetType,
													@PathVariable(value="contentType") String contentType) {
		return new ResponseEntity<>(dxeAssetProxyService.recordByContentType(assetType,contentType), HttpStatus.OK) ;
	}
	
	@GetMapping(value="/countryImage/{assetType}/{itemId}/{countryType}")
	public ResponseEntity<JsonNode> recordByCountryType(@PathVariable(value="itemId") String itemId,
													@PathVariable(value="assetType") String assetType,
													@PathVariable(value="countryType") String coountryType) {
		return new ResponseEntity<>(dxeAssetProxyService.recordByCountryType(itemId,assetType,coountryType), HttpStatus.OK) ;
	}
}
