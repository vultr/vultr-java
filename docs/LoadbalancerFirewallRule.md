

# LoadbalancerFirewallRule

Load Balancer firewall rule information.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | The unique ID for the firewall rule |  [optional] |
|**port** | **Integer** | Port for this rule.  |  [optional] |
|**source** | **String** | If the source string is given a value of \&quot;cloudflare\&quot; then cloudflare IPs will be supplied. Otherwise enter a IP address with subnet size that you wish to permit through the firewall.  Possible values:  |   | Value | Description | | - | ------ | ------------- | |   | \&quot;192.168.1.1/16\&quot; | Ip address with a subnet size. | |   | cloudflare | Allow all of Cloudflare&#39;s IP space through the firewall | |  [optional] |
|**ipType** | **String** | The type of IP rule.  * v4 * v6  |  [optional] |



