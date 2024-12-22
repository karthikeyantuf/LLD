package Splitwise.Expense.Split;

import java.util.List;

public interface ExpenseSplit {

    public void validateExpenseSplit(List<Split> splits , double amt);
}
