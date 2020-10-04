package com.github.mitschi.painterBunny;

import com.github.mitschi.entities.Egg;
import com.github.mitschi.utils.ActiveMQUtils;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class PainterBunny {
    private final String name;
    private final int timeForAnEgg;
    private String color;

    public PainterBunny(String name, int timeForAnEgg, String color) {

        this.name = name;
        this.timeForAnEgg = timeForAnEgg;
        this.color = color;
    }

    public void doJob() {
        try {
            System.out.println("PainterBunny "+name+" is starting with the job.");
            boolean interrupted=false;

            MessageConsumer consumer = ActiveMQUtils.createConsumer(ActiveMQUtils.CURRENT_TESTHOST, "emptiedEggs");

            ActiveMQUtils coloredEggsQueue = new ActiveMQUtils();
            coloredEggsQueue.init("coloredEggs",ActiveMQUtils.CURRENT_TESTHOST);

            while(!interrupted) {
                Message message = consumer.receive();
                if (message instanceof ObjectMessage) {
                    Serializable object = ((ObjectMessage) message).getObject();
                    if (object instanceof Egg) {
                        Egg egg = (Egg)object;
                        egg.setColor(this.color);
                        System.out.println(this.name+" colored an egg with the color "+this.color+".");
                        coloredEggsQueue.send(egg);
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
