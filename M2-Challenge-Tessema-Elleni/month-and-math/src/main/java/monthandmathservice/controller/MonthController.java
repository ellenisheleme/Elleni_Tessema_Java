package monthandmathservice.controller;
// custom exception handling is done based on the class activity CityWebService week2 day 3
import monthandmathservice.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MonthController {

    List<monthandmathservice.model.Month> monthList = new ArrayList<>(Arrays.asList(new monthandmathservice.model.Month(1, "January"),
            new monthandmathservice.model.Month(2, "February"),
            new monthandmathservice.model.Month(3, "March"),
            new monthandmathservice.model.Month(4, "April"),
            new monthandmathservice.model.Month(5, "April"),
            new monthandmathservice.model.Month(6, "June"),
            new monthandmathservice.model.Month(7, "July"),
            new monthandmathservice.model.Month(8, "August"),
            new monthandmathservice.model.Month(9, "September"),
            new monthandmathservice.model.Month(10, "October"),
            new monthandmathservice.model.Month(11, "November"),
            new monthandmathservice.model.Month(12, "December")
    ));

    @RequestMapping(value = "/month", method = RequestMethod.GET)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<monthandmathservice.model.Month> getMonthList() {
        return monthList;
    }

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public monthandmathservice.model.Month getByMonthNumber(@PathVariable int monthNumber) {
        for (monthandmathservice.model.Month month : monthList) {
            if (month.getMonthNumber() == monthNumber) {

                System.out.println(month.getMonthNumber() + "-" + month.getMonthName());

                return month;
            }
        }

        throw new NotFoundException("Attempt to get a month number not exist " + monthNumber);
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public monthandmathservice.model.Month getRandomMonth() {

        int max = 12;
        int min = 1;
        int range = (max - min) + 1;

        int randomMonth = min + (int) (Math.random() * max);
        monthandmathservice.model.Month month = null;
        for (int i = 0; i < monthList.size(); i++) {
            if (monthList.get(i).getMonthNumber() == randomMonth) {

                month = monthList.get(i);
                System.out.println(month);
                break;
            }
        }
        return month;
    }



}




