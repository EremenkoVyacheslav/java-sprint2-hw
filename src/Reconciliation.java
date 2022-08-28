public class Reconciliation {

    public  void reconciliationOfReports(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        boolean reconciliation = true;

        for (int i = 1; i <=3 ; i++) {
            if ((monthlyReport.getMonthIncome(i) != yearlyReport.getMonthIncome(i)) ||
            (monthlyReport.getMonthSpending(i) != yearlyReport.getMonthSpending(i))){
                System.out.println(monthlyReport.getNameMonth(i) + ": обнаружено несоответствие");
                reconciliation = false;
            }
        }
        if (reconciliation) {
            System.out.println("Сверка прошла успешно");
        }
    }
}
