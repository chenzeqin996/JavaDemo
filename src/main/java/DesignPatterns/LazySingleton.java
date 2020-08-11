package DesignPatterns;

import java.io.Serializable;

/**
 * @author chenzeqin
 * date 2020/8/10
 */
public class LazySingleton implements Serializable {
    private volatile static LazySingleton lazySingleton;
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        if(lazySingleton==null){
            synchronized (LazySingleton.class){
                if(lazySingleton==null){
                    lazySingleton = new LazySingleton();
                    // 在字节码层面，new命令会执行有以下几个步骤
                    // 1、分配空间
                    // 2、初始化
                    // 3、引用赋值
                    // 在多核CPU，会有指令重排序的情况，即2，3步骤执行顺序有可能相反，执行顺序有1，3，2。
                    // 所以在多线程情况下，线程2拿到的有可能是在线程1，3执行完毕，而2未执行（未进行初始化）的数据。
                    // 所以加上volatile可以防止指令的重排序
                }
            }
        }
        return lazySingleton;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            System.out.println(instance);
        }).start();
        Thread.sleep(1000l);
        LazySingleton s = new LazySingleton();
        System.out.println(s);
    }
}
