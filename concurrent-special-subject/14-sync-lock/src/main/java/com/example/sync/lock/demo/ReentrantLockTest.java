package com.example.sync.lock.demo;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-09-09 20:05
 * @Description: ReentrantLock公平锁/非公平锁
 */
public class ReentrantLockTest {
    /**
     * 公平锁模式
     */
//    private static Lock lock = new ReentrantLock(true);

    /**
     * 非公平锁模式
     */
    private static Lock lock = new ReentrantLock(false);


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();
        }
        /*ThreadPoolExecutor executor = null;
        try {
            int numb = 5 ;
            executor = new ThreadPoolExecutor(2,
                    4, 10,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),
                    new ThreadPoolExecutor.AbortPolicy());
            for (int i = 0; i < numb ; i++) {
                executor.execute(new ThreadDemo(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert executor != null;
            executor.shutdown();
        }*/

    }

    static class ThreadDemo implements Runnable {
        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println("获得锁的线程：" + id);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
                System.out.println("shi锁的线程：" + id);
                /*try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
}



