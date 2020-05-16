/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * Apr 27, 2020: 5:09:23 PM
 */
package pattern.nullobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NullObjectDemo {
	
	public static void main (String[] args) {
		
		// Setup: Creating a model with elements and adding
		// them to a map of models
		Map<String, Model> models = new HashMap<> ();
		
		Element element1 = new Element ("name1", "element1");
		Element element2 = new Element ("name2", "element2");
		Element element3 = new Element ("name3", "element3");
		Element element4 = new Element ("name4", "element4");
		
		Model model1 = new Model ();
		Model model2 = new Model ();
		
		List<Element> e1 = new ArrayList<> ();
		List<Element> e2 = new ArrayList<> ();
		
		e1.add (element1);
		e1.add (element2);
		
		e2.add (element3);
		e2.add (element4);
		
		model1.setElements (e1);
		model2.setElements (e2);
		
		models.put ("model1", model1);
		models.put ("model2", model2);
		
		System.out.println ("Model 1: " + models.get ("model1") + "\n"); // Returns model1
		System.out.println ("Model 2: " + models.get ("model2") + "\n"); // Returns model2
//		System.out.println("Model 3: " + models.get("foo") + "\n"); // Returns null (map doesn't have an entry for that key value)
		
//		Model nullModel = models.get("foo"); // Returns null
//		System.out.println("Null Model element name " + nullModel.getElements().get(0).getName()); // throws NPE
		
		Model nullModel = getModel ("foo", models); // Returns NullObject
		System.out.println (
			"Null Model element name " + nullModel.getElements ().get (0).getName ()); // Will work just fine
	}
	
	public static Model getModel (String key, Map<String, Model> models) {
		
		return models.entrySet ().stream ()
			.filter (e -> key.equalsIgnoreCase (e.getKey ()))
			.map (Map.Entry::getValue).findFirst ().orElse (new NullModel ());
	}
}
