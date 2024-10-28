-- Step 1: Drop existing tables to remove all data
DROP TABLE IF EXISTS monthly_production CASCADE;
DROP TABLE IF EXISTS yearly_production CASCADE;
DROP TABLE IF EXISTS safety_data CASCADE;
DROP TABLE IF EXISTS environmental_data CASCADE;
DROP TABLE IF EXISTS monitoring_stations CASCADE;
DROP TABLE IF EXISTS pollutants CASCADE;
DROP TABLE IF EXISTS mine_minerals CASCADE;
DROP TABLE IF EXISTS mines CASCADE;
DROP TABLE IF EXISTS minerals CASCADE;
DROP TABLE IF EXISTS provinces CASCADE;
DROP TABLE IF EXISTS exploration_projects CASCADE;

-- Step 2: Create provinces table
CREATE TABLE provinces (
    province_id SERIAL PRIMARY KEY,
    province_name VARCHAR(255) NOT NULL
);

-- Step 3: Create minerals table
CREATE TABLE minerals (
    mineral_id SERIAL PRIMARY KEY,
    mineral_name VARCHAR(255) NOT NULL
);

-- Step 4: Create mines table
CREATE TABLE mines (
    mine_id SERIAL PRIMARY KEY,
    mine_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    company VARCHAR(255) NOT NULL,
    province_id INT,
    FOREIGN KEY (province_id) REFERENCES provinces(province_id)
);


-- Step 12: Create mine_minerals junction table
CREATE TABLE mine_minerals (
    mine_id INT,
    mineral_id INT,
    PRIMARY KEY (mine_id, mineral_id),
    FOREIGN KEY (mine_id) REFERENCES mines(mine_id) ON DELETE CASCADE,
    FOREIGN KEY (mineral_id) REFERENCES minerals(mineral_id) ON DELETE CASCADE
);

-- Step 5: Create exploration_projects table
CREATE TABLE exploration_projects (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    mine_id INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    budget DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (mine_id) REFERENCES mines(mine_id)
);

-- Step 6: Create monitoring_stations table
CREATE TABLE monitoring_stations (
    station_id SERIAL PRIMARY KEY,
    station_name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    province_id INT,
    FOREIGN KEY (province_id) REFERENCES provinces(province_id)
);

-- Step 7: Create pollutants table
CREATE TABLE pollutants (
    pollutant_id SERIAL PRIMARY KEY,
    pollutant_name VARCHAR(255) NOT NULL,
    unit VARCHAR(50) NOT NULL,
    description TEXT
);

-- Step 8: Create environmental_data table
CREATE TABLE environmental_data (
    data_id SERIAL PRIMARY KEY,
    station_id INT,
    pollutant_id INT,
    date_recorded DATE NOT NULL,
    value DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (station_id) REFERENCES monitoring_stations(station_id),
    FOREIGN KEY (pollutant_id) REFERENCES pollutants(pollutant_id)
);

-- Step 9: Create safety_data table
CREATE TABLE safety_data (
    safety_id SERIAL PRIMARY KEY,
    mine_id INT,
    date_recorded DATE NOT NULL,
    lost_time_incidents INT NOT NULL,
    near_misses INT NOT NULL,
    FOREIGN KEY (mine_id) REFERENCES mines(mine_id)
);

-- Step 10: Create monthly_production table
CREATE TABLE monthly_production (
    production_id SERIAL PRIMARY KEY,
    project_id INT,
    mineral_id INT,
    year INT NOT NULL,
    month INT NOT NULL,
    target_production DECIMAL(10, 2) NOT NULL,
    actual_production DECIMAL(10, 2) NOT NULL,
    variance DECIMAL(10, 2),
    percent_to_goal DECIMAL(5, 2),
    FOREIGN KEY (project_id) REFERENCES exploration_projects(project_id),
    FOREIGN KEY (mineral_id) REFERENCES minerals(mineral_id)
);

-- Step 11: Create yearly_production table
CREATE TABLE yearly_production (
    yearly_production_id SERIAL PRIMARY KEY,
    project_id INT,
    mineral_id INT,
    year INT NOT NULL,
    total_target_production DECIMAL(10, 2) NOT NULL,
    total_actual_production DECIMAL(10, 2) NOT NULL,
    variance DECIMAL(10, 2),
    percent_to_goal DECIMAL(5, 2),
    FOREIGN KEY (project_id) REFERENCES exploration_projects(project_id),
    FOREIGN KEY (mineral_id) REFERENCES minerals(mineral_id)
);


