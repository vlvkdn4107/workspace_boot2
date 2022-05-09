
preparedStatement 사용 방법

Statement 와 preparedStatement 의 차이점은 캐시 사용 유무 입니다

캐시란{
사용자 -----> 바나나를 찾고 싶으면 --> 메모리(램)에서 찾고 없으면 ---> 하드디스크에가서(서치)찾는다 찾아서 메모리에 담아둔다

사용자 -----> 바나나 ---> 메모리에 담아져있기때문에 하드디스크 까지 안가도된다}


따라서 반복적으로 쿼리를 수행한다면 Statement에 비해 성능이 훨씬 좋다.
그리고 보안적인 측면에서도 Statement보다 preparedStatement가 안정성이 높다






