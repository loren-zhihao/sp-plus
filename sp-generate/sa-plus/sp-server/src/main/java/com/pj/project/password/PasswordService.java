package com.pj.project.password;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.utils.so.*;

/**
 * Service: password -- 密码表
 * @author lizhihao 
 */
@Service
public class PasswordService {

	/** 底层 Mapper 对象 */
	@Autowired
	PasswordMapper passwordMapper;

	/** 增 */
	int add(Password p){
		return passwordMapper.add(p);
	}

	/** 删 */
	int delete(Long id){
		return passwordMapper.delete(id);
	}

	/** 改 */
	int update(Password p){
		return passwordMapper.update(p);
	}

	/** 查 */
	Password getById(Long id){
		return passwordMapper.getById(id);
	}

	/** 查集合 - 根据条件（参数为空时代表忽略指定条件） */  
	List<Password> getList(SoMap so) { 
		return passwordMapper.getList(so);	
	}
	

}
