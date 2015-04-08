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
	
	public String toString(){
		return getName();
	}
	
	public String getName(){
		return c.getSimpleName();
	}
	
	public ReflectedMethod getMethod(String name){
		return new ReflectedMethod(this, c, name);
	}
	
	public ReflectedMethod getMethod(String name, Class<?>...params){
		return new ReflectedMethod(this, c, name, params); 
	}
	
	protected T getObject(){
		return object;
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
