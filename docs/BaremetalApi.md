# BaremetalApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachBaremetalsVpc2**](BaremetalApi.md#attachBaremetalsVpc2) | **POST** /bare-metals/{baremetal-id}/vpc2/attach | Attach VPC 2.0 Network to Bare Metal Instance |
| [**createBaremetal**](BaremetalApi.md#createBaremetal) | **POST** /bare-metals | Create Bare Metal Instance |
| [**deleteBaremetal**](BaremetalApi.md#deleteBaremetal) | **DELETE** /bare-metals/{baremetal-id} | Delete Bare Metal |
| [**detachBaremetalVpc2**](BaremetalApi.md#detachBaremetalVpc2) | **POST** /bare-metals/{baremetal-id}/vpc2/detach | Detach VPC 2.0 Network from Bare Metal Instance |
| [**getBandwidthBaremetal**](BaremetalApi.md#getBandwidthBaremetal) | **GET** /bare-metals/{baremetal-id}/bandwidth | Bare Metal Bandwidth |
| [**getBareMetalUserdata**](BaremetalApi.md#getBareMetalUserdata) | **GET** /bare-metals/{baremetal-id}/user-data | Get Bare Metal User Data |
| [**getBareMetalVnc**](BaremetalApi.md#getBareMetalVnc) | **GET** /bare-metals/{baremetal-id}/vnc | Get VNC URL for a Bare Metal |
| [**getBareMetalsUpgrades**](BaremetalApi.md#getBareMetalsUpgrades) | **GET** /bare-metals/{baremetal-id}/upgrades | Get Available Bare Metal Upgrades |
| [**getBaremetal**](BaremetalApi.md#getBaremetal) | **GET** /bare-metals/{baremetal-id} | Get Bare Metal |
| [**getIpv4Baremetal**](BaremetalApi.md#getIpv4Baremetal) | **GET** /bare-metals/{baremetal-id}/ipv4 | Bare Metal IPv4 Addresses |
| [**getIpv6Baremetal**](BaremetalApi.md#getIpv6Baremetal) | **GET** /bare-metals/{baremetal-id}/ipv6 | Bare Metal IPv6 Addresses |
| [**haltBaremetal**](BaremetalApi.md#haltBaremetal) | **POST** /bare-metals/{baremetal-id}/halt | Halt Bare Metal |
| [**haltBaremetals**](BaremetalApi.md#haltBaremetals) | **POST** /bare-metals/halt | Halt Bare Metals |
| [**listBaremetalVpc2**](BaremetalApi.md#listBaremetalVpc2) | **GET** /bare-metals/{baremetal-id}/vpc2 | List Bare Metal Instance VPC 2.0 Networks |
| [**listBaremetals**](BaremetalApi.md#listBaremetals) | **GET** /bare-metals | List Bare Metal Instances |
| [**rebootBareMetals**](BaremetalApi.md#rebootBareMetals) | **POST** /bare-metals/reboot | Reboot Bare Metals |
| [**rebootBaremetal**](BaremetalApi.md#rebootBaremetal) | **POST** /bare-metals/{baremetal-id}/reboot | Reboot Bare Metal |
| [**reinstallBaremetal**](BaremetalApi.md#reinstallBaremetal) | **POST** /bare-metals/{baremetal-id}/reinstall | Reinstall Bare Metal |
| [**startBareMetals**](BaremetalApi.md#startBareMetals) | **POST** /bare-metals/start | Start Bare Metals |
| [**startBaremetal**](BaremetalApi.md#startBaremetal) | **POST** /bare-metals/{baremetal-id}/start | Start Bare Metal |
| [**updateBaremetal**](BaremetalApi.md#updateBaremetal) | **PATCH** /bare-metals/{baremetal-id} | Update Bare Metal |


<a id="attachBaremetalsVpc2"></a>
# **attachBaremetalsVpc2**
> attachBaremetalsVpc2(baremetalId, attachBaremetalsVpc2Request)

Attach VPC 2.0 Network to Bare Metal Instance

Attach a VPC 2.0 Network to a Bare Metal Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal ID](#operation/list-baremetals).
    AttachBaremetalsVpc2Request attachBaremetalsVpc2Request = new AttachBaremetalsVpc2Request(); // AttachBaremetalsVpc2Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachBaremetalsVpc2(baremetalId, attachBaremetalsVpc2Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#attachBaremetalsVpc2");
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
| **baremetalId** | **String**| The [Bare Metal ID](#operation/list-baremetals). | |
| **attachBaremetalsVpc2Request** | [**AttachBaremetalsVpc2Request**](AttachBaremetalsVpc2Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="createBaremetal"></a>
# **createBaremetal**
> CreateBaremetal202Response createBaremetal(createBaremetalRequest)

Create Bare Metal Instance

Create a new Bare Metal instance in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Choose one of the following to deploy the instance:  * &#x60;os_id&#x60; * &#x60;snapshot_id&#x60; * &#x60;app_id&#x60; * &#x60;image_id&#x60;  Supply other attributes as desired.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    CreateBaremetalRequest createBaremetalRequest = new CreateBaremetalRequest(); // CreateBaremetalRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateBaremetal202Response result = apiInstance.createBaremetal(createBaremetalRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#createBaremetal");
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
| **createBaremetalRequest** | [**CreateBaremetalRequest**](CreateBaremetalRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateBaremetal202Response**](CreateBaremetal202Response.md)

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

<a id="deleteBaremetal"></a>
# **deleteBaremetal**
> deleteBaremetal(baremetalId)

Delete Bare Metal

Delete a Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      apiInstance.deleteBaremetal(baremetalId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#deleteBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

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

<a id="detachBaremetalVpc2"></a>
# **detachBaremetalVpc2**
> detachBaremetalVpc2(baremetalId, detachBaremetalVpc2Request)

Detach VPC 2.0 Network from Bare Metal Instance

Detach a VPC 2.0 Network from an Bare Metal Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [bare-metal ID](#operation/list-baremetals).
    DetachBaremetalVpc2Request detachBaremetalVpc2Request = new DetachBaremetalVpc2Request(); // DetachBaremetalVpc2Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.detachBaremetalVpc2(baremetalId, detachBaremetalVpc2Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#detachBaremetalVpc2");
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
| **baremetalId** | **String**| The [bare-metal ID](#operation/list-baremetals). | |
| **detachBaremetalVpc2Request** | [**DetachBaremetalVpc2Request**](DetachBaremetalVpc2Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="getBandwidthBaremetal"></a>
# **getBandwidthBaremetal**
> GetBandwidthBaremetal200Response getBandwidthBaremetal(baremetalId)

Bare Metal Bandwidth

Get bandwidth information for the Bare Metal instance.&lt;br&gt;&lt;br&gt;The &#x60;bandwidth&#x60; object in a successful response contains objects representing a day in the month. The date is denoted by the nested object keys. Days begin and end in the UTC timezone. Bandwidth utilization data contained within the date object is refreshed periodically. We do not recommend using this endpoint to gather real-time metrics.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      GetBandwidthBaremetal200Response result = apiInstance.getBandwidthBaremetal(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getBandwidthBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

### Return type

[**GetBandwidthBaremetal200Response**](GetBandwidthBaremetal200Response.md)

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

<a id="getBareMetalUserdata"></a>
# **getBareMetalUserdata**
> GetBareMetalUserdata200Response getBareMetalUserdata(baremetalId)

Get Bare Metal User Data

Get the user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) for a Bare Metal.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      GetBareMetalUserdata200Response result = apiInstance.getBareMetalUserdata(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getBareMetalUserdata");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

### Return type

[**GetBareMetalUserdata200Response**](GetBareMetalUserdata200Response.md)

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

<a id="getBareMetalVnc"></a>
# **getBareMetalVnc**
> GetBareMetalVnc200Response getBareMetalVnc(baremetalId)

Get VNC URL for a Bare Metal

Get the VNC URL for a Bare Metal

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      GetBareMetalVnc200Response result = apiInstance.getBareMetalVnc(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getBareMetalVnc");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

### Return type

[**GetBareMetalVnc200Response**](GetBareMetalVnc200Response.md)

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

<a id="getBareMetalsUpgrades"></a>
# **getBareMetalsUpgrades**
> GetBareMetalsUpgrades200Response getBareMetalsUpgrades(baremetalId, type)

Get Available Bare Metal Upgrades

Get available upgrades for a Bare Metal

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    String type = "type_example"; // String | Filter upgrade by type:  - all (applications, plans) - applications - os
    try {
      GetBareMetalsUpgrades200Response result = apiInstance.getBareMetalsUpgrades(baremetalId, type);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getBareMetalsUpgrades");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |
| **type** | **String**| Filter upgrade by type:  - all (applications, plans) - applications - os | [optional] |

### Return type

[**GetBareMetalsUpgrades200Response**](GetBareMetalsUpgrades200Response.md)

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

<a id="getBaremetal"></a>
# **getBaremetal**
> GetBaremetal200Response getBaremetal(baremetalId)

Get Bare Metal

Get information for a Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      GetBaremetal200Response result = apiInstance.getBaremetal(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

### Return type

[**GetBaremetal200Response**](GetBaremetal200Response.md)

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

<a id="getIpv4Baremetal"></a>
# **getIpv4Baremetal**
> GetIpv4Baremetal200Response getIpv4Baremetal(baremetalId)

Bare Metal IPv4 Addresses

Get the IPv4 information for the Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      GetIpv4Baremetal200Response result = apiInstance.getIpv4Baremetal(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getIpv4Baremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

### Return type

[**GetIpv4Baremetal200Response**](GetIpv4Baremetal200Response.md)

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

<a id="getIpv6Baremetal"></a>
# **getIpv6Baremetal**
> GetIpv6Baremetal200Response getIpv6Baremetal(baremetalId)

Bare Metal IPv6 Addresses

Get the IPv6 information for the Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      GetIpv6Baremetal200Response result = apiInstance.getIpv6Baremetal(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#getIpv6Baremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

### Return type

[**GetIpv6Baremetal200Response**](GetIpv6Baremetal200Response.md)

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

<a id="haltBaremetal"></a>
# **haltBaremetal**
> haltBaremetal(baremetalId)

Halt Bare Metal

Halt the Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      apiInstance.haltBaremetal(baremetalId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#haltBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

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

<a id="haltBaremetals"></a>
# **haltBaremetals**
> haltBaremetals(haltBaremetalsRequest)

Halt Bare Metals

Halt Bare Metals.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    HaltBaremetalsRequest haltBaremetalsRequest = new HaltBaremetalsRequest(); // HaltBaremetalsRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.haltBaremetals(haltBaremetalsRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#haltBaremetals");
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
| **haltBaremetalsRequest** | [**HaltBaremetalsRequest**](HaltBaremetalsRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="listBaremetalVpc2"></a>
# **listBaremetalVpc2**
> ListBaremetalVpc2200Response listBaremetalVpc2(baremetalId)

List Bare Metal Instance VPC 2.0 Networks

List the VPC 2.0 networks for a Bare Metal Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal ID](#operation/list-baremetals).
    try {
      ListBaremetalVpc2200Response result = apiInstance.listBaremetalVpc2(baremetalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#listBaremetalVpc2");
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
| **baremetalId** | **String**| The [Bare Metal ID](#operation/list-baremetals). | |

### Return type

[**ListBaremetalVpc2200Response**](ListBaremetalVpc2200Response.md)

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

<a id="listBaremetals"></a>
# **listBaremetals**
> ListBaremetals200Response listBaremetals(perPage, cursor)

List Bare Metal Instances

List all Bare Metal instances in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500. 
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListBaremetals200Response result = apiInstance.listBaremetals(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#listBaremetals");
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

[**ListBaremetals200Response**](ListBaremetals200Response.md)

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

<a id="rebootBareMetals"></a>
# **rebootBareMetals**
> rebootBareMetals(haltBaremetalsRequest)

Reboot Bare Metals

Reboot Bare Metals.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    HaltBaremetalsRequest haltBaremetalsRequest = new HaltBaremetalsRequest(); // HaltBaremetalsRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.rebootBareMetals(haltBaremetalsRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#rebootBareMetals");
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
| **haltBaremetalsRequest** | [**HaltBaremetalsRequest**](HaltBaremetalsRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="rebootBaremetal"></a>
# **rebootBaremetal**
> rebootBaremetal(baremetalId)

Reboot Bare Metal

Reboot the Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      apiInstance.rebootBaremetal(baremetalId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#rebootBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

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

<a id="reinstallBaremetal"></a>
# **reinstallBaremetal**
> GetBaremetal200Response reinstallBaremetal(baremetalId, reinstallBaremetalRequest)

Reinstall Bare Metal

Reinstall the Bare Metal instance using an optional &#x60;hostname&#x60;.   **Note:** This action may take some time to complete.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    ReinstallBaremetalRequest reinstallBaremetalRequest = new ReinstallBaremetalRequest(); // ReinstallBaremetalRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetBaremetal200Response result = apiInstance.reinstallBaremetal(baremetalId, reinstallBaremetalRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#reinstallBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |
| **reinstallBaremetalRequest** | [**ReinstallBaremetalRequest**](ReinstallBaremetalRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetBaremetal200Response**](GetBaremetal200Response.md)

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

<a id="startBareMetals"></a>
# **startBareMetals**
> startBareMetals(haltBaremetalsRequest)

Start Bare Metals

Start Bare Metals.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    HaltBaremetalsRequest haltBaremetalsRequest = new HaltBaremetalsRequest(); // HaltBaremetalsRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.startBareMetals(haltBaremetalsRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#startBareMetals");
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
| **haltBaremetalsRequest** | [**HaltBaremetalsRequest**](HaltBaremetalsRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="startBaremetal"></a>
# **startBaremetal**
> startBaremetal(baremetalId)

Start Bare Metal

Start the Bare Metal instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    try {
      apiInstance.startBaremetal(baremetalId);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#startBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |

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

<a id="updateBaremetal"></a>
# **updateBaremetal**
> GetBaremetal200Response updateBaremetal(baremetalId, updateBaremetalRequest)

Update Bare Metal

Update a Bare Metal instance. All attributes are optional. If not set, the attributes will retain their original values.  **Note:** Changing &#x60;os_id&#x60;, &#x60;app_id&#x60; or &#x60;image_id&#x60; may take a few extra seconds to complete.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaremetalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    BaremetalApi apiInstance = new BaremetalApi(defaultClient);
    String baremetalId = "baremetalId_example"; // String | The [Bare Metal id](#operation/list-baremetals).
    UpdateBaremetalRequest updateBaremetalRequest = new UpdateBaremetalRequest(); // UpdateBaremetalRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      GetBaremetal200Response result = apiInstance.updateBaremetal(baremetalId, updateBaremetalRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaremetalApi#updateBaremetal");
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
| **baremetalId** | **String**| The [Bare Metal id](#operation/list-baremetals). | |
| **updateBaremetalRequest** | [**UpdateBaremetalRequest**](UpdateBaremetalRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**GetBaremetal200Response**](GetBaremetal200Response.md)

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

