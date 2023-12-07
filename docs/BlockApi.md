# BlockApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachBlock**](BlockApi.md#attachBlock) | **POST** /blocks/{block-id}/attach | Attach Block Storage |
| [**createBlock**](BlockApi.md#createBlock) | **POST** /blocks | Create Block Storage |
| [**deleteBlock**](BlockApi.md#deleteBlock) | **DELETE** /blocks/{block-id} | Delete Block Storage |
| [**detachBlock**](BlockApi.md#detachBlock) | **POST** /blocks/{block-id}/detach | Detach Block Storage |
| [**getBlock**](BlockApi.md#getBlock) | **GET** /blocks/{block-id} | Get Block Storage |
| [**listBlocks**](BlockApi.md#listBlocks) | **GET** /blocks | List Block storages |
| [**updateBlock**](BlockApi.md#updateBlock) | **PATCH** /blocks/{block-id} | Update Block Storage |


<a id="attachBlock"></a>
# **attachBlock**
> attachBlock(blockId, attachBlockRequest)

Attach Block Storage

Attach Block Storage to Instance &#x60;instance_id&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    String blockId = "blockId_example"; // String | The [Block Storage id](#operation/list-blocks).
    AttachBlockRequest attachBlockRequest = new AttachBlockRequest(); // AttachBlockRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachBlock(blockId, attachBlockRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#attachBlock");
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
| **blockId** | **String**| The [Block Storage id](#operation/list-blocks). | |
| **attachBlockRequest** | [**AttachBlockRequest**](AttachBlockRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **404** | Not Found |  -  |

<a id="createBlock"></a>
# **createBlock**
> CreateBlock202Response createBlock(createBlockRequest)

Create Block Storage

Create new Block Storage in a &#x60;region&#x60; with a size of &#x60;size_gb&#x60;. Size may range between 10 and 40000 depending on the &#x60;block_type&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    CreateBlockRequest createBlockRequest = new CreateBlockRequest(); // CreateBlockRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateBlock202Response result = apiInstance.createBlock(createBlockRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#createBlock");
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
| **createBlockRequest** | [**CreateBlockRequest**](CreateBlockRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateBlock202Response**](CreateBlock202Response.md)

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

<a id="deleteBlock"></a>
# **deleteBlock**
> deleteBlock(blockId)

Delete Block Storage

Delete Block Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    String blockId = "blockId_example"; // String | The [Block Storage id](#operation/list-blocks).
    try {
      apiInstance.deleteBlock(blockId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#deleteBlock");
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
| **blockId** | **String**| The [Block Storage id](#operation/list-blocks). | |

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

<a id="detachBlock"></a>
# **detachBlock**
> detachBlock(blockId, detachBlockRequest)

Detach Block Storage

Detach Block Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    String blockId = "blockId_example"; // String | The [Block Storage id](#operation/list-blocks).
    DetachBlockRequest detachBlockRequest = new DetachBlockRequest(); // DetachBlockRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.detachBlock(blockId, detachBlockRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#detachBlock");
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
| **blockId** | **String**| The [Block Storage id](#operation/list-blocks). | |
| **detachBlockRequest** | [**DetachBlockRequest**](DetachBlockRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **404** | Not Found |  -  |

<a id="getBlock"></a>
# **getBlock**
> CreateBlock202Response getBlock(blockId)

Get Block Storage

Get information for Block Storage.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    String blockId = "blockId_example"; // String | The [Block Storage id](#operation/list-blocks).
    try {
      CreateBlock202Response result = apiInstance.getBlock(blockId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#getBlock");
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
| **blockId** | **String**| The [Block Storage id](#operation/list-blocks). | |

### Return type

[**CreateBlock202Response**](CreateBlock202Response.md)

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

<a id="listBlocks"></a>
# **listBlocks**
> ListBlocks200Response listBlocks(perPage, cursor)

List Block storages

List all Block Storage in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListBlocks200Response result = apiInstance.listBlocks(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#listBlocks");
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

[**ListBlocks200Response**](ListBlocks200Response.md)

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
| **500** | Internal Server Error |  -  |

<a id="updateBlock"></a>
# **updateBlock**
> updateBlock(blockId, updateBlockRequest)

Update Block Storage

Update information for Block Storage. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BlockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BlockApi apiInstance = new BlockApi(defaultClient);
    String blockId = "blockId_example"; // String | The [Block Storage id](#operation/list-blocks).
    UpdateBlockRequest updateBlockRequest = new UpdateBlockRequest(); // UpdateBlockRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateBlock(blockId, updateBlockRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling BlockApi#updateBlock");
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
| **blockId** | **String**| The [Block Storage id](#operation/list-blocks). | |
| **updateBlockRequest** | [**UpdateBlockRequest**](UpdateBlockRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

