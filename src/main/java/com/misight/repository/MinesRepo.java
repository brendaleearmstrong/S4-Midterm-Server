package com.misight.repository;

import com.misight.model.Mines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinesRepo extends JpaRepository<Mines, Long> {

}
