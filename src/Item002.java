import java.util.EnumSet;
import java.util.Objects;

public class Item002 {

	/*
	 * @��ó : ������ ���ũ, ������Ƽ�� �ڹ١�, ���ոʽ�(�̺���) �ű�, ���α׷��� �λ���Ʈ(2020), p14-22.
	 */
	
	/*
	 * "�����ڿ� �Ű������� ���ٸ� ������ ����϶�" (��������, Builder pattern)
	 * -> �����ڳ� ���� ���͸��� ó���ؾ� �� �Ű������� ���ٸ� ���� ������ �����ϴ°� �� ����.
	 * �Ű����� �� �ټ��� �ʼ��� �ƴϰų� ���� Ÿ���̸� Ư�� �� �׷���. ������ ������ �����ں��� Ŭ���̾�Ʈ �ڵ带
	 * �а� ���Ⱑ �ν� �����ϰ�, �ڹٺ���� �ξ� �����ϴ�. 
	 */
	
	
	
	//������ ������ ����(Telescoping constructor pattern)
	public class NutritionFacts {
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;
		
		public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
			this.servingSize = servingSize;
			this.servings = servings;
			this.calories = calories;
			this.fat = fat;
			this.sodium = sodium;
			this.carbohydrate = carbohydrate;
			
		}
	}
	
	//�ڹ� ���� ����(JavaBeans pattern)
	public class NutritionFacts {
		private  int servingSize  = -1;
		private  int servings     = -1;
		private  int calories     = 0;
		private  int fat          = 0;
		private  int sodium       = 0;
		private  int carbohydrate = 0;
		
		public NutritionFacts() {}
		
		public void setServingSize(int val) 	{ servingSize = val; }
		public void setServings(int val) 		{ servings = val; }
		public void setCalories(int val) 		{ calories = val; }
		public void setFat(int val) 			{ fat = val; }
		public void setSodium(int val) 			{ sodium = val; }
		public void setCarbohydrate(int val) 	{ carbohydrate = val; }
	}
	
	//���� ���� - ������ ������ ���ϰ� �ڹٺ��� ������ ������ ���ߴ�. 
	public class NutritionFacts {
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;
		
		public static class Builder {
			//�ʼ� �Ű�����
			private final int servingSize;
			private final int servings;
			
			//���� �Ű����� - �⺻������ �ʱ�ȭ �Ѵ�. 
			private int calories 		= 0;
			private int fat   			= 0;
			private int sodium 			= 0;
			private int carbohydrate 	= 0;
			
			public Builder(int servingSize, int servings) {
				this.servingSize 	= servingSize;
				this.servings 		= servings;
			}
			
			public Builder calories(int val) 		{ calories = val; return this; }
			public Builder fat(int val) 			{ fat = val; return this; }
			public Builder sodium(int val) 			{ sodium = val; return this; }
			public Builder carbohydrate(int val) 	{ carbohydrate = val; return this; }
			
			public NutritionFacts build() {
				return new NutritionFacts(this);
			}
		} //public static class Builder
		
		private NutritionFacts(Builder builder) {
			servingSize 		= builder.servingSize;
			servings 			= builder.servings;
			calories 			= builder.calories;
			fat 				= builder.fat;
			sodium 				= builder.sodium;
			carbohydrate 		= builder.carbohydrate;
			
		}

	}// (��������, Builder pattern)
	
	
	//���������� ����� Ŭ������ �� ��︮�� ���� ����
	public abstract class Pizza {
		public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
		final Set<Topping> toppings;
		
		abstract static class Builder<T extends Builder<T>> {
			EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
			public T addTopping(Topping topping) {
				toppings.add(Objects.requireNonNull(topping));
				return self();
			}
			
			abstract Pizza build();
			
			protected abstract T self();
		}
		
		Pizza(Builder<?> builder) {
			toppings = builder.toppings.clone();
		}
	} //public abstract class Pizza
	
	//NewYork Pizza
	public class NyPizza extends Pizza {
		public enum Size { SMALL, MEDIUM, LARGE }
		private final Size size;
		
		public static class Builder extends Pizza.Builder<Builder> {
			private final Size size;
			
			public Builder(Size size) {
				this.size = Objects.requireNonNull(size);
			}
			
			@Override public NyPizza build() {
				return new NyPizza(this);
			}
			
			@Override protected Builder self() { return this; }
			
		}
		
		private NyPizza(Builder builder) {
			super(builder);
			size = builder.size;
		}
	}
	
	//Calzone Pizza
	public class Calzone extends Pizza {
		private final boolean sauceInside;
		
		public static class Builder extends Pizza.Builder<Builder> {
			private boolean sauceInside = false;
			
			public Builder sauceInside() {
				sauceInside = true;
				return this;
			}
			
			@Override public Calzone build() {
				return new Calzone(this);
			}
			
			@Override protected Builder self() { return this; }
		}
		
		private Calzone(Builder builder) {
			super(builder);
			sauceInside = builder.sauceInside;
		}
	}
	
	
	
}
