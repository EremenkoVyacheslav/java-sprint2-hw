import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    readFileContentsOrNull readFileContentsOrNull = new readFileContentsOrNull();
    HashMap<Integer, ArrayList<BilletMonth>> monthlyReports = new HashMap<>();
    ArrayList<BilletMonth> monthlyReport = new ArrayList<>();

    public void readLines() {
        for (int n = 1; n <= 3; n++) {
            String monthlyReportRaw = readFileContentsOrNull.readFileContentsOrNull("resources/m.20210" + n + ".csv");
            String[] lines = monthlyReportRaw.split(System.lineSeparator());
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

    }

    public void printReports() {
        if (monthlyReports.isEmpty()) {
            System.out.println("Отчет не создан");
        } else {
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
                System.out.println("Месяц: " + getNameMonth(month) + ". Самый прибыльный товар: " + monthMaxName +
                                                                                        ". Сумма: " + monthMaxExpense);
            }
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

    public String getNameMonth(int monthNumber) {
        String[] month = {"Январь", "Февраль", "Март"};
        return month[monthNumber - 1];
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

