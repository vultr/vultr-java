# S3Api

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createObjectStorage**](S3Api.md#createObjectStorage) | **POST** /object-storage | Create Object Storage |
| [**deleteObjectStorage**](S3Api.md#deleteObjectStorage) | **DELETE** /object-storage/{object-storage-id} | Delete Object Storage |
| [**getObjectStorage**](S3Api.md#getObjectStorage) | **GET** /object-storage/{object-storage-id} | Get Object Storage |
| [**listObjectStorageClusters**](S3Api.md#listObjectStorageClusters) | **GET** /object-storage/clusters | Get All Clusters |
| [**listObjectStorages**](S3Api.md#listObjectStorages) | **GET** /object-storage | List Object Storages |
| [**regenerateObjectStorageKeys**](S3Api.md#regenerateObjectStorageKeys) | **POST** /object-storage/{object-storage-id}/regenerate-keys | Regenerate Object Storage Keys |
| [**updateObjectStorage**](S3Api.md#updateObjectStorage) | **PUT** /object-storage/{object-storage-id} | Update Object Storage |


<a id="createObjectStorage"></a>
# **createObjectStorage**
> CreateObjectStorage202Response createObjectStorage(createObjectStorageRequest)

Create Object Storage

Create new Object Storage. The &#x60;cluster_id&#x60; attribute is required.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    S3Api apiInstance = new S3Api(defaultClient);
    CreateObjectStorageRequest createObjectStorageRequest = new CreateObjectStorageRequest(); // CreateObjectStorageRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateObjectStorage202Response result = apiInstance.createObjectStorage(createObjectStorageRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#createObjectStorage");
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
| **createObjectStorageRequest** | [**CreateObjectStorageRequest**](CreateObjectStorageRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateObjectStorage202Response**](CreateObjectStorage202Response.md)

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

<a id="deleteObjectStorage"></a>
# **deleteObjectStorage**
> deleteObjectStorage(objectStorageId)

Delete Object Storage

Delete an Object Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    S3Api apiInstance = new S3Api(defaultClient);
    String objectStorageId = "objectStorageId_example"; // String | The [Object Storage id](#operation/list-object-storages).
    try {
      apiInstance.deleteObjectStorage(objectStorageId);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#deleteObjectStorage");
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
| **objectStorageId** | **String**| The [Object Storage id](#operation/list-object-storages). | |

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

<a id="getObjectStorage"></a>
# **getObjectStorage**
> CreateObjectStorage202Response getObjectStorage(objectStorageId)

Get Object Storage

Get information about an Object Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    S3Api apiInstance = new S3Api(defaultClient);
    String objectStorageId = "objectStorageId_example"; // String | The [Object Storage id](#operation/list-object-storages).
    try {
      CreateObjectStorage202Response result = apiInstance.getObjectStorage(objectStorageId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#getObjectStorage");
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
| **objectStorageId** | **String**| The [Object Storage id](#operation/list-object-storages). | |

### Return type

[**CreateObjectStorage202Response**](CreateObjectStorage202Response.md)

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

<a id="listObjectStorageClusters"></a>
# **listObjectStorageClusters**
> ListObjectStorageClusters200Response listObjectStorageClusters(perPage, cursor)

Get All Clusters

Get a list of all Object Storage Clusters.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    S3Api apiInstance = new S3Api(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListObjectStorageClusters200Response result = apiInstance.listObjectStorageClusters(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#listObjectStorageClusters");
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
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListObjectStorageClusters200Response**](ListObjectStorageClusters200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="listObjectStorages"></a>
# **listObjectStorages**
> ListObjectStorages200Response listObjectStorages(perPage, cursor)

List Object Storages

Get a list of all Object Storage in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    S3Api apiInstance = new S3Api(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListObjectStorages200Response result = apiInstance.listObjectStorages(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#listObjectStorages");
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
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListObjectStorages200Response**](ListObjectStorages200Response.md)

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

<a id="regenerateObjectStorageKeys"></a>
# **regenerateObjectStorageKeys**
> RegenerateObjectStorageKeys201Response regenerateObjectStorageKeys(objectStorageId)

Regenerate Object Storage Keys

Regenerate the keys for an Object Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    S3Api apiInstance = new S3Api(defaultClient);
    String objectStorageId = "objectStorageId_example"; // String | The [Object Storage id](#operation/list-object-storages).
    try {
      RegenerateObjectStorageKeys201Response result = apiInstance.regenerateObjectStorageKeys(objectStorageId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#regenerateObjectStorageKeys");
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
| **objectStorageId** | **String**| The [Object Storage id](#operation/list-object-storages). | |

### Return type

[**RegenerateObjectStorageKeys201Response**](RegenerateObjectStorageKeys201Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="updateObjectStorage"></a>
# **updateObjectStorage**
> updateObjectStorage(objectStorageId, updateObjectStorageRequest)

Update Object Storage

Update the label for an Object Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.S3Api;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    S3Api apiInstance = new S3Api(defaultClient);
    String objectStorageId = "objectStorageId_example"; // String | The [Object Storage id](#operation/list-object-storages).
    UpdateObjectStorageRequest updateObjectStorageRequest = new UpdateObjectStorageRequest(); // UpdateObjectStorageRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateObjectStorage(objectStorageId, updateObjectStorageRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling S3Api#updateObjectStorage");
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
| **objectStorageId** | **String**| The [Object Storage id](#operation/list-object-storages). | |
| **updateObjectStorageRequest** | [**UpdateObjectStorageRequest**](UpdateObjectStorageRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

