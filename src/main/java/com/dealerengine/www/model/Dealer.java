package com.dealerengine.www.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Dealer
 */

@Schema(name = "dealer", description = "Dealer")
@JsonTypeName("dealer")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public class Dealer {

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

  public Dealer dealerId(Integer dealerId) {
    this.dealerId = dealerId;
    return this;
  }

  /**
   * Unique id of the dealer
   * @return dealerId
  */
  @NotNull 
  @Schema(name = "dealerId", description = "Unique id of the dealer", required = true)
  public Integer getDealerId() {
    return dealerId;
  }

  public void setDealerId(Integer dealerId) {
    this.dealerId = dealerId;
  }

  public Dealer dealerName(String dealerName) {
    this.dealerName = dealerName;
    return this;
  }

  /**
   * Name of the dealer
   * @return dealerName
  */
  @NotNull 
  @Schema(name = "dealerName", description = "Name of the dealer", required = true)
  public String getDealerName() {
    return dealerName;
  }

  public void setDealerName(String dealerName) {
    this.dealerName = dealerName;
  }

  public Dealer dealerAddress(String dealerAddress) {
    this.dealerAddress = dealerAddress;
    return this;
  }

  /**
   * Address of the dealer
   * @return dealerAddress
  */
  @NotNull 
  @Schema(name = "dealerAddress", description = "Address of the dealer", required = true)
  public String getDealerAddress() {
    return dealerAddress;
  }

  public void setDealerAddress(String dealerAddress) {
    this.dealerAddress = dealerAddress;
  }

  public Dealer dealerCity(String dealerCity) {
    this.dealerCity = dealerCity;
    return this;
  }

  /**
   * City of the dealer
   * @return dealerCity
  */
  @NotNull 
  @Schema(name = "dealerCity", description = "City of the dealer", required = true)
  public String getDealerCity() {
    return dealerCity;
  }

  public void setDealerCity(String dealerCity) {
    this.dealerCity = dealerCity;
  }

  public Dealer dealerState(String dealerState) {
    this.dealerState = dealerState;
    return this;
  }

  /**
   * State of the dealer
   * @return dealerState
  */
  @NotNull 
  @Schema(name = "dealerState", description = "State of the dealer", required = true)
  public String getDealerState() {
    return dealerState;
  }

  public void setDealerState(String dealerState) {
    this.dealerState = dealerState;
  }

  public Dealer dealerZipCode(Integer dealerZipCode) {
    this.dealerZipCode = dealerZipCode;
    return this;
  }

  /**
   * Zip Code of the dealer
   * @return dealerZipCode
  */
  @NotNull 
  @Schema(name = "dealerZipCode", description = "Zip Code of the dealer", required = true)
  public Integer getDealerZipCode() {
    return dealerZipCode;
  }

  public void setDealerZipCode(Integer dealerZipCode) {
    this.dealerZipCode = dealerZipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dealer dealer = (Dealer) o;
    return Objects.equals(this.dealerId, dealer.dealerId) &&
        Objects.equals(this.dealerName, dealer.dealerName) &&
        Objects.equals(this.dealerAddress, dealer.dealerAddress) &&
        Objects.equals(this.dealerCity, dealer.dealerCity) &&
        Objects.equals(this.dealerState, dealer.dealerState) &&
        Objects.equals(this.dealerZipCode, dealer.dealerZipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dealerId, dealerName, dealerAddress, dealerCity, dealerState, dealerZipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dealer {\n");
    sb.append("    dealerId: ").append(toIndentedString(dealerId)).append("\n");
    sb.append("    dealerName: ").append(toIndentedString(dealerName)).append("\n");
    sb.append("    dealerAddress: ").append(toIndentedString(dealerAddress)).append("\n");
    sb.append("    dealerCity: ").append(toIndentedString(dealerCity)).append("\n");
    sb.append("    dealerState: ").append(toIndentedString(dealerState)).append("\n");
    sb.append("    dealerZipCode: ").append(toIndentedString(dealerZipCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

