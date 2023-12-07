

# UpdateUserRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**email** | **String** | The User&#39;s email address. |  [optional] |
|**name** | **String** | The User&#39;s name. |  [optional] |
|**password** | **String** | The User&#39;s password. |  [optional] |
|**apiEnabled** | **Boolean** | API access is permitted for this User.  * true (default) * false |  [optional] |
|**acls** | **List&lt;String&gt;** | An array of permission granted. Valid values:  * abuse * alerts * billing * dns * firewall * loadbalancer * manage\\_users * objstore * provisioning * subscriptions * subscriptions\\_view * support * upgrade |  [optional] |



