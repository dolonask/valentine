package kg.megacom.services.impl;

import kg.megacom.exceptions.MaxSubscribersCountException;
import kg.megacom.model.Subscriber;
import kg.megacom.services.SubscriberService;

public class SubscriberServiceImpl implements SubscriberService {

    private Subscriber[] subscribers = new Subscriber[100];

    @Override
    public Subscriber findOrCreateSubscriber(String phone) {

        /*
            если ячейка пустая, то пропускаем
            если не пустая, то проверяем номер
            если абонента такого нет, то создаем

         */
        for (int i = 0; i < subscribers.length; i++){

            if (subscribers[i] == null){
                Subscriber subscriber = new Subscriber(phone);
                subscribers[i]  = subscriber;
                return subscriber;
            }else {
                if (subscribers[i].getPhone().equals(phone)){
                    return subscribers[i];
                }else{
                    continue;
                }
            }
        }

        throw new MaxSubscribersCountException();
    }
}
