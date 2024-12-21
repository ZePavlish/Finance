import java.util.HashMap;
import java.util.Map;

public class FinanceApp {
    private Map<String, User> users;
    private User loggedInUser;

    public FinanceApp() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Пользователь с таким логином уже существует.");
            return;
        }
        users.put(username, new User(username, password));
        System.out.println("Пользователь успешно зарегистрирован.");
    }

    public void login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Авторизация прошла успешно.");
        } else {
            System.out.println("Неверные логин или пароль.");
        }
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Выход из системы.");
    }

    public void addIncome(String category, double amount) {
        if (loggedInUser != null) {
            loggedInUser.getWallet().addIncome(category, amount);
            System.out.println("Доход успешно добавлен.");
        } else {
            System.out.println("Вы не авторизованы.");
        }
    }

    public void addExpense(String category, double amount) {
        if (loggedInUser != null) {
            loggedInUser.getWallet().addExpense(category, amount);
            System.out.println("Расход успешно добавлен.");
        } else {
            System.out.println("Вы не авторизованы.");
        }
    }

    public void setBudget(String category, double amount) {
        if (loggedInUser != null) {
            loggedInUser.getWallet().setBudget(category, amount);
            System.out.println("Бюджет успешно установлен.");
        } else {
            System.out.println("Вы не авторизованы.");
        }
    }

    public void showFinances() {
        if (loggedInUser != null) {
            Wallet wallet = loggedInUser.getWallet();
            System.out.println("Общий доход: " + wallet.getTotalIncome());
            System.out.println("Общие расходы: " + wallet.getTotalExpense());
            System.out.println("Баланс: " + wallet.getBalance());

            System.out.println("Бюджет по категориям:");
            wallet.getBudgets().forEach((category, budget) -> {
                double expense = wallet.getCategoryExpense(category);
                double remainingBudget = budget - expense;
                System.out.println(category + ": " + budget + ", Оставшийся бюджет: " + remainingBudget);
            });
        } else {
            System.out.println("Вы не авторизованы.");
        }
    }
}
