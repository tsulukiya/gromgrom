package lesson20;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction = new Transaction(101, "Kiev", 100, "asas", TransactionType.INCOME, new Date());
        Transaction transaction1 = new Transaction(100, "Moscow", 800, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction2 = new Transaction(102, "Minsk", 1090, "asas", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(103, "Odessa", 1600, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction4 = new Transaction(104, "Dnepropetrovsk", 1400, "asas", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(105, "Kharkov", 1600, "asas", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(106, "Kiev", 10, "asas", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(107, "Kiev", 1200, "asas", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(1089, "Kiev", 13400, "asas", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(1099, "Kiev", 14400, "asas", TransactionType.INCOME, new Date());
        Transaction transaction10 = new Transaction(1010, "Kiev", 1500, "asas", TransactionType.INCOME, new Date());
        Transaction [] transactions = new Transaction[] {transaction, transaction1, transaction2, transaction3, transaction4, transaction5, null,
        null, null, null};

        Controller controller = new Controller();
        try {
            controller.save(transaction6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(transactions));


    }
}
