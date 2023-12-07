# ManagedDatabasesApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createConnectionPool**](ManagedDatabasesApi.md#createConnectionPool) | **POST** /databases/{database-id}/connection-pools | Create Connection Pool |
| [**createDatabase**](ManagedDatabasesApi.md#createDatabase) | **POST** /databases | Create Managed Database |
| [**createDatabaseDb**](ManagedDatabasesApi.md#createDatabaseDb) | **POST** /databases/{database-id}/dbs | Create Logical Database |
| [**createDatabaseUser**](ManagedDatabasesApi.md#createDatabaseUser) | **POST** /databases/{database-id}/users | Create Database User |
| [**databaseAddReadReplica**](ManagedDatabasesApi.md#databaseAddReadReplica) | **POST** /databases/{database-id}/read-replica | Add Read-Only Replica |
| [**databaseDetachMigration**](ManagedDatabasesApi.md#databaseDetachMigration) | **DELETE** /databases/{database-id}/migration | Detach Migration |
| [**databaseFork**](ManagedDatabasesApi.md#databaseFork) | **POST** /databases/{database-id}/fork | Fork Managed Database |
| [**databasePromoteReadReplica**](ManagedDatabasesApi.md#databasePromoteReadReplica) | **POST** /databases/{database-id}/promote-read-replica | Promote Read-Only Replica |
| [**databaseRestoreFromBackup**](ManagedDatabasesApi.md#databaseRestoreFromBackup) | **POST** /databases/{database-id}/restore | Restore from Backup |
| [**databaseStartMigration**](ManagedDatabasesApi.md#databaseStartMigration) | **POST** /databases/{database-id}/migration | Start Migration |
| [**deleteConnectionPool**](ManagedDatabasesApi.md#deleteConnectionPool) | **DELETE** /databases/{database-id}/connection-pools/{pool-name} | Delete Connection Pool |
| [**deleteDatabase**](ManagedDatabasesApi.md#deleteDatabase) | **DELETE** /databases/{database-id} | Delete Managed Database |
| [**deleteDatabaseDb**](ManagedDatabasesApi.md#deleteDatabaseDb) | **DELETE** /databases/{database-id}/dbs/{db-name} | Delete Logical Database |
| [**deleteDatabaseUser**](ManagedDatabasesApi.md#deleteDatabaseUser) | **DELETE** /databases/{database-id}/users/{username} | Delete Database User |
| [**getBackupInformation**](ManagedDatabasesApi.md#getBackupInformation) | **GET** /databases/{database-id}/backups | Get Backup Information |
| [**getConnectionPool**](ManagedDatabasesApi.md#getConnectionPool) | **GET** /databases/{database-id}/connection-pools/{pool-name} | Get Connection Pool |
| [**getDatabase**](ManagedDatabasesApi.md#getDatabase) | **GET** /databases/{database-id} | Get Managed Database |
| [**getDatabaseDb**](ManagedDatabasesApi.md#getDatabaseDb) | **GET** /databases/{database-id}/dbs/{db-name} | Get Logical Database |
| [**getDatabaseUsage**](ManagedDatabasesApi.md#getDatabaseUsage) | **GET** /databases/{database-id}/usage | Get Database Usage Information |
| [**getDatabaseUser**](ManagedDatabasesApi.md#getDatabaseUser) | **GET** /databases/{database-id}/users/{username} | Get Database User |
| [**listAdvancedOptions**](ManagedDatabasesApi.md#listAdvancedOptions) | **GET** /databases/{database-id}/advanced-options | List Advanced Options |
| [**listAvailableVersions**](ManagedDatabasesApi.md#listAvailableVersions) | **GET** /databases/{database-id}/version-upgrade | List Available Versions |
| [**listConnectionPools**](ManagedDatabasesApi.md#listConnectionPools) | **GET** /databases/{database-id}/connection-pools | List Connection Pools |
| [**listDatabaseDbs**](ManagedDatabasesApi.md#listDatabaseDbs) | **GET** /databases/{database-id}/dbs | List Logical Databases |
| [**listDatabasePlans**](ManagedDatabasesApi.md#listDatabasePlans) | **GET** /databases/plans | List Managed Database Plans |
| [**listDatabaseUsers**](ManagedDatabasesApi.md#listDatabaseUsers) | **GET** /databases/{database-id}/users | List Database Users |
| [**listDatabases**](ManagedDatabasesApi.md#listDatabases) | **GET** /databases | List Managed Databases |
| [**listMaintenanceUpdates**](ManagedDatabasesApi.md#listMaintenanceUpdates) | **GET** /databases/{database-id}/maintenance | List Maintenance Updates |
| [**listServiceAlerts**](ManagedDatabasesApi.md#listServiceAlerts) | **POST** /databases/{database-id}/alerts | List Service Alerts |
| [**setDatabaseUserAcl**](ManagedDatabasesApi.md#setDatabaseUserAcl) | **PUT** /databases/{database-id}/users/{username}/access-control | Set Database User Access Control |
| [**startMaintenanceUpdates**](ManagedDatabasesApi.md#startMaintenanceUpdates) | **POST** /databases/{database-id}/maintenance | Start Maintenance Updates |
| [**startVersionUpgrade**](ManagedDatabasesApi.md#startVersionUpgrade) | **POST** /databases/{database-id}/version-upgrade | Start Version Upgrade |
| [**updateAdvancedOptions**](ManagedDatabasesApi.md#updateAdvancedOptions) | **PUT** /databases/{database-id}/advanced-options | Update Advanced Options |
| [**updateConnectionPool**](ManagedDatabasesApi.md#updateConnectionPool) | **PUT** /databases/{database-id}/connection-pools/{pool-name} | Update Connection Pool |
| [**updateDatabase**](ManagedDatabasesApi.md#updateDatabase) | **PUT** /databases/{database-id} | Update Managed Database |
| [**updateDatabaseUser**](ManagedDatabasesApi.md#updateDatabaseUser) | **PUT** /databases/{database-id}/users/{username} | Update Database User |
| [**viewMigrationStatus**](ManagedDatabasesApi.md#viewMigrationStatus) | **GET** /databases/{database-id}/migration | Get Migration Status |


<a id="createConnectionPool"></a>
# **createConnectionPool**
> CreateConnectionPool202Response createConnectionPool(createConnectionPoolRequest)

Create Connection Pool

Create a new connection pool within the Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    CreateConnectionPoolRequest createConnectionPoolRequest = new CreateConnectionPoolRequest(); // CreateConnectionPoolRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateConnectionPool202Response result = apiInstance.createConnectionPool(createConnectionPoolRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#createConnectionPool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createConnectionPoolRequest** | [**CreateConnectionPoolRequest**](CreateConnectionPoolRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateConnectionPool202Response**](CreateConnectionPool202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="createDatabase"></a>
# **createDatabase**
> CreateDatabase202Response createDatabase(createDatabaseRequest)

Create Managed Database

Create a new Managed Database in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Supply optional attributes as desired.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    CreateDatabaseRequest createDatabaseRequest = new CreateDatabaseRequest(); // CreateDatabaseRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabase202Response result = apiInstance.createDatabase(createDatabaseRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#createDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createDatabaseRequest** | [**CreateDatabaseRequest**](CreateDatabaseRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabase202Response**](CreateDatabase202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="createDatabaseDb"></a>
# **createDatabaseDb**
> CreateDatabaseDb202Response createDatabaseDb(createDatabaseDbRequest)

Create Logical Database

Create a new logical database within the Managed Database (MySQL and PostgreSQL only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    CreateDatabaseDbRequest createDatabaseDbRequest = new CreateDatabaseDbRequest(); // CreateDatabaseDbRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabaseDb202Response result = apiInstance.createDatabaseDb(createDatabaseDbRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#createDatabaseDb");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createDatabaseDbRequest** | [**CreateDatabaseDbRequest**](CreateDatabaseDbRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabaseDb202Response**](CreateDatabaseDb202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="createDatabaseUser"></a>
# **createDatabaseUser**
> CreateDatabaseUser202Response createDatabaseUser(createDatabaseUserRequest)

Create Database User

Create a new database user within the Managed Database. Supply optional attributes as desired.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    CreateDatabaseUserRequest createDatabaseUserRequest = new CreateDatabaseUserRequest(); // CreateDatabaseUserRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabaseUser202Response result = apiInstance.createDatabaseUser(createDatabaseUserRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#createDatabaseUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createDatabaseUserRequest** | [**CreateDatabaseUserRequest**](CreateDatabaseUserRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabaseUser202Response**](CreateDatabaseUser202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="databaseAddReadReplica"></a>
# **databaseAddReadReplica**
> CreateDatabase202Response databaseAddReadReplica(databaseAddReadReplicaRequest)

Add Read-Only Replica

Create a read-only replica node for the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    DatabaseAddReadReplicaRequest databaseAddReadReplicaRequest = new DatabaseAddReadReplicaRequest(); // DatabaseAddReadReplicaRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabase202Response result = apiInstance.databaseAddReadReplica(databaseAddReadReplicaRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#databaseAddReadReplica");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseAddReadReplicaRequest** | [**DatabaseAddReadReplicaRequest**](DatabaseAddReadReplicaRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabase202Response**](CreateDatabase202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="databaseDetachMigration"></a>
# **databaseDetachMigration**
> databaseDetachMigration()

Detach Migration

Detach a migration from the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      apiInstance.databaseDetachMigration();
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#databaseDetachMigration");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="databaseFork"></a>
# **databaseFork**
> CreateDatabase202Response databaseFork(databaseForkRequest)

Fork Managed Database

Fork a Managed Database to a new subscription from a backup.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    DatabaseForkRequest databaseForkRequest = new DatabaseForkRequest(); // DatabaseForkRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabase202Response result = apiInstance.databaseFork(databaseForkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#databaseFork");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseForkRequest** | [**DatabaseForkRequest**](DatabaseForkRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabase202Response**](CreateDatabase202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="databasePromoteReadReplica"></a>
# **databasePromoteReadReplica**
> databasePromoteReadReplica()

Promote Read-Only Replica

Promote a read-only replica node to its own primary Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      apiInstance.databasePromoteReadReplica();
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#databasePromoteReadReplica");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="databaseRestoreFromBackup"></a>
# **databaseRestoreFromBackup**
> CreateDatabase202Response databaseRestoreFromBackup(databaseRestoreFromBackupRequest)

Restore from Backup

Create a new Managed Database from a backup.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    DatabaseRestoreFromBackupRequest databaseRestoreFromBackupRequest = new DatabaseRestoreFromBackupRequest(); // DatabaseRestoreFromBackupRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabase202Response result = apiInstance.databaseRestoreFromBackup(databaseRestoreFromBackupRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#databaseRestoreFromBackup");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseRestoreFromBackupRequest** | [**DatabaseRestoreFromBackupRequest**](DatabaseRestoreFromBackupRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabase202Response**](CreateDatabase202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="databaseStartMigration"></a>
# **databaseStartMigration**
> ViewMigrationStatus200Response databaseStartMigration(databaseStartMigrationRequest)

Start Migration

Start a migration to the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    DatabaseStartMigrationRequest databaseStartMigrationRequest = new DatabaseStartMigrationRequest(); // DatabaseStartMigrationRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      ViewMigrationStatus200Response result = apiInstance.databaseStartMigration(databaseStartMigrationRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#databaseStartMigration");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseStartMigrationRequest** | [**DatabaseStartMigrationRequest**](DatabaseStartMigrationRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**ViewMigrationStatus200Response**](ViewMigrationStatus200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="deleteConnectionPool"></a>
# **deleteConnectionPool**
> deleteConnectionPool(databaseId, poolName)

Delete Connection Pool

Delete a connection pool within a Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String poolName = "poolName_example"; // String | The [connection pool name](#operation/list-connection-pools).
    try {
      apiInstance.deleteConnectionPool(databaseId, poolName);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#deleteConnectionPool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **poolName** | **String**| The [connection pool name](#operation/list-connection-pools). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteDatabase"></a>
# **deleteDatabase**
> deleteDatabase(databaseId)

Delete Managed Database

Delete a Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    try {
      apiInstance.deleteDatabase(databaseId);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#deleteDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteDatabaseDb"></a>
# **deleteDatabaseDb**
> deleteDatabaseDb(databaseId, dbName)

Delete Logical Database

Delete a logical database within a Managed Database (MySQL and PostgreSQL only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String dbName = "dbName_example"; // String | The [logical database name](#operation/list-database-dbs).
    try {
      apiInstance.deleteDatabaseDb(databaseId, dbName);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#deleteDatabaseDb");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **dbName** | **String**| The [logical database name](#operation/list-database-dbs). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="deleteDatabaseUser"></a>
# **deleteDatabaseUser**
> deleteDatabaseUser(databaseId, username)

Delete Database User

Delete a database user within a Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String username = "username_example"; // String | The [database user](#operation/list-database-users).
    try {
      apiInstance.deleteDatabaseUser(databaseId, username);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#deleteDatabaseUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **username** | **String**| The [database user](#operation/list-database-users). | |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="getBackupInformation"></a>
# **getBackupInformation**
> GetBackupInformation200Response getBackupInformation()

Get Backup Information

Get backup information for the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      GetBackupInformation200Response result = apiInstance.getBackupInformation();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#getBackupInformation");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetBackupInformation200Response**](GetBackupInformation200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="getConnectionPool"></a>
# **getConnectionPool**
> CreateConnectionPool202Response getConnectionPool(databaseId, poolName)

Get Connection Pool

Get information about a Managed Database connection pool (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String poolName = "poolName_example"; // String | The [connection pool name](#operation/list-connection-pools).
    try {
      CreateConnectionPool202Response result = apiInstance.getConnectionPool(databaseId, poolName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#getConnectionPool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **poolName** | **String**| The [connection pool name](#operation/list-connection-pools). | |

### Return type

[**CreateConnectionPool202Response**](CreateConnectionPool202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="getDatabase"></a>
# **getDatabase**
> CreateDatabase202Response getDatabase(databaseId)

Get Managed Database

Get information about a Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    try {
      CreateDatabase202Response result = apiInstance.getDatabase(databaseId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#getDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |

### Return type

[**CreateDatabase202Response**](CreateDatabase202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="getDatabaseDb"></a>
# **getDatabaseDb**
> CreateDatabaseDb202Response getDatabaseDb(databaseId, dbName)

Get Logical Database

Get information about a logical database within a Managed Database (MySQL and PostgreSQL only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String dbName = "dbName_example"; // String | The [logical database name](#operation/list-database-dbs).
    try {
      CreateDatabaseDb202Response result = apiInstance.getDatabaseDb(databaseId, dbName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#getDatabaseDb");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **dbName** | **String**| The [logical database name](#operation/list-database-dbs). | |

### Return type

[**CreateDatabaseDb202Response**](CreateDatabaseDb202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="getDatabaseUsage"></a>
# **getDatabaseUsage**
> GetDatabaseUsage200Response getDatabaseUsage()

Get Database Usage Information

Get disk, memory, and vCPU usage information for a Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      GetDatabaseUsage200Response result = apiInstance.getDatabaseUsage();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#getDatabaseUsage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetDatabaseUsage200Response**](GetDatabaseUsage200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="getDatabaseUser"></a>
# **getDatabaseUser**
> CreateDatabaseUser202Response getDatabaseUser(databaseId, username)

Get Database User

Get information about a Managed Database user.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String username = "username_example"; // String | The [database user](#operation/list-database-users).
    try {
      CreateDatabaseUser202Response result = apiInstance.getDatabaseUser(databaseId, username);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#getDatabaseUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **username** | **String**| The [database user](#operation/list-database-users). | |

### Return type

[**CreateDatabaseUser202Response**](CreateDatabaseUser202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listAdvancedOptions"></a>
# **listAdvancedOptions**
> ListAdvancedOptions200Response listAdvancedOptions()

List Advanced Options

List all configured and available advanced options for the Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ListAdvancedOptions200Response result = apiInstance.listAdvancedOptions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listAdvancedOptions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListAdvancedOptions200Response**](ListAdvancedOptions200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listAvailableVersions"></a>
# **listAvailableVersions**
> ListAvailableVersions200Response listAvailableVersions()

List Available Versions

List all available version upgrades within the Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ListAvailableVersions200Response result = apiInstance.listAvailableVersions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listAvailableVersions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListAvailableVersions200Response**](ListAvailableVersions200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listConnectionPools"></a>
# **listConnectionPools**
> ListConnectionPools200Response listConnectionPools()

List Connection Pools

List all connection pools within the Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ListConnectionPools200Response result = apiInstance.listConnectionPools();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listConnectionPools");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListConnectionPools200Response**](ListConnectionPools200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listDatabaseDbs"></a>
# **listDatabaseDbs**
> ListDatabaseDbs200Response listDatabaseDbs()

List Logical Databases

List all logical databases within the Managed Database (MySQL and PostgreSQL only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ListDatabaseDbs200Response result = apiInstance.listDatabaseDbs();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listDatabaseDbs");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListDatabaseDbs200Response**](ListDatabaseDbs200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listDatabasePlans"></a>
# **listDatabasePlans**
> ListDatabasePlans200Response listDatabasePlans(engine, nodes, region)

List Managed Database Plans

List all Managed Databases plans.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String engine = "engine_example"; // String | Filter by engine type  * `mysql` * `pg` * `redis`.
    Integer nodes = 56; // Integer | Filter by number of nodes.
    String region = "region_example"; // String | Filter by [Region id](#operation/list-regions).
    try {
      ListDatabasePlans200Response result = apiInstance.listDatabasePlans(engine, nodes, region);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listDatabasePlans");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **engine** | **String**| Filter by engine type  * &#x60;mysql&#x60; * &#x60;pg&#x60; * &#x60;redis&#x60;. | [optional] |
| **nodes** | **Integer**| Filter by number of nodes. | [optional] |
| **region** | **String**| Filter by [Region id](#operation/list-regions). | [optional] |

### Return type

[**ListDatabasePlans200Response**](ListDatabasePlans200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listDatabaseUsers"></a>
# **listDatabaseUsers**
> ListDatabaseUsers200Response listDatabaseUsers()

List Database Users

List all database users within the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ListDatabaseUsers200Response result = apiInstance.listDatabaseUsers();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listDatabaseUsers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListDatabaseUsers200Response**](ListDatabaseUsers200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listDatabases"></a>
# **listDatabases**
> ListDatabases200Response listDatabases(label, tag, region)

List Managed Databases

List all Managed Databases in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String label = "label_example"; // String | Filter by label.
    String tag = "tag_example"; // String | Filter by specific tag.
    String region = "region_example"; // String | Filter by [Region id](#operation/list-regions).
    try {
      ListDatabases200Response result = apiInstance.listDatabases(label, tag, region);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listDatabases");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **label** | **String**| Filter by label. | [optional] |
| **tag** | **String**| Filter by specific tag. | [optional] |
| **region** | **String**| Filter by [Region id](#operation/list-regions). | [optional] |

### Return type

[**ListDatabases200Response**](ListDatabases200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listMaintenanceUpdates"></a>
# **listMaintenanceUpdates**
> ListMaintenanceUpdates200Response listMaintenanceUpdates()

List Maintenance Updates

List all available version upgrades within the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ListMaintenanceUpdates200Response result = apiInstance.listMaintenanceUpdates();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listMaintenanceUpdates");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ListMaintenanceUpdates200Response**](ListMaintenanceUpdates200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="listServiceAlerts"></a>
# **listServiceAlerts**
> ListServiceAlerts200Response listServiceAlerts(listServiceAlertsRequest)

List Service Alerts

List service alert messages for the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    ListServiceAlertsRequest listServiceAlertsRequest = new ListServiceAlertsRequest(); // ListServiceAlertsRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      ListServiceAlerts200Response result = apiInstance.listServiceAlerts(listServiceAlertsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#listServiceAlerts");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **listServiceAlertsRequest** | [**ListServiceAlertsRequest**](ListServiceAlertsRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**ListServiceAlerts200Response**](ListServiceAlerts200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="setDatabaseUserAcl"></a>
# **setDatabaseUserAcl**
> CreateDatabaseUser202Response setDatabaseUserAcl(databaseId, username, setDatabaseUserAclRequest)

Set Database User Access Control

Configure access control settings for a Managed Database user (Redis engine type only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String username = "username_example"; // String | The [database user](#operation/list-database-users).
    SetDatabaseUserAclRequest setDatabaseUserAclRequest = new SetDatabaseUserAclRequest(); // SetDatabaseUserAclRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabaseUser202Response result = apiInstance.setDatabaseUserAcl(databaseId, username, setDatabaseUserAclRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#setDatabaseUserAcl");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **username** | **String**| The [database user](#operation/list-database-users). | |
| **setDatabaseUserAclRequest** | [**SetDatabaseUserAclRequest**](SetDatabaseUserAclRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabaseUser202Response**](CreateDatabaseUser202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="startMaintenanceUpdates"></a>
# **startMaintenanceUpdates**
> StartMaintenanceUpdates200Response startMaintenanceUpdates()

Start Maintenance Updates

Start maintenance updates for the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      StartMaintenanceUpdates200Response result = apiInstance.startMaintenanceUpdates();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#startMaintenanceUpdates");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**StartMaintenanceUpdates200Response**](StartMaintenanceUpdates200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="startVersionUpgrade"></a>
# **startVersionUpgrade**
> StartVersionUpgrade200Response startVersionUpgrade(startVersionUpgradeRequest)

Start Version Upgrade

Start a version upgrade for the Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    StartVersionUpgradeRequest startVersionUpgradeRequest = new StartVersionUpgradeRequest(); // StartVersionUpgradeRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      StartVersionUpgrade200Response result = apiInstance.startVersionUpgrade(startVersionUpgradeRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#startVersionUpgrade");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **startVersionUpgradeRequest** | [**StartVersionUpgradeRequest**](StartVersionUpgradeRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**StartVersionUpgrade200Response**](StartVersionUpgrade200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="updateAdvancedOptions"></a>
# **updateAdvancedOptions**
> ListAdvancedOptions200Response updateAdvancedOptions(updateAdvancedOptionsRequest)

Update Advanced Options

Updates an advanced configuration option for the Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    UpdateAdvancedOptionsRequest updateAdvancedOptionsRequest = new UpdateAdvancedOptionsRequest(); // UpdateAdvancedOptionsRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      ListAdvancedOptions200Response result = apiInstance.updateAdvancedOptions(updateAdvancedOptionsRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#updateAdvancedOptions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **updateAdvancedOptionsRequest** | [**UpdateAdvancedOptionsRequest**](UpdateAdvancedOptionsRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**ListAdvancedOptions200Response**](ListAdvancedOptions200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="updateConnectionPool"></a>
# **updateConnectionPool**
> CreateConnectionPool202Response updateConnectionPool(databaseId, poolName, updateConnectionPoolRequest)

Update Connection Pool

Update connection-pool information within a Managed Database (PostgreSQL engine types only).

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String poolName = "poolName_example"; // String | The [connection pool name](#operation/list-connection-pools).
    UpdateConnectionPoolRequest updateConnectionPoolRequest = new UpdateConnectionPoolRequest(); // UpdateConnectionPoolRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateConnectionPool202Response result = apiInstance.updateConnectionPool(databaseId, poolName, updateConnectionPoolRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#updateConnectionPool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **poolName** | **String**| The [connection pool name](#operation/list-connection-pools). | |
| **updateConnectionPoolRequest** | [**UpdateConnectionPoolRequest**](UpdateConnectionPoolRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateConnectionPool202Response**](CreateConnectionPool202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="updateDatabase"></a>
# **updateDatabase**
> CreateDatabase202Response updateDatabase(databaseId, updateDatabaseRequest)

Update Managed Database

Update information for a Managed Database. All attributes are optional. If not set, the attributes will retain their original values.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    UpdateDatabaseRequest updateDatabaseRequest = new UpdateDatabaseRequest(); // UpdateDatabaseRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabase202Response result = apiInstance.updateDatabase(databaseId, updateDatabaseRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#updateDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **updateDatabaseRequest** | [**UpdateDatabaseRequest**](UpdateDatabaseRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabase202Response**](CreateDatabase202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="updateDatabaseUser"></a>
# **updateDatabaseUser**
> CreateDatabaseUser202Response updateDatabaseUser(databaseId, username, updateDatabaseUserRequest)

Update Database User

Update database user information within a Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    String databaseId = "databaseId_example"; // String | The [Managed Database ID](#operation/list-databases).
    String username = "username_example"; // String | The [database user](#operation/list-database-users).
    UpdateDatabaseUserRequest updateDatabaseUserRequest = new UpdateDatabaseUserRequest(); // UpdateDatabaseUserRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDatabaseUser202Response result = apiInstance.updateDatabaseUser(databaseId, username, updateDatabaseUserRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#updateDatabaseUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **String**| The [Managed Database ID](#operation/list-databases). | |
| **username** | **String**| The [database user](#operation/list-database-users). | |
| **updateDatabaseUserRequest** | [**UpdateDatabaseUserRequest**](UpdateDatabaseUserRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDatabaseUser202Response**](CreateDatabaseUser202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |
| **422** | Validation Error |  -  |

<a id="viewMigrationStatus"></a>
# **viewMigrationStatus**
> ViewMigrationStatus200Response viewMigrationStatus()

Get Migration Status

View the status of a migration attached to the Managed Database.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ManagedDatabasesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    ManagedDatabasesApi apiInstance = new ManagedDatabasesApi(defaultClient);
    try {
      ViewMigrationStatus200Response result = apiInstance.viewMigrationStatus();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ManagedDatabasesApi#viewMigrationStatus");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ViewMigrationStatus200Response**](ViewMigrationStatus200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

