import java.util.EnumSet;
import java.util.Objects;

public class Item002 {

	/*
	 * @출처 : 조슈아 블로크, 『이펙티브 자바』, 개앞맵시(이복연) 옮김, 프로그래밍 인사이트(2020), p14-22.
	 */
	
	/*
	 * "생성자에 매개변수가 많다면 빌더를 고려하라" (빌더패턴, Builder pattern)
	 * -> 생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면 빌더 패턴을 선택하는게 더 낫다.
	 * 매개변수 중 다수가 필수가 아니거나 같은 타입이면 특히 더 그렇다. 빌더는 점층적 생성자보다 클라이언트 코드를
	 * 읽고 쓰기가 훨신 간결하고, 자바빈즈보다 훨씬 안전하다. 
	 */
	
	
	
	//점층적 생성자 패턴(Telescoping constructor pattern)
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
	
	//자바 빈즈 패턴(JavaBeans pattern)
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
	
	//빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. 
	public class NutritionFacts {
		private final int servingSize;
		private final int servings;
		private final int calories;
		private final int fat;
		private final int sodium;
		private final int carbohydrate;
		
		public static class Builder {
			//필수 매개변수
			private final int servingSize;
			private final int servings;
			
			//선택 매개변수 - 기본값으로 초기화 한다. 
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

	}// (빌더패턴, Builder pattern)
	
	
	//계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴
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
