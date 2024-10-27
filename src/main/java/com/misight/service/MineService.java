package com.misight.service;

import com.misight.model.Mine;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MineService {
    private final MineRepo mineRepo;

    @Autowired
    public MineService(MineRepo mineRepo){
        this.mineRepo = mineRepo;
    }

    public Mine addMine(Mine mine){
        return mineRepo.save(mine);
    }

    public Optional<Mine> getMineById(Integer mine_id){
        return mineRepo.findById(mine_id);
    }

    public Optional<Mine> findById(Integer mine_id){
        return mineRepo.findById(mine_id);
    }

    public void delMine(Integer mine_id){
        mineRepo.deleteById(mine_id);
    }

    public List<Mine> getAllMines(){
        return mineRepo.findAll();
    }

    public Optional<Mine> getMineById(Integer mineId) {
    }
}
