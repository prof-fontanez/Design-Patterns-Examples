/*
 * Programming Corner
 * Professor Fontanez
 * www.professorfontanez.com
 * May 2, 2020: 12:33:12 PM
 */
package pattern.builder;

/**
 * Builder pattern example as proposed by Joshua Bloch
 * in his book: <b><i>Effective Java</i></b>
 * 
 * @author Prof. Fontanez
 */
public class ImmutableWidget {
	
	private final String required;
	private final String optional;
	
	private ImmutableWidget (Builder builder) {
		this.required = builder.required;
		this.optional = builder.optional;
	}
	
	@Override
	public String toString () {
		return "Required: " + required + "; Optional: " + optional;
	}
	
	public String getRequired () {
		return required;
	}
	
	public String getOptional () {
		return optional;
	}
	
	public static class Builder {
		
		private final String required;
		private String optional;
		
		public Builder (String required) {
			this.required = required;
		}
		
		public Builder setOptional (String optional) {
			this.optional = optional;
			return this;
		}
		
		public ImmutableWidget build () {
			return new ImmutableWidget (this);
		}
	}
	
	public static void main (String... strings) {
		Builder builder = new ImmutableWidget.Builder ("required");
		ImmutableWidget widget = builder.setOptional ("optional").build ();
		System.out.println (widget);
		
		widget = new ImmutableWidget.Builder("required").build();
		System.out.println (widget);
	}
}
