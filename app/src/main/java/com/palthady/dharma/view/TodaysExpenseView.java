package com.palthady.dharma.view;

import java.util.List;

import com.palthady.dharma.model.Expense;

public interface TodaysExpenseView {
  void displayTotalExpense(Long totalExpense);
  void displayTodaysExpenses(List<Expense> expenses);
}
