package com.pj.project.sp_semic_dictionary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.utils.so.*;

/**
 * Service: sp_semic_dictionary -- 半导体词典表
 * @author lizhihao 
 */
@Service
public class SpSemicDictionaryService {

	/** 底层 Mapper 对象 */
	@Autowired
	SpSemicDictionaryMapper spSemicDictionaryMapper;

	/** 增 */
	int add(SpSemicDictionary s){
		return spSemicDictionaryMapper.add(s);
	}

	/** 删 */
	int delete(Long id){
		return spSemicDictionaryMapper.delete(id);
	}

	/** 改 */
	int update(SpSemicDictionary s){
		return spSemicDictionaryMapper.update(s);
	}

	/** 查 */
	SpSemicDictionary getById(Long id){
		return spSemicDictionaryMapper.getById(id);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	List<SpSemicDictionary> getList(SoMap so) { 
		return spSemicDictionaryMapper.getList(so);	
	}
	

}
