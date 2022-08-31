public class Reconciliation {

    public  void reconciliationOfReports(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        boolean reconciliation = false;

        try {

            for (int i = 1; i <= 3; i++) {
                if ((monthlyReport.getMonthIncome(i) == yearlyReport.getMonthIncome(i)) ||
                        (monthlyReport.getMonthSpending(i) == yearlyReport.getMonthSpending(i))) {
                    System.out.println("Сверка прошла успешно");
                   reconciliation = true;
                }
            }
            if (!reconciliation) {
                for (int i = 0; i <= 3 ; i++) {
                    System.out.println(monthlyReport.getNameMonths(i) + ": обнаружено несоответствие");
                }

            }
        } catch (Exception e) {
            System.out.println("Для сверки в начале нужно сверить отчеты!");
        }
    }
}

