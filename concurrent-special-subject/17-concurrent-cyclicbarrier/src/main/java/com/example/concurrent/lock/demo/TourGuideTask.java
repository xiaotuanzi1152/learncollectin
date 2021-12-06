package com.example.concurrent.lock.demo;

/**
 * @Author: 无双老师【云析学院:http://yunxiedu.net QQ:3190976240 email:zhouguanya20@163.com】
 * @Date: 2019-09-29 20:59
 * @Description: 导游线程，都到达目的地时，发放护照和签证
 */
public class TourGuideTask implements Runnable {

    @Override
    public void run() {
        try {
            //模拟发护照签证需要2秒
            Thread.sleep(2000);
            System.out.println(CyclicBarrierDemo.printDate() + " " + "****导游分发护照签证****");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
