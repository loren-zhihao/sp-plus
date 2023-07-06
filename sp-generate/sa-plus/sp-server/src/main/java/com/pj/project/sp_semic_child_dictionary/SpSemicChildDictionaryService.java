package com.pj.project.sp_semic_child_dictionary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.utils.so.*;

/**
 * Service: sp_semic_child_dictionary -- 半导体词典表的子集信息
 * @author lizhihao 
 */
@Service
public class SpSemicChildDictionaryService {

	/** 底层 Mapper 对象 */
	@Autowired
	SpSemicChildDictionaryMapper spSemicChildDictionaryMapper;

	/** 增 */
	int add(SpSemicChildDictionary s){
		return spSemicChildDictionaryMapper.add(s);
	}

	/** 删 */
	int delete(Long id){
		return spSemicChildDictionaryMapper.delete(id);
	}

	/** 改 */
	int update(SpSemicChildDictionary s){
		return spSemicChildDictionaryMapper.update(s);
	}

	/** 查 */
	SpSemicChildDictionary getById(Long id){
		return spSemicChildDictionaryMapper.getById(id);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	List<SpSemicChildDictionary> getList(SoMap so) { 
		return spSemicChildDictionaryMapper.getList(so);	
	}
	

}
