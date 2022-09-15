package pl.sportplusopole.excelExport;

import org.springframework.stereotype.Repository;
import pl.sportplusopole.customer.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DateTimeDataDao {

    @PersistenceContext
    EntityManager entityManager;

    public DateTimeData findById(int id){
        return entityManager.find(DateTimeData.class, id);
    }

    public void addDateTimeData(DateTimeData dateTimeData){
        entityManager.persist(dateTimeData);
    }

    public void edit(DateTimeData dateTimeData){
        entityManager.merge(dateTimeData);
    }

}
