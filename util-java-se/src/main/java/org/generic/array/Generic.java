package org.generic.array;

public class Generic<T> {

    public static void main(String[] args) {
        /**
         * Error:(6, 48) java: 需要数组, 但找到org.generic.array.Generic<java.lang.Object>
         */
        //Generic<Integer> ga[] = new Generic<>()[10];
    }
}
