package com.github.mitschi.deliveryBunny;


public class DeliveryBunnyMain
{
    public static void main( String[] args )
    {
        System.out.println("DeliveryBunnyMain");
        if(args.length!=2) {
            System.out.println("Need 2 params: name, timeForAnEgg");
        } else {
            String name = args[0];
            int timeForAnEgg = Integer.parseInt(args[1]);
            DeliveryBunny emptierBunny = new DeliveryBunny(name,timeForAnEgg);
            emptierBunny.doJob();
        }
    }
}
