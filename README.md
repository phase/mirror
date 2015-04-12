# mirror
A Java representation of jQuery, using Reflection to interact with things.

jQuery is used to interact with the DOM in JavaScript. Java doesn't have a DOM, so the next best thing was Reflection, which interacts with everything in Java.

I recently found out `$` could be used as an identifier in Java, and I immediately thought of jQuery. jQuery messes with the DOM, Relfection messes with Classes. Put two and two together and we've got mirror!

##Use
The first thing you want to do is statically import Mirror.java:
```java
import static mirror.Mirror;
```
`$()` is the main method for mirror. It will get the class of what you input.
```java
int i = 7;
$(i); //returns a ReflectedClass of type Integer

$(i).print(); //prints 'java.lang.Integer'
```
All of the classes implement a Printable interface, so you can put `print()` anywhere in your chain to debug.

To invoke a method:
```java
String s = "Hello World";
String[] a = $(s).getMethod("split", String.class).invoke(" "); //returns s.split(" ")
```

You can also set and get fields:
```java
String s = "Hello World";
$(s).setField("hash", -5);
int i = $(s).<Integer>getField("hash");
```
