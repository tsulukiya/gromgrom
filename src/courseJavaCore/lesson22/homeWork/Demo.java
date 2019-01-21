package courseJavaCore.lesson22.homeWork;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Transaction transaction = new Transaction(101, "Odessa", 2, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction1 = new Transaction(100, "Kiev", 2, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction2 = new Transaction(102, "Kiev", 2, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction3 = new Transaction(103, "Kiev", 5, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction4 = new Transaction(104, "Kiev", 2, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction5 = new Transaction(105, "Kiev", 16, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction6 = new Transaction(106, "Kiev", 10, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction7 = new Transaction(107, "Kiev", 1, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction8 = new Transaction(1089, "Kiev", 11, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction9 = new Transaction(1099, "Kiev", 3, "asas", TransactionType.OUTCOME, new Date());
        Transaction transaction10 = new Transaction(1010, "Odessa", 6, "asas", TransactionType.OUTCOME, new Date());
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.save(transaction);
        transactionDAO.save(transaction1);
        transactionDAO.save(transaction2);
        transactionDAO.save(transaction3);
        transactionDAO.save(transaction4);
        transactionDAO.save(transaction5);
        transactionDAO.save(transaction6);
        transactionDAO.save(transaction7);
        transactionDAO.save(transaction8);
        transactionDAO.save(transaction9);
        //transactionDAO.save(transaction10);
        System.out.println(Arrays.toString(transactionDAO.transactionList("")));





    }
}
