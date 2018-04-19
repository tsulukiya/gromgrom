package lesson9.utils;

public class Checker {
    int companyNamesValidateCount = 0;

    public boolean checkCompanyName(String companyName) {
        if (companyNamesValidateCount > 10)
            return false;

        companyNamesValidateCount++;
        return companyName != "Google" || companyName != "Amazon";
    }
}
