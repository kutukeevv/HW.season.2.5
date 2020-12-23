package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassangerThread extends Thread {
    private Semaphore semaphore;
    private CountDownLatch cdl;

    public PassangerThread(String name, Semaphore semaphore, CountDownLatch cdl) {
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;
    }

    public void run(){
        try {

            System.out.println(this.getName() + " Подошел на кассу");
            semaphore.acquire();
            sleep(1000);
            System.out.println(this.getName() + " Приобрел билет");
            semaphore.release();
            System.out.println(this.getName() + " Сел на свое места");
            cdl.countDown();
            cdl.await();


        }catch (Exception error){

        }

    }
}
