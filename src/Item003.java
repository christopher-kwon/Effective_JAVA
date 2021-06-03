
public class Item003 {

	
	/*
	 * @출처 : 조슈아 블로크, 『이펙티브 자바』, 개앞맵시(이복연) 옮김, 프로그래밍 인사이트(2020), p23-25.
	 */
	
	/*
	 * "private 생성자나 열거 타입으로 싱글턴임을 보증하라"
	 * 
	 */
	
	//싱글턴 만드는 방법 #1
	public class Elvis {
		public static final Elvis INSTANCE = new Elvis();
		private Elvis() {
			...
		}
		
		public void leaveTheBuilding() {
			...
		}
	}
	
	//싱글턴 만드는 방법#2
	public class Elvis {
		private static final Elvis INSTANCE = new Elvis();
		private Elvis() {
			...
		}
		public static Elvis getInstance() {
			return INSTANCE;
		}
		
		public void leaveTheBuilding() {
			...
		}
		
		//싱글턴임을 보장해주는 readResolve 메서드
		private Object readResolve() {
			//'진짜' Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다. 
			return INSTANCE;
		}
	}
	
	//싱글턴 만드는 방법 #3
	public enum Elvis {
		INSTANCE;
		
		public void leaveTheBuilding() {
			...
		}
	}
	
}
