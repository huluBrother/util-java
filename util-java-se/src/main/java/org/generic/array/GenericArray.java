package org.generic.array;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size){
        array = (T[])new Object[size];//本质上还是Object 数组
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        Object[] repObj = gai.rep();
        System.out.println(repObj.length + " : " + repObj.getClass().getName());
        gai.put(0,new Integer(10));
        Integer element = gai.get(0);
        System.out.println(element + " : " + element.getClass().getName());
        Integer[] rep = gai.rep();
        System.out.println(rep.length + " : " + rep.getClass().getName());
    }
}
