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
import org.openapitools.client.model.DatabaseFerretdbCredentials;

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
 * Managed Database information.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-07T21:22:43.771568343Z[Etc/UTC]")
public class Database {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_DATE_CREATED = "date_created";
  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  private String dateCreated;

  public static final String SERIALIZED_NAME_PLAN = "plan";
  @SerializedName(SERIALIZED_NAME_PLAN)
  private String plan;

  public static final String SERIALIZED_NAME_PLAN_DISK = "plan_disk";
  @SerializedName(SERIALIZED_NAME_PLAN_DISK)
  private Integer planDisk;

  public static final String SERIALIZED_NAME_PLAN_RAM = "plan_ram";
  @SerializedName(SERIALIZED_NAME_PLAN_RAM)
  private Integer planRam;

  public static final String SERIALIZED_NAME_PLAN_VCPUS = "plan_vcpus";
  @SerializedName(SERIALIZED_NAME_PLAN_VCPUS)
  private Integer planVcpus;

  public static final String SERIALIZED_NAME_PLAN_REPLICAS = "plan_replicas";
  @SerializedName(SERIALIZED_NAME_PLAN_REPLICAS)
  private Integer planReplicas;

  public static final String SERIALIZED_NAME_REGION = "region";
  @SerializedName(SERIALIZED_NAME_REGION)
  private String region;

  public static final String SERIALIZED_NAME_DATABASE_ENGINE = "database_engine";
  @SerializedName(SERIALIZED_NAME_DATABASE_ENGINE)
  private String databaseEngine;

  public static final String SERIALIZED_NAME_DATABASE_ENGINE_VERSION = "database_engine_version";
  @SerializedName(SERIALIZED_NAME_DATABASE_ENGINE_VERSION)
  private String databaseEngineVersion;

  public static final String SERIALIZED_NAME_VPC_ID = "vpc_id";
  @SerializedName(SERIALIZED_NAME_VPC_ID)
  private String vpcId;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_TAG = "tag";
  @SerializedName(SERIALIZED_NAME_TAG)
  private String tag;

  public static final String SERIALIZED_NAME_DBNAME = "dbname";
  @SerializedName(SERIALIZED_NAME_DBNAME)
  private String dbname;

  public static final String SERIALIZED_NAME_FERRETDB_CREDENTIALS = "ferretdb_credentials";
  @SerializedName(SERIALIZED_NAME_FERRETDB_CREDENTIALS)
  private DatabaseFerretdbCredentials ferretdbCredentials;

  public static final String SERIALIZED_NAME_HOST = "host";
  @SerializedName(SERIALIZED_NAME_HOST)
  private String host;

  public static final String SERIALIZED_NAME_PUBLIC_HOST = "public_host";
  @SerializedName(SERIALIZED_NAME_PUBLIC_HOST)
  private String publicHost;

  public static final String SERIALIZED_NAME_USER = "user";
  @SerializedName(SERIALIZED_NAME_USER)
  private String user;

  public static final String SERIALIZED_NAME_PASSWORD = "password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;

  public static final String SERIALIZED_NAME_PORT = "port";
  @SerializedName(SERIALIZED_NAME_PORT)
  private String port;

  public static final String SERIALIZED_NAME_MAINTENANCE_DOW = "maintenance_dow";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_DOW)
  private String maintenanceDow;

  public static final String SERIALIZED_NAME_MAINTENANCE_TIME = "maintenance_time";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_TIME)
  private String maintenanceTime;

  public static final String SERIALIZED_NAME_LATEST_BACKUP = "latest_backup";
  @SerializedName(SERIALIZED_NAME_LATEST_BACKUP)
  private String latestBackup;

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

  public static final String SERIALIZED_NAME_PG_AVAILABLE_EXTENSIONS = "pg_available_extensions";
  @SerializedName(SERIALIZED_NAME_PG_AVAILABLE_EXTENSIONS)
  private List<Object> pgAvailableExtensions;

  public static final String SERIALIZED_NAME_REDIS_EVICTION_POLICY = "redis_eviction_policy";
  @SerializedName(SERIALIZED_NAME_REDIS_EVICTION_POLICY)
  private String redisEvictionPolicy;

  public static final String SERIALIZED_NAME_CLUSTER_TIME_ZONE = "cluster_time_zone";
  @SerializedName(SERIALIZED_NAME_CLUSTER_TIME_ZONE)
  private String clusterTimeZone;

  public static final String SERIALIZED_NAME_READ_REPLICAS = "read_replicas";
  @SerializedName(SERIALIZED_NAME_READ_REPLICAS)
  private List<Object> readReplicas;

  public Database() {
  }

  public Database id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique ID for the Managed Database.
   * @return id
  **/
  @javax.annotation.Nullable
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Database dateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

   /**
   * The date this database was created.
   * @return dateCreated
  **/
  @javax.annotation.Nullable
  public String getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(String dateCreated) {
    this.dateCreated = dateCreated;
  }


  public Database plan(String plan) {
    this.plan = plan;
    return this;
  }

   /**
   * The name of the Managed Database plan.
   * @return plan
  **/
  @javax.annotation.Nullable
  public String getPlan() {
    return plan;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }


  public Database planDisk(Integer planDisk) {
    this.planDisk = planDisk;
    return this;
  }

   /**
   * The size of the disk in GB (excluded for Redis engine types).
   * @return planDisk
  **/
  @javax.annotation.Nullable
  public Integer getPlanDisk() {
    return planDisk;
  }

  public void setPlanDisk(Integer planDisk) {
    this.planDisk = planDisk;
  }


  public Database planRam(Integer planRam) {
    this.planRam = planRam;
    return this;
  }

   /**
   * The amount of RAM in MB.
   * @return planRam
  **/
  @javax.annotation.Nullable
  public Integer getPlanRam() {
    return planRam;
  }

  public void setPlanRam(Integer planRam) {
    this.planRam = planRam;
  }


  public Database planVcpus(Integer planVcpus) {
    this.planVcpus = planVcpus;
    return this;
  }

   /**
   * Number of vCPUs.
   * @return planVcpus
  **/
  @javax.annotation.Nullable
  public Integer getPlanVcpus() {
    return planVcpus;
  }

  public void setPlanVcpus(Integer planVcpus) {
    this.planVcpus = planVcpus;
  }


  public Database planReplicas(Integer planReplicas) {
    this.planReplicas = planReplicas;
    return this;
  }

   /**
   * Number of replica nodes.
   * @return planReplicas
  **/
  @javax.annotation.Nullable
  public Integer getPlanReplicas() {
    return planReplicas;
  }

  public void setPlanReplicas(Integer planReplicas) {
    this.planReplicas = planReplicas;
  }


  public Database region(String region) {
    this.region = region;
    return this;
  }

   /**
   * The [Region id](#operation/list-regions) where the Managed Database is located.
   * @return region
  **/
  @javax.annotation.Nullable
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


  public Database databaseEngine(String databaseEngine) {
    this.databaseEngine = databaseEngine;
    return this;
  }

   /**
   * The database engine type (MySQL, PostgreSQL, FerretDB + PostgreSQL, Redis).
   * @return databaseEngine
  **/
  @javax.annotation.Nullable
  public String getDatabaseEngine() {
    return databaseEngine;
  }

  public void setDatabaseEngine(String databaseEngine) {
    this.databaseEngine = databaseEngine;
  }


  public Database databaseEngineVersion(String databaseEngineVersion) {
    this.databaseEngineVersion = databaseEngineVersion;
    return this;
  }

   /**
   * The version number of the database engine in use.
   * @return databaseEngineVersion
  **/
  @javax.annotation.Nullable
  public String getDatabaseEngineVersion() {
    return databaseEngineVersion;
  }

  public void setDatabaseEngineVersion(String databaseEngineVersion) {
    this.databaseEngineVersion = databaseEngineVersion;
  }


  public Database vpcId(String vpcId) {
    this.vpcId = vpcId;
    return this;
  }

   /**
   * The ID of the [VPC Network](#operation/get-vpc) attached to the Managed Database.
   * @return vpcId
  **/
  @javax.annotation.Nullable
  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(String vpcId) {
    this.vpcId = vpcId;
  }


  public Database status(String status) {
    this.status = status;
    return this;
  }

   /**
   * The current status.  * Rebuilding * Rebalancing * Running
   * @return status
  **/
  @javax.annotation.Nullable
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Database label(String label) {
    this.label = label;
    return this;
  }

   /**
   * The user-supplied label for this managed database.
   * @return label
  **/
  @javax.annotation.Nullable
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public Database tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * The user-supplied tag for this managed database.
   * @return tag
  **/
  @javax.annotation.Nullable
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  public Database dbname(String dbname) {
    this.dbname = dbname;
    return this;
  }

   /**
   * The default database name.
   * @return dbname
  **/
  @javax.annotation.Nullable
  public String getDbname() {
    return dbname;
  }

  public void setDbname(String dbname) {
    this.dbname = dbname;
  }


  public Database ferretdbCredentials(DatabaseFerretdbCredentials ferretdbCredentials) {
    this.ferretdbCredentials = ferretdbCredentials;
    return this;
  }

   /**
   * Get ferretdbCredentials
   * @return ferretdbCredentials
  **/
  @javax.annotation.Nullable
  public DatabaseFerretdbCredentials getFerretdbCredentials() {
    return ferretdbCredentials;
  }

  public void setFerretdbCredentials(DatabaseFerretdbCredentials ferretdbCredentials) {
    this.ferretdbCredentials = ferretdbCredentials;
  }


  public Database host(String host) {
    this.host = host;
    return this;
  }

   /**
   * The public hostname for database connections, or private hostname if this managed database is attached to a VPC network.
   * @return host
  **/
  @javax.annotation.Nullable
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }


  public Database publicHost(String publicHost) {
    this.publicHost = publicHost;
    return this;
  }

   /**
   * The public hostname for database connections. Only visible when the managed database is attached to a VPC network.
   * @return publicHost
  **/
  @javax.annotation.Nullable
  public String getPublicHost() {
    return publicHost;
  }

  public void setPublicHost(String publicHost) {
    this.publicHost = publicHost;
  }


  public Database user(String user) {
    this.user = user;
    return this;
  }

   /**
   * The default user configured on creation.
   * @return user
  **/
  @javax.annotation.Nullable
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }


  public Database password(String password) {
    this.password = password;
    return this;
  }

   /**
   * The default user&#39;s secure password generated on creation.
   * @return password
  **/
  @javax.annotation.Nullable
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Database port(String port) {
    this.port = port;
    return this;
  }

   /**
   * The assigned port for connecting to the Managed Database.
   * @return port
  **/
  @javax.annotation.Nullable
  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }


  public Database maintenanceDow(String maintenanceDow) {
    this.maintenanceDow = maintenanceDow;
    return this;
  }

   /**
   * The chosen date of week for routine maintenance updates.
   * @return maintenanceDow
  **/
  @javax.annotation.Nullable
  public String getMaintenanceDow() {
    return maintenanceDow;
  }

  public void setMaintenanceDow(String maintenanceDow) {
    this.maintenanceDow = maintenanceDow;
  }


  public Database maintenanceTime(String maintenanceTime) {
    this.maintenanceTime = maintenanceTime;
    return this;
  }

   /**
   * The chosen hour for routine maintenance updates.
   * @return maintenanceTime
  **/
  @javax.annotation.Nullable
  public String getMaintenanceTime() {
    return maintenanceTime;
  }

  public void setMaintenanceTime(String maintenanceTime) {
    this.maintenanceTime = maintenanceTime;
  }


  public Database latestBackup(String latestBackup) {
    this.latestBackup = latestBackup;
    return this;
  }

   /**
   * The date for the latest backup stored on the Managed Database.
   * @return latestBackup
  **/
  @javax.annotation.Nullable
  public String getLatestBackup() {
    return latestBackup;
  }

  public void setLatestBackup(String latestBackup) {
    this.latestBackup = latestBackup;
  }


  public Database trustedIps(List<String> trustedIps) {
    this.trustedIps = trustedIps;
    return this;
  }

  public Database addTrustedIpsItem(String trustedIpsItem) {
    if (this.trustedIps == null) {
      this.trustedIps = new ArrayList<>();
    }
    this.trustedIps.add(trustedIpsItem);
    return this;
  }

   /**
   * A list of trusted IP addresses for connecting to this Managed Database (in CIDR notation).
   * @return trustedIps
  **/
  @javax.annotation.Nullable
  public List<String> getTrustedIps() {
    return trustedIps;
  }

  public void setTrustedIps(List<String> trustedIps) {
    this.trustedIps = trustedIps;
  }


  public Database mysqlSqlModes(List<String> mysqlSqlModes) {
    this.mysqlSqlModes = mysqlSqlModes;
    return this;
  }

  public Database addMysqlSqlModesItem(String mysqlSqlModesItem) {
    if (this.mysqlSqlModes == null) {
      this.mysqlSqlModes = new ArrayList<>();
    }
    this.mysqlSqlModes.add(mysqlSqlModesItem);
    return this;
  }

   /**
   * A list names of enabled SQL Modes for MySQL engine types only.
   * @return mysqlSqlModes
  **/
  @javax.annotation.Nullable
  public List<String> getMysqlSqlModes() {
    return mysqlSqlModes;
  }

  public void setMysqlSqlModes(List<String> mysqlSqlModes) {
    this.mysqlSqlModes = mysqlSqlModes;
  }


  public Database mysqlRequirePrimaryKey(Boolean mysqlRequirePrimaryKey) {
    this.mysqlRequirePrimaryKey = mysqlRequirePrimaryKey;
    return this;
  }

   /**
   * Configuration value for requiring table primary keys for MySQL engine types only.
   * @return mysqlRequirePrimaryKey
  **/
  @javax.annotation.Nullable
  public Boolean getMysqlRequirePrimaryKey() {
    return mysqlRequirePrimaryKey;
  }

  public void setMysqlRequirePrimaryKey(Boolean mysqlRequirePrimaryKey) {
    this.mysqlRequirePrimaryKey = mysqlRequirePrimaryKey;
  }


  public Database mysqlSlowQueryLog(Boolean mysqlSlowQueryLog) {
    this.mysqlSlowQueryLog = mysqlSlowQueryLog;
    return this;
  }

   /**
   * Configuration value for slow query logging on the Managed Database for MySQL engine types only.
   * @return mysqlSlowQueryLog
  **/
  @javax.annotation.Nullable
  public Boolean getMysqlSlowQueryLog() {
    return mysqlSlowQueryLog;
  }

  public void setMysqlSlowQueryLog(Boolean mysqlSlowQueryLog) {
    this.mysqlSlowQueryLog = mysqlSlowQueryLog;
  }


  public Database mysqlLongQueryTime(Integer mysqlLongQueryTime) {
    this.mysqlLongQueryTime = mysqlLongQueryTime;
    return this;
  }

   /**
   * The number of seconds to denote a slow query when logging is enabled for MySQL engine types only.
   * @return mysqlLongQueryTime
  **/
  @javax.annotation.Nullable
  public Integer getMysqlLongQueryTime() {
    return mysqlLongQueryTime;
  }

  public void setMysqlLongQueryTime(Integer mysqlLongQueryTime) {
    this.mysqlLongQueryTime = mysqlLongQueryTime;
  }


  public Database pgAvailableExtensions(List<Object> pgAvailableExtensions) {
    this.pgAvailableExtensions = pgAvailableExtensions;
    return this;
  }

  public Database addPgAvailableExtensionsItem(Object pgAvailableExtensionsItem) {
    if (this.pgAvailableExtensions == null) {
      this.pgAvailableExtensions = new ArrayList<>();
    }
    this.pgAvailableExtensions.add(pgAvailableExtensionsItem);
    return this;
  }

   /**
   * A list of objects containing names and versions (when applicable) of available extensions for PostgreSQL engine types only.
   * @return pgAvailableExtensions
  **/
  @javax.annotation.Nullable
  public List<Object> getPgAvailableExtensions() {
    return pgAvailableExtensions;
  }

  public void setPgAvailableExtensions(List<Object> pgAvailableExtensions) {
    this.pgAvailableExtensions = pgAvailableExtensions;
  }


  public Database redisEvictionPolicy(String redisEvictionPolicy) {
    this.redisEvictionPolicy = redisEvictionPolicy;
    return this;
  }

   /**
   * The current configured data eviction policy for Redis engine types only.
   * @return redisEvictionPolicy
  **/
  @javax.annotation.Nullable
  public String getRedisEvictionPolicy() {
    return redisEvictionPolicy;
  }

  public void setRedisEvictionPolicy(String redisEvictionPolicy) {
    this.redisEvictionPolicy = redisEvictionPolicy;
  }


  public Database clusterTimeZone(String clusterTimeZone) {
    this.clusterTimeZone = clusterTimeZone;
    return this;
  }

   /**
   * The configured time zone of the Managed Database in TZ database format.
   * @return clusterTimeZone
  **/
  @javax.annotation.Nullable
  public String getClusterTimeZone() {
    return clusterTimeZone;
  }

  public void setClusterTimeZone(String clusterTimeZone) {
    this.clusterTimeZone = clusterTimeZone;
  }


  public Database readReplicas(List<Object> readReplicas) {
    this.readReplicas = readReplicas;
    return this;
  }

  public Database addReadReplicasItem(Object readReplicasItem) {
    if (this.readReplicas == null) {
      this.readReplicas = new ArrayList<>();
    }
    this.readReplicas.add(readReplicasItem);
    return this;
  }

   /**
   * A list of database objects containing details for all attached read-only replica nodes.
   * @return readReplicas
  **/
  @javax.annotation.Nullable
  public List<Object> getReadReplicas() {
    return readReplicas;
  }

  public void setReadReplicas(List<Object> readReplicas) {
    this.readReplicas = readReplicas;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Database database = (Database) o;
    return Objects.equals(this.id, database.id) &&
        Objects.equals(this.dateCreated, database.dateCreated) &&
        Objects.equals(this.plan, database.plan) &&
        Objects.equals(this.planDisk, database.planDisk) &&
        Objects.equals(this.planRam, database.planRam) &&
        Objects.equals(this.planVcpus, database.planVcpus) &&
        Objects.equals(this.planReplicas, database.planReplicas) &&
        Objects.equals(this.region, database.region) &&
        Objects.equals(this.databaseEngine, database.databaseEngine) &&
        Objects.equals(this.databaseEngineVersion, database.databaseEngineVersion) &&
        Objects.equals(this.vpcId, database.vpcId) &&
        Objects.equals(this.status, database.status) &&
        Objects.equals(this.label, database.label) &&
        Objects.equals(this.tag, database.tag) &&
        Objects.equals(this.dbname, database.dbname) &&
        Objects.equals(this.ferretdbCredentials, database.ferretdbCredentials) &&
        Objects.equals(this.host, database.host) &&
        Objects.equals(this.publicHost, database.publicHost) &&
        Objects.equals(this.user, database.user) &&
        Objects.equals(this.password, database.password) &&
        Objects.equals(this.port, database.port) &&
        Objects.equals(this.maintenanceDow, database.maintenanceDow) &&
        Objects.equals(this.maintenanceTime, database.maintenanceTime) &&
        Objects.equals(this.latestBackup, database.latestBackup) &&
        Objects.equals(this.trustedIps, database.trustedIps) &&
        Objects.equals(this.mysqlSqlModes, database.mysqlSqlModes) &&
        Objects.equals(this.mysqlRequirePrimaryKey, database.mysqlRequirePrimaryKey) &&
        Objects.equals(this.mysqlSlowQueryLog, database.mysqlSlowQueryLog) &&
        Objects.equals(this.mysqlLongQueryTime, database.mysqlLongQueryTime) &&
        Objects.equals(this.pgAvailableExtensions, database.pgAvailableExtensions) &&
        Objects.equals(this.redisEvictionPolicy, database.redisEvictionPolicy) &&
        Objects.equals(this.clusterTimeZone, database.clusterTimeZone) &&
        Objects.equals(this.readReplicas, database.readReplicas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dateCreated, plan, planDisk, planRam, planVcpus, planReplicas, region, databaseEngine, databaseEngineVersion, vpcId, status, label, tag, dbname, ferretdbCredentials, host, publicHost, user, password, port, maintenanceDow, maintenanceTime, latestBackup, trustedIps, mysqlSqlModes, mysqlRequirePrimaryKey, mysqlSlowQueryLog, mysqlLongQueryTime, pgAvailableExtensions, redisEvictionPolicy, clusterTimeZone, readReplicas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Database {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    plan: ").append(toIndentedString(plan)).append("\n");
    sb.append("    planDisk: ").append(toIndentedString(planDisk)).append("\n");
    sb.append("    planRam: ").append(toIndentedString(planRam)).append("\n");
    sb.append("    planVcpus: ").append(toIndentedString(planVcpus)).append("\n");
    sb.append("    planReplicas: ").append(toIndentedString(planReplicas)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    databaseEngine: ").append(toIndentedString(databaseEngine)).append("\n");
    sb.append("    databaseEngineVersion: ").append(toIndentedString(databaseEngineVersion)).append("\n");
    sb.append("    vpcId: ").append(toIndentedString(vpcId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    dbname: ").append(toIndentedString(dbname)).append("\n");
    sb.append("    ferretdbCredentials: ").append(toIndentedString(ferretdbCredentials)).append("\n");
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("    publicHost: ").append(toIndentedString(publicHost)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    maintenanceDow: ").append(toIndentedString(maintenanceDow)).append("\n");
    sb.append("    maintenanceTime: ").append(toIndentedString(maintenanceTime)).append("\n");
    sb.append("    latestBackup: ").append(toIndentedString(latestBackup)).append("\n");
    sb.append("    trustedIps: ").append(toIndentedString(trustedIps)).append("\n");
    sb.append("    mysqlSqlModes: ").append(toIndentedString(mysqlSqlModes)).append("\n");
    sb.append("    mysqlRequirePrimaryKey: ").append(toIndentedString(mysqlRequirePrimaryKey)).append("\n");
    sb.append("    mysqlSlowQueryLog: ").append(toIndentedString(mysqlSlowQueryLog)).append("\n");
    sb.append("    mysqlLongQueryTime: ").append(toIndentedString(mysqlLongQueryTime)).append("\n");
    sb.append("    pgAvailableExtensions: ").append(toIndentedString(pgAvailableExtensions)).append("\n");
    sb.append("    redisEvictionPolicy: ").append(toIndentedString(redisEvictionPolicy)).append("\n");
    sb.append("    clusterTimeZone: ").append(toIndentedString(clusterTimeZone)).append("\n");
    sb.append("    readReplicas: ").append(toIndentedString(readReplicas)).append("\n");
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
    openapiFields.add("date_created");
    openapiFields.add("plan");
    openapiFields.add("plan_disk");
    openapiFields.add("plan_ram");
    openapiFields.add("plan_vcpus");
    openapiFields.add("plan_replicas");
    openapiFields.add("region");
    openapiFields.add("database_engine");
    openapiFields.add("database_engine_version");
    openapiFields.add("vpc_id");
    openapiFields.add("status");
    openapiFields.add("label");
    openapiFields.add("tag");
    openapiFields.add("dbname");
    openapiFields.add("ferretdb_credentials");
    openapiFields.add("host");
    openapiFields.add("public_host");
    openapiFields.add("user");
    openapiFields.add("password");
    openapiFields.add("port");
    openapiFields.add("maintenance_dow");
    openapiFields.add("maintenance_time");
    openapiFields.add("latest_backup");
    openapiFields.add("trusted_ips");
    openapiFields.add("mysql_sql_modes");
    openapiFields.add("mysql_require_primary_key");
    openapiFields.add("mysql_slow_query_log");
    openapiFields.add("mysql_long_query_time");
    openapiFields.add("pg_available_extensions");
    openapiFields.add("redis_eviction_policy");
    openapiFields.add("cluster_time_zone");
    openapiFields.add("read_replicas");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to Database
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!Database.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Database is not found in the empty JSON string", Database.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!Database.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `Database` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("date_created") != null && !jsonObj.get("date_created").isJsonNull()) && !jsonObj.get("date_created").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date_created` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date_created").toString()));
      }
      if ((jsonObj.get("plan") != null && !jsonObj.get("plan").isJsonNull()) && !jsonObj.get("plan").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `plan` to be a primitive type in the JSON string but got `%s`", jsonObj.get("plan").toString()));
      }
      if ((jsonObj.get("region") != null && !jsonObj.get("region").isJsonNull()) && !jsonObj.get("region").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `region` to be a primitive type in the JSON string but got `%s`", jsonObj.get("region").toString()));
      }
      if ((jsonObj.get("database_engine") != null && !jsonObj.get("database_engine").isJsonNull()) && !jsonObj.get("database_engine").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `database_engine` to be a primitive type in the JSON string but got `%s`", jsonObj.get("database_engine").toString()));
      }
      if ((jsonObj.get("database_engine_version") != null && !jsonObj.get("database_engine_version").isJsonNull()) && !jsonObj.get("database_engine_version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `database_engine_version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("database_engine_version").toString()));
      }
      if ((jsonObj.get("vpc_id") != null && !jsonObj.get("vpc_id").isJsonNull()) && !jsonObj.get("vpc_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `vpc_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("vpc_id").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      if ((jsonObj.get("label") != null && !jsonObj.get("label").isJsonNull()) && !jsonObj.get("label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("label").toString()));
      }
      if ((jsonObj.get("tag") != null && !jsonObj.get("tag").isJsonNull()) && !jsonObj.get("tag").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tag` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tag").toString()));
      }
      if ((jsonObj.get("dbname") != null && !jsonObj.get("dbname").isJsonNull()) && !jsonObj.get("dbname").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `dbname` to be a primitive type in the JSON string but got `%s`", jsonObj.get("dbname").toString()));
      }
      // validate the optional field `ferretdb_credentials`
      if (jsonObj.get("ferretdb_credentials") != null && !jsonObj.get("ferretdb_credentials").isJsonNull()) {
        DatabaseFerretdbCredentials.validateJsonElement(jsonObj.get("ferretdb_credentials"));
      }
      if ((jsonObj.get("host") != null && !jsonObj.get("host").isJsonNull()) && !jsonObj.get("host").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `host` to be a primitive type in the JSON string but got `%s`", jsonObj.get("host").toString()));
      }
      if ((jsonObj.get("public_host") != null && !jsonObj.get("public_host").isJsonNull()) && !jsonObj.get("public_host").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `public_host` to be a primitive type in the JSON string but got `%s`", jsonObj.get("public_host").toString()));
      }
      if ((jsonObj.get("user") != null && !jsonObj.get("user").isJsonNull()) && !jsonObj.get("user").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user").toString()));
      }
      if ((jsonObj.get("password") != null && !jsonObj.get("password").isJsonNull()) && !jsonObj.get("password").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `password` to be a primitive type in the JSON string but got `%s`", jsonObj.get("password").toString()));
      }
      if ((jsonObj.get("port") != null && !jsonObj.get("port").isJsonNull()) && !jsonObj.get("port").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `port` to be a primitive type in the JSON string but got `%s`", jsonObj.get("port").toString()));
      }
      if ((jsonObj.get("maintenance_dow") != null && !jsonObj.get("maintenance_dow").isJsonNull()) && !jsonObj.get("maintenance_dow").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `maintenance_dow` to be a primitive type in the JSON string but got `%s`", jsonObj.get("maintenance_dow").toString()));
      }
      if ((jsonObj.get("maintenance_time") != null && !jsonObj.get("maintenance_time").isJsonNull()) && !jsonObj.get("maintenance_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `maintenance_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("maintenance_time").toString()));
      }
      if ((jsonObj.get("latest_backup") != null && !jsonObj.get("latest_backup").isJsonNull()) && !jsonObj.get("latest_backup").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `latest_backup` to be a primitive type in the JSON string but got `%s`", jsonObj.get("latest_backup").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("trusted_ips") != null && !jsonObj.get("trusted_ips").isJsonNull() && !jsonObj.get("trusted_ips").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `trusted_ips` to be an array in the JSON string but got `%s`", jsonObj.get("trusted_ips").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("mysql_sql_modes") != null && !jsonObj.get("mysql_sql_modes").isJsonNull() && !jsonObj.get("mysql_sql_modes").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `mysql_sql_modes` to be an array in the JSON string but got `%s`", jsonObj.get("mysql_sql_modes").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("pg_available_extensions") != null && !jsonObj.get("pg_available_extensions").isJsonNull() && !jsonObj.get("pg_available_extensions").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `pg_available_extensions` to be an array in the JSON string but got `%s`", jsonObj.get("pg_available_extensions").toString()));
      }
      if ((jsonObj.get("redis_eviction_policy") != null && !jsonObj.get("redis_eviction_policy").isJsonNull()) && !jsonObj.get("redis_eviction_policy").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `redis_eviction_policy` to be a primitive type in the JSON string but got `%s`", jsonObj.get("redis_eviction_policy").toString()));
      }
      if ((jsonObj.get("cluster_time_zone") != null && !jsonObj.get("cluster_time_zone").isJsonNull()) && !jsonObj.get("cluster_time_zone").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cluster_time_zone` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cluster_time_zone").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("read_replicas") != null && !jsonObj.get("read_replicas").isJsonNull() && !jsonObj.get("read_replicas").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `read_replicas` to be an array in the JSON string but got `%s`", jsonObj.get("read_replicas").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Database.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Database' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Database> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Database.class));

       return (TypeAdapter<T>) new TypeAdapter<Database>() {
           @Override
           public void write(JsonWriter out, Database value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public Database read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of Database given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Database
  * @throws IOException if the JSON string is invalid with respect to Database
  */
  public static Database fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Database.class);
  }

 /**
  * Convert an instance of Database to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

