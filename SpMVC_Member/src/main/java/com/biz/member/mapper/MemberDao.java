package com.biz.member.mapper;

import java.util.List;

import com.biz.member.model.MemberVO;

public interface MemberDao {

	public List<MemberVO> selectAll();

	public MemberVO findById(String m_userid);

	public int insert(MemberVO memberVO);

	public int update(MemberVO memberVO);

	public int delete(String m_userid);
	
	public List<MemberVO> loginCheck(String m_userid);

}
