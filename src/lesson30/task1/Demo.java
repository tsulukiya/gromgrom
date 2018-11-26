package lesson30.task1;


public class Demo {
    public static void main(String[] args) throws Exception {
        Bank euBank = new EUBank(1223, "Ireland", Currency.USD, 120, 2000, 5, 33344567);

        User user = new User(1001, "Denis1", 20000, 40, "GMD1", 1500, euBank);

        UkrainianBankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user, 150);
        Thread.sleep(2000);
        bankSystem.withdraw(user, 10);

        System.out.println(bankSystem.getTransactions());

    }
}
