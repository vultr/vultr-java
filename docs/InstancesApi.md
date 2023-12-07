# InstancesApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**attachInstanceIso**](InstancesApi.md#attachInstanceIso) | **POST** /instances/{instance-id}/iso/attach | Attach ISO to Instance |
| [**attachInstanceNetwork**](InstancesApi.md#attachInstanceNetwork) | **POST** /instances/{instance-id}/private-networks/attach | Attach Private Network to Instance |
| [**attachInstanceVpc**](InstancesApi.md#attachInstanceVpc) | **POST** /instances/{instance-id}/vpcs/attach | Attach VPC to Instance |
| [**attachInstanceVpc2**](InstancesApi.md#attachInstanceVpc2) | **POST** /instances/{instance-id}/vpc2/attach | Attach VPC 2.0 Network to Instance |
| [**createInstance**](InstancesApi.md#createInstance) | **POST** /instances | Create Instance |
| [**createInstanceBackupSchedule**](InstancesApi.md#createInstanceBackupSchedule) | **POST** /instances/{instance-id}/backup-schedule | Set Instance Backup Schedule |
| [**createInstanceIpv4**](InstancesApi.md#createInstanceIpv4) | **POST** /instances/{instance-id}/ipv4 | Create IPv4 |
| [**createInstanceReverseIpv4**](InstancesApi.md#createInstanceReverseIpv4) | **POST** /instances/{instance-id}/ipv4/reverse | Create Instance Reverse IPv4 |
| [**createInstanceReverseIpv6**](InstancesApi.md#createInstanceReverseIpv6) | **POST** /instances/{instance-id}/ipv6/reverse | Create Instance Reverse IPv6 |
| [**deleteInstance**](InstancesApi.md#deleteInstance) | **DELETE** /instances/{instance-id} | Delete Instance |
| [**deleteInstanceIpv4**](InstancesApi.md#deleteInstanceIpv4) | **DELETE** /instances/{instance-id}/ipv4/{ipv4} | Delete IPv4 Address |
| [**deleteInstanceReverseIpv6**](InstancesApi.md#deleteInstanceReverseIpv6) | **DELETE** /instances/{instance-id}/ipv6/reverse/{ipv6} | Delete Instance Reverse IPv6 |
| [**detachInstanceIso**](InstancesApi.md#detachInstanceIso) | **POST** /instances/{instance-id}/iso/detach | Detach ISO from instance |
| [**detachInstanceNetwork**](InstancesApi.md#detachInstanceNetwork) | **POST** /instances/{instance-id}/private-networks/detach | Detach Private Network from Instance. |
| [**detachInstanceVpc**](InstancesApi.md#detachInstanceVpc) | **POST** /instances/{instance-id}/vpcs/detach | Detach VPC from Instance |
| [**detachInstanceVpc2**](InstancesApi.md#detachInstanceVpc2) | **POST** /instances/{instance-id}/vpc2/detach | Detach VPC 2.0 Network from Instance |
| [**getInstance**](InstancesApi.md#getInstance) | **GET** /instances/{instance-id} | Get Instance |
| [**getInstanceBackupSchedule**](InstancesApi.md#getInstanceBackupSchedule) | **GET** /instances/{instance-id}/backup-schedule | Get Instance Backup Schedule |
| [**getInstanceBandwidth**](InstancesApi.md#getInstanceBandwidth) | **GET** /instances/{instance-id}/bandwidth | Instance Bandwidth |
| [**getInstanceIpv4**](InstancesApi.md#getInstanceIpv4) | **GET** /instances/{instance-id}/ipv4 | List Instance IPv4 Information |
| [**getInstanceIpv6**](InstancesApi.md#getInstanceIpv6) | **GET** /instances/{instance-id}/ipv6 | Get Instance IPv6 Information |
| [**getInstanceIsoStatus**](InstancesApi.md#getInstanceIsoStatus) | **GET** /instances/{instance-id}/iso | Get Instance ISO Status |
| [**getInstanceNeighbors**](InstancesApi.md#getInstanceNeighbors) | **GET** /instances/{instance-id}/neighbors | Get Instance neighbors |
| [**getInstanceUpgrades**](InstancesApi.md#getInstanceUpgrades) | **GET** /instances/{instance-id}/upgrades | Get Available Instance Upgrades |
| [**getInstanceUserdata**](InstancesApi.md#getInstanceUserdata) | **GET** /instances/{instance-id}/user-data | Get Instance User Data |
| [**haltInstance**](InstancesApi.md#haltInstance) | **POST** /instances/{instance-id}/halt | Halt Instance |
| [**haltInstances**](InstancesApi.md#haltInstances) | **POST** /instances/halt | Halt Instances |
| [**listInstanceIpv6Reverse**](InstancesApi.md#listInstanceIpv6Reverse) | **GET** /instances/{instance-id}/ipv6/reverse | List Instance IPv6 Reverse |
| [**listInstancePrivateNetworks**](InstancesApi.md#listInstancePrivateNetworks) | **GET** /instances/{instance-id}/private-networks | List instance Private Networks |
| [**listInstanceVpc2**](InstancesApi.md#listInstanceVpc2) | **GET** /instances/{instance-id}/vpc2 | List Instance VPC 2.0 Networks |
| [**listInstanceVpcs**](InstancesApi.md#listInstanceVpcs) | **GET** /instances/{instance-id}/vpcs | List instance VPCs |
| [**listInstances**](InstancesApi.md#listInstances) | **GET** /instances | List Instances |
| [**postInstancesInstanceIdIpv4ReverseDefault**](InstancesApi.md#postInstancesInstanceIdIpv4ReverseDefault) | **POST** /instances/{instance-id}/ipv4/reverse/default | Set Default Reverse DNS Entry |
| [**rebootInstance**](InstancesApi.md#rebootInstance) | **POST** /instances/{instance-id}/reboot | Reboot Instance |
| [**rebootInstances**](InstancesApi.md#rebootInstances) | **POST** /instances/reboot | Reboot instances |
| [**reinstallInstance**](InstancesApi.md#reinstallInstance) | **POST** /instances/{instance-id}/reinstall | Reinstall Instance |
| [**restoreInstance**](InstancesApi.md#restoreInstance) | **POST** /instances/{instance-id}/restore | Restore Instance |
| [**startInstance**](InstancesApi.md#startInstance) | **POST** /instances/{instance-id}/start | Start instance |
| [**startInstances**](InstancesApi.md#startInstances) | **POST** /instances/start | Start instances |
| [**updateInstance**](InstancesApi.md#updateInstance) | **PATCH** /instances/{instance-id} | Update Instance |


<a id="attachInstanceIso"></a>
# **attachInstanceIso**
> AttachInstanceIso202Response attachInstanceIso(instanceId, attachInstanceIsoRequest)

Attach ISO to Instance

Attach an ISO to an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | 
    AttachInstanceIsoRequest attachInstanceIsoRequest = new AttachInstanceIsoRequest(); // AttachInstanceIsoRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      AttachInstanceIso202Response result = apiInstance.attachInstanceIso(instanceId, attachInstanceIsoRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#attachInstanceIso");
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
| **instanceId** | **String**|  | |
| **attachInstanceIsoRequest** | [**AttachInstanceIsoRequest**](AttachInstanceIsoRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**AttachInstanceIso202Response**](AttachInstanceIso202Response.md)

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

<a id="attachInstanceNetwork"></a>
# **attachInstanceNetwork**
> attachInstanceNetwork(instanceId, attachInstanceNetworkRequest)

Attach Private Network to Instance

Attach Private Network to an Instance.&lt;br&gt;&lt;br&gt;**Deprecated**: use [Attach VPC to Instance](#operation/attach-instance-vpc) instead.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    AttachInstanceNetworkRequest attachInstanceNetworkRequest = new AttachInstanceNetworkRequest(); // AttachInstanceNetworkRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachInstanceNetwork(instanceId, attachInstanceNetworkRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#attachInstanceNetwork");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **attachInstanceNetworkRequest** | [**AttachInstanceNetworkRequest**](AttachInstanceNetworkRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="attachInstanceVpc"></a>
# **attachInstanceVpc**
> attachInstanceVpc(instanceId, attachInstanceVpcRequest)

Attach VPC to Instance

Attach a VPC to an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    AttachInstanceVpcRequest attachInstanceVpcRequest = new AttachInstanceVpcRequest(); // AttachInstanceVpcRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachInstanceVpc(instanceId, attachInstanceVpcRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#attachInstanceVpc");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **attachInstanceVpcRequest** | [**AttachInstanceVpcRequest**](AttachInstanceVpcRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="attachInstanceVpc2"></a>
# **attachInstanceVpc2**
> attachInstanceVpc2(instanceId, attachInstanceVpc2Request)

Attach VPC 2.0 Network to Instance

Attach a VPC 2.0 Network to an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    AttachInstanceVpc2Request attachInstanceVpc2Request = new AttachInstanceVpc2Request(); // AttachInstanceVpc2Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.attachInstanceVpc2(instanceId, attachInstanceVpc2Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#attachInstanceVpc2");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **attachInstanceVpc2Request** | [**AttachInstanceVpc2Request**](AttachInstanceVpc2Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **404** | Not Found |  -  |

<a id="createInstance"></a>
# **createInstance**
> CreateInstance202Response createInstance(createInstanceRequest)

Create Instance

Create a new VPS Instance in a &#x60;region&#x60; with the desired &#x60;plan&#x60;. Choose one of the following to deploy the instance:  * &#x60;os_id&#x60; * &#x60;iso_id&#x60; * &#x60;snapshot_id&#x60; * &#x60;app_id&#x60; * &#x60;image_id&#x60;  Supply other attributes as desired.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest(); // CreateInstanceRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateInstance202Response result = apiInstance.createInstance(createInstanceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#createInstance");
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
| **createInstanceRequest** | [**CreateInstanceRequest**](CreateInstanceRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateInstance202Response**](CreateInstance202Response.md)

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

<a id="createInstanceBackupSchedule"></a>
# **createInstanceBackupSchedule**
> createInstanceBackupSchedule(instanceId, createInstanceBackupScheduleRequest)

Set Instance Backup Schedule

Set the backup schedule for an Instance in UTC. The &#x60;type&#x60; is required.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    CreateInstanceBackupScheduleRequest createInstanceBackupScheduleRequest = new CreateInstanceBackupScheduleRequest(); // CreateInstanceBackupScheduleRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.createInstanceBackupSchedule(instanceId, createInstanceBackupScheduleRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#createInstanceBackupSchedule");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **createInstanceBackupScheduleRequest** | [**CreateInstanceBackupScheduleRequest**](CreateInstanceBackupScheduleRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="createInstanceIpv4"></a>
# **createInstanceIpv4**
> Object createInstanceIpv4(instanceId, createInstanceIpv4Request)

Create IPv4

Create an IPv4 address for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    CreateInstanceIpv4Request createInstanceIpv4Request = new CreateInstanceIpv4Request(); // CreateInstanceIpv4Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      Object result = apiInstance.createInstanceIpv4(instanceId, createInstanceIpv4Request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#createInstanceIpv4");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **createInstanceIpv4Request** | [**CreateInstanceIpv4Request**](CreateInstanceIpv4Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

**Object**

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

<a id="createInstanceReverseIpv4"></a>
# **createInstanceReverseIpv4**
> createInstanceReverseIpv4(instanceId, createInstanceReverseIpv4Request)

Create Instance Reverse IPv4

Create a reverse IPv4 entry for an Instance. The &#x60;ip&#x60; and &#x60;reverse&#x60; attributes are required. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    CreateInstanceReverseIpv4Request createInstanceReverseIpv4Request = new CreateInstanceReverseIpv4Request(); // CreateInstanceReverseIpv4Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.createInstanceReverseIpv4(instanceId, createInstanceReverseIpv4Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#createInstanceReverseIpv4");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **createInstanceReverseIpv4Request** | [**CreateInstanceReverseIpv4Request**](CreateInstanceReverseIpv4Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="createInstanceReverseIpv6"></a>
# **createInstanceReverseIpv6**
> createInstanceReverseIpv6(instanceId, createInstanceReverseIpv6Request)

Create Instance Reverse IPv6

Create a reverse IPv6 entry for an Instance. The &#x60;ip&#x60; and &#x60;reverse&#x60; attributes are required. IP address must be in full, expanded format.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    CreateInstanceReverseIpv6Request createInstanceReverseIpv6Request = new CreateInstanceReverseIpv6Request(); // CreateInstanceReverseIpv6Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.createInstanceReverseIpv6(instanceId, createInstanceReverseIpv6Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#createInstanceReverseIpv6");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **createInstanceReverseIpv6Request** | [**CreateInstanceReverseIpv6Request**](CreateInstanceReverseIpv6Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="deleteInstance"></a>
# **deleteInstance**
> deleteInstance(instanceId)

Delete Instance

Delete an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      apiInstance.deleteInstance(instanceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#deleteInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

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

<a id="deleteInstanceIpv4"></a>
# **deleteInstanceIpv4**
> deleteInstanceIpv4(instanceId, ipv4)

Delete IPv4 Address

Delete an IPv4 address from an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    String ipv4 = "ipv4_example"; // String | The IPv4 address.
    try {
      apiInstance.deleteInstanceIpv4(instanceId, ipv4);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#deleteInstanceIpv4");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **ipv4** | **String**| The IPv4 address. | |

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

<a id="deleteInstanceReverseIpv6"></a>
# **deleteInstanceReverseIpv6**
> deleteInstanceReverseIpv6(instanceId, ipv6)

Delete Instance Reverse IPv6

Delete the reverse IPv6 for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    String ipv6 = "ipv6_example"; // String | The IPv6 address.
    try {
      apiInstance.deleteInstanceReverseIpv6(instanceId, ipv6);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#deleteInstanceReverseIpv6");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **ipv6** | **String**| The IPv6 address. | |

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

<a id="detachInstanceIso"></a>
# **detachInstanceIso**
> DetachInstanceIso202Response detachInstanceIso(instanceId)

Detach ISO from instance

Detach the ISO from an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      DetachInstanceIso202Response result = apiInstance.detachInstanceIso(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#detachInstanceIso");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**DetachInstanceIso202Response**](DetachInstanceIso202Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted |  -  |
| **400** | Bad Request |  -  |
| **401** | Unauthorized |  -  |
| **404** | Not Found |  -  |

<a id="detachInstanceNetwork"></a>
# **detachInstanceNetwork**
> detachInstanceNetwork(instanceId, detachInstanceNetworkRequest)

Detach Private Network from Instance.

Detach Private Network from an Instance.&lt;br&gt;&lt;br&gt;**Deprecated**: use [Detach VPC from Instance](#operation/detach-instance-vpc) instead.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    DetachInstanceNetworkRequest detachInstanceNetworkRequest = new DetachInstanceNetworkRequest(); // DetachInstanceNetworkRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.detachInstanceNetwork(instanceId, detachInstanceNetworkRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#detachInstanceNetwork");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **detachInstanceNetworkRequest** | [**DetachInstanceNetworkRequest**](DetachInstanceNetworkRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="detachInstanceVpc"></a>
# **detachInstanceVpc**
> detachInstanceVpc(instanceId, detachInstanceVpcRequest)

Detach VPC from Instance

Detach a VPC from an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    DetachInstanceVpcRequest detachInstanceVpcRequest = new DetachInstanceVpcRequest(); // DetachInstanceVpcRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.detachInstanceVpc(instanceId, detachInstanceVpcRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#detachInstanceVpc");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **detachInstanceVpcRequest** | [**DetachInstanceVpcRequest**](DetachInstanceVpcRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="detachInstanceVpc2"></a>
# **detachInstanceVpc2**
> detachInstanceVpc2(instanceId, detachInstanceVpc2Request)

Detach VPC 2.0 Network from Instance

Detach a VPC 2.0 Network from an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    DetachInstanceVpc2Request detachInstanceVpc2Request = new DetachInstanceVpc2Request(); // DetachInstanceVpc2Request | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.detachInstanceVpc2(instanceId, detachInstanceVpc2Request);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#detachInstanceVpc2");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **detachInstanceVpc2Request** | [**DetachInstanceVpc2Request**](DetachInstanceVpc2Request.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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
| **404** | Not Found |  -  |

<a id="getInstance"></a>
# **getInstance**
> CreateInstance202Response getInstance(instanceId)

Get Instance

Get information about an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      CreateInstance202Response result = apiInstance.getInstance(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**CreateInstance202Response**](CreateInstance202Response.md)

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

<a id="getInstanceBackupSchedule"></a>
# **getInstanceBackupSchedule**
> GetInstanceBackupSchedule200Response getInstanceBackupSchedule(instanceId)

Get Instance Backup Schedule

Get the backup schedule for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      GetInstanceBackupSchedule200Response result = apiInstance.getInstanceBackupSchedule(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceBackupSchedule");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**GetInstanceBackupSchedule200Response**](GetInstanceBackupSchedule200Response.md)

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

<a id="getInstanceBandwidth"></a>
# **getInstanceBandwidth**
> GetBandwidthBaremetal200Response getInstanceBandwidth(instanceId, dateRange)

Instance Bandwidth

Get bandwidth information about an Instance.&lt;br&gt;&lt;br&gt;The &#x60;bandwidth&#x60; object in a successful response contains objects representing a day in the month. The date is denoted by the nested object keys. Days begin and end in the UTC timezone. The bandwidth utilization data contained within the date object is refreshed periodically. We do not recommend using this endpoint to gather real-time metrics.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    Integer dateRange = 56; // Integer | The range of days to include, represented as the number of days relative to the current date. Default 30, Minimum 1 and Max 60.
    try {
      GetBandwidthBaremetal200Response result = apiInstance.getInstanceBandwidth(instanceId, dateRange);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceBandwidth");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **dateRange** | **Integer**| The range of days to include, represented as the number of days relative to the current date. Default 30, Minimum 1 and Max 60. | [optional] |

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

<a id="getInstanceIpv4"></a>
# **getInstanceIpv4**
> GetIpv4Baremetal200Response getInstanceIpv4(instanceId, publicNetwork, perPage, cursor)

List Instance IPv4 Information

List the IPv4 information for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    Boolean publicNetwork = true; // Boolean | If `true`, includes information about the public network adapter (such as MAC address) with the `main_ip` entry.
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500. 
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      GetIpv4Baremetal200Response result = apiInstance.getInstanceIpv4(instanceId, publicNetwork, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceIpv4");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **publicNetwork** | **Boolean**| If &#x60;true&#x60;, includes information about the public network adapter (such as MAC address) with the &#x60;main_ip&#x60; entry. | [optional] |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500.  | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

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

<a id="getInstanceIpv6"></a>
# **getInstanceIpv6**
> GetIpv6Baremetal200Response getInstanceIpv6(instanceId)

Get Instance IPv6 Information

Get the IPv6 information for an VPS Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      GetIpv6Baremetal200Response result = apiInstance.getInstanceIpv6(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceIpv6");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

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

<a id="getInstanceIsoStatus"></a>
# **getInstanceIsoStatus**
> GetInstanceIsoStatus200Response getInstanceIsoStatus(instanceId)

Get Instance ISO Status

Get the ISO status for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      GetInstanceIsoStatus200Response result = apiInstance.getInstanceIsoStatus(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceIsoStatus");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**GetInstanceIsoStatus200Response**](GetInstanceIsoStatus200Response.md)

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

<a id="getInstanceNeighbors"></a>
# **getInstanceNeighbors**
> GetInstanceNeighbors200Response getInstanceNeighbors(instanceId)

Get Instance neighbors

Get a list of other instances in the same location as this Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      GetInstanceNeighbors200Response result = apiInstance.getInstanceNeighbors(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceNeighbors");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**GetInstanceNeighbors200Response**](GetInstanceNeighbors200Response.md)

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

<a id="getInstanceUpgrades"></a>
# **getInstanceUpgrades**
> GetInstanceUpgrades200Response getInstanceUpgrades(instanceId, type)

Get Available Instance Upgrades

Get available upgrades for an Instance

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    String type = "type_example"; // String | Filter upgrade by type:  - all (applications, os, plans) - applications - os - plans
    try {
      GetInstanceUpgrades200Response result = apiInstance.getInstanceUpgrades(instanceId, type);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceUpgrades");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **type** | **String**| Filter upgrade by type:  - all (applications, os, plans) - applications - os - plans | [optional] |

### Return type

[**GetInstanceUpgrades200Response**](GetInstanceUpgrades200Response.md)

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

<a id="getInstanceUserdata"></a>
# **getInstanceUserdata**
> GetInstanceUserdata200Response getInstanceUserdata(instanceId)

Get Instance User Data

Get the user-supplied, base64 encoded [user data](https://www.vultr.com/docs/manage-instance-user-data-with-the-vultr-metadata-api/) for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      GetInstanceUserdata200Response result = apiInstance.getInstanceUserdata(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#getInstanceUserdata");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**GetInstanceUserdata200Response**](GetInstanceUserdata200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="haltInstance"></a>
# **haltInstance**
> haltInstance(instanceId)

Halt Instance

Halt an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      apiInstance.haltInstance(instanceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#haltInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

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

<a id="haltInstances"></a>
# **haltInstances**
> haltInstances(haltInstancesRequest)

Halt Instances

Halt Instances.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    HaltInstancesRequest haltInstancesRequest = new HaltInstancesRequest(); // HaltInstancesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.haltInstances(haltInstancesRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#haltInstances");
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
| **haltInstancesRequest** | [**HaltInstancesRequest**](HaltInstancesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="listInstanceIpv6Reverse"></a>
# **listInstanceIpv6Reverse**
> ListInstanceIpv6Reverse200Response listInstanceIpv6Reverse(instanceId)

List Instance IPv6 Reverse

List the reverse IPv6 information for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      ListInstanceIpv6Reverse200Response result = apiInstance.listInstanceIpv6Reverse(instanceId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#listInstanceIpv6Reverse");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

### Return type

[**ListInstanceIpv6Reverse200Response**](ListInstanceIpv6Reverse200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="listInstancePrivateNetworks"></a>
# **listInstancePrivateNetworks**
> ListInstancePrivateNetworks200Response listInstancePrivateNetworks(instanceId, perPage, cursor)

List instance Private Networks

**Deprecated**: use [List Instance VPCs](#operation/list-instance-vpcs) instead.&lt;br&gt;&lt;br&gt;List the private networks for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListInstancePrivateNetworks200Response result = apiInstance.listInstancePrivateNetworks(instanceId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#listInstancePrivateNetworks");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListInstancePrivateNetworks200Response**](ListInstancePrivateNetworks200Response.md)

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

<a id="listInstanceVpc2"></a>
# **listInstanceVpc2**
> ListInstanceVpc2200Response listInstanceVpc2(instanceId, perPage, cursor)

List Instance VPC 2.0 Networks

List the VPC 2.0 networks for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListInstanceVpc2200Response result = apiInstance.listInstanceVpc2(instanceId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#listInstanceVpc2");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListInstanceVpc2200Response**](ListInstanceVpc2200Response.md)

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

<a id="listInstanceVpcs"></a>
# **listInstanceVpcs**
> ListInstanceVpcs200Response listInstanceVpcs(instanceId, perPage, cursor)

List instance VPCs

List the VPCs for an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListInstanceVpcs200Response result = apiInstance.listInstanceVpcs(instanceId, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#listInstanceVpcs");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListInstanceVpcs200Response**](ListInstanceVpcs200Response.md)

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

<a id="listInstances"></a>
# **listInstances**
> ListInstances200Response listInstances(perPage, cursor, tag, label, mainIp, region, firewallGroupId)

List Instances

List all VPS instances in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    String tag = "tag_example"; // String | Filter by specific tag.
    String label = "label_example"; // String | Filter by label.
    String mainIp = "mainIp_example"; // String | Filter by main ip address.
    String region = "region_example"; // String | Filter by [Region id](#operation/list-regions).
    String firewallGroupId = "firewallGroupId_example"; // String | Filter by [Firewall group id](#operation/list-firewall-groups).
    try {
      ListInstances200Response result = apiInstance.listInstances(perPage, cursor, tag, label, mainIp, region, firewallGroupId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#listInstances");
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
| **tag** | **String**| Filter by specific tag. | [optional] |
| **label** | **String**| Filter by label. | [optional] |
| **mainIp** | **String**| Filter by main ip address. | [optional] |
| **region** | **String**| Filter by [Region id](#operation/list-regions). | [optional] |
| **firewallGroupId** | **String**| Filter by [Firewall group id](#operation/list-firewall-groups). | [optional] |

### Return type

[**ListInstances200Response**](ListInstances200Response.md)

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
| **422** | Validation Error |  -  |

<a id="postInstancesInstanceIdIpv4ReverseDefault"></a>
# **postInstancesInstanceIdIpv4ReverseDefault**
> postInstancesInstanceIdIpv4ReverseDefault(instanceId, postInstancesInstanceIdIpv4ReverseDefaultRequest)

Set Default Reverse DNS Entry

Set a reverse DNS entry for an IPv4 address

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    PostInstancesInstanceIdIpv4ReverseDefaultRequest postInstancesInstanceIdIpv4ReverseDefaultRequest = new PostInstancesInstanceIdIpv4ReverseDefaultRequest(); // PostInstancesInstanceIdIpv4ReverseDefaultRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.postInstancesInstanceIdIpv4ReverseDefault(instanceId, postInstancesInstanceIdIpv4ReverseDefaultRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#postInstancesInstanceIdIpv4ReverseDefault");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **postInstancesInstanceIdIpv4ReverseDefaultRequest** | [**PostInstancesInstanceIdIpv4ReverseDefaultRequest**](PostInstancesInstanceIdIpv4ReverseDefaultRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="rebootInstance"></a>
# **rebootInstance**
> rebootInstance(instanceId)

Reboot Instance

Reboot an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      apiInstance.rebootInstance(instanceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#rebootInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

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

<a id="rebootInstances"></a>
# **rebootInstances**
> rebootInstances(rebootInstancesRequest)

Reboot instances

Reboot Instances.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    RebootInstancesRequest rebootInstancesRequest = new RebootInstancesRequest(); // RebootInstancesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.rebootInstances(rebootInstancesRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#rebootInstances");
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
| **rebootInstancesRequest** | [**RebootInstancesRequest**](RebootInstancesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="reinstallInstance"></a>
# **reinstallInstance**
> CreateInstance202Response reinstallInstance(instanceId, reinstallInstanceRequest)

Reinstall Instance

Reinstall an Instance using an optional &#x60;hostname&#x60;.  **Note:** This action may take a few extra seconds to complete.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    ReinstallInstanceRequest reinstallInstanceRequest = new ReinstallInstanceRequest(); // ReinstallInstanceRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateInstance202Response result = apiInstance.reinstallInstance(instanceId, reinstallInstanceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#reinstallInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **reinstallInstanceRequest** | [**ReinstallInstanceRequest**](ReinstallInstanceRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateInstance202Response**](CreateInstance202Response.md)

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

<a id="restoreInstance"></a>
# **restoreInstance**
> RestoreInstance202Response restoreInstance(instanceId, restoreInstanceRequest)

Restore Instance

Restore an Instance from either &#x60;backup_id&#x60; or &#x60;snapshot_id&#x60;.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    RestoreInstanceRequest restoreInstanceRequest = new RestoreInstanceRequest(); // RestoreInstanceRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      RestoreInstance202Response result = apiInstance.restoreInstance(instanceId, restoreInstanceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#restoreInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **restoreInstanceRequest** | [**RestoreInstanceRequest**](RestoreInstanceRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**RestoreInstance202Response**](RestoreInstance202Response.md)

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

<a id="startInstance"></a>
# **startInstance**
> startInstance(instanceId)

Start instance

Start an Instance.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    try {
      apiInstance.startInstance(instanceId);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#startInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |

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

<a id="startInstances"></a>
# **startInstances**
> startInstances(startInstancesRequest)

Start instances

Start Instances.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    StartInstancesRequest startInstancesRequest = new StartInstancesRequest(); // StartInstancesRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.startInstances(startInstancesRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#startInstances");
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
| **startInstancesRequest** | [**StartInstancesRequest**](StartInstancesRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="updateInstance"></a>
# **updateInstance**
> CreateInstance202Response updateInstance(instanceId, updateInstanceRequest)

Update Instance

Update information for an Instance. All attributes are optional. If not set, the attributes will retain their original values.  **Note:** Changing &#x60;os_id&#x60;, &#x60;app_id&#x60; or &#x60;image_id&#x60; may take a few extra seconds to complete.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.InstancesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    InstancesApi apiInstance = new InstancesApi(defaultClient);
    String instanceId = "instanceId_example"; // String | The [Instance ID](#operation/list-instances).
    UpdateInstanceRequest updateInstanceRequest = new UpdateInstanceRequest(); // UpdateInstanceRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateInstance202Response result = apiInstance.updateInstance(instanceId, updateInstanceRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InstancesApi#updateInstance");
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
| **instanceId** | **String**| The [Instance ID](#operation/list-instances). | |
| **updateInstanceRequest** | [**UpdateInstanceRequest**](UpdateInstanceRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateInstance202Response**](CreateInstance202Response.md)

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

