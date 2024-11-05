package com.misight.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mines")
public class Mine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mineId;

    @Column(nullable = false)
    private String mineName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    @OneToMany(mappedBy = "mine", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SafetyData> safetyData = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "mine_minerals",
            joinColumns = @JoinColumn(name = "mine_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private Set<Mineral> minerals = new HashSet<>();

    public Mine() {}

    public Mine(String mineName, String location, String company, Province province) {
        this.mineName = mineName;
        this.location = location;
        this.company = company;
        this.province = province;
    }

    public Long getMineId() {
        return mineId;
    }

    public String getMineName() {
        return mineName;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }

    public Province getProvince() {
        return province;
    }

    public Set<Mineral> getMinerals() {
        return minerals;
    }

    public Set<SafetyData> getSafetyData() {
        return safetyData;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public void addMineral(Mineral mineral) {
        minerals.add(mineral);
        mineral.getMines().add(this);
    }

    public void removeMineral(Mineral mineral) {
        minerals.remove(mineral);
        mineral.getMines().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mine)) return false;
        Mine mine = (Mine) o;
        return mineId.equals(mine.mineId);
    }

    @Override
    public int hashCode() {
        return 31 * mineId.hashCode();
    }
}