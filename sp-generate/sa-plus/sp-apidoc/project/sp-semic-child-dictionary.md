# 半导体词典表的子集信息


---
### 1、增加
- 接口
``` api
	/SpSemicChildDictionary/add
```
- 参数
``` p
	{Long}	id			主键id 
	{Long}	semicDictionaryId			关联类型表id 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
	{String}	fullName			英文全称 
```
- 返回 
@import(res)


--- 
### 2、删除
- 接口
``` api
	/SpSemicChildDictionary/delete
```
- 参数
``` p
	{Long}	id			要删除的记录id
```
- 返回
@import(res)


---
### 3、批量删除
- 接口
``` api
	/SpSemicChildDictionary/deleteByIds
```
- 参数
``` p
	{数组}	ids			要删除的记录id数组，逗号隔开，例：ids=1,2,3,4
```
- 返回
@import(res)


---
### 4、修改
- 接口
``` api
	/SpSemicChildDictionary/update
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{Long}	semicDictionaryId			关联类型表id 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
	{String}	fullName			英文全称 
```
- 返回
@import(res)


---
### 5、查 - 根据id
- 接口
```  api 
	/SpSemicChildDictionary/getById
```
- 参数
``` p
	{Long}	id			要查询的记录id
```
- 返回示例
``` js
	{
		"code": 200,
		"msg": "ok",
		"data": {
			"id": 0L,		// 主键id
			"semicDictionaryId": 0L,		// 关联类型表id
			"abbreviation": "",		// 英文简写
			"description": "",		// 描述
			"createTime": "",		// 创建时间
			"createBy": "",		// 创建人
			"updateTime": "",		// 更新人
			"updateBy": "",		// 更新人
			"fullName": "",		// 英文全称
		},
		"dataCount": -1
	}
```


---
### 6、查集合 - 根据条件
- 接口
``` api
	/SpSemicChildDictionary/getList
```
- 参数 （参数为空时代表忽略指定条件）
``` p
	{int}	pageNo = 1			当前页
	{int}	pageSize = 10		页大小 
	{Long}	id			主键id 
	{Long}	semicDictionaryId			关联类型表id 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
	{String}	fullName			英文全称 
	{int}	sortType = 0		排序方式 (0 = 默认, 1 = 主键id, 2 = 关联类型表id, 3 = 英文简写, 4 = 描述, 5 = 创建时间, 6 = 创建人, 7 = 更新人, 8 = 更新人, 9 = 英文全称)
```
- 返回 
``` js
	{
		"code": 200,
		"msg": "ok",
		"data": [
			// 数据列表，格式参考getById 
		],
		"dataCount": 100	// 数据总数
	}
```




---
### 7、修改 - 空值不改
- 接口
``` api
	/SpSemicChildDictionary/updateByNotNull
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{Long}	semicDictionaryId			关联类型表id 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
	{String}	fullName			英文全称 
```
- 返回
@import(res)







