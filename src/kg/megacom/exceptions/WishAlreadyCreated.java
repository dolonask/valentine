package kg.megacom.exceptions;

public class WishAlreadyCreated extends RuntimeException{

    public WishAlreadyCreated() {
        super("Пожелание уже было создано!");
    }
}
