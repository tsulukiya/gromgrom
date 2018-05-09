package lesson12;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank euBank = new EUBank(1223, "Ireland", Currency.USD, 120, 2000, 5, 33344567);
        Bank chinaBank = new ChinaBank(1224, "Germany", Currency.EUR, 200, 1800, 5, 222999333);
        User user1 = new User(1001, "Denis1", 20000, 40, "GMD1", 1500, usBank);
        User user2 = new User(1002, "Denis2", 1000, 10, "GMD2", 2200, usBank);
        User user3 = new User(1003, "Denis3", 1239, 20, "GMD3", 3000, euBank);
        User user4 = new User(1004, "Denis4", 1003, 30, "GMD4", 3500, euBank);
        User user5 = new User(1005, "Denis5", 1000000, 50, "GMD5", 4050, chinaBank);
        User user6 = new User(1006, "Denis6", 1002345, 60, "GMD6", 5150, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        //bankSystem.withdraw(user, 150);

        //System.out.println(user.getBalance());

        //System.out.println("+++++++++++++++++++");

        //bankSystem.fund(user1, 10001);
        //System.out.println(user1.getBalance());

        System.out.println("+++++++++++++++++++++++++");
        bankSystem.transferMoney(user5, user3, 120);
        System.out.println(user5.getBalance());
        System.out.println(user3.getBalance());
    }
}
