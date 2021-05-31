import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;

public class Item001 {

	
	/*
	 * @출처 : 조슈아 블로크, 『이펙티브 자바』, 개앞맵시(이복연) 옮김, 프로그래밍 인사이트(2020), p8-13
	 */
	
	/*
	 * "생성자 대신 정적 팩터리 메서드를 고려하라"
	 * 
	 * -> 정적 팩터리 메서드와 public 생성자는 각자의 쓰임새가 있으니 상대적인 장단점을 이해하고 사용하는 것이 좋다.
	 * 그렇다고 하더라도 정적 팩터리를 사용하는 게 유리한 경우가 더 많으므로 무작정 public 생성자를 제공하던 습관이 있다면 고치자.
	 * 
	 * 
	 *
	 * 장점
	 * 1. 이름을 가질 수 있다. (생성자에 비해 그 의미를 구체화할 수 있음)
	 * 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다. 
	 * 3. 반환 타입의 하위 타입 개체를 반환할 수 있는 능력이 있다. 
	 * 4. 입력 매개변수에 따라 매번 다른 클래스의 개체를 반환할 수 있다. 
	 * 5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 개체의 클래스가 존재하지 않아도 된다. 
	 * 
	 * 단점
	 * 1. 상속을 하려면 public이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
	 * 2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다. 
	 * 
	 * ※ Flyweight pattern
	 */
	public static Boolean valueOf(boolean b) {
		return b ? Boolean.TRUE : Boolean.FALSE;
	}
	
	//from : 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
	Date d  = Date.from(instant);
	
	//of : 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
	Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
	
	//valueOf : from과 of의 더 자세한 버전
	BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
	
	//instance 혹은 getInstance : (매개변수를 받는다면) 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스임을 보장하지는 않는다.
	StackWalker luke = StackWalker.getInstance(options);
	
	//create 혹은 newInstance : instance 혹은 getInstance와 같지만, 매번 새로운 인스턴스를 생성해 반환함을 보장한다.
	Object newArray = Array.newInstance(classObject, arrayLen);
	
	//getType : getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. "Type"은 팩터리 메서드가 반환할 개체의 타입이다.
	FileStore fs = Files.getFileStore(path);
	
	//newType : newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할 때 쓴다. "Type"은 팩터리 메서드가 반환할 개체의 타입이다.
	BufferReader br = Files.newBufferedReader(path);
	
	//type : getType과 newType의 간결한 버전
	List<Complaint> litany = Collections.list(legacyLitany);
	
	
	
}
