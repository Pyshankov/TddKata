package com.pyshankov.tamagochi;

/**
 * Created by pyshankov on 29.11.15.
 */
public interface TamagochiBehaviour extends Runnable {

     byte MAX_SCALE = 100;
     byte MIN_SCALE = 1;

    int  increaseHappiness();

    int decreaseHappiness();

    int increaseTiredness();

    int decreaseTiredness();

    int increaseHungriness();

    int decreaseHungriness();

    int increaseFullness();

    int decreaseFullness();

    boolean isAlive();

    void poop();

    void play();

    void feed();

    void putToBed();


}
