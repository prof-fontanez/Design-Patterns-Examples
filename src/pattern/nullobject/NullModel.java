/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * Apr 27, 2020: 5:10:38 PM
 */
package pattern.nullobject;

import java.util.ArrayList;
import java.util.List;

public final class NullModel extends Model {
	
	public List<Element> getElements () {
		List<Element> elements = new ArrayList<> ();
		elements.add (new NullElement ());
//		 return new UnmodifiableList<>(elements); // Before Java 8
//		 return Collections.unmodifiableList(elements); // Java 8
		return List.copyOf (elements); // Returns unmodifiable list
	}
	
	public void setElements (List<Element> elements) {
		// do nothing
	}
	
	@Override
	public String toString () {
		StringBuilder buffer = new StringBuilder ();
		buffer.append ("NullModel");
		for (Element e : getElements ()) {
			buffer.append ("\n" + e.toString ());
		}
		return buffer.toString ();
	}
}
