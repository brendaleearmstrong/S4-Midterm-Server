-- First, delete all data in the correct order
DELETE FROM monthly_production;
DELETE FROM yearly_production;
DELETE FROM safety_data;
DELETE FROM environmental_data;
DELETE FROM monitoring_stations;
DELETE FROM pollutants;
DELETE FROM mine_minerals;
DELETE FROM exploration_projects;
DELETE FROM mines;
DELETE FROM minerals;
DELETE FROM provinces;

-- Reset all sequences
ALTER SEQUENCE monthly_production_production_id_seq RESTART WITH 1;
ALTER SEQUENCE yearly_production_yearly_production_id_seq RESTART WITH 1;
ALTER SEQUENCE safety_data_safety_id_seq RESTART WITH 1;
ALTER SEQUENCE environmental_data_data_id_seq RESTART WITH 1;
ALTER SEQUENCE monitoring_stations_station_id_seq RESTART WITH 1;
ALTER SEQUENCE pollutants_pollutant_id_seq RESTART WITH 1;
ALTER SEQUENCE exploration_projects_project_id_seq RESTART WITH 1;
ALTER SEQUENCE mines_mine_id_seq RESTART WITH 1;
ALTER SEQUENCE minerals_mineral_id_seq RESTART WITH 1;
ALTER SEQUENCE provinces_province_id_seq RESTART WITH 1;

-- Insert all data in the correct order
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

INSERT INTO mines (mine_name, location, company, province_id) VALUES 
('Voiseys Bay Mine', 'Labrador City, NL', 'Vale Canada Limited', 1),           -- id: 1
('Long Harbour Processing Plant', 'Long Harbour, NL', 'Vale Canada Limited', 1), -- id: 2
('Scully Mine', 'Wabush, NL', 'Tacora Resources', 1),                          -- id: 3
('Brunswick Mine', 'Bathurst, NB', 'Glencore', 1),                             -- id: 4
('Duck Pond Mine', 'Pilleys Island, NL', 'Teck Resources', 1),                 -- id: 5
('Pine Cove Mine', 'Point Rousse, NL', 'Signal Gold', 1),                      -- id: 6
('Little Deer Mine', 'Baie Verte, NL', 'Signal Gold', 1),                      -- id: 7
('Hammerdown Mine', 'Baie Verte, NL', 'Marble Mountain Resources', 1),         -- id: 8
('Labrador Iron Mines', 'Sandy Lake, NL', 'Labrador Iron Mines Holdings Limited', 1), -- id: 9
('Stoger Tight Mine', 'Baie Verte, NL', 'Signal Gold', 1),                     -- id: 10
('Kami Project', 'Shemogue, NL', 'Champion Iron', 1),                          -- id: 11
('Gullbridge Mine', 'Gullbridge, NL', 'Fjordland Exploration', 1),             -- id: 12
('Red Moon Potash', 'Grand Falls-Windsor, NL', 'Red Moon Resources', 1),        -- id: 13
('Crown Pillar Mine', 'Buchans, NL', 'Buchans Minerals', 1),                   -- id: 14
('Sunnyside Mine', 'Sunnyside, NL', 'Sunnyside Mining Company', 1);            -- id: 15

INSERT INTO mine_minerals (mine_id, mineral_id) VALUES
(1, 7), (1, 3),  -- Voiseys Bay Mine - Nickel, Copper
(2, 7),          -- Long Harbour - Nickel
(3, 4),          -- Scully Mine - Iron Ore
(4, 5),          -- Brunswick Mine - Zinc
(5, 3),          -- Duck Pond Mine - Copper
(6, 1),          -- Pine Cove Mine - Gold
(7, 3),          -- Little Deer Mine - Copper
(8, 1),          -- Hammerdown Mine - Gold
(9, 4),          -- Labrador Iron Mines - Iron Ore
(10, 1),         -- Stoger Tight Mine - Gold
(11, 4),         -- Kami Project - Iron Ore
(12, 3),         -- Gullbridge Mine - Copper
(13, 4),         -- Red Moon Potash - Iron Ore
(14, 2),         -- Crown Pillar Mine - Silver
(15, 1);         -- Sunnyside Mine - Gold

INSERT INTO exploration_projects (project_name, mine_id, start_date, end_date, budget) VALUES 
('Voiseys Bay Expansion', 1, '2024-01-01', '2024-12-31', 2000000.00),           -- id: 1
('Long Harbour Nickel Processing', 2, '2024-02-01', '2025-02-01', 1500000.00),  -- id: 2
('Iron Ore Exploration', 3, '2024-03-15', '2025-03-15', 1200000.00),            -- id: 3
('Zinc Development', 4, '2024-04-20', '2025-04-20', 1000000.00),                -- id: 4
('Copper Exploration', 5, '2024-05-10', '2025-05-10', 1100000.00),              -- id: 5
('Gold Expansion Project', 6, '2024-06-01', '2025-06-01', 900000.00),           -- id: 6
('Copper Development', 7, '2024-07-01', '2025-07-01', 800000.00),               -- id: 7
('Gold Project Development', 8, '2024-08-01', '2025-08-01', 950000.00),         -- id: 8
('Iron Ore Development', 9, '2024-09-01', '2025-09-01', 1800000.00),            -- id: 9
('Gold Exploration Program', 10, '2024-10-01', '2025-10-01', 1500000.00),       -- id: 10
('Iron Ore Expansion', 11, '2024-11-01', '2025-11-01', 700000.00),              -- id: 11
('Copper Development Program', 12, '2024-12-01', '2025-12-01', 1300000.00),     -- id: 12
('Iron Ore Exploration', 13, '2024-01-15', '2025-01-15', 600000.00),            -- id: 13
('Silver Development', 14, '2024-02-20', '2025-02-20', 850000.00),              -- id: 14
('Gold Development Project', 15, '2024-03-25', '2025-03-25', 2200000.00);       -- id: 15

INSERT INTO monitoring_stations (station_name, location, province_id) VALUES 
('Wabush Station', 'Wabush, NL', 1),                    -- id: 1
('Labrador City Station', 'Labrador City, NL', 1),      -- id: 2
('Long Harbour Station', 'Long Harbour, NL', 1),        -- id: 3
('Baie Verte Station', 'Baie Verte, NL', 1),           -- id: 4
('Goose Bay Station', 'Goose Bay, NL', 1),             -- id: 5
('Pilleys Island Station', 'Pilleys Island, NL', 1),    -- id: 6
('Marble Mountain Station', 'Steady Brook, NL', 1);     -- id: 7

INSERT INTO pollutants (pollutant_name, unit, description) VALUES 
('PM2.5', 'µg/m³', 'Particulate Matter 2.5 micrometers or smaller'),    -- id: 1
('PM10', 'µg/m³', 'Particulate Matter 10 micrometers or smaller'),      -- id: 2
('NO2', 'ppb', 'Nitrogen Dioxide'),                                     -- id: 3
('SO2', 'ppb', 'Sulfur Dioxide'),                                      -- id: 4
('CO', 'ppm', 'Carbon Monoxide'),                                      -- id: 5
('Ozone', 'ppb', 'Ground-level Ozone'),                                -- id: 6
('VOCs', 'ppb', 'Volatile Organic Compounds'),                         -- id: 7
('NH3', 'ppb', 'Ammonia');                                            -- id: 8

INSERT INTO environmental_data (station_id, pollutant_id, date_recorded, value) VALUES 
-- Wabush Station readings
(1, 1, '2024-10-01', 25.5),
(1, 2, '2024-10-01', 15.2),
(1, 3, '2024-10-01', 10.1),
-- Labrador City Station readings
(2, 1, '2024-10-01', 22.3),
(2, 2, '2024-10-01', 14.8),
(2, 4, '2024-10-01', 5.6),
-- Long Harbour Station readings
(3, 1, '2024-10-01', 20.1),
(3, 5, '2024-10-01', 12.3),
(3, 6, '2024-10-01', 7.8),
-- Baie Verte Station readings
(4, 1, '2024-10-01', 23.4),
(4, 6, '2024-10-01', 8.0),
(4, 7, '2024-10-01', 18.5),
-- Follow-up readings for all stations
(1, 1, '2024-10-02', 26.2),
(2, 1, '2024-10-02', 23.1),
(3, 1, '2024-10-02', 21.5),
(4, 1, '2024-10-02', 24.0),
(5, 1, '2024-10-02', 22.8),
(6, 1, '2024-10-02', 23.3),
(7, 1, '2024-10-02', 21.9);

INSERT INTO safety_data (mine_id, date_recorded, lost_time_incidents, near_misses) VALUES 
(1, '2024-10-01', 2, 5),    -- Voiseys Bay Mine
(2, '2024-10-01', 0, 3),    -- Long Harbour Processing Plant
(3, '2024-10-01', 1, 0),    -- Scully Mine
(4, '2024-10-01', 3, 2),    -- Brunswick Mine
(5, '2024-10-01', 0, 1),    -- Duck Pond Mine
(6, '2024-10-01', 1, 4),    -- Pine Cove Mine
(7, '2024-10-01', 0, 2),    -- Little Deer Mine
(8, '2024-10-01', 2, 1),    -- Hammerdown Mine
(9, '2024-10-01', 0, 0),    -- Labrador Iron Mines
(10, '2024-10-01', 3, 3),   -- Stoger Tight Mine
(11, '2024-10-01', 1, 2),   -- Kami Project
(12, '2024-10-01', 0, 1),   -- Gullbridge Mine
(13, '2024-10-01', 2, 4),   -- Red Moon Potash
(14, '2024-10-01', 1, 3),   -- Crown Pillar Mine
(15, '2024-10-01', 0, 2);   -- Sunnyside Mine

-- First, clear existing production data
DELETE FROM yearly_production;
DELETE FROM monthly_production;

-- Create function for realistic variance (with seasonal adjustments)
CREATE OR REPLACE FUNCTION generate_production_variance(
    base_target numeric, 
    month int,
    variance_percent numeric DEFAULT 0.05
) RETURNS numeric AS $$
BEGIN
    -- Add seasonal variation: slightly lower production in winter months (1,2,12)
    -- and maintenance months (7), slightly higher in good weather months (5,6,8,9)
    RETURN base_target * (
        CASE 
            WHEN month IN (1, 2, 12) THEN 0.95 -- Winter impact
            WHEN month = 7 THEN 0.90 -- Maintenance month
            WHEN month IN (5, 6, 8, 9) THEN 1.05 -- Good weather
            ELSE 1.0
        END
    ) * (1 + (random() * variance_percent - variance_percent/2));
END;
$$ LANGUAGE plpgsql;

-- Insert monthly production data with realistic targets and variations
WITH monthly_targets AS (
    -- Iron Ore Operations (Large scale)
    SELECT 3 as project_id, 4 as mineral_id, 500000 as monthly_target, 
           'Scully Mine (Tacora)' as operation UNION ALL                -- 6M annual target
    SELECT 9, 4, 2000000, 'IOC' UNION ALL                              -- 24M annual target
    SELECT 11, 4, 300000, 'Kami Project' UNION ALL                     -- 3.6M annual target
    SELECT 13, 4, 200000, 'Red Moon' UNION ALL                         -- 2.4M annual target

    -- Nickel Operations (Medium-Large scale)
    SELECT 1, 7, 500000, 'Voiseys Bay' UNION ALL                       -- 6M annual target
    SELECT 2, 7, 400000, 'Long Harbour' UNION ALL                      -- 4.8M annual processing

    -- Copper Operations (Medium scale)
    SELECT 5, 3, 50000, 'Duck Pond' UNION ALL                          -- 600K annual
    SELECT 7, 3, 60000, 'Little Deer' UNION ALL                        -- 720K annual
    SELECT 12, 3, 45000, 'Gullbridge' UNION ALL                        -- 540K annual

    -- Zinc Operations
    SELECT 4, 5, 60000, 'Brunswick' UNION ALL                          -- 720K annual

    -- Gold Operations (Smaller tonnage)
    SELECT 6, 1, 50000, 'Pine Cove' UNION ALL                          -- 600K annual
    SELECT 8, 1, 20000, 'Hammerdown' UNION ALL                         -- 240K annual
    SELECT 10, 1, 35000, 'Stoger Tight' UNION ALL                      -- 420K annual
    SELECT 15, 1, 30000, 'Sunnyside' UNION ALL                         -- 360K annual

    -- Silver Operations
    SELECT 14, 2, 25000, 'Crown Pillar'                                -- 300K annual
)
INSERT INTO monthly_production (project_id, mineral_id, year, month, target_production, actual_production, variance, percent_to_goal)
SELECT 
    t.project_id,
    t.mineral_id,
    2024 as year,
    m.month,
    t.monthly_target as target_production,
    generate_production_variance(t.monthly_target, m.month) as actual_production,
    0 as variance,  -- Will update
    0 as percent_to_goal  -- Will update
FROM monthly_targets t
CROSS JOIN (SELECT generate_series(1, 10) as month) m;

-- Update variance and percent_to_goal
UPDATE monthly_production
SET variance = actual_production - target_production,
    percent_to_goal = (actual_production / target_production * 100);

-- Calculate YTD totals based on actual monthly data
INSERT INTO yearly_production (project_id, mineral_id, year, total_target_production, total_actual_production, variance, percent_to_goal)
SELECT 
    project_id,
    mineral_id,
    year,
    SUM(target_production) * (12.0/10.0) as total_target_production,  -- Annualized
    SUM(actual_production) * (12.0/10.0) as total_actual_production,  -- Annualized
    (SUM(actual_production) * (12.0/10.0)) - (SUM(target_production) * (12.0/10.0)) as variance,
    (SUM(actual_production) / SUM(target_production) * 100) as percent_to_goal
FROM monthly_production
WHERE year = 2024
GROUP BY project_id, mineral_id, year;

-- Verification queries

-- 1. Monthly production summary by mine
SELECT 
    m.project_id,
    mi.mine_name,
    min.mineral_name,
    m.month,
    ROUND(m.target_production::numeric, 2) as target,
    ROUND(m.actual_production::numeric, 2) as actual,
    ROUND(m.percent_to_goal::numeric, 2) as percent_to_goal
FROM monthly_production m
JOIN exploration_projects e ON m.project_id = e.project_id
JOIN mines mi ON e.mine_id = mi.mine_id
JOIN minerals min ON m.mineral_id = min.mineral_id
ORDER BY m.project_id, m.month;

-- 2. Yearly totals verification
SELECT 
    y.project_id,
    mi.mine_name,
    min.mineral_name,
    ROUND(y.total_target_production::numeric, 2) as yearly_target,
    ROUND(y.total_actual_production::numeric, 2) as yearly_actual,
    ROUND(y.percent_to_goal::numeric, 2) as percent_to_goal
FROM yearly_production y
JOIN exploration_projects e ON y.project_id = e.project_id
JOIN mines mi ON e.mine_id = mi.mine_id
JOIN minerals min ON y.mineral_id = min.mineral_id
ORDER BY y.project_id;

-- Clean up
DROP FUNCTION IF EXISTS generate_production_variance;