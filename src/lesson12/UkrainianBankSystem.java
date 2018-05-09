package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        checkWithdrawFinal(user, amount);
    }

    @Override
    public void fund(User user, int amount) {
        checkFundFinal(user, amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkTransferMoney(fromUser, toUser, amount))
            return;
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);
    }

    @Override
    public void paySalary(User user) {
        //todo homework

    }

    private void checkWithdrawFinal(User user, int amount) {
        if (checkWithdraw(user, amount))
            user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private void checkFundFinal(User user, int amount) {
        if (checkFund(user, amount))
            user.setBalance(user.getBalance() + amount);
    }

    private boolean checkFund(User user, int amount) {
        return checkFundLimits(user, amount, user.getBank().getLimitOfFunding());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkFundLimits(User user, int amount, double limit) {
        if (amount > limit) {
            printFundErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user " + user.toString());
    }

    private void printFundErrorMsg(int amount, User user) {
        System.err.println("Can't fund money " + amount + " from user " + user.toString());
    }

    private boolean checkAmountFund(int amount) {
        if (amount <= 0) {
            System.err.println(" ERROR: Value 'amount' isn't correct...");
            return false;
        }
        return true;
    }

    private boolean checkTransferMoney(User fromUser, User toUser, int amount) {
        return checkAmountFund(amount) && checkWithdraw(fromUser, amount) && checkFund(toUser, amount) &&
                (fromUser.getBank().getCurrency() == toUser.getBank().getCurrency());
    }
}
