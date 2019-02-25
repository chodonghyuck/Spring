package com.biz.ajax01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import com.biz.ajax01.model.DeptVO;

public interface DeptMapper {
	
	@Select(" SELECT * FROM tbl_dept ORDER BY d_code")
	public List<DeptVO> selectAll();
	
	@Select(" SELECT * FROM tbl_dept WHERE d_code = #{d_code} ")
	public DeptVO findByDCode(String d_code);
	
	@Select(" SELECT * FROM tbl_dept WHERE d_name LIKE '%' || #{d_name} || '%' ORDER BY d_name ")
	public List<DeptVO> findByDName(String d_name);
	
	@InsertProvider(type=DeptSQLBuilder.class, method = "getInsertSQL")
	public int insert(DeptVO vo);
	
	@InsertProvider(type=DeptSQLBuilder.class, method = "getUpdateSQL")
	public int update(DeptVO vo);
	
	@InsertProvider(type=DeptSQLBuilder.class, method = "getDeleteSQL")
	public int delete(String d_code);

}
