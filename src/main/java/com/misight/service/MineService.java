package com.misight.service;

import com.misight.model.Mine;
import com.misight.repository.MineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService {
    @Autowired
    private MineRepo mineRepo;

    public List<Mine> getAllMines() { return mineRepo.findAll(); }
    public Mine getMineById(int id) { return mineRepo.findById(id).orElse(null); }
    public Mine saveMine(Mine mine) { return mineRepo.save(mine); }
    public void deleteMine(int id) { mineRepo.deleteById(id); }
}