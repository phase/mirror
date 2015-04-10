package mirror;

import java.lang.reflect.Field;

public class ReflectedField implements Printable<ReflectedField> {

	private Field f;
	private ReflectedClass<?> rc;
	
	protected ReflectedField(ReflectedClass<?> rc, Class<?> c, String name){
		try {
			f = c.getDeclaredField(name);
			f.setAccessible(true);
			this.rc = rc;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	protected <T> T get(){
		try {
			return (T) f.get(rc.getObject());
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void set(Object value2) {
		try {
			f.set(rc.getObject(), value2);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString(){
		return f.get(rc.getObject()).toString();
	}

	@Override
	public ReflectedField print() {
		System.out.println(this.toString());
		return this;
	}
	
}
