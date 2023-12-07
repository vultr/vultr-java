# PlansApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listMetalPlans**](PlansApi.md#listMetalPlans) | **GET** /plans-metal | List Bare Metal Plans |
| [**listPlans**](PlansApi.md#listPlans) | **GET** /plans | List Plans |


<a id="listMetalPlans"></a>
# **listMetalPlans**
> ListMetalPlans200Response listMetalPlans(perPage, cursor)

List Bare Metal Plans

Get a list of all Bare Metal plans at Vultr.  The response is an array of JSON &#x60;plan&#x60; objects, with unique &#x60;id&#x60; with sub-fields in the general format of:    &lt;type&gt;-&lt;number of cores&gt;-&lt;memory size&gt;-&lt;optional modifier&gt;  For example: &#x60;vc2-24c-96gb-sc1&#x60;  More about the sub-fields:  * &#x60;&lt;type&gt;&#x60;: The Vultr type code. For example, &#x60;vc2&#x60;, &#x60;vhf&#x60;, &#x60;vdc&#x60;, etc. * &#x60;&lt;number of cores&gt;&#x60;: The number of cores, such as &#x60;4c&#x60; for \&quot;4 cores\&quot;, &#x60;8c&#x60; for \&quot;8 cores\&quot;, etc. * &#x60;&lt;memory size&gt;&#x60;: Size in GB, such as &#x60;32gb&#x60;. * &#x60;&lt;optional modifier&gt;&#x60;: Some plans include a modifier for internal identification purposes, such as CPU type or location surcharges.  &gt; Note: This information about plan id format is for general education. Vultr may change the sub-field format or values at any time. You should not attempt to parse the plan ID sub-fields in your code for any specific purpose. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    PlansApi apiInstance = new PlansApi(defaultClient);
    String perPage = "perPage_example"; // String | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListMetalPlans200Response result = apiInstance.listMetalPlans(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PlansApi#listMetalPlans");
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
| **perPage** | **String**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListMetalPlans200Response**](ListMetalPlans200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="listPlans"></a>
# **listPlans**
> ListPlans200Response listPlans(type, perPage, cursor, os)

List Plans

Get a list of all VPS plans at Vultr.  The response is an array of JSON &#x60;plan&#x60; objects, with unique &#x60;id&#x60; with sub-fields in the general format of:    &lt;type&gt;-&lt;number of cores&gt;-&lt;memory size&gt;-&lt;optional modifier&gt;  For example: &#x60;vc2-24c-96gb-sc1&#x60;  More about the sub-fields:  * &#x60;&lt;type&gt;&#x60;: The Vultr type code. For example, &#x60;vc2&#x60;, &#x60;vhf&#x60;, &#x60;vdc&#x60;, etc. * &#x60;&lt;number of cores&gt;&#x60;: The number of cores, such as &#x60;4c&#x60; for \&quot;4 cores\&quot;, &#x60;8c&#x60; for \&quot;8 cores\&quot;, etc. * &#x60;&lt;memory size&gt;&#x60;: Size in GB, such as &#x60;32gb&#x60;. * &#x60;&lt;optional modifier&gt;&#x60;: Some plans include a modifier for internal identification purposes, such as CPU type or location surcharges.  &gt; Note: This information about plan id format is for general education. Vultr may change the sub-field format or values at any time. You should not attempt to parse the plan ID sub-fields in your code for any specific purpose. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PlansApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");

    PlansApi apiInstance = new PlansApi(defaultClient);
    String type = "type_example"; // String | Filter the results by type.  | **Type** | **Description** | |----------|-----------------| | all | All available types | | vc2 | Cloud Compute | | vdc | Dedicated Cloud | | vhf | High Frequency Compute | | vhp | High Performance | | voc | All Optimized Cloud types | | voc-g | General Purpose Optimized Cloud | | voc-c | CPU Optimized Cloud | | voc-m | Memory Optimized Cloud | | voc-s | Storage Optimized Cloud | | vcg | Cloud GPU |
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    String os = "os_example"; // String | Filter the results by operating system.  |   | Type | Description | | - | ------ | ------------- | |   | windows | All available plans that support windows |
    try {
      ListPlans200Response result = apiInstance.listPlans(type, perPage, cursor, os);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PlansApi#listPlans");
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
| **type** | **String**| Filter the results by type.  | **Type** | **Description** | |----------|-----------------| | all | All available types | | vc2 | Cloud Compute | | vdc | Dedicated Cloud | | vhf | High Frequency Compute | | vhp | High Performance | | voc | All Optimized Cloud types | | voc-g | General Purpose Optimized Cloud | | voc-c | CPU Optimized Cloud | | voc-m | Memory Optimized Cloud | | voc-s | Storage Optimized Cloud | | vcg | Cloud GPU | | [optional] |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |
| **os** | **String**| Filter the results by operating system.  |   | Type | Description | | - | ------ | ------------- | |   | windows | All available plans that support windows | | [optional] |

### Return type

[**ListPlans200Response**](ListPlans200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

