package ch03;

import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import dto.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString



public class MainTest3 {

	public static void main(String[] args) {
		
		
		List<Data> dataList = new ArrayList<Data>();//Data리스트
		String status;
		String status_message;
		
		Gson gson = new Gson();
		
//		Data data = gson.fromJson(40971, 20, 1,Movies.class);
	}

}
