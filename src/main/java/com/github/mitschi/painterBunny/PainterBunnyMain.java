package com.github.mitschi.painterBunny;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class PainterBunnyMain
{
    public static void main( String[] args )
    {
        System.out.println("PainterBunnyMain");
        String name = (args.length>0 && args[0]!=null)?args[0]:"PainterBunny-"+ UUID.randomUUID();
        int timeForAnEgg = (args.length>1&&args[1]!=null)?Integer.parseInt(args[1]):(int)(1500+Math.random()*1000);

        List<String> colors = Arrays.asList(new String[]{"red","green","blue","yellow","purple","black","white","orange"});
        String color = colors.get((int) (Math.random()*colors.size()));

        PainterBunny emptierBunny = new PainterBunny(name,timeForAnEgg,color);
            emptierBunny.doJob();
    }
}
