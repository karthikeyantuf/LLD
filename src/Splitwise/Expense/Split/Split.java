package Splitwise.Expense.Split;

import Splitwise.User.User;

public class Split {
    Double amnt;
    User user;

    public Split(User user, double amnt)
    {
        this.amnt = amnt;
        this.user = user;
    }

    public Double getAmnt() {
        return amnt;
    }

    public User getUser() {
        return user;
    }
}
