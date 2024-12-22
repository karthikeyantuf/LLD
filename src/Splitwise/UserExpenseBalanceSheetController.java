package Splitwise;

import Splitwise.Expense.Expense;
import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;

public class UserExpenseBalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidByUser, List<Split> splitList)
    {
        for(Split split : splitList)
        {
            if(split.getUser().getUserId().equals(paidByUser.getUserId()))
            {
                paidByUser.getUserExpenseBalanceSheet().setExpense(paidByUser.getUserExpenseBalanceSheet().getExpense()+ split.getAmnt());
            }
            else {
                split.getUser().getUserExpenseBalanceSheet().setTotalOweAmt(split.getUser().getUserExpenseBalanceSheet().getTotalOweAmt()+ split.getAmnt());
            }
        }
    }
}
