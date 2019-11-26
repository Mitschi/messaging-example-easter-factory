package com.github.mitschi.emptierBunny;


public class EmptierBunnyMain
{
    public static void main( String[] args )
    {
        System.out.println("EmptierBunnyMain");
        if(args.length!=2) {
            System.out.println("Need 2 params: name, timeForAnEgg");
        } else {
            String name = args[0];
            int timeForAnEgg = Integer.parseInt(args[1]);
            EmptierBunny emptierBunny = new EmptierBunny(name,timeForAnEgg);
            emptierBunny.doJob();
        }
    }
}
