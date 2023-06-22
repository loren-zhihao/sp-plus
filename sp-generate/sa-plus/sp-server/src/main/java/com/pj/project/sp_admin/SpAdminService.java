package com.pj.project.sp_admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.utils.so.*;

/**
 * Service: sp_admin -- 系统管理员表
 * @author lizhihao 
 */
@Service
public class SpAdminService {

	/** 底层 Mapper 对象 */
	@Autowired
	SpAdminMapper spAdminMapper;

	/** 增 */
	int add(SpAdmin s){
		return spAdminMapper.add(s);
	}

	/** 删 */
	int delete(Long id){
		return spAdminMapper.delete(id);
	}

	/** 改 */
	int update(SpAdmin s){
		return spAdminMapper.update(s);
	}

	/** 查 */
	SpAdmin getById(Long id){
		return spAdminMapper.getById(id);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	List<SpAdmin> getList(SoMap so) { 
		return spAdminMapper.getList(so);	
	}
	

}
