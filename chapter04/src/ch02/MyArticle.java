package ch02;

//호출자 : 인터페이스 멤버변수로 선언
public class MyArticle {
	
	String article;
	WriteArticle onwriteArticle;//콜백함수의 변수에 on을 많이 붙힌다
	
	//주소값 연결 : 생성자에서 연결하는 방법
	public MyArticle(String aticle, WriteArticle onwriteArticle) {
		this.article = article;
		this.onwriteArticle = onwriteArticle;
	}
	public void complete() {
		onwriteArticle.printArticle(article);
	}
	
	
	
}
