package cn.enjoyedu.web;

import java.util.Random;

public class TestThreadLocal {
    public static void main(String[] args) {

        TestThread targetThread = new TestThread();

        Thread t1 = new Thread(targetThread);
        Thread t2 = new Thread(targetThread);
        Thread t3 = new Thread(targetThread);

        t1.start();
        t2.start();
        t3.start();

    }
}

class TestThread implements Runnable{
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    @Override
    public void run() {
        threadLocal.set(new Random().nextInt(10));
        System.out.println("生成随机数:"+threadLocal.get());
        System.out.println(threadLocal);
    }


}