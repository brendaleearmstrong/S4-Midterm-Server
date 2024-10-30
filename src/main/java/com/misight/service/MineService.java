package com.misight.service;

import com.misight.model.Mine;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MineService {
    List<Mine> getAllMines();
    Optional<Mine> getMineById(int id);
    Mine saveMine(Mine mine);
    Optional<Mine> updateMine(int id, Mine mine);
    Optional<Mine> patchMine(int id, Map<String, Object> updates);
    boolean deleteMine(int id);
}
