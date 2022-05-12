package DBDao;

public class MainTest {

	public static void main(String[] args) {
		
		SelectDao selectDao = new SelectDao();
//		ArrayList<MovieListSelectDto> movielist = selectDao.movieList("국제시장"); 
//		System.out.println(movielist); OK
		
//		ArrayList<MovieTicketPriceDto> ticketPrice = selectDao.movieTicketPrice("국제시장");
//		System.out.println(ticketPrice); OK
		
//		ArrayList<ActorInfoSelectDto> actorInfo = selectDao.actorInfo("로버트 다우니 주니어");
//		System.out.println(actorInfo); OK
		
//		ArrayList<ActorMovieListSelect> actormoive = selectDao.actorMovieList("로버트 다우니 주니어");
//		System.out.println(actormoive); OK
		
//		ArrayList<AllMovieDto> allMovie = selectDao.movieInfo1("명량");
//		System.out.println(allMovie); OK
		
//		ArrayList<AllMovieDto> allMovie = selectDao.movieInfo2("2014,7,30");
//		System.out.println(allMovie); OK
		
		
//		ArrayList<RoleDto> roleDto = selectDao.roleList1(1);
//		System.out.println(roleDto); OK
		
//		ArrayList<RoleDto> roleDto = selectDao.roleList2(1);
//		System.out.println(roleDto); OK
		
		UpdateDao updateDao = new UpdateDao();
//		updateDao.movieNameUpdate();
//		updateDao.movieratingUpdate();
//		updateDao.movieYearUpdate();
//		updateDao.movieAudienceUpdate();
//		updateDao.AppearActorNumUpdate();
		
		InsertDao insertDao = new InsertDao();
//		insertDao.insertMovie(10, "들어감?", "2022,05,12", 1111111111, 120, 2, 7.21); OK
//		insertDao.insertActor(20, "임모씨", 1997, 170.8, 78.2, null);  OK
//		insertDao.insertMoviePrice(10, 111111, 22222, 333333333, 15000); OK
//		insertDao.insertrole(10, 20, "주연", "망나니"); 
		
		DeleteDao deleteDao = new DeleteDao();
//		deleteDao.RoleDelete1(10, 20);  OK
//		deleteDao.RoleDelete2(10); OK
//		deleteDao.movieDelete(10); OK
//		deleteDao.actorDelete(20); OK
//		deleteDao.moviePriceDelete(10); OK

	}

}
