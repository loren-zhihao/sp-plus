package com.pj.project.sp_vedio;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Model: sp_vedio -- 视频表
 * @author lizhihao 
 */
@Data
@Accessors(chain = true)
public class SpVedio implements Serializable {

	// ---------- 模块常量 ----------
	/**
	 * 序列化版本id 
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * 此模块对应的表名 
	 */
	public static final String TABLE_NAME = "sp_vedio";	
	/**
	 * 此模块对应的权限码 
	 */
	public static final String PERMISSION_CODE = "sp-vedio";	


	// ---------- 表中字段 ----------
	/**
	 * 主键id 
	 */
	public Long id;	

	/**
	 * 地址 
	 */
	public String url;	

	/**
	 * 类型 1:普通  2:会员 
	 */
	public String type;	

	/**
	 * 状态  1:上架  2:下架 
	 */
	public String status;	

	/**
	 * 创建人 
	 */
	public String createBy;	

	/**
	 * 创建时间 
	 */
	public String createTime;	

	/**
	 * 更新人 
	 */
	public String updateBy;	

	/**
	 * 更新时间 
	 */
	public String updateTime;	





	


}
