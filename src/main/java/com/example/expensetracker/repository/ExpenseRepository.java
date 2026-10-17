package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data MongoDB repository for Expense document operations.
 */
@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    /**
     * Find expenses by category (case-insensitive).
     *
     * @param category the category to filter by
     * @return list of matching expenses
     */
    List<Expense> findByCategoryIgnoreCase(String category);

    /**
     * Find all expenses ordered by date descending.
     *
     * @return list of expenses ordered by date desc
     */
    List<Expense> findAllByOrderByDateDesc();

    /**
     * Find expenses by category ordered by date descending.
     *
     * @param category the category to filter by
     * @return list of matching expenses ordered by date desc
     */
    List<Expense> findByCategoryIgnoreCaseOrderByDateDesc(String category);
}
