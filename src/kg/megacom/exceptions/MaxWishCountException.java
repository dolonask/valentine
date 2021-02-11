package kg.megacom.exceptions;

public class MaxWishCountException extends RuntimeException {

    public MaxWishCountException() {
        super("Достигнуто максимально количество пожеланий!");
    }
}
