package courseJavaCore.lesson22.homeWork;

import java.util.Date;

public class Transaction {
    private static long id;
    private static String city;
    private static int amount;
    private static String description;
    private static TransactionType type;
    private static Date dateCreated;

    public Transaction(long id, String city, int amount, String description, TransactionType type, Date dateCreated) {
        this.id = id;
        this.city = city;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.dateCreated = dateCreated;
    }

    public static long getId() {
        return id;
    }

    public static String getCity() {
        return city;
    }

    public static int getAmount() {
        return amount;
    }

    public static String getDescription() {
        return description;
    }

    public static TransactionType getType() {
        return type;
    }

    public static Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", dateCreated=" + dateCreated +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (!city.equals(that.city)) return false;
        if (!description.equals(that.description)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + city.hashCode();
        result = 31 * result + amount;
        result = 31 * result + description.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
