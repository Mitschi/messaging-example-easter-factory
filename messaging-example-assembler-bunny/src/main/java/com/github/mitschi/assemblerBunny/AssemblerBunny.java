package com.github.mitschi.assemblerBunny;

import com.github.mitschi.entities.Egg;
import com.github.mitschi.entities.Nest;
import com.github.mitschi.utils.ActiveMQUtils;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class AssemblerBunny {
    private final String name;
    private final int timeForAnEgg;
    private int nestSize;

    public AssemblerBunny(String name, int timeForAnEgg, int nestSize) {
        this.name = name;
        this.timeForAnEgg = timeForAnEgg;
        this.nestSize = nestSize;
    }

    public void doJob() {
        try {
            System.out.println("AssemblerBunny "+name+" is starting with the job.");
            boolean interrupted=false;

            MessageConsumer consumer = ActiveMQUtils.createConsumer(ActiveMQUtils.CURRENT_TESTHOST, "coloredEggs");

            ActiveMQUtils assembledNestsQueue = new ActiveMQUtils();
            assembledNestsQueue.init("assembledNests",ActiveMQUtils.CURRENT_TESTHOST);

            while(!interrupted) {
                Nest nest = new Nest();
                while(nest.getEggs().size()<this.nestSize) {
                    Message message = consumer.receive();
                    if (message instanceof ObjectMessage) {
                        Serializable object = ((ObjectMessage) message).getObject();
                        if (object instanceof Egg) {
                            Egg egg = (Egg)object;
                            nest.getEggs().add(egg);
                            System.out.println(this.name + " added an egg to the nest.");
                            message.acknowledge();
                            Thread.sleep(timeForAnEgg);
                        }
                    }
                }
                assembledNestsQueue.send(nest);
                System.out.println(this.name + " finished a nest.");
                Thread.sleep(timeForAnEgg);
            }

        } catch (InterruptedException e) {
        } catch (Exception e) {
            System.out.println("Something happened.. try restart ;)");
            e.printStackTrace();
        }
    }
}
