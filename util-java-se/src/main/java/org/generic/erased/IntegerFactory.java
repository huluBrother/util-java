package org.generic.erased;

public class IntegerFactory implements FactoryI<Integer>{

    @Override
    public Integer create(int type) {
        return new Integer(type);
    }
}
