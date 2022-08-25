package pl.sportplusopole.trainer;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class TrainerDao {
    @PersistenceContext
    EntityManager entityManager;

    // wyświetlanie wszystkich trenerów
    public List<Trainer> findAll(){
        Query query = entityManager.createQuery("SELECT t FROM Trainer t");
        return query.getResultList();
    }

    //wyszukiwanie pojedynczego trenera
    public Trainer findById(int id){
        return entityManager.find(Trainer.class, id);
    }

    //dodawanie nowego trenera
    public void addTrainer(Trainer trainer){
        entityManager.persist(trainer);
    }

    //edycja danych trenera
    public void edit(Trainer trainer){
        entityManager.merge(trainer);
    }

    // usuwanie trenera
    public void delete(Trainer trainer) {
        entityManager.remove(entityManager.contains(trainer) ? trainer : entityManager.merge(trainer));
    }

}
