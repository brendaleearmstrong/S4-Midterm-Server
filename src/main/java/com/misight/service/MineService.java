package com.misight.service;

import com.misight.model.Mine;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Mine> getAllMines(){
        return mineRepo.findAll();
    }
}
