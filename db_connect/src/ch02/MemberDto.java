package ch02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {

	// MySQL table에 null이 있으면 오류가 뜬다!!!!
	@NonNull
	private String memberId;
	@NonNull
	private String memberName;
	
	private String memberAddress;

}
