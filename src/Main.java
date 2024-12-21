import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceApp app = new FinanceApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (register, login, addIncome, addExpense, setBudget, showFinances, logout, exit):");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "register":
                    System.out.print("Введите логин: ");
                    String username = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();
                    app.registerUser(username, password);
                    break;
                case "login":
                    System.out.print("Введите логин: ");
                    username = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    password = scanner.nextLine();
                    app.login(username, password);
                    break;
                case "addincome":
                    System.out.print("Введите категорию дохода: ");
                    String categoryIncome = scanner.nextLine();
                    System.out.print("Введите сумму дохода: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    app.addIncome(categoryIncome, incomeAmount);
                    break;
                case "addexpense":
                    System.out.print("Введите категорию расхода: ");
                    String categoryExpense = scanner.nextLine();
                    System.out.print("Введите сумму расхода: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    app.addExpense(categoryExpense, expenseAmount);
                    break;
                case "setbudget":
                    System.out.print("Введите категорию: ");
                    String categoryBudget = scanner.nextLine();
                    System.out.print("Введите бюджет: ");
                    double budgetAmount = scanner.nextDouble();
                    scanner.nextLine();  // consume newline
                    app.setBudget(categoryBudget, budgetAmount);
                    break;
                case "showfinances":
                    app.showFinances();
                    break;
                case "logout":
                    app.logout();
                    break;
                case "exit":
                    System.out.println("Выход из приложения.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }
}
