package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4, true);

        CountDownLatch cdl = new CountDownLatch(100);

        for (int i = 1; i < 101; i++) {
            new PassangerThread("Пассажир"+i,semaphore,cdl).start();
        }


            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("Все пассажиры сели на места, Автобус полностью заполнен и выезжает в Ош");


    }

}
