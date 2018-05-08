package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        User user = new User(1001, "Denis", 20000, 40, "GMD", 1500, euBank);
        User user1 = new User(1002, "Denis1", 100, 401, "GMD1", 150, euBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        //bankSystem.withdraw(user, 150);

        //System.out.println(user.getBalance());

        //System.out.println("+++++++++++++++++++");

        //bankSystem.fund(user1, 10001);
        //System.out.println(user1.getBalance());

        System.out.println("+++++++++++++++++++++++++");
        bankSystem.transferMoney(user, user1, 1250);
        System.out.println(user.getBalance());
        System.out.println(user1.getBalance());
    }
}
