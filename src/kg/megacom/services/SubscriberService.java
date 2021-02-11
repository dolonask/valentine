package kg.megacom.services;

import kg.megacom.model.Subscriber;

public interface SubscriberService {

    Subscriber findOrCreateSubscriber(String phone);
}
