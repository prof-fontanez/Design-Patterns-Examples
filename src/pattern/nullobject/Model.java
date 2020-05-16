/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * Apr 27, 2020: 5:08:18 PM
 */
package pattern.nullobject;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<Element> elements;
	
	public Model () {
		elements = new ArrayList<> ();
	}
	
	public List<Element> getElements () {
		return elements;
	}
	
	public void setElements (List<Element> elements) {
		this.elements = elements;
	}
	
	@Override
	public String toString () {
		StringBuilder buffer = new StringBuilder ();
		buffer.append ("Model");
		for (Element e : elements) {
			buffer.append ("\n" + e.toString ());
		}
		return buffer.toString ();
	}
}
