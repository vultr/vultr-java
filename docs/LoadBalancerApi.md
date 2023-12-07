# LoadBalancerApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createLoadBalancer**](LoadBalancerApi.md#createLoadBalancer) | **POST** /load-balancers | Create Load Balancer |
| [**createLoadBalancerForwardingRules**](LoadBalancerApi.md#createLoadBalancerForwardingRules) | **POST** /load-balancers/{load-balancer-id}/forwarding-rules | Create Forwarding Rule |
| [**deleteLoadBalancer**](LoadBalancerApi.md#deleteLoadBalancer) | **DELETE** /load-balancers/{load-balancer-id} | Delete Load Balancer |
| [**deleteLoadBalancerForwardingRule**](LoadBalancerApi.md#deleteLoadBalancerForwardingRule) | **DELETE** /load-balancers/{load-balancer-id}/forwarding-rules/{forwarding-rule-id} | Delete Forwarding Rule |
| [**deleteLoadBalancerSsl**](LoadBalancerApi.md#deleteLoadBalancerSsl) | **DELETE** /load-balancers/{load-balancer-id}/ssl | Delete Load Balancer SSL |
| [**getLoadBalancer**](LoadBalancerApi.md#getLoadBalancer) | **GET** /load-balancers/{load-balancer-id} | Get Load Balancer |
| [**getLoadBalancerForwardingRule**](LoadBalancerApi.md#getLoadBalancerForwardingRule) | **GET** /load-balancers/{load-balancer-id}/forwarding-rules/{forwarding-rule-id} | Get Forwarding Rule |
| [**getLoadbalancerFirewallRule**](LoadBalancerApi.md#getLoadbalancerFirewallRule) | **GET** /load-balancers/{loadbalancer-id}/firewall-rules/{firewall-rule-id} | Get Firewall Rule |
| [**listLoadBalancerForwardingRules**](LoadBalancerApi.md#listLoadBalancerForwardingRules) | **GET** /load-balancers/{load-balancer-id}/forwarding-rules | List Forwarding Rules |
| [**listLoadBalancers**](LoadBalancerApi.md#listLoadBalancers) | **GET** /load-balancers | List Load Balancers |
| [**listLoadbalancerFirewallRules**](LoadBalancerApi.md#listLoadbalancerFirewallRules) | **GET** /load-balancers/{loadbalancer-id}/firewall-rules | List Firewall Rules |
| [**updateLoadBalancer**](LoadBalancerApi.md#updateLoadBalancer) | **PATCH** /load-balancers/{load-balancer-id} | Update Load Balancer |


<a id="createLoadBalancer"></a>
# **createLoadBalancer**
> CreateLoadBalancer202Response createLoadBalancer(createLoadBalancerRequest)

Create Load Balancer

Create a new Load Balancer in a particular &#x60;region&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    CreateLoadBalancerRequest createLoadBalancerRequest = new CreateLoadBalancerRequest(); // CreateLoadBalancerRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateLoadBalancer202Response result = apiInstance.createLoadBalancer(createLoadBalancerRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#createLoadBalancer");
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
| **createLoadBalancerRequest** | [**CreateLoadBalancerRequest**](CreateLoadBalancerRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateLoadBalancer202Response**](CreateLoadBalancer202Response.md)

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

<a id="createLoadBalancerForwardingRules"></a>
# **createLoadBalancerForwardingRules**
> createLoadBalancerForwardingRules(loadBalancerId, createLoadBalancerForwardingRulesRequest)

Create Forwarding Rule

Create a new forwarding rule for a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    CreateLoadBalancerForwardingRulesRequest createLoadBalancerForwardingRulesRequest = new CreateLoadBalancerForwardingRulesRequest(); // CreateLoadBalancerForwardingRulesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.createLoadBalancerForwardingRules(loadBalancerId, createLoadBalancerForwardingRulesRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#createLoadBalancerForwardingRules");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |
| **createLoadBalancerForwardingRulesRequest** | [**CreateLoadBalancerForwardingRulesRequest**](CreateLoadBalancerForwardingRulesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="deleteLoadBalancer"></a>
# **deleteLoadBalancer**
> deleteLoadBalancer(loadBalancerId)

Delete Load Balancer

Delete a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    try {
      apiInstance.deleteLoadBalancer(loadBalancerId);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#deleteLoadBalancer");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |

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

<a id="deleteLoadBalancerForwardingRule"></a>
# **deleteLoadBalancerForwardingRule**
> deleteLoadBalancerForwardingRule(loadBalancerId, forwardingRuleId)

Delete Forwarding Rule

Delete a Forwarding Rule on a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    String forwardingRuleId = "forwardingRuleId_example"; // String | The [Forwarding Rule id](#operation/list-load-balancer-forwarding-rules).
    try {
      apiInstance.deleteLoadBalancerForwardingRule(loadBalancerId, forwardingRuleId);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#deleteLoadBalancerForwardingRule");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |
| **forwardingRuleId** | **String**| The [Forwarding Rule id](#operation/list-load-balancer-forwarding-rules). | |

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

<a id="deleteLoadBalancerSsl"></a>
# **deleteLoadBalancerSsl**
> deleteLoadBalancerSsl(loadBalancerId)

Delete Load Balancer SSL

Delete a Load Balancer SSL.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/delete-load-balancer-ssl).
    try {
      apiInstance.deleteLoadBalancerSsl(loadBalancerId);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#deleteLoadBalancerSsl");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/delete-load-balancer-ssl). | |

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

<a id="getLoadBalancer"></a>
# **getLoadBalancer**
> CreateLoadBalancer202Response getLoadBalancer(loadBalancerId)

Get Load Balancer

Get information for a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    try {
      CreateLoadBalancer202Response result = apiInstance.getLoadBalancer(loadBalancerId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#getLoadBalancer");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |

### Return type

[**CreateLoadBalancer202Response**](CreateLoadBalancer202Response.md)

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

<a id="getLoadBalancerForwardingRule"></a>
# **getLoadBalancerForwardingRule**
> GetLoadBalancerForwardingRule200Response getLoadBalancerForwardingRule(loadBalancerId, forwardingRuleId)

Get Forwarding Rule

Get information for a Forwarding Rule on a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    String forwardingRuleId = "forwardingRuleId_example"; // String | The [Forwarding Rule id](#operation/list-load-balancer-forwarding-rules).
    try {
      GetLoadBalancerForwardingRule200Response result = apiInstance.getLoadBalancerForwardingRule(loadBalancerId, forwardingRuleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#getLoadBalancerForwardingRule");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |
| **forwardingRuleId** | **String**| The [Forwarding Rule id](#operation/list-load-balancer-forwarding-rules). | |

### Return type

[**GetLoadBalancerForwardingRule200Response**](GetLoadBalancerForwardingRule200Response.md)

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

<a id="getLoadbalancerFirewallRule"></a>
# **getLoadbalancerFirewallRule**
> LoadbalancerFirewallRule getLoadbalancerFirewallRule(loadbalancerId, firewallRuleId)

Get Firewall Rule

Get a firewall rule for a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadbalancerId = "loadbalancerId_example"; // String | 
    String firewallRuleId = "firewallRuleId_example"; // String | 
    try {
      LoadbalancerFirewallRule result = apiInstance.getLoadbalancerFirewallRule(loadbalancerId, firewallRuleId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#getLoadbalancerFirewallRule");
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
| **loadbalancerId** | **String**|  | |
| **firewallRuleId** | **String**|  | |

### Return type

[**LoadbalancerFirewallRule**](LoadbalancerFirewallRule.md)

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

<a id="listLoadBalancerForwardingRules"></a>
# **listLoadBalancerForwardingRules**
> ListLoadBalancerForwardingRules200Response listLoadBalancerForwardingRules(loadBalancerId, perPage, cursor)

List Forwarding Rules

List the fowarding rules for a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListLoadBalancerForwardingRules200Response result = apiInstance.listLoadBalancerForwardingRules(loadBalancerId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#listLoadBalancerForwardingRules");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListLoadBalancerForwardingRules200Response**](ListLoadBalancerForwardingRules200Response.md)

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

<a id="listLoadBalancers"></a>
# **listLoadBalancers**
> ListLoadBalancers200Response listLoadBalancers(perPage, cursor)

List Load Balancers

List the Load Balancers in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500. 
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListLoadBalancers200Response result = apiInstance.listLoadBalancers(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#listLoadBalancers");
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

[**ListLoadBalancers200Response**](ListLoadBalancers200Response.md)

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

<a id="listLoadbalancerFirewallRules"></a>
# **listLoadbalancerFirewallRules**
> LoadbalancerFirewallRule listLoadbalancerFirewallRules(loadbalancerId, perPage, cursor)

List Firewall Rules

List the firewall rules for a Load Balancer.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadbalancerId = "loadbalancerId_example"; // String | 
    String perPage = "perPage_example"; // String | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      LoadbalancerFirewallRule result = apiInstance.listLoadbalancerFirewallRules(loadbalancerId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#listLoadbalancerFirewallRules");
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
| **loadbalancerId** | **String**|  | |
| **perPage** | **String**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**LoadbalancerFirewallRule**](LoadbalancerFirewallRule.md)

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

<a id="updateLoadBalancer"></a>
# **updateLoadBalancer**
> updateLoadBalancer(loadBalancerId, updateLoadBalancerRequest)

Update Load Balancer

Update information for a Load Balancer. All attributes are optional. If not set, the attributes will retain their original values.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.LoadBalancerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    LoadBalancerApi apiInstance = new LoadBalancerApi(defaultClient);
    String loadBalancerId = "loadBalancerId_example"; // String | The [Load Balancer id](#operation/list-load-balancers).
    UpdateLoadBalancerRequest updateLoadBalancerRequest = new UpdateLoadBalancerRequest(); // UpdateLoadBalancerRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateLoadBalancer(loadBalancerId, updateLoadBalancerRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling LoadBalancerApi#updateLoadBalancer");
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
| **loadBalancerId** | **String**| The [Load Balancer id](#operation/list-load-balancers). | |
| **updateLoadBalancerRequest** | [**UpdateLoadBalancerRequest**](UpdateLoadBalancerRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

