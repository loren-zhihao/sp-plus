package com.pj.project.sp_semic_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.utils.sg.*;

/**
 * 工具类：sp_semic_type -- 类型表
 * @author lizhihao 
 *
 */
@Component
public class SpSemicTypeUtil {

	
	/** 底层 Mapper 对象 */
	public static SpSemicTypeMapper spSemicTypeMapper;
	@Autowired
	private void setSpSemicTypeMapper(SpSemicTypeMapper spSemicTypeMapper) {
		SpSemicTypeUtil.spSemicTypeMapper = spSemicTypeMapper;
	}
	
	
	/** 
	 * 将一个 SpSemicType 对象进行进行数据完整性校验 (方便add/update等接口数据校验) [G] 
	 */
	static void check(SpSemicType s) {
		AjaxError.throwByIsNull(s.id, "[主键id] 不能为空");		// 验证: 主键id 
		AjaxError.throwByIsNull(s.type, "[类型如1：系统2：其他，用户可以自定义] 不能为空");		// 验证: 类型  如 1：系统 2：其他，用户可以自定义 
		AjaxError.throwByIsNull(s.name, "[类型说明] 不能为空");		// 验证: 类型说明 
		AjaxError.throwByIsNull(s.createTime, "[创建时间] 不能为空");		// 验证: 创建时间 
		AjaxError.throwByIsNull(s.createBy, "[创建人] 不能为空");		// 验证: 创建人 
		AjaxError.throwByIsNull(s.updateTime, "[更新时间] 不能为空");		// 验证: 更新时间 
		AjaxError.throwByIsNull(s.updateBy, "[更新人] 不能为空");		// 验证: 更新人 
	}

	/** 
	 * 获取一个SpSemicType (方便复制代码用) [G] 
	 */ 
	static SpSemicType getSpSemicType() {
		SpSemicType s = new SpSemicType();	// 声明对象 
		s.id = 0L;		// 主键id 
		s.type = 0;		// 类型  如 1：系统 2：其他，用户可以自定义 
		s.name = "";		// 类型说明 
		s.createTime = "";		// 创建时间 
		s.createBy = "";		// 创建人 
		s.updateTime = "";		// 更新时间 
		s.updateBy = "";		// 更新人 
		return s;
	}
	
	
	
	
	
}
