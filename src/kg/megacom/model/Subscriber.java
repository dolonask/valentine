package kg.megacom.model;

import kg.megacom.exceptions.MaxWishCountException;
import kg.megacom.exceptions.SubscriberNotCreated;

public class Subscriber {

    private double id;
    private String phone;
    private boolean isBlocked;
    private int wishCount;

    private Subscription subscription;


    public Subscriber(String phone) {
        id = Math.random();
        setPhone(phone);
        isBlocked = false;
        wishCount = 0;
    }


    public int getWishCount() {
        return wishCount;
    }

    public void increaseWishCount() {
        if (this.wishCount >= 2)
            throw new MaxWishCountException();

        this.wishCount++;
    }

    public double getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        if (phone.length() < 0)
            throw new SubscriberNotCreated("Неверный номер телефона!");

        this.phone = phone;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
