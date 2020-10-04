package com.github.mitschi.hen;

import com.github.mitschi.entities.Egg;
import com.github.mitschi.utils.ActiveMQUtils;

import java.util.UUID;

public class Hen {
    private final String name;
    private final int timeForAnEgg;

    public Hen(String name, int timeForAnEgg) {

        this.name = name;
        this.timeForAnEgg = timeForAnEgg;
    }

    public void doJob() {
        try {
            System.out.println("Hen "+name+" is starting with the job.");
            boolean interrupted=false;

            ActiveMQUtils laidEggsQueue = new ActiveMQUtils();
            laidEggsQueue.init("laidEggs",ActiveMQUtils.CURRENT_TESTHOST);

            while(!interrupted) {
                Egg egg = new Egg();
                egg.setId(UUID.randomUUID().toString());
                laidEggsQueue.send(egg);
                System.out.println(this.name+" laid an egg.");
                Thread.sleep(timeForAnEgg);
            }

        } catch (InterruptedException e) {

        } catch (Exception e) {
            System.out.println("Something happened.. try restart ;)");
            e.printStackTrace();
        }
    }
}
