import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;

public class Item001 {

	
	/*
	 * @��ó : ������ ���ũ, ������Ƽ�� �ڹ١�, ���ոʽ�(�̺���) �ű�, ���α׷��� �λ���Ʈ(2020), p8-13
	 */
	
	/*
	 * "������ ��� ���� ���͸� �޼��带 ����϶�"
	 * 
	 * -> ���� ���͸� �޼���� public �����ڴ� ������ ���ӻ��� ������ ������� ������� �����ϰ� ����ϴ� ���� ����.
	 * �׷��ٰ� �ϴ��� ���� ���͸��� ����ϴ� �� ������ ��찡 �� �����Ƿ� ������ public �����ڸ� �����ϴ� ������ �ִٸ� ��ġ��.
	 * 
	 * 
	 *
	 * ����
	 * 1. �̸��� ���� �� �ִ�. (�����ڿ� ���� �� �ǹ̸� ��üȭ�� �� ����)
	 * 2. ȣ��� ������ �ν��Ͻ��� ���� �������� �ʾƵ� �ȴ�. 
	 * 3. ��ȯ Ÿ���� ���� Ÿ�� ��ü�� ��ȯ�� �� �ִ� �ɷ��� �ִ�. 
	 * 4. �Է� �Ű������� ���� �Ź� �ٸ� Ŭ������ ��ü�� ��ȯ�� �� �ִ�. 
	 * 5. ���� ���͸� �޼��带 �ۼ��ϴ� �������� ��ȯ�� ��ü�� Ŭ������ �������� �ʾƵ� �ȴ�. 
	 * 
	 * ����
	 * 1. ����� �Ϸ��� public�̳� protected �����ڰ� �ʿ��ϴ� ���� ���͸� �޼��常 �����ϸ� ���� Ŭ������ ���� �� ����.
	 * 2. ���� ���͸� �޼���� ���α׷��Ӱ� ã�� ��ƴ�. 
	 * 
	 * �� Flyweight pattern
	 */
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	
	//from : �Ű������� �ϳ� �޾Ƽ� �ش� Ÿ���� �ν��Ͻ��� ��ȯ�ϴ� ����ȯ �޼���
	Date d  = Date.from(instant);
	
	//of : ���� �Ű������� �޾� ������ Ÿ���� �ν��Ͻ��� ��ȯ�ϴ� ���� �޼���
	Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
	
	//valueOf : from�� of�� �� �ڼ��� ����
	BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
	
	//instance Ȥ�� getInstance : (�Ű������� �޴´ٸ�) �Ű������� ����� �ν��Ͻ��� ��ȯ������, ���� �ν��Ͻ����� ���������� �ʴ´�.
	StackWalker luke = StackWalker.getInstance(options);
	
	//create Ȥ�� newInstance : instance Ȥ�� getInstance�� ������, �Ź� ���ο� �ν��Ͻ��� ������ ��ȯ���� �����Ѵ�.
	Object newArray = Array.newInstance(classObject, arrayLen);
	
	//getType : getInstance�� ������, ������ Ŭ������ �ƴ� �ٸ� Ŭ������ ���͸� �޼��带 ������ �� ����. "Type"�� ���͸� �޼��尡 ��ȯ�� ��ü�� Ÿ���̴�.
	FileStore fs = Files.getFileStore(path);
	
	//newType : newInstance�� ������, ������ Ŭ������ �ƴ� �ٸ� Ŭ������ ���͸� �޼��带 ������ �� ����. "Type"�� ���͸� �޼��尡 ��ȯ�� ��ü�� Ÿ���̴�.
	BufferReader br = Files.newBufferedReader(path);
	
	//type : getType�� newType�� ������ ����
	List<Complaint> litany = Collections.list(legacyLitany);
	
	
	
}
