import java.util.HashMap;
import java.util.Map;

public class Wallet {
    private User user;
    private double balance;
    private Map<String, Double> incomes; // Доходы по категориям
    private Map<String, Double> expenses; // Расходы по категориям
    private Map<String, Double> budgets;  // Бюджеты по категориям

    public Wallet(User user) {
        this.user = user;
        this.balance = 0.0;
        this.incomes = new HashMap<>();
        this.expenses = new HashMap<>();
        this.budgets = new HashMap<>();
    }

    public void addIncome(String category, double amount) {
        incomes.put(category, incomes.getOrDefault(category, 0.0) + amount);
        balance += amount;
    }

    public void addExpense(String category, double amount) {
        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
        balance -= amount;
    }

    public void setBudget(String category, double amount) {
        budgets.put(category, amount);
    }

    public double getTotalIncome() {
        return incomes.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getTotalExpense() {
        return expenses.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getCategoryExpense(String category) {
        return expenses.getOrDefault(category, 0.0);
    }

    public double getCategoryBudget(String category) {
        return budgets.getOrDefault(category, 0.0);
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Double> getBudgets() {
        return budgets;
    }
}
