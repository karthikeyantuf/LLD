package Splitwise;

import Splitwise.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<User , Double> userVsBalance;
    Double expense;
    Double totalOweAmt;

    public UserExpenseBalanceSheet()
    {
        userVsBalance = new HashMap<>();
        expense = 0.0;
        totalOweAmt = 0.0;
    }

    public Map<User, Double> getUserVsBalance() {
        return userVsBalance;
    }

    public Double getExpense() {
        return expense;
    }

    public Double getTotalOweAmt() {
        return totalOweAmt;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public void setTotalOweAmt(Double totalOweAmt) {
        this.totalOweAmt = totalOweAmt;
    }
}
