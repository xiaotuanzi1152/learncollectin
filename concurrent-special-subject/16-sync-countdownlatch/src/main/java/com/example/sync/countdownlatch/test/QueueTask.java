package com.example.sync.countdownlatch.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: thread-demo
 * @description: 排队
 * @author: XTZ
 * @create: 2021-12-04 23:53
 **/
public class QueueTask implements Runnable {
    CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(CountDownLatchTest.prinDate() + "女朋友去看大夫了，我去排队交费");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(CountDownLatchTest.prinDate() + "排队结束，开始交费");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
