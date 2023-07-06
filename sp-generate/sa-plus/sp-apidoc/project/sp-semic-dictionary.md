# 半导体词典表


---
### 1、增加
- 接口
``` api
	/SpSemicDictionary/add
```
- 参数
``` p
	{Long}	id			主键id 
	{Long}	semicTypeId			关联类型表id 
	{String}	fullName			英文全称 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
```
- 返回 
@import(res)


--- 
### 2、删除
- 接口
``` api
	/SpSemicDictionary/delete
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
	/SpSemicDictionary/deleteByIds
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
	/SpSemicDictionary/update
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{Long}	semicTypeId			关联类型表id 
	{String}	fullName			英文全称 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
```
- 返回
@import(res)


---
### 5、查 - 根据id
- 接口
```  api 
	/SpSemicDictionary/getById
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
			"semicTypeId": 0L,		// 关联类型表id
			"fullName": "",		// 英文全称
			"abbreviation": "",		// 英文简写
			"description": "",		// 描述
			"createTime": "",		// 创建时间
			"createBy": "",		// 创建人
			"updateTime": "",		// 更新人
			"updateBy": "",		// 更新人
		},
		"dataCount": -1
	}
```


---
### 6、查集合 - 根据条件
- 接口
``` api
	/SpSemicDictionary/getList
```
- 参数 （参数为空时代表忽略指定条件）
``` p
	{int}	pageNo = 1			当前页
	{int}	pageSize = 10		页大小 
	{Long}	id			主键id 
	{Long}	semicTypeId			关联类型表id 
	{String}	fullName			英文全称 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
	{int}	sortType = 0		排序方式 (0 = 默认, 1 = 主键id, 2 = 关联类型表id, 3 = 英文全称, 4 = 英文简写, 5 = 描述, 6 = 创建时间, 7 = 创建人, 8 = 更新人, 9 = 更新人)
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
	/SpSemicDictionary/updateByNotNull
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{Long}	semicTypeId			关联类型表id 
	{String}	fullName			英文全称 
	{String}	abbreviation			英文简写 
	{String}	description			描述 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新人 
	{String}	updateBy			更新人 
```
- 返回
@import(res)







