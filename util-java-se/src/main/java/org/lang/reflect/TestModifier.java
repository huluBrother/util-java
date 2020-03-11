package org.lang.reflect;

import java.lang.reflect.Modifier;

public class TestModifier {

    public static void main(String[] args) {
        System.out.println("接口描述符号......:\t" + Modifier.interfaceModifiers() + " :\t " + Modifier.toString(Modifier.interfaceModifiers()));
        System.out.println("类描述符号........:\t " + Modifier.classModifiers() + " :\t" + Modifier.toString(Modifier.classModifiers()));
        System.out.println("构造方法描述符号..:\t" + Modifier.constructorModifiers() + " :\t" + Modifier.toString(Modifier.constructorModifiers()));
        System.out.println("类成员描述符号....:\t " + Modifier.fieldModifiers() + " :\t" + Modifier.toString(Modifier.fieldModifiers()));
        System.out.println("类方法描述符号....:\t " + Modifier.methodModifiers() + " :\t" + Modifier.toString(Modifier.methodModifiers()));
        System.out.println("方法参数描述符号..:\t" + Modifier.parameterModifiers() + " :\t" + Modifier.toString(Modifier.parameterModifiers()));
        System.out.println("方法参数描述符号..:\t" + Modifier.parameterModifiers() + " :\t" + Modifier.toString(Modifier.INTERFACE));

        System.out.println("public " + "\t" + Integer.toOctalString(Modifier.PUBLIC) + " : " + Modifier.PUBLIC);
        System.out.println("private" + "\t" + Integer.toOctalString(Modifier.PRIVATE) + " : " + Modifier.PRIVATE);
        System.out.println("protected" + "\t" + Integer.toOctalString(Modifier.PROTECTED) + " : " + Modifier.PROTECTED);
        System.out.println("static " + "\t" + Integer.toOctalString(Modifier.STATIC) + " : " + Modifier.STATIC);
        System.out.println("final " + "\t" + Integer.toOctalString(Modifier.FINAL) + " : " + Modifier.FINAL);
        System.out.println("syncronized" + "\t" + Integer.toOctalString(Modifier.SYNCHRONIZED) + " : " + Modifier.SYNCHRONIZED);
        System.out.println("volatile" + "\t" + Integer.toOctalString(Modifier.VOLATILE) + " : " + Modifier.VOLATILE);
        System.out.println("transient" + "\t" + Integer.toOctalString(Modifier.TRANSIENT) + " : " + Modifier.TRANSIENT);
        System.out.println("native " + "\t" + Integer.toOctalString(Modifier.NATIVE) + " : " + Modifier.NATIVE);
        System.out.println("interface " + "\t" + Integer.toOctalString(Modifier.INTERFACE) + " : " + Modifier.INTERFACE);
        System.out.println("abstract" + "\t" + Integer.toOctalString(Modifier.ABSTRACT) + " : " + Modifier.ABSTRACT);
        System.out.println("strict" + "\t" + Integer.toOctalString(Modifier.STRICT) + " : " + Modifier.STRICT);
        System.out.println(Modifier.toString(0xFFFFFFFF));

    }
}
