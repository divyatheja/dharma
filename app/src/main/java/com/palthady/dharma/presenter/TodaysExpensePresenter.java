package com.palthady.dharma.presenter;

import java.util.List;

import com.palthady.dharma.database.ExpenseDatabaseHelper;
import com.palthady.dharma.model.Expense;
import com.palthady.dharma.view.TodaysExpenseView;

public class TodaysExpensePresenter {

  private TodaysExpenseView view;
  private final List<Expense> expenses;

  public TodaysExpensePresenter(TodaysExpenseView view, ExpenseDatabaseHelper expenseDatabaseHelper) {
    this.view = view;
    expenses = expenseDatabaseHelper.getTodaysExpenses();
  }

  public void renderTotalExpense() {
    Long totalExpense = 0l;
    for (Expense expense : expenses)
      totalExpense += expense.getAmount();

    view.displayTotalExpense(totalExpense);
  }

  public void renderTodaysExpenses() {
    view.displayTodaysExpenses(expenses);
  }
}
