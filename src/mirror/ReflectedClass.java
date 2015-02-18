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
		return c.getName();
	}
	
	public String getName(){
		final String s = c.getSimpleName();
		for (String a : s.split(".")) {
			System.out.println(a);
		}
		return s.contains(".") ? s.split(".")[s.split(".").length-1] : s;
		//return toString();
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
