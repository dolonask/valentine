package kg.megacom.services.impl;

import kg.megacom.exceptions.MaxWishCountException;
import kg.megacom.exceptions.WishAlreadyCreated;
import kg.megacom.model.Subscriber;
import kg.megacom.model.Wish;
import kg.megacom.services.SubscriberService;
import kg.megacom.services.WishService;

public class WishServiceImpl implements WishService {

    private Wish[] wishes = new Wish[10];
    private SubscriberService subscriberService = new SubscriberServiceImpl();
    @Override
    public void createWish(String senderPhone, String recipientPhone, String text) {

        Subscriber sender = subscriberService.findOrCreateSubscriber(senderPhone);
        Subscriber recipient = subscriberService.findOrCreateSubscriber(recipientPhone);

        if (wishExistsBySenderAndRecipient(sender, recipient)){
            throw new WishAlreadyCreated();
        }

        sender.increaseWishCount();

        Wish wish = new Wish(text,sender, recipient);

        if (addWishToArray(wish)){
            System.out.println("Желание успешно добавлено!");
        };



        /*
            1. По номеру абонента найти абонента
                а. если его нет, то создать
                б. если есть то вернуть
            2. Ты уже оставлял ему пожелание
            3. Увеличили количество пожеланий абонента отправителя
            4. Создаем пожелание
            5. Добавляем в первую пустую ячейку
         */
    }

    @Override
    public Wish[] findMutualWishByNumber(String phoneNumber) {

        Wish[] myWishes = new Wish[wishes.length];

        Subscriber subscriber = subscriberService.findOrCreateSubscriber(phoneNumber);

        if (wishes.length <=1){
            return null;
        }

        for (int i = 0; i < wishes.length; i++){
            if (wishes[i] != null){

                if (wishes[i].getSender().getId() == subscriber.getId()){
                    // 2 -> 3
                    // 3 -> 2

                    for (int j = 0; j < wishes.length; j++){

                        Wish sender = wishes[i];
                        Wish recipient = wishes[j];

                        if ( wishes[j] != null && wishes[j].getSender().getId() == wishes[i].getRecipient().getId() && wishes[j].getRecipient().getId() == subscriber.getId()){
                            myWishes[i] = wishes[j];
                        }
                    }
                }

            }
        }

        return myWishes;
    }

    private boolean addWishToArray(Wish wish) {

        for (int i = 0; i < wishes.length; i++){
            if (wishes[i] == null){
                wishes[i] = wish;
                return true;
            }
        }

        throw new MaxWishCountException();
    }

    private boolean wishExistsBySenderAndRecipient(Subscriber sender, Subscriber recipient) {

        for (Wish item:wishes) {

            if (item == null){
                continue;
            }else{
                if (item.getSender().getId() == sender.getId() && item.getRecipient().getId() == recipient.getId()){
                    return true;
                }
            }
        }

        return false;
    }
}
