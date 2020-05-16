/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * Apr 27, 2020: 5:11:23 PM
 */
package pattern.nullobject;

public final class NullElement extends Element {
	
	public NullElement () {
		super ("none", "N/A");
	}
	
	@Override
	public String getName () {
		return super.getName ();
	}
	
	@Override
	public void setName (String name) {
		// do nothing
	}
	
	@Override
	public String getValue () {
		return super.getValue ();
	}
	
	@Override
	public void setValue (String value) {
		// do nothing
	}
	
	@Override
	public String toString () {
		return "Element [name=" + getName () + ", value=" + getValue () + "]";
	}
}
