package a.b.c.ch1;


public class ClassInstance extends Object {
	
	public static void main(String[] args) {
		System.out.println("main() 함수 시작 >>> ");
		// new : 왼쪽에 선언한 사용자 정의 클래스를 메모리에 올려주세요 요청하는 키워드 이다.
		// ClassInstance() : 생성자 ClassInstance() 를 찾아서 인스턴스(객체 생성) 요청 한다
		// ClassInstance() : 생성자가 메모리에 올릴때 사용자정의 클래스 는 기본적으로 object 클래스를 상속하고 있어
	    // JVM은 object 클래스를 먼저 메모리에 올리고 그다음 ClassInstance() 객체가 메모리에 올라간다
		ClassInstance ci = new ClassInstance();
		System.out.println("ci >>>"+ ci);
	}//end of main function
} //end of ClassInstance
