package kg.megacom;

import kg.megacom.model.Wish;
import kg.megacom.services.WishService;
import kg.megacom.services.impl.WishServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
            Общее количество пожеланий - 10
            Количество признаний на каждого пользователя - 2
            Абонент может быть заблокирован

            Выберите действие:
                1. Оставить признание
                    а. Введите свой номер:
                    b. Ввести номер получателя:
                    с. Оставить пожелание
                2. Проверить, есть ли взаимные признания
                    a. Ввести свой номер
                3. Выход


         */

        WishService wishService = new WishServiceImpl();

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Выберите действие:");
            System.out.println("1. Оставить признание\n2. Проверить, есть ли взаимные признания\n3. Выход");
            System.out.print("Ваш выбор: ");
            int choose = scanner.nextInt();

            if (choose == 1){
                System.out.print("Введите свой номер: ");
                String senderNumber = scanner.next();
                System.out.print("Введите номер получателя:");
                String recipientNumber = scanner.next();
                System.out.print("Оставить пожелание:");
                String wishText = scanner.next();

                wishService.createWish(senderNumber, recipientNumber, wishText);

            }else if (choose == 2){
                System.out.print("Введите свой номер: ");
                String senderNumber = scanner.next();

                Wish[] wishes = wishService.findMutualWishByNumber(senderNumber);

                for (Wish wish: wishes
                     ) {
                    if (wish != null){
                        System.out.println(wish.getSender().getPhone() + " - " + wish.getText());
                    }
                }


            }else if (choose == 3){
                System.out.println("До свидания!");
                break;
            }else {
                System.out.println("Некорретная команда!");
            }
        }
      }
}
