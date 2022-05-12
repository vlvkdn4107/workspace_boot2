package DBDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActorMovieListSelect {

	private String actorName;
	private String movieName;
	private String role;
	private String roleName;
		
}
