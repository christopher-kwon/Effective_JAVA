
public class Item003 {

	
	/*
	 * @��ó : ������ ���ũ, ������Ƽ�� �ڹ١�, ���ոʽ�(�̺���) �ű�, ���α׷��� �λ���Ʈ(2020), p23-25.
	 */
	
	/*
	 * "private �����ڳ� ���� Ÿ������ �̱������� �����϶�"
	 * 
	 */
	
	//�̱��� ����� ��� #1
	public class Elvis {
		public static final Elvis INSTANCE = new Elvis();
		private Elvis() {
			...
		}
		
		public void leaveTheBuilding() {
			...
		}
	}
	
	//�̱��� ����� ���#2
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
		
		//�̱������� �������ִ� readResolve �޼���
		private Object readResolve() {
			//'��¥' Elvis�� ��ȯ�ϰ�, ��¥ Elvis�� ������ �÷��Ϳ� �ñ��. 
			return INSTANCE;
		}
	}
	
	//�̱��� ����� ��� #3
	public enum Elvis {
		INSTANCE;
		
		public void leaveTheBuilding() {
			...
		}
	}
	
}
