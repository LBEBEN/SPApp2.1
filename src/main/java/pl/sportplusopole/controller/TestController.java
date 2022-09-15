package pl.sportplusopole.controller;

import jxl.write.WriteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sportplusopole.customer.CustomerService;
import pl.sportplusopole.excelExport.DateTimeData;
import pl.sportplusopole.excelExport.DateTimeDataService;
import pl.sportplusopole.excelExport.JExcel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
    public class TestController {

    private final CustomerService customerService;
    private final DateTimeDataService dateTimeDataService;
    private final JExcel jExcel;


    @RequestMapping("/helloPanel")
        public String hello() throws WriteException, IOException {
        Optional<DateTimeData> getDate = Optional.ofNullable(dateTimeDataService.findById()); // pobieram dane z obiektu  DateTimeData do sprawdzenia czy obiekt nie jest nullem

        if(!getDate.isPresent()){
                dateTimeDataService.addDateTimeData();}
        else {
           if( !getDate.get().getMonthName().equals(String.valueOf(LocalDate.now().getMonth()))){
               String monthName = String.valueOf(LocalDate.now().getMonth());
               getDate.get().setMonthName(monthName);
               jExcel.exportToExcel(customerService.showALL(), monthName );
           }
        }
            return "hello/helloPanel";
        }
    }

