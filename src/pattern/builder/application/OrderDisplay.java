/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * May 16, 2020: 1:09:54 PM
 */
package pattern.builder.application;

public class OrderDisplay implements OrderListener {

	@Override
	public void onItemAdded (Sandwich sandwich) {
		System.out.println(sandwich.toString());
	}
}
