package com.pj.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.project.sp_semic_type.SpSemicTypeMapper;
import com.pj.project.sp_semic_dictionary.SpSemicDictionaryMapper;
import com.pj.project.sp_semic_child_dictionary.SpSemicChildDictionaryMapper;
import com.pj.project.sp_semic_type.SpSemicTypeService;
import com.pj.project.sp_semic_dictionary.SpSemicDictionaryService;
import com.pj.project.sp_semic_child_dictionary.SpSemicChildDictionaryService;
import com.pj.project4sp.public4mapper.PublicMapper;
import com.pj.project4sp.public4mapper.PublicService;

/**
 * SpringBean依赖清单，项目中所有Bean在此定义
 */
@Component
public class FC {

	// ======================================== 所有Mapper ============================================== 

	public static SpSemicTypeMapper spSemicTypeMapper;		// Mapper：类型表
	public static SpSemicDictionaryMapper spSemicDictionaryMapper;		// Mapper：半导体词典表
	public static SpSemicChildDictionaryMapper spSemicChildDictionaryMapper;		// Mapper：半导体词典表的子集信息
	public static PublicMapper publicMapper;					// Mapper: 公共Mapper 



	// ======================================== 所有Service ============================================== 

	public static SpSemicTypeService spSemicTypeService;		// Service：类型表
	public static SpSemicDictionaryService spSemicDictionaryService;		// Service：半导体词典表
	public static SpSemicChildDictionaryService spSemicChildDictionaryService;		// Service：半导体词典表的子集信息
	public static PublicService publicService;						// Service：公共service



	// ======================================== 所有注入所有Bean ============================================== 
	
	// 注入 
	@Autowired
	public void setBean(
			SpSemicTypeMapper spSemicTypeMapper, 
			SpSemicDictionaryMapper spSemicDictionaryMapper, 
			SpSemicChildDictionaryMapper spSemicChildDictionaryMapper, 
			PublicMapper publicMapper,
			
			SpSemicTypeService spSemicTypeService, 
			SpSemicDictionaryService spSemicDictionaryService, 
			SpSemicChildDictionaryService spSemicChildDictionaryService, 
			PublicService publicService
			) {
			FC.spSemicTypeMapper = spSemicTypeMapper;
			FC.spSemicDictionaryMapper = spSemicDictionaryMapper;
			FC.spSemicChildDictionaryMapper = spSemicChildDictionaryMapper;
			FC.publicMapper = publicMapper;
			
			FC.spSemicTypeService = spSemicTypeService;
			FC.spSemicDictionaryService = spSemicDictionaryService;
			FC.spSemicChildDictionaryService = spSemicChildDictionaryService;
			FC.publicService = publicService;
	}


}