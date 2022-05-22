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
 * Error
 */

@Schema(name = "error", description = "Error")
@JsonTypeName("error")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-20T16:17:24.620-05:00[America/Chicago]")
public class Error {

  @JsonProperty("id")
  private String id;

  @JsonProperty("message")
  private String message;

  public Error id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id representing the type of an error
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "Unique id representing the type of an error", required = true)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Meaningful message about what went wrong
   * @return message
  */
  @NotNull 
  @Schema(name = "message", description = "Meaningful message about what went wrong", required = true)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.id, error.id) &&
        Objects.equals(this.message, error.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

