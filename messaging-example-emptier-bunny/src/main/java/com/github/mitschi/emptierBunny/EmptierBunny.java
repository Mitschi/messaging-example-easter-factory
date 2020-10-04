package com.github.mitschi.emptierBunny;

import com.github.mitschi.entities.Egg;
import com.github.mitschi.utils.ActiveMQUtils;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class EmptierBunny {
    private final String name;
    private final int timeForAnEgg;

    public EmptierBunny(String name, int timeForAnEgg) {

        this.name = name;
        this.timeForAnEgg = timeForAnEgg;
    }

    public void doJob() {
        try {
            System.out.println("EmptierBunny "+name+" is starting with the job.");
            boolean interrupted=false;

            MessageConsumer consumer = ActiveMQUtils.createConsumer(ActiveMQUtils.CURRENT_TESTHOST, "laidEggs");

            ActiveMQUtils emptiedEggsQueue = new ActiveMQUtils();
            emptiedEggsQueue.init("emptiedEggs",ActiveMQUtils.CURRENT_TESTHOST);

            while(!interrupted) {
                Message message = consumer.receive();
                if (message instanceof ObjectMessage) {
                    Serializable object = ((ObjectMessage) message).getObject();
                    if (object instanceof Egg) {
                        Egg egg = (Egg)object;
                        egg.setHasInnerPart(false);
                        System.out.println(this.name+" emptied an egg.");
                        emptiedEggsQueue.send(egg);
                        message.acknowledge();
                        Thread.sleep(timeForAnEgg);
                    }
                }
            }

        } catch (InterruptedException e) {
        } catch (Exception e) {
            System.out.println("Something happened.. try restart ;)");
            e.printStackTrace();
        }
    }
}
