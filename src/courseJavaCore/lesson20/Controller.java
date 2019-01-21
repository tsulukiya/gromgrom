package courseJavaCore.lesson20;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    Transaction [] transactionList() {
        return transactionDAO.transactionList();

    }

    Transaction [] transactionList(String city) {
        return transactionDAO.transactionList(city);

    }

   Transaction [] transactionList(int amount) {
        return transactionDAO.transactionList(amount);

    }

}
