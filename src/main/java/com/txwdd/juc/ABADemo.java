package com.txwdd.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("======ABA����Ĳ���======");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get().toString());
        }, "t2").start();

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("======ABA����Ľ��======");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t��һ�ΰ汾�ţ� " + stamp);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            atomicStampedReference.compareAndSet(100,101,
                atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t�ڶ��ΰ汾�ţ� " + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,
                atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName() + "\t�����ΰ汾�ţ� " + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t��һ�ΰ汾�ţ� " + stamp);
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            boolean result=atomicStampedReference.compareAndSet(100,2019,
                stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t�޸ĳɹ����"+result+"  ��ǰ���°汾��"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t��ǰʵ��ֵ��"+atomicStampedReference.getReference());
        }, "t4").start();
    }
}
