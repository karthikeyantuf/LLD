package Splitwise.Group;

import Splitwise.Expense.ExpenseController;
import Splitwise.Expense.ExpenseSplitType;
import Splitwise.Expense.Split.Split;
import Splitwise.User.User;
import Splitwise.Expense.Expense;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;

    ExpenseController expenseController;

    public Group(String groupId,String groupName)
    {
        this.groupId = groupId;
        this.groupName = groupName;
        this.expenseController = new ExpenseController();
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
    }

    public void addMember(User user)
    {
        groupMembers.add(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getGroupMembers() {
        return groupMembers;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public Expense createExpense(String expenseId, String expenseDesc, Double expAmnt, ExpenseSplitType expenseSplitType, User userPaidBy, List<Split> splits)
    {
        Expense expense = expenseController.createExpense(expenseId,expenseDesc,splits,expAmnt,expenseSplitType,userPaidBy);
        expenseList.add(expense);
        return expense;
    }
}
