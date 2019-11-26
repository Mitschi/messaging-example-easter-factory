package com.github.mitschi.hen;


public class HenMain
{
    public static void main( String[] args )
    {
        System.out.println("HenMain");
        if(args.length!=2) {
            System.out.println("Need 2 params: name, timeForAnEgg");
        } else {
            String name = args[0];
            int timeForAnEgg = Integer.parseInt(args[1]);
            Hen hen = new Hen(name,timeForAnEgg);
            hen.doJob();
        }
    }
}
