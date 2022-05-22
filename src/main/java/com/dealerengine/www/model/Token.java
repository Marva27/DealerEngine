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
 * Token
 */

@Schema(name = "token", description = "Token")
@JsonTypeName("token")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public class Token {

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("jwtCode")
  private String jwtCode;

  public Token userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Username of the admin user
   * @return userName
  */
  @NotNull 
  @Schema(name = "userName", description = "Username of the admin user", required = true)
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Token jwtCode(String jwtCode) {
    this.jwtCode = jwtCode;
    return this;
  }

  /**
   * JWT Token
   * @return jwtCode
  */
  @NotNull 
  @Schema(name = "jwtCode", description = "JWT Token", required = true)
  public String getJwtCode() {
    return jwtCode;
  }

  public void setJwtCode(String jwtCode) {
    this.jwtCode = jwtCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Token token = (Token) o;
    return Objects.equals(this.userName, token.userName) &&
        Objects.equals(this.jwtCode, token.jwtCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, jwtCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    jwtCode: ").append(toIndentedString(jwtCode)).append("\n");
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

