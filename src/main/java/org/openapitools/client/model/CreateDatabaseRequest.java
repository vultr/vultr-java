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
 * CreateDatabaseRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-07T21:22:43.771568343Z[Etc/UTC]")
public class CreateDatabaseRequest {
  public static final String SERIALIZED_NAME_DATABASE_ENGINE = "database_engine";
  @SerializedName(SERIALIZED_NAME_DATABASE_ENGINE)
  private String databaseEngine;

  public static final String SERIALIZED_NAME_DATABASE_ENGINE_VERSION = "database_engine_version";
  @SerializedName(SERIALIZED_NAME_DATABASE_ENGINE_VERSION)
  private String databaseEngineVersion;

  public static final String SERIALIZED_NAME_REGION = "region";
  @SerializedName(SERIALIZED_NAME_REGION)
  private String region;

  public static final String SERIALIZED_NAME_PLAN = "plan";
  @SerializedName(SERIALIZED_NAME_PLAN)
  private String plan;

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_TAG = "tag";
  @SerializedName(SERIALIZED_NAME_TAG)
  private String tag;

  public static final String SERIALIZED_NAME_VPC_ID = "vpc_id";
  @SerializedName(SERIALIZED_NAME_VPC_ID)
  private String vpcId;

  public static final String SERIALIZED_NAME_MAINTENANCE_DOW = "maintenance_dow";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_DOW)
  private String maintenanceDow;

  public static final String SERIALIZED_NAME_MAINTENANCE_TIME = "maintenance_time";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_TIME)
  private String maintenanceTime;

  public static final String SERIALIZED_NAME_TRUSTED_IPS = "trusted_ips";
  @SerializedName(SERIALIZED_NAME_TRUSTED_IPS)
  private List<String> trustedIps;

  public static final String SERIALIZED_NAME_MYSQL_SQL_MODES = "mysql_sql_modes";
  @SerializedName(SERIALIZED_NAME_MYSQL_SQL_MODES)
  private List<String> mysqlSqlModes;

  public static final String SERIALIZED_NAME_MYSQL_REQUIRE_PRIMARY_KEY = "mysql_require_primary_key";
  @SerializedName(SERIALIZED_NAME_MYSQL_REQUIRE_PRIMARY_KEY)
  private Boolean mysqlRequirePrimaryKey;

  public static final String SERIALIZED_NAME_MYSQL_SLOW_QUERY_LOG = "mysql_slow_query_log";
  @SerializedName(SERIALIZED_NAME_MYSQL_SLOW_QUERY_LOG)
  private Boolean mysqlSlowQueryLog;

  public static final String SERIALIZED_NAME_MYSQL_LONG_QUERY_TIME = "mysql_long_query_time";
  @SerializedName(SERIALIZED_NAME_MYSQL_LONG_QUERY_TIME)
  private Integer mysqlLongQueryTime;

  public static final String SERIALIZED_NAME_REDIS_EVICTION_POLICY = "redis_eviction_policy";
  @SerializedName(SERIALIZED_NAME_REDIS_EVICTION_POLICY)
  private String redisEvictionPolicy;

  public CreateDatabaseRequest() {
  }

  public CreateDatabaseRequest databaseEngine(String databaseEngine) {
    this.databaseEngine = databaseEngine;
    return this;
  }

   /**
   * The database engine type for the Managed Database. * &#x60;mysql&#x60; * &#x60;pg&#x60; * &#x60;ferretpg&#x60; * &#x60;redis&#x60;
   * @return databaseEngine
  **/
  @javax.annotation.Nonnull
  public String getDatabaseEngine() {
    return databaseEngine;
  }

  public void setDatabaseEngine(String databaseEngine) {
    this.databaseEngine = databaseEngine;
  }


  public CreateDatabaseRequest databaseEngineVersion(String databaseEngineVersion) {
    this.databaseEngineVersion = databaseEngineVersion;
    return this;
  }

   /**
   * The version of the chosen database engine type for the Managed Database. * MySQL: &#x60;8&#x60; * PostgreSQL: &#x60;12&#x60; - &#x60;15&#x60; * FerretDB + PostgreSQL: &#x60;12&#x60; - &#x60;15&#x60; * Redis: &#x60;7&#x60;
   * @return databaseEngineVersion
  **/
  @javax.annotation.Nonnull
  public String getDatabaseEngineVersion() {
    return databaseEngineVersion;
  }

  public void setDatabaseEngineVersion(String databaseEngineVersion) {
    this.databaseEngineVersion = databaseEngineVersion;
  }


  public CreateDatabaseRequest region(String region) {
    this.region = region;
    return this;
  }

   /**
   * The [Region id](#operation/list-regions) where the Managed Database is located.
   * @return region
  **/
  @javax.annotation.Nonnull
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


  public CreateDatabaseRequest plan(String plan) {
    this.plan = plan;
    return this;
  }

   /**
   * The [Plan id](#operation/list-database-plans) to use when deploying this Managed Database.
   * @return plan
  **/
  @javax.annotation.Nonnull
  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }


  public CreateDatabaseRequest label(String label) {
    this.label = label;
    return this;
  }

   /**
   * A user-supplied label for this Managed Database.
   * @return label
  **/
  @javax.annotation.Nonnull
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public CreateDatabaseRequest tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * The user-supplied tag for this Managed Database.
   * @return tag
  **/
  @javax.annotation.Nullable
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  public CreateDatabaseRequest vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * The [VPC id](#operation/list-vpcs) to use when deploying this Managed Database. It can also be set to &#x60;new&#x60; to configure a new VPC network with this deployment.
   * @return vpcId
  **/
  @javax.annotation.Nullable
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  public CreateDatabaseRequest maintenanceDow(String maintenanceDow) {
    this.maintenanceDow = maintenanceDow;
    return this;
  }

   /**
   * The day of week for routine maintenance updates. * &#x60;monday&#x60; * &#x60;tuesday&#x60; * &#x60;wednesday&#x60; * &#x60;thursday&#x60; * &#x60;friday&#x60; * &#x60;saturday&#x60; * &#x60;sunday&#x60;
   * @return maintenanceDow
  **/
  @javax.annotation.Nullable
  public String getMaintenanceDow() {
    return maintenanceDow;
  }

  public void setMaintenanceDow(String maintenanceDow) {
    this.maintenanceDow = maintenanceDow;
  }


  public CreateDatabaseRequest maintenanceTime(String maintenanceTime) {
    this.maintenanceTime = maintenanceTime;
    return this;
  }

   /**
   * The preferred time (UTC) for routine maintenance updates to occur in 24-hour HH:00 format (e.g. &#x60;01:00&#x60;, &#x60;13:00&#x60;, &#x60;23:00&#x60;, etc.).
   * @return maintenanceTime
  **/
  @javax.annotation.Nullable
  public String getMaintenanceTime() {
    return maintenanceTime;
  }

  public void setMaintenanceTime(String maintenanceTime) {
    this.maintenanceTime = maintenanceTime;
  }


  public CreateDatabaseRequest trustedIps(List<String> trustedIps) {
    this.trustedIps = trustedIps;
    return this;
  }

  public CreateDatabaseRequest addTrustedIpsItem(String trustedIpsItem) {
    if (this.trustedIps == null) {
      this.trustedIps = new ArrayList<>();
    }
    this.trustedIps.add(trustedIpsItem);
    return this;
  }

   /**
   * A list of IP addresses allowed to access the Managed Database in CIDR notation (defaults to /32 if excluded).
   * @return trustedIps
  **/
  @javax.annotation.Nullable
  public List<String> getTrustedIps() {
    return trustedIps;
  }

  public void setTrustedIps(List<String> trustedIps) {
    this.trustedIps = trustedIps;
  }


  public CreateDatabaseRequest mysqlSqlModes(List<String> mysqlSqlModes) {
    this.mysqlSqlModes = mysqlSqlModes;
    return this;
  }

  public CreateDatabaseRequest addMysqlSqlModesItem(String mysqlSqlModesItem) {
    if (this.mysqlSqlModes == null) {
      this.mysqlSqlModes = new ArrayList<>();
    }
    this.mysqlSqlModes.add(mysqlSqlModesItem);
    return this;
  }

   /**
   * A list of SQL modes to enable on the Managed Database (MySQL engine type only). * &#x60;ALLOW_INVALID_DATES&#x60; * &#x60;ANSI&#x60; (Combination Mode) * &#x60;ANSI_QUOTES&#x60; * &#x60;ERROR_FOR_DIVISION_BY_ZERO&#x60; * &#x60;HIGH_NOT_PRECEDENCE&#x60; * &#x60;IGNORE_SPACE&#x60; * &#x60;NO_AUTO_VALUE_ON_ZERO&#x60; * &#x60;NO_DIR_IN_CREATE&#x60; * &#x60;NO_ENGINE_SUBSTITUTION&#x60; * &#x60;NO_UNSIGNED_SUBTRACTION&#x60; * &#x60;NO_ZERO_DATE&#x60; * &#x60;NO_ZERO_IN_DATE&#x60; * &#x60;ONLY_FULL_GROUP_BY&#x60; * &#x60;PIPES_AS_CONCAT&#x60; * &#x60;REAL_AS_FLOAT&#x60; * &#x60;STRICT_ALL_TABLES&#x60; * &#x60;STRICT_TRANS_TABLES&#x60; * &#x60;TIME_TRUNCATE_FRACTIONAL&#x60; * &#x60;TRADITIONAL&#x60; (Combination Mode)
   * @return mysqlSqlModes
  **/
  @javax.annotation.Nullable
  public List<String> getMysqlSqlModes() {
    return mysqlSqlModes;
  }

  public void setMysqlSqlModes(List<String> mysqlSqlModes) {
    this.mysqlSqlModes = mysqlSqlModes;
  }


  public CreateDatabaseRequest mysqlRequirePrimaryKey(Boolean mysqlRequirePrimaryKey) {
    this.mysqlRequirePrimaryKey = mysqlRequirePrimaryKey;
    return this;
  }

   /**
   * Require a primary key for all tables on the Managed Database (MySQL engine type only).
   * @return mysqlRequirePrimaryKey
  **/
  @javax.annotation.Nullable
  public Boolean getMysqlRequirePrimaryKey() {
    return mysqlRequirePrimaryKey;
  }

  public void setMysqlRequirePrimaryKey(Boolean mysqlRequirePrimaryKey) {
    this.mysqlRequirePrimaryKey = mysqlRequirePrimaryKey;
  }


  public CreateDatabaseRequest mysqlSlowQueryLog(Boolean mysqlSlowQueryLog) {
    this.mysqlSlowQueryLog = mysqlSlowQueryLog;
    return this;
  }

   /**
   * Enable or disable slow query logging on the Managed Database (MySQL engine type only).
   * @return mysqlSlowQueryLog
  **/
  @javax.annotation.Nullable
  public Boolean getMysqlSlowQueryLog() {
    return mysqlSlowQueryLog;
  }

  public void setMysqlSlowQueryLog(Boolean mysqlSlowQueryLog) {
    this.mysqlSlowQueryLog = mysqlSlowQueryLog;
  }


  public CreateDatabaseRequest mysqlLongQueryTime(Integer mysqlLongQueryTime) {
    this.mysqlLongQueryTime = mysqlLongQueryTime;
    return this;
  }

   /**
   * The number of seconds to denote a slow query when logging is enabled (MySQL engine type only).
   * @return mysqlLongQueryTime
  **/
  @javax.annotation.Nullable
  public Integer getMysqlLongQueryTime() {
    return mysqlLongQueryTime;
  }

  public void setMysqlLongQueryTime(Integer mysqlLongQueryTime) {
    this.mysqlLongQueryTime = mysqlLongQueryTime;
  }


  public CreateDatabaseRequest redisEvictionPolicy(String redisEvictionPolicy) {
    this.redisEvictionPolicy = redisEvictionPolicy;
    return this;
  }

   /**
   * Set the data eviction policy for the Managed Database (Redis engine type only)
   * @return redisEvictionPolicy
  **/
  @javax.annotation.Nullable
  public String getRedisEvictionPolicy() {
    return redisEvictionPolicy;
  }

  public void setRedisEvictionPolicy(String redisEvictionPolicy) {
    this.redisEvictionPolicy = redisEvictionPolicy;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDatabaseRequest createDatabaseRequest = (CreateDatabaseRequest) o;
    return Objects.equals(this.databaseEngine, createDatabaseRequest.databaseEngine) &&
        Objects.equals(this.databaseEngineVersion, createDatabaseRequest.databaseEngineVersion) &&
        Objects.equals(this.region, createDatabaseRequest.region) &&
        Objects.equals(this.plan, createDatabaseRequest.plan) &&
        Objects.equals(this.label, createDatabaseRequest.label) &&
        Objects.equals(this.tag, createDatabaseRequest.tag) &&
        Objects.equals(this.vpcId, createDatabaseRequest.vpcId) &&
        Objects.equals(this.maintenanceDow, createDatabaseRequest.maintenanceDow) &&
        Objects.equals(this.maintenanceTime, createDatabaseRequest.maintenanceTime) &&
        Objects.equals(this.trustedIps, createDatabaseRequest.trustedIps) &&
        Objects.equals(this.mysqlSqlModes, createDatabaseRequest.mysqlSqlModes) &&
        Objects.equals(this.mysqlRequirePrimaryKey, createDatabaseRequest.mysqlRequirePrimaryKey) &&
        Objects.equals(this.mysqlSlowQueryLog, createDatabaseRequest.mysqlSlowQueryLog) &&
        Objects.equals(this.mysqlLongQueryTime, createDatabaseRequest.mysqlLongQueryTime) &&
        Objects.equals(this.redisEvictionPolicy, createDatabaseRequest.redisEvictionPolicy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(databaseEngine, databaseEngineVersion, region, plan, label, tag, vpcId, maintenanceDow, maintenanceTime, trustedIps, mysqlSqlModes, mysqlRequirePrimaryKey, mysqlSlowQueryLog, mysqlLongQueryTime, redisEvictionPolicy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDatabaseRequest {\n");
    sb.append("    databaseEngine: ").append(toIndentedString(databaseEngine)).append("\n");
    sb.append("    databaseEngineVersion: ").append(toIndentedString(databaseEngineVersion)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    plan: ").append(toIndentedString(plan)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
    sb.append("    maintenanceDow: ").append(toIndentedString(maintenanceDow)).append("\n");
    sb.append("    maintenanceTime: ").append(toIndentedString(maintenanceTime)).append("\n");
    sb.append("    trustedIps: ").append(toIndentedString(trustedIps)).append("\n");
    sb.append("    mysqlSqlModes: ").append(toIndentedString(mysqlSqlModes)).append("\n");
    sb.append("    mysqlRequirePrimaryKey: ").append(toIndentedString(mysqlRequirePrimaryKey)).append("\n");
    sb.append("    mysqlSlowQueryLog: ").append(toIndentedString(mysqlSlowQueryLog)).append("\n");
    sb.append("    mysqlLongQueryTime: ").append(toIndentedString(mysqlLongQueryTime)).append("\n");
    sb.append("    redisEvictionPolicy: ").append(toIndentedString(redisEvictionPolicy)).append("\n");
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
    openapiFields.add("database_engine");
    openapiFields.add("database_engine_version");
    openapiFields.add("region");
    openapiFields.add("plan");
    openapiFields.add("label");
    openapiFields.add("tag");
    openapiFields.add("vpc_id");
    openapiFields.add("maintenance_dow");
    openapiFields.add("maintenance_time");
    openapiFields.add("trusted_ips");
    openapiFields.add("mysql_sql_modes");
    openapiFields.add("mysql_require_primary_key");
    openapiFields.add("mysql_slow_query_log");
    openapiFields.add("mysql_long_query_time");
    openapiFields.add("redis_eviction_policy");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("database_engine");
    openapiRequiredFields.add("database_engine_version");
    openapiRequiredFields.add("region");
    openapiRequiredFields.add("plan");
    openapiRequiredFields.add("label");
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to CreateDatabaseRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!CreateDatabaseRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CreateDatabaseRequest is not found in the empty JSON string", CreateDatabaseRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!CreateDatabaseRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `CreateDatabaseRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CreateDatabaseRequest.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("database_engine").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `database_engine` to be a primitive type in the JSON string but got `%s`", jsonObj.get("database_engine").toString()));
      }
      if (!jsonObj.get("database_engine_version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `database_engine_version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("database_engine_version").toString()));
      }
      if (!jsonObj.get("region").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `region` to be a primitive type in the JSON string but got `%s`", jsonObj.get("region").toString()));
      }
      if (!jsonObj.get("plan").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plan").toString()));
      }
      if (!jsonObj.get("label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("label").toString()));
      }
      if ((jsonObj.get("tag") != null && !jsonObj.get("tag").isJsonNull()) && !jsonObj.get("tag").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tag` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tag").toString()));
      }
      if ((jsonObj.get("vpc_id") != null && !jsonObj.get("vpc_id").isJsonNull()) && !jsonObj.get("vpc_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `vpc_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("vpc_id").toString()));
      }
      if ((jsonObj.get("maintenance_dow") != null && !jsonObj.get("maintenance_dow").isJsonNull()) && !jsonObj.get("maintenance_dow").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `maintenance_dow` to be a primitive type in the JSON string but got `%s`", jsonObj.get("maintenance_dow").toString()));
      }
      if ((jsonObj.get("maintenance_time") != null && !jsonObj.get("maintenance_time").isJsonNull()) && !jsonObj.get("maintenance_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `maintenance_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("maintenance_time").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("trusted_ips") != null && !jsonObj.get("trusted_ips").isJsonNull() && !jsonObj.get("trusted_ips").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `trusted_ips` to be an array in the JSON string but got `%s`", jsonObj.get("trusted_ips").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("mysql_sql_modes") != null && !jsonObj.get("mysql_sql_modes").isJsonNull() && !jsonObj.get("mysql_sql_modes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `mysql_sql_modes` to be an array in the JSON string but got `%s`", jsonObj.get("mysql_sql_modes").toString()));
      }
      if ((jsonObj.get("redis_eviction_policy") != null && !jsonObj.get("redis_eviction_policy").isJsonNull()) && !jsonObj.get("redis_eviction_policy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `redis_eviction_policy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("redis_eviction_policy").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CreateDatabaseRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CreateDatabaseRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CreateDatabaseRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CreateDatabaseRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CreateDatabaseRequest>() {
           @Override
           public void write(JsonWriter out, CreateDatabaseRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public CreateDatabaseRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of CreateDatabaseRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CreateDatabaseRequest
  * @throws IOException if the JSON string is invalid with respect to CreateDatabaseRequest
  */
  public static CreateDatabaseRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CreateDatabaseRequest.class);
  }

 /**
  * Convert an instance of CreateDatabaseRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

