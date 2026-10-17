package com.example.expensetracker.controller;

import com.example.expensetracker.dto.TotalResponse;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * REST controller exposing endpoints for expense tracking.
 */
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /**
     * Create a new expense.
     * POST /api/expenses -> 201 Created
     */
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {
        Expense created = expenseService.createExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Get all expenses, with optional category filter.
     * GET /api/expenses?category=Food -> 200 OK
     */
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(
            @RequestParam(required = false) String category) {
        List<Expense> expenses = expenseService.getExpenses(category);
        return ResponseEntity.ok(expenses);
    }

    /**
     * Get total amount spent, with optional category filter.
     * GET /api/expenses/total?category=Food -> 200 OK
     * NOTE: Defined BEFORE /{id} so that "/total" is matched properly.
     */
    @GetMapping("/total")
    public ResponseEntity<TotalResponse> getTotalExpenses(
            @RequestParam(required = false) String category) {
        TotalResponse totalResponse = expenseService.calculateTotal(category);
        return ResponseEntity.ok(totalResponse);
    }

    /**
     * Get a single expense by ID.
     * GET /api/expenses/{id} -> 200 OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable String id) {
        Expense expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }

    /**
     * Update an existing expense by ID.
     * PUT /api/expenses/{id} -> 200 OK
     */
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
            @PathVariable String id,
            @Valid @RequestBody Expense expenseDetails) {
        Expense updated = expenseService.updateExpense(id, expenseDetails);
        return ResponseEntity.ok(updated);
    }

    /**
     * Delete an expense by ID.
     * DELETE /api/expenses/{id} -> 200 OK
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(Collections.singletonMap("message", "Expense deleted successfully"));
    }
}
