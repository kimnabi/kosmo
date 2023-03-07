package a.b.c.ch3;

public class IfTest_2 
{
	public static void main(String[] args) 
	{
		// ======================================
		//  if 문은 조건식이 ture 일 때 if 절이 수행 된다.
		// ======================================

		/*
		if (true)
		{
			System.out.println(">>>");
		}
		*/
		// if 문 실행결과 가 true이거나 false에 맞게 분기한다
		// ?? 조건식이 없는 경우 if 문은 true 으로 분기한다 default 
		if (false)
		{
			// if 절 
			System.out.println(">>>");
		}else{
			// else 절 
			System.out.println("<<<>>>");
		}

		boolean bool = true;
		System.out.println("bool >>> : " + bool);
		//조건식결과가 true 일때는 if 절 으로 분기한다 
		//조건식결과가 false 일때는 else 절 으로 분기한다 
		if (bool)
		{
			System.out.println("if 절 :: bool >>> : " + bool);
			// if 절 
			System.out.println(">>>");
		}else{
			// else 절 
			System.out.println("<<<>>>");
		}

	}
}
