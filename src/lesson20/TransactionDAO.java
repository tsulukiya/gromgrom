package lesson20;

import lesson20.exception.BadRequestException;
import lesson20.exception.InternalServerException;
import lesson20.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {


        validate(transaction);


        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                break;

            }
        }
        return transaction;
    }


    Transaction[] transactionList() {
        return null;

    }


    Transaction[] transactionList(String city) {
        return null;
    }


    Transaction[] transactionList(int amount) {
        return null;
    }

    private void validate(Transaction transaction) throws Exception {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) //todo >
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
                sum =+ tr.getAmount();
                ++count;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");
        }

        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");
        }

        count = 0;
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity())) {
                count++;

            }
            if (count == 0) {
                throw new BadRequestException("Transaction from this city isn't possible " + transaction.getId() + ". Can't be saved");
            }
        }

        count = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                count++;
                break;
            }
        }
        if (count == 0) {
            throw new InternalServerException("Transaction isn't possible " + transaction.getId() + ". Can't be saved");
        }


    }


    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;
    }


}
