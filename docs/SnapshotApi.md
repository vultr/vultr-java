# SnapshotApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSnapshot**](SnapshotApi.md#createSnapshot) | **POST** /snapshots | Create Snapshot |
| [**createSnapshotCreateFromUrl**](SnapshotApi.md#createSnapshotCreateFromUrl) | **POST** /snapshots/create-from-url | Create Snapshot from URL |
| [**deleteSnapshot**](SnapshotApi.md#deleteSnapshot) | **DELETE** /snapshots/{snapshot-id} | Delete Snapshot |
| [**getSnapshot**](SnapshotApi.md#getSnapshot) | **GET** /snapshots/{snapshot-id} | Get Snapshot |
| [**listSnapshots**](SnapshotApi.md#listSnapshots) | **GET** /snapshots | List Snapshots |
| [**putSnapshotsSnapshotId**](SnapshotApi.md#putSnapshotsSnapshotId) | **PUT** /snapshots/{snapshot-id} | Update Snapshot |


<a id="createSnapshot"></a>
# **createSnapshot**
> GetSnapshot200Response createSnapshot(createSnapshotRequest)

Create Snapshot

Create a new Snapshot for &#x60;instance_id&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SnapshotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SnapshotApi apiInstance = new SnapshotApi(defaultClient);
    CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(); // CreateSnapshotRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetSnapshot200Response result = apiInstance.createSnapshot(createSnapshotRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SnapshotApi#createSnapshot");
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
| **createSnapshotRequest** | [**CreateSnapshotRequest**](CreateSnapshotRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetSnapshot200Response**](GetSnapshot200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |

<a id="createSnapshotCreateFromUrl"></a>
# **createSnapshotCreateFromUrl**
> GetSnapshot200Response createSnapshotCreateFromUrl(createSnapshotCreateFromUrlRequest)

Create Snapshot from URL

Create a new Snapshot from a RAW image located at &#x60;url&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SnapshotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SnapshotApi apiInstance = new SnapshotApi(defaultClient);
    CreateSnapshotCreateFromUrlRequest createSnapshotCreateFromUrlRequest = new CreateSnapshotCreateFromUrlRequest(); // CreateSnapshotCreateFromUrlRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetSnapshot200Response result = apiInstance.createSnapshotCreateFromUrl(createSnapshotCreateFromUrlRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SnapshotApi#createSnapshotCreateFromUrl");
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
| **createSnapshotCreateFromUrlRequest** | [**CreateSnapshotCreateFromUrlRequest**](CreateSnapshotCreateFromUrlRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetSnapshot200Response**](GetSnapshot200Response.md)

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

<a id="deleteSnapshot"></a>
# **deleteSnapshot**
> deleteSnapshot(snapshotId)

Delete Snapshot

Delete a Snapshot.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SnapshotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SnapshotApi apiInstance = new SnapshotApi(defaultClient);
    String snapshotId = "snapshotId_example"; // String | The [Snapshot id](#operation/list-snapshots).
    try {
      apiInstance.deleteSnapshot(snapshotId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SnapshotApi#deleteSnapshot");
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
| **snapshotId** | **String**| The [Snapshot id](#operation/list-snapshots). | |

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

<a id="getSnapshot"></a>
# **getSnapshot**
> GetSnapshot200Response getSnapshot(snapshotId)

Get Snapshot

Get information about a Snapshot.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SnapshotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SnapshotApi apiInstance = new SnapshotApi(defaultClient);
    String snapshotId = "snapshotId_example"; // String | The [Snapshot id](#operation/list-snapshots).
    try {
      GetSnapshot200Response result = apiInstance.getSnapshot(snapshotId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SnapshotApi#getSnapshot");
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
| **snapshotId** | **String**| The [Snapshot id](#operation/list-snapshots). | |

### Return type

[**GetSnapshot200Response**](GetSnapshot200Response.md)

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
| **404** | Not Found |  -  |

<a id="listSnapshots"></a>
# **listSnapshots**
> ListSnapshots200Response listSnapshots(description, perPage, cursor)

List Snapshots

Get information about all Snapshots in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SnapshotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SnapshotApi apiInstance = new SnapshotApi(defaultClient);
    String description = "description_example"; // String | Filter the list of Snapshots by `description`
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListSnapshots200Response result = apiInstance.listSnapshots(description, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SnapshotApi#listSnapshots");
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
| **description** | **String**| Filter the list of Snapshots by &#x60;description&#x60; | [optional] |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListSnapshots200Response**](ListSnapshots200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |

<a id="putSnapshotsSnapshotId"></a>
# **putSnapshotsSnapshotId**
> putSnapshotsSnapshotId(snapshotId, putSnapshotsSnapshotIdRequest)

Update Snapshot

Update the description for a Snapshot.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SnapshotApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SnapshotApi apiInstance = new SnapshotApi(defaultClient);
    String snapshotId = "snapshotId_example"; // String | The [Snapshot id](#operation/list-snapshots).
    PutSnapshotsSnapshotIdRequest putSnapshotsSnapshotIdRequest = new PutSnapshotsSnapshotIdRequest(); // PutSnapshotsSnapshotIdRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.putSnapshotsSnapshotId(snapshotId, putSnapshotsSnapshotIdRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling SnapshotApi#putSnapshotsSnapshotId");
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
| **snapshotId** | **String**| The [Snapshot id](#operation/list-snapshots). | |
| **putSnapshotsSnapshotIdRequest** | [**PutSnapshotsSnapshotIdRequest**](PutSnapshotsSnapshotIdRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

null (empty response body)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

