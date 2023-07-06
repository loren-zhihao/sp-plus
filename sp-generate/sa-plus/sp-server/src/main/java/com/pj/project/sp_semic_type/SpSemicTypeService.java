package com.pj.project.sp_semic_type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.utils.so.*;

/**
 * Service: sp_semic_type -- 类型表
 * @author lizhihao 
 */
@Service
public class SpSemicTypeService {

	/** 底层 Mapper 对象 */
	@Autowired
	SpSemicTypeMapper spSemicTypeMapper;

	/** 增 */
	int add(SpSemicType s){
		return spSemicTypeMapper.add(s);
	}

	/** 删 */
	int delete(Long id){
		return spSemicTypeMapper.delete(id);
	}

	/** 改 */
	int update(SpSemicType s){
		return spSemicTypeMapper.update(s);
	}

	/** 查 */
	SpSemicType getById(Long id){
		return spSemicTypeMapper.getById(id);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	List<SpSemicType> getList(SoMap so) { 
		return spSemicTypeMapper.getList(so);	
	}
	

}
