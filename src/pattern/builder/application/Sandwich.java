/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * May 16, 2020: 11:53:39 AM
 */
package pattern.builder.application;

import java.util.ArrayList;
import java.util.List;

public final class Sandwich {
	
	private final String bread;
	private final String meat;
	private List<String> toppings;
	private List<String> condiments;
	
	private Sandwich(Builder b) {
		bread = b.bread;
		meat = b.meat;
		toppings = b.toppings;
		condiments = b.condiments;
	}

	@Override
	public String toString () {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("Your sandwich: ");
		buffer.append(meat + " on ");
		buffer.append(bread + ", with: ");
		buffer
			.append( (toppings.size() == 0) ? "no toppings" : toppings.toString());
		buffer.append(" and ");
		buffer.append(
			(condiments.size() == 0) ? "no condiments" : condiments.toString());
		
		return buffer.toString();
	}
	
	public static class Builder {
		
		private final String bread;
		private final String meat;
		private final List<String> toppings = new ArrayList<>();
		private final List<String> condiments = new ArrayList<>();
		
		private List<OrderListener> listeners;
		
		public Builder(String bread, String meat) {
			this.listeners = new ArrayList<>();
			this.bread = bread;
			this.meat = meat;
		}
		
		public void addListener(OrderListener l) { listeners.add(l); }
		
		private void notifyListeners(Sandwich sandwich) {
			for(OrderListener listener : listeners) {
				listener.onItemAdded(sandwich);
			}
		}
		
		public Builder addTopping (String condiment) {
			toppings.add(condiment);
			return this;
		}
		
		public Builder addCondiment (String condiment) {
			condiments.add(condiment);
			return this;
		}
		
		public Builder removeTopping (String topping) {
			toppings.remove(topping);
			return this;
		}
		
		public Sandwich makeSandwich () {
			Sandwich sandwich = new Sandwich(this);
			notifyListeners(sandwich);
			return sandwich;
		}
	}
	
	public static void main (String... strings) {
		
		OrderDisplay display = new OrderDisplay();
		
		Builder sandwichMaker = new Sandwich.Builder("club bread", "grilled chicken");
		sandwichMaker.addListener(display);
		sandwichMaker.addCondiment("ketchup").addTopping("lettuce")
			.addTopping("tomato").addTopping("onions");
		// Confirm order with customer... Make sandwich after confirmation
		sandwichMaker.makeSandwich();
		
		sandwichMaker = new Sandwich.Builder("burger bun", "burger patty");
		sandwichMaker.addListener(display);
		sandwichMaker.addCondiment("ketchup").addCondiment("mustard")
			.addTopping("tomato").addCondiment("mayo");
		// Confirm order with customer... customer doesn't want tomato on his burger
		sandwichMaker.removeTopping("tomato");
		// Now make the sandwich
		sandwichMaker.addTopping("grilled onions")
			.addTopping("pickles").makeSandwich();
		
		// Listener using Lambda function instead of a class
		sandwichMaker = new Sandwich.Builder("club bread", "burger patty");
		sandwichMaker.addListener(sandwich -> System.out.println(sandwich));
		sandwichMaker.makeSandwich();		
	}
}
