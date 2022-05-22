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
 * SignIn Request
 */

@Schema(name = "signInRequest", description = "SignIn Request")
@JsonTypeName("signInRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public class SignInRequest {

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("password")
  private String password;

  public SignInRequest userName(String userName) {
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

  public SignInRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password of the admin user
   * @return password
  */
  @NotNull 
  @Schema(name = "password", description = "Password of the admin user", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignInRequest signInRequest = (SignInRequest) o;
    return Objects.equals(this.userName, signInRequest.userName) &&
        Objects.equals(this.password, signInRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignInRequest {\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

