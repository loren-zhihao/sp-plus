# 密码表


---
### 1、增加
- 接口
``` api
	/Password/add
```
- 参数
``` p
	{Long}	id			主键id 
	{Long}	userId			所属用户ID 
	{Long}	categoryId			密码分类ID 
	{String}	title			密码标题 
	{String}	account			账号 
	{String}	password			密码 
	{String}	url			登录地址 
	{String}	notes			备注 
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
	/Password/delete
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
	/Password/deleteByIds
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
	/Password/update
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{Long}	userId			所属用户ID 
	{Long}	categoryId			密码分类ID 
	{String}	title			密码标题 
	{String}	account			账号 
	{String}	password			密码 
	{String}	url			登录地址 
	{String}	notes			备注 
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
	/Password/getById
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
			"userId": 0L,		// 所属用户ID
			"categoryId": 0L,		// 密码分类ID
			"title": "",		// 密码标题
			"account": "",		// 账号
			"password": "",		// 密码
			"url": "",		// 登录地址
			"notes": "",		// 备注
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
	/Password/getList
```
- 参数 （参数为空时代表忽略指定条件）
``` p
	{int}	pageNo = 1			当前页
	{int}	pageSize = 10		页大小 
	{Long}	id			主键id 
	{Long}	userId			所属用户ID 
	{Long}	categoryId			密码分类ID 
	{String}	title			密码标题 
	{String}	account			账号 
	{String}	password			密码 
	{String}	url			登录地址 
	{String}	notes			备注 
	{String}	createBy			创建人 
	{String}	createTime			创建时间 
	{String}	updateBy			更新人 
	{String}	updateTime			更新时间 
	{int}	sortType = 0		排序方式 (0 = 默认, 1 = 主键id, 2 = 所属用户ID, 3 = 密码分类ID, 4 = 密码标题, 5 = 账号, 6 = 密码, 7 = 登录地址, 8 = 备注, 9 = 创建人, 10 = 创建时间, 11 = 更新人, 12 = 更新时间)
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
	/Password/updateByNotNull
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{Long}	userId			所属用户ID 
	{Long}	categoryId			密码分类ID 
	{String}	title			密码标题 
	{String}	account			账号 
	{String}	password			密码 
	{String}	url			登录地址 
	{String}	notes			备注 
	{String}	createBy			创建人 
	{String}	createTime			创建时间 
	{String}	updateBy			更新人 
	{String}	updateTime			更新时间 
```
- 返回
@import(res)







