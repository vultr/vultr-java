# openapi-java-client

Vultr API
- API version: 2.0
  - Build date: 2023-12-07T21:22:43.771568343Z[Etc/UTC]

# Introduction

The Vultr API v2 is a set of HTTP endpoints that adhere to RESTful design principles and CRUD actions with predictable URIs. It uses standard HTTP response codes, authentication, and verbs. The API has consistent and well-formed JSON requests and responses with cursor-based pagination to simplify list handling. Error messages are descriptive and easy to understand. All functions of the Vultr customer portal are accessible via the API, enabling you to script complex unattended scenarios with any tool fluent in HTTP.

## Requests

Communicate with the API by making an HTTP request at the correct endpoint. The chosen method determines the action taken.

| Method | Usage |
| ------ | ------------- |
| DELETE | Use the DELETE method to destroy a resource in your account. If it is not found, the operation will return a 4xx error and an appropriate message. |
| GET | To retrieve information about a resource, use the GET method. The data is returned as a JSON object. GET methods are read-only and do not affect any resources. |
| PATCH | Some resources support partial modification with PATCH, which modifies specific attributes without updating the entire object representation. |
| POST | Issue a POST method to create a new object. Include all needed attributes in the request body encoded as JSON. |
| PUT | Use the PUT method to update information about a resource. PUT will set new values on the item without regard to their current values. |

**Rate Limit:** Vultr safeguards the API against bursts of incoming traffic based on the request's IP address to ensure stability for all users. If your application sends more than 30 requests per second, the API may return HTTP status code 429.

## Response Codes

We use standard HTTP response codes to show the success or failure of requests. Response codes in the 2xx range indicate success, while codes in the 4xx range indicate an error, such as an authorization failure or a malformed request. All 4xx errors will return a JSON response object with an `error` attribute explaining the error. Codes in the 5xx range indicate a server-side problem preventing Vultr from fulfilling your request.

| Response | Description |
| ------ | ------------- |
| 200 OK | The response contains your requested information. |
| 201 Created | Your request was accepted. The resource was created. |
| 202 Accepted | Your request was accepted. The resource was created or updated. |
| 204 No Content | Your request succeeded, there is no additional information returned. |
| 400 Bad Request | Your request was malformed. |
| 401 Unauthorized | You did not supply valid authentication credentials. |
| 403 Forbidden | You are not allowed to perform that action. |
| 404 Not Found | No results were found for your request. |
| 429 Too Many Requests | Your request exceeded the API rate limit. |
| 500 Internal Server Error | We were unable to perform the request due to server-side problems. |

## Meta and Pagination

Many API calls will return a `meta` object with paging information.

### Definitions

| Term | Description |
| ------ | ------------- |
| **List** | The items returned from the database for your request (not necessarily shown in a single response depending on the **cursor** size). |
| **Page** | A subset of the full **list** of items. Choose the size of a **page** with the `per_page` parameter. |
| **Total** | The `total` attribute indicates the number of items in the full **list**.|
| **Cursor** | Use the `cursor` query parameter to select a next or previous **page**. |
| **Next** & **Prev** | Use the `next` and `prev` attributes of the `links` meta object as `cursor` values. |

### How to use Paging

If your result **list** total exceeds the default **cursor** size (the default depends on the route, but is usually 100 records) or the value defined by the `per_page` query param (when present) the response will be returned to you paginated.

### Paging Example

> These examples have abbreviated attributes and sample values. Your actual `cursor` values will be encoded alphanumeric strings.

To return a **page** with the first two plans in the List:

    curl \"https://api.vultr.com/v2/plans?per_page=2\" \\
      -X GET \\
      -H \"Authorization: Bearer ${VULTR_API_KEY}\"

The API returns an object similar to this:

    {
        \"plans\": [
            {
                \"id\": \"vc2-1c-2gb\",
                \"vcpu_count\": 1,
                \"ram\": 2048,
                \"locations\": []
            },
            {
                \"id\": \"vc2-24c-97gb\",
                \"vcpu_count\": 24,
                \"ram\": 98304,
                \"locations\": []
            }
        ],
        \"meta\": {
            \"total\": 19,
            \"links\": {
                \"next\": \"WxYzExampleNext\",
                \"prev\": \"WxYzExamplePrev\"
            }
        }
    }

The object contains two plans. The `total` attribute indicates that 19 plans are available in the List. To navigate forward in the **list**, use the `next` value (`WxYzExampleNext` in this example) as your `cursor` query parameter.

    curl \"https://api.vultr.com/v2/plans?per_page=2&cursor=WxYzExampleNext\" \\
      -X GET
      -H \"Authorization: Bearer ${VULTR_API_KEY}\"

Likewise, you can use the example `prev` value `WxYzExamplePrev` to navigate backward.

## Parameters

You can pass information to the API with three different types of parameters.

### Path parameters

Some API calls require variable parameters as part of the endpoint path. For example, to retrieve information about a user, supply the `user-id` in the endpoint.

    curl \"https://api.vultr.com/v2/users/{user-id}\" \\
      -X GET \\
      -H \"Authorization: Bearer ${VULTR_API_KEY}\"

### Query parameters

Some API calls allow filtering with query parameters. For example, the `/v2/plans` endpoint supports a `type` query parameter. Setting `type=vhf` instructs the API only to return High Frequency Compute plans in the list. You'll find more specifics about valid filters in the endpoint documentation below.

    curl \"https://api.vultr.com/v2/plans?type=vhf\" \\
      -X GET \\
      -H \"Authorization: Bearer ${VULTR_API_KEY}\"

You can also combine filtering with paging. Use the `per_page` parameter to retreive a subset of vhf plans.

    curl \"https://api.vultr.com/v2/plans?type=vhf&per_page=2\" \\
      -X GET \\
      -H \"Authorization: Bearer ${VULTR_API_KEY}\"

### Request Body

PUT, POST, and PATCH methods may include an object in the request body with a content type of **application/json**. The documentation for each endpoint below has more information about the expected object.

## API Example Conventions

The examples in this documentation use `curl`, a command-line HTTP client, to demonstrate useage. Linux and macOS computers usually have curl installed by default, and it's [available for download](https://curl.se/download.html) on all popular platforms including Windows.

Each example is split across multiple lines with the `\\` character, which is compatible with a `bash` terminal. A typical example looks like this:

    curl \"https://api.vultr.com/v2/domains\" \\
      -X POST \\
      -H \"Authorization: Bearer ${VULTR_API_KEY}\" \\
      -H \"Content-Type: application/json\" \\
      --data '{
        \"domain\" : \"example.com\",
        \"ip\" : \"192.0.2.123\"
      }'

* The `-X` parameter sets the request method. For consistency, we show the method on all examples, even though it's not explicitly required for GET methods.
* The `-H` lines set required HTTP headers. These examples are formatted to expand the VULTR\\_API\\_KEY environment variable for your convenience.
* Examples that require a JSON object in the request body pass the required data via the `--data` parameter.

All values in this guide are examples. Do not rely on the OS or Plan IDs listed in this guide; use the appropriate endpoint to retreive values before creating resources.


  For more information, please visit [https://www.vultr.com](https://www.vultr.com)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>2.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:2.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-2.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.AccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.vultr.com/v2");
    
    // Configure HTTP bearer authorization: API Key
    HttpBearerAuth API Key = (HttpBearerAuth) defaultClient.getAuthentication("API Key");
    API Key.setBearerToken("BEARER TOKEN");

    AccountApi apiInstance = new AccountApi(defaultClient);
    try {
      GetAccount200Response result = apiInstance.getAccount();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountApi#getAccount");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.vultr.com/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AccountApi* | [**getAccount**](docs/AccountApi.md#getAccount) | **GET** /account | Get Account Info
*ApplicationApi* | [**listApplications**](docs/ApplicationApi.md#listApplications) | **GET** /applications | List Applications
*BackupApi* | [**getBackup**](docs/BackupApi.md#getBackup) | **GET** /backups/{backup-id} | Get a Backup
*BackupApi* | [**listBackups**](docs/BackupApi.md#listBackups) | **GET** /backups | List Backups
*BaremetalApi* | [**attachBaremetalsVpc2**](docs/BaremetalApi.md#attachBaremetalsVpc2) | **POST** /bare-metals/{baremetal-id}/vpc2/attach | Attach VPC 2.0 Network to Bare Metal Instance
*BaremetalApi* | [**createBaremetal**](docs/BaremetalApi.md#createBaremetal) | **POST** /bare-metals | Create Bare Metal Instance
*BaremetalApi* | [**deleteBaremetal**](docs/BaremetalApi.md#deleteBaremetal) | **DELETE** /bare-metals/{baremetal-id} | Delete Bare Metal
*BaremetalApi* | [**detachBaremetalVpc2**](docs/BaremetalApi.md#detachBaremetalVpc2) | **POST** /bare-metals/{baremetal-id}/vpc2/detach | Detach VPC 2.0 Network from Bare Metal Instance
*BaremetalApi* | [**getBandwidthBaremetal**](docs/BaremetalApi.md#getBandwidthBaremetal) | **GET** /bare-metals/{baremetal-id}/bandwidth | Bare Metal Bandwidth
*BaremetalApi* | [**getBareMetalUserdata**](docs/BaremetalApi.md#getBareMetalUserdata) | **GET** /bare-metals/{baremetal-id}/user-data | Get Bare Metal User Data
*BaremetalApi* | [**getBareMetalVnc**](docs/BaremetalApi.md#getBareMetalVnc) | **GET** /bare-metals/{baremetal-id}/vnc | Get VNC URL for a Bare Metal
*BaremetalApi* | [**getBareMetalsUpgrades**](docs/BaremetalApi.md#getBareMetalsUpgrades) | **GET** /bare-metals/{baremetal-id}/upgrades | Get Available Bare Metal Upgrades
*BaremetalApi* | [**getBaremetal**](docs/BaremetalApi.md#getBaremetal) | **GET** /bare-metals/{baremetal-id} | Get Bare Metal
*BaremetalApi* | [**getIpv4Baremetal**](docs/BaremetalApi.md#getIpv4Baremetal) | **GET** /bare-metals/{baremetal-id}/ipv4 | Bare Metal IPv4 Addresses
*BaremetalApi* | [**getIpv6Baremetal**](docs/BaremetalApi.md#getIpv6Baremetal) | **GET** /bare-metals/{baremetal-id}/ipv6 | Bare Metal IPv6 Addresses
*BaremetalApi* | [**haltBaremetal**](docs/BaremetalApi.md#haltBaremetal) | **POST** /bare-metals/{baremetal-id}/halt | Halt Bare Metal
*BaremetalApi* | [**haltBaremetals**](docs/BaremetalApi.md#haltBaremetals) | **POST** /bare-metals/halt | Halt Bare Metals
*BaremetalApi* | [**listBaremetalVpc2**](docs/BaremetalApi.md#listBaremetalVpc2) | **GET** /bare-metals/{baremetal-id}/vpc2 | List Bare Metal Instance VPC 2.0 Networks
*BaremetalApi* | [**listBaremetals**](docs/BaremetalApi.md#listBaremetals) | **GET** /bare-metals | List Bare Metal Instances
*BaremetalApi* | [**rebootBareMetals**](docs/BaremetalApi.md#rebootBareMetals) | **POST** /bare-metals/reboot | Reboot Bare Metals
*BaremetalApi* | [**rebootBaremetal**](docs/BaremetalApi.md#rebootBaremetal) | **POST** /bare-metals/{baremetal-id}/reboot | Reboot Bare Metal
*BaremetalApi* | [**reinstallBaremetal**](docs/BaremetalApi.md#reinstallBaremetal) | **POST** /bare-metals/{baremetal-id}/reinstall | Reinstall Bare Metal
*BaremetalApi* | [**startBareMetals**](docs/BaremetalApi.md#startBareMetals) | **POST** /bare-metals/start | Start Bare Metals
*BaremetalApi* | [**startBaremetal**](docs/BaremetalApi.md#startBaremetal) | **POST** /bare-metals/{baremetal-id}/start | Start Bare Metal
*BaremetalApi* | [**updateBaremetal**](docs/BaremetalApi.md#updateBaremetal) | **PATCH** /bare-metals/{baremetal-id} | Update Bare Metal
*BillingApi* | [**getInvoice**](docs/BillingApi.md#getInvoice) | **GET** /billing/invoices/{invoice-id} | Get Invoice
*BillingApi* | [**getInvoiceItems**](docs/BillingApi.md#getInvoiceItems) | **GET** /billing/invoices/{invoice-id}/items | Get Invoice Items
*BillingApi* | [**listBillingHistory**](docs/BillingApi.md#listBillingHistory) | **GET** /billing/history | List Billing History
*BillingApi* | [**listInvoices**](docs/BillingApi.md#listInvoices) | **GET** /billing/invoices | List Invoices
*BlockApi* | [**attachBlock**](docs/BlockApi.md#attachBlock) | **POST** /blocks/{block-id}/attach | Attach Block Storage
*BlockApi* | [**createBlock**](docs/BlockApi.md#createBlock) | **POST** /blocks | Create Block Storage
*BlockApi* | [**deleteBlock**](docs/BlockApi.md#deleteBlock) | **DELETE** /blocks/{block-id} | Delete Block Storage
*BlockApi* | [**detachBlock**](docs/BlockApi.md#detachBlock) | **POST** /blocks/{block-id}/detach | Detach Block Storage
*BlockApi* | [**getBlock**](docs/BlockApi.md#getBlock) | **GET** /blocks/{block-id} | Get Block Storage
*BlockApi* | [**listBlocks**](docs/BlockApi.md#listBlocks) | **GET** /blocks | List Block storages
*BlockApi* | [**updateBlock**](docs/BlockApi.md#updateBlock) | **PATCH** /blocks/{block-id} | Update Block Storage
*ContainerRegistryApi* | [**createRegistry**](docs/ContainerRegistryApi.md#createRegistry) | **POST** /registry | Create Container Registry
*ContainerRegistryApi* | [**createRegistryDockerCredentials**](docs/ContainerRegistryApi.md#createRegistryDockerCredentials) | **OPTIONS** /registry/{registry-id}/docker-credentials?expiry_seconds&#x3D;0&amp;read_write&#x3D;false | Create Docker Credentials
*ContainerRegistryApi* | [**createRegistryKubernetesDockerCredentials**](docs/ContainerRegistryApi.md#createRegistryKubernetesDockerCredentials) | **OPTIONS** /registry/{registry-id}/docker-credentials/kubernetes?expiry_seconds&#x3D;0&amp;read_write&#x3D;false&amp;base64_encode&#x3D;false | Create Docker Credentials for Kubernetes
*ContainerRegistryApi* | [**deleteRegistry**](docs/ContainerRegistryApi.md#deleteRegistry) | **DELETE** /registry/{registry-id} | Delete Container Registry
*ContainerRegistryApi* | [**deleteRepository**](docs/ContainerRegistryApi.md#deleteRepository) | **DELETE** /registry/{registry-id}/repository/{repository-image} | Delete Repository
*ContainerRegistryApi* | [**listRegistries**](docs/ContainerRegistryApi.md#listRegistries) | **GET** /registries | List Container Registries
*ContainerRegistryApi* | [**listRegistryPlans**](docs/ContainerRegistryApi.md#listRegistryPlans) | **GET** /registry/plan/list | List Registry Plans
*ContainerRegistryApi* | [**listRegistryRegions**](docs/ContainerRegistryApi.md#listRegistryRegions) | **GET** /registry/region/list | List Registry Regions
*ContainerRegistryApi* | [**listRegistryRepositories**](docs/ContainerRegistryApi.md#listRegistryRepositories) | **GET** /registry/{registry-id}/repositories | List Repositories
*ContainerRegistryApi* | [**readRegistry**](docs/ContainerRegistryApi.md#readRegistry) | **GET** /registry/{registry-id} | Read Container Registry
*ContainerRegistryApi* | [**readRegistryRepository**](docs/ContainerRegistryApi.md#readRegistryRepository) | **GET** /registry/{registry-id}/repository/{repository-image} | Read Repository
*ContainerRegistryApi* | [**updateRegistry**](docs/ContainerRegistryApi.md#updateRegistry) | **PUT** /registry/{registry-id} | Update Container Registry
*ContainerRegistryApi* | [**updateRepository**](docs/ContainerRegistryApi.md#updateRepository) | **PUT** /registry/{registry-id}/repository/{repository-image} | Update Repository
*DnsApi* | [**createDnsDomain**](docs/DnsApi.md#createDnsDomain) | **POST** /domains | Create DNS Domain
*DnsApi* | [**createDnsDomainRecord**](docs/DnsApi.md#createDnsDomainRecord) | **POST** /domains/{dns-domain}/records | Create Record
*DnsApi* | [**deleteDnsDomain**](docs/DnsApi.md#deleteDnsDomain) | **DELETE** /domains/{dns-domain} | Delete Domain
*DnsApi* | [**deleteDnsDomainRecord**](docs/DnsApi.md#deleteDnsDomainRecord) | **DELETE** /domains/{dns-domain}/records/{record-id} | Delete Record
*DnsApi* | [**getDnsDomain**](docs/DnsApi.md#getDnsDomain) | **GET** /domains/{dns-domain} | Get DNS Domain
*DnsApi* | [**getDnsDomainDnssec**](docs/DnsApi.md#getDnsDomainDnssec) | **GET** /domains/{dns-domain}/dnssec | Get DNSSec Info
*DnsApi* | [**getDnsDomainRecord**](docs/DnsApi.md#getDnsDomainRecord) | **GET** /domains/{dns-domain}/records/{record-id} | Get Record
*DnsApi* | [**getDnsDomainSoa**](docs/DnsApi.md#getDnsDomainSoa) | **GET** /domains/{dns-domain}/soa | Get SOA information
*DnsApi* | [**listDnsDomainRecords**](docs/DnsApi.md#listDnsDomainRecords) | **GET** /domains/{dns-domain}/records | List Records
*DnsApi* | [**listDnsDomains**](docs/DnsApi.md#listDnsDomains) | **GET** /domains | List DNS Domains
*DnsApi* | [**updateDnsDomain**](docs/DnsApi.md#updateDnsDomain) | **PUT** /domains/{dns-domain} | Update a DNS Domain
*DnsApi* | [**updateDnsDomainRecord**](docs/DnsApi.md#updateDnsDomainRecord) | **PATCH** /domains/{dns-domain}/records/{record-id} | Update Record
*DnsApi* | [**updateDnsDomainSoa**](docs/DnsApi.md#updateDnsDomainSoa) | **PATCH** /domains/{dns-domain}/soa | Update SOA information
*FirewallApi* | [**createFirewallGroup**](docs/FirewallApi.md#createFirewallGroup) | **POST** /firewalls | Create Firewall Group
*FirewallApi* | [**deleteFirewallGroup**](docs/FirewallApi.md#deleteFirewallGroup) | **DELETE** /firewalls/{firewall-group-id} | Delete Firewall Group
*FirewallApi* | [**deleteFirewallGroupRule**](docs/FirewallApi.md#deleteFirewallGroupRule) | **DELETE** /firewalls/{firewall-group-id}/rules/{firewall-rule-id} | Delete Firewall Rule
*FirewallApi* | [**getFirewallGroup**](docs/FirewallApi.md#getFirewallGroup) | **GET** /firewalls/{firewall-group-id} | Get Firewall Group
*FirewallApi* | [**getFirewallGroupRule**](docs/FirewallApi.md#getFirewallGroupRule) | **GET** /firewalls/{firewall-group-id}/rules/{firewall-rule-id} | Get Firewall Rule
*FirewallApi* | [**listFirewallGroupRules**](docs/FirewallApi.md#listFirewallGroupRules) | **GET** /firewalls/{firewall-group-id}/rules | List Firewall Rules
*FirewallApi* | [**listFirewallGroups**](docs/FirewallApi.md#listFirewallGroups) | **GET** /firewalls | List Firewall Groups
*FirewallApi* | [**postFirewallsFirewallGroupIdRules**](docs/FirewallApi.md#postFirewallsFirewallGroupIdRules) | **POST** /firewalls/{firewall-group-id}/rules | Create Firewall Rules
*FirewallApi* | [**updateFirewallGroup**](docs/FirewallApi.md#updateFirewallGroup) | **PUT** /firewalls/{firewall-group-id} | Update Firewall Group
*InstancesApi* | [**attachInstanceIso**](docs/InstancesApi.md#attachInstanceIso) | **POST** /instances/{instance-id}/iso/attach | Attach ISO to Instance
*InstancesApi* | [**attachInstanceNetwork**](docs/InstancesApi.md#attachInstanceNetwork) | **POST** /instances/{instance-id}/private-networks/attach | Attach Private Network to Instance
*InstancesApi* | [**attachInstanceVpc**](docs/InstancesApi.md#attachInstanceVpc) | **POST** /instances/{instance-id}/vpcs/attach | Attach VPC to Instance
*InstancesApi* | [**attachInstanceVpc2**](docs/InstancesApi.md#attachInstanceVpc2) | **POST** /instances/{instance-id}/vpc2/attach | Attach VPC 2.0 Network to Instance
*InstancesApi* | [**createInstance**](docs/InstancesApi.md#createInstance) | **POST** /instances | Create Instance
*InstancesApi* | [**createInstanceBackupSchedule**](docs/InstancesApi.md#createInstanceBackupSchedule) | **POST** /instances/{instance-id}/backup-schedule | Set Instance Backup Schedule
*InstancesApi* | [**createInstanceIpv4**](docs/InstancesApi.md#createInstanceIpv4) | **POST** /instances/{instance-id}/ipv4 | Create IPv4
*InstancesApi* | [**createInstanceReverseIpv4**](docs/InstancesApi.md#createInstanceReverseIpv4) | **POST** /instances/{instance-id}/ipv4/reverse | Create Instance Reverse IPv4
*InstancesApi* | [**createInstanceReverseIpv6**](docs/InstancesApi.md#createInstanceReverseIpv6) | **POST** /instances/{instance-id}/ipv6/reverse | Create Instance Reverse IPv6
*InstancesApi* | [**deleteInstance**](docs/InstancesApi.md#deleteInstance) | **DELETE** /instances/{instance-id} | Delete Instance
*InstancesApi* | [**deleteInstanceIpv4**](docs/InstancesApi.md#deleteInstanceIpv4) | **DELETE** /instances/{instance-id}/ipv4/{ipv4} | Delete IPv4 Address
*InstancesApi* | [**deleteInstanceReverseIpv6**](docs/InstancesApi.md#deleteInstanceReverseIpv6) | **DELETE** /instances/{instance-id}/ipv6/reverse/{ipv6} | Delete Instance Reverse IPv6
*InstancesApi* | [**detachInstanceIso**](docs/InstancesApi.md#detachInstanceIso) | **POST** /instances/{instance-id}/iso/detach | Detach ISO from instance
*InstancesApi* | [**detachInstanceNetwork**](docs/InstancesApi.md#detachInstanceNetwork) | **POST** /instances/{instance-id}/private-networks/detach | Detach Private Network from Instance.
*InstancesApi* | [**detachInstanceVpc**](docs/InstancesApi.md#detachInstanceVpc) | **POST** /instances/{instance-id}/vpcs/detach | Detach VPC from Instance
*InstancesApi* | [**detachInstanceVpc2**](docs/InstancesApi.md#detachInstanceVpc2) | **POST** /instances/{instance-id}/vpc2/detach | Detach VPC 2.0 Network from Instance
*InstancesApi* | [**getInstance**](docs/InstancesApi.md#getInstance) | **GET** /instances/{instance-id} | Get Instance
*InstancesApi* | [**getInstanceBackupSchedule**](docs/InstancesApi.md#getInstanceBackupSchedule) | **GET** /instances/{instance-id}/backup-schedule | Get Instance Backup Schedule
*InstancesApi* | [**getInstanceBandwidth**](docs/InstancesApi.md#getInstanceBandwidth) | **GET** /instances/{instance-id}/bandwidth | Instance Bandwidth
*InstancesApi* | [**getInstanceIpv4**](docs/InstancesApi.md#getInstanceIpv4) | **GET** /instances/{instance-id}/ipv4 | List Instance IPv4 Information
*InstancesApi* | [**getInstanceIpv6**](docs/InstancesApi.md#getInstanceIpv6) | **GET** /instances/{instance-id}/ipv6 | Get Instance IPv6 Information
*InstancesApi* | [**getInstanceIsoStatus**](docs/InstancesApi.md#getInstanceIsoStatus) | **GET** /instances/{instance-id}/iso | Get Instance ISO Status
*InstancesApi* | [**getInstanceNeighbors**](docs/InstancesApi.md#getInstanceNeighbors) | **GET** /instances/{instance-id}/neighbors | Get Instance neighbors
*InstancesApi* | [**getInstanceUpgrades**](docs/InstancesApi.md#getInstanceUpgrades) | **GET** /instances/{instance-id}/upgrades | Get Available Instance Upgrades
*InstancesApi* | [**getInstanceUserdata**](docs/InstancesApi.md#getInstanceUserdata) | **GET** /instances/{instance-id}/user-data | Get Instance User Data
*InstancesApi* | [**haltInstance**](docs/InstancesApi.md#haltInstance) | **POST** /instances/{instance-id}/halt | Halt Instance
*InstancesApi* | [**haltInstances**](docs/InstancesApi.md#haltInstances) | **POST** /instances/halt | Halt Instances
*InstancesApi* | [**listInstanceIpv6Reverse**](docs/InstancesApi.md#listInstanceIpv6Reverse) | **GET** /instances/{instance-id}/ipv6/reverse | List Instance IPv6 Reverse
*InstancesApi* | [**listInstancePrivateNetworks**](docs/InstancesApi.md#listInstancePrivateNetworks) | **GET** /instances/{instance-id}/private-networks | List instance Private Networks
*InstancesApi* | [**listInstanceVpc2**](docs/InstancesApi.md#listInstanceVpc2) | **GET** /instances/{instance-id}/vpc2 | List Instance VPC 2.0 Networks
*InstancesApi* | [**listInstanceVpcs**](docs/InstancesApi.md#listInstanceVpcs) | **GET** /instances/{instance-id}/vpcs | List instance VPCs
*InstancesApi* | [**listInstances**](docs/InstancesApi.md#listInstances) | **GET** /instances | List Instances
*InstancesApi* | [**postInstancesInstanceIdIpv4ReverseDefault**](docs/InstancesApi.md#postInstancesInstanceIdIpv4ReverseDefault) | **POST** /instances/{instance-id}/ipv4/reverse/default | Set Default Reverse DNS Entry
*InstancesApi* | [**rebootInstance**](docs/InstancesApi.md#rebootInstance) | **POST** /instances/{instance-id}/reboot | Reboot Instance
*InstancesApi* | [**rebootInstances**](docs/InstancesApi.md#rebootInstances) | **POST** /instances/reboot | Reboot instances
*InstancesApi* | [**reinstallInstance**](docs/InstancesApi.md#reinstallInstance) | **POST** /instances/{instance-id}/reinstall | Reinstall Instance
*InstancesApi* | [**restoreInstance**](docs/InstancesApi.md#restoreInstance) | **POST** /instances/{instance-id}/restore | Restore Instance
*InstancesApi* | [**startInstance**](docs/InstancesApi.md#startInstance) | **POST** /instances/{instance-id}/start | Start instance
*InstancesApi* | [**startInstances**](docs/InstancesApi.md#startInstances) | **POST** /instances/start | Start instances
*InstancesApi* | [**updateInstance**](docs/InstancesApi.md#updateInstance) | **PATCH** /instances/{instance-id} | Update Instance
*IsoApi* | [**createIso**](docs/IsoApi.md#createIso) | **POST** /iso | Create ISO
*IsoApi* | [**deleteIso**](docs/IsoApi.md#deleteIso) | **DELETE** /iso/{iso-id} | Delete ISO
*IsoApi* | [**isoGet**](docs/IsoApi.md#isoGet) | **GET** /iso/{iso-id} | Get ISO
*IsoApi* | [**listIsos**](docs/IsoApi.md#listIsos) | **GET** /iso | List ISOs
*IsoApi* | [**listPublicIsos**](docs/IsoApi.md#listPublicIsos) | **GET** /iso-public | List Public ISOs
*KubernetesApi* | [**createKubernetesCluster**](docs/KubernetesApi.md#createKubernetesCluster) | **POST** /kubernetes/clusters | Create Kubernetes Cluster
*KubernetesApi* | [**createNodepools**](docs/KubernetesApi.md#createNodepools) | **POST** /kubernetes/clusters/{vke-id}/node-pools | Create NodePool
*KubernetesApi* | [**deleteKubernetesCluster**](docs/KubernetesApi.md#deleteKubernetesCluster) | **DELETE** /kubernetes/clusters/{vke-id} | Delete Kubernetes Cluster
*KubernetesApi* | [**deleteKubernetesClusterVkeIdDeleteWithLinkedResources**](docs/KubernetesApi.md#deleteKubernetesClusterVkeIdDeleteWithLinkedResources) | **DELETE** /kubernetes/clusters/{vke-id}/delete-with-linked-resources | Delete VKE Cluster and All Related Resources
*KubernetesApi* | [**deleteNodepool**](docs/KubernetesApi.md#deleteNodepool) | **DELETE** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id} | Delete Nodepool
*KubernetesApi* | [**deleteNodepoolInstance**](docs/KubernetesApi.md#deleteNodepoolInstance) | **DELETE** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id}/nodes/{node-id} | Delete NodePool Instance
*KubernetesApi* | [**getKubernetesAvailableUpgrades**](docs/KubernetesApi.md#getKubernetesAvailableUpgrades) | **GET** /kubernetes/clusters/{vke-id}/available-upgrades | Get Kubernetes Available Upgrades
*KubernetesApi* | [**getKubernetesClusters**](docs/KubernetesApi.md#getKubernetesClusters) | **GET** /kubernetes/clusters/{vke-id} | Get Kubernetes Cluster
*KubernetesApi* | [**getKubernetesClustersConfig**](docs/KubernetesApi.md#getKubernetesClustersConfig) | **GET** /kubernetes/clusters/{vke-id}/config | Get Kubernetes Cluster Kubeconfig
*KubernetesApi* | [**getKubernetesResources**](docs/KubernetesApi.md#getKubernetesResources) | **GET** /kubernetes/clusters/{vke-id}/resources | Get Kubernetes Resources
*KubernetesApi* | [**getKubernetesVersions**](docs/KubernetesApi.md#getKubernetesVersions) | **GET** /kubernetes/versions | Get Kubernetes Versions
*KubernetesApi* | [**getNodepool**](docs/KubernetesApi.md#getNodepool) | **GET** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id} | Get NodePool
*KubernetesApi* | [**getNodepools**](docs/KubernetesApi.md#getNodepools) | **GET** /kubernetes/clusters/{vke-id}/node-pools | List NodePools
*KubernetesApi* | [**listKubernetesClusters**](docs/KubernetesApi.md#listKubernetesClusters) | **GET** /kubernetes/clusters | List all Kubernetes Clusters
*KubernetesApi* | [**recycleNodepoolInstance**](docs/KubernetesApi.md#recycleNodepoolInstance) | **POST** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id}/nodes/{node-id}/recycle | Recycle a NodePool Instance
*KubernetesApi* | [**startKubernetesClusterUpgrade**](docs/KubernetesApi.md#startKubernetesClusterUpgrade) | **POST** /kubernetes/clusters/{vke-id}/upgrades | Start Kubernetes Cluster Upgrade
*KubernetesApi* | [**updateKubernetesCluster**](docs/KubernetesApi.md#updateKubernetesCluster) | **PUT** /kubernetes/clusters/{vke-id} | Update Kubernetes Cluster
*KubernetesApi* | [**updateNodepool**](docs/KubernetesApi.md#updateNodepool) | **PATCH** /kubernetes/clusters/{vke-id}/node-pools/{nodepool-id} | Update Nodepool
*LoadBalancerApi* | [**createLoadBalancer**](docs/LoadBalancerApi.md#createLoadBalancer) | **POST** /load-balancers | Create Load Balancer
*LoadBalancerApi* | [**createLoadBalancerForwardingRules**](docs/LoadBalancerApi.md#createLoadBalancerForwardingRules) | **POST** /load-balancers/{load-balancer-id}/forwarding-rules | Create Forwarding Rule
*LoadBalancerApi* | [**deleteLoadBalancer**](docs/LoadBalancerApi.md#deleteLoadBalancer) | **DELETE** /load-balancers/{load-balancer-id} | Delete Load Balancer
*LoadBalancerApi* | [**deleteLoadBalancerForwardingRule**](docs/LoadBalancerApi.md#deleteLoadBalancerForwardingRule) | **DELETE** /load-balancers/{load-balancer-id}/forwarding-rules/{forwarding-rule-id} | Delete Forwarding Rule
*LoadBalancerApi* | [**deleteLoadBalancerSsl**](docs/LoadBalancerApi.md#deleteLoadBalancerSsl) | **DELETE** /load-balancers/{load-balancer-id}/ssl | Delete Load Balancer SSL
*LoadBalancerApi* | [**getLoadBalancer**](docs/LoadBalancerApi.md#getLoadBalancer) | **GET** /load-balancers/{load-balancer-id} | Get Load Balancer
*LoadBalancerApi* | [**getLoadBalancerForwardingRule**](docs/LoadBalancerApi.md#getLoadBalancerForwardingRule) | **GET** /load-balancers/{load-balancer-id}/forwarding-rules/{forwarding-rule-id} | Get Forwarding Rule
*LoadBalancerApi* | [**getLoadbalancerFirewallRule**](docs/LoadBalancerApi.md#getLoadbalancerFirewallRule) | **GET** /load-balancers/{loadbalancer-id}/firewall-rules/{firewall-rule-id} | Get Firewall Rule
*LoadBalancerApi* | [**listLoadBalancerForwardingRules**](docs/LoadBalancerApi.md#listLoadBalancerForwardingRules) | **GET** /load-balancers/{load-balancer-id}/forwarding-rules | List Forwarding Rules
*LoadBalancerApi* | [**listLoadBalancers**](docs/LoadBalancerApi.md#listLoadBalancers) | **GET** /load-balancers | List Load Balancers
*LoadBalancerApi* | [**listLoadbalancerFirewallRules**](docs/LoadBalancerApi.md#listLoadbalancerFirewallRules) | **GET** /load-balancers/{loadbalancer-id}/firewall-rules | List Firewall Rules
*LoadBalancerApi* | [**updateLoadBalancer**](docs/LoadBalancerApi.md#updateLoadBalancer) | **PATCH** /load-balancers/{load-balancer-id} | Update Load Balancer
*ManagedDatabasesApi* | [**createConnectionPool**](docs/ManagedDatabasesApi.md#createConnectionPool) | **POST** /databases/{database-id}/connection-pools | Create Connection Pool
*ManagedDatabasesApi* | [**createDatabase**](docs/ManagedDatabasesApi.md#createDatabase) | **POST** /databases | Create Managed Database
*ManagedDatabasesApi* | [**createDatabaseDb**](docs/ManagedDatabasesApi.md#createDatabaseDb) | **POST** /databases/{database-id}/dbs | Create Logical Database
*ManagedDatabasesApi* | [**createDatabaseUser**](docs/ManagedDatabasesApi.md#createDatabaseUser) | **POST** /databases/{database-id}/users | Create Database User
*ManagedDatabasesApi* | [**databaseAddReadReplica**](docs/ManagedDatabasesApi.md#databaseAddReadReplica) | **POST** /databases/{database-id}/read-replica | Add Read-Only Replica
*ManagedDatabasesApi* | [**databaseDetachMigration**](docs/ManagedDatabasesApi.md#databaseDetachMigration) | **DELETE** /databases/{database-id}/migration | Detach Migration
*ManagedDatabasesApi* | [**databaseFork**](docs/ManagedDatabasesApi.md#databaseFork) | **POST** /databases/{database-id}/fork | Fork Managed Database
*ManagedDatabasesApi* | [**databasePromoteReadReplica**](docs/ManagedDatabasesApi.md#databasePromoteReadReplica) | **POST** /databases/{database-id}/promote-read-replica | Promote Read-Only Replica
*ManagedDatabasesApi* | [**databaseRestoreFromBackup**](docs/ManagedDatabasesApi.md#databaseRestoreFromBackup) | **POST** /databases/{database-id}/restore | Restore from Backup
*ManagedDatabasesApi* | [**databaseStartMigration**](docs/ManagedDatabasesApi.md#databaseStartMigration) | **POST** /databases/{database-id}/migration | Start Migration
*ManagedDatabasesApi* | [**deleteConnectionPool**](docs/ManagedDatabasesApi.md#deleteConnectionPool) | **DELETE** /databases/{database-id}/connection-pools/{pool-name} | Delete Connection Pool
*ManagedDatabasesApi* | [**deleteDatabase**](docs/ManagedDatabasesApi.md#deleteDatabase) | **DELETE** /databases/{database-id} | Delete Managed Database
*ManagedDatabasesApi* | [**deleteDatabaseDb**](docs/ManagedDatabasesApi.md#deleteDatabaseDb) | **DELETE** /databases/{database-id}/dbs/{db-name} | Delete Logical Database
*ManagedDatabasesApi* | [**deleteDatabaseUser**](docs/ManagedDatabasesApi.md#deleteDatabaseUser) | **DELETE** /databases/{database-id}/users/{username} | Delete Database User
*ManagedDatabasesApi* | [**getBackupInformation**](docs/ManagedDatabasesApi.md#getBackupInformation) | **GET** /databases/{database-id}/backups | Get Backup Information
*ManagedDatabasesApi* | [**getConnectionPool**](docs/ManagedDatabasesApi.md#getConnectionPool) | **GET** /databases/{database-id}/connection-pools/{pool-name} | Get Connection Pool
*ManagedDatabasesApi* | [**getDatabase**](docs/ManagedDatabasesApi.md#getDatabase) | **GET** /databases/{database-id} | Get Managed Database
*ManagedDatabasesApi* | [**getDatabaseDb**](docs/ManagedDatabasesApi.md#getDatabaseDb) | **GET** /databases/{database-id}/dbs/{db-name} | Get Logical Database
*ManagedDatabasesApi* | [**getDatabaseUsage**](docs/ManagedDatabasesApi.md#getDatabaseUsage) | **GET** /databases/{database-id}/usage | Get Database Usage Information
*ManagedDatabasesApi* | [**getDatabaseUser**](docs/ManagedDatabasesApi.md#getDatabaseUser) | **GET** /databases/{database-id}/users/{username} | Get Database User
*ManagedDatabasesApi* | [**listAdvancedOptions**](docs/ManagedDatabasesApi.md#listAdvancedOptions) | **GET** /databases/{database-id}/advanced-options | List Advanced Options
*ManagedDatabasesApi* | [**listAvailableVersions**](docs/ManagedDatabasesApi.md#listAvailableVersions) | **GET** /databases/{database-id}/version-upgrade | List Available Versions
*ManagedDatabasesApi* | [**listConnectionPools**](docs/ManagedDatabasesApi.md#listConnectionPools) | **GET** /databases/{database-id}/connection-pools | List Connection Pools
*ManagedDatabasesApi* | [**listDatabaseDbs**](docs/ManagedDatabasesApi.md#listDatabaseDbs) | **GET** /databases/{database-id}/dbs | List Logical Databases
*ManagedDatabasesApi* | [**listDatabasePlans**](docs/ManagedDatabasesApi.md#listDatabasePlans) | **GET** /databases/plans | List Managed Database Plans
*ManagedDatabasesApi* | [**listDatabaseUsers**](docs/ManagedDatabasesApi.md#listDatabaseUsers) | **GET** /databases/{database-id}/users | List Database Users
*ManagedDatabasesApi* | [**listDatabases**](docs/ManagedDatabasesApi.md#listDatabases) | **GET** /databases | List Managed Databases
*ManagedDatabasesApi* | [**listMaintenanceUpdates**](docs/ManagedDatabasesApi.md#listMaintenanceUpdates) | **GET** /databases/{database-id}/maintenance | List Maintenance Updates
*ManagedDatabasesApi* | [**listServiceAlerts**](docs/ManagedDatabasesApi.md#listServiceAlerts) | **POST** /databases/{database-id}/alerts | List Service Alerts
*ManagedDatabasesApi* | [**setDatabaseUserAcl**](docs/ManagedDatabasesApi.md#setDatabaseUserAcl) | **PUT** /databases/{database-id}/users/{username}/access-control | Set Database User Access Control
*ManagedDatabasesApi* | [**startMaintenanceUpdates**](docs/ManagedDatabasesApi.md#startMaintenanceUpdates) | **POST** /databases/{database-id}/maintenance | Start Maintenance Updates
*ManagedDatabasesApi* | [**startVersionUpgrade**](docs/ManagedDatabasesApi.md#startVersionUpgrade) | **POST** /databases/{database-id}/version-upgrade | Start Version Upgrade
*ManagedDatabasesApi* | [**updateAdvancedOptions**](docs/ManagedDatabasesApi.md#updateAdvancedOptions) | **PUT** /databases/{database-id}/advanced-options | Update Advanced Options
*ManagedDatabasesApi* | [**updateConnectionPool**](docs/ManagedDatabasesApi.md#updateConnectionPool) | **PUT** /databases/{database-id}/connection-pools/{pool-name} | Update Connection Pool
*ManagedDatabasesApi* | [**updateDatabase**](docs/ManagedDatabasesApi.md#updateDatabase) | **PUT** /databases/{database-id} | Update Managed Database
*ManagedDatabasesApi* | [**updateDatabaseUser**](docs/ManagedDatabasesApi.md#updateDatabaseUser) | **PUT** /databases/{database-id}/users/{username} | Update Database User
*ManagedDatabasesApi* | [**viewMigrationStatus**](docs/ManagedDatabasesApi.md#viewMigrationStatus) | **GET** /databases/{database-id}/migration | Get Migration Status
*OsApi* | [**listOs**](docs/OsApi.md#listOs) | **GET** /os | List OS
*PlansApi* | [**listMetalPlans**](docs/PlansApi.md#listMetalPlans) | **GET** /plans-metal | List Bare Metal Plans
*PlansApi* | [**listPlans**](docs/PlansApi.md#listPlans) | **GET** /plans | List Plans
*PrivateNetworksApi* | [**createNetwork**](docs/PrivateNetworksApi.md#createNetwork) | **POST** /private-networks | Create a Private Network
*PrivateNetworksApi* | [**deleteNetwork**](docs/PrivateNetworksApi.md#deleteNetwork) | **DELETE** /private-networks/{network-id} | Delete a private network
*PrivateNetworksApi* | [**getNetwork**](docs/PrivateNetworksApi.md#getNetwork) | **GET** /private-networks/{network-id} | Get a private network
*PrivateNetworksApi* | [**listNetworks**](docs/PrivateNetworksApi.md#listNetworks) | **GET** /private-networks | List Private Networks
*PrivateNetworksApi* | [**updateNetwork**](docs/PrivateNetworksApi.md#updateNetwork) | **PUT** /private-networks/{network-id} | Update a Private Network
*RegionApi* | [**listAvailablePlansRegion**](docs/RegionApi.md#listAvailablePlansRegion) | **GET** /regions/{region-id}/availability | List available plans in region
*RegionApi* | [**listRegions**](docs/RegionApi.md#listRegions) | **GET** /regions | List Regions
*ReservedIpApi* | [**attachReservedIp**](docs/ReservedIpApi.md#attachReservedIp) | **POST** /reserved-ips/{reserved-ip}/attach | Attach Reserved IP
*ReservedIpApi* | [**convertReservedIp**](docs/ReservedIpApi.md#convertReservedIp) | **POST** /reserved-ips/convert | Convert Instance IP to Reserved IP
*ReservedIpApi* | [**createReservedIp**](docs/ReservedIpApi.md#createReservedIp) | **POST** /reserved-ips | Create Reserved IP
*ReservedIpApi* | [**deleteReservedIp**](docs/ReservedIpApi.md#deleteReservedIp) | **DELETE** /reserved-ips/{reserved-ip} | Delete Reserved IP
*ReservedIpApi* | [**detachReservedIp**](docs/ReservedIpApi.md#detachReservedIp) | **POST** /reserved-ips/{reserved-ip}/detach | Detach Reserved IP
*ReservedIpApi* | [**getReservedIp**](docs/ReservedIpApi.md#getReservedIp) | **GET** /reserved-ips/{reserved-ip} | Get Reserved IP
*ReservedIpApi* | [**listReservedIps**](docs/ReservedIpApi.md#listReservedIps) | **GET** /reserved-ips | List Reserved IPs
*ReservedIpApi* | [**patchReservedIpsReservedIp**](docs/ReservedIpApi.md#patchReservedIpsReservedIp) | **PATCH** /reserved-ips/{reserved-ip} | Update Reserved IP
*S3Api* | [**createObjectStorage**](docs/S3Api.md#createObjectStorage) | **POST** /object-storage | Create Object Storage
*S3Api* | [**deleteObjectStorage**](docs/S3Api.md#deleteObjectStorage) | **DELETE** /object-storage/{object-storage-id} | Delete Object Storage
*S3Api* | [**getObjectStorage**](docs/S3Api.md#getObjectStorage) | **GET** /object-storage/{object-storage-id} | Get Object Storage
*S3Api* | [**listObjectStorageClusters**](docs/S3Api.md#listObjectStorageClusters) | **GET** /object-storage/clusters | Get All Clusters
*S3Api* | [**listObjectStorages**](docs/S3Api.md#listObjectStorages) | **GET** /object-storage | List Object Storages
*S3Api* | [**regenerateObjectStorageKeys**](docs/S3Api.md#regenerateObjectStorageKeys) | **POST** /object-storage/{object-storage-id}/regenerate-keys | Regenerate Object Storage Keys
*S3Api* | [**updateObjectStorage**](docs/S3Api.md#updateObjectStorage) | **PUT** /object-storage/{object-storage-id} | Update Object Storage
*SnapshotApi* | [**createSnapshot**](docs/SnapshotApi.md#createSnapshot) | **POST** /snapshots | Create Snapshot
*SnapshotApi* | [**createSnapshotCreateFromUrl**](docs/SnapshotApi.md#createSnapshotCreateFromUrl) | **POST** /snapshots/create-from-url | Create Snapshot from URL
*SnapshotApi* | [**deleteSnapshot**](docs/SnapshotApi.md#deleteSnapshot) | **DELETE** /snapshots/{snapshot-id} | Delete Snapshot
*SnapshotApi* | [**getSnapshot**](docs/SnapshotApi.md#getSnapshot) | **GET** /snapshots/{snapshot-id} | Get Snapshot
*SnapshotApi* | [**listSnapshots**](docs/SnapshotApi.md#listSnapshots) | **GET** /snapshots | List Snapshots
*SnapshotApi* | [**putSnapshotsSnapshotId**](docs/SnapshotApi.md#putSnapshotsSnapshotId) | **PUT** /snapshots/{snapshot-id} | Update Snapshot
*SshApi* | [**createSshKey**](docs/SshApi.md#createSshKey) | **POST** /ssh-keys | Create SSH key
*SshApi* | [**deleteSshKey**](docs/SshApi.md#deleteSshKey) | **DELETE** /ssh-keys/{ssh-key-id} | Delete SSH Key
*SshApi* | [**getSshKey**](docs/SshApi.md#getSshKey) | **GET** /ssh-keys/{ssh-key-id} | Get SSH Key
*SshApi* | [**listSshKeys**](docs/SshApi.md#listSshKeys) | **GET** /ssh-keys | List SSH Keys
*SshApi* | [**updateSshKey**](docs/SshApi.md#updateSshKey) | **PATCH** /ssh-keys/{ssh-key-id} | Update SSH Key
*StartupApi* | [**createStartupScript**](docs/StartupApi.md#createStartupScript) | **POST** /startup-scripts | Create Startup Script
*StartupApi* | [**deleteStartupScript**](docs/StartupApi.md#deleteStartupScript) | **DELETE** /startup-scripts/{startup-id} | Delete Startup Script
*StartupApi* | [**getStartupScript**](docs/StartupApi.md#getStartupScript) | **GET** /startup-scripts/{startup-id} | Get Startup Script
*StartupApi* | [**listStartupScripts**](docs/StartupApi.md#listStartupScripts) | **GET** /startup-scripts | List Startup Scripts
*StartupApi* | [**updateStartupScript**](docs/StartupApi.md#updateStartupScript) | **PATCH** /startup-scripts/{startup-id} | Update Startup Script
*SubaccountApi* | [**createSubaccount**](docs/SubaccountApi.md#createSubaccount) | **POST** /subaccounts | Create Sub-Account
*SubaccountApi* | [**listSubaccounts**](docs/SubaccountApi.md#listSubaccounts) | **GET** /subaccounts | List Sub-Accounts
*UsersApi* | [**createUser**](docs/UsersApi.md#createUser) | **POST** /users | Create User
*UsersApi* | [**deleteUser**](docs/UsersApi.md#deleteUser) | **DELETE** /users/{user-id} | Delete User
*UsersApi* | [**getUser**](docs/UsersApi.md#getUser) | **GET** /users/{user-id} | Get User
*UsersApi* | [**listUsers**](docs/UsersApi.md#listUsers) | **GET** /users | Get Users
*UsersApi* | [**updateUser**](docs/UsersApi.md#updateUser) | **PATCH** /users/{user-id} | Update User
*Vpc2Api* | [**attachVpc2Nodes**](docs/Vpc2Api.md#attachVpc2Nodes) | **POST** /vpc2/{vpc-id}/nodes/attach | Attach nodes to a VPC 2.0 network
*Vpc2Api* | [**createVpc2**](docs/Vpc2Api.md#createVpc2) | **POST** /vpc2 | Create a VPC 2.0 network
*Vpc2Api* | [**deleteVpc2**](docs/Vpc2Api.md#deleteVpc2) | **DELETE** /vpc2/{vpc-id} | Delete a VPC 2.0 network
*Vpc2Api* | [**detachVpc2Nodes**](docs/Vpc2Api.md#detachVpc2Nodes) | **POST** /vpc2/{vpc-id}/nodes/detach | Remove nodes from a VPC 2.0 network
*Vpc2Api* | [**getVpc2**](docs/Vpc2Api.md#getVpc2) | **GET** /vpc2/{vpc-id} | Get a VPC 2.0 network
*Vpc2Api* | [**listVpc2**](docs/Vpc2Api.md#listVpc2) | **GET** /vpc2 | List VPC 2.0 networks
*Vpc2Api* | [**listVpc2Nodes**](docs/Vpc2Api.md#listVpc2Nodes) | **GET** /vpc2/{vpc-id}/nodes | Get a list of nodes attached to a VPC 2.0 network
*Vpc2Api* | [**updateVpc2**](docs/Vpc2Api.md#updateVpc2) | **PUT** /vpc2/{vpc-id} | Update a VPC 2.0 network
*VpcsApi* | [**createVpc**](docs/VpcsApi.md#createVpc) | **POST** /vpcs | Create a VPC
*VpcsApi* | [**deleteVpc**](docs/VpcsApi.md#deleteVpc) | **DELETE** /vpcs/{vpc-id} | Delete a VPC
*VpcsApi* | [**getVpc**](docs/VpcsApi.md#getVpc) | **GET** /vpcs/{vpc-id} | Get a VPC
*VpcsApi* | [**listVpcs**](docs/VpcsApi.md#listVpcs) | **GET** /vpcs | List VPCs
*VpcsApi* | [**updateVpc**](docs/VpcsApi.md#updateVpc) | **PUT** /vpcs/{vpc-id} | Update a VPC


## Documentation for Models

 - [Account](docs/Account.md)
 - [Application](docs/Application.md)
 - [AttachBaremetalsVpc2Request](docs/AttachBaremetalsVpc2Request.md)
 - [AttachBlockRequest](docs/AttachBlockRequest.md)
 - [AttachInstanceIso202Response](docs/AttachInstanceIso202Response.md)
 - [AttachInstanceIso202ResponseIsoStatus](docs/AttachInstanceIso202ResponseIsoStatus.md)
 - [AttachInstanceIsoRequest](docs/AttachInstanceIsoRequest.md)
 - [AttachInstanceNetworkRequest](docs/AttachInstanceNetworkRequest.md)
 - [AttachInstanceVpc2Request](docs/AttachInstanceVpc2Request.md)
 - [AttachInstanceVpcRequest](docs/AttachInstanceVpcRequest.md)
 - [AttachReservedIpRequest](docs/AttachReservedIpRequest.md)
 - [AttachVpc2NodesRequest](docs/AttachVpc2NodesRequest.md)
 - [Backup](docs/Backup.md)
 - [BackupSchedule](docs/BackupSchedule.md)
 - [Bandwidth](docs/Bandwidth.md)
 - [Baremetal](docs/Baremetal.md)
 - [BaremetalIpv4](docs/BaremetalIpv4.md)
 - [BaremetalIpv6](docs/BaremetalIpv6.md)
 - [Billing](docs/Billing.md)
 - [Blockstorage](docs/Blockstorage.md)
 - [Clusters](docs/Clusters.md)
 - [ConnectionPool](docs/ConnectionPool.md)
 - [ConvertReservedIpRequest](docs/ConvertReservedIpRequest.md)
 - [CreateBaremetal202Response](docs/CreateBaremetal202Response.md)
 - [CreateBaremetalRequest](docs/CreateBaremetalRequest.md)
 - [CreateBlock202Response](docs/CreateBlock202Response.md)
 - [CreateBlockRequest](docs/CreateBlockRequest.md)
 - [CreateConnectionPool202Response](docs/CreateConnectionPool202Response.md)
 - [CreateConnectionPoolRequest](docs/CreateConnectionPoolRequest.md)
 - [CreateDatabase202Response](docs/CreateDatabase202Response.md)
 - [CreateDatabaseDb202Response](docs/CreateDatabaseDb202Response.md)
 - [CreateDatabaseDbRequest](docs/CreateDatabaseDbRequest.md)
 - [CreateDatabaseRequest](docs/CreateDatabaseRequest.md)
 - [CreateDatabaseUser202Response](docs/CreateDatabaseUser202Response.md)
 - [CreateDatabaseUserRequest](docs/CreateDatabaseUserRequest.md)
 - [CreateDnsDomain200Response](docs/CreateDnsDomain200Response.md)
 - [CreateDnsDomainRecord201Response](docs/CreateDnsDomainRecord201Response.md)
 - [CreateDnsDomainRecordRequest](docs/CreateDnsDomainRecordRequest.md)
 - [CreateDnsDomainRequest](docs/CreateDnsDomainRequest.md)
 - [CreateFirewallGroup201Response](docs/CreateFirewallGroup201Response.md)
 - [CreateFirewallGroupRequest](docs/CreateFirewallGroupRequest.md)
 - [CreateInstance202Response](docs/CreateInstance202Response.md)
 - [CreateInstanceBackupScheduleRequest](docs/CreateInstanceBackupScheduleRequest.md)
 - [CreateInstanceIpv4Request](docs/CreateInstanceIpv4Request.md)
 - [CreateInstanceRequest](docs/CreateInstanceRequest.md)
 - [CreateInstanceReverseIpv4Request](docs/CreateInstanceReverseIpv4Request.md)
 - [CreateInstanceReverseIpv6Request](docs/CreateInstanceReverseIpv6Request.md)
 - [CreateIso201Response](docs/CreateIso201Response.md)
 - [CreateIsoRequest](docs/CreateIsoRequest.md)
 - [CreateKubernetesCluster201Response](docs/CreateKubernetesCluster201Response.md)
 - [CreateKubernetesClusterRequest](docs/CreateKubernetesClusterRequest.md)
 - [CreateKubernetesClusterRequestNodePoolsInner](docs/CreateKubernetesClusterRequestNodePoolsInner.md)
 - [CreateLoadBalancer202Response](docs/CreateLoadBalancer202Response.md)
 - [CreateLoadBalancerForwardingRulesRequest](docs/CreateLoadBalancerForwardingRulesRequest.md)
 - [CreateLoadBalancerRequest](docs/CreateLoadBalancerRequest.md)
 - [CreateLoadBalancerRequestFirewallRulesInner](docs/CreateLoadBalancerRequestFirewallRulesInner.md)
 - [CreateLoadBalancerRequestForwardingRulesInner](docs/CreateLoadBalancerRequestForwardingRulesInner.md)
 - [CreateLoadBalancerRequestHealthCheck](docs/CreateLoadBalancerRequestHealthCheck.md)
 - [CreateLoadBalancerRequestSsl](docs/CreateLoadBalancerRequestSsl.md)
 - [CreateLoadBalancerRequestStickySession](docs/CreateLoadBalancerRequestStickySession.md)
 - [CreateNetworkRequest](docs/CreateNetworkRequest.md)
 - [CreateNodepools201Response](docs/CreateNodepools201Response.md)
 - [CreateNodepoolsRequest](docs/CreateNodepoolsRequest.md)
 - [CreateObjectStorage202Response](docs/CreateObjectStorage202Response.md)
 - [CreateObjectStorageRequest](docs/CreateObjectStorageRequest.md)
 - [CreateRegistryRequest](docs/CreateRegistryRequest.md)
 - [CreateReservedIpRequest](docs/CreateReservedIpRequest.md)
 - [CreateSnapshotCreateFromUrlRequest](docs/CreateSnapshotCreateFromUrlRequest.md)
 - [CreateSnapshotRequest](docs/CreateSnapshotRequest.md)
 - [CreateSshKeyRequest](docs/CreateSshKeyRequest.md)
 - [CreateStartupScriptRequest](docs/CreateStartupScriptRequest.md)
 - [CreateSubaccount201Response](docs/CreateSubaccount201Response.md)
 - [CreateSubaccountRequest](docs/CreateSubaccountRequest.md)
 - [CreateUserRequest](docs/CreateUserRequest.md)
 - [CreateVpc2Request](docs/CreateVpc2Request.md)
 - [CreateVpcRequest](docs/CreateVpcRequest.md)
 - [Database](docs/Database.md)
 - [DatabaseAddReadReplicaRequest](docs/DatabaseAddReadReplicaRequest.md)
 - [DatabaseConnections](docs/DatabaseConnections.md)
 - [DatabaseDb](docs/DatabaseDb.md)
 - [DatabaseFerretdbCredentials](docs/DatabaseFerretdbCredentials.md)
 - [DatabaseForkRequest](docs/DatabaseForkRequest.md)
 - [DatabaseLatestBackup](docs/DatabaseLatestBackup.md)
 - [DatabaseOldestBackup](docs/DatabaseOldestBackup.md)
 - [DatabaseRestoreFromBackupRequest](docs/DatabaseRestoreFromBackupRequest.md)
 - [DatabaseStartMigrationRequest](docs/DatabaseStartMigrationRequest.md)
 - [DatabaseUsage](docs/DatabaseUsage.md)
 - [DatabaseUsageCpu](docs/DatabaseUsageCpu.md)
 - [DatabaseUsageDisk](docs/DatabaseUsageDisk.md)
 - [DatabaseUsageMemory](docs/DatabaseUsageMemory.md)
 - [DatabaseUser](docs/DatabaseUser.md)
 - [DatabaseUserAccessControl](docs/DatabaseUserAccessControl.md)
 - [DbaasAlerts](docs/DbaasAlerts.md)
 - [DbaasAvailableOptions](docs/DbaasAvailableOptions.md)
 - [DbaasMeta](docs/DbaasMeta.md)
 - [DbaasMigration](docs/DbaasMigration.md)
 - [DbaasMigrationCredentials](docs/DbaasMigrationCredentials.md)
 - [DbaasPlan](docs/DbaasPlan.md)
 - [DetachBaremetalVpc2Request](docs/DetachBaremetalVpc2Request.md)
 - [DetachBlockRequest](docs/DetachBlockRequest.md)
 - [DetachInstanceIso202Response](docs/DetachInstanceIso202Response.md)
 - [DetachInstanceIso202ResponseIsoStatus](docs/DetachInstanceIso202ResponseIsoStatus.md)
 - [DetachInstanceNetworkRequest](docs/DetachInstanceNetworkRequest.md)
 - [DetachInstanceVpc2Request](docs/DetachInstanceVpc2Request.md)
 - [DetachInstanceVpcRequest](docs/DetachInstanceVpcRequest.md)
 - [DetachVpc2NodesRequest](docs/DetachVpc2NodesRequest.md)
 - [DnsRecord](docs/DnsRecord.md)
 - [DnsSoa](docs/DnsSoa.md)
 - [Domain](docs/Domain.md)
 - [FirewallGroup](docs/FirewallGroup.md)
 - [FirewallRule](docs/FirewallRule.md)
 - [ForwardingRule](docs/ForwardingRule.md)
 - [GetAccount200Response](docs/GetAccount200Response.md)
 - [GetBackup200Response](docs/GetBackup200Response.md)
 - [GetBackupInformation200Response](docs/GetBackupInformation200Response.md)
 - [GetBandwidthBaremetal200Response](docs/GetBandwidthBaremetal200Response.md)
 - [GetBandwidthBaremetal200ResponseBandwidth](docs/GetBandwidthBaremetal200ResponseBandwidth.md)
 - [GetBareMetalUserdata200Response](docs/GetBareMetalUserdata200Response.md)
 - [GetBareMetalUserdata200ResponseUserData](docs/GetBareMetalUserdata200ResponseUserData.md)
 - [GetBareMetalVnc200Response](docs/GetBareMetalVnc200Response.md)
 - [GetBareMetalVnc200ResponseVnc](docs/GetBareMetalVnc200ResponseVnc.md)
 - [GetBareMetalsUpgrades200Response](docs/GetBareMetalsUpgrades200Response.md)
 - [GetBareMetalsUpgrades200ResponseUpgrades](docs/GetBareMetalsUpgrades200ResponseUpgrades.md)
 - [GetBaremetal200Response](docs/GetBaremetal200Response.md)
 - [GetDatabaseUsage200Response](docs/GetDatabaseUsage200Response.md)
 - [GetDnsDomainDnssec200Response](docs/GetDnsDomainDnssec200Response.md)
 - [GetDnsDomainSoa200Response](docs/GetDnsDomainSoa200Response.md)
 - [GetInstanceBackupSchedule200Response](docs/GetInstanceBackupSchedule200Response.md)
 - [GetInstanceIsoStatus200Response](docs/GetInstanceIsoStatus200Response.md)
 - [GetInstanceIsoStatus200ResponseIsoStatus](docs/GetInstanceIsoStatus200ResponseIsoStatus.md)
 - [GetInstanceNeighbors200Response](docs/GetInstanceNeighbors200Response.md)
 - [GetInstanceUpgrades200Response](docs/GetInstanceUpgrades200Response.md)
 - [GetInstanceUpgrades200ResponseUpgrades](docs/GetInstanceUpgrades200ResponseUpgrades.md)
 - [GetInstanceUserdata200Response](docs/GetInstanceUserdata200Response.md)
 - [GetInstanceUserdata200ResponseUserData](docs/GetInstanceUserdata200ResponseUserData.md)
 - [GetInvoice200Response](docs/GetInvoice200Response.md)
 - [GetInvoiceItems200Response](docs/GetInvoiceItems200Response.md)
 - [GetInvoiceItems200ResponseInvoiceItemsInner](docs/GetInvoiceItems200ResponseInvoiceItemsInner.md)
 - [GetInvoiceItems200ResponseMeta](docs/GetInvoiceItems200ResponseMeta.md)
 - [GetInvoiceItems200ResponseMetaLinks](docs/GetInvoiceItems200ResponseMetaLinks.md)
 - [GetIpv4Baremetal200Response](docs/GetIpv4Baremetal200Response.md)
 - [GetIpv6Baremetal200Response](docs/GetIpv6Baremetal200Response.md)
 - [GetKubernetesAvailableUpgrades200Response](docs/GetKubernetesAvailableUpgrades200Response.md)
 - [GetKubernetesClustersConfig200Response](docs/GetKubernetesClustersConfig200Response.md)
 - [GetKubernetesResources200Response](docs/GetKubernetesResources200Response.md)
 - [GetKubernetesResources200ResponseResources](docs/GetKubernetesResources200ResponseResources.md)
 - [GetKubernetesResources200ResponseResourcesBlockStorageInner](docs/GetKubernetesResources200ResponseResourcesBlockStorageInner.md)
 - [GetKubernetesResources200ResponseResourcesLoadBalancerInner](docs/GetKubernetesResources200ResponseResourcesLoadBalancerInner.md)
 - [GetKubernetesVersions200Response](docs/GetKubernetesVersions200Response.md)
 - [GetLoadBalancerForwardingRule200Response](docs/GetLoadBalancerForwardingRule200Response.md)
 - [GetNetwork200Response](docs/GetNetwork200Response.md)
 - [GetNodepools200Response](docs/GetNodepools200Response.md)
 - [GetReservedIp200Response](docs/GetReservedIp200Response.md)
 - [GetSnapshot200Response](docs/GetSnapshot200Response.md)
 - [GetSshKey200Response](docs/GetSshKey200Response.md)
 - [GetStartupScript200Response](docs/GetStartupScript200Response.md)
 - [GetVpc200Response](docs/GetVpc200Response.md)
 - [GetVpc2200Response](docs/GetVpc2200Response.md)
 - [HaltBaremetalsRequest](docs/HaltBaremetalsRequest.md)
 - [HaltInstancesRequest](docs/HaltInstancesRequest.md)
 - [Instance](docs/Instance.md)
 - [InstanceV6NetworksInner](docs/InstanceV6NetworksInner.md)
 - [InstanceVpc2](docs/InstanceVpc2.md)
 - [Invoice](docs/Invoice.md)
 - [Iso](docs/Iso.md)
 - [IsoPublic](docs/IsoPublic.md)
 - [ListAdvancedOptions200Response](docs/ListAdvancedOptions200Response.md)
 - [ListApplications200Response](docs/ListApplications200Response.md)
 - [ListAvailablePlansRegion200Response](docs/ListAvailablePlansRegion200Response.md)
 - [ListAvailableVersions200Response](docs/ListAvailableVersions200Response.md)
 - [ListBackups200Response](docs/ListBackups200Response.md)
 - [ListBaremetalVpc2200Response](docs/ListBaremetalVpc2200Response.md)
 - [ListBaremetals200Response](docs/ListBaremetals200Response.md)
 - [ListBillingHistory200Response](docs/ListBillingHistory200Response.md)
 - [ListBlocks200Response](docs/ListBlocks200Response.md)
 - [ListConnectionPools200Response](docs/ListConnectionPools200Response.md)
 - [ListDatabaseDbs200Response](docs/ListDatabaseDbs200Response.md)
 - [ListDatabasePlans200Response](docs/ListDatabasePlans200Response.md)
 - [ListDatabaseUsers200Response](docs/ListDatabaseUsers200Response.md)
 - [ListDatabases200Response](docs/ListDatabases200Response.md)
 - [ListDnsDomainRecords200Response](docs/ListDnsDomainRecords200Response.md)
 - [ListDnsDomains200Response](docs/ListDnsDomains200Response.md)
 - [ListFirewallGroupRules200Response](docs/ListFirewallGroupRules200Response.md)
 - [ListFirewallGroups200Response](docs/ListFirewallGroups200Response.md)
 - [ListInstanceIpv6Reverse200Response](docs/ListInstanceIpv6Reverse200Response.md)
 - [ListInstanceIpv6Reverse200ResponseReverseIpv6sInner](docs/ListInstanceIpv6Reverse200ResponseReverseIpv6sInner.md)
 - [ListInstancePrivateNetworks200Response](docs/ListInstancePrivateNetworks200Response.md)
 - [ListInstanceVpc2200Response](docs/ListInstanceVpc2200Response.md)
 - [ListInstanceVpcs200Response](docs/ListInstanceVpcs200Response.md)
 - [ListInstances200Response](docs/ListInstances200Response.md)
 - [ListInvoices200Response](docs/ListInvoices200Response.md)
 - [ListIsos200Response](docs/ListIsos200Response.md)
 - [ListKubernetesClusters200Response](docs/ListKubernetesClusters200Response.md)
 - [ListLoadBalancerForwardingRules200Response](docs/ListLoadBalancerForwardingRules200Response.md)
 - [ListLoadBalancers200Response](docs/ListLoadBalancers200Response.md)
 - [ListMaintenanceUpdates200Response](docs/ListMaintenanceUpdates200Response.md)
 - [ListMetalPlans200Response](docs/ListMetalPlans200Response.md)
 - [ListNetworks200Response](docs/ListNetworks200Response.md)
 - [ListObjectStorageClusters200Response](docs/ListObjectStorageClusters200Response.md)
 - [ListObjectStorages200Response](docs/ListObjectStorages200Response.md)
 - [ListOs200Response](docs/ListOs200Response.md)
 - [ListPlans200Response](docs/ListPlans200Response.md)
 - [ListPublicIsos200Response](docs/ListPublicIsos200Response.md)
 - [ListRegions200Response](docs/ListRegions200Response.md)
 - [ListRegistries200Response](docs/ListRegistries200Response.md)
 - [ListRegistryPlans200Response](docs/ListRegistryPlans200Response.md)
 - [ListRegistryPlans200ResponsePlans](docs/ListRegistryPlans200ResponsePlans.md)
 - [ListRegistryRegions200Response](docs/ListRegistryRegions200Response.md)
 - [ListRegistryRepositories200Response](docs/ListRegistryRepositories200Response.md)
 - [ListReservedIps200Response](docs/ListReservedIps200Response.md)
 - [ListServiceAlerts200Response](docs/ListServiceAlerts200Response.md)
 - [ListServiceAlertsRequest](docs/ListServiceAlertsRequest.md)
 - [ListSnapshots200Response](docs/ListSnapshots200Response.md)
 - [ListSshKeys200Response](docs/ListSshKeys200Response.md)
 - [ListStartupScripts200Response](docs/ListStartupScripts200Response.md)
 - [ListSubaccounts200Response](docs/ListSubaccounts200Response.md)
 - [ListUsers200Response](docs/ListUsers200Response.md)
 - [ListVpc2200Response](docs/ListVpc2200Response.md)
 - [ListVpcs200Response](docs/ListVpcs200Response.md)
 - [Loadbalancer](docs/Loadbalancer.md)
 - [LoadbalancerFirewallRule](docs/LoadbalancerFirewallRule.md)
 - [LoadbalancerFirewallRulesInner](docs/LoadbalancerFirewallRulesInner.md)
 - [LoadbalancerForwardRulesInner](docs/LoadbalancerForwardRulesInner.md)
 - [LoadbalancerGenericInfo](docs/LoadbalancerGenericInfo.md)
 - [LoadbalancerGenericInfoStickySessions](docs/LoadbalancerGenericInfoStickySessions.md)
 - [LoadbalancerHealthCheck](docs/LoadbalancerHealthCheck.md)
 - [Meta](docs/Meta.md)
 - [MetaLinks](docs/MetaLinks.md)
 - [Network](docs/Network.md)
 - [NodepoolInstances](docs/NodepoolInstances.md)
 - [Nodepools](docs/Nodepools.md)
 - [ObjectStorage](docs/ObjectStorage.md)
 - [Os](docs/Os.md)
 - [PatchReservedIpsReservedIpRequest](docs/PatchReservedIpsReservedIpRequest.md)
 - [Plans](docs/Plans.md)
 - [PlansMetal](docs/PlansMetal.md)
 - [PostFirewallsFirewallGroupIdRules201Response](docs/PostFirewallsFirewallGroupIdRules201Response.md)
 - [PostFirewallsFirewallGroupIdRulesRequest](docs/PostFirewallsFirewallGroupIdRulesRequest.md)
 - [PostInstancesInstanceIdIpv4ReverseDefaultRequest](docs/PostInstancesInstanceIdIpv4ReverseDefaultRequest.md)
 - [PrivateNetworks](docs/PrivateNetworks.md)
 - [PutSnapshotsSnapshotIdRequest](docs/PutSnapshotsSnapshotIdRequest.md)
 - [RebootInstancesRequest](docs/RebootInstancesRequest.md)
 - [RegenerateObjectStorageKeys201Response](docs/RegenerateObjectStorageKeys201Response.md)
 - [RegenerateObjectStorageKeys201ResponseS3Credentials](docs/RegenerateObjectStorageKeys201ResponseS3Credentials.md)
 - [Region](docs/Region.md)
 - [Registry](docs/Registry.md)
 - [RegistryDockerCredentials](docs/RegistryDockerCredentials.md)
 - [RegistryDockerCredentialsAuths](docs/RegistryDockerCredentialsAuths.md)
 - [RegistryDockerCredentialsAuthsRegistryRegionNameVultrcrCom](docs/RegistryDockerCredentialsAuthsRegistryRegionNameVultrcrCom.md)
 - [RegistryKubernetesDockerCredentials](docs/RegistryKubernetesDockerCredentials.md)
 - [RegistryKubernetesDockerCredentialsData](docs/RegistryKubernetesDockerCredentialsData.md)
 - [RegistryKubernetesDockerCredentialsMetadata](docs/RegistryKubernetesDockerCredentialsMetadata.md)
 - [RegistryMetadata](docs/RegistryMetadata.md)
 - [RegistryMetadataSubscription](docs/RegistryMetadataSubscription.md)
 - [RegistryMetadataSubscriptionBilling](docs/RegistryMetadataSubscriptionBilling.md)
 - [RegistryPlan](docs/RegistryPlan.md)
 - [RegistryRegion](docs/RegistryRegion.md)
 - [RegistryRepository](docs/RegistryRepository.md)
 - [RegistryStorage](docs/RegistryStorage.md)
 - [RegistryUser](docs/RegistryUser.md)
 - [ReinstallBaremetalRequest](docs/ReinstallBaremetalRequest.md)
 - [ReinstallInstanceRequest](docs/ReinstallInstanceRequest.md)
 - [ReservedIp](docs/ReservedIp.md)
 - [RestoreInstance202Response](docs/RestoreInstance202Response.md)
 - [RestoreInstance202ResponseStatus](docs/RestoreInstance202ResponseStatus.md)
 - [RestoreInstanceRequest](docs/RestoreInstanceRequest.md)
 - [SetDatabaseUserAclRequest](docs/SetDatabaseUserAclRequest.md)
 - [Snapshot](docs/Snapshot.md)
 - [Ssh](docs/Ssh.md)
 - [StartInstancesRequest](docs/StartInstancesRequest.md)
 - [StartKubernetesClusterUpgradeRequest](docs/StartKubernetesClusterUpgradeRequest.md)
 - [StartMaintenanceUpdates200Response](docs/StartMaintenanceUpdates200Response.md)
 - [StartVersionUpgrade200Response](docs/StartVersionUpgrade200Response.md)
 - [StartVersionUpgradeRequest](docs/StartVersionUpgradeRequest.md)
 - [Startup](docs/Startup.md)
 - [Subaccount](docs/Subaccount.md)
 - [UpdateAdvancedOptionsRequest](docs/UpdateAdvancedOptionsRequest.md)
 - [UpdateBaremetalRequest](docs/UpdateBaremetalRequest.md)
 - [UpdateBlockRequest](docs/UpdateBlockRequest.md)
 - [UpdateConnectionPoolRequest](docs/UpdateConnectionPoolRequest.md)
 - [UpdateDatabaseRequest](docs/UpdateDatabaseRequest.md)
 - [UpdateDatabaseUserRequest](docs/UpdateDatabaseUserRequest.md)
 - [UpdateDnsDomainRecordRequest](docs/UpdateDnsDomainRecordRequest.md)
 - [UpdateDnsDomainRequest](docs/UpdateDnsDomainRequest.md)
 - [UpdateDnsDomainSoaRequest](docs/UpdateDnsDomainSoaRequest.md)
 - [UpdateFirewallGroupRequest](docs/UpdateFirewallGroupRequest.md)
 - [UpdateInstanceRequest](docs/UpdateInstanceRequest.md)
 - [UpdateKubernetesClusterRequest](docs/UpdateKubernetesClusterRequest.md)
 - [UpdateLoadBalancerRequest](docs/UpdateLoadBalancerRequest.md)
 - [UpdateLoadBalancerRequestHealthCheck](docs/UpdateLoadBalancerRequestHealthCheck.md)
 - [UpdateNetworkRequest](docs/UpdateNetworkRequest.md)
 - [UpdateNodepoolRequest](docs/UpdateNodepoolRequest.md)
 - [UpdateNodepoolRequest1](docs/UpdateNodepoolRequest1.md)
 - [UpdateObjectStorageRequest](docs/UpdateObjectStorageRequest.md)
 - [UpdateRegistryRequest](docs/UpdateRegistryRequest.md)
 - [UpdateRepositoryRequest](docs/UpdateRepositoryRequest.md)
 - [UpdateSshKeyRequest](docs/UpdateSshKeyRequest.md)
 - [UpdateStartupScriptRequest](docs/UpdateStartupScriptRequest.md)
 - [UpdateUserRequest](docs/UpdateUserRequest.md)
 - [UpdateVpc2Request](docs/UpdateVpc2Request.md)
 - [UpdateVpcRequest](docs/UpdateVpcRequest.md)
 - [User](docs/User.md)
 - [UserUser](docs/UserUser.md)
 - [ViewMigrationStatus200Response](docs/ViewMigrationStatus200Response.md)
 - [VkeCluster](docs/VkeCluster.md)
 - [Vpc](docs/Vpc.md)
 - [Vpc2](docs/Vpc2.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="API Key"></a>
### API Key

- **Type**: HTTP Bearer Token authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@vultr.com

