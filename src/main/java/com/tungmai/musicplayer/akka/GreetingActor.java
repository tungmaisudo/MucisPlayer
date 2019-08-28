package com.tungmai.musicplayer.akka;

import akka.actor.UntypedActor;
import com.tungmai.musicplayer.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetingActor extends UntypedActor {

    @Autowired
    private GreetingService greetingService;

    // constructor

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Greet) {
            String name = ((Greet) message).getName();
            getSender().tell(greetingService.greet(name), getSelf());
        } else {
            unhandled(message);
        }
    }

    public static class Greet {

        private String name;

        public Greet(String name){
            this.name = name;
        }


        public String getName() {
            return name;
        }
    }
}
