/*
 * Vultr API
 * # Introduction  The Vultr API v2 is a set of HTTP endpoints that adhere to RESTful design principles and CRUD actions with predictable URIs. It uses standard HTTP response codes, authentication, and verbs. The API has consistent and well-formed JSON requests and responses with cursor-based pagination to simplify list handling. Error messages are descriptive and easy to understand. All functions of the Vultr customer portal are accessible via the API, enabling you to script complex unattended scenarios with any tool fluent in HTTP.  ## Requests  Communicate with the API by making an HTTP request at the correct endpoint. The chosen method determines the action taken.  | Method | Usage | | ------ | ------------- | | DELETE | Use the DELETE method to destroy a resource in your account. If it is not found, the operation will return a 4xx error and an appropriate message. | | GET | To retrieve information about a resource, use the GET method. The data is returned as a JSON object. GET methods are read-only and do not affect any resources. | | PATCH | Some resources support partial modification with PATCH, which modifies specific attributes without updating the entire object representation. | | POST | Issue a POST method to create a new object. Include all needed attributes in the request body encoded as JSON. | | PUT | Use the PUT method to update information about a resource. PUT will set new values on the item without regard to their current values. |  **Rate Limit:** Vultr safeguards the API against bursts of incoming traffic based on the request's IP address to ensure stability for all users. If your application sends more than 30 requests per second, the API may return HTTP status code 429.  ## Response Codes  We use standard HTTP response codes to show the success or failure of requests. Response codes in the 2xx range indicate success, while codes in the 4xx range indicate an error, such as an authorization failure or a malformed request. All 4xx errors will return a JSON response object with an `error` attribute explaining the error. Codes in the 5xx range indicate a server-side problem preventing Vultr from fulfilling your request.  | Response | Description | | ------ | ------------- | | 200 OK | The response contains your requested information. | | 201 Created | Your request was accepted. The resource was created. | | 202 Accepted | Your request was accepted. The resource was created or updated. | | 204 No Content | Your request succeeded, there is no additional information returned. | | 400 Bad Request | Your request was malformed. | | 401 Unauthorized | You did not supply valid authentication credentials. | | 403 Forbidden | You are not allowed to perform that action. | | 404 Not Found | No results were found for your request. | | 429 Too Many Requests | Your request exceeded the API rate limit. | | 500 Internal Server Error | We were unable to perform the request due to server-side problems. |  ## Meta and Pagination  Many API calls will return a `meta` object with paging information.  ### Definitions  | Term | Description | | ------ | ------------- | | **List** | The items returned from the database for your request (not necessarily shown in a single response depending on the **cursor** size). | | **Page** | A subset of the full **list** of items. Choose the size of a **page** with the `per_page` parameter. | | **Total** | The `total` attribute indicates the number of items in the full **list**.| | **Cursor** | Use the `cursor` query parameter to select a next or previous **page**. | | **Next** & **Prev** | Use the `next` and `prev` attributes of the `links` meta object as `cursor` values. |  ### How to use Paging  If your result **list** total exceeds the default **cursor** size (the default depends on the route, but is usually 100 records) or the value defined by the `per_page` query param (when present) the response will be returned to you paginated.  ### Paging Example  > These examples have abbreviated attributes and sample values. Your actual `cursor` values will be encoded alphanumeric strings.  To return a **page** with the first two plans in the List:      curl \"https://api.vultr.com/v2/plans?per_page=2\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  The API returns an object similar to this:      {         \"plans\": [             {                 \"id\": \"vc2-1c-2gb\",                 \"vcpu_count\": 1,                 \"ram\": 2048,                 \"locations\": []             },             {                 \"id\": \"vc2-24c-97gb\",                 \"vcpu_count\": 24,                 \"ram\": 98304,                 \"locations\": []             }         ],         \"meta\": {             \"total\": 19,             \"links\": {                 \"next\": \"WxYzExampleNext\",                 \"prev\": \"WxYzExamplePrev\"             }         }     }  The object contains two plans. The `total` attribute indicates that 19 plans are available in the List. To navigate forward in the **list**, use the `next` value (`WxYzExampleNext` in this example) as your `cursor` query parameter.      curl \"https://api.vultr.com/v2/plans?per_page=2&cursor=WxYzExampleNext\" \\       -X GET       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  Likewise, you can use the example `prev` value `WxYzExamplePrev` to navigate backward.  ## Parameters  You can pass information to the API with three different types of parameters.  ### Path parameters  Some API calls require variable parameters as part of the endpoint path. For example, to retrieve information about a user, supply the `user-id` in the endpoint.      curl \"https://api.vultr.com/v2/users/{user-id}\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  ### Query parameters  Some API calls allow filtering with query parameters. For example, the `/v2/plans` endpoint supports a `type` query parameter. Setting `type=vhf` instructs the API only to return High Frequency Compute plans in the list. You'll find more specifics about valid filters in the endpoint documentation below.      curl \"https://api.vultr.com/v2/plans?type=vhf\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  You can also combine filtering with paging. Use the `per_page` parameter to retreive a subset of vhf plans.      curl \"https://api.vultr.com/v2/plans?type=vhf&per_page=2\" \\       -X GET \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\"  ### Request Body  PUT, POST, and PATCH methods may include an object in the request body with a content type of **application/json**. The documentation for each endpoint below has more information about the expected object.  ## API Example Conventions  The examples in this documentation use `curl`, a command-line HTTP client, to demonstrate useage. Linux and macOS computers usually have curl installed by default, and it's [available for download](https://curl.se/download.html) on all popular platforms including Windows.  Each example is split across multiple lines with the `\\` character, which is compatible with a `bash` terminal. A typical example looks like this:      curl \"https://api.vultr.com/v2/domains\" \\       -X POST \\       -H \"Authorization: Bearer ${VULTR_API_KEY}\" \\       -H \"Content-Type: application/json\" \\       --data '{         \"domain\" : \"example.com\",         \"ip\" : \"192.0.2.123\"       }'  * The `-X` parameter sets the request method. For consistency, we show the method on all examples, even though it's not explicitly required for GET methods. * The `-H` lines set required HTTP headers. These examples are formatted to expand the VULTR\\_API\\_KEY environment variable for your convenience. * Examples that require a JSON object in the request body pass the required data via the `--data` parameter.  All values in this guide are examples. Do not rely on the OS or Plan IDs listed in this guide; use the appropriate endpoint to retreive values before creating resources. 
 *
 * The version of the OpenAPI document: 2.0
 * Contact: support@vultr.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * UpdateBaremetalRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-07T21:22:43.771568343Z[Etc/UTC]")
public class UpdateBaremetalRequest {
  public static final String SERIALIZED_NAME_USER_DATA = "user_data";
  @SerializedName(SERIALIZED_NAME_USER_DATA)
  private String userData;

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_TAG = "tag";
  @Deprecated
  @SerializedName(SERIALIZED_NAME_TAG)
  private String tag;

  public static final String SERIALIZED_NAME_OS_ID = "os_id";
  @SerializedName(SERIALIZED_NAME_OS_ID)
  private Integer osId;

  public static final String SERIALIZED_NAME_APP_ID = "app_id";
  @SerializedName(SERIALIZED_NAME_APP_ID)
  private Integer appId;

  public static final String SERIALIZED_NAME_IMAGE_ID = "image_id";
  @SerializedName(SERIALIZED_NAME_IMAGE_ID)
  private String imageId;

  public static final String SERIALIZED_NAME_ENABLE_IPV6 = "enable_ipv6";
  @SerializedName(SERIALIZED_NAME_ENABLE_IPV6)
  private Boolean enableIpv6;

  public static final String SERIALIZED_NAME_ATTACH_VPC2 = "attach_vpc2";
  @SerializedName(SERIALIZED_NAME_ATTACH_VPC2)
  private List<String> attachVpc2;

  public static final String SERIALIZED_NAME_DETACH_VPC2 = "detach_vpc2";
  @SerializedName(SERIALIZED_NAME_DETACH_VPC2)
  private List<String> detachVpc2;

  public static final String SERIALIZED_NAME_ENABLE_VPC2 = "enable_vpc2";
  @SerializedName(SERIALIZED_NAME_ENABLE_VPC2)
  private Boolean enableVpc2;

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private List<String> tags;

  public static final String SERIALIZED_NAME_USER_SCHEME = "user_scheme";
  @SerializedName(SERIALIZED_NAME_USER_SCHEME)
  private String userScheme;

  public UpdateBaremetalRequest() {
  }

  public UpdateBaremetalRequest userData(String userData) {
    this.userData = userData;
    return this;
  }

   /**
   * The user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) to attach to this instance.
   * @return userData
  **/
  @javax.annotation.Nullable
  public String getUserData() {
    return userData;
  }

  public void setUserData(String userData) {
    this.userData = userData;
  }


  public UpdateBaremetalRequest label(String label) {
    this.label = label;
    return this;
  }

   /**
   * The user-supplied label.
   * @return label
  **/
  @javax.annotation.Nullable
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  @Deprecated
  public UpdateBaremetalRequest tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Use &#x60;tags&#x60; instead. The user-supplied tag.
   * @return tag
   * @deprecated
  **/
  @Deprecated
  @javax.annotation.Nullable
  public String getTag() {
    return tag;
  }

  @Deprecated
  public void setTag(String tag) {
    this.tag = tag;
  }


  public UpdateBaremetalRequest osId(Integer osId) {
    this.osId = osId;
    return this;
  }

   /**
   * If supplied, reinstall the instance using this [Operating System id](#operation/list-os).
   * @return osId
  **/
  @javax.annotation.Nullable
  public Integer getOsId() {
    return osId;
  }

  public void setOsId(Integer osId) {
    this.osId = osId;
  }


  public UpdateBaremetalRequest appId(Integer appId) {
    this.appId = appId;
    return this;
  }

   /**
   * If supplied, reinstall the instance using this [Application id](#operation/list-applications).
   * @return appId
  **/
  @javax.annotation.Nullable
  public Integer getAppId() {
    return appId;
  }

  public void setAppId(Integer appId) {
    this.appId = appId;
  }


  public UpdateBaremetalRequest imageId(String imageId) {
    this.imageId = imageId;
    return this;
  }

   /**
   * If supplied, reinstall the instance using this [Application image_id](#operation/list-applications).
   * @return imageId
  **/
  @javax.annotation.Nullable
  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }


  public UpdateBaremetalRequest enableIpv6(Boolean enableIpv6) {
    this.enableIpv6 = enableIpv6;
    return this;
  }

   /**
   * Enable IPv6.  * true
   * @return enableIpv6
  **/
  @javax.annotation.Nullable
  public Boolean getEnableIpv6() {
    return enableIpv6;
  }

  public void setEnableIpv6(Boolean enableIpv6) {
    this.enableIpv6 = enableIpv6;
  }


  public UpdateBaremetalRequest attachVpc2(List<String> attachVpc2) {
    this.attachVpc2 = attachVpc2;
    return this;
  }

  public UpdateBaremetalRequest addAttachVpc2Item(String attachVpc2Item) {
    if (this.attachVpc2 == null) {
      this.attachVpc2 = new ArrayList<>();
    }
    this.attachVpc2.add(attachVpc2Item);
    return this;
  }

   /**
   * An array of [VPC IDs](#operation/list-vpc2) to attach to this Bare Metal Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;. Please choose one parameter.
   * @return attachVpc2
  **/
  @javax.annotation.Nullable
  public List<String> getAttachVpc2() {
    return attachVpc2;
  }

  public void setAttachVpc2(List<String> attachVpc2) {
    this.attachVpc2 = attachVpc2;
  }


  public UpdateBaremetalRequest detachVpc2(List<String> detachVpc2) {
    this.detachVpc2 = detachVpc2;
    return this;
  }

  public UpdateBaremetalRequest addDetachVpc2Item(String detachVpc2Item) {
    if (this.detachVpc2 == null) {
      this.detachVpc2 = new ArrayList<>();
    }
    this.detachVpc2.add(detachVpc2Item);
    return this;
  }

   /**
   * An array of [VPC IDs](#operation/list-vpc2) to detach from this Bare Metal Instance. This parameter takes precedence over &#x60;enable_vpc2&#x60;.
   * @return detachVpc2
  **/
  @javax.annotation.Nullable
  public List<String> getDetachVpc2() {
    return detachVpc2;
  }

  public void setDetachVpc2(List<String> detachVpc2) {
    this.detachVpc2 = detachVpc2;
  }


  public UpdateBaremetalRequest enableVpc2(Boolean enableVpc2) {
    this.enableVpc2 = enableVpc2;
    return this;
  }

   /**
   * If &#x60;true&#x60;, VPC 2.0 support will be added to the new server.  This parameter attaches a single VPC 2.0 netowrk. When no VPC 2.0 network exists in the region, it will be automatically created.  If there are multiple VPC 2.0 networks in the instance&#39;s region, use &#x60;attach_vpc2&#x60; instead to specify a VPC 2.0 network.
   * @return enableVpc2
  **/
  @javax.annotation.Nullable
  public Boolean getEnableVpc2() {
    return enableVpc2;
  }

  public void setEnableVpc2(Boolean enableVpc2) {
    this.enableVpc2 = enableVpc2;
  }


  public UpdateBaremetalRequest tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public UpdateBaremetalRequest addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Tags to apply to the instance.
   * @return tags
  **/
  @javax.annotation.Nullable
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }


  public UpdateBaremetalRequest userScheme(String userScheme) {
    this.userScheme = userScheme;
    return this;
  }

   /**
   * Linux-only: The user scheme used for logging into this instance. The instance must be reinstalled for this change to take effect.  * root * limited
   * @return userScheme
  **/
  @javax.annotation.Nullable
  public String getUserScheme() {
    return userScheme;
  }

  public void setUserScheme(String userScheme) {
    this.userScheme = userScheme;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBaremetalRequest updateBaremetalRequest = (UpdateBaremetalRequest) o;
    return Objects.equals(this.userData, updateBaremetalRequest.userData) &&
        Objects.equals(this.label, updateBaremetalRequest.label) &&
        Objects.equals(this.tag, updateBaremetalRequest.tag) &&
        Objects.equals(this.osId, updateBaremetalRequest.osId) &&
        Objects.equals(this.appId, updateBaremetalRequest.appId) &&
        Objects.equals(this.imageId, updateBaremetalRequest.imageId) &&
        Objects.equals(this.enableIpv6, updateBaremetalRequest.enableIpv6) &&
        Objects.equals(this.attachVpc2, updateBaremetalRequest.attachVpc2) &&
        Objects.equals(this.detachVpc2, updateBaremetalRequest.detachVpc2) &&
        Objects.equals(this.enableVpc2, updateBaremetalRequest.enableVpc2) &&
        Objects.equals(this.tags, updateBaremetalRequest.tags) &&
        Objects.equals(this.userScheme, updateBaremetalRequest.userScheme);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userData, label, tag, osId, appId, imageId, enableIpv6, attachVpc2, detachVpc2, enableVpc2, tags, userScheme);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBaremetalRequest {\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    osId: ").append(toIndentedString(osId)).append("\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    enableIpv6: ").append(toIndentedString(enableIpv6)).append("\n");
    sb.append("    attachVpc2: ").append(toIndentedString(attachVpc2)).append("\n");
    sb.append("    detachVpc2: ").append(toIndentedString(detachVpc2)).append("\n");
    sb.append("    enableVpc2: ").append(toIndentedString(enableVpc2)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    userScheme: ").append(toIndentedString(userScheme)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("user_data");
    openapiFields.add("label");
    openapiFields.add("tag");
    openapiFields.add("os_id");
    openapiFields.add("app_id");
    openapiFields.add("image_id");
    openapiFields.add("enable_ipv6");
    openapiFields.add("attach_vpc2");
    openapiFields.add("detach_vpc2");
    openapiFields.add("enable_vpc2");
    openapiFields.add("tags");
    openapiFields.add("user_scheme");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateBaremetalRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateBaremetalRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateBaremetalRequest is not found in the empty JSON string", UpdateBaremetalRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateBaremetalRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateBaremetalRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("user_data") != null && !jsonObj.get("user_data").isJsonNull()) && !jsonObj.get("user_data").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_data` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user_data").toString()));
      }
      if ((jsonObj.get("label") != null && !jsonObj.get("label").isJsonNull()) && !jsonObj.get("label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("label").toString()));
      }
      if ((jsonObj.get("tag") != null && !jsonObj.get("tag").isJsonNull()) && !jsonObj.get("tag").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tag` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tag").toString()));
      }
      if ((jsonObj.get("image_id") != null && !jsonObj.get("image_id").isJsonNull()) && !jsonObj.get("image_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `image_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("image_id").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("attach_vpc2") != null && !jsonObj.get("attach_vpc2").isJsonNull() && !jsonObj.get("attach_vpc2").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `attach_vpc2` to be an array in the JSON string but got `%s`", jsonObj.get("attach_vpc2").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("detach_vpc2") != null && !jsonObj.get("detach_vpc2").isJsonNull() && !jsonObj.get("detach_vpc2").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `detach_vpc2` to be an array in the JSON string but got `%s`", jsonObj.get("detach_vpc2").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("tags") != null && !jsonObj.get("tags").isJsonNull() && !jsonObj.get("tags").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `tags` to be an array in the JSON string but got `%s`", jsonObj.get("tags").toString()));
      }
      if ((jsonObj.get("user_scheme") != null && !jsonObj.get("user_scheme").isJsonNull()) && !jsonObj.get("user_scheme").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user_scheme` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user_scheme").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateBaremetalRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateBaremetalRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateBaremetalRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateBaremetalRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateBaremetalRequest>() {
           @Override
           public void write(JsonWriter out, UpdateBaremetalRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateBaremetalRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateBaremetalRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateBaremetalRequest
  * @throws IOException if the JSON string is invalid with respect to UpdateBaremetalRequest
  */
  public static UpdateBaremetalRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateBaremetalRequest.class);
  }

 /**
  * Convert an instance of UpdateBaremetalRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

