/**
 * mirror was made by Jadon Fowler.
 * This file is licensed under the MIT License.
 */
package mirror;

/**
 * @author Jadon "Phase" Fowler on Feb 16, 2015
 */
public class ReflectedClass<T> implements Printable<ReflectedClass<T>> {
	
	Class<T> c;
	T object;
	
	@SuppressWarnings("unchecked")
	protected ReflectedClass(T o){
		this.c = (Class<T>) o.getClass();
		this.object = o;
	}
	
	/**
	 * @return An easy way to get the name.
	 */
	public String toString(){
		return getName();
	}
	
	/**
	 * @return The simple name of the class.
	 */
	public String getName(){
		return c.getSimpleName();
	}
	
	/**
	 * Gets a Method from the class w/out params
	 * @param name Name of the method
	 * @return A ReflectedMethod object holding the Method
	 */
	public ReflectedMethod getMethod(String name){
		return new ReflectedMethod(this, c, name);
	}
	
	/**
	 * Gets the Method from the class
	 * @param name Name of the Method
	 * @param params Parameters for the Method
	 * @return A ReflectedMethod object holding the Method
	 */
	public ReflectedMethod getMethod(String name, Class<?>...params){
		return new ReflectedMethod(this, c, name, params); 
	}
	
	/**
	 * @return The original object passed in.
	 */
	protected T getObject(){
		return object;
	}
	
	/**
	 * @return The original object's class
	 */
	protected Class<T> getObjectClass(){
		return c;
	}
	
	/**
	 * @see mirror.Printable#print()
	 */
	@Override
	public ReflectedClass<T> print() {
		System.out.println(this.toString());
		return this;
	}
	
	public <K> K getField(String name){
		return new ReflectedField(this, c, name).<K>get();
	}
	
	public ReflectedClass<T> setField(String name, Object value){
		new ReflectedField(this, c, name).set(value);
		return this;
	}
}
