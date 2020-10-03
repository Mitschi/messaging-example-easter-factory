package com.github.mitschi.deliveryBunny;


import java.util.UUID;

public class DeliveryBunnyMain {
    public static void main(String[] args) {
        System.out.println("DeliveryBunnyMain");
        String name = (args.length>0 && args[0]!=null)?args[0]:"DeliveryBunny-"+ UUID.randomUUID();
        int timeForAnEgg = (args.length>1&&args[1]!=null)?Integer.parseInt(args[1]):(int)(1500+Math.random()*1000);

        DeliveryBunny emptierBunny = new DeliveryBunny(name, timeForAnEgg);
        emptierBunny.doJob();
    }
}
