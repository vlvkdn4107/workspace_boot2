package DBInterface;

import java.sql.Date;
import java.util.ArrayList;

import DBDto.ActorInfoSelectDto;
import DBDto.ActorMovieListSelect;
import DBDto.AllMovieDto;
import DBDto.AllactorListDto;
import DBDto.MovieListSelectDto;
import DBDto.MovieTicketPriceDto;
import DBDto.RoleDto;

public interface ISelect {

	
	
	// 영화에대한 정보리스트 출력 OK
	ArrayList<MovieListSelectDto> movieList(String movieName);
	// 영화티켓 금액 출력 OK
	ArrayList<MovieTicketPriceDto> movieTicketPrice(String movieName);
	//모든 배우 리스트 출력
	ArrayList<AllactorListDto> AllActorInfo();
	// 배우에대한 정보리스트 출력 OK
	ArrayList<ActorInfoSelectDto> actorInfo(String actorName);
	// 배우가 찍은 영화 리스트 출력 OK
	ArrayList<ActorMovieListSelect> actorMovieList(String actorName);
	
	// 모든role 리스트 출력
	ArrayList<RoleDto> roleList1(int movieNumber);
	ArrayList<RoleDto> roleList2(int actorNumber);

	// 모든 영화 리스트 출력
	ArrayList<AllMovieDto> movieInfo1(String movieName);
	ArrayList<AllMovieDto> movieInfo2(String movieYear);
}
