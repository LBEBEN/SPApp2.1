package pl.sportplusopole.trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TrainerConverter implements Converter<String, Trainer> {

    @Autowired
    private TrainerService trainerService;

    @Override
    public Trainer convert(String s) {
        return trainerService.findById(Integer.parseInt(s));
    }

}
