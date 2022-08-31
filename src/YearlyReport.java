import java.io.File;
import java.util.ArrayList;


public class YearlyReport {

    ArrayList<BilletYear> yearlyReport = new ArrayList<>();

    public void readLines() {
        if (yearlyReport.isEmpty()) {
            ReadFileContentsOrNull readFileContentsOrNull = new ReadFileContentsOrNull();
            String monthlyReportRaw = readFileContentsOrNull.readFileContentsOrNull("resources/y.2021.csv");
            String[] lines = monthlyReportRaw.split("\n");
            for (int i = 1; i < lines.length; i++) {
                String[] linesContent = lines[i].split(",");

                yearlyReport.add(new BilletYear(
                        Integer.parseInt(linesContent[0]),
                        Integer.parseInt(linesContent[1]),
                        Boolean.parseBoolean(linesContent[2])
                ));
            }
            System.out.println("Отчет успешно считан");
        } else {
            System.out.println("Отчет уже загружен");
        }
    }

    public void printReport() {


        int profitPerMonthTrue = 0;
        int profitPerMonthFalse = 0;
        int sumTrue = 0;
        int sumFalse = 0;

        if (yearlyReport.isEmpty()) {
            System.out.println("Нет отчетов для отображения");
        } else {
            printYear();
            averageAmounts();

            for (var detour : yearlyReport) {
                if (detour.isExpense) {
                    profitPerMonthTrue += detour.amount;
                    sumTrue = profitPerMonthTrue / detour.month;
                }
                if (!detour.isExpense) {
                    profitPerMonthFalse += detour.amount;
                    sumFalse = profitPerMonthFalse / detour.month;

                }
            }
            System.out.println("Средний расход за все месяцы: " + sumTrue);
            System.out.println("Средний доход за все месяцы: " + sumFalse);
        }
    }

    public void printYear() {

        File file = new File("resources/y.2021.csv");
        String fileName = file.getName();
        String fileNameWithoutSuffix = fileName.substring(2, fileName.lastIndexOf("."));
        System.out.println("Год:" + fileNameWithoutSuffix);
    }

    public void averageAmounts() {
       int firstMonth = yearlyReport.get(0).amount - yearlyReport.get(1).amount;
       int secondMonth = yearlyReport.get(2).amount - yearlyReport.get(3).amount;
       int thirdMonth = yearlyReport.get(5).amount - yearlyReport.get(4).amount;

        System.out.println("Прибыль за " + yearlyReport.get(0).month + " месяц: " + firstMonth);
        System.out.println("Прибыль за " + yearlyReport.get(2).month + " месяц: " + secondMonth);
        System.out.println("Прибыль за " + yearlyReport.get(4).month + " месяц: " + thirdMonth);
    }


    public Integer getMonthIncome(int month) {
        for (BilletYear billetYear : yearlyReport) {
            if ((billetYear.month == month) && !billetYear.isExpense) {
                return billetYear.amount;
            }
        }
        return null;
    }

    public Integer getMonthSpending(int month) {

        for (BilletYear billetYear : yearlyReport) {
            if ((billetYear.month == month) && billetYear.isExpense) {
                return billetYear.amount;

            }
        }
        return null;
    }
}