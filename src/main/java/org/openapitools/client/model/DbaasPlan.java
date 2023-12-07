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
 * Managed Database plan information.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-07T21:22:43.771568343Z[Etc/UTC]")
public class DbaasPlan {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NUMBER_OF_NODES = "number_of_nodes";
  @SerializedName(SERIALIZED_NAME_NUMBER_OF_NODES)
  private Integer numberOfNodes;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_VCPU_COUNT = "vcpu_count";
  @SerializedName(SERIALIZED_NAME_VCPU_COUNT)
  private Integer vcpuCount;

  public static final String SERIALIZED_NAME_RAM = "ram";
  @SerializedName(SERIALIZED_NAME_RAM)
  private Integer ram;

  public static final String SERIALIZED_NAME_DISK = "disk";
  @SerializedName(SERIALIZED_NAME_DISK)
  private Integer disk;

  public static final String SERIALIZED_NAME_MONTHLY_COST = "monthly_cost";
  @SerializedName(SERIALIZED_NAME_MONTHLY_COST)
  private Integer monthlyCost;

  public static final String SERIALIZED_NAME_SUPPORTED_ENGINES = "supported_engines";
  @SerializedName(SERIALIZED_NAME_SUPPORTED_ENGINES)
  private Object supportedEngines;

  public static final String SERIALIZED_NAME_MAX_CONNECTIONS = "max_connections";
  @SerializedName(SERIALIZED_NAME_MAX_CONNECTIONS)
  private Object maxConnections;

  public static final String SERIALIZED_NAME_LOCATIONS = "locations";
  @SerializedName(SERIALIZED_NAME_LOCATIONS)
  private List<String> locations;

  public DbaasPlan() {
  }

  public DbaasPlan id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique ID for the plan.
   * @return id
  **/
  @javax.annotation.Nullable
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public DbaasPlan numberOfNodes(Integer numberOfNodes) {
    this.numberOfNodes = numberOfNodes;
    return this;
  }

   /**
   * The total number of nodes for this plan.
   * @return numberOfNodes
  **/
  @javax.annotation.Nullable
  public Integer getNumberOfNodes() {
    return numberOfNodes;
  }

  public void setNumberOfNodes(Integer numberOfNodes) {
    this.numberOfNodes = numberOfNodes;
  }


  public DbaasPlan type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of plan this is.
   * @return type
  **/
  @javax.annotation.Nullable
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public DbaasPlan vcpuCount(Integer vcpuCount) {
    this.vcpuCount = vcpuCount;
    return this;
  }

   /**
   * Number of vCPUs.
   * @return vcpuCount
  **/
  @javax.annotation.Nullable
  public Integer getVcpuCount() {
    return vcpuCount;
  }

  public void setVcpuCount(Integer vcpuCount) {
    this.vcpuCount = vcpuCount;
  }


  public DbaasPlan ram(Integer ram) {
    this.ram = ram;
    return this;
  }

   /**
   * The amount of RAM in MB.
   * @return ram
  **/
  @javax.annotation.Nullable
  public Integer getRam() {
    return ram;
  }

  public void setRam(Integer ram) {
    this.ram = ram;
  }


  public DbaasPlan disk(Integer disk) {
    this.disk = disk;
    return this;
  }

   /**
   * The size of the disk in GB (excluded for Redis engine types).
   * @return disk
  **/
  @javax.annotation.Nullable
  public Integer getDisk() {
    return disk;
  }

  public void setDisk(Integer disk) {
    this.disk = disk;
  }


  public DbaasPlan monthlyCost(Integer monthlyCost) {
    this.monthlyCost = monthlyCost;
    return this;
  }

   /**
   * The monthly cost of this Managed Database plan.
   * @return monthlyCost
  **/
  @javax.annotation.Nullable
  public Integer getMonthlyCost() {
    return monthlyCost;
  }

  public void setMonthlyCost(Integer monthlyCost) {
    this.monthlyCost = monthlyCost;
  }


  public DbaasPlan supportedEngines(Object supportedEngines) {
    this.supportedEngines = supportedEngines;
    return this;
  }

   /**
   * A list of key/value pairs with database engine types and boolean values.
   * @return supportedEngines
  **/
  @javax.annotation.Nullable
  public Object getSupportedEngines() {
    return supportedEngines;
  }

  public void setSupportedEngines(Object supportedEngines) {
    this.supportedEngines = supportedEngines;
  }


  public DbaasPlan maxConnections(Object maxConnections) {
    this.maxConnections = maxConnections;
    return this;
  }

   /**
   * A list of key/value pairs with database engine types (excluding Redis) and integers of max connection values.
   * @return maxConnections
  **/
  @javax.annotation.Nullable
  public Object getMaxConnections() {
    return maxConnections;
  }

  public void setMaxConnections(Object maxConnections) {
    this.maxConnections = maxConnections;
  }


  public DbaasPlan locations(List<String> locations) {
    this.locations = locations;
    return this;
  }

  public DbaasPlan addLocationsItem(String locationsItem) {
    if (this.locations == null) {
      this.locations = new ArrayList<>();
    }
    this.locations.add(locationsItem);
    return this;
  }

   /**
   * A list of available regions in which this plan is currently available.
   * @return locations
  **/
  @javax.annotation.Nullable
  public List<String> getLocations() {
    return locations;
  }

  public void setLocations(List<String> locations) {
    this.locations = locations;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DbaasPlan dbaasPlan = (DbaasPlan) o;
    return Objects.equals(this.id, dbaasPlan.id) &&
        Objects.equals(this.numberOfNodes, dbaasPlan.numberOfNodes) &&
        Objects.equals(this.type, dbaasPlan.type) &&
        Objects.equals(this.vcpuCount, dbaasPlan.vcpuCount) &&
        Objects.equals(this.ram, dbaasPlan.ram) &&
        Objects.equals(this.disk, dbaasPlan.disk) &&
        Objects.equals(this.monthlyCost, dbaasPlan.monthlyCost) &&
        Objects.equals(this.supportedEngines, dbaasPlan.supportedEngines) &&
        Objects.equals(this.maxConnections, dbaasPlan.maxConnections) &&
        Objects.equals(this.locations, dbaasPlan.locations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numberOfNodes, type, vcpuCount, ram, disk, monthlyCost, supportedEngines, maxConnections, locations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DbaasPlan {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numberOfNodes: ").append(toIndentedString(numberOfNodes)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    vcpuCount: ").append(toIndentedString(vcpuCount)).append("\n");
    sb.append("    ram: ").append(toIndentedString(ram)).append("\n");
    sb.append("    disk: ").append(toIndentedString(disk)).append("\n");
    sb.append("    monthlyCost: ").append(toIndentedString(monthlyCost)).append("\n");
    sb.append("    supportedEngines: ").append(toIndentedString(supportedEngines)).append("\n");
    sb.append("    maxConnections: ").append(toIndentedString(maxConnections)).append("\n");
    sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("number_of_nodes");
    openapiFields.add("type");
    openapiFields.add("vcpu_count");
    openapiFields.add("ram");
    openapiFields.add("disk");
    openapiFields.add("monthly_cost");
    openapiFields.add("supported_engines");
    openapiFields.add("max_connections");
    openapiFields.add("locations");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to DbaasPlan
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!DbaasPlan.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DbaasPlan is not found in the empty JSON string", DbaasPlan.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!DbaasPlan.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DbaasPlan` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("locations") != null && !jsonObj.get("locations").isJsonNull() && !jsonObj.get("locations").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `locations` to be an array in the JSON string but got `%s`", jsonObj.get("locations").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DbaasPlan.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DbaasPlan' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DbaasPlan> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DbaasPlan.class));

       return (TypeAdapter<T>) new TypeAdapter<DbaasPlan>() {
           @Override
           public void write(JsonWriter out, DbaasPlan value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DbaasPlan read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DbaasPlan given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DbaasPlan
  * @throws IOException if the JSON string is invalid with respect to DbaasPlan
  */
  public static DbaasPlan fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DbaasPlan.class);
  }

 /**
  * Convert an instance of DbaasPlan to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

