
public class Item004 {
	
	/*
	 * @출처 : 조슈아 블로크, 『이펙티브 자바』, 개앞맵시(이복연) 옮김, 프로그래밍 인사이트(2020), p26-27.
	 */
	
	/*
	 * "인스턴스화를 막으려거든 private 생성자를 사용하라"
	 */
	public class UtilityClass {
		// 기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지용)
		private UtilityClass() {
			throw new AssertionError();
		}
		.... //나머지 코드는 생략
	}
}
