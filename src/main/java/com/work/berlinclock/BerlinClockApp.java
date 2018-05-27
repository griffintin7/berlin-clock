package com.work.berlinclock;

public class BerlinClockApp {

    public static void main(String[] args) {
        BerlinClock berlinClock = new BerlinClock();
        String berlinTime = berlinClock.printBerlinClock(args[0]);
        if (berlinTime.contains("ERROR")) {
            System.err.print(berlinTime);
        } else {
            System.out.println(berlinTime);
        }
    }
}
