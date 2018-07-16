package lesson20;

public class Utils {
    private int limitTransactionPerDayCount = 10;
    private int limitTransactionPerDayAmount = 100;
    private int limitSimpleTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionPerDayCount() {
        return limitTransactionPerDayCount;
    }

    public int getLimitTransactionPerDayAmount() {
        return limitTransactionPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
