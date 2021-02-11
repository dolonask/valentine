package kg.megacom.exceptions;

public class MaxSubscribersCountException extends RuntimeException {

    public MaxSubscribersCountException() {
        super("Максимальное количество абонентов!");
    }
}
