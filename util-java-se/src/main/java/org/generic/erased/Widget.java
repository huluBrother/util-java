package org.generic.erased;

/**
 * 使用对象的内部类
 */
public class Widget {


    public static class Factory implements FactoryI<Widget>{

        @Override
        public Widget create(int type) {
            return new Widget();
        }
    }

    public static void main(String[] args) {
        new Foo2<Widget>(new Widget.Factory());
    }

}
