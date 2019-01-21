package courseJavaCore.lesson22.homeWork;

import courseJavaCore.lesson22.homeWork.exception.BadRequestException;
import courseJavaCore.lesson22.homeWork.exception.InternalServerException;
import courseJavaCore.lesson22.homeWork.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws Exception {


        validate(transaction);


        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                break;

            }
        }
        return transaction;
    }


    public static Transaction[] transactionList() {

        int count = 0;

        for (Transaction transaction : getTransactions()) {
            if (transaction != null)
                count++;
        }

        Transaction[] transactions = new Transaction[count];

        for (int i = 0; i < getTransactions().length; i++) {
            if (getTransactions()[i] != null)
                transactions[i] = getTransactions()[i];
        }

        return transactions;

    }


    public static Transaction[] transactionList(String city) {

        int count = 0;

        for (Transaction transaction : getTransactions()) {
            if (transaction != null && transaction.getCity().equals(city))
                count++;
        }

        Transaction[] transactionsListByCity = new Transaction[count];

        for (int i = 0; i < transactionsListByCity.length; i++) {
            for (int j = 0; j < getTransactions().length; j++) {
                if (getTransactions()[j] != null && getTransactions()[j].getCity().equals(city))
                    transactionsListByCity[i] = getTransactions()[j];
            }
        }

        return transactionsListByCity;
    }


    static Transaction[] transactionList(int amount) {
        int count = 0;

        for (Transaction transaction : getTransactions()) {
            if (transaction != null && transaction.getAmount() == amount)
                count++;
        }

        Transaction[] transactionsListByAmount = new Transaction[count];

        for (int i = 0; i < transactionsListByAmount.length; i++) {
            for (int j = 0; j < getTransactions().length; j++) {
                if (getTransactions()[j] != null && getTransactions()[j].getAmount() == amount)
                    transactionsListByAmount[i] = getTransactions()[j];
            }
        }
        return transactionsListByAmount;
    }

    private static void validate(Transaction transaction) throws Exception {

        if (transaction.getAmount() >= utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = transaction.getAmount();
        int count = 1;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
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
        }

        if (count == 0) {
            throw new BadRequestException("Transaction from this city isn't possible " + transaction.getId() + ". Can't be saved");
        }
        count = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                count++;
                break;
            }
        }
        if (count == 0) {
            throw new InternalServerException("Transaction isn't possible (out of memory) " + transaction.getId() + ". Can't be saved");
        }


    }


    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
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

    public static Transaction[] getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "TransactionDAO{" +
                "transactions=" + Arrays.toString(transactions) +
                ", utils=" + utils +
                '}';
    }
}
