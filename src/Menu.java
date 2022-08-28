import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        menu();

    }


    public static void printMenu() {
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчетах");
        System.out.println("5 - Вывести информацию о годовом отчете");
        System.out.println("0 - Выход");
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Reconciliation reconciliation = new Reconciliation();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                monthlyReport.readLines();
                System.out.println();
            } else if (userInput == 2) {
                yearlyReport.readLines();
            } else if (userInput == 3) {
                reconciliation.reconciliationOfReports(monthlyReport, yearlyReport);
            } else if (userInput == 4) {
                monthlyReport.printReports();
            } else if (userInput == 5) {
                yearlyReport.printReport();
            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды нет");
            }
        }
    }
}
