package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import dto.Post;

public class HttpMainTest3 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			try {
				HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();//다운 캐스팅
				connection.setRequestMethod("GET");//REST API라고 한다
				
//				connection.setRequestProperty("Content-type", "application/json");//이런것도 있다 알고만 있어라
				connection.connect();//요청
				int statusCode = connection.getResponseCode();
				BufferedReader reder = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				StringBuffer buffer = new StringBuffer();
				String line = null;
				
				if(statusCode == 200) {
					while((line = reder.readLine()) != null) {
						buffer.append(line);
					}
				}else if(statusCode == 404) {//if else로 방어적 코드
					System.out.println("네트워크 연결이 불안정합니다");
				}
				String str = buffer.toString();
				
				System.out.println("-------------------------------");
			
				
				
				
				Gson gson = new Gson();
				Post post = gson.fromJson(str, Post.class);//.class 리플레싱??기법?
				
//				System.out.println(post.userId);
//				System.out.println(post.id);
//				System.out.println(post.title);
//				System.out.println(post.body);
				
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
