package com.atguigu.springcloud.juc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynDemo{

    public static void main(String[] arg){

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        objectObjectMap.put(1,1);


        synchronized(new Object()){
            System.out.printf("123");
        }
        Runnable t1=new MyThread();
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();
    }

}
class MyThread implements Runnable {



    @Override
    public void run() {
        synchronized (this) {
            for(int i=0;i<10;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }

}