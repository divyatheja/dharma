package com.palthady.dharma.presenter;

import com.palthady.dharma.database.ExpenseDatabaseHelper;
import com.palthady.dharma.utils.ExpenseCollection;
import com.palthady.dharma.view.CurrentWeekExpenseView;

public class CurrentWeekExpensePresenter {

  private CurrentWeekExpenseView view;
  private ExpenseDatabaseHelper database;
  private ExpenseCollection expenseCollection;

  public CurrentWeekExpensePresenter(ExpenseDatabaseHelper database, CurrentWeekExpenseView view) {
    this.database = database;
    this.view = view;
    expenseCollection = new ExpenseCollection(this.database.getCurrentWeeksExpenses());
  }

  public void renderTotalExpenses() {
    view.displayTotalExpenses(expenseCollection.getTotalExpense());
  }

  public void renderCurrentWeeksExpenses() {
    view.displayCurrentWeeksExpenses(expenseCollection.groupByDate());
  }
}
