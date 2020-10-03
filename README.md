# messaging-example-easter-factory
This project shows an example for message oriented systems. 
## Setup
This guide provides the basic commands to get the project running.
### Get the Sources
* Clone this project (`git clone https://github.com/Mitschi/messaging-example-easter-factory.git`)

### Download and start Apache ActiveMQ
* Download Apache ActiveMQ (e.g. [here](https://activemq.apache.org/components/classic/download/)).
* In a terminal, go to the binary folder of ActiveMQ (`cd [yourActiveMQFolder]/bin`)
* Start Apache MQ with `activemq start`
* You can stop ActiveMQ any time by calling `activemq stop`

### Build the project
* Navigate to the root folder of the project
* Run `mvn clean package`

### Run the clients
To run the clients, start the produced jar file with the respective Main classes

* Hen: `java -cp messagingexample-1.0-SNAPSHOT.jar com.github.mitschi.hen.HenMain H1 2000`
* EmptierBunny: `java -cp messagingexample-1.0-SNAPSHOT.jar com.github.mitschi.hen.EmptierBunny EB1 2000`
* PainterBunny: `java -cp messagingexample-1.0-SNAPSHOT.jar com.github.mitschi.hen.PainterBunnyMain PB1 2000 green`
* AssemblerBunny: `java -cp messagingexample-1.0-SNAPSHOT.jar com.github.mitschi.hen.AssemblerBunnyMain AB1 2000 3`
* DeliveryBunny: `java -cp messagingexample-1.0-SNAPSHOT.jar com.github.mitschi.hen.DeliveryBunnyMain DB1 2000`

