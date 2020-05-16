/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * Apr 27, 2020: 5:07:54 PM
 */
package pattern.nullobject;

public class Element {
	
	private String name;
	private String value;
	
	public Element (String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getValue () {
		return value;
	}
	
	public void setValue (String value) {
		this.value = value;
	}
	
	@Override
	public String toString () {
		return "Element [name=" + getName () + ", value=" + getValue () + "]";
	}
}
