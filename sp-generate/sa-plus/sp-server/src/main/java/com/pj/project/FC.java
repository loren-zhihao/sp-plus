package com.pj.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pj.project.sp_admin.SpAdminMapper;
import com.pj.project.sp_vedio.SpVedioMapper;
import com.pj.project.sp_admin.SpAdminService;
import com.pj.project.sp_vedio.SpVedioService;
import com.pj.project4sp.public4mapper.PublicMapper;
import com.pj.project4sp.public4mapper.PublicService;

/**
 * SpringBean依赖清单，项目中所有Bean在此定义
 */
@Component
public class FC {

	// ======================================== 所有Mapper ============================================== 

	public static SpAdminMapper spAdminMapper;		// Mapper：系统管理员表
	public static SpVedioMapper spVedioMapper;		// Mapper：视频表
	public static PublicMapper publicMapper;					// Mapper: 公共Mapper 



	// ======================================== 所有Service ============================================== 

	public static SpAdminService spAdminService;		// Service：系统管理员表
	public static SpVedioService spVedioService;		// Service：视频表
	public static PublicService publicService;						// Service：公共service



	// ======================================== 所有注入所有Bean ============================================== 
	
	// 注入 
	@Autowired
	public void setBean(
			SpAdminMapper spAdminMapper, 
			SpVedioMapper spVedioMapper, 
			PublicMapper publicMapper,
			
			SpAdminService spAdminService, 
			SpVedioService spVedioService, 
			PublicService publicService
			) {
			FC.spAdminMapper = spAdminMapper;
			FC.spVedioMapper = spVedioMapper;
			FC.publicMapper = publicMapper;
			
			FC.spAdminService = spAdminService;
			FC.spVedioService = spVedioService;
			FC.publicService = publicService;
	}


}