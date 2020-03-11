package org.generic.erased;

public abstract class GenericWithCreate<T>{

    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();

}
