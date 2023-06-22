package com.pj.project.sp_vedio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.utils.so.*;

/**
 * Service: sp_vedio -- 视频表
 * @author lizhihao 
 */
@Service
public class SpVedioService {

	/** 底层 Mapper 对象 */
	@Autowired
	SpVedioMapper spVedioMapper;

	/** 增 */
	int add(SpVedio s){
		return spVedioMapper.add(s);
	}

	/** 删 */
	int delete(Long id){
		return spVedioMapper.delete(id);
	}

	/** 改 */
	int update(SpVedio s){
		return spVedioMapper.update(s);
	}

	/** 查 */
	SpVedio getById(Long id){
		return spVedioMapper.getById(id);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	List<SpVedio> getList(SoMap so) { 
		return spVedioMapper.getList(so);	
	}
	

}
