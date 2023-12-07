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
import java.util.Arrays;
import org.openapitools.client.model.ModelEnum;

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
 * UpdateAdvancedOptionsRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-12-07T21:22:43.771568343Z[Etc/UTC]")
public class UpdateAdvancedOptionsRequest {
  public static final String SERIALIZED_NAME_AUTOVACUUM_ANALYZE_SCALE_FACTOR = "autovacuum_analyze_scale_factor";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_ANALYZE_SCALE_FACTOR)
  private Float autovacuumAnalyzeScaleFactor = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_ANALYZE_THRESHOLD = "autovacuum_analyze_threshold";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_ANALYZE_THRESHOLD)
  private Integer autovacuumAnalyzeThreshold = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_FREEZE_MAX_AGE = "autovacuum_freeze_max_age";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_FREEZE_MAX_AGE)
  private Integer autovacuumFreezeMaxAge = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_MAX_WORKERS = "autovacuum_max_workers";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_MAX_WORKERS)
  private Integer autovacuumMaxWorkers = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_NAPTIME = "autovacuum_naptime";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_NAPTIME)
  private Integer autovacuumNaptime = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_VACUUM_COST_DELAY = "autovacuum_vacuum_cost_delay";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_VACUUM_COST_DELAY)
  private Integer autovacuumVacuumCostDelay = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_VACUUM_COST_LIMIT = "autovacuum_vacuum_cost_limit";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_VACUUM_COST_LIMIT)
  private Integer autovacuumVacuumCostLimit = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_VACUUM_SCALE_FACTOR = "autovacuum_vacuum_scale_factor";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_VACUUM_SCALE_FACTOR)
  private Float autovacuumVacuumScaleFactor = null;

  public static final String SERIALIZED_NAME_AUTOVACUUM_VACUUM_THRESHOLD = "autovacuum_vacuum_threshold";
  @SerializedName(SERIALIZED_NAME_AUTOVACUUM_VACUUM_THRESHOLD)
  private Integer autovacuumVacuumThreshold = null;

  public static final String SERIALIZED_NAME_BGWRITER_DELAY = "bgwriter_delay";
  @SerializedName(SERIALIZED_NAME_BGWRITER_DELAY)
  private Integer bgwriterDelay = null;

  public static final String SERIALIZED_NAME_BGWRITER_FLUSH_AFTER = "bgwriter_flush_after";
  @SerializedName(SERIALIZED_NAME_BGWRITER_FLUSH_AFTER)
  private Integer bgwriterFlushAfter = null;

  public static final String SERIALIZED_NAME_BGWRITER_LRU_MAXPAGES = "bgwriter_lru_maxpages";
  @SerializedName(SERIALIZED_NAME_BGWRITER_LRU_MAXPAGES)
  private Integer bgwriterLruMaxpages = null;

  public static final String SERIALIZED_NAME_BGWRITER_LRU_MULTIPLIER = "bgwriter_lru_multiplier";
  @SerializedName(SERIALIZED_NAME_BGWRITER_LRU_MULTIPLIER)
  private Float bgwriterLruMultiplier = null;

  public static final String SERIALIZED_NAME_DEADLOCK_TIMEOUT = "deadlock_timeout";
  @SerializedName(SERIALIZED_NAME_DEADLOCK_TIMEOUT)
  private Integer deadlockTimeout = null;

  public static final String SERIALIZED_NAME_DEFAULT_TOAST_COMPRESSION = "default_toast_compression";
  @SerializedName(SERIALIZED_NAME_DEFAULT_TOAST_COMPRESSION)
  private ModelEnum defaultToastCompression = null;

  public static final String SERIALIZED_NAME_IDLE_IN_TRANSACTION_SESSION_TIMEOUT = "idle_in_transaction_session_timeout";
  @SerializedName(SERIALIZED_NAME_IDLE_IN_TRANSACTION_SESSION_TIMEOUT)
  private Integer idleInTransactionSessionTimeout = null;

  public static final String SERIALIZED_NAME_JIT = "jit";
  @SerializedName(SERIALIZED_NAME_JIT)
  private Boolean jit;

  public static final String SERIALIZED_NAME_LOG_AUTOVACUUM_MIN_DURATION = "log_autovacuum_min_duration";
  @SerializedName(SERIALIZED_NAME_LOG_AUTOVACUUM_MIN_DURATION)
  private Integer logAutovacuumMinDuration = null;

  public static final String SERIALIZED_NAME_LOG_ERROR_VERBOSITY = "log_error_verbosity";
  @SerializedName(SERIALIZED_NAME_LOG_ERROR_VERBOSITY)
  private ModelEnum logErrorVerbosity = null;

  public static final String SERIALIZED_NAME_LOG_LINE_PREFIX = "log_line_prefix";
  @SerializedName(SERIALIZED_NAME_LOG_LINE_PREFIX)
  private ModelEnum logLinePrefix = null;

  public static final String SERIALIZED_NAME_LOG_MIN_DURATION_STATEMENT = "log_min_duration_statement";
  @SerializedName(SERIALIZED_NAME_LOG_MIN_DURATION_STATEMENT)
  private Integer logMinDurationStatement = null;

  public static final String SERIALIZED_NAME_MAX_FILES_PER_PROCESS = "max_files_per_process";
  @SerializedName(SERIALIZED_NAME_MAX_FILES_PER_PROCESS)
  private Integer maxFilesPerProcess = null;

  public static final String SERIALIZED_NAME_MAX_LOCKS_PER_TRANSACTION = "max_locks_per_transaction";
  @SerializedName(SERIALIZED_NAME_MAX_LOCKS_PER_TRANSACTION)
  private Integer maxLocksPerTransaction = null;

  public static final String SERIALIZED_NAME_MAX_LOGICAL_REPLICATION_WORKERS = "max_logical_replication_workers";
  @SerializedName(SERIALIZED_NAME_MAX_LOGICAL_REPLICATION_WORKERS)
  private Integer maxLogicalReplicationWorkers = null;

  public static final String SERIALIZED_NAME_MAX_PARALLEL_WORKERS = "max_parallel_workers";
  @SerializedName(SERIALIZED_NAME_MAX_PARALLEL_WORKERS)
  private Integer maxParallelWorkers = null;

  public static final String SERIALIZED_NAME_MAX_PARALLEL_WORKERS_PER_GATHER = "max_parallel_workers_per_gather";
  @SerializedName(SERIALIZED_NAME_MAX_PARALLEL_WORKERS_PER_GATHER)
  private Integer maxParallelWorkersPerGather = null;

  public static final String SERIALIZED_NAME_MAX_PRED_LOCKS_PER_TRANSACTION = "max_pred_locks_per_transaction";
  @SerializedName(SERIALIZED_NAME_MAX_PRED_LOCKS_PER_TRANSACTION)
  private Integer maxPredLocksPerTransaction = null;

  public static final String SERIALIZED_NAME_MAX_PREPARED_TRANSACTIONS = "max_prepared_transactions";
  @SerializedName(SERIALIZED_NAME_MAX_PREPARED_TRANSACTIONS)
  private Integer maxPreparedTransactions = null;

  public static final String SERIALIZED_NAME_MAX_REPLICATION_SLOTS = "max_replication_slots";
  @SerializedName(SERIALIZED_NAME_MAX_REPLICATION_SLOTS)
  private Integer maxReplicationSlots = null;

  public static final String SERIALIZED_NAME_MAX_STACK_DEPTH = "max_stack_depth";
  @SerializedName(SERIALIZED_NAME_MAX_STACK_DEPTH)
  private Integer maxStackDepth = null;

  public static final String SERIALIZED_NAME_MAX_STANDBY_ARCHIVE_DELAY = "max_standby_archive_delay";
  @SerializedName(SERIALIZED_NAME_MAX_STANDBY_ARCHIVE_DELAY)
  private Integer maxStandbyArchiveDelay = null;

  public static final String SERIALIZED_NAME_MAX_STANDBY_STREAMING_DELAY = "max_standby_streaming_delay";
  @SerializedName(SERIALIZED_NAME_MAX_STANDBY_STREAMING_DELAY)
  private Integer maxStandbyStreamingDelay = null;

  public static final String SERIALIZED_NAME_MAX_WAL_SENDERS = "max_wal_senders";
  @SerializedName(SERIALIZED_NAME_MAX_WAL_SENDERS)
  private Integer maxWalSenders = null;

  public static final String SERIALIZED_NAME_MAX_WORKER_PROCESSES = "max_worker_processes";
  @SerializedName(SERIALIZED_NAME_MAX_WORKER_PROCESSES)
  private Integer maxWorkerProcesses = null;

  public static final String SERIALIZED_NAME_PG_PARTMAN_BGW_INTERVAL = "pg_partman_bgw.interval";
  @SerializedName(SERIALIZED_NAME_PG_PARTMAN_BGW_INTERVAL)
  private Integer pgPartmanBgwInterval = null;

  public static final String SERIALIZED_NAME_PG_PARTMAN_BGW_ROLE = "pg_partman_bgw.role";
  @SerializedName(SERIALIZED_NAME_PG_PARTMAN_BGW_ROLE)
  private String pgPartmanBgwRole;

  public static final String SERIALIZED_NAME_PG_STAT_STATEMENTS_TRACK = "pg_stat_statements.track";
  @SerializedName(SERIALIZED_NAME_PG_STAT_STATEMENTS_TRACK)
  private ModelEnum pgStatStatementsTrack = null;

  public static final String SERIALIZED_NAME_TEMP_FILE_LIMIT = "temp_file_limit";
  @SerializedName(SERIALIZED_NAME_TEMP_FILE_LIMIT)
  private Integer tempFileLimit = null;

  public static final String SERIALIZED_NAME_TRACK_ACTIVITY_QUERY_SIZE = "track_activity_query_size";
  @SerializedName(SERIALIZED_NAME_TRACK_ACTIVITY_QUERY_SIZE)
  private Integer trackActivityQuerySize = null;

  public static final String SERIALIZED_NAME_TRACK_COMMIT_TIMESTAMP = "track_commit_timestamp";
  @SerializedName(SERIALIZED_NAME_TRACK_COMMIT_TIMESTAMP)
  private ModelEnum trackCommitTimestamp = null;

  public static final String SERIALIZED_NAME_TRACK_FUNCTIONS = "track_functions";
  @SerializedName(SERIALIZED_NAME_TRACK_FUNCTIONS)
  private ModelEnum trackFunctions = null;

  public static final String SERIALIZED_NAME_TRACK_IO_TIMING = "track_io_timing";
  @SerializedName(SERIALIZED_NAME_TRACK_IO_TIMING)
  private ModelEnum trackIoTiming = null;

  public static final String SERIALIZED_NAME_WAL_SENDER_TIMEOUT = "wal_sender_timeout";
  @SerializedName(SERIALIZED_NAME_WAL_SENDER_TIMEOUT)
  private Integer walSenderTimeout = null;

  public static final String SERIALIZED_NAME_WAL_WRITER_DELAY = "wal_writer_delay";
  @SerializedName(SERIALIZED_NAME_WAL_WRITER_DELAY)
  private Integer walWriterDelay = null;

  public UpdateAdvancedOptionsRequest() {
  }

  public UpdateAdvancedOptionsRequest autovacuumAnalyzeScaleFactor(Float autovacuumAnalyzeScaleFactor) {
    this.autovacuumAnalyzeScaleFactor = autovacuumAnalyzeScaleFactor;
    return this;
  }

   /**
   * Accepted values: 0 - 1
   * @return autovacuumAnalyzeScaleFactor
  **/
  @javax.annotation.Nullable
  public Float getAutovacuumAnalyzeScaleFactor() {
    return autovacuumAnalyzeScaleFactor;
  }

  public void setAutovacuumAnalyzeScaleFactor(Float autovacuumAnalyzeScaleFactor) {
    this.autovacuumAnalyzeScaleFactor = autovacuumAnalyzeScaleFactor;
  }


  public UpdateAdvancedOptionsRequest autovacuumAnalyzeThreshold(Integer autovacuumAnalyzeThreshold) {
    this.autovacuumAnalyzeThreshold = autovacuumAnalyzeThreshold;
    return this;
  }

   /**
   * Accepted values: 0 - 2147483647
   * @return autovacuumAnalyzeThreshold
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumAnalyzeThreshold() {
    return autovacuumAnalyzeThreshold;
  }

  public void setAutovacuumAnalyzeThreshold(Integer autovacuumAnalyzeThreshold) {
    this.autovacuumAnalyzeThreshold = autovacuumAnalyzeThreshold;
  }


  public UpdateAdvancedOptionsRequest autovacuumFreezeMaxAge(Integer autovacuumFreezeMaxAge) {
    this.autovacuumFreezeMaxAge = autovacuumFreezeMaxAge;
    return this;
  }

   /**
   * Accepted values: 200000000 - 1500000000
   * @return autovacuumFreezeMaxAge
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumFreezeMaxAge() {
    return autovacuumFreezeMaxAge;
  }

  public void setAutovacuumFreezeMaxAge(Integer autovacuumFreezeMaxAge) {
    this.autovacuumFreezeMaxAge = autovacuumFreezeMaxAge;
  }


  public UpdateAdvancedOptionsRequest autovacuumMaxWorkers(Integer autovacuumMaxWorkers) {
    this.autovacuumMaxWorkers = autovacuumMaxWorkers;
    return this;
  }

   /**
   * Accepted values: 1 - 20
   * @return autovacuumMaxWorkers
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumMaxWorkers() {
    return autovacuumMaxWorkers;
  }

  public void setAutovacuumMaxWorkers(Integer autovacuumMaxWorkers) {
    this.autovacuumMaxWorkers = autovacuumMaxWorkers;
  }


  public UpdateAdvancedOptionsRequest autovacuumNaptime(Integer autovacuumNaptime) {
    this.autovacuumNaptime = autovacuumNaptime;
    return this;
  }

   /**
   * Accepted values: 1 - 86400
   * @return autovacuumNaptime
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumNaptime() {
    return autovacuumNaptime;
  }

  public void setAutovacuumNaptime(Integer autovacuumNaptime) {
    this.autovacuumNaptime = autovacuumNaptime;
  }


  public UpdateAdvancedOptionsRequest autovacuumVacuumCostDelay(Integer autovacuumVacuumCostDelay) {
    this.autovacuumVacuumCostDelay = autovacuumVacuumCostDelay;
    return this;
  }

   /**
   * Accepted values: -1 - 100
   * @return autovacuumVacuumCostDelay
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumVacuumCostDelay() {
    return autovacuumVacuumCostDelay;
  }

  public void setAutovacuumVacuumCostDelay(Integer autovacuumVacuumCostDelay) {
    this.autovacuumVacuumCostDelay = autovacuumVacuumCostDelay;
  }


  public UpdateAdvancedOptionsRequest autovacuumVacuumCostLimit(Integer autovacuumVacuumCostLimit) {
    this.autovacuumVacuumCostLimit = autovacuumVacuumCostLimit;
    return this;
  }

   /**
   * Accepted values: -1 - 10000
   * @return autovacuumVacuumCostLimit
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumVacuumCostLimit() {
    return autovacuumVacuumCostLimit;
  }

  public void setAutovacuumVacuumCostLimit(Integer autovacuumVacuumCostLimit) {
    this.autovacuumVacuumCostLimit = autovacuumVacuumCostLimit;
  }


  public UpdateAdvancedOptionsRequest autovacuumVacuumScaleFactor(Float autovacuumVacuumScaleFactor) {
    this.autovacuumVacuumScaleFactor = autovacuumVacuumScaleFactor;
    return this;
  }

   /**
   * Accepted values: 0 - 1
   * @return autovacuumVacuumScaleFactor
  **/
  @javax.annotation.Nullable
  public Float getAutovacuumVacuumScaleFactor() {
    return autovacuumVacuumScaleFactor;
  }

  public void setAutovacuumVacuumScaleFactor(Float autovacuumVacuumScaleFactor) {
    this.autovacuumVacuumScaleFactor = autovacuumVacuumScaleFactor;
  }


  public UpdateAdvancedOptionsRequest autovacuumVacuumThreshold(Integer autovacuumVacuumThreshold) {
    this.autovacuumVacuumThreshold = autovacuumVacuumThreshold;
    return this;
  }

   /**
   * Accepted values: 0 - 2147483647
   * @return autovacuumVacuumThreshold
  **/
  @javax.annotation.Nullable
  public Integer getAutovacuumVacuumThreshold() {
    return autovacuumVacuumThreshold;
  }

  public void setAutovacuumVacuumThreshold(Integer autovacuumVacuumThreshold) {
    this.autovacuumVacuumThreshold = autovacuumVacuumThreshold;
  }


  public UpdateAdvancedOptionsRequest bgwriterDelay(Integer bgwriterDelay) {
    this.bgwriterDelay = bgwriterDelay;
    return this;
  }

   /**
   * Accepted values: 10 - 10000
   * @return bgwriterDelay
  **/
  @javax.annotation.Nullable
  public Integer getBgwriterDelay() {
    return bgwriterDelay;
  }

  public void setBgwriterDelay(Integer bgwriterDelay) {
    this.bgwriterDelay = bgwriterDelay;
  }


  public UpdateAdvancedOptionsRequest bgwriterFlushAfter(Integer bgwriterFlushAfter) {
    this.bgwriterFlushAfter = bgwriterFlushAfter;
    return this;
  }

   /**
   * Accepted values: 0 - 2048
   * @return bgwriterFlushAfter
  **/
  @javax.annotation.Nullable
  public Integer getBgwriterFlushAfter() {
    return bgwriterFlushAfter;
  }

  public void setBgwriterFlushAfter(Integer bgwriterFlushAfter) {
    this.bgwriterFlushAfter = bgwriterFlushAfter;
  }


  public UpdateAdvancedOptionsRequest bgwriterLruMaxpages(Integer bgwriterLruMaxpages) {
    this.bgwriterLruMaxpages = bgwriterLruMaxpages;
    return this;
  }

   /**
   * Accepted values: 0 - 1073741823
   * @return bgwriterLruMaxpages
  **/
  @javax.annotation.Nullable
  public Integer getBgwriterLruMaxpages() {
    return bgwriterLruMaxpages;
  }

  public void setBgwriterLruMaxpages(Integer bgwriterLruMaxpages) {
    this.bgwriterLruMaxpages = bgwriterLruMaxpages;
  }


  public UpdateAdvancedOptionsRequest bgwriterLruMultiplier(Float bgwriterLruMultiplier) {
    this.bgwriterLruMultiplier = bgwriterLruMultiplier;
    return this;
  }

   /**
   * Accepted values: 0 - 10
   * @return bgwriterLruMultiplier
  **/
  @javax.annotation.Nullable
  public Float getBgwriterLruMultiplier() {
    return bgwriterLruMultiplier;
  }

  public void setBgwriterLruMultiplier(Float bgwriterLruMultiplier) {
    this.bgwriterLruMultiplier = bgwriterLruMultiplier;
  }


  public UpdateAdvancedOptionsRequest deadlockTimeout(Integer deadlockTimeout) {
    this.deadlockTimeout = deadlockTimeout;
    return this;
  }

   /**
   * Accepted values: 500 - 1800000
   * @return deadlockTimeout
  **/
  @javax.annotation.Nullable
  public Integer getDeadlockTimeout() {
    return deadlockTimeout;
  }

  public void setDeadlockTimeout(Integer deadlockTimeout) {
    this.deadlockTimeout = deadlockTimeout;
  }


  public UpdateAdvancedOptionsRequest defaultToastCompression(ModelEnum defaultToastCompression) {
    this.defaultToastCompression = defaultToastCompression;
    return this;
  }

   /**
   * Accepted values: * &#x60;lz4&#x60; * &#x60;pglz&#x60;
   * @return defaultToastCompression
  **/
  @javax.annotation.Nullable
  public ModelEnum getDefaultToastCompression() {
    return defaultToastCompression;
  }

  public void setDefaultToastCompression(ModelEnum defaultToastCompression) {
    this.defaultToastCompression = defaultToastCompression;
  }


  public UpdateAdvancedOptionsRequest idleInTransactionSessionTimeout(Integer idleInTransactionSessionTimeout) {
    this.idleInTransactionSessionTimeout = idleInTransactionSessionTimeout;
    return this;
  }

   /**
   * Accepted values: 0 - 604800000
   * @return idleInTransactionSessionTimeout
  **/
  @javax.annotation.Nullable
  public Integer getIdleInTransactionSessionTimeout() {
    return idleInTransactionSessionTimeout;
  }

  public void setIdleInTransactionSessionTimeout(Integer idleInTransactionSessionTimeout) {
    this.idleInTransactionSessionTimeout = idleInTransactionSessionTimeout;
  }


  public UpdateAdvancedOptionsRequest jit(Boolean jit) {
    this.jit = jit;
    return this;
  }

   /**
   * Accepted values: * &#x60;true&#x60; * &#x60;false&#x60;
   * @return jit
  **/
  @javax.annotation.Nullable
  public Boolean getJit() {
    return jit;
  }

  public void setJit(Boolean jit) {
    this.jit = jit;
  }


  public UpdateAdvancedOptionsRequest logAutovacuumMinDuration(Integer logAutovacuumMinDuration) {
    this.logAutovacuumMinDuration = logAutovacuumMinDuration;
    return this;
  }

   /**
   * Accepted values: -1 - 2147483647
   * @return logAutovacuumMinDuration
  **/
  @javax.annotation.Nullable
  public Integer getLogAutovacuumMinDuration() {
    return logAutovacuumMinDuration;
  }

  public void setLogAutovacuumMinDuration(Integer logAutovacuumMinDuration) {
    this.logAutovacuumMinDuration = logAutovacuumMinDuration;
  }


  public UpdateAdvancedOptionsRequest logErrorVerbosity(ModelEnum logErrorVerbosity) {
    this.logErrorVerbosity = logErrorVerbosity;
    return this;
  }

   /**
   * Accepted values: * &#x60;TERSE&#x60; * &#x60;DEFAULT&#x60; * &#x60;VERBOSE&#x60;
   * @return logErrorVerbosity
  **/
  @javax.annotation.Nullable
  public ModelEnum getLogErrorVerbosity() {
    return logErrorVerbosity;
  }

  public void setLogErrorVerbosity(ModelEnum logErrorVerbosity) {
    this.logErrorVerbosity = logErrorVerbosity;
  }


  public UpdateAdvancedOptionsRequest logLinePrefix(ModelEnum logLinePrefix) {
    this.logLinePrefix = logLinePrefix;
    return this;
  }

   /**
   * Accepted values: * &#x60;&#39;pid&#x3D;%p,user&#x3D;%u,db&#x3D;%d,app&#x3D;%a,client&#x3D;%h &#39;&#x60; * &#x60;&#39;%t [%p]: [%l-1] user&#x3D;%u,db&#x3D;%d,app&#x3D;%a,client&#x3D;%h &#39;&#x60; * &#x60;&#39;%m [%p] %q[user&#x3D;%u,db&#x3D;%d,app&#x3D;%a] &#39;&#x60;
   * @return logLinePrefix
  **/
  @javax.annotation.Nullable
  public ModelEnum getLogLinePrefix() {
    return logLinePrefix;
  }

  public void setLogLinePrefix(ModelEnum logLinePrefix) {
    this.logLinePrefix = logLinePrefix;
  }


  public UpdateAdvancedOptionsRequest logMinDurationStatement(Integer logMinDurationStatement) {
    this.logMinDurationStatement = logMinDurationStatement;
    return this;
  }

   /**
   * Accepted values: -1 - 86400000
   * @return logMinDurationStatement
  **/
  @javax.annotation.Nullable
  public Integer getLogMinDurationStatement() {
    return logMinDurationStatement;
  }

  public void setLogMinDurationStatement(Integer logMinDurationStatement) {
    this.logMinDurationStatement = logMinDurationStatement;
  }


  public UpdateAdvancedOptionsRequest maxFilesPerProcess(Integer maxFilesPerProcess) {
    this.maxFilesPerProcess = maxFilesPerProcess;
    return this;
  }

   /**
   * Accepted values: 1000 - 4096
   * @return maxFilesPerProcess
  **/
  @javax.annotation.Nullable
  public Integer getMaxFilesPerProcess() {
    return maxFilesPerProcess;
  }

  public void setMaxFilesPerProcess(Integer maxFilesPerProcess) {
    this.maxFilesPerProcess = maxFilesPerProcess;
  }


  public UpdateAdvancedOptionsRequest maxLocksPerTransaction(Integer maxLocksPerTransaction) {
    this.maxLocksPerTransaction = maxLocksPerTransaction;
    return this;
  }

   /**
   * Accepted values: 64 - 6400
   * @return maxLocksPerTransaction
  **/
  @javax.annotation.Nullable
  public Integer getMaxLocksPerTransaction() {
    return maxLocksPerTransaction;
  }

  public void setMaxLocksPerTransaction(Integer maxLocksPerTransaction) {
    this.maxLocksPerTransaction = maxLocksPerTransaction;
  }


  public UpdateAdvancedOptionsRequest maxLogicalReplicationWorkers(Integer maxLogicalReplicationWorkers) {
    this.maxLogicalReplicationWorkers = maxLogicalReplicationWorkers;
    return this;
  }

   /**
   * Accepted values: 4 - 64
   * @return maxLogicalReplicationWorkers
  **/
  @javax.annotation.Nullable
  public Integer getMaxLogicalReplicationWorkers() {
    return maxLogicalReplicationWorkers;
  }

  public void setMaxLogicalReplicationWorkers(Integer maxLogicalReplicationWorkers) {
    this.maxLogicalReplicationWorkers = maxLogicalReplicationWorkers;
  }


  public UpdateAdvancedOptionsRequest maxParallelWorkers(Integer maxParallelWorkers) {
    this.maxParallelWorkers = maxParallelWorkers;
    return this;
  }

   /**
   * Accepted values: 0 - 96
   * @return maxParallelWorkers
  **/
  @javax.annotation.Nullable
  public Integer getMaxParallelWorkers() {
    return maxParallelWorkers;
  }

  public void setMaxParallelWorkers(Integer maxParallelWorkers) {
    this.maxParallelWorkers = maxParallelWorkers;
  }


  public UpdateAdvancedOptionsRequest maxParallelWorkersPerGather(Integer maxParallelWorkersPerGather) {
    this.maxParallelWorkersPerGather = maxParallelWorkersPerGather;
    return this;
  }

   /**
   * Accepted values: 0 - 96
   * @return maxParallelWorkersPerGather
  **/
  @javax.annotation.Nullable
  public Integer getMaxParallelWorkersPerGather() {
    return maxParallelWorkersPerGather;
  }

  public void setMaxParallelWorkersPerGather(Integer maxParallelWorkersPerGather) {
    this.maxParallelWorkersPerGather = maxParallelWorkersPerGather;
  }


  public UpdateAdvancedOptionsRequest maxPredLocksPerTransaction(Integer maxPredLocksPerTransaction) {
    this.maxPredLocksPerTransaction = maxPredLocksPerTransaction;
    return this;
  }

   /**
   * Accepted values: 64 - 5120
   * @return maxPredLocksPerTransaction
  **/
  @javax.annotation.Nullable
  public Integer getMaxPredLocksPerTransaction() {
    return maxPredLocksPerTransaction;
  }

  public void setMaxPredLocksPerTransaction(Integer maxPredLocksPerTransaction) {
    this.maxPredLocksPerTransaction = maxPredLocksPerTransaction;
  }


  public UpdateAdvancedOptionsRequest maxPreparedTransactions(Integer maxPreparedTransactions) {
    this.maxPreparedTransactions = maxPreparedTransactions;
    return this;
  }

   /**
   * Accepted values: 0 - 10000
   * @return maxPreparedTransactions
  **/
  @javax.annotation.Nullable
  public Integer getMaxPreparedTransactions() {
    return maxPreparedTransactions;
  }

  public void setMaxPreparedTransactions(Integer maxPreparedTransactions) {
    this.maxPreparedTransactions = maxPreparedTransactions;
  }


  public UpdateAdvancedOptionsRequest maxReplicationSlots(Integer maxReplicationSlots) {
    this.maxReplicationSlots = maxReplicationSlots;
    return this;
  }

   /**
   * Accepted values: 8 - 64
   * @return maxReplicationSlots
  **/
  @javax.annotation.Nullable
  public Integer getMaxReplicationSlots() {
    return maxReplicationSlots;
  }

  public void setMaxReplicationSlots(Integer maxReplicationSlots) {
    this.maxReplicationSlots = maxReplicationSlots;
  }


  public UpdateAdvancedOptionsRequest maxStackDepth(Integer maxStackDepth) {
    this.maxStackDepth = maxStackDepth;
    return this;
  }

   /**
   * Accepted values: 2097152 - 6291456
   * @return maxStackDepth
  **/
  @javax.annotation.Nullable
  public Integer getMaxStackDepth() {
    return maxStackDepth;
  }

  public void setMaxStackDepth(Integer maxStackDepth) {
    this.maxStackDepth = maxStackDepth;
  }


  public UpdateAdvancedOptionsRequest maxStandbyArchiveDelay(Integer maxStandbyArchiveDelay) {
    this.maxStandbyArchiveDelay = maxStandbyArchiveDelay;
    return this;
  }

   /**
   * Accepted values: 1 - 43200000
   * @return maxStandbyArchiveDelay
  **/
  @javax.annotation.Nullable
  public Integer getMaxStandbyArchiveDelay() {
    return maxStandbyArchiveDelay;
  }

  public void setMaxStandbyArchiveDelay(Integer maxStandbyArchiveDelay) {
    this.maxStandbyArchiveDelay = maxStandbyArchiveDelay;
  }


  public UpdateAdvancedOptionsRequest maxStandbyStreamingDelay(Integer maxStandbyStreamingDelay) {
    this.maxStandbyStreamingDelay = maxStandbyStreamingDelay;
    return this;
  }

   /**
   * Accepted values: 1 - 43200000
   * @return maxStandbyStreamingDelay
  **/
  @javax.annotation.Nullable
  public Integer getMaxStandbyStreamingDelay() {
    return maxStandbyStreamingDelay;
  }

  public void setMaxStandbyStreamingDelay(Integer maxStandbyStreamingDelay) {
    this.maxStandbyStreamingDelay = maxStandbyStreamingDelay;
  }


  public UpdateAdvancedOptionsRequest maxWalSenders(Integer maxWalSenders) {
    this.maxWalSenders = maxWalSenders;
    return this;
  }

   /**
   * Accepted values: 20 - 64
   * @return maxWalSenders
  **/
  @javax.annotation.Nullable
  public Integer getMaxWalSenders() {
    return maxWalSenders;
  }

  public void setMaxWalSenders(Integer maxWalSenders) {
    this.maxWalSenders = maxWalSenders;
  }


  public UpdateAdvancedOptionsRequest maxWorkerProcesses(Integer maxWorkerProcesses) {
    this.maxWorkerProcesses = maxWorkerProcesses;
    return this;
  }

   /**
   * Accepted values: 8 - 96
   * @return maxWorkerProcesses
  **/
  @javax.annotation.Nullable
  public Integer getMaxWorkerProcesses() {
    return maxWorkerProcesses;
  }

  public void setMaxWorkerProcesses(Integer maxWorkerProcesses) {
    this.maxWorkerProcesses = maxWorkerProcesses;
  }


  public UpdateAdvancedOptionsRequest pgPartmanBgwInterval(Integer pgPartmanBgwInterval) {
    this.pgPartmanBgwInterval = pgPartmanBgwInterval;
    return this;
  }

   /**
   * Accepted values: 3600 - 604800
   * @return pgPartmanBgwInterval
  **/
  @javax.annotation.Nullable
  public Integer getPgPartmanBgwInterval() {
    return pgPartmanBgwInterval;
  }

  public void setPgPartmanBgwInterval(Integer pgPartmanBgwInterval) {
    this.pgPartmanBgwInterval = pgPartmanBgwInterval;
  }


  public UpdateAdvancedOptionsRequest pgPartmanBgwRole(String pgPartmanBgwRole) {
    this.pgPartmanBgwRole = pgPartmanBgwRole;
    return this;
  }

   /**
   * Maximum length: 64 characters
   * @return pgPartmanBgwRole
  **/
  @javax.annotation.Nullable
  public String getPgPartmanBgwRole() {
    return pgPartmanBgwRole;
  }

  public void setPgPartmanBgwRole(String pgPartmanBgwRole) {
    this.pgPartmanBgwRole = pgPartmanBgwRole;
  }


  public UpdateAdvancedOptionsRequest pgStatStatementsTrack(ModelEnum pgStatStatementsTrack) {
    this.pgStatStatementsTrack = pgStatStatementsTrack;
    return this;
  }

   /**
   * Accepted values: * &#x60;all&#x60; * &#x60;top&#x60; * &#x60;none&#x60;
   * @return pgStatStatementsTrack
  **/
  @javax.annotation.Nullable
  public ModelEnum getPgStatStatementsTrack() {
    return pgStatStatementsTrack;
  }

  public void setPgStatStatementsTrack(ModelEnum pgStatStatementsTrack) {
    this.pgStatStatementsTrack = pgStatStatementsTrack;
  }


  public UpdateAdvancedOptionsRequest tempFileLimit(Integer tempFileLimit) {
    this.tempFileLimit = tempFileLimit;
    return this;
  }

   /**
   * Accepted values: -1 - 2147483647
   * @return tempFileLimit
  **/
  @javax.annotation.Nullable
  public Integer getTempFileLimit() {
    return tempFileLimit;
  }

  public void setTempFileLimit(Integer tempFileLimit) {
    this.tempFileLimit = tempFileLimit;
  }


  public UpdateAdvancedOptionsRequest trackActivityQuerySize(Integer trackActivityQuerySize) {
    this.trackActivityQuerySize = trackActivityQuerySize;
    return this;
  }

   /**
   * Accepted values: 1024 - 10240
   * @return trackActivityQuerySize
  **/
  @javax.annotation.Nullable
  public Integer getTrackActivityQuerySize() {
    return trackActivityQuerySize;
  }

  public void setTrackActivityQuerySize(Integer trackActivityQuerySize) {
    this.trackActivityQuerySize = trackActivityQuerySize;
  }


  public UpdateAdvancedOptionsRequest trackCommitTimestamp(ModelEnum trackCommitTimestamp) {
    this.trackCommitTimestamp = trackCommitTimestamp;
    return this;
  }

   /**
   * Accepted values: * &#x60;off&#x60; * &#x60;on&#x60;
   * @return trackCommitTimestamp
  **/
  @javax.annotation.Nullable
  public ModelEnum getTrackCommitTimestamp() {
    return trackCommitTimestamp;
  }

  public void setTrackCommitTimestamp(ModelEnum trackCommitTimestamp) {
    this.trackCommitTimestamp = trackCommitTimestamp;
  }


  public UpdateAdvancedOptionsRequest trackFunctions(ModelEnum trackFunctions) {
    this.trackFunctions = trackFunctions;
    return this;
  }

   /**
   * Accepted values: * &#x60;all&#x60; * &#x60;pl&#x60; * &#x60;none&#x60;
   * @return trackFunctions
  **/
  @javax.annotation.Nullable
  public ModelEnum getTrackFunctions() {
    return trackFunctions;
  }

  public void setTrackFunctions(ModelEnum trackFunctions) {
    this.trackFunctions = trackFunctions;
  }


  public UpdateAdvancedOptionsRequest trackIoTiming(ModelEnum trackIoTiming) {
    this.trackIoTiming = trackIoTiming;
    return this;
  }

   /**
   * Accepted values: * &#x60;off&#x60; * &#x60;on&#x60;
   * @return trackIoTiming
  **/
  @javax.annotation.Nullable
  public ModelEnum getTrackIoTiming() {
    return trackIoTiming;
  }

  public void setTrackIoTiming(ModelEnum trackIoTiming) {
    this.trackIoTiming = trackIoTiming;
  }


  public UpdateAdvancedOptionsRequest walSenderTimeout(Integer walSenderTimeout) {
    this.walSenderTimeout = walSenderTimeout;
    return this;
  }

   /**
   * Accepted values: 0, 5000 - 10800000
   * @return walSenderTimeout
  **/
  @javax.annotation.Nullable
  public Integer getWalSenderTimeout() {
    return walSenderTimeout;
  }

  public void setWalSenderTimeout(Integer walSenderTimeout) {
    this.walSenderTimeout = walSenderTimeout;
  }


  public UpdateAdvancedOptionsRequest walWriterDelay(Integer walWriterDelay) {
    this.walWriterDelay = walWriterDelay;
    return this;
  }

   /**
   * Accepted values: 10 - 200
   * @return walWriterDelay
  **/
  @javax.annotation.Nullable
  public Integer getWalWriterDelay() {
    return walWriterDelay;
  }

  public void setWalWriterDelay(Integer walWriterDelay) {
    this.walWriterDelay = walWriterDelay;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAdvancedOptionsRequest updateAdvancedOptionsRequest = (UpdateAdvancedOptionsRequest) o;
    return Objects.equals(this.autovacuumAnalyzeScaleFactor, updateAdvancedOptionsRequest.autovacuumAnalyzeScaleFactor) &&
        Objects.equals(this.autovacuumAnalyzeThreshold, updateAdvancedOptionsRequest.autovacuumAnalyzeThreshold) &&
        Objects.equals(this.autovacuumFreezeMaxAge, updateAdvancedOptionsRequest.autovacuumFreezeMaxAge) &&
        Objects.equals(this.autovacuumMaxWorkers, updateAdvancedOptionsRequest.autovacuumMaxWorkers) &&
        Objects.equals(this.autovacuumNaptime, updateAdvancedOptionsRequest.autovacuumNaptime) &&
        Objects.equals(this.autovacuumVacuumCostDelay, updateAdvancedOptionsRequest.autovacuumVacuumCostDelay) &&
        Objects.equals(this.autovacuumVacuumCostLimit, updateAdvancedOptionsRequest.autovacuumVacuumCostLimit) &&
        Objects.equals(this.autovacuumVacuumScaleFactor, updateAdvancedOptionsRequest.autovacuumVacuumScaleFactor) &&
        Objects.equals(this.autovacuumVacuumThreshold, updateAdvancedOptionsRequest.autovacuumVacuumThreshold) &&
        Objects.equals(this.bgwriterDelay, updateAdvancedOptionsRequest.bgwriterDelay) &&
        Objects.equals(this.bgwriterFlushAfter, updateAdvancedOptionsRequest.bgwriterFlushAfter) &&
        Objects.equals(this.bgwriterLruMaxpages, updateAdvancedOptionsRequest.bgwriterLruMaxpages) &&
        Objects.equals(this.bgwriterLruMultiplier, updateAdvancedOptionsRequest.bgwriterLruMultiplier) &&
        Objects.equals(this.deadlockTimeout, updateAdvancedOptionsRequest.deadlockTimeout) &&
        Objects.equals(this.defaultToastCompression, updateAdvancedOptionsRequest.defaultToastCompression) &&
        Objects.equals(this.idleInTransactionSessionTimeout, updateAdvancedOptionsRequest.idleInTransactionSessionTimeout) &&
        Objects.equals(this.jit, updateAdvancedOptionsRequest.jit) &&
        Objects.equals(this.logAutovacuumMinDuration, updateAdvancedOptionsRequest.logAutovacuumMinDuration) &&
        Objects.equals(this.logErrorVerbosity, updateAdvancedOptionsRequest.logErrorVerbosity) &&
        Objects.equals(this.logLinePrefix, updateAdvancedOptionsRequest.logLinePrefix) &&
        Objects.equals(this.logMinDurationStatement, updateAdvancedOptionsRequest.logMinDurationStatement) &&
        Objects.equals(this.maxFilesPerProcess, updateAdvancedOptionsRequest.maxFilesPerProcess) &&
        Objects.equals(this.maxLocksPerTransaction, updateAdvancedOptionsRequest.maxLocksPerTransaction) &&
        Objects.equals(this.maxLogicalReplicationWorkers, updateAdvancedOptionsRequest.maxLogicalReplicationWorkers) &&
        Objects.equals(this.maxParallelWorkers, updateAdvancedOptionsRequest.maxParallelWorkers) &&
        Objects.equals(this.maxParallelWorkersPerGather, updateAdvancedOptionsRequest.maxParallelWorkersPerGather) &&
        Objects.equals(this.maxPredLocksPerTransaction, updateAdvancedOptionsRequest.maxPredLocksPerTransaction) &&
        Objects.equals(this.maxPreparedTransactions, updateAdvancedOptionsRequest.maxPreparedTransactions) &&
        Objects.equals(this.maxReplicationSlots, updateAdvancedOptionsRequest.maxReplicationSlots) &&
        Objects.equals(this.maxStackDepth, updateAdvancedOptionsRequest.maxStackDepth) &&
        Objects.equals(this.maxStandbyArchiveDelay, updateAdvancedOptionsRequest.maxStandbyArchiveDelay) &&
        Objects.equals(this.maxStandbyStreamingDelay, updateAdvancedOptionsRequest.maxStandbyStreamingDelay) &&
        Objects.equals(this.maxWalSenders, updateAdvancedOptionsRequest.maxWalSenders) &&
        Objects.equals(this.maxWorkerProcesses, updateAdvancedOptionsRequest.maxWorkerProcesses) &&
        Objects.equals(this.pgPartmanBgwInterval, updateAdvancedOptionsRequest.pgPartmanBgwInterval) &&
        Objects.equals(this.pgPartmanBgwRole, updateAdvancedOptionsRequest.pgPartmanBgwRole) &&
        Objects.equals(this.pgStatStatementsTrack, updateAdvancedOptionsRequest.pgStatStatementsTrack) &&
        Objects.equals(this.tempFileLimit, updateAdvancedOptionsRequest.tempFileLimit) &&
        Objects.equals(this.trackActivityQuerySize, updateAdvancedOptionsRequest.trackActivityQuerySize) &&
        Objects.equals(this.trackCommitTimestamp, updateAdvancedOptionsRequest.trackCommitTimestamp) &&
        Objects.equals(this.trackFunctions, updateAdvancedOptionsRequest.trackFunctions) &&
        Objects.equals(this.trackIoTiming, updateAdvancedOptionsRequest.trackIoTiming) &&
        Objects.equals(this.walSenderTimeout, updateAdvancedOptionsRequest.walSenderTimeout) &&
        Objects.equals(this.walWriterDelay, updateAdvancedOptionsRequest.walWriterDelay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autovacuumAnalyzeScaleFactor, autovacuumAnalyzeThreshold, autovacuumFreezeMaxAge, autovacuumMaxWorkers, autovacuumNaptime, autovacuumVacuumCostDelay, autovacuumVacuumCostLimit, autovacuumVacuumScaleFactor, autovacuumVacuumThreshold, bgwriterDelay, bgwriterFlushAfter, bgwriterLruMaxpages, bgwriterLruMultiplier, deadlockTimeout, defaultToastCompression, idleInTransactionSessionTimeout, jit, logAutovacuumMinDuration, logErrorVerbosity, logLinePrefix, logMinDurationStatement, maxFilesPerProcess, maxLocksPerTransaction, maxLogicalReplicationWorkers, maxParallelWorkers, maxParallelWorkersPerGather, maxPredLocksPerTransaction, maxPreparedTransactions, maxReplicationSlots, maxStackDepth, maxStandbyArchiveDelay, maxStandbyStreamingDelay, maxWalSenders, maxWorkerProcesses, pgPartmanBgwInterval, pgPartmanBgwRole, pgStatStatementsTrack, tempFileLimit, trackActivityQuerySize, trackCommitTimestamp, trackFunctions, trackIoTiming, walSenderTimeout, walWriterDelay);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateAdvancedOptionsRequest {\n");
    sb.append("    autovacuumAnalyzeScaleFactor: ").append(toIndentedString(autovacuumAnalyzeScaleFactor)).append("\n");
    sb.append("    autovacuumAnalyzeThreshold: ").append(toIndentedString(autovacuumAnalyzeThreshold)).append("\n");
    sb.append("    autovacuumFreezeMaxAge: ").append(toIndentedString(autovacuumFreezeMaxAge)).append("\n");
    sb.append("    autovacuumMaxWorkers: ").append(toIndentedString(autovacuumMaxWorkers)).append("\n");
    sb.append("    autovacuumNaptime: ").append(toIndentedString(autovacuumNaptime)).append("\n");
    sb.append("    autovacuumVacuumCostDelay: ").append(toIndentedString(autovacuumVacuumCostDelay)).append("\n");
    sb.append("    autovacuumVacuumCostLimit: ").append(toIndentedString(autovacuumVacuumCostLimit)).append("\n");
    sb.append("    autovacuumVacuumScaleFactor: ").append(toIndentedString(autovacuumVacuumScaleFactor)).append("\n");
    sb.append("    autovacuumVacuumThreshold: ").append(toIndentedString(autovacuumVacuumThreshold)).append("\n");
    sb.append("    bgwriterDelay: ").append(toIndentedString(bgwriterDelay)).append("\n");
    sb.append("    bgwriterFlushAfter: ").append(toIndentedString(bgwriterFlushAfter)).append("\n");
    sb.append("    bgwriterLruMaxpages: ").append(toIndentedString(bgwriterLruMaxpages)).append("\n");
    sb.append("    bgwriterLruMultiplier: ").append(toIndentedString(bgwriterLruMultiplier)).append("\n");
    sb.append("    deadlockTimeout: ").append(toIndentedString(deadlockTimeout)).append("\n");
    sb.append("    defaultToastCompression: ").append(toIndentedString(defaultToastCompression)).append("\n");
    sb.append("    idleInTransactionSessionTimeout: ").append(toIndentedString(idleInTransactionSessionTimeout)).append("\n");
    sb.append("    jit: ").append(toIndentedString(jit)).append("\n");
    sb.append("    logAutovacuumMinDuration: ").append(toIndentedString(logAutovacuumMinDuration)).append("\n");
    sb.append("    logErrorVerbosity: ").append(toIndentedString(logErrorVerbosity)).append("\n");
    sb.append("    logLinePrefix: ").append(toIndentedString(logLinePrefix)).append("\n");
    sb.append("    logMinDurationStatement: ").append(toIndentedString(logMinDurationStatement)).append("\n");
    sb.append("    maxFilesPerProcess: ").append(toIndentedString(maxFilesPerProcess)).append("\n");
    sb.append("    maxLocksPerTransaction: ").append(toIndentedString(maxLocksPerTransaction)).append("\n");
    sb.append("    maxLogicalReplicationWorkers: ").append(toIndentedString(maxLogicalReplicationWorkers)).append("\n");
    sb.append("    maxParallelWorkers: ").append(toIndentedString(maxParallelWorkers)).append("\n");
    sb.append("    maxParallelWorkersPerGather: ").append(toIndentedString(maxParallelWorkersPerGather)).append("\n");
    sb.append("    maxPredLocksPerTransaction: ").append(toIndentedString(maxPredLocksPerTransaction)).append("\n");
    sb.append("    maxPreparedTransactions: ").append(toIndentedString(maxPreparedTransactions)).append("\n");
    sb.append("    maxReplicationSlots: ").append(toIndentedString(maxReplicationSlots)).append("\n");
    sb.append("    maxStackDepth: ").append(toIndentedString(maxStackDepth)).append("\n");
    sb.append("    maxStandbyArchiveDelay: ").append(toIndentedString(maxStandbyArchiveDelay)).append("\n");
    sb.append("    maxStandbyStreamingDelay: ").append(toIndentedString(maxStandbyStreamingDelay)).append("\n");
    sb.append("    maxWalSenders: ").append(toIndentedString(maxWalSenders)).append("\n");
    sb.append("    maxWorkerProcesses: ").append(toIndentedString(maxWorkerProcesses)).append("\n");
    sb.append("    pgPartmanBgwInterval: ").append(toIndentedString(pgPartmanBgwInterval)).append("\n");
    sb.append("    pgPartmanBgwRole: ").append(toIndentedString(pgPartmanBgwRole)).append("\n");
    sb.append("    pgStatStatementsTrack: ").append(toIndentedString(pgStatStatementsTrack)).append("\n");
    sb.append("    tempFileLimit: ").append(toIndentedString(tempFileLimit)).append("\n");
    sb.append("    trackActivityQuerySize: ").append(toIndentedString(trackActivityQuerySize)).append("\n");
    sb.append("    trackCommitTimestamp: ").append(toIndentedString(trackCommitTimestamp)).append("\n");
    sb.append("    trackFunctions: ").append(toIndentedString(trackFunctions)).append("\n");
    sb.append("    trackIoTiming: ").append(toIndentedString(trackIoTiming)).append("\n");
    sb.append("    walSenderTimeout: ").append(toIndentedString(walSenderTimeout)).append("\n");
    sb.append("    walWriterDelay: ").append(toIndentedString(walWriterDelay)).append("\n");
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
    openapiFields.add("autovacuum_analyze_scale_factor");
    openapiFields.add("autovacuum_analyze_threshold");
    openapiFields.add("autovacuum_freeze_max_age");
    openapiFields.add("autovacuum_max_workers");
    openapiFields.add("autovacuum_naptime");
    openapiFields.add("autovacuum_vacuum_cost_delay");
    openapiFields.add("autovacuum_vacuum_cost_limit");
    openapiFields.add("autovacuum_vacuum_scale_factor");
    openapiFields.add("autovacuum_vacuum_threshold");
    openapiFields.add("bgwriter_delay");
    openapiFields.add("bgwriter_flush_after");
    openapiFields.add("bgwriter_lru_maxpages");
    openapiFields.add("bgwriter_lru_multiplier");
    openapiFields.add("deadlock_timeout");
    openapiFields.add("default_toast_compression");
    openapiFields.add("idle_in_transaction_session_timeout");
    openapiFields.add("jit");
    openapiFields.add("log_autovacuum_min_duration");
    openapiFields.add("log_error_verbosity");
    openapiFields.add("log_line_prefix");
    openapiFields.add("log_min_duration_statement");
    openapiFields.add("max_files_per_process");
    openapiFields.add("max_locks_per_transaction");
    openapiFields.add("max_logical_replication_workers");
    openapiFields.add("max_parallel_workers");
    openapiFields.add("max_parallel_workers_per_gather");
    openapiFields.add("max_pred_locks_per_transaction");
    openapiFields.add("max_prepared_transactions");
    openapiFields.add("max_replication_slots");
    openapiFields.add("max_stack_depth");
    openapiFields.add("max_standby_archive_delay");
    openapiFields.add("max_standby_streaming_delay");
    openapiFields.add("max_wal_senders");
    openapiFields.add("max_worker_processes");
    openapiFields.add("pg_partman_bgw.interval");
    openapiFields.add("pg_partman_bgw.role");
    openapiFields.add("pg_stat_statements.track");
    openapiFields.add("temp_file_limit");
    openapiFields.add("track_activity_query_size");
    openapiFields.add("track_commit_timestamp");
    openapiFields.add("track_functions");
    openapiFields.add("track_io_timing");
    openapiFields.add("wal_sender_timeout");
    openapiFields.add("wal_writer_delay");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateAdvancedOptionsRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateAdvancedOptionsRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateAdvancedOptionsRequest is not found in the empty JSON string", UpdateAdvancedOptionsRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateAdvancedOptionsRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateAdvancedOptionsRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("pg_partman_bgw.role") != null && !jsonObj.get("pg_partman_bgw.role").isJsonNull()) && !jsonObj.get("pg_partman_bgw.role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `pg_partman_bgw.role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("pg_partman_bgw.role").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateAdvancedOptionsRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateAdvancedOptionsRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateAdvancedOptionsRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateAdvancedOptionsRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateAdvancedOptionsRequest>() {
           @Override
           public void write(JsonWriter out, UpdateAdvancedOptionsRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateAdvancedOptionsRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateAdvancedOptionsRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateAdvancedOptionsRequest
  * @throws IOException if the JSON string is invalid with respect to UpdateAdvancedOptionsRequest
  */
  public static UpdateAdvancedOptionsRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateAdvancedOptionsRequest.class);
  }

 /**
  * Convert an instance of UpdateAdvancedOptionsRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

