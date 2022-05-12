package DBInterface;


public interface IUpdate {
	
	//영화 이름 수정
	void movieNameUpdate(String movieName, int movieNuber);
	// 영화 평점 수정
	void movieratingUpdate(double starRating, int movieNumber);
	// 영화 개봉년도 수정
	void movieYearUpdate(String releasedDate, int movieNuber);
	// 영화 매출액 수정
	void movieSalesUpdate(long revenue, int movieNumber);
	// 영화 관객수 수정
	void movieAudienceUpdate(int audience, int movieNumber);
	
	
	//배우 이름 수정
	void actorNameUpdate();
	// 배우 출생 수정
	void actorYearUpdate();
	// 배우 키 수정
	void actorHeightUpdate();
	// 배우 몸무게 수정
	void actorWeightUpdate();
	// 배우 배우자 수정
	void actorSpouseUpdate();
	
	//영화금액 수정
	void moviePriceUpdate();
	
	// 출연쪽 배우 번호 수정
	void AppearActorNumUpdate(int actorNumber, String roleName, int movieNumber);
	// 출연쪽 배우의 출연 수정
	void AppearRoleUpdate(String role, String roleName, int actorNumber);
	// 출연쪽 배우의 출연이름 수정
	void AppearRoluNameUpdate(String roleName, int movieNumber, int actorNumber);
	
}
