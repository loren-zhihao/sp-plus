package com.pj.project.sp_semic_dictionary;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Model: sp_semic_dictionary -- 半导体词典表
 * @author lizhihao 
 */
@Data
@Accessors(chain = true)
public class SpSemicDictionary implements Serializable {

	// ---------- 模块常量 ----------
	/**
	 * 序列化版本id 
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * 此模块对应的表名 
	 */
	public static final String TABLE_NAME = "sp_semic_dictionary";	
	/**
	 * 此模块对应的权限码 
	 */
	public static final String PERMISSION_CODE = "sp-semic-dictionary";	


	// ---------- 表中字段 ----------
	/**
	 * 主键id 
	 */
	public Long id;	

	/**
	 * 关联类型表id 
	 */
	public Long semicTypeId;	

	/**
	 * 英文全称 
	 */
	public String fullName;	

	/**
	 * 英文简写 
	 */
	public String abbreviation;	

	/**
	 * 描述 
	 */
	public String description;	

	/**
	 * 创建时间 
	 */
	public String createTime;	

	/**
	 * 创建人 
	 */
	public String createBy;	

	/**
	 * 更新人 
	 */
	public String updateTime;	

	/**
	 * 更新人 
	 */
	public String updateBy;	





	


}
