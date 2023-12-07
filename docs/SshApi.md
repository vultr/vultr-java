# SshApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSshKey**](SshApi.md#createSshKey) | **POST** /ssh-keys | Create SSH key |
| [**deleteSshKey**](SshApi.md#deleteSshKey) | **DELETE** /ssh-keys/{ssh-key-id} | Delete SSH Key |
| [**getSshKey**](SshApi.md#getSshKey) | **GET** /ssh-keys/{ssh-key-id} | Get SSH Key |
| [**listSshKeys**](SshApi.md#listSshKeys) | **GET** /ssh-keys | List SSH Keys |
| [**updateSshKey**](SshApi.md#updateSshKey) | **PATCH** /ssh-keys/{ssh-key-id} | Update SSH Key |


<a id="createSshKey"></a>
# **createSshKey**
> GetSshKey200Response createSshKey(createSshKeyRequest)

Create SSH key

Create a new SSH Key for use with future instances. This does not update any running instances.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SshApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SshApi apiInstance = new SshApi(defaultClient);
    CreateSshKeyRequest createSshKeyRequest = new CreateSshKeyRequest(); // CreateSshKeyRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetSshKey200Response result = apiInstance.createSshKey(createSshKeyRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SshApi#createSshKey");
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
| **createSshKeyRequest** | [**CreateSshKeyRequest**](CreateSshKeyRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetSshKey200Response**](GetSshKey200Response.md)

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

<a id="deleteSshKey"></a>
# **deleteSshKey**
> deleteSshKey(sshKeyId)

Delete SSH Key

Delete an SSH Key.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SshApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SshApi apiInstance = new SshApi(defaultClient);
    String sshKeyId = "sshKeyId_example"; // String | The [SSH Key id](#operation/list-ssh-keys).
    try {
      apiInstance.deleteSshKey(sshKeyId);
    } catch (ApiException e) {
      System.err.println("Exception when calling SshApi#deleteSshKey");
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
| **sshKeyId** | **String**| The [SSH Key id](#operation/list-ssh-keys). | |

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

<a id="getSshKey"></a>
# **getSshKey**
> GetSshKey200Response getSshKey(sshKeyId)

Get SSH Key

Get information about an SSH Key.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SshApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SshApi apiInstance = new SshApi(defaultClient);
    String sshKeyId = "sshKeyId_example"; // String | The [SSH Key id](#operation/list-ssh-keys).
    try {
      GetSshKey200Response result = apiInstance.getSshKey(sshKeyId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SshApi#getSshKey");
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
| **sshKeyId** | **String**| The [SSH Key id](#operation/list-ssh-keys). | |

### Return type

[**GetSshKey200Response**](GetSshKey200Response.md)

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

<a id="listSshKeys"></a>
# **listSshKeys**
> ListSshKeys200Response listSshKeys(perPage, cursor)

List SSH Keys

List all SSH Keys in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SshApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SshApi apiInstance = new SshApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500. 
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListSshKeys200Response result = apiInstance.listSshKeys(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SshApi#listSshKeys");
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
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500.  | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListSshKeys200Response**](ListSshKeys200Response.md)

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

<a id="updateSshKey"></a>
# **updateSshKey**
> updateSshKey(sshKeyId, updateSshKeyRequest)

Update SSH Key

Update an SSH Key. The attributes &#x60;name&#x60; and &#x60;ssh_key&#x60; are optional. If not set, the attributes will retain their original values. New deployments will use the updated key, but this action does not update previously deployed instances.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SshApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    SshApi apiInstance = new SshApi(defaultClient);
    String sshKeyId = "sshKeyId_example"; // String | The [SSH Key id](#operation/list-ssh-keys).
    UpdateSshKeyRequest updateSshKeyRequest = new UpdateSshKeyRequest(); // UpdateSshKeyRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateSshKey(sshKeyId, updateSshKeyRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling SshApi#updateSshKey");
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
| **sshKeyId** | **String**| The [SSH Key id](#operation/list-ssh-keys). | |
| **updateSshKeyRequest** | [**UpdateSshKeyRequest**](UpdateSshKeyRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

