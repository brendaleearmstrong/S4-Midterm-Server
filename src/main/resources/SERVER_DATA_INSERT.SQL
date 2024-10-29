-- First, delete all data in the correct order
DELETE FROM monthly_production;
DELETE FROM yearly_production;
DELETE FROM safety_data;
DELETE FROM environmental_data;
DELETE FROM user_privileges;
DELETE FROM monitoring_stations;
DELETE FROM pollutants;
DELETE FROM mine_minerals;
DELETE FROM exploration_projects;
DELETE FROM mines;
DELETE FROM minerals;
DELETE FROM provinces;
DELETE FROM privileges;
DELETE FROM users;

-- Reset all sequences
ALTER SEQUENCE monthly_production_production_id_seq RESTART WITH 1;
ALTER SEQUENCE yearly_production_production_id_seq RESTART WITH 1;
ALTER SEQUENCE safety_data_safety_id_seq RESTART WITH 1;
ALTER SEQUENCE environmental_data_data_id_seq RESTART WITH 1;
ALTER SEQUENCE monitoring_stations_station_id_seq RESTART WITH 1;
ALTER SEQUENCE pollutants_pollutant_id_seq RESTART WITH 1;
ALTER SEQUENCE exploration_projects_project_id_seq RESTART WITH 1;
ALTER SEQUENCE mines_mine_id_seq RESTART WITH 1;
ALTER SEQUENCE minerals_mineral_id_seq RESTART WITH 1;
ALTER SEQUENCE provinces_province_id_seq RESTART WITH 1;
ALTER SEQUENCE privileges_privilege_id_seq RESTART WITH 1;
ALTER SEQUENCE users_user_id_seq RESTART WITH 1;

-- Insert users and privileges
INSERT INTO users (username, password, role) VALUES
('admin', '$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2', 'ADMIN'),  -- password: admin123
('mine_admin', '$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2', 'MINE_ADMIN'),  -- password: admin123
('user', '$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2', 'USER');  -- password: admin123

INSERT INTO privileges (privilege_name) VALUES
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_MINE_ADMIN'),
('VIEW_ENVIRONMENTAL_DATA'),
('EDIT_ENVIRONMENTAL_DATA'),
('VIEW_SAFETY_DATA'),
('EDIT_SAFETY_DATA'),
('VIEW_PRODUCTION_DATA'),
('EDIT_PRODUCTION_DATA');

-- Link users to privileges
INSERT INTO user_privileges (user_id, privilege_id)
SELECT u.user_id, p.privilege_id
FROM users u
CROSS JOIN privileges p
WHERE u.username = 'admin';

INSERT INTO user_privileges (user_id, privilege_id)
SELECT u.user_id, p.privilege_id
FROM users u
CROSS JOIN privileges p
WHERE u.username = 'mine_admin'
AND p.privilege_name IN ('VIEW_ENVIRONMENTAL_DATA', 'VIEW_SAFETY_DATA', 'VIEW_PRODUCTION_DATA', 'EDIT_SAFETY_DATA', 'EDIT_PRODUCTION_DATA', 'ROLE_MINE_ADMIN');

INSERT INTO user_privileges (user_id, privilege_id)
SELECT u.user_id, p.privilege_id
FROM users u
CROSS JOIN privileges p
WHERE u.username = 'user'
AND p.privilege_name IN ('VIEW_ENVIRONMENTAL_DATA', 'VIEW_SAFETY_DATA', 'VIEW_PRODUCTION_DATA', 'ROLE_USER');

-- Insert base data for provinces
INSERT INTO provinces (province_name) VALUES
('Newfoundland and Labrador'),  -- id: 1
('British Columbia'),           -- id: 2
('Ontario'),                    -- id: 3
('Quebec'),                     -- id: 4
('Alberta'),                    -- id: 5
('Saskatchewan'),               -- id: 6
('Nova Scotia'),                -- id: 7
('Manitoba'),                   -- id: 8
('Yukon'),                      -- id: 9
('Northwest Territories'),      -- id: 10
('Nunavut');                    -- id: 11

-- Insert base data for minerals
INSERT INTO minerals (mineral_name) VALUES
('Gold'),          -- id: 1
('Silver'),        -- id: 2
('Copper'),        -- id: 3
('Iron Ore'),      -- id: 4
('Zinc'),          -- id: 5
('Lead'),          -- id: 6
('Nickel'),        -- id: 7
('Aluminum'),      -- id: 8
('Lithium'),       -- id: 9
('Cobalt'),        -- id: 10
('Manganese');     -- id: 11

-- Insert data for mines
INSERT INTO mines (mine_name, location, company, province_id) VALUES
('Voiseys Bay Mine', 'Labrador City, NL', 'Vale Canada Limited', 1),
('Long Harbour Processing Plant', 'Long Harbour, NL', 'Vale Canada Limited', 1),
('Scully Mine', 'Wabush, NL', 'Tacora Resources', 1),
('Brunswick Mine', 'Bathurst, NB', 'Glencore', 1),
('Duck Pond Mine', 'Pilleys Island, NL', 'Teck Resources', 1),
('Pine Cove Mine', 'Point Rousse, NL', 'Signal Gold', 1),
('Little Deer Mine', 'Baie Verte, NL', 'Signal Gold', 1),
('Hammerdown Mine', 'Baie Verte, NL', 'Marble Mountain Resources', 1),
('Labrador Iron Mines', 'Sandy Lake, NL', 'Labrador Iron Mines Holdings Limited', 1),
('Stoger Tight Mine', 'Baie Verte, NL', 'Signal Gold', 1),
('Kami Project', 'Shemogue, NL', 'Champion Iron', 1),
('Gullbridge Mine', 'Gullbridge, NL', 'Fjordland Exploration', 1),
('Red Moon Potash', 'Grand Falls-Windsor, NL', 'Red Moon Resources', 1),
('Crown Pillar Mine', 'Buchans, NL', 'Buchans Minerals', 1),
('Sunnyside Mine', 'Sunnyside, NL', 'Sunnyside Mining Company', 1);

-- Insert data for mine_minerals relationships
INSERT INTO mine_minerals (mine_id, mineral_id) VALUES
(1, 7), (1, 3),
(2, 7),
(3, 4),
(4, 5),
(5, 3),
(6, 1),
(7, 3),
(8, 1),
(9, 4),
(10, 1),
(11, 4),
(12, 3),
(13, 4),
(14, 2),
(15, 1);

-- Insert data for exploration projects
INSERT INTO exploration_projects (project_name, mine_id, start_date, end_date, budget) VALUES
('Voiseys Bay Expansion', 1, '2024-01-01', '2024-12-31', 2000000.00),
('Long Harbour Nickel Processing', 2, '2024-02-01', '2025-02-01', 1500000.00),
('Iron Ore Exploration', 3, '2024-03-15', '2025-03-15', 1200000.00),
('Zinc Development', 4, '2024-04-20', '2025-04-20', 1000000.00),
('Copper Exploration', 5, '2024-05-10', '2025-05-10', 1100000.00),
('Gold Expansion Project', 6, '2024-06-01', '2025-06-01', 900000.00),
('Copper Development', 7, '2024-07-01', '2025-07-01', 800000.00),
('Gold Project Development', 8, '2024-08-01', '2025-08-01', 950000.00),
('Iron Ore Development', 9, '2024-09-01', '2025-09-01', 1800000.00),
('Gold Exploration Program', 10, '2024-10-01', '2025-10-01', 1500000.00),
('Iron Ore Expansion', 11, '2024-11-01', '2025-11-01', 700000.00),
('Copper Development Program', 12, '2024-12-01', '2025-12-01', 1300000.00),
('Iron Ore Exploration', 13, '2024-01-15', '2025-01-15', 600000.00),
('Silver Development', 14, '2024-02-20', '2025-02-20', 850000.00),
('Gold Development Project', 15, '2024-03-25', '2025-03-25', 2200000.00);

-- Insert data for monitoring stations
INSERT INTO monitoring_stations (station_name, location, province_id) VALUES
('Wabush Station', 'Wabush, NL', 1),
('Labrador City Station', 'Labrador City, NL', 1),
('Long Harbour Station', 'Long Harbour, NL', 1),
('Baie Verte Station', 'Baie Verte, NL', 1),
('Goose Bay Station', 'Goose Bay, NL', 1),
('Pilleys Island Station', 'Pilleys Island, NL', 1),
('Marble Mountain Station', 'Steady Brook, NL', 1);

-- Insert data for pollutants
INSERT INTO pollutants (pollutant_name, unit, description) VALUES
('PM2.5', 'µg/m³', 'Particulate Matter 2.5 micrometers or smaller'),
('PM10', 'µg/m³', 'Particulate Matter 10 micrometers or smaller'),
('NO2', 'ppb', 'Nitrogen Dioxide'),
('SO2', 'ppb', 'Sulfur Dioxide'),
('CO', 'ppm', 'Carbon Monoxide'),
('Ozone', 'ppb', 'Ground-level Ozone'),
('VOCs', 'ppb', 'Volatile Organic Compounds'),
('NH3', 'ppb', 'Ammonia');

-- Insert base environmental data
INSERT INTO environmental_data (station_id, pollutant_id, date_recorded, value) VALUES
(1, 1, '2024-10-01', 25.5),
(1, 2, '2024-10-01', 15.2),
(1, 3, '2024-10-01', 10.1),
(2, 1, '2024-10-01', 22.3),
(2, 2, '2024-10-01', 14.8),
(2, 4, '2024-10-01', 5.6),
(3, 1, '2024-10-01', 20.1),
(3, 5, '2024-10-01', 12.3),
(3, 6, '2024-10-01', 7.8),
(4, 1, '2024-10-01', 23.4),
(4, 6, '2024-10-01', 8.0),
(4, 7, '2024-10-01', 18.5);

-- Insert safety data with safety levels (alter table if needed)
ALTER TABLE safety_data ADD COLUMN IF NOT EXISTS safety_level VARCHAR(255);

INSERT INTO safety_data (mine_id, date_recorded, lost_time_incidents, near_misses, safety_level) VALUES
(1, '2024-10-01', 2, 5, 'NEEDS_IMPROVEMENT'),
(2, '2024-10-01', 0, 3, 'GOOD'),
(3, '2024-10-01', 1, 0, 'FAIR'),
(4, '2024-10-01', 3, 2, 'CRITICAL'),
(5, '2024-10-01', 0, 1, 'EXCELLENT'),
(6, '2024-10-01', 1, 4, 'FAIR');

-- Populate production tables with realistic variance using the function
CREATE OR REPLACE FUNCTION generate_production_variance(base_target NUMERIC, month INT, variance_percent NUMERIC DEFAULT 0.05) RETURNS NUMERIC AS $$
BEGIN
    RETURN base_target * (
        CASE
            WHEN month IN (1, 2, 12) THEN 0.95
            WHEN month = 7 THEN 0.90
            WHEN month IN (5, 6, 8, 9) THEN 1.05
            ELSE 1.0
        END
    ) * (1 + (random() * variance_percent - variance_percent/2));
END;
$$ LANGUAGE plpgsql;

-- Generate monthly production data and populate yearly totals
WITH monthly_targets AS (
    SELECT 3 as project_id, 4 as mineral_id, 500000 as monthly_target UNION ALL
    SELECT 9, 4, 2000000 UNION ALL
    SELECT 11, 4, 300000 UNION ALL
    SELECT 13, 4, 200000 UNION ALL
    SELECT 1, 7, 500000 UNION ALL
    SELECT 2, 7, 400000 UNION ALL
    SELECT 5, 3, 50000 UNION ALL
    SELECT 7, 3, 60000 UNION ALL
    SELECT 12, 3, 45000 UNION ALL
    SELECT 4, 5, 60000 UNION ALL
    SELECT 6, 1, 50000 UNION ALL
    SELECT 8, 1, 20000 UNION ALL
    SELECT 10, 1, 35000 UNION ALL
    SELECT 15, 1, 30000 UNION ALL
    SELECT 14, 2, 25000
)
INSERT INTO monthly_production (project_id, mineral_id, year, month, target_production, actual_production, variance, percent_to_goal)
SELECT
    t.project_id,
    t.mineral_id,
    2024 AS year,
    m.month,
    t.monthly_target,
    generate_production_variance(t.monthly_target, m.month) AS actual_production,
    0 AS variance,
    0 AS percent_to_goal
FROM monthly_targets t
CROSS JOIN (SELECT generate_series(1, 12) AS month) m;

-- Update variance and percent_to_goal for each row in monthly_production
UPDATE monthly_production
SET variance = actual_production - target_production,
    percent_to_goal = (actual_production / target_production * 100);

-- Aggregate to yearly production based on monthly data
INSERT INTO yearly_production (project_id, mineral_id, year, total_target_production, total_actual_production, variance, percent_to_goal)
SELECT
    project_id,
    mineral_id,
    year,
    SUM(target_production) AS total_target_production,
    SUM(actual_production) AS total_actual_production,
    SUM(actual_production) - SUM(target_production) AS variance,
    (SUM(actual_production) / SUM(target_production) * 100) AS percent_to_goal
FROM monthly_production
GROUP BY project_id, mineral_id, year;
