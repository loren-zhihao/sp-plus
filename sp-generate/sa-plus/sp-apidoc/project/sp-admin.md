# 系统管理员表


---
### 1、增加
- 接口
``` api
	/SpAdmin/add
```
- 参数
``` p
	{Long}	id			id，--主键、自增 
	{String}	name			admin名称 
	{String}	avatar			头像地址 
	{String}	password			密码 
	{String}	pw			明文密码 
	{String}	phone			手机号 
	{Long}	roleId			所属角色id 
	{Integer}	status			账号状态(1=正常,2=禁用) 
	{Long}	createByAid			创建自哪个管理员 
	{String}	createTime			创建时间 
	{String}	loginTime			上次登陆时间 
	{String}	loginIp			上次登陆IP 
	{Integer}	loginCount			登陆次数 
	{String}	userType			会员类型0:普通1:会员 
```
- 返回 
@import(res)


--- 
### 2、删除
- 接口
``` api
	/SpAdmin/delete
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
	/SpAdmin/deleteByIds
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
	/SpAdmin/update
```
- 参数
``` p
	{Long}	id			id，--主键、自增  (修改条件)
	{String}	name			admin名称 
	{String}	avatar			头像地址 
	{String}	password			密码 
	{String}	pw			明文密码 
	{String}	phone			手机号 
	{Long}	roleId			所属角色id 
	{Integer}	status			账号状态(1=正常,2=禁用) 
	{Long}	createByAid			创建自哪个管理员 
	{String}	createTime			创建时间 
	{String}	loginTime			上次登陆时间 
	{String}	loginIp			上次登陆IP 
	{Integer}	loginCount			登陆次数 
	{String}	userType			会员类型0:普通1:会员 
```
- 返回
@import(res)


---
### 5、查 - 根据id
- 接口
```  api 
	/SpAdmin/getById
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
			"id": 0L,		// id，--主键、自增
			"name": "",		// admin名称
			"avatar": "",		// 头像地址
			"password": "",		// 密码
			"pw": "",		// 明文密码
			"phone": "",		// 手机号
			"roleId": 0L,		// 所属角色id
			"status": 0,		// 账号状态(1=正常,2=禁用)
			"createByAid": 0L,		// 创建自哪个管理员
			"createTime": "",		// 创建时间
			"loginTime": "",		// 上次登陆时间
			"loginIp": "",		// 上次登陆IP
			"loginCount": 0,		// 登陆次数
			"userType": "",		// 会员类型0:普通1:会员
		},
		"dataCount": -1
	}
```


---
### 6、查集合 - 根据条件
- 接口
``` api
	/SpAdmin/getList
```
- 参数 （参数为空时代表忽略指定条件）
``` p
	{int}	pageNo = 1			当前页
	{int}	pageSize = 10		页大小 
	{Long}	id			id，--主键、自增 
	{String}	name			admin名称 
	{String}	avatar			头像地址 
	{String}	password			密码 
	{String}	pw			明文密码 
	{String}	phone			手机号 
	{Long}	roleId			所属角色id 
	{Integer}	status			账号状态(1=正常,2=禁用) 
	{Long}	createByAid			创建自哪个管理员 
	{String}	createTime			创建时间 
	{String}	loginTime			上次登陆时间 
	{String}	loginIp			上次登陆IP 
	{Integer}	loginCount			登陆次数 
	{String}	userType			会员类型0:普通1:会员 
	{int}	sortType = 0		排序方式 (0 = 默认, 1 = id，--主键、自增, 2 = admin名称, 3 = 头像地址, 4 = 密码, 5 = 明文密码, 6 = 手机号, 7 = 所属角色id, 8 = 账号状态(1=正常,2=禁用), 9 = 创建自哪个管理员, 10 = 创建时间, 11 = 上次登陆时间, 12 = 上次登陆IP, 13 = 登陆次数, 14 = 会员类型0:普通1:会员)
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
	/SpAdmin/updateByNotNull
```
- 参数
``` p
	{Long}	id			id，--主键、自增  (修改条件)
	{String}	name			admin名称 
	{String}	avatar			头像地址 
	{String}	password			密码 
	{String}	pw			明文密码 
	{String}	phone			手机号 
	{Long}	roleId			所属角色id 
	{Integer}	status			账号状态(1=正常,2=禁用) 
	{Long}	createByAid			创建自哪个管理员 
	{String}	createTime			创建时间 
	{String}	loginTime			上次登陆时间 
	{String}	loginIp			上次登陆IP 
	{Integer}	loginCount			登陆次数 
	{String}	userType			会员类型0:普通1:会员 
```
- 返回
@import(res)







