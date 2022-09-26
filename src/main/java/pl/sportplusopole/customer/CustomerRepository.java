package pl.sportplusopole.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sportplusopole.bucklet.Bucklet;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.cartNumber = ?1")
    Customer findByCartNumber(String cartNumber);

    @Query("SELECT c FROM Customer c WHERE c.lastVisit > ?1 ORDER BY c.lastVisit DESC")
    List<Customer> visitCustmoer(LocalDate date);

    @Query("SELECT c FROM Customer c WHERE c.surname = ?1")
    List <Customer> customerBySurname(String surname);

    @Query("SELECT c FROM Customer c WHERE c.trainer.trainerId = ?1")
    List <Customer> coachesClients (int trainerId);

    @Query("SELECT COUNT(c.bucklet.price) FROM Customer c WHERE c.bucklet.price = ?1 AND c.lastVisit > ?1")
    Integer countPrice ( Double price, LocalDate date);

}
