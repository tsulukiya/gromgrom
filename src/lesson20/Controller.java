package lesson20;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    Transaction [] transactionList() {
        return transactionDAO.transactionList();

    }

    Transaction [] transactionList(String city) {
        return transactionDAO.transactionList();

    }

   Transaction [] transactionList(int amount) {
        return null;

    }

}
