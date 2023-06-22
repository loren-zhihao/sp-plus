# 视频表


---
### 1、增加
- 接口
``` api
	/SpVedio/add
```
- 参数
``` p
	{Long}	id			主键id 
	{String}	url			地址 
	{String}	type			类型1:普通2:会员 
	{String}	status			状态1:上架2:下架 
	{String}	createBy			创建人 
	{String}	createTime			创建时间 
	{String}	updateBy			更新人 
	{String}	updateTime			更新时间 
```
- 返回 
@import(res)


--- 
### 2、删除
- 接口
``` api
	/SpVedio/delete
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
	/SpVedio/deleteByIds
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
	/SpVedio/update
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{String}	url			地址 
	{String}	type			类型1:普通2:会员 
	{String}	status			状态1:上架2:下架 
	{String}	createBy			创建人 
	{String}	createTime			创建时间 
	{String}	updateBy			更新人 
	{String}	updateTime			更新时间 
```
- 返回
@import(res)


---
### 5、查 - 根据id
- 接口
```  api 
	/SpVedio/getById
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
			"url": "",		// 地址
			"type": "",		// 类型1:普通2:会员
			"status": "",		// 状态1:上架2:下架
			"createBy": "",		// 创建人
			"createTime": "",		// 创建时间
			"updateBy": "",		// 更新人
			"updateTime": "",		// 更新时间
		},
		"dataCount": -1
	}
```


---
### 6、查集合 - 根据条件
- 接口
``` api
	/SpVedio/getList
```
- 参数 （参数为空时代表忽略指定条件）
``` p
	{int}	pageNo = 1			当前页
	{int}	pageSize = 10		页大小 
	{Long}	id			主键id 
	{String}	url			地址 
	{String}	type			类型1:普通2:会员 
	{String}	status			状态1:上架2:下架 
	{String}	createBy			创建人 
	{String}	createTime			创建时间 
	{String}	updateBy			更新人 
	{String}	updateTime			更新时间 
	{int}	sortType = 0		排序方式 (0 = 默认, 1 = 主键id, 2 = 地址, 3 = 类型1:普通2:会员, 4 = 状态1:上架2:下架, 5 = 创建人, 6 = 创建时间, 7 = 更新人, 8 = 更新时间)
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
	/SpVedio/updateByNotNull
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{String}	url			地址 
	{String}	type			类型1:普通2:会员 
	{String}	status			状态1:上架2:下架 
	{String}	createBy			创建人 
	{String}	createTime			创建时间 
	{String}	updateBy			更新人 
	{String}	updateTime			更新时间 
```
- 返回
@import(res)







