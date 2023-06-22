package com.pj.project.sp_admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.utils.sg.*;

/**
 * 工具类：sp_admin -- 系统管理员表
 * @author lizhihao 
 *
 */
@Component
public class SpAdminUtil {

	
	/** 底层 Mapper 对象 */
	public static SpAdminMapper spAdminMapper;
	@Autowired
	private void setSpAdminMapper(SpAdminMapper spAdminMapper) {
		SpAdminUtil.spAdminMapper = spAdminMapper;
	}
	
	
	/** 
	 * 将一个 SpAdmin 对象进行进行数据完整性校验 (方便add/update等接口数据校验) [G] 
	 */
	static void check(SpAdmin s) {
		AjaxError.throwByIsNull(s.id, "[id，--主键、自增] 不能为空");		// 验证: id，--主键、自增 
		AjaxError.throwByIsNull(s.name, "[admin名称] 不能为空");		// 验证: admin名称 
		AjaxError.throwByIsNull(s.avatar, "[头像地址] 不能为空");		// 验证: 头像地址 
		AjaxError.throwByIsNull(s.password, "[密码] 不能为空");		// 验证: 密码 
		AjaxError.throwByIsNull(s.pw, "[明文密码] 不能为空");		// 验证: 明文密码 
		AjaxError.throwByIsNull(s.phone, "[手机号] 不能为空");		// 验证: 手机号 
		AjaxError.throwByIsNull(s.roleId, "[所属角色id] 不能为空");		// 验证: 所属角色id 
		AjaxError.throwByIsNull(s.status, "[账号状态] 不能为空");		// 验证: 账号状态(1=正常, 2=禁用) 
		AjaxError.throwByIsNull(s.createByAid, "[创建自哪个管理员] 不能为空");		// 验证: 创建自哪个管理员 
		AjaxError.throwByIsNull(s.createTime, "[创建时间] 不能为空");		// 验证: 创建时间 
		AjaxError.throwByIsNull(s.loginTime, "[上次登陆时间] 不能为空");		// 验证: 上次登陆时间 
		AjaxError.throwByIsNull(s.loginIp, "[上次登陆IP] 不能为空");		// 验证: 上次登陆IP 
		AjaxError.throwByIsNull(s.loginCount, "[登陆次数] 不能为空");		// 验证: 登陆次数 
		AjaxError.throwByIsNull(s.userType, "[会员类型0:普通1:会员] 不能为空");		// 验证: 会员类型  0:普通  1:会员 
	}

	/** 
	 * 获取一个SpAdmin (方便复制代码用) [G] 
	 */ 
	static SpAdmin getSpAdmin() {
		SpAdmin s = new SpAdmin();	// 声明对象 
		s.id = 0L;		// id，--主键、自增 
		s.name = "";		// admin名称 
		s.avatar = "";		// 头像地址 
		s.password = "";		// 密码 
		s.pw = "";		// 明文密码 
		s.phone = "";		// 手机号 
		s.roleId = 0L;		// 所属角色id 
		s.status = 0;		// 账号状态(1=正常, 2=禁用) 
		s.createByAid = 0L;		// 创建自哪个管理员 
		s.createTime = "";		// 创建时间 
		s.loginTime = "";		// 上次登陆时间 
		s.loginIp = "";		// 上次登陆IP 
		s.loginCount = 0;		// 登陆次数 
		s.userType = "";		// 会员类型  0:普通  1:会员 
		return s;
	}
	
	
	
	
	
}
