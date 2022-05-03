package dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
class Genres{
	String Action;
	String Drama;
	String Thriller;

}
class Movies {
	
	String id;
	String imdb_code;
	String title;
	String title_english;
	String title_long;
	String slug;
	int year;
	int rating;
	int runTime;
	Genres genres = new Genres();
	String summary;
	String description;
	String synopsis;
	String yt_trailer_code;
	String language;
	String mpa_rating;
	String background_image;
	String backgroud_image_original;
	String small_cover_image;
	String medium_cover_image;
	String large_cover_image;
	String stats;
	
}
public class Data {
	int Movie_count;
	int limit;
	int page_numver;
	Movies movies = new Movies();
}
