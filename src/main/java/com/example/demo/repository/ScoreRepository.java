package com.example.demo.repository;

import com.example.demo.entities.Score;
import com.example.demo.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository ScoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) ScoreCrudRepository.findAll();
    }

    public Score save(Score score){
        return ScoreCrudRepository.save(score);
    }

    public void delete (Score score){
        ScoreCrudRepository.delete(score);
    }

    public Optional<Score> getScore(int id){
        return ScoreCrudRepository.findById(id);
    }

}
