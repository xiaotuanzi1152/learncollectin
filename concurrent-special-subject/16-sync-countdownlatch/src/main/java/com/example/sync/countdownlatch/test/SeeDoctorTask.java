package com.example.sync.countdownlatch.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.example.sync.countdownlatch.test.CountDownLatchTest.prinDate;

/**
 * @program: thread-demo
 * @description: 看大夫
 * @author: XTZ
 * @create: 2021-12-04 23:52
 **/
public class SeeDoctorTask implements Runnable {
    CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(CountDownLatchTest.prinDate() + "女朋友去看大夫了");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(CountDownLatchTest.prinDate() + "女朋友看完大夫粗来了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
