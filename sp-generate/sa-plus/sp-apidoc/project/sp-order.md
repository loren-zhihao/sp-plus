# 订单信息表


---
### 1、增加
- 接口
``` api
	/SpOrder/add
```
- 参数
``` p
	{Long}	id			主键id 
	{String}	code			订单编号 
	{String}	payType			支付方式1：支付宝2:微信3:其他 
	{Double}	payAmount			支付金额 
	{String}	orderSource			订单来源1:注册2:分享 
	{String}	drawee			付款人 
	{String}	orderPayTime			订单支付时间 
	{String}	orderCode			订单编号 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新时间 
	{String}	updateBy			更新人 
```
- 返回 
@import(res)


--- 
### 2、删除
- 接口
``` api
	/SpOrder/delete
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
	/SpOrder/deleteByIds
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
	/SpOrder/update
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{String}	code			订单编号 
	{String}	payType			支付方式1：支付宝2:微信3:其他 
	{Double}	payAmount			支付金额 
	{String}	orderSource			订单来源1:注册2:分享 
	{String}	drawee			付款人 
	{String}	orderPayTime			订单支付时间 
	{String}	orderCode			订单编号 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新时间 
	{String}	updateBy			更新人 
```
- 返回
@import(res)


---
### 5、查 - 根据id
- 接口
```  api 
	/SpOrder/getById
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
			"code": "",		// 订单编号
			"payType": "",		// 支付方式1：支付宝2:微信3:其他
			"payAmount": 0.0,		// 支付金额
			"orderSource": "",		// 订单来源1:注册2:分享
			"drawee": "",		// 付款人
			"orderPayTime": "",		// 订单支付时间
			"orderCode": "",		// 订单编号
			"createTime": "",		// 创建时间
			"createBy": "",		// 创建人
			"updateTime": "",		// 更新时间
			"updateBy": "",		// 更新人
		},
		"dataCount": -1
	}
```


---
### 6、查集合 - 根据条件
- 接口
``` api
	/SpOrder/getList
```
- 参数 （参数为空时代表忽略指定条件）
``` p
	{int}	pageNo = 1			当前页
	{int}	pageSize = 10		页大小 
	{Long}	id			主键id 
	{String}	code			订单编号 
	{String}	payType			支付方式1：支付宝2:微信3:其他 
	{Double}	payAmount			支付金额 
	{String}	orderSource			订单来源1:注册2:分享 
	{String}	drawee			付款人 
	{String}	orderPayTime			订单支付时间 
	{String}	orderCode			订单编号 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新时间 
	{String}	updateBy			更新人 
	{int}	sortType = 0		排序方式 (0 = 默认, 1 = 主键id, 2 = 订单编号, 3 = 支付方式1：支付宝2:微信3:其他, 4 = 支付金额, 5 = 订单来源1:注册2:分享, 6 = 付款人, 7 = 订单支付时间, 8 = 订单编号, 9 = 创建时间, 10 = 创建人, 11 = 更新时间, 12 = 更新人)
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
	/SpOrder/updateByNotNull
```
- 参数
``` p
	{Long}	id			主键id  (修改条件)
	{String}	code			订单编号 
	{String}	payType			支付方式1：支付宝2:微信3:其他 
	{Double}	payAmount			支付金额 
	{String}	orderSource			订单来源1:注册2:分享 
	{String}	drawee			付款人 
	{String}	orderPayTime			订单支付时间 
	{String}	orderCode			订单编号 
	{String}	createTime			创建时间 
	{String}	createBy			创建人 
	{String}	updateTime			更新时间 
	{String}	updateBy			更新人 
```
- 返回
@import(res)







