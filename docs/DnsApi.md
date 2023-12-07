# DnsApi

All URIs are relative to *https://api.vultr.com/v2*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDnsDomain**](DnsApi.md#createDnsDomain) | **POST** /domains | Create DNS Domain |
| [**createDnsDomainRecord**](DnsApi.md#createDnsDomainRecord) | **POST** /domains/{dns-domain}/records | Create Record |
| [**deleteDnsDomain**](DnsApi.md#deleteDnsDomain) | **DELETE** /domains/{dns-domain} | Delete Domain |
| [**deleteDnsDomainRecord**](DnsApi.md#deleteDnsDomainRecord) | **DELETE** /domains/{dns-domain}/records/{record-id} | Delete Record |
| [**getDnsDomain**](DnsApi.md#getDnsDomain) | **GET** /domains/{dns-domain} | Get DNS Domain |
| [**getDnsDomainDnssec**](DnsApi.md#getDnsDomainDnssec) | **GET** /domains/{dns-domain}/dnssec | Get DNSSec Info |
| [**getDnsDomainRecord**](DnsApi.md#getDnsDomainRecord) | **GET** /domains/{dns-domain}/records/{record-id} | Get Record |
| [**getDnsDomainSoa**](DnsApi.md#getDnsDomainSoa) | **GET** /domains/{dns-domain}/soa | Get SOA information |
| [**listDnsDomainRecords**](DnsApi.md#listDnsDomainRecords) | **GET** /domains/{dns-domain}/records | List Records |
| [**listDnsDomains**](DnsApi.md#listDnsDomains) | **GET** /domains | List DNS Domains |
| [**updateDnsDomain**](DnsApi.md#updateDnsDomain) | **PUT** /domains/{dns-domain} | Update a DNS Domain |
| [**updateDnsDomainRecord**](DnsApi.md#updateDnsDomainRecord) | **PATCH** /domains/{dns-domain}/records/{record-id} | Update Record |
| [**updateDnsDomainSoa**](DnsApi.md#updateDnsDomainSoa) | **PATCH** /domains/{dns-domain}/soa | Update SOA information |


<a id="createDnsDomain"></a>
# **createDnsDomain**
> CreateDnsDomain200Response createDnsDomain(createDnsDomainRequest)

Create DNS Domain

Create a DNS Domain for &#x60;domain&#x60;. If no &#x60;ip&#x60; address is supplied a domain with no records will be created.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    CreateDnsDomainRequest createDnsDomainRequest = new CreateDnsDomainRequest(); // CreateDnsDomainRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDnsDomain200Response result = apiInstance.createDnsDomain(createDnsDomainRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#createDnsDomain");
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
| **createDnsDomainRequest** | [**CreateDnsDomainRequest**](CreateDnsDomainRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDnsDomain200Response**](CreateDnsDomain200Response.md)

### Authorization

[API Key](../README.md#API Key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="createDnsDomainRecord"></a>
# **createDnsDomainRecord**
> CreateDnsDomainRecord201Response createDnsDomainRecord(dnsDomain, createDnsDomainRecordRequest)

Create Record

Create a DNS record.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    CreateDnsDomainRecordRequest createDnsDomainRecordRequest = new CreateDnsDomainRecordRequest(); // CreateDnsDomainRecordRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      CreateDnsDomainRecord201Response result = apiInstance.createDnsDomainRecord(dnsDomain, createDnsDomainRecordRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#createDnsDomainRecord");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **createDnsDomainRecordRequest** | [**CreateDnsDomainRecordRequest**](CreateDnsDomainRecordRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

### Return type

[**CreateDnsDomainRecord201Response**](CreateDnsDomainRecord201Response.md)

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
| **403** | Forbidden |  -  |
| **404** | Not Found |  -  |

<a id="deleteDnsDomain"></a>
# **deleteDnsDomain**
> deleteDnsDomain(dnsDomain)

Delete Domain

Delete the DNS Domain.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    try {
      apiInstance.deleteDnsDomain(dnsDomain);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#deleteDnsDomain");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |

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

<a id="deleteDnsDomainRecord"></a>
# **deleteDnsDomainRecord**
> deleteDnsDomainRecord(dnsDomain, recordId)

Delete Record

Delete the DNS record.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    String recordId = "recordId_example"; // String | The [DNS Record id](#operation/list-dns-domain-records).
    try {
      apiInstance.deleteDnsDomainRecord(dnsDomain, recordId);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#deleteDnsDomainRecord");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **recordId** | **String**| The [DNS Record id](#operation/list-dns-domain-records). | |

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

<a id="getDnsDomain"></a>
# **getDnsDomain**
> CreateDnsDomain200Response getDnsDomain(dnsDomain)

Get DNS Domain

Get information for the DNS Domain.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    try {
      CreateDnsDomain200Response result = apiInstance.getDnsDomain(dnsDomain);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#getDnsDomain");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |

### Return type

[**CreateDnsDomain200Response**](CreateDnsDomain200Response.md)

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

<a id="getDnsDomainDnssec"></a>
# **getDnsDomainDnssec**
> GetDnsDomainDnssec200Response getDnsDomainDnssec(dnsDomain)

Get DNSSec Info

Get the DNSSEC information for the DNS Domain.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    try {
      GetDnsDomainDnssec200Response result = apiInstance.getDnsDomainDnssec(dnsDomain);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#getDnsDomainDnssec");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |

### Return type

[**GetDnsDomainDnssec200Response**](GetDnsDomainDnssec200Response.md)

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

<a id="getDnsDomainRecord"></a>
# **getDnsDomainRecord**
> CreateDnsDomainRecord201Response getDnsDomainRecord(dnsDomain, recordId)

Get Record

Get information for a DNS Record.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    String recordId = "recordId_example"; // String | The [DNS Record id](#operation/list-dns-domain-records).
    try {
      CreateDnsDomainRecord201Response result = apiInstance.getDnsDomainRecord(dnsDomain, recordId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#getDnsDomainRecord");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **recordId** | **String**| The [DNS Record id](#operation/list-dns-domain-records). | |

### Return type

[**CreateDnsDomainRecord201Response**](CreateDnsDomainRecord201Response.md)

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

<a id="getDnsDomainSoa"></a>
# **getDnsDomainSoa**
> GetDnsDomainSoa200Response getDnsDomainSoa(dnsDomain)

Get SOA information

Get SOA information for the DNS Domain.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    try {
      GetDnsDomainSoa200Response result = apiInstance.getDnsDomainSoa(dnsDomain);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#getDnsDomainSoa");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |

### Return type

[**GetDnsDomainSoa200Response**](GetDnsDomainSoa200Response.md)

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

<a id="listDnsDomainRecords"></a>
# **listDnsDomainRecords**
> ListDnsDomainRecords200Response listDnsDomainRecords(dnsDomain, perPage, cursor)

List Records

Get the DNS records for the Domain.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500.
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListDnsDomainRecords200Response result = apiInstance.listDnsDomainRecords(dnsDomain, perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#listDnsDomainRecords");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **perPage** | **Integer**| Number of items requested per page. Default is 100 and Max is 500. | [optional] |
| **cursor** | **String**| Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination). | [optional] |

### Return type

[**ListDnsDomainRecords200Response**](ListDnsDomainRecords200Response.md)

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

<a id="listDnsDomains"></a>
# **listDnsDomains**
> ListDnsDomains200Response listDnsDomains(perPage, cursor)

List DNS Domains

List all DNS Domains in your account.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    Integer perPage = 56; // Integer | Number of items requested per page. Default is 100 and Max is 500. 
    String cursor = "cursor_example"; // String | Cursor for paging. See [Meta and Pagination](#section/Introduction/Meta-and-Pagination).
    try {
      ListDnsDomains200Response result = apiInstance.listDnsDomains(perPage, cursor);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#listDnsDomains");
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

[**ListDnsDomains200Response**](ListDnsDomains200Response.md)

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

<a id="updateDnsDomain"></a>
# **updateDnsDomain**
> updateDnsDomain(dnsDomain, updateDnsDomainRequest)

Update a DNS Domain

Update the DNS Domain. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    UpdateDnsDomainRequest updateDnsDomainRequest = new UpdateDnsDomainRequest(); // UpdateDnsDomainRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateDnsDomain(dnsDomain, updateDnsDomainRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#updateDnsDomain");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **updateDnsDomainRequest** | [**UpdateDnsDomainRequest**](UpdateDnsDomainRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="updateDnsDomainRecord"></a>
# **updateDnsDomainRecord**
> updateDnsDomainRecord(dnsDomain, recordId, updateDnsDomainRecordRequest)

Update Record

Update the information for a DNS record. All attributes are optional. If not set, the attributes will retain their original values.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    String recordId = "recordId_example"; // String | The [DNS Record id](#operation/list-dns-domain-records).
    UpdateDnsDomainRecordRequest updateDnsDomainRecordRequest = new UpdateDnsDomainRecordRequest(); // UpdateDnsDomainRecordRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateDnsDomainRecord(dnsDomain, recordId, updateDnsDomainRecordRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#updateDnsDomainRecord");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **recordId** | **String**| The [DNS Record id](#operation/list-dns-domain-records). | |
| **updateDnsDomainRecordRequest** | [**UpdateDnsDomainRecordRequest**](UpdateDnsDomainRecordRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

<a id="updateDnsDomainSoa"></a>
# **updateDnsDomainSoa**
> updateDnsDomainSoa(dnsDomain, updateDnsDomainSoaRequest)

Update SOA information

Update the SOA information for the DNS Domain. All attributes are optional. If not set, the attributes will retain their original values.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DnsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    DnsApi apiInstance = new DnsApi(defaultClient);
    String dnsDomain = "dnsDomain_example"; // String | The [DNS Domain](#operation/list-dns-domains).
    UpdateDnsDomainSoaRequest updateDnsDomainSoaRequest = new UpdateDnsDomainSoaRequest(); // UpdateDnsDomainSoaRequest | Include a JSON object in the request body with a content type of **application/json**.
    try {
      apiInstance.updateDnsDomainSoa(dnsDomain, updateDnsDomainSoaRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DnsApi#updateDnsDomainSoa");
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
| **dnsDomain** | **String**| The [DNS Domain](#operation/list-dns-domains). | |
| **updateDnsDomainSoaRequest** | [**UpdateDnsDomainSoaRequest**](UpdateDnsDomainSoaRequest.md)| Include a JSON object in the request body with a content type of **application/json**. | [optional] |

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

