package com.example.demo.service;


import com.example.demo.entities.Reservation;
import com.example.demo.entities.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository ScoreRepository;
    public List<Score> getAll(){
        return ScoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return ScoreRepository.getScore(id);
    }

    public Score save(Score score){
        if(score.getIdScore()==null){
            return ScoreRepository.save(score);
        }else{
            Optional<Score> e = ScoreRepository.getScore(score.getIdScore());
            if(e.isPresent()){
                return score;
            }else{
                return ScoreRepository.save(score);
            }
        }
    }
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> old=ScoreRepository.getScore(score.getIdScore());
            if(old.isPresent()){
                Score k=old.get();
                if(score.getMessageText()!=null){
                    k.setMessageText(score.getMessageText());
                }
                if(score.getStarts()!=null){
                    k.setStarts(score.getStarts());
                }
                return ScoreRepository.save(k);
            }
        }
        return score;
    }
    public boolean deleteScore (int id){
        Boolean d = getScore(id).map(score -> {
            ScoreRepository.delete(score);
            return true;
        }).orElse(false);
        return d;
    }

}
