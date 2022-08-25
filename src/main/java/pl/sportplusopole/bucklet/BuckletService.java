package pl.sportplusopole.bucklet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sportplusopole.customer.Customer;

import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BuckletService {

    private final BuckletDao buckletDao;

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
                customer.setExpiryDate(customer.getPurchaseDate().plusDays(customer.getBucklet().getValidity()));
            }}
    }
}
