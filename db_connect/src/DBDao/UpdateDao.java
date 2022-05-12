package DBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBInterface.IUpdate;

public class UpdateDao implements IUpdate{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null;

	
	@Override
	public void movieNameUpdate(String movieName, int movieNuber) {
		try {
			String movieNameUpdate1 = "UPDATE movieTbl SET movieName = ? WHERE movieNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(movieNameUpdate1);
			preparedStatement.setString(1, movieName);
			preparedStatement.setInt(2, movieNuber);
			
			int movieNameupdateCount = preparedStatement.executeUpdate();
			System.out.println("updateCount : " + movieNameupdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void movieratingUpdate(double starRating, int movieNumber) {
		try {
			String movieRatingUpdate1 = "UPDATE movieTbl set starRating = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieRatingUpdate1);
			preparedStatement.setDouble(1, starRating);
			preparedStatement.setInt(2, movieNumber);
			
			int movieRatingUpdateCount = preparedStatement.executeUpdate();
			System.out.println("ratingUpdateCount : " + movieRatingUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void movieYearUpdate(String releasedDate, int movieNuber) {
		try {
			String movieYearUpdate1 = "UPDATE movieTbl SET releasedDate = ? WHERE movieNuber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieYearUpdate1);
			preparedStatement.setString(1, releasedDate);
			preparedStatement.setInt(2, movieNuber);
			
			int movieYearUpdateCount = preparedStatement.executeUpdate();
			System.out.println("yearUpdateCount : " + movieYearUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void movieSalesUpdate(long revenue, int movieNumber) {
		try {
			String movieSalesUpdate1 = "UPDATE movieTbl SET revenue = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieSalesUpdate1);
			preparedStatement.setLong(1, revenue);
			preparedStatement.setInt(2, movieNumber);
			
			int movieSalesUpdateCount = preparedStatement.executeUpdate();
			System.out.println("SalesUpdateCount : " + movieSalesUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void movieAudienceUpdate(int audience, int movieNumber) {
		try {
			String movieAudienceUpdate1 = "UPDATE movieTbl SET audience = ? WHERE movieNumber = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(movieAudienceUpdate1);
			preparedStatement.setInt(1, audience);
			preparedStatement.setInt(2, movieNumber);
			
			int movieAudienceUpdateCount = preparedStatement.executeUpdate();
			System.out.println("AudienceUpdateCount : " + movieAudienceUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	// ======================================================
	
	
	@Override
	public void actorNameUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actorYearUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actorHeightUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actorWeightUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actorSpouseUpdate() {
		// TODO Auto-generated method stub
		
	}

	
	// ======================================================
	
	@Override
	public void moviePriceUpdate() {
		// TODO Auto-generated method stub
		
	}

	
	// ======================================================
	
	
	@Override
	public void AppearActorNumUpdate(int actorNumber, String roleName, int movieNumber) {
		try {
			String appearActorNumUpdate1 = "UPDATE roleTbl SET actorNumber = ? WHERE roleName = ? AND movieNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearActorNumUpdate1);
			preparedStatement.setInt(1, actorNumber);
			preparedStatement.setString(2, roleName);
			preparedStatement.setInt(3, movieNumber);
			
			int appearActorNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearActorNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void AppearRoleUpdate(String role, String roleName, int actorNumber) {
		try {
			String appearActorNumUpdate1 = "UPDATE roleTbl SET role = ? WHERE roleName = ? AND actorNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearActorNumUpdate1);
			preparedStatement.setString(1, role);
			preparedStatement.setString(2, roleName);
			preparedStatement.setInt(3, actorNumber);
			
			int appearActorNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearActorNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void AppearRoluNameUpdate(String roleName, int movieNumber, int actorNumber) {
		try {
			String appearActorNumUpdate1 = "UPDATE roleTbl SET roleName = ? WHERE movieNumber = ? AND actorNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(appearActorNumUpdate1);
			preparedStatement.setString(1, roleName);
			preparedStatement.setInt(2, movieNumber);
			preparedStatement.setInt(3, actorNumber);
			
			int appearActorNumUpdateCount = preparedStatement.executeUpdate();
			System.out.println("appearActorNumUpdateCount : " + appearActorNumUpdateCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
