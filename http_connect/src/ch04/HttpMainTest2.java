package ch04;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Post;

public class HttpMainTest2 {

	public static void main(String[] args) {
		//소통할떄 필요한놈
		try {
			//준비물 1 (http통신을 하기 위한 준비물)
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			//준비물 2    (레퍼런스주소값이 담겨져있다)
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			//부가적인 정보를 추가해서 보내기
			connection.setRequestMethod("GET");
			connection.connect();
			
			
			
			
			
			//응답하는 코드 (프로토콜로 볼수가있다)  100번 200번 300번 400번 500번 종류가 있다   (200 성공  400 실패)
			int statusCode = connection.getResponseCode();
//			System.out.println("statusCode : " + statusCode); //콘솔로 200이 나오면 성공한거다
			
			//일반적으로 http통신 할 때 스트림을 받아야한다.
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //받는 입장이라서 Reader
			
			StringBuffer sb = new StringBuffer();//메모리를 줄이기 위해서 
			String line = null;
			
			if(statusCode == 200) {//성공이라면
				while((line = reader.readLine()) != null){//리드라인으로 line의 데이터타입을 읽어서 null이 아닐때까지 반복
					sb.append(line + "\n");
				}
			}
		
			String str = sb.toString();//StringBuffer과 String은 달라서 toString으로 바꿔준다.
			Type postList = new TypeToken<ArrayList<Post>>() {}.getType();
			ArrayList<Post> arrayList = new Gson().fromJson(str, postList);
			for (Post post : arrayList) {
				System.out.println(post);
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
