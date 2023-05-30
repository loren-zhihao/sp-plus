package com.pj.project.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.pj.utils.sg.*;
import com.pj.utils.so.*;
import com.pj.project4sp.SP;

import com.pj.current.satoken.StpUserUtil;
import cn.dev33.satoken.annotation.SaCheckPermission;


/**
 * Controller: user -- 用户表
 * @author lizhihao 
 */
@RestController
@RequestMapping("/User/")
public class UserController {

	/** 底层 Service 对象 */
	@Autowired
	UserService userService;

	/** 增 */  
	@RequestMapping("add")
	@SaCheckPermission(User.PERMISSION_CODE)
	@Transactional(rollbackFor = Exception.class)
	public AjaxJson add(User u){
		userService.add(u);
		u = userService.getById(SP.publicMapper.getPrimarykey());
		return AjaxJson.getSuccessData(u);
	}

	/** 删 */  
	@RequestMapping("delete")
	@SaCheckPermission(User.PERMISSION_CODE)
	public AjaxJson delete(Long id){
		int line = userService.delete(id);
		return AjaxJson.getByLine(line);
	}
	
	/** 删 - 根据id列表 */  
	@RequestMapping("deleteByIds")
	@SaCheckPermission(User.PERMISSION_CODE)
	public AjaxJson deleteByIds(){
		List<Long> ids = SoMap.getRequestSoMap().getListByComma("ids", long.class); 
		int line = SP.publicMapper.deleteByIds(User.TABLE_NAME, ids);
		return AjaxJson.getByLine(line);
	}
	
	/** 改 */  
	@RequestMapping("update")
	@SaCheckPermission(User.PERMISSION_CODE)
	public AjaxJson update(User u){
		int line = userService.update(u);
		return AjaxJson.getByLine(line);
	}

	/** 查 - 根据id */  
	@RequestMapping("getById")
	public AjaxJson getById(Long id){
		User u = userService.getById(id);
		return AjaxJson.getSuccessData(u);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	@RequestMapping("getList")
	public AjaxJson getList() { 
		SoMap so = SoMap.getRequestSoMap();
		List<User> list = userService.getList(so.startPage());
		return AjaxJson.getPageData(so.getDataCount(), list);
	}
	
	
	
	
	// ------------------------- 前端接口 -------------------------
	
	
	/** 改 - 不传不改 [G] */
	@RequestMapping("updateByNotNull")
	public AjaxJson updateByNotNull(Long id){
		AjaxError.throwBy(true, "如需正常调用此接口，请删除此行代码");
		// 鉴别身份，是否为数据创建者 
		long userId = SP.publicMapper.getColumnByIdToLong(User.TABLE_NAME, "user_id", id);
		AjaxError.throwBy(userId != StpUserUtil.getLoginIdAsLong(), "此数据您无权限修改");
		// 开始修改 (请只保留需要修改的字段)
		SoMap so = SoMap.getRequestSoMap();
		so.clearNotIn("id", "username", "password", "createBy", "createTime", "updateBy", "updateTime").clearNull().humpToLineCase();	
		int line = SP.publicMapper.updateBySoMapById(User.TABLE_NAME, so, id);
		return AjaxJson.getByLine(line);
	}
	
	
	
	
	
	

}
