package Splitwise.Expense;

import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    List<Split> splitDetails;
    User userPaidBy;

    public Expense(String expenseId,String description,User userPaidBy,List<Split> splitDetails)
    {
        this.expenseId = expenseId;
        this.description = description;
        this.splitDetails.addAll(splitDetails);
        this.userPaidBy = userPaidBy;
    }
}
