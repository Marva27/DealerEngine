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
 * Admin User
 */

@Schema(name = "adminUser", description = "Admin User")
@JsonTypeName("adminUser")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public class AdminUser {

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("emailAddress")
  private String emailAddress;

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("password")
  private String password;

  public AdminUser firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the admin user
   * @return firstName
  */
  @NotNull 
  @Schema(name = "firstName", description = "First name of the admin user", required = true)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public AdminUser lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the admin user
   * @return lastName
  */
  @NotNull 
  @Schema(name = "lastName", description = "Last name of the admin user", required = true)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public AdminUser emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Email address of the admin user
   * @return emailAddress
  */
  @NotNull 
  @Schema(name = "emailAddress", description = "Email address of the admin user", required = true)
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public AdminUser userName(String userName) {
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

  public AdminUser password(String password) {
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
    AdminUser adminUser = (AdminUser) o;
    return Objects.equals(this.firstName, adminUser.firstName) &&
        Objects.equals(this.lastName, adminUser.lastName) &&
        Objects.equals(this.emailAddress, adminUser.emailAddress) &&
        Objects.equals(this.userName, adminUser.userName) &&
        Objects.equals(this.password, adminUser.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailAddress, userName, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminUser {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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

