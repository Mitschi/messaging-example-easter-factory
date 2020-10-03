package com.github.mitschi.hen;


import java.util.UUID;

public class HenMain {
    public static void main(String[] args) {
        System.out.println("HenMain");
        String name = (args.length > 0 && args[0] != null) ? args[0] : "Hen-" + UUID.randomUUID();
        int timeForAnEgg = (args.length > 1 && args[1] != null) ? Integer.parseInt(args[1]) : (int) (1500 + Math.random() * 1000);

        Hen hen = new Hen(name, timeForAnEgg);
        hen.doJob();
    }
}
