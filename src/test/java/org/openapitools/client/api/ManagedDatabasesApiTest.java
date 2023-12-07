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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.CreateConnectionPool202Response;
import org.openapitools.client.model.CreateConnectionPoolRequest;
import org.openapitools.client.model.CreateDatabase202Response;
import org.openapitools.client.model.CreateDatabaseDb202Response;
import org.openapitools.client.model.CreateDatabaseDbRequest;
import org.openapitools.client.model.CreateDatabaseRequest;
import org.openapitools.client.model.CreateDatabaseUser202Response;
import org.openapitools.client.model.CreateDatabaseUserRequest;
import org.openapitools.client.model.DatabaseAddReadReplicaRequest;
import org.openapitools.client.model.DatabaseForkRequest;
import org.openapitools.client.model.DatabaseRestoreFromBackupRequest;
import org.openapitools.client.model.DatabaseStartMigrationRequest;
import org.openapitools.client.model.GetBackupInformation200Response;
import org.openapitools.client.model.GetDatabaseUsage200Response;
import org.openapitools.client.model.ListAdvancedOptions200Response;
import org.openapitools.client.model.ListAvailableVersions200Response;
import org.openapitools.client.model.ListConnectionPools200Response;
import org.openapitools.client.model.ListDatabaseDbs200Response;
import org.openapitools.client.model.ListDatabasePlans200Response;
import org.openapitools.client.model.ListDatabaseUsers200Response;
import org.openapitools.client.model.ListDatabases200Response;
import org.openapitools.client.model.ListMaintenanceUpdates200Response;
import org.openapitools.client.model.ListServiceAlerts200Response;
import org.openapitools.client.model.ListServiceAlertsRequest;
import org.openapitools.client.model.SetDatabaseUserAclRequest;
import org.openapitools.client.model.StartMaintenanceUpdates200Response;
import org.openapitools.client.model.StartVersionUpgrade200Response;
import org.openapitools.client.model.StartVersionUpgradeRequest;
import org.openapitools.client.model.UpdateAdvancedOptionsRequest;
import org.openapitools.client.model.UpdateConnectionPoolRequest;
import org.openapitools.client.model.UpdateDatabaseRequest;
import org.openapitools.client.model.UpdateDatabaseUserRequest;
import org.openapitools.client.model.ViewMigrationStatus200Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ManagedDatabasesApi
 */
@Disabled
public class ManagedDatabasesApiTest {

    private final ManagedDatabasesApi api = new ManagedDatabasesApi();

    /**
     * Create Connection Pool
     *
     * Create a new connection pool within the Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createConnectionPoolTest() throws ApiException {
        CreateConnectionPoolRequest createConnectionPoolRequest = null;
        CreateConnectionPool202Response response = api.createConnectionPool(createConnectionPoolRequest);
        // TODO: test validations
    }

    /**
     * Create Managed Database
     *
     * Create a new Managed Database in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Supply optional attributes as desired.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createDatabaseTest() throws ApiException {
        CreateDatabaseRequest createDatabaseRequest = null;
        CreateDatabase202Response response = api.createDatabase(createDatabaseRequest);
        // TODO: test validations
    }

    /**
     * Create Logical Database
     *
     * Create a new logical database within the Managed Database (MySQL and PostgreSQL only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createDatabaseDbTest() throws ApiException {
        CreateDatabaseDbRequest createDatabaseDbRequest = null;
        CreateDatabaseDb202Response response = api.createDatabaseDb(createDatabaseDbRequest);
        // TODO: test validations
    }

    /**
     * Create Database User
     *
     * Create a new database user within the Managed Database. Supply optional attributes as desired.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createDatabaseUserTest() throws ApiException {
        CreateDatabaseUserRequest createDatabaseUserRequest = null;
        CreateDatabaseUser202Response response = api.createDatabaseUser(createDatabaseUserRequest);
        // TODO: test validations
    }

    /**
     * Add Read-Only Replica
     *
     * Create a read-only replica node for the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void databaseAddReadReplicaTest() throws ApiException {
        DatabaseAddReadReplicaRequest databaseAddReadReplicaRequest = null;
        CreateDatabase202Response response = api.databaseAddReadReplica(databaseAddReadReplicaRequest);
        // TODO: test validations
    }

    /**
     * Detach Migration
     *
     * Detach a migration from the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void databaseDetachMigrationTest() throws ApiException {
        api.databaseDetachMigration();
        // TODO: test validations
    }

    /**
     * Fork Managed Database
     *
     * Fork a Managed Database to a new subscription from a backup.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void databaseForkTest() throws ApiException {
        DatabaseForkRequest databaseForkRequest = null;
        CreateDatabase202Response response = api.databaseFork(databaseForkRequest);
        // TODO: test validations
    }

    /**
     * Promote Read-Only Replica
     *
     * Promote a read-only replica node to its own primary Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void databasePromoteReadReplicaTest() throws ApiException {
        api.databasePromoteReadReplica();
        // TODO: test validations
    }

    /**
     * Restore from Backup
     *
     * Create a new Managed Database from a backup.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void databaseRestoreFromBackupTest() throws ApiException {
        DatabaseRestoreFromBackupRequest databaseRestoreFromBackupRequest = null;
        CreateDatabase202Response response = api.databaseRestoreFromBackup(databaseRestoreFromBackupRequest);
        // TODO: test validations
    }

    /**
     * Start Migration
     *
     * Start a migration to the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void databaseStartMigrationTest() throws ApiException {
        DatabaseStartMigrationRequest databaseStartMigrationRequest = null;
        ViewMigrationStatus200Response response = api.databaseStartMigration(databaseStartMigrationRequest);
        // TODO: test validations
    }

    /**
     * Delete Connection Pool
     *
     * Delete a connection pool within a Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteConnectionPoolTest() throws ApiException {
        String databaseId = null;
        String poolName = null;
        api.deleteConnectionPool(databaseId, poolName);
        // TODO: test validations
    }

    /**
     * Delete Managed Database
     *
     * Delete a Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteDatabaseTest() throws ApiException {
        String databaseId = null;
        api.deleteDatabase(databaseId);
        // TODO: test validations
    }

    /**
     * Delete Logical Database
     *
     * Delete a logical database within a Managed Database (MySQL and PostgreSQL only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteDatabaseDbTest() throws ApiException {
        String databaseId = null;
        String dbName = null;
        api.deleteDatabaseDb(databaseId, dbName);
        // TODO: test validations
    }

    /**
     * Delete Database User
     *
     * Delete a database user within a Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteDatabaseUserTest() throws ApiException {
        String databaseId = null;
        String username = null;
        api.deleteDatabaseUser(databaseId, username);
        // TODO: test validations
    }

    /**
     * Get Backup Information
     *
     * Get backup information for the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getBackupInformationTest() throws ApiException {
        GetBackupInformation200Response response = api.getBackupInformation();
        // TODO: test validations
    }

    /**
     * Get Connection Pool
     *
     * Get information about a Managed Database connection pool (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getConnectionPoolTest() throws ApiException {
        String databaseId = null;
        String poolName = null;
        CreateConnectionPool202Response response = api.getConnectionPool(databaseId, poolName);
        // TODO: test validations
    }

    /**
     * Get Managed Database
     *
     * Get information about a Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getDatabaseTest() throws ApiException {
        String databaseId = null;
        CreateDatabase202Response response = api.getDatabase(databaseId);
        // TODO: test validations
    }

    /**
     * Get Logical Database
     *
     * Get information about a logical database within a Managed Database (MySQL and PostgreSQL only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getDatabaseDbTest() throws ApiException {
        String databaseId = null;
        String dbName = null;
        CreateDatabaseDb202Response response = api.getDatabaseDb(databaseId, dbName);
        // TODO: test validations
    }

    /**
     * Get Database Usage Information
     *
     * Get disk, memory, and vCPU usage information for a Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getDatabaseUsageTest() throws ApiException {
        GetDatabaseUsage200Response response = api.getDatabaseUsage();
        // TODO: test validations
    }

    /**
     * Get Database User
     *
     * Get information about a Managed Database user.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getDatabaseUserTest() throws ApiException {
        String databaseId = null;
        String username = null;
        CreateDatabaseUser202Response response = api.getDatabaseUser(databaseId, username);
        // TODO: test validations
    }

    /**
     * List Advanced Options
     *
     * List all configured and available advanced options for the Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listAdvancedOptionsTest() throws ApiException {
        ListAdvancedOptions200Response response = api.listAdvancedOptions();
        // TODO: test validations
    }

    /**
     * List Available Versions
     *
     * List all available version upgrades within the Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listAvailableVersionsTest() throws ApiException {
        ListAvailableVersions200Response response = api.listAvailableVersions();
        // TODO: test validations
    }

    /**
     * List Connection Pools
     *
     * List all connection pools within the Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listConnectionPoolsTest() throws ApiException {
        ListConnectionPools200Response response = api.listConnectionPools();
        // TODO: test validations
    }

    /**
     * List Logical Databases
     *
     * List all logical databases within the Managed Database (MySQL and PostgreSQL only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listDatabaseDbsTest() throws ApiException {
        ListDatabaseDbs200Response response = api.listDatabaseDbs();
        // TODO: test validations
    }

    /**
     * List Managed Database Plans
     *
     * List all Managed Databases plans.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listDatabasePlansTest() throws ApiException {
        String engine = null;
        Integer nodes = null;
        String region = null;
        ListDatabasePlans200Response response = api.listDatabasePlans(engine, nodes, region);
        // TODO: test validations
    }

    /**
     * List Database Users
     *
     * List all database users within the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listDatabaseUsersTest() throws ApiException {
        ListDatabaseUsers200Response response = api.listDatabaseUsers();
        // TODO: test validations
    }

    /**
     * List Managed Databases
     *
     * List all Managed Databases in your account.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listDatabasesTest() throws ApiException {
        String label = null;
        String tag = null;
        String region = null;
        ListDatabases200Response response = api.listDatabases(label, tag, region);
        // TODO: test validations
    }

    /**
     * List Maintenance Updates
     *
     * List all available version upgrades within the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listMaintenanceUpdatesTest() throws ApiException {
        ListMaintenanceUpdates200Response response = api.listMaintenanceUpdates();
        // TODO: test validations
    }

    /**
     * List Service Alerts
     *
     * List service alert messages for the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listServiceAlertsTest() throws ApiException {
        ListServiceAlertsRequest listServiceAlertsRequest = null;
        ListServiceAlerts200Response response = api.listServiceAlerts(listServiceAlertsRequest);
        // TODO: test validations
    }

    /**
     * Set Database User Access Control
     *
     * Configure access control settings for a Managed Database user (Redis engine type only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void setDatabaseUserAclTest() throws ApiException {
        String databaseId = null;
        String username = null;
        SetDatabaseUserAclRequest setDatabaseUserAclRequest = null;
        CreateDatabaseUser202Response response = api.setDatabaseUserAcl(databaseId, username, setDatabaseUserAclRequest);
        // TODO: test validations
    }

    /**
     * Start Maintenance Updates
     *
     * Start maintenance updates for the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void startMaintenanceUpdatesTest() throws ApiException {
        StartMaintenanceUpdates200Response response = api.startMaintenanceUpdates();
        // TODO: test validations
    }

    /**
     * Start Version Upgrade
     *
     * Start a version upgrade for the Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void startVersionUpgradeTest() throws ApiException {
        StartVersionUpgradeRequest startVersionUpgradeRequest = null;
        StartVersionUpgrade200Response response = api.startVersionUpgrade(startVersionUpgradeRequest);
        // TODO: test validations
    }

    /**
     * Update Advanced Options
     *
     * Updates an advanced configuration option for the Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateAdvancedOptionsTest() throws ApiException {
        UpdateAdvancedOptionsRequest updateAdvancedOptionsRequest = null;
        ListAdvancedOptions200Response response = api.updateAdvancedOptions(updateAdvancedOptionsRequest);
        // TODO: test validations
    }

    /**
     * Update Connection Pool
     *
     * Update connection-pool information within a Managed Database (PostgreSQL engine types only).
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateConnectionPoolTest() throws ApiException {
        String databaseId = null;
        String poolName = null;
        UpdateConnectionPoolRequest updateConnectionPoolRequest = null;
        CreateConnectionPool202Response response = api.updateConnectionPool(databaseId, poolName, updateConnectionPoolRequest);
        // TODO: test validations
    }

    /**
     * Update Managed Database
     *
     * Update information for a Managed Database. All attributes are optional. If not set, the attributes will retain their original values.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateDatabaseTest() throws ApiException {
        String databaseId = null;
        UpdateDatabaseRequest updateDatabaseRequest = null;
        CreateDatabase202Response response = api.updateDatabase(databaseId, updateDatabaseRequest);
        // TODO: test validations
    }

    /**
     * Update Database User
     *
     * Update database user information within a Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateDatabaseUserTest() throws ApiException {
        String databaseId = null;
        String username = null;
        UpdateDatabaseUserRequest updateDatabaseUserRequest = null;
        CreateDatabaseUser202Response response = api.updateDatabaseUser(databaseId, username, updateDatabaseUserRequest);
        // TODO: test validations
    }

    /**
     * Get Migration Status
     *
     * View the status of a migration attached to the Managed Database.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void viewMigrationStatusTest() throws ApiException {
        ViewMigrationStatus200Response response = api.viewMigrationStatus();
        // TODO: test validations
    }

}
