package com.github.mitschi.emptierBunny;


import java.util.UUID;

public class EmptierBunnyMain {
    public static void main(String[] args) {
        System.out.println("EmptierBunnyMain");
        String name = (args.length > 0 && args[0] != null) ? args[0] : "EmptierBunny-" + UUID.randomUUID();
        int timeForAnEgg = (args.length > 1 && args[1] != null) ? Integer.parseInt(args[1]) : (int) (1500 + Math.random() * 1000);

        EmptierBunny emptierBunny = new EmptierBunny(name, timeForAnEgg);
        emptierBunny.doJob();
    }
}
