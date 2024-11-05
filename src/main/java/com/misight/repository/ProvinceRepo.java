package com.misight.repository;

import com.misight.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Long> {
    Optional<Province> findByProvinceNameIgnoreCase(String name);
    boolean existsByProvinceNameIgnoreCase(String name);

    @Query("SELECT p FROM Province p LEFT JOIN FETCH p.mines WHERE p.provinceId = :id")
    Optional<Province> findByIdWithMines(@Param("id") Long id);
}