package com.github.mitschi.assemblerBunny;


import java.util.UUID;

public class AssemblerBunnyMain {
    public static void main(String[] args) {
        System.out.println("AssemblerBunnyMain");
        String name = (args.length>0 && args[0]!=null)?args[0]:"AssemblerBunny-"+ UUID.randomUUID();
        int timeForAnEgg = (args.length>1&&args[1]!=null)?Integer.parseInt(args[1]):(int)(1500+Math.random()*1000);
        int nestSize = (args.length>2&&args[2]!=null)?Integer.parseInt(args[2]):(int)(1+Math.random()*4);

        AssemblerBunny emptierBunny = new AssemblerBunny(name, timeForAnEgg, nestSize);
        emptierBunny.doJob();
    }
}
