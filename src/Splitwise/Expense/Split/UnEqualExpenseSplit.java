package Splitwise.Expense.Split;

import java.util.List;

public class UnEqualExpenseSplit implements ExpenseSplit{
    @Override
    public void validateExpenseSplit(List<Split> splits, double amt) {
        Double total =0.0;
        for(Split split : splits)
        {
            total += split.getAmnt();
        }
        if(total != amt)
        {
            //throw exception
        }
    }
}
