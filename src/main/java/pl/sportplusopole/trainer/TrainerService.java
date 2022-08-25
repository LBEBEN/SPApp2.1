package pl.sportplusopole.trainer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerDao trainerDao;

    public List<Trainer> findAll(){
        return trainerDao.findAll();
    }

    public Trainer findById (int id){
        return trainerDao.findById(id);
    }

    public void addTrainer(Trainer trainer){
        trainerDao.addTrainer(trainer);
    }

    public void editTrainer(Trainer trainer){
        trainerDao.edit(trainer);
    }

    public void deleteTrainer(Trainer trainer){
        trainerDao.delete(trainer);
    }

}
