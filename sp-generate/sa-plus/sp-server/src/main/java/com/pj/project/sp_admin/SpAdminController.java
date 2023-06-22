package com.pj.project.sp_admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.pj.current.satoken.AuthConst;
import com.pj.utils.sg.*;
import com.pj.utils.so.*;
import com.pj.project.SP;

import com.pj.current.satoken.StpUserUtil;
import cn.dev33.satoken.annotation.SaCheckPermission;


/**
 * Controller: sp_admin -- 系统管理员表
 * @author lizhihao 
 */
@RestController
@RequestMapping("/spAdmin/")
public class SpAdminController {

	/** 底层 Service 对象 */
	@Autowired
	SpAdminService spAdminService;

	/** 增 */  
	@RequestMapping("add")
	@SaCheckPermission(AuthConst.SP_ADMIN_ADD)
	@Transactional(rollbackFor = Exception.class)
	public AjaxJson add(SpAdmin s){
		spAdminService.add(s);
		s = spAdminService.getById(SP.publicMapper.getPrimarykey());
		return AjaxJson.getSuccessData(s);
	}

	/** 删 */  
	@RequestMapping("delete")
	@SaCheckPermission(AuthConst.SP_ADMIN_DELETE)
	public AjaxJson delete(Long id){
		int line = spAdminService.delete(id);
		return AjaxJson.getByLine(line);
	}
	
	/** 删 - 根据id列表 */  
	@RequestMapping("deleteByIds")
	@SaCheckPermission(AuthConst.SP_ADMIN_DELETE_BY_IDS)
	public AjaxJson deleteByIds(){
		List<Long> ids = SoMap.getRequestSoMap().getListByComma("ids", long.class); 
		int line = SP.publicMapper.deleteByIds(SpAdmin.TABLE_NAME, ids);
		return AjaxJson.getByLine(line);
	}
	
	/** 改 */  
	@RequestMapping("update")
	@SaCheckPermission(AuthConst.SP_ADMIN_UPDATE)
	public AjaxJson update(SpAdmin s){
		int line = spAdminService.update(s);
		return AjaxJson.getByLine(line);
	}

	/** 查 - 根据id */  
	@RequestMapping("getById")
	@SaCheckPermission(AuthConst.SP_ADMIN_GETBY＿ID)
	public AjaxJson getById(Long id){
		SpAdmin s = spAdminService.getById(id);
		return AjaxJson.getSuccessData(s);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	@RequestMapping("getList")
	@SaCheckPermission(AuthConst.SP_ADMIN_GETLIST)
	public AjaxJson getList() {
		SoMap so = SoMap.getRequestSoMap();
		List<SpAdmin> list = spAdminService.getList(so.startPage());
		return AjaxJson.getPageData(so.getDataCount(), list);
	}
	
	
	
	
	// ------------------------- 前端接口 -------------------------
	
	
	/** 改 - 不传不改 [G] */
	@RequestMapping("updateByNotNull")
	public AjaxJson updateByNotNull(Long id){
		AjaxError.throwBy(true, "如需正常调用此接口，请删除此行代码");
		// 鉴别身份，是否为数据创建者 
		long userId = SP.publicMapper.getColumnByIdToLong(SpAdmin.TABLE_NAME, "user_id", id);
		AjaxError.throwBy(userId != StpUserUtil.getLoginIdAsLong(), "此数据您无权限修改");
		// 开始修改 (请只保留需要修改的字段)
		SoMap so = SoMap.getRequestSoMap();
		so.clearNotIn("id", "name", "avatar", "password", "pw", "phone", "roleId", "status", "createByAid", "createTime", "loginTime", "loginIp", "loginCount", "userType").clearNull().humpToLineCase();	
		int line = SP.publicMapper.updateBySoMapById(SpAdmin.TABLE_NAME, so, id);
		return AjaxJson.getByLine(line);
	}
	
	
	
	
	
	

}
