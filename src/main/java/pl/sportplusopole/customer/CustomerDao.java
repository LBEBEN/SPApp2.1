package pl.sportplusopole.customer;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Customer> showAll(){
        Query query = entityManager.createQuery("SELECT c FROM Customer c");
        return query.getResultList();
    }

    public Customer findById(int id){
        return entityManager.find(Customer.class, id);
    }

    public void addCustomer(Customer customer){
        entityManager.persist(customer);
    }

    public void edit(Customer customer){
        entityManager.merge(customer);
    }

    public void delete(Customer customer) {
        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
    }
}
