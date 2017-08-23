package main.com.intexsoft.test_web_mvc.actor;

import akka.actor.UntypedAbstractActor;
import main.com.intexsoft.test_web_mvc.entity.CallRecord;

public class BillingActorSystem extends UntypedAbstractActor{

    @Override
    public void onReceive(Object object) throws Throwable {
        if (object instanceof CallRecord) {
            CallRecord callRecord = (CallRecord) object;
            System.out.println(callRecord);
            System.out.println(getSender());
            return;
        }
        unhandled(object);
    }
}