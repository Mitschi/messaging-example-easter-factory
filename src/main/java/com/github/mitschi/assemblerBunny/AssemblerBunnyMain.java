package com.github.mitschi.assemblerBunny;


public class AssemblerBunnyMain
{
    public static void main( String[] args )
    {
        System.out.println("AssemblerBunnyMain");
        if(args.length!=3) {
            System.out.println("Need 3 params: name, timeForAnEgg, nestSize");
        } else {
            String name = args[0];
            int timeForAnEgg = Integer.parseInt(args[1]);
            int nestSize = Integer.parseInt(args[2]);
            AssemblerBunny emptierBunny = new AssemblerBunny(name,timeForAnEgg,nestSize);
            emptierBunny.doJob();
        }
    }
}
