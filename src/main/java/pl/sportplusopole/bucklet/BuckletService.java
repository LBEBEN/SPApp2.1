package pl.sportplusopole.bucklet;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.sportplusopole.customer.Customer;
import pl.sportplusopole.customer.CustomerRepository;

import java.time.LocalDate;
import java.util.*;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BuckletService {

    private final BuckletDao buckletDao;
    private final CustomerRepository customerRepository;

    public List<Bucklet> showAll(){
        return buckletDao.showAll();
    }
    public Bucklet findById (int id){
        return buckletDao.findById(id);
    }

    public void addBucklet(Bucklet bucklet){buckletDao.addBucklet(bucklet);}

    public void editBucklet(Bucklet bucklet){
        buckletDao.edit(bucklet);
    }

    public void deleteBucklet (Bucklet bucklet) {buckletDao.delete(bucklet);
    }

    // ustawienie ilości wejść i daty ważności klienta, wykorzystywane w editClient oraz addCustomer w CustomerController
    public void setVisitsAndExpiryDate(Customer customer) {
        List<Bucklet> bucklets = showAll();
        for (Bucklet b : bucklets) {
            if (b.getBuckletId() == customer.getBucklet().getBuckletId()) {
                customer.setVisitsLeft(b.getNumberOfVisits());
                customer.setExpiryDate(customer.getPurchaseDate().toLocalDate().plusDays(customer.getBucklet().getValidity()));
            }}
    }

    // metoda do podsumowania karnetów
    public Map<Double, Integer> showPriceBalance(){
        Map<Double, Integer> showPriceBalance = new TreeMap<>();
        List<Double> allPrice = buckletDao.showAllPrice();
        for(Double price : allPrice){
            showPriceBalance.put(price, customerRepository.countPrice(price, LocalDate.now().plusDays(60)));
        }
        return showPriceBalance;
    }


}
