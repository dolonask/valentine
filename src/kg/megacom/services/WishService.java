package kg.megacom.services;

import kg.megacom.model.Wish;

public interface WishService {

    void createWish(String senderPhone, String recipientPhone, String text);

    Wish[] findMutualWishByNumber(String phoneNumber);
}
