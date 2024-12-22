package Splitwise.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{
    @Override
    public void validateExpenseSplit(List<Split> splits, double amt) {
        Double splitAmnt =amt/2;
        for(Split split : splits)
        {
            if(split.getAmnt() != splitAmnt)
            {
                //throw exception
            }
        }
    }
}
