

# DnsRecord

DNS Record information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | A unique ID for the DNS Record. |  [optional] |
|**type** | **String** | The DNS record type.  * A * AAAA * CNAME * NS * MX * SRV * TXT * CAA * SSHFP |  [optional] |
|**name** | **String** | The hostname for this DNS record. |  [optional] |
|**data** | **String** | The DNS data for this record type. |  [optional] |
|**priority** | **Integer** | DNS priority. Does not apply to all record types. |  [optional] |
|**ttl** | **Integer** | Time to Live in seconds. |  [optional] |



