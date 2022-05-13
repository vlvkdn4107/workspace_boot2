package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.Data;

@Data
public class MovieInfoDao implements ISelect{

	private static final String TABLE_NAME = "영화정보";
	private DBClient client;
	private Connection connection;
	private ResultSet rs = null;
	
	
	private ArrayList<MovieInfoDto> movieInfo;
	private ArrayList<actorDto> actorInfo;
	
	private MovieInfo info = new MovieInfo();
	private MovieInfo actorinfo = new MovieInfo();
	
	public MovieInfoDao() {
		client = DBClient.getInstance();
		connection = client.getConnection();
	}
	
	
	public ArrayList<MovieInfoDto> selectAll(){
		
		 movieInfo = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "select * from movieTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			
			while(rs.next()) {
				
				MovieInfoDto dto = new MovieInfoDto();
				
				int movieNumber = rs.getInt("movieNumber");
				String movieName = rs.getString("movieName");
				String releasedDate = rs.getString("releasedDate");
				long revenue = rs.getLong("revenue");
				long audience = rs.getLong("audience");
				int screen = rs.getInt("screen");
				float starRating = rs.getFloat("starRating");
				
				dto.setMovieNumber(movieNumber);
				dto.setMovieName(movieName);
				dto.setReleasedDate(releasedDate);
				dto.setRevenue(revenue);
				dto.setAudience(audience);
				dto.setScreen(screen);
				dto.setStarRating(starRating);
				
				movieInfo.add(dto);
				
				info.getModel().addRow(new Object[] {rs.getInt("movieNumber"),rs.getString("movieName"),
						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
						rs.getInt("screen"), rs.getFloat("starRating")});
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieInfo;
		
	}
	public ArrayList<actorDto> actorSelectAll(){
		
		actorInfo = new ArrayList<actorDto>();
		
		try {
			String query = "select * from actorTbl";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			
			
			while(rs.next()) {
				
				actorDto dto = new actorDto();
				
				int actorNumber = rs.getInt("actorNumbe");
				String actorName = rs.getString("actor");
				int birthYear = rs.getInt("birthYear");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String spouse = rs.getString("spouse");

				
				dto.setActorNumber(actorNumber);
				dto.setActorName(actorName);
				dto.setBirthYear(birthYear);
				dto.setHeight(height);
				dto.setWeight(weight);
				dto.setSpouse(spouse);
				
				actorInfo.add(dto);
				
				info.getModel().addRow(new Object[] {rs.getInt("actorNumbe"),rs.getString("actor"),
						rs.getInt("birthYear"), rs.getInt("height"), rs.getInt("weight"), 
						rs.getString("spouse")});
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actorInfo;
		
	}
	
	@Override
	public ArrayList<MovieInfoDto> selectByMovieName(String movieName) {
		
		ArrayList<MovieInfoDto> movieInfo = new ArrayList<MovieInfoDto>();
		
		try {
			String query = "SELECT * FROM movieTbl WHERE movieName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, movieName);
			rs = preparedStatement.executeQuery();
			
			
			while(rs.next()){
				MovieInfoDto dto = new MovieInfoDto();
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				movieInfo.add(dto);
				
				info.getModel().addRow(
						new Object[] {
						rs.getInt("movieNumber"),rs.getString("movieName"),
						rs.getString("releasedDate"), rs.getLong("revenue"), rs.getLong("audience"), 
						rs.getInt("screen"), rs.getFloat("starRating")
						});
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieInfo;
		
	}
	
	
	
	@Override
	public ArrayList<MovieInfoDto> selectByReleasedYear(String releasedYear) {
		
		ArrayList<MovieInfoDto> movieInfo = new ArrayList<MovieInfoDto>();
		try {
			String query = "SELECT * FROM 영화정보 WHERE 개봉년도 = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, releasedYear);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				MovieInfoDto dto = new MovieInfoDto();
				
				dto.setMovieNumber(rs.getInt("movieNumber"));
				dto.setMovieName(rs.getString("movieName"));
				dto.setReleasedDate(rs.getString("releasedDate"));
				dto.setRevenue(rs.getLong("revenue"));
				dto.setAudience(rs.getLong("audience"));
				dto.setStarRating(rs.getFloat("starRating"));
				
				movieInfo.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movieInfo;
		
	}
	

	
	
}