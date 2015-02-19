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
	
	@SuppressWarnings("unchecked")
	protected ReflectedClass(T o){
		this.c = (Class<T>) o.getClass();
	}
	
	public String toString(){
		return getName();
	}
	
	public String getName(){
		return c.getSimpleName();
	}
	
	
	public ReflectedMethod getMethod(String name){
		return new ReflectedMethod(c, name);
	}
	
	public ReflectedMethod getMethod(String name, Class<?>...params){
		return new ReflectedMethod(c, name, params); 
	}
	
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
}
