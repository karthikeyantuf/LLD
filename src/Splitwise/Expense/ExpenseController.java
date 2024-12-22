package Splitwise.Expense;

import Splitwise.Expense.Split.ExpenseSplit;
import Splitwise.Expense.Split.Split;
import Splitwise.User.User;
import Splitwise.UserExpenseBalanceSheetController;

import java.util.List;

public class ExpenseController {
    UserExpenseBalanceSheetController userExpenseBalanceSheetController;
    public ExpenseController()
    {
        userExpenseBalanceSheetController = new UserExpenseBalanceSheetController();
    }
    public Expense createExpense(String expenseId, String expenseDesc, List<Split> splitList, double expenseAmnt, ExpenseSplitType expenseSplitType, User userPaidBy)
    {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(expenseSplitType);
        expenseSplit.validateExpenseSplit(splitList,expenseAmnt);
        Expense expense = new Expense(expenseId,expenseDesc,userPaidBy,splitList);
        userExpenseBalanceSheetController.updateUserExpenseBalanceSheet(userPaidBy,splitList);
        return expense;
    }
}
