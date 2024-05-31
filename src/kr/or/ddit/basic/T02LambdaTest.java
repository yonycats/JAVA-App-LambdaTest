package kr.or.ddit.basic;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class T02LambdaTest {
	public static void main(String[] args) {
		
		// 람다식을 사용하지 않았을 경우
		LambdaTestInterface1 lam1 = new LambdaTestInterface1() {
			
			@Override
			public void test() {
				System.out.println("안녕하세요.\n익명구현객체 방식입니다.");
			}
		};
		lam1.test();
		
		
		// 람다식을 사용했을 경우
		LambdaTestInterface1 lam2 = () ->
			System.out.println("반갑습니다.\n람다식으로 구현하는 방식입니다.");
		lam2.test();
		
		System.out.println("-----------------------------------");
		

/*
 		람다식 작성 방법
 		
 		기본형식) (자료형이름 매개변수명, ...) -> {실행문들; ...}
 		
 		1) 매개변수의 '자료형이름'은 생략할 수 있다.
 			예 ) (int a) -> { System.out.println(a); }
 				  (a)   -> { System.out.println(a); }
 		
 		2) 매개변수가 1개일 경우에는 괄호 '()'를 생략할 수 있다.
 			(단, '자료형이름'을 지정할 경우에는 괄호를 생략할 수 없다.)
 			예 ) a -> { System.out.println(a); }
 		
 		3) '실행문'이 1개일 경우에는 '{}'를 생략할 수 있다.
 			(이 때, 문장의 끝을 나타내는 세미콜론(;)도 생략한다.)
 			예 ) a -> System.out.println(a)
 			
 		4) 매개변수가 하나도 없으면 괄호 '()'를 생략할 수 없다.
 			예 ) () -> System.out.println("안녕");
 			
 		5) 반환값이 있을 경우에는 return 명령을 사용한다.
 			예 ) (a, b) -> { return a + b; }
 			    (a, b) -> return a + b
 			    
 		6) 실행문에 return문만 있을 경우 return 명령과 '{}'를 생략할 수 있다.
 			예 ) (a, b) -> a + b
 		
 */
		// 3, 4, 5
		// 자료형 이름 쓰고 싶을 때는 괄호 생략 불가
//		LambdaTestInterface2 lam3 = 
//				(int z) -> {
//					int result = z + 100;
//					System.out.println("result = " + result);
//				};
//		lam3.test(30);
		
		// LambdaTestInterface2는 Consumer 인터페이스로 바꿀 수 있음
		// https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/Object.html
		// 지금 한 것처럼 인터페이스를 따로 정의할 필요 없이 제공하는 인터페이스를 활용할 수 있다.
		Consumer<Integer> lam3 = 
				(Integer z) -> {
					int result = z + 100;
					System.out.println("result = " + result);
				};
		lam3.accept(30);
		
		
		// 자료형 이름 생략 가능
		LambdaTestInterface2 lam4 = 
				z -> {
					int result = z + 300;
					System.out.println("result = " + result);
				};
		lam4.test(60);
		
		// 실행문이 1개여서 '{}'를 생략
		LambdaTestInterface2 lam5 = 
				z -> System.out.println("result = " + (z + 500));;
		lam5.test(90);
		System.out.println("---------------------------------");;
	
		
		
		// 6, 7, 8
		// 자료형 이름 쓰고 싶을 때는 괄호 생략 불가
//		LambdaTestInterface3 lam6 =
//				(int x, int y) -> {
//					int r = x + y;
//					return r;
//				};
		
		// LambdaTestInterface3는 BiFunction 인터페이스로 바꿀 수 있음
		// https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/Object.html
		BiFunction<Integer, Integer, Integer> lam6 =
				(Integer x, Integer y) -> {
					int r = x + y;
					return r;
				};
		int k = lam6.apply(20, 50);
		System.out.println("k = " + k);
		
		// 자료형 이름 생략 가능
		LambdaTestInterface3 lam7 = 
				(x, y) -> {
					return x + y;
				};
		k = lam7.test(80, 50);
		
		// 실행문에 return문만 있을 경우 return 명령과 '{}'를 생략
		LambdaTestInterface3 lam8 = 
				(x, y) -> x + y;
		k = lam8.test(100, 200);
		System.out.println("k = " + k);
		
		
		// 9
		// 실행문에 return문만 있을 경우 return 명령과 '{}'를 생략
		LambdaTestInterface3 lam9 = 
				(x, y) -> x > y ? x : y;
		k = lam9.test(100, 200);
		System.out.println("k = " + k);
	}
}
