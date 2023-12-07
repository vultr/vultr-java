# FirewallApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createFirewallGroup**](FirewallApi.md#createFirewallGroup) | **POST** /firewalls | Create Firewall Group |
| [**deleteFirewallGroup**](FirewallApi.md#deleteFirewallGroup) | **DELETE** /firewalls/{firewall-group-id} | Delete Firewall Group |
| [**deleteFirewallGroupRule**](FirewallApi.md#deleteFirewallGroupRule) | **DELETE** /firewalls/{firewall-group-id}/rules/{firewall-rule-id} | Delete Firewall Rule |
| [**getFirewallGroup**](FirewallApi.md#getFirewallGroup) | **GET** /firewalls/{firewall-group-id} | Get Firewall Group |
| [**getFirewallGroupRule**](FirewallApi.md#getFirewallGroupRule) | **GET** /firewalls/{firewall-group-id}/rules/{firewall-rule-id} | Get Firewall Rule |
| [**listFirewallGroupRules**](FirewallApi.md#listFirewallGroupRules) | **GET** /firewalls/{firewall-group-id}/rules | List Firewall Rules |
| [**listFirewallGroups**](FirewallApi.md#listFirewallGroups) | **GET** /firewalls | List Firewall Groups |
| [**postFirewallsFirewallGroupIdRules**](FirewallApi.md#postFirewallsFirewallGroupIdRules) | **POST** /firewalls/{firewall-group-id}/rules | Create Firewall Rules |
| [**updateFirewallGroup**](FirewallApi.md#updateFirewallGroup) | **PUT** /firewalls/{firewall-group-id} | Update Firewall Group |


<a id="createFirewallGroup"></a>
# **createFirewallGroup**
> CreateFirewallGroup201Response createFirewallGroup(createFirewallGroupRequest)

Create Firewall Group

Create a new Firewall Group.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    CreateFirewallGroupRequest createFirewallGroupRequest = new CreateFirewallGroupRequest(); // CreateFirewallGroupRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateFirewallGroup201Response result = apiInstance.createFirewallGroup(createFirewallGroupRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#createFirewallGroup");
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
| **createFirewallGroupRequest** | [**CreateFirewallGroupRequest**](CreateFirewallGroupRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateFirewallGroup201Response**](CreateFirewallGroup201Response.md)

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

<a id="deleteFirewallGroup"></a>
# **deleteFirewallGroup**
> deleteFirewallGroup(firewallGroupId)

Delete Firewall Group

Delete a Firewall Group.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    try {
      apiInstance.deleteFirewallGroup(firewallGroupId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#deleteFirewallGroup");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |

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

<a id="deleteFirewallGroupRule"></a>
# **deleteFirewallGroupRule**
> deleteFirewallGroupRule(firewallGroupId, firewallRuleId)

Delete Firewall Rule

Delete a Firewall Rule.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    String firewallRuleId = "firewallRuleId_example"; // String | The [Firewall Rule id](#operation/list-firewall-group-rules).
    try {
      apiInstance.deleteFirewallGroupRule(firewallGroupId, firewallRuleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#deleteFirewallGroupRule");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |
| **firewallRuleId** | **String**| The [Firewall Rule id](#operation/list-firewall-group-rules). | |

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

<a id="getFirewallGroup"></a>
# **getFirewallGroup**
> CreateFirewallGroup201Response getFirewallGroup(firewallGroupId)

Get Firewall Group

Get information for a Firewall Group.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    try {
      CreateFirewallGroup201Response result = apiInstance.getFirewallGroup(firewallGroupId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#getFirewallGroup");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |

### Return type

[**CreateFirewallGroup201Response**](CreateFirewallGroup201Response.md)

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

<a id="getFirewallGroupRule"></a>
# **getFirewallGroupRule**
> PostFirewallsFirewallGroupIdRules201Response getFirewallGroupRule(firewallGroupId, firewallRuleId)

Get Firewall Rule

Get a Firewall Rule.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    String firewallRuleId = "firewallRuleId_example"; // String | The [Firewall Rule id](#operation/list-firewall-group-rules).
    try {
      PostFirewallsFirewallGroupIdRules201Response result = apiInstance.getFirewallGroupRule(firewallGroupId, firewallRuleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#getFirewallGroupRule");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |
| **firewallRuleId** | **String**| The [Firewall Rule id](#operation/list-firewall-group-rules). | |

### Return type

[**PostFirewallsFirewallGroupIdRules201Response**](PostFirewallsFirewallGroupIdRules201Response.md)

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

<a id="listFirewallGroupRules"></a>
# **listFirewallGroupRules**
> ListFirewallGroupRules200Response listFirewallGroupRules(firewallGroupId, perPage, cursor)

List Firewall Rules

Get the Firewall Rules for a Firewall Group.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListFirewallGroupRules200Response result = apiInstance.listFirewallGroupRules(firewallGroupId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#listFirewallGroupRules");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListFirewallGroupRules200Response**](ListFirewallGroupRules200Response.md)

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

<a id="listFirewallGroups"></a>
# **listFirewallGroups**
> ListFirewallGroups200Response listFirewallGroups(perPage, cursor)

List Firewall Groups

Get a list of all Firewall Groups.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListFirewallGroups200Response result = apiInstance.listFirewallGroups(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#listFirewallGroups");
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

[**ListFirewallGroups200Response**](ListFirewallGroups200Response.md)

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

<a id="postFirewallsFirewallGroupIdRules"></a>
# **postFirewallsFirewallGroupIdRules**
> PostFirewallsFirewallGroupIdRules201Response postFirewallsFirewallGroupIdRules(firewallGroupId, postFirewallsFirewallGroupIdRulesRequest)

Create Firewall Rules

Create a Firewall Rule for a Firewall Group. The attributes &#x60;ip_type&#x60;, &#x60;protocol&#x60;, &#x60;subnet&#x60;, and &#x60;subnet_size&#x60; are required.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    PostFirewallsFirewallGroupIdRulesRequest postFirewallsFirewallGroupIdRulesRequest = new PostFirewallsFirewallGroupIdRulesRequest(); // PostFirewallsFirewallGroupIdRulesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      PostFirewallsFirewallGroupIdRules201Response result = apiInstance.postFirewallsFirewallGroupIdRules(firewallGroupId, postFirewallsFirewallGroupIdRulesRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#postFirewallsFirewallGroupIdRules");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |
| **postFirewallsFirewallGroupIdRulesRequest** | [**PostFirewallsFirewallGroupIdRulesRequest**](PostFirewallsFirewallGroupIdRulesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**PostFirewallsFirewallGroupIdRules201Response**](PostFirewallsFirewallGroupIdRules201Response.md)

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

<a id="updateFirewallGroup"></a>
# **updateFirewallGroup**
> updateFirewallGroup(firewallGroupId, updateFirewallGroupRequest)

Update Firewall Group

Update information for a Firewall Group.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FirewallApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    FirewallApi apiInstance = new FirewallApi(defaultClient);
    String firewallGroupId = "firewallGroupId_example"; // String | The [Firewall Group id](#operation/list-firewall-groups).
    UpdateFirewallGroupRequest updateFirewallGroupRequest = new UpdateFirewallGroupRequest(); // UpdateFirewallGroupRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateFirewallGroup(firewallGroupId, updateFirewallGroupRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling FirewallApi#updateFirewallGroup");
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
| **firewallGroupId** | **String**| The [Firewall Group id](#operation/list-firewall-groups). | |
| **updateFirewallGroupRequest** | [**UpdateFirewallGroupRequest**](UpdateFirewallGroupRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

