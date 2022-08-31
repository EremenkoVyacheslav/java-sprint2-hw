import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<BilletMonth>> monthlyReports = new HashMap<>();
    ArrayList<BilletMonth> monthlyReport = new ArrayList<>();

    public void readLines() {
        ReadFileContentsOrNull readFileContentsOrNull = new ReadFileContentsOrNull();
        if (monthlyReports.isEmpty()) {
            for (int n = 1; n <= 3; n++) {
               monthlyReport =  new ArrayList<>();
                String monthlyReportRaw =
                        readFileContentsOrNull.readFileContentsOrNull("resources/m.20210" + n + ".csv");
                String[] lines = monthlyReportRaw.split("\n");
                for (int i = 1; i < lines.length; i++) {
                   String[] linesContent = lines[i].split(",");
                    monthlyReport.add(new BilletMonth(
                            linesContent[0],
                            Boolean.parseBoolean(linesContent[1]),
                            Integer.parseInt(linesContent[2]),
                            Integer.parseInt(linesContent[3])
                    ));
                }
                monthlyReports.put(n, monthlyReport);
            }

            System.out.println("Отчет успешно считан");
        } else {
            System.out.println("Отчет уже загружен");
        }
    }

    public void printReports() {
        if (!monthlyReports.isEmpty()) {
            for (Integer month : monthlyReports.keySet()) {
                int monthMaxExpense = 0;
                String monthMaxName = "";
                for (BilletMonth billetMonth : monthlyReports.get(month)) {

                    if (!billetMonth.isExpense) {
                        int sum = billetMonth.quantity * billetMonth.sumOfOne;
                        if (sum > monthMaxExpense) {
                            monthMaxExpense = sum;
                            monthMaxName = billetMonth.itemName;
                        }
                    }
                }
                System.out.println("Месяц: " + getNameMonths(month));
                System.out.println("Самый прибыльный товар: " + monthMaxName);
                System.out.println("Сумма: " + monthMaxExpense);
            }

        } else {
            System.out.println("Отчет не создан");
        }

    }

    public int getMonthIncome(int month) {
        int totalIncome = 0;
        for (BilletMonth billetMonth : monthlyReports.get(month)) {
            if (!billetMonth.isExpense) {
                totalIncome += billetMonth.quantity * billetMonth.sumOfOne;
            }
        }
        return totalIncome;
    }

    public String getNameMonths(int monthNumber) {
        String[] months = {"Январь", "Февраль", "Март"};
        return months[monthNumber - 1];
    }

    public int getMonthSpending(int month) {
        int totalOutcome = 0;
        for (BilletMonth billetMonth : monthlyReports.get(month)) {
            if (billetMonth.isExpense) {
                totalOutcome += billetMonth.quantity * billetMonth.sumOfOne;
            }
        }

        return totalOutcome;
    }
}

