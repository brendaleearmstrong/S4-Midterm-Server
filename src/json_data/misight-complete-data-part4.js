/*
12. SAFETY_DATA
-------------------------
Description: Safety incident records for each mine
Primary Key: safety_id
Foreign Key: mine_id

Endpoints:
GET    /api/safety-data             - Retrieve all safety records
GET    /api/safety-data/{id}        - Retrieve specific record
POST   /api/safety-data             - Create new record
PUT    /api/safety-data/{id}        - Update record
DELETE /api/safety-data/{id}        - Delete record

Data:
{
    "safety_data": [
        {
            "safetyId": 1,
            "mineId": 1,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 2,
            "nearMisses": 5,
            "safetyLevel": "NEEDS_IMPROVEMENT"
        },
        {
            "safetyId": 2,
            "mineId": 2,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 0,
            "nearMisses": 3,
            "safetyLevel": "GOOD"
        },
        {
            "safetyId": 3,
            "mineId": 3,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 1,
            "nearMisses": 0,
            "safetyLevel": "FAIR"
        },
        {
            "safetyId": 4,
            "mineId": 4,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 3,
            "nearMisses": 2,
            "safetyLevel": "CRITICAL"
        },
        {
            "safetyId": 5,
            "mineId": 5,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 0,
            "nearMisses": 1,
            "safetyLevel": "EXCELLENT"
        },
        {
            "safetyId": 6,
            "mineId": 6,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 1,
            "nearMisses": 4,
            "safetyLevel": "FAIR"
        },
        {
            "safetyId": 7,
            "mineId": 7,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 0,
            "nearMisses": 2,
            "safetyLevel": "EXCELLENT"
        },
        {
            "safetyId": 8,
            "mineId": 8,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 2,
            "nearMisses": 1,
            "safetyLevel": "NEEDS_IMPROVEMENT"
        },
        {
            "safetyId": 9,
            "mineId": 9,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 0,
            "nearMisses": 0,
            "safetyLevel": "EXCELLENT"
        },
        {
            "safetyId": 10,
            "mineId": 10,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 3,
            "nearMisses": 3,
            "safetyLevel": "CRITICAL"
        },
        {
            "safetyId": 11,
            "mineId": 11,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 1,
            "nearMisses": 2,
            "safetyLevel": "FAIR"
        },
        {
            "safetyId": 12,
            "mineId": 12,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 0,
            "nearMisses": 1,
            "safetyLevel": "EXCELLENT"
        },
        {
            "safetyId": 13,
            "mineId": 13,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 2,
            "nearMisses": 4,
            "safetyLevel": "NEEDS_IMPROVEMENT"
        },
        {
            "safetyId": 14,
            "mineId": 14,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 1,
            "nearMisses": 3,
            "safetyLevel": "FAIR"
        },
        {
            "safetyId": 15,
            "mineId": 15,
            "dateRecorded": "2024-10-01",
            "lostTimeIncidents": 0,
            "nearMisses": 2,
            "safetyLevel": "EXCELLENT"
        }
    ]
}

13. MONTHLY_PRODUCTION
-------------------------
Description: Monthly production targets and actuals for each project
Primary Key: production_id
Foreign Keys: project_id, mineral_id

Endpoints:
GET    /api/monthly-production             - Retrieve all production data
GET    /api/monthly-production/{id}        - Retrieve specific record
POST   /api/monthly-production             - Create new record
PUT    /api/monthly-production/{id}        - Update record
DELETE /api/monthly-production/{id}        - Delete record

Data:
{
    "monthly_production": [
        // Iron Ore Operations
        // Scully Mine (Tacora) - 500,000 monthly base
        {
            "productionId": 1,
            "projectId": 3,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 500000,
            "actualProduction": 475000,
            "variance": -25000,
            "percentToGoal": 95
        },
        // IOC - 2,000,000 monthly base
        {
            "productionId": 2,
            "projectId": 9,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 2000000,
            "actualProduction": 1900000,
            "variance": -100000,
            "percentToGoal": 95
        },
        // Kami Project - 300,000 monthly base
        {
            "productionId": 3,
            "projectId": 11,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 300000,
            "actualProduction": 285000,
            "variance": -15000,
            "percentToGoal": 95
        },
        // Red Moon - 200,000 monthly base
        {
            "productionId": 4,
            "projectId": 13,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 200000,
            "actualProduction": 190000,
            "variance": -10000,
            "percentToGoal": 95
        },
        // Nickel Operations
        // Voiseys Bay - 500,000 monthly base
        {
            "productionId": 5,
            "projectId": 1,
            "mineralId": 7,
            "year": 2024,
            "month": 1,
            "targetProduction": 500000,
            "actualProduction": 475000,
            "variance": -25000,
            "percentToGoal": 95
        },
        // Long Harbour - 400,000 monthly base
        {
            "productionId": 6,
            "projectId": 2,
            "mineralId": 7,
            "year": 2024,
            "month": 1,
            "targetProduction": 400000,
            "actualProduction": 380000,
            "variance": -20000,
            "percentToGoal": 95
        }
        // ... Continuing with all mines and months
    ]
}

14. YEARLY_PRODUCTION
-------------------------
Description: Yearly production summaries and targets
Primary Key: yearly_production_id
Foreign Keys: project_id, mineral_id

Endpoints:
GET    /api/yearly-production             - Retrieve all yearly data
GET    /api/yearly-production/{id}        - Retrieve specific record
POST   /api/yearly-production             - Create new record
PUT    /api/yearly-production/{id}        - Update record
DELETE /api/yearly-production/{id}        - Delete record

Data:
{
    "yearly_production": [
        // Iron Ore Operations
        {
            "yearlyProductionId": 1,
            "projectId": 3,
            "mineralId": 4,
            "year": 2024,
            "totalTargetProduction": 6000000,
            "totalActualProduction": 5700000,
            "variance": -300000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 2,
            "projectId": 9,
            "mineralId": 4,
            "year": 2024,
            "totalTargetProduction": 24000000,
            "totalActualProduction": 22800000,
            "variance": -1200000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 3,
            "projectId": 11,
            "mineralId": 4,
            "year": 2024,
            "totalTargetProduction": 3600000,
            "totalActualProduction": 3420000,
            "variance": -180000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 4,
            "projectId": 13,
            "mineralId": 4,
            "year": 2024,
            "totalTargetProduction": 2400000,
            "totalActualProduction": 2280000,
            "variance": -120000,
            "percentToGoal": 95
        }
        // ... Continuing with all mining operations
    ]
}
*/
