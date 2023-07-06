package com.pj.project.sp_semic_dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.utils.sg.*;

/**
 * 工具类：sp_semic_dictionary -- 半导体词典表
 * @author lizhihao 
 *
 */
@Component
public class SpSemicDictionaryUtil {

	
	/** 底层 Mapper 对象 */
	public static SpSemicDictionaryMapper spSemicDictionaryMapper;
	@Autowired
	private void setSpSemicDictionaryMapper(SpSemicDictionaryMapper spSemicDictionaryMapper) {
		SpSemicDictionaryUtil.spSemicDictionaryMapper = spSemicDictionaryMapper;
	}
	
	
	/** 
	 * 将一个 SpSemicDictionary 对象进行进行数据完整性校验 (方便add/update等接口数据校验) [G] 
	 */
	static void check(SpSemicDictionary s) {
		AjaxError.throwByIsNull(s.id, "[主键id] 不能为空");		// 验证: 主键id 
		AjaxError.throwByIsNull(s.semicTypeId, "[关联类型表id] 不能为空");		// 验证: 关联类型表id 
		AjaxError.throwByIsNull(s.fullName, "[英文全称] 不能为空");		// 验证: 英文全称 
		AjaxError.throwByIsNull(s.abbreviation, "[英文简写] 不能为空");		// 验证: 英文简写 
		AjaxError.throwByIsNull(s.description, "[描述] 不能为空");		// 验证: 描述 
		AjaxError.throwByIsNull(s.createTime, "[创建时间] 不能为空");		// 验证: 创建时间 
		AjaxError.throwByIsNull(s.createBy, "[创建人] 不能为空");		// 验证: 创建人 
		AjaxError.throwByIsNull(s.updateTime, "[更新人] 不能为空");		// 验证: 更新人 
		AjaxError.throwByIsNull(s.updateBy, "[更新人] 不能为空");		// 验证: 更新人 
	}

	/** 
	 * 获取一个SpSemicDictionary (方便复制代码用) [G] 
	 */ 
	static SpSemicDictionary getSpSemicDictionary() {
		SpSemicDictionary s = new SpSemicDictionary();	// 声明对象 
		s.id = 0L;		// 主键id 
		s.semicTypeId = 0L;		// 关联类型表id 
		s.fullName = "";		// 英文全称 
		s.abbreviation = "";		// 英文简写 
		s.description = "";		// 描述 
		s.createTime = "";		// 创建时间 
		s.createBy = "";		// 创建人 
		s.updateTime = "";		// 更新人 
		s.updateBy = "";		// 更新人 
		return s;
	}
	
	
	
	
	
}
