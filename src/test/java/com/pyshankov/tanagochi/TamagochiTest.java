package com.pyshankov.tanagochi;

import com.pyshankov.tamagochi.Tamagochi;
import com.pyshankov.tamagochi.TamagochiBehaviour;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
/**
 * Created by pyshankov on 29.11.15.
 */
public class TamagochiTest {

    TamagochiBehaviour tomagochi;
    @Test
  public void test_poop(){
        tomagochi= new Tamagochi(1,"my tomagochi",50,50,50,50);
        tomagochi.poop();
        assertEquals(40,((Tamagochi)tomagochi).getFullness());
    }
    @Test
    public void test_play(){
        tomagochi= new Tamagochi(1,"my tomagochi",50,50,50,50);
        tomagochi.play();
        assertEquals(60,((Tamagochi)tomagochi).getTiredness());
        assertEquals(60,((Tamagochi)tomagochi).getHappiness());
    }
    @Test
    public void test_feed(){
        tomagochi= new Tamagochi(1,"my tomagochi",50,50,50,50);
        tomagochi.feed();
        assertEquals(40,((Tamagochi)tomagochi).getHungriness());
        assertEquals(60,((Tamagochi)tomagochi).getFullness());
    }
    @Test
    public void test_putToBed(){
        tomagochi= new Tamagochi(1,"my tomagochi",50,50,50,50);
        tomagochi.putToBed();
        assertEquals(40,((Tamagochi)tomagochi).getTiredness());
    }
    @Test
    public void test_isDead(){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        tomagochi= new Tamagochi(1,"my tomagochi",50,50,40,40);
        scheduler.scheduleWithFixedDelay(tomagochi, 1, 1, TimeUnit.SECONDS);
        while (tomagochi.isAlive()){}
        scheduler.shutdown();
        assertTrue(!tomagochi.isAlive());
    }


}
