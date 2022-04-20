package File_io_ch01;

import java.io.FileInputStream;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 바이트 단위 스트림
 * 파일에서 바이트를 배열 단위로 읽기
 */
public class MainTest3 {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("boot_b.txt")){//여기 안에서는 ;안써도된다
			byte[] bs = new byte[10];//바이트 단위로 읽을거기떄문에
			int i;
//			while((i = fis.read(bs)) !=-1) {//read안에 bs를 넣으면 이 배열의 크기만큼 읽어라
//				for(int j = 0; j < i; j++) {					
//					System.out.println("i :" + i);
//					System.out.println("j :" + j);
//					System.out.println((char)bs[j]);
//				}
//				
//			}
			while((i = fis.read(bs, 1, 5)) !=-1) {//1번쨰 부터 5번쨰 바이트 까지
				for(int j = 0; j < i; j++) {					
//					System.out.println("i :" + i);
//					System.out.println("j :" + j);
					System.out.println((char)bs[j]);
				}
				System.out.println("i :" + i + "바이트 읽음");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
 
		
	}
}
