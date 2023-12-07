# PrivateNetworksApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNetwork**](PrivateNetworksApi.md#createNetwork) | **POST** /private-networks | Create a Private Network |
| [**deleteNetwork**](PrivateNetworksApi.md#deleteNetwork) | **DELETE** /private-networks/{network-id} | Delete a private network |
| [**getNetwork**](PrivateNetworksApi.md#getNetwork) | **GET** /private-networks/{network-id} | Get a private network |
| [**listNetworks**](PrivateNetworksApi.md#listNetworks) | **GET** /private-networks | List Private Networks |
| [**updateNetwork**](PrivateNetworksApi.md#updateNetwork) | **PUT** /private-networks/{network-id} | Update a Private Network |


<a id="createNetwork"></a>
# **createNetwork**
> GetNetwork200Response createNetwork(createNetworkRequest)

Create a Private Network

Create a new Private Network in a &#x60;region&#x60;.  **Deprecated**: Use [Create VPC](#operation/create-vpc) instead.      Private networks should use [RFC1918 private address space](https://tools.ietf.org/html/rfc1918):      10.0.0.0    - 10.255.255.255  (10/8 prefix)     172.16.0.0  - 172.31.255.255  (172.16/12 prefix)     192.168.0.0 - 192.168.255.255 (192.168/16 prefix) 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateNetworksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    PrivateNetworksApi apiInstance = new PrivateNetworksApi(defaultClient);
    CreateNetworkRequest createNetworkRequest = new CreateNetworkRequest(); // CreateNetworkRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetNetwork200Response result = apiInstance.createNetwork(createNetworkRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateNetworksApi#createNetwork");
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
| **createNetworkRequest** | [**CreateNetworkRequest**](CreateNetworkRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetNetwork200Response**](GetNetwork200Response.md)

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
| **404** | Not Found |  -  |

<a id="deleteNetwork"></a>
# **deleteNetwork**
> deleteNetwork(networkId)

Delete a private network

Delete a Private Network.&lt;br&gt;&lt;br&gt;**Deprecated**: Use [Delete VPC](#operation/delete-vpc) instead.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateNetworksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    PrivateNetworksApi apiInstance = new PrivateNetworksApi(defaultClient);
    String networkId = "networkId_example"; // String | The [Network id](#operation/list-networks).
    try {
      apiInstance.deleteNetwork(networkId);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateNetworksApi#deleteNetwork");
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
| **networkId** | **String**| The [Network id](#operation/list-networks). | |

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

<a id="getNetwork"></a>
# **getNetwork**
> GetNetwork200Response getNetwork(networkId)

Get a private network

Get information about a Private Network.&lt;br&gt;&lt;br&gt;**Deprecated**: Use [Get VPC](#operation/get-vpc) instead. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateNetworksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    PrivateNetworksApi apiInstance = new PrivateNetworksApi(defaultClient);
    String networkId = "networkId_example"; // String | The [Network id](#operation/list-networks).
    try {
      GetNetwork200Response result = apiInstance.getNetwork(networkId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateNetworksApi#getNetwork");
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
| **networkId** | **String**| The [Network id](#operation/list-networks). | |

### Return type

[**GetNetwork200Response**](GetNetwork200Response.md)

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

<a id="listNetworks"></a>
# **listNetworks**
> ListNetworks200Response listNetworks(perPage, cursor)

List Private Networks

Get a list of all Private Networks in your account.&lt;br&gt;&lt;br&gt;**Deprecated**: Use [List VPCs](#operation/list-vpcs) instead.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateNetworksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    PrivateNetworksApi apiInstance = new PrivateNetworksApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListNetworks200Response result = apiInstance.listNetworks(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateNetworksApi#listNetworks");
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

[**ListNetworks200Response**](ListNetworks200Response.md)

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

<a id="updateNetwork"></a>
# **updateNetwork**
> updateNetwork(networkId, updateNetworkRequest)

Update a Private Network

Update information for a Private Network.&lt;br&gt;&lt;br&gt;**Deprecated**: Use [Update VPC](#operation/update-vpc) instead.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PrivateNetworksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    PrivateNetworksApi apiInstance = new PrivateNetworksApi(defaultClient);
    String networkId = "networkId_example"; // String | The [Network id](#operation/list-networks).
    UpdateNetworkRequest updateNetworkRequest = new UpdateNetworkRequest(); // UpdateNetworkRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateNetwork(networkId, updateNetworkRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling PrivateNetworksApi#updateNetwork");
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
| **networkId** | **String**| The [Network id](#operation/list-networks). | |
| **updateNetworkRequest** | [**UpdateNetworkRequest**](UpdateNetworkRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

