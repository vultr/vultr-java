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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Model tests for Database
 */
public class DatabaseTest {
    private final Database model = new Database();

    /**
     * Model tests for Database
     */
    @Test
    public void testDatabase() {
        // TODO: test Database
    }

    /**
     * Test the property 'id'
     */
    @Test
    public void idTest() {
        // TODO: test id
    }

    /**
     * Test the property 'dateCreated'
     */
    @Test
    public void dateCreatedTest() {
        // TODO: test dateCreated
    }

    /**
     * Test the property 'plan'
     */
    @Test
    public void planTest() {
        // TODO: test plan
    }

    /**
     * Test the property 'planDisk'
     */
    @Test
    public void planDiskTest() {
        // TODO: test planDisk
    }

    /**
     * Test the property 'planRam'
     */
    @Test
    public void planRamTest() {
        // TODO: test planRam
    }

    /**
     * Test the property 'planVcpus'
     */
    @Test
    public void planVcpusTest() {
        // TODO: test planVcpus
    }

    /**
     * Test the property 'planReplicas'
     */
    @Test
    public void planReplicasTest() {
        // TODO: test planReplicas
    }

    /**
     * Test the property 'region'
     */
    @Test
    public void regionTest() {
        // TODO: test region
    }

    /**
     * Test the property 'databaseEngine'
     */
    @Test
    public void databaseEngineTest() {
        // TODO: test databaseEngine
    }

    /**
     * Test the property 'databaseEngineVersion'
     */
    @Test
    public void databaseEngineVersionTest() {
        // TODO: test databaseEngineVersion
    }

    /**
     * Test the property 'vpcId'
     */
    @Test
    public void vpcIdTest() {
        // TODO: test vpcId
    }

    /**
     * Test the property 'status'
     */
    @Test
    public void statusTest() {
        // TODO: test status
    }

    /**
     * Test the property 'label'
     */
    @Test
    public void labelTest() {
        // TODO: test label
    }

    /**
     * Test the property 'tag'
     */
    @Test
    public void tagTest() {
        // TODO: test tag
    }

    /**
     * Test the property 'dbname'
     */
    @Test
    public void dbnameTest() {
        // TODO: test dbname
    }

    /**
     * Test the property 'ferretdbCredentials'
     */
    @Test
    public void ferretdbCredentialsTest() {
        // TODO: test ferretdbCredentials
    }

    /**
     * Test the property 'host'
     */
    @Test
    public void hostTest() {
        // TODO: test host
    }

    /**
     * Test the property 'publicHost'
     */
    @Test
    public void publicHostTest() {
        // TODO: test publicHost
    }

    /**
     * Test the property 'user'
     */
    @Test
    public void userTest() {
        // TODO: test user
    }

    /**
     * Test the property 'password'
     */
    @Test
    public void passwordTest() {
        // TODO: test password
    }

    /**
     * Test the property 'port'
     */
    @Test
    public void portTest() {
        // TODO: test port
    }

    /**
     * Test the property 'maintenanceDow'
     */
    @Test
    public void maintenanceDowTest() {
        // TODO: test maintenanceDow
    }

    /**
     * Test the property 'maintenanceTime'
     */
    @Test
    public void maintenanceTimeTest() {
        // TODO: test maintenanceTime
    }

    /**
     * Test the property 'latestBackup'
     */
    @Test
    public void latestBackupTest() {
        // TODO: test latestBackup
    }

    /**
     * Test the property 'trustedIps'
     */
    @Test
    public void trustedIpsTest() {
        // TODO: test trustedIps
    }

    /**
     * Test the property 'mysqlSqlModes'
     */
    @Test
    public void mysqlSqlModesTest() {
        // TODO: test mysqlSqlModes
    }

    /**
     * Test the property 'mysqlRequirePrimaryKey'
     */
    @Test
    public void mysqlRequirePrimaryKeyTest() {
        // TODO: test mysqlRequirePrimaryKey
    }

    /**
     * Test the property 'mysqlSlowQueryLog'
     */
    @Test
    public void mysqlSlowQueryLogTest() {
        // TODO: test mysqlSlowQueryLog
    }

    /**
     * Test the property 'mysqlLongQueryTime'
     */
    @Test
    public void mysqlLongQueryTimeTest() {
        // TODO: test mysqlLongQueryTime
    }

    /**
     * Test the property 'pgAvailableExtensions'
     */
    @Test
    public void pgAvailableExtensionsTest() {
        // TODO: test pgAvailableExtensions
    }

    /**
     * Test the property 'redisEvictionPolicy'
     */
    @Test
    public void redisEvictionPolicyTest() {
        // TODO: test redisEvictionPolicy
    }

    /**
     * Test the property 'clusterTimeZone'
     */
    @Test
    public void clusterTimeZoneTest() {
        // TODO: test clusterTimeZone
    }

    /**
     * Test the property 'readReplicas'
     */
    @Test
    public void readReplicasTest() {
        // TODO: test readReplicas
    }

}
