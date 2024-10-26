package com.misight.repository;

import com.misight.model.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface MineRepo extends JpaRepository<Mine, Integer> {

}
