package org.lang.reflect; // 01 java.lang.Package


@SuppressWarnings("all") // 02 java.lang.Annotation
public class TestClass {

    public TestClass(Object obj){ // 03 java.lang.reflect.Constructor<T>
        //
    }

    String name;  //04 java.lang.reflect.Field
    TestClass next;
    int age;

    public void setNext(TestClass next) { //05 java.lang.reflect.Method
        this.next = next;
    }
}
