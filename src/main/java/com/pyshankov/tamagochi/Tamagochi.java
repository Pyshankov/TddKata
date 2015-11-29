package com.pyshankov.tamagochi;


/**
 * Created by pyshankov on 29.11.15.
 */
final public class Tamagochi implements TamagochiBehaviour {

    private final int id;

    private final String name;

    private volatile State state;

    private volatile int hungriness;

    private volatile int fullness;

    private volatile int tiredness;

    private volatile int happiness;

    public Tamagochi(int id, String name, int tiredness, int happiness, int hungriness, int fullness) {
        this.id = id;
        this.name = name;
        this.state = State.LIVE;
        this.happiness=happiness;
        this.tiredness=tiredness;
        this.hungriness=hungriness;
        this.fullness=fullness;
    }

    public int getHungriness() { return hungriness; }

    public int getFullness() { return fullness; }

    public int getTiredness() { return tiredness; }

    public int getHappiness() { return happiness; }

    public int increaseHappiness() { return this.happiness+=10; }

    public int decreaseHappiness() { return this.happiness-=10; }

    public int increaseTiredness() { return this.tiredness+=10; }

    public int decreaseTiredness() { return this.tiredness-=10; }

    public int increaseHungriness() { return hungriness+=10; }

    public int decreaseHungriness() { return hungriness-=10; }

    public int increaseFullness() { return fullness+=10; }

    public int decreaseFullness() { return fullness-=10; }

    public boolean isAlive() { return this.state==State.LIVE; }

    public void poop() { decreaseFullness(); }

    public void putToBed() { decreaseTiredness(); }

    public void play() {
        increaseTiredness();
        increaseHappiness();
    }

    public void feed() {
        decreaseHungriness();
        increaseFullness();
    }

    public void run() {
            if (this.tiredness >= TamagochiBehaviour.MAX_SCALE
                    || this.hungriness >= TamagochiBehaviour.MAX_SCALE
                    || this.happiness < TamagochiBehaviour.MIN_SCALE) this.kill();
            if (this.isAlive()) {
                        increaseTiredness();
                        increaseHungriness();
                        decreaseHappiness();
                System.out.println("tamagochi state: Tiredness-"+getTiredness()
                        +" Hungriness-"+getHungriness()
                        +" Happiness-"+getHappiness());
            }
            else System.out.println("tamagochi is dead");
    }

    private void kill(){ this.state=State.DEAD; }

    private enum State{ LIVE,DEAD }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tamagochi tamagochi = (Tamagochi) o;
        return id == tamagochi.id;
    }
    @Override
    public int hashCode() {
        return id;
    }
}
