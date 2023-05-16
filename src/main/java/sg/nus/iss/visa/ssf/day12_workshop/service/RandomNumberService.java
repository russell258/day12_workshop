package sg.nus.iss.visa.ssf.day12_workshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

import org.springframework.stereotype.Service;

//put service so that our container will create bean for this
@Service
public class RandomNumberService {
    public List<Integer> generateRandomNumbers(int number){
        return new Random().ints(1,31).distinct().limit(number).boxed().collect(Collectors.toList());
    }
}
