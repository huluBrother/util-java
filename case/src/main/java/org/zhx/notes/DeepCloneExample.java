package org.zhx.notes;

public class DeepCloneExample implements Cloneable {

    private int[] arr;

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    public int[] getArr() {
        return arr;
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        System.out.println(this == result);
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        System.out.println(this == result);
        return result;
    }


    public static void main(String[] args) {
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 2
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.getArr());
        System.out.println(e2.getArr());

    }
}
