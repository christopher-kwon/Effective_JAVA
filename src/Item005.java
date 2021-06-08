
public class Item005 {

	/*
	 * @출처 : 조슈아 블로크, 『이펙티브 자바』, 개앞맵시(이복연) 옮김, 프로그래밍 인사이트(2020), p28-30.
	 */

	/*
	 * "자원을 직접 명시하지 말고 의존 개체 주입을 사용하라"
	 */
	

	// 정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
	public class SpellChecker {
		private static final Lexicon dictionary = ...;

		private SpellChecker() {
		} // 개체 생성 방지

		public static boolean isValid(String word) { ... }

		public static List<String> suggestions(String typo) { ... }
	}

	// 싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다
	public class SpellChecker {
		private final Lexicon dictionary = ...;

		private SpellChecker(...) {}

		public static SpellChecker INSTANCE = new SpellChecker(...);

		public boolean isValid(String word) { ... }

		public List<String> suggestions(String typo) { ... }
	}

	// 의존 개체 주입은 유연성과 테스트 용이성을 높여준다.
	public class SpellChecker {
		private final Lexicon dictionary;

		public SpellChecker(Lexicon dictionary) {
			this.dictionary = Objects.requireNonNull(dictionary);
		}

		public boolean isValid(String word) { ... }

		public List<String> suggestions(String typo) { ... }
	}
}
