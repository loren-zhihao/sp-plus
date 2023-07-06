package com.pj.project.sp_semic_child_dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.utils.sg.*;

/**
 * 工具类：sp_semic_child_dictionary -- 半导体词典表的子集信息
 * @author lizhihao 
 *
 */
@Component
public class SpSemicChildDictionaryUtil {

	
	/** 底层 Mapper 对象 */
	public static SpSemicChildDictionaryMapper spSemicChildDictionaryMapper;
	@Autowired
	private void setSpSemicChildDictionaryMapper(SpSemicChildDictionaryMapper spSemicChildDictionaryMapper) {
		SpSemicChildDictionaryUtil.spSemicChildDictionaryMapper = spSemicChildDictionaryMapper;
	}
	
	
	/** 
	 * 将一个 SpSemicChildDictionary 对象进行进行数据完整性校验 (方便add/update等接口数据校验) [G] 
	 */
	static void check(SpSemicChildDictionary s) {
		AjaxError.throwByIsNull(s.id, "[主键id] 不能为空");		// 验证: 主键id 
		AjaxError.throwByIsNull(s.semicDictionaryId, "[关联类型表id] 不能为空");		// 验证: 关联类型表id 
		AjaxError.throwByIsNull(s.abbreviation, "[英文简写] 不能为空");		// 验证: 英文简写 
		AjaxError.throwByIsNull(s.description, "[描述] 不能为空");		// 验证: 描述 
		AjaxError.throwByIsNull(s.createTime, "[创建时间] 不能为空");		// 验证: 创建时间 
		AjaxError.throwByIsNull(s.createBy, "[创建人] 不能为空");		// 验证: 创建人 
		AjaxError.throwByIsNull(s.updateTime, "[更新人] 不能为空");		// 验证: 更新人 
		AjaxError.throwByIsNull(s.updateBy, "[更新人] 不能为空");		// 验证: 更新人 
		AjaxError.throwByIsNull(s.fullName, "[英文全称] 不能为空");		// 验证: 英文全称 
	}

	/** 
	 * 获取一个SpSemicChildDictionary (方便复制代码用) [G] 
	 */ 
	static SpSemicChildDictionary getSpSemicChildDictionary() {
		SpSemicChildDictionary s = new SpSemicChildDictionary();	// 声明对象 
		s.id = 0L;		// 主键id 
		s.semicDictionaryId = 0L;		// 关联类型表id 
		s.abbreviation = "";		// 英文简写 
		s.description = "";		// 描述 
		s.createTime = "";		// 创建时间 
		s.createBy = "";		// 创建人 
		s.updateTime = "";		// 更新人 
		s.updateBy = "";		// 更新人 
		s.fullName = "";		// 英文全称 
		return s;
	}
	
	
	
	
	
}
