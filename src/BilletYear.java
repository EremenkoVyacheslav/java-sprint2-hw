public class BilletYear {
    int month;
    int amount;
    boolean isExpense;

    public BilletYear(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }


    @Override
    public String toString() {
        return "YearlyRecord{" +
                "month='" + month + '\'' +
                ", amount=" + amount +
                ", isExpense=" + isExpense +
                '}';
    }
}
