package com.github.mitschi.painterBunny;


public class PainterBunnyMain
{
    public static void main( String[] args )
    {
        System.out.println("PainterBunnyMain");
        if(args.length!=3) {
            System.out.println("Need 3 params: name, timeForAnEgg, color");
        } else {
            String name = args[0];
            int timeForAnEgg = Integer.parseInt(args[1]);
            String color = args[2];
            PainterBunny emptierBunny = new PainterBunny(name,timeForAnEgg,color);
            emptierBunny.doJob();
        }
    }
}
