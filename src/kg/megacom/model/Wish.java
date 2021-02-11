package kg.megacom.model;

public class Wish {


    private double id;
    private String text;
    private Subscriber sender;
    private Subscriber recipient;

    public Wish(String text, Subscriber sender, Subscriber recipient) {
        id = Math.random();
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
    }

    public double getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Subscriber getSender() {
        return sender;
    }

    public void setSender(Subscriber sender) {
        this.sender = sender;
    }

    public Subscriber getRecipient() {
        return recipient;
    }

    public void setRecipient(Subscriber recipient) {
        this.recipient = recipient;
    }
}
