package com.txwdd.juc.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws Exception{
        Product product = new Product();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    try {
                        product.procuce();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"producer-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    try {
                        product.consume();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"consumer-1").start();
    }


}

class Product {

    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void procuce()  throws Exception{
        try {
            lock.lock();
            while (number != 0){
                condition.await();
            }
            number++;
            System.out.println("producer:"+number);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume()  throws Exception{
        try {
            lock.lock();
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println("consumer:"+number);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }



}
