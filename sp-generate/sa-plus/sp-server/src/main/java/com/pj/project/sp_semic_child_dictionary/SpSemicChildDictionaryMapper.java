package com.pj.project.sp_semic_child_dictionary;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pj.utils.so.*;
import org.springframework.stereotype.Repository;

/**
 * Mapper: sp_semic_child_dictionary -- 半导体词典表的子集信息
 * @author lizhihao 
 */

@Mapper
@Repository
public interface SpSemicChildDictionaryMapper {

	/**
	 * 增  
	 * @param s 实体对象 
	 * @return 受影响行数 
	 */
	int add(SpSemicChildDictionary s);

	/**
	 * 删  
	 * @param id 要删除的数据id  
	 * @return 受影响行数 
	 */
	int delete(Long id);	 

	/** 
	 * 改  
	 * @param s 实体对象 
	 * @return 受影响行数 
	 */
	int update(SpSemicChildDictionary s);

	/** 
	 * 查 - 根据id  
	 * @param id 要查询的数据id 
	 * @return 实体对象 
	 */
	SpSemicChildDictionary getById(Long id);	 

	/**
	 * 查集合 - 根据条件（参数为空时代表忽略指定条件）
	 * @param so 参数集合 
	 * @return 数据列表 
	 */
	List<SpSemicChildDictionary> getList(SoMap so);


}
