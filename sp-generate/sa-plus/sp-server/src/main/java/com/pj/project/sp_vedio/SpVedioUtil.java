package com.pj.project.sp_vedio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.utils.sg.*;

/**
 * 工具类：sp_vedio -- 视频表
 * @author lizhihao 
 *
 */
@Component
public class SpVedioUtil {

	
	/** 底层 Mapper 对象 */
	public static SpVedioMapper spVedioMapper;
	@Autowired
	private void setSpVedioMapper(SpVedioMapper spVedioMapper) {
		SpVedioUtil.spVedioMapper = spVedioMapper;
	}
	
	
	/** 
	 * 将一个 SpVedio 对象进行进行数据完整性校验 (方便add/update等接口数据校验) [G] 
	 */
	static void check(SpVedio s) {
		AjaxError.throwByIsNull(s.id, "[主键id] 不能为空");		// 验证: 主键id 
		AjaxError.throwByIsNull(s.url, "[地址] 不能为空");		// 验证: 地址 
		AjaxError.throwByIsNull(s.type, "[类型1:普通2:会员] 不能为空");		// 验证: 类型 1:普通  2:会员 
		AjaxError.throwByIsNull(s.status, "[状态1:上架2:下架] 不能为空");		// 验证: 状态  1:上架  2:下架 
		AjaxError.throwByIsNull(s.createBy, "[创建人] 不能为空");		// 验证: 创建人 
		AjaxError.throwByIsNull(s.createTime, "[创建时间] 不能为空");		// 验证: 创建时间 
		AjaxError.throwByIsNull(s.updateBy, "[更新人] 不能为空");		// 验证: 更新人 
		AjaxError.throwByIsNull(s.updateTime, "[更新时间] 不能为空");		// 验证: 更新时间 
	}

	/** 
	 * 获取一个SpVedio (方便复制代码用) [G] 
	 */ 
	static SpVedio getSpVedio() {
		SpVedio s = new SpVedio();	// 声明对象 
		s.id = 0L;		// 主键id 
		s.url = "";		// 地址 
		s.type = "";		// 类型 1:普通  2:会员 
		s.status = "";		// 状态  1:上架  2:下架 
		s.createBy = "";		// 创建人 
		s.createTime = "";		// 创建时间 
		s.updateBy = "";		// 更新人 
		s.updateTime = "";		// 更新时间 
		return s;
	}
	
	
	
	
	
}
