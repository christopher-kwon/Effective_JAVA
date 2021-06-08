
public class Item005 {

	/*
	 * @��ó : ������ ���ũ, ������Ƽ�� �ڹ١�, ���ոʽ�(�̺���) �ű�, ���α׷��� �λ���Ʈ(2020), p28-30.
	 */

	/*
	 * "�ڿ��� ���� ������� ���� ���� ��ü ������ ����϶�"
	 */
	

	// ���� ��ƿ��Ƽ�� �߸� ����� �� - �������� �ʰ� �׽�Ʈ�ϱ� ��ƴ�.
	public class SpellChecker {
		private static final Lexicon dictionary = ...;

		private SpellChecker() {
		} // ��ü ���� ����

		public static boolean isValid(String word) { ... }

		public static List<String> suggestions(String typo) { ... }
	}

	// �̱����� �߸� ����� �� - �������� �ʰ� �׽�Ʈ�ϱ� ��ƴ�
	public class SpellChecker {
		private final Lexicon dictionary = ...;

		private SpellChecker(...) {}

		public static SpellChecker INSTANCE = new SpellChecker(...);

		public boolean isValid(String word) { ... }

		public List<String> suggestions(String typo) { ... }
	}

	// ���� ��ü ������ �������� �׽�Ʈ ���̼��� �����ش�.
	public class SpellChecker {
		private final Lexicon dictionary;

		public SpellChecker(Lexicon dictionary) {
			this.dictionary = Objects.requireNonNull(dictionary);
		}

		public boolean isValid(String word) { ... }

		public List<String> suggestions(String typo) { ... }
	}
}
