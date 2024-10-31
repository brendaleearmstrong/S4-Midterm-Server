/*
8. EXPLORATION_PROJECTS
-------------------------
Description: Current and planned exploration projects at mining sites
Primary Key: project_id
Foreign Key: mine_id references mines(mine_id)

Endpoints:
GET    /api/exploration-projects             - Retrieve all projects
GET    /api/exploration-projects/{id}        - Retrieve specific project
POST   /api/exploration-projects             - Create new project
PUT    /api/exploration-projects/{id}        - Update project
DELETE /api/exploration-projects/{id}        - Delete project

Data:
{
    "exploration_projects": [
        {
            "projectId": 1,
            "projectName": "Voiseys Bay Expansion",
            "mineId": 1,
            "startDate": "2024-01-01",
            "endDate": "2024-12-31",
            "budget": 2000000.00
        },
        {
            "projectId": 2,
            "projectName": "Long Harbour Nickel Processing",
            "mineId": 2,
            "startDate": "2024-02-01",
            "endDate": "2025-02-01",
            "budget": 1500000.00
        },
        {
            "projectId": 3,
            "projectName": "Iron Ore Exploration",
            "mineId": 3,
            "startDate": "2024-03-15",
            "endDate": "2025-03-15",
            "budget": 1200000.00
        },
        {
            "projectId": 4,
            "projectName": "Zinc Development",
            "mineId": 4,
            "startDate": "2024-04-20",
            "endDate": "2025-04-20",
            "budget": 1000000.00
        },
        {
            "projectId": 5,
            "projectName": "Copper Exploration",
            "mineId": 5,
            "startDate": "2024-05-10",
            "endDate": "2025-05-10",
            "budget": 1100000.00
        },
        {
            "projectId": 6,
            "projectName": "Gold Expansion Project",
            "mineId": 6,
            "startDate": "2024-06-01",
            "endDate": "2025-06-01",
            "budget": 900000.00
        },
        {
            "projectId": 7,
            "projectName": "Copper Development",
            "mineId": 7,
            "startDate": "2024-07-01",
            "endDate": "2025-07-01",
            "budget": 800000.00
        },
        {
            "projectId": 8,
            "projectName": "Gold Project Development",
            "mineId": 8,
            "startDate": "2024-08-01",
            "endDate": "2025-08-01",
            "budget": 950000.00
        },
        {
            "projectId": 9,
            "projectName": "Iron Ore Development",
            "mineId": 9,
            "startDate": "2024-09-01",
            "endDate": "2025-09-01",
            "budget": 1800000.00
        },
        {
            "projectId": 10,
            "projectName": "Gold Exploration Program",
            "mineId": 10,
            "startDate": "2024-10-01",
            "endDate": "2025-10-01",
            "budget": 1500000.00
        },
        {
            "projectId": 11,
            "projectName": "Iron Ore Expansion",
            "mineId": 11,
            "startDate": "2024-11-01",
            "endDate": "2025-11-01",
            "budget": 700000.00
        },
        {
            "projectId": 12,
            "projectName": "Copper Development Program",
            "mineId": 12,
            "startDate": "2024-12-01",
            "endDate": "2025-12-01",
            "budget": 1300000.00
        },
        {
            "projectId": 13,
            "projectName": "Iron Ore Exploration",
            "mineId": 13,
            "startDate": "2024-01-15",
            "endDate": "2025-01-15",
            "budget": 600000.00
        },
        {
            "projectId": 14,
            "projectName": "Silver Development",
            "mineId": 14,
            "startDate": "2024-02-20",
            "endDate": "2025-02-20",
            "budget": 850000.00
        },
        {
            "projectId": 15,
            "projectName": "Gold Development Project",
            "mineId": 15,
            "startDate": "2024-03-25",
            "endDate": "2025-03-25",
            "budget": 2200000.00
        }
    ]
}

9. MONITORING_STATIONS
-------------------------
Description: Environmental monitoring stations locations and details
Primary Key: station_id
Foreign Key: province_id references provinces(province_id)

Endpoints:
GET    /api/monitoring-stations             - Retrieve all stations
GET    /api/monitoring-stations/{id}        - Retrieve specific station
POST   /api/monitoring-stations             - Create new station
PUT    /api/monitoring-stations/{id}        - Update station
DELETE /api/monitoring-stations/{id}        - Delete station

Data:
{
    "monitoring_stations": [
        {
            "stationId": 1,
            "stationName": "Wabush Station",
            "location": "Wabush, NL",
            "provinceId": 1
        },
        {
            "stationId": 2,
            "stationName": "Labrador City Station",
            "location": "Labrador City, NL",
            "provinceId": 1
        },
        {
            "stationId": 3,
            "stationName": "Long Harbour Station",
            "location": "Long Harbour, NL",
            "provinceId": 1
        },
        {
            "stationId": 4,
            "stationName": "Baie Verte Station",
            "location": "Baie Verte, NL",
            "provinceId": 1
        },
        {
            "stationId": 5,
            "stationName": "Goose Bay Station",
            "location": "Goose Bay, NL",
            "provinceId": 1
        },
        {
            "stationId": 6,
            "stationName": "Pilleys Island Station",
            "location": "Pilleys Island, NL",
            "provinceId": 1
        },
        {
            "stationId": 7,
            "stationName": "Marble Mountain Station",
            "location": "Steady Brook, NL",
            "provinceId": 1
        }
    ]
}

10. POLLUTANTS
-------------------------
Description: Types of pollutants monitored at environmental stations
Primary Key: pollutant_id

Endpoints:
GET    /api/pollutants             - Retrieve all pollutants
GET    /api/pollutants/{id}        - Retrieve specific pollutant
POST   /api/pollutants             - Create new pollutant
PUT    /api/pollutants/{id}        - Update pollutant
DELETE /api/pollutants/{id}        - Delete pollutant

Data:
{
    "pollutants": [
        {
            "pollutantId": 1,
            "pollutantName": "PM2.5",
            "unit": "µg/m³",
            "description": "Particulate Matter 2.5 micrometers or smaller"
        },
        {
            "pollutantId": 2,
            "pollutantName": "PM10",
            "unit": "µg/m³",
            "description": "Particulate Matter 10 micrometers or smaller"
        },
        {
            "pollutantId": 3,
            "pollutantName": "NO2",
            "unit": "ppb",
            "description": "Nitrogen Dioxide"
        },
        {
            "pollutantId": 4,
            "pollutantName": "SO2",
            "unit": "ppb",
            "description": "Sulfur Dioxide"
        },
        {
            "pollutantId": 5,
            "pollutantName": "CO",
            "unit": "ppm",
            "description": "Carbon Monoxide"
        },
        {
            "pollutantId": 6,
            "pollutantName": "Ozone",
            "unit": "ppb",
            "description": "Ground-level Ozone"
        },
        {
            "pollutantId": 7,
            "pollutantName": "VOCs",
            "unit": "ppb",
            "description": "Volatile Organic Compounds"
        },
        {
            "pollutantId": 8,
            "pollutantName": "NH3",
            "unit": "ppb",
            "description": "Ammonia"
        }
    ]
}

11. ENVIRONMENTAL_DATA
-------------------------
Description: Environmental readings from monitoring stations
Primary Key: data_id
Foreign Keys: station_id, pollutant_id

Endpoints:
GET    /api/environmental-data             - Retrieve all readings
GET    /api/environmental-data/{id}        - Retrieve specific reading
POST   /api/environmental-data             - Create new reading
PUT    /api/environmental-data/{id}        - Update reading
DELETE /api/environmental-data/{id}        - Delete reading

Data:
{
    "environmental_data": [
        {
            "dataId": 1,
            "stationId": 1,
            "pollutantId": 1,
            "dateRecorded": "2024-10-01",
            "value": 25.5
        },
        {
            "dataId": 2,
            "stationId": 1,
            "pollutantId": 2,
            "dateRecorded": "2024-10-01",
            "value": 15.2
        },
        {
            "dataId": 3,
            "stationId": 1,
            "pollutantId": 3,
            "dateRecorded": "2024-10-01",
            "value": 10.1
        },
        {
            "dataId": 4,
            "stationId": 2,
            "pollutantId": 1,
            "dateRecorded": "2024-10-01",
            "value": 22.3
        },
        {
            "dataId": 5,
            "stationId": 2,
            "pollutantId": 2,
            "dateRecorded": "2024-10-01",
            "value": 14.8
        },
        {
            "dataId": 6,
            "stationId": 2,
            "pollutantId": 4,
            "dateRecorded": "2024-10-01",
            "value": 5.6
        },
        {
            "dataId": 7,
            "stationId": 3,
            "pollutantId": 1,
            "dateRecorded": "2024-10-01",
            "value": 20.1
        },
        {
            "dataId": 8,
            "stationId": 3,
            "pollutantId": 5,
            "dateRecorded": "2024-10-01",
            "value": 12.3
        },
        {
            "dataId": 9,
            "stationId": 3,
            "pollutantId": 6,
            "dateRecorded": "2024-10-01",
            "value": 7.8
        },
        {
            "dataId": 10,
            "stationId": 4,
            "pollutantId": 1,
            "dateRecorded": "2024-10-01",
            "value": 23.4
        },
        {
            "dataId": 11,
            "stationId": 4,
            "pollutantId": 6,
            "dateRecorded": "2024-10-01",
            "value": 8.0
        },
        {
            "dataId": 12,
            "stationId": 4,
            "pollutantId": 7,
            "dateRecorded": "2024-10-01",
            "value": 18.5
        },
        {
            "dataId": 13,
            "stationId": 1,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 26.2
        },
        {
            "dataId": 14,
            "stationId": 2,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 23.1
        },
        {
            "dataId": 15,
            "stationId": 3,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 21.5
        },
        {
            "dataId": 16,
            "stationId": 4,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 24.0
        },
        {
            "dataId": 17,
            "stationId": 5,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 22.8
        },
        {
            "dataId": 18,
            "stationId": 6,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 23.3
        },
        {
            "dataId": 19,
            "stationId": 7,
            "pollutantId": 1,
            "dateRecorded": "2024-10-02",
            "value": 21.9
        }
    ]
}
*/
