package pl.sportplusopole.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;
    private final CustomerRepository customerRepository;

    public Customer findById (int id){
        return customerDao.findById(id);
    }

    public void addCustomer(Customer customer){customerDao.addCustomer(customer);}

    public void editCustomer(Customer customer){
        customerDao.edit(customer);
    }

    public void deleteCustomer(Customer customer){
        customerDao.delete(customer);
    }

    public List <Customer> visitCustomer(){
        LocalDate date = LocalDate.now().minusDays(2);
        return customerRepository.visitCustmoer(date);
    }

    public List<Customer> showALL(){
        return customerDao.showAll();
    }

    // aktywni klienci... czyli klienci którzy przez ostatnie 60 dni przynajmniej raz byli w klubie
    public List<Customer> activeCustomers(){
        LocalDate date = LocalDate.now().minusDays(60);
        return customerRepository.visitCustmoer(date);
    }

    public List<Customer> customerBySurname(String surname){
        return customerRepository.customerBySurname(surname);
    }

    public List <Customer> trainersCustomers(int trainersId){
        return customerRepository.coachesClients(trainersId);
    }

    public void notePresence(String cartNumber){
        Customer customer = customerRepository.findByCartNumber(cartNumber);
        LocalDate presentDay = LocalDate.now();
        if(!customer.getLastVisit().equals(presentDay)) {
            customer.setLastVisit(presentDay);
            if (customer.getExpiryDate().isBefore(presentDay) || customer.getVisitsLeft().equals("1")) {
                customer.setVisitsLeft(null);
            }
            if (isNumeric(customer.getVisitsLeft())) {
                int i = Integer.parseInt(customer.getVisitsLeft()) - 1;
                customer.setVisitsLeft(String.valueOf(i));
            }
            editCustomer(customer);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
