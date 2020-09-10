package org.zhx.notes;

/**
 * @ProjectName: util-java
 * @Package: org.zhx.notes
 * @ClassName: ShallowCloneExample
 * @Author: zhanghx
 * @Description: ${description}
 * @Date: 2020/9/10 18:00
 * @Version: 1.0
 */
public class ShallowCloneExample implements Cloneable {

    private int[] arr;

    public ShallowCloneExample() {
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
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 222);
        System.out.println(e2.get(2)); // 222
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.getArr());
        System.out.println(e2.getArr());

    }
}
