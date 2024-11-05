package com.misight.repository;

import com.misight.model.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvincesRepo extends JpaRepository<Provinces, Long> {
    // Custom query methods can be added here if required
}
