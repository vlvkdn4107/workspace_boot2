package ch02;

import java.util.ArrayList;

public interface ImemberinfoDao {

	ArrayList<MemberDto> select();
	int insert(MemberDto dto);
	int update(MemberDto dto);
	int delete(String memberId);
	
	
}
