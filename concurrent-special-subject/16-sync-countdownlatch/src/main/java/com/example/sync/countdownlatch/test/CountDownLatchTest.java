package com.example.sync.countdownlatch.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @program: thread-demo
 * @description: 陪女朋友去看病，轮到女朋友看大夫的时候，我就去排队准备交钱
 * @author: XTZ
 * @create: 2021-12-04 23:38
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 20,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());

        try {
            threadPoolExecutor.execute(new SeeDoctorTask(countDownLatch));
            TimeUnit.SECONDS.sleep(1);
            threadPoolExecutor.execute(new QueueTask(countDownLatch));
            countDownLatch.await();
            System.out.println(prinDate() + " 搞定，和女朋友回家！！！总共耗时:"+(System.currentTimeMillis()-currentTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    public static String prinDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(new Date()) + "";
    }
}
