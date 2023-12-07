

# RegistryUser

Container Registry User Entity

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** | The Numeric ID of this user. |  [optional] |
|**username** | **String** | The globally unique name of this user. |  [optional] |
|**password** | **String** | The password this user will use to authenticate. |  [optional] |
|**root** | **Boolean** | If true, this is a root user/registry owner meaning it cannot be deleted or renamed. If false, this is an additional user added to this registry that can be modified |  [optional] |
|**addedAt** | **String** | The date this User was added |  [optional] |
|**updatedAt** | **String** | The date this User was last updated |  [optional] |



