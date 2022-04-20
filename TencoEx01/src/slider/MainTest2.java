package slider;

public class MainTest2 {
	public static void main(String[] args) {
		
		StringBuilder strBuilder1 = new StringBuilder("StringBuilder");
		String str1 = new String("더하기 String(heap)");
		String str2 = "더하기 String(상수풀)";
		String str3 = "";
		System.out.println("↓↓↓↓strBuilder1의 원래 주소↓↓↓↓");
		System.out.println(System.identityHashCode(strBuilder1));
		System.out.println("strBuilder 현재 문자열 : " + strBuilder1);
		System.out.println("=============================");
		strBuilder1.append(str1);
		System.out.println("↓↓↓↓strBuilder1에 str1더한 주소↓↓↓↓");
		System.out.println(System.identityHashCode(strBuilder1));
		System.out.println("strBuilder 현재 문자열 : " + strBuilder1);
		System.out.println("=============================");
		strBuilder1.append(str2);
		System.out.println("↓↓↓↓strBuilder1에 str2더한 주소↓↓↓↓");
		System.out.println(System.identityHashCode(strBuilder1));
		System.out.println("strBuilder 현재 문자열 : " + strBuilder1);
		System.out.println("=============================");
		
		System.out.println("↓↓↓↓str3의 원래 주소↓↓↓↓");
		System.out.println(System.identityHashCode(str3));
		System.out.println("str3 현자 문자열 : " + str3);
		System.out.println("=============================");
		System.out.println("↓↓↓↓strBuilder1을 str3에 형변환후 str3주소 ↓↓↓↓");
		str3 = strBuilder1.toString();
		System.out.println(System.identityHashCode(str3));
		System.out.println("str3 현자 문자열 : " + str3);
		
	}
}
