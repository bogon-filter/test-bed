package org.personal.testbed.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@MyAnnotation(name="test", value="TestingValue")
public class Sample1 {

    public static int i=99;
    static Field f = (Long.class.getFields())[0];
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Logger log = Logger.getLogger("Sample Reflection");
        log.info("Starting sample1");


        // access methods
        log.info("Methods");
        Class c1 = Sample1.class;
        Method[] m = c1.getMethods();
        for(Method method: m){
            //log.info(method.toString());
        }
        printMembers(m);

        // access fields
        log.info("Fields");
        Field[] fields = c1.getDeclaredFields();
        for(Field f:fields) {
            //log.info(f.toString());
            //System.out.println(f.getType());
            f.getClass();
        }

        // access constructors
        Constructor[] ctors = c1.getDeclaredConstructors();
        for(Constructor ctor: ctors){
            //log.info(ctor.toString());
        }


        // some play on the Field
        System.out.println(f.getType());
        System.out.println(f.getName());
        System.out.println(f.getDeclaringClass());
        System.out.println(f.getClass());
        System.out.println(Modifier.toString(f.getModifiers()));

        // alternate way to access the class's field variable value
        int newi = ((Sample1.class.getFields())[0]).getInt((Sample1.class.getFields())[0]);
        System.out.println("Value of I = " + i + ", New I " + newi);

        // set value of field
        Field var1 = ((Sample1.class.getFields())[0]);
        var1.setInt(var1, 89);
        System.out.println(i);


        // play on getting class
        Class c2= int.class;
        c2 = Integer.TYPE;   // TYPE only for Boxed types
        c2 = Class.forName("java.lang.Integer");

        Integer tempInt = 98;
        c2 = tempInt.getClass(); // get class only on reference types
        Set<String> s = new HashSet<String>();
        c2 = s.getClass();

        // some methods return classes
        c2 = c2.getSuperclass(); // object, interface and primitive types return null
        c2.getEnclosingClass(); // top level classes return null
        c2 = Sample1.class;
        Class[] arrayClass = c2.getClasses();
        System.out.println("Declared classed for class: " + c2.getName());
        for(Class c:arrayClass){
            System.out.println(c.getName());
        }
        c2.getClasses(); // return all public classes, interfaces
        //java.lang.reflect.Field.getDeclaringClass();
        //java.lang.reflect.Method.getDeclaringClass();
        //java.lang.reflect.Constructor.getDeclaringClass();

        System.out.println("printing out type params");
        c2 = Class.forName("java.util.concurrent.ConcurrentNavigableMap");
        TypeVariable[] typeParams = c2.getTypeParameters();
        for(TypeVariable typeParam: typeParams){
            System.out.println(typeParam.getName());
            Type[] bounds = typeParam.getBounds();
            System.out.println("printing bounds for the type param");
            for(Type t:bounds) {
                System.out.println(t.toString());
            }
        }

        System.out.println("printing out interfaces");
        Type[] interfaces = c2.getGenericInterfaces();
        for(Type type:interfaces){
            System.out.println(type.toString());
        }

        c2= Sample1.class;
        System.out.println("printing out annotations");
        Annotation[] annotations = c2.getAnnotations();
        for(Annotation anon:annotations ){
            System.out.println(anon.toString());
        }
        System.out.println(c2.getPackage());
        // getting hierarchy
        System.out.println(c2.getSuperclass());


        //Recap on operations on class
        c2.getMethods();
        c2.getDeclaredFields();
        c2.getDeclaredConstructors();
        c2.getAnnotations();
        c2.getGenericInterfaces();
        c2.getSuperclass();
        c2.getClasses();
        c2.getModifiers();
        c2.getPackage();

        c2.getMethods(); // all public methods + inherited methods
        c2.getDeclaredMethods(); // all methods (including private) but not inherited methods

        // call this standalone recursively
        // haha, will terminate with StackOverflowError
        System.out.println("creating new objects: " + c2.getCanonicalName());
        Sample1 app = (Sample1)c2.newInstance();
        //app.main(new String[]{""});

        //c2 = Sample1.SWITCH.class;
        //c2.newInstance(); // instantiation exception if switch is not public
        // another way of instantiating new class
        app = (Sample1) c2.getConstructors()[0].newInstance();
        app.main(new String[]{""});
        System.out.println(app.toString());


    }

    // Member - field, method or constructor
    private static void printMembers(@Nullable Member[] m) {
        for(Member mem:m){
            System.out.println(mem.getName());
        }

    }

    public static enum SWITCH{
        ON,
        OFF;
         SWITCH() {
        }
    }

}
