package dev.vraj.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();


    // return all the runs stores
    List<Run>findAll() {
        return runs;
    }

    // function which returns the whole run whose id is given
    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id()
                .equals(id))
                .findFirst();

    }

    // function to create a new run whose id is given
    void create(Run run){
        runs.add(run);
    }

    // function to update data of the run provided
    void updateRun(Run run,Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()) ,run);
        }
    }

    // function to delete the run whose id is provided
    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

// just a function to initially hard code in 2 default runs
    @PostConstruct
    private  void init(){
        runs.add(new Run(1, "Morning Run" , LocalDateTime.now() , LocalDateTime.now().plus(30, ChronoUnit.MINUTES) , 3 ,Location.INDOOR));
        runs.add(new Run(2 ,"Wednesday Evening Run" , LocalDateTime.now() , LocalDateTime.now().plus(60,ChronoUnit.MINUTES)  , 6, Location.INDOOR));
    }
}
