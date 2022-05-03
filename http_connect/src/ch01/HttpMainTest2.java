package ch01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import dto.Post;

public class HttpMainTest2 {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/20");
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
				System.out.println(str);
				
				Post post = new Post();
				
				post.userId = Integer.parseInt(str.substring(13, 14));
				post.id = Integer.parseInt(str.substring(23, 25));
				post.title = str.substring(38, 72);
//				post.userId = Integer.parseInt(str.substring(13, 14));
				System.out.println(post.userId);
				System.out.println(post.id);
				System.out.println(post.title);
				
				
				
				//문자열을 파싱해서 post객체에 값을 받아서 담아보세요.
				//잘 담겼는데 출력까지. 
				
				
				
				 
				
				
				
				
				
				
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
