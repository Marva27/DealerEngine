package com.dealerengine.www.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dealerId", "dealerName", "dealerAddress", "dealerCity", "dealerState", "dealerZipCode",
		"dealerPhone" })
public class Dealer {

	@Id
	@JsonProperty("dealerId")
	private Integer dealerId;
	@JsonProperty("dealerName")
	private String dealerName;
	@JsonProperty("dealerAddress")
	private String dealerAddress;
	@JsonProperty("dealerCity")
	private String dealerCity;
	@JsonProperty("dealerState")
	private String dealerState;
	@JsonProperty("dealerZipCode")
	private Integer dealerZipCode;
	@JsonProperty("dealerPhone")
	private String dealerPhone;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("dealerId")
	public Integer getDealerId() {
		return dealerId;
	}

	@JsonProperty("dealerId")
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	@JsonProperty("dealerName")
	public String getDealerName() {
		return dealerName;
	}

	@JsonProperty("dealerName")
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	@JsonProperty("dealerAddress")
	public String getDealerAddress() {
		return dealerAddress;
	}

	@JsonProperty("dealerAddress")
	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	@JsonProperty("dealerCity")
	public String getDealerCity() {
		return dealerCity;
	}

	@JsonProperty("dealerCity")
	public void setDealerCity(String dealerCity) {
		this.dealerCity = dealerCity;
	}

	@JsonProperty("dealerState")
	public String getDealerState() {
		return dealerState;
	}

	@JsonProperty("dealerState")
	public void setDealerState(String dealerState) {
		this.dealerState = dealerState;
	}

	@JsonProperty("dealerZipCode")
	public Integer getDealerZipCode() {
		return dealerZipCode;
	}

	@JsonProperty("dealerZipCode")
	public void setDealerZipCode(Integer dealerZipCode) {
		this.dealerZipCode = dealerZipCode;
	}

	@JsonProperty("dealerPhone")
	public String getDealerPhone() {
		return dealerPhone;
	}

	@JsonProperty("dealerPhone")
	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}