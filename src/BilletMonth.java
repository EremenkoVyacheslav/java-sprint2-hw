public class BilletMonth {
    String itemName;
    int quantity;
    int sumOfOne;
    boolean isExpense;

    public BilletMonth(String itemName, boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
        this.isExpense = isExpense;
    }

    @Override
    public String toString() {
        return "MonthlyRecord{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", sumOfOne=" + sumOfOne +
                ", isExpense=" + isExpense +
                '}';
    }

}
