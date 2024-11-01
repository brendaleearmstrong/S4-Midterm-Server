// Adding to override changes
package com.misight.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.misight.repository.ProvinceRepo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "mines")
public class Mine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mine_id")
    private int mineId;

    @NotBlank(message = "Mine name is required")
    @Size(min = 2, max = 100, message = "Mine name must be between 2 and 100 characters")
    @Column(name = "mine_name", nullable = false)
    @JsonProperty("mine_name")
    private String mineName;

    @NotBlank(message = "Location is required")
    @Column(nullable = false)
    @JsonProperty("location")
    private String location;

    @NotBlank(message = "Company name is required")
    @Column(nullable = false)
    @JsonProperty("company")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    @JsonProperty("province_id")
    public Province province;

    @OneToMany(mappedBy = "mine", cascade = CascadeType.ALL)
    private Set<ExplorationProject> explorationProjects = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "mine_minerals",
            joinColumns = @JoinColumn(name = "mine_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private Set<Mineral> minerals = new HashSet<>();

    // Constructors
    public Mine() {}

    public Mine(String mineName, String location, String company, Province province) {
        this.mineName = mineName;
        this.location = location;
        this.company = company;
        this.province = province;
    }

    // Getters and Setters
    public int getMineId() {
        return mineId;
    }

    public String getMineName() {
        return mineName;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Set<ExplorationProject> getExplorationProjects() {
        return explorationProjects;
    }

    public Set<Mineral> getMinerals() {
        return minerals;
    }

    public void setMinerals(Set<Mineral> minerals) {
        this.minerals = minerals;
    }

    // Helper methods
    public void addMineral(Mineral mineral) {
        this.minerals.add(mineral);
        mineral.getMines().add(this);
    }

    public void removeMineral(Mineral mineral) {
        this.minerals.remove(mineral);
        mineral.getMines().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mine)) return false;
        Mine mine = (Mine) o;
        return mineId == mine.mineId;
    }

    @Override
    public int hashCode() {
        return 31 * mineId;
    }

    @Override
    public String toString() {
        return "Mine{" +
                "mineId=" + mineId +
                ", mineName='" + mineName + '\'' +
                ", location='" + location + '\'' +
                ", company='" + company + '\'' +
                ", province=" + (this.province.getProvinceName() != null ? this.province.getProvinceName() : "null") +
                '}';
    }
}