
*** 입출력 스트림 ***

*** 입출력 스트림의 구분 ***
대상기준 : 입력 스트림/ 출력 스트림
자료의 종류 : 바이트 스트림 / 문자 스트림
기능 : 기반 스트림 / 보조 스트림

***입출력 스트림의 종류***
입력 스트림 : FileInputStream, FileReader, BufferdInputStream, BufferdReader 등등
출력 스트림 : FileoutputStream, FileWriter, BufferdOutStream, BufferdWriter 등등

** 바이트 단위 스트림과/ 문자 단위 스트림 **
바이트 단위 스트림 : 동영상, 음악 파일, 실행 파일 등 자료를 읽고 쓸 때 사용한다.
문자 단위 스트림 : 바이트 단위로 자료를 처리하게 되면 문자는 깨진다. 최소한 한글을 사용하기 위해서는 인코딩에 맞게 2바이트 이상
처리하도록 구현된 스트림이다.

** 기반 스트림과 / 보조 스트림 **
기반 스트림 : 대상에 직접 자료를 읽어 들이거나 쓰는 기능을 가지고 있다(바이트 단위, 문조 단위)
보조 스트림 : 직접 읽고 쓰는 기능은 없고 추가적인 기능을 더해 주는 스트림이다.

참고: 보조 스트림은 직접 읽고 쓰는 기능이 없기 때문에 보조 스트림 생성자에 기반 스트림을 포함 시켜서 사용한다.