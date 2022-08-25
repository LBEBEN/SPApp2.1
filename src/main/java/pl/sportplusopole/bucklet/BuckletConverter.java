package pl.sportplusopole.bucklet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class BuckletConverter implements Converter<String, Bucklet> {

    @Autowired
    private BuckletService buckletService;

    @Override
    public Bucklet convert(String s){
        return buckletService.findById(Integer.parseInt(s));
    }
}
