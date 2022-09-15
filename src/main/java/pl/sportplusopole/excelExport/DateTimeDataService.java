package pl.sportplusopole.excelExport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Repository
@Transactional
@RequiredArgsConstructor
public class DateTimeDataService {

    private final DateTimeDataDao dateTimeDataDao;

    public DateTimeData findById(){
        return dateTimeDataDao.findById(1);
    }

    public void addDateTimeData (){
        DateTimeData dateTimeData = new DateTimeData();
        dateTimeData.setMonthName(String.valueOf(LocalDate.now().getMonth()));
        dateTimeDataDao.addDateTimeData(dateTimeData);
    }

}
