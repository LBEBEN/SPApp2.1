package pl.sportplusopole.bucklet;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BuckletDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Bucklet> showAll(){
        Query query = entityManager.createQuery("SELECT b FROM Bucklet b");
        return query.getResultList();
    }
    //wyszukiwanie pojedynczego trenera
    public Bucklet findById(int id){
        return entityManager.find(Bucklet.class, id);
    }

    //dodawanie nowego trenera
    public void addBucklet(Bucklet bucklet){
        entityManager.persist(bucklet);
    }

    //edycja danych trenera
    public void edit(Bucklet bucklet){
        entityManager.merge(bucklet);
    }

    // usuwanie trenera
    public void delete(Bucklet bucklet) {
        entityManager.remove(entityManager.contains(bucklet) ? bucklet : entityManager.merge(bucklet));
    }
}
