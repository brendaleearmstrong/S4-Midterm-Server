// Adding to override changes

package com.misight.controller;

import com.misight.model.Mine;
import com.misight.model.MineDTO;
import com.misight.model.Province;
import com.misight.repository.ProvinceRepo;
import com.misight.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/mines")
public class MineController {

    @Autowired
    private MineService mineService;

    @Autowired
    private ProvinceRepo provinceRepo;

    @GetMapping
    public ResponseEntity<List<Mine>> getAllMines() {
        return ResponseEntity.ok(mineService.getAllMines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mine> getMineById(@PathVariable int id) {
        return mineService.getMineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mine> createMine(@Validated @RequestBody MineDTO mineDTO) {
        try {
            if (mineDTO.getMine_id() == null) {
                throw new IllegalArgumentException("Mine ID cannot be null");
            }
            Mine mine = new Mine();
            mine.setMineName(mineDTO.getMineName());
            mine.setLocation(mineDTO.getLocation());
            mine.setCompany(mineDTO.getCompany());

            Optional<Province> provinceOptional = provinceRepo.findById(mineDTO.getProvinceId());
            if (provinceOptional.isPresent()) {
                mine.setProvince(provinceOptional.get());
            } else {
                return ResponseEntity.badRequest().body(null);
            }

            Mine savedMine = mineService.saveMine(mine);
            return new ResponseEntity<>(savedMine, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Mine> updateMine(@PathVariable int id, @Validated @RequestBody Mine mine) {
        return mineService.updateMine(id, mine)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Mine> patchMine(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return mineService.patchMine(id, updates)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMine(@PathVariable int id) {
        return mineService.deleteMine(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}