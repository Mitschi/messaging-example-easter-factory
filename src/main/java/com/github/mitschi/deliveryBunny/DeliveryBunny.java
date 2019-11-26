package com.github.mitschi.deliveryBunny;

import com.github.mitschi.entities.Egg;
import com.github.mitschi.entities.Nest;
import com.github.mitschi.utils.ActiveMQUtils;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class DeliveryBunny {
    private final String name;
    private final int timeForANest;

    public DeliveryBunny(String name, int timeForANest) {
        this.name = name;
        this.timeForANest = timeForANest;
    }

    public void doJob() {
        try {
            System.out.println("DeliveryBunny "+name+" is starting with the job.");
            boolean interrupted=false;

            MessageConsumer consumer = ActiveMQUtils.createConsumer("localhost", "assembledNests");

            while(!interrupted) {
                Message message = consumer.receive();
                if (message instanceof ObjectMessage) {
                    Serializable object = ((ObjectMessage) message).getObject();
                    if (object instanceof Nest) {
                        Nest nest = (Nest)object;
                        System.out.println("Delivered Nest to Alex:");
                        System.out.print("  ");
                        System.out.println(nest);
                        message.acknowledge();
                        Thread.sleep(timeForANest);
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
