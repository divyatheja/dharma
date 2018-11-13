package com.palthady.dharma.view;

import java.util.List;
import java.util.Map;

import com.palthady.dharma.model.Expense;

public interface CurrentWeekExpenseView {
  void displayCurrentWeeksExpenses(Map<String, List<Expense>> expensesByDate);

  void displayTotalExpenses(Long totalExpense);
}
