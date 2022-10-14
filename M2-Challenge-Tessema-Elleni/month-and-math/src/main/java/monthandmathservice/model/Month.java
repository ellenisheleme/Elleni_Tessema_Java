package monthandmathservice.model;

import javax.validation.constraints.*;
import java.util.Objects;

public class Month {

    @Size(max = 12 , min = 1)
    private int monthNumber;
    @NotEmpty(message =  "You must put the month name")
    private String monthName;

    public Month(int monthNumber, String monthName) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthName='" + monthName + '\'' +
                ", monthNumber=" + monthNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return monthNumber == month.monthNumber && Objects.equals(monthName, month.monthName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthName, monthNumber);
    }


}
