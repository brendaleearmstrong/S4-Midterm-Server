/*
13. MONTHLY_PRODUCTION
-------------------------
Description: Monthly production records for mining operations
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
        {
            "productionId": 2,
            "projectId": 3,
            "mineralId": 4,
            "year": 2024,
            "month": 2,
            "targetProduction": 500000,
            "actualProduction": 475000,
            "variance": -25000,
            "percentToGoal": 95
        },
        {
            "productionId": 3,
            "projectId": 9,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 2000000,
            "actualProduction": 1900000,
            "variance": -100000,
            "percentToGoal": 95
        },
        {
            "productionId": 4,
            "projectId": 9,
            "mineralId": 4,
            "year": 2024,
            "month": 2,
            "targetProduction": 2000000,
            "actualProduction": 1900000,
            "variance": -100000,
            "percentToGoal": 95
        },
        {
            "productionId": 5,
            "projectId": 11,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 300000,
            "actualProduction": 285000,
            "variance": -15000,
            "percentToGoal": 95
        },
        {
            "productionId": 6,
            "projectId": 11,
            "mineralId": 4,
            "year": 2024,
            "month": 2,
            "targetProduction": 300000,
            "actualProduction": 285000,
            "variance": -15000,
            "percentToGoal": 95
        },
        {
            "productionId": 7,
            "projectId": 13,
            "mineralId": 4,
            "year": 2024,
            "month": 1,
            "targetProduction": 200000,
            "actualProduction": 190000,
            "variance": -10000,
            "percentToGoal": 95
        },
        {
            "productionId": 8,
            "projectId": 13,
            "mineralId": 4,
            "year": 2024,
            "month": 2,
            "targetProduction": 200000,
            "actualProduction": 190000,
            "variance": -10000,
            "percentToGoal": 95
        },
        {
            "productionId": 9,
            "projectId": 1,
            "mineralId": 7,
            "year": 2024,
            "month": 1,
            "targetProduction": 500000,
            "actualProduction": 475000,
            "variance": -25000,
            "percentToGoal": 95
        },
        {
            "productionId": 10,
            "projectId": 1,
            "mineralId": 7,
            "year": 2024,
            "month": 2,
            "targetProduction": 500000,
            "actualProduction": 475000,
            "variance": -25000,
            "percentToGoal": 95
        },
        {
            "productionId": 11,
            "projectId": 2,
            "mineralId": 7,
            "year": 2024,
            "month": 1,
            "targetProduction": 400000,
            "actualProduction": 380000,
            "variance": -20000,
            "percentToGoal": 95
        },
        {
            "productionId": 12,
            "projectId": 2,
            "mineralId": 7,
            "year": 2024,
            "month": 2,
            "targetProduction": 400000,
            "actualProduction": 380000,
            "variance": -20000,
            "percentToGoal": 95
        },
        {
            "productionId": 13,
            "projectId": 5,
            "mineralId": 3,
            "year": 2024,
            "month": 1,
            "targetProduction": 50000,
            "actualProduction": 47500,
            "variance": -2500,
            "percentToGoal": 95
        },
        {
            "productionId": 14,
            "projectId": 5,
            "mineralId": 3,
            "year": 2024,
            "month": 2,
            "targetProduction": 50000,
            "actualProduction": 47500,
            "variance": -2500,
            "percentToGoal": 95
        },
        {
            "productionId": 15,
            "projectId": 7,
            "mineralId": 3,
            "year": 2024,
            "month": 1,
            "targetProduction": 60000,
            "actualProduction": 57000,
            "variance": -3000,
            "percentToGoal": 95
        },
        {
            "productionId": 16,
            "projectId": 7,
            "mineralId": 3,
            "year": 2024,
            "month": 2,
            "targetProduction": 60000,
            "actualProduction": 57000,
            "variance": -3000,
            "percentToGoal": 95
        },
        {
            "productionId": 17,
            "projectId": 12,
            "mineralId": 3,
            "year": 2024,
            "month": 1,
            "targetProduction": 45000,
            "actualProduction": 42750,
            "variance": -2250,
            "percentToGoal": 95
        },
        {
            "productionId": 18,
            "projectId": 12,
            "mineralId": 3,
            "year": 2024,
            "month": 2,
            "targetProduction": 45000,
            "actualProduction": 42750,
            "variance": -2250,
            "percentToGoal": 95
        },
        {
            "productionId": 19,
            "projectId": 4,
            "mineralId": 5,
            "year": 2024,
            "month": 1,
            "targetProduction": 60000,
            "actualProduction": 57000,
            "variance": -3000,
            "percentToGoal": 95
        },
        {
            "productionId": 20,
            "projectId": 4,
            "mineralId": 5,
            "year": 2024,
            "month": 2,
            "targetProduction": 60000,
            "actualProduction": 57000,
            "variance": -3000,
            "percentToGoal": 95
        }
    ]
}

14. YEARLY_PRODUCTION
-------------------------
Description: Annual production summaries
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
        },
        {
            "yearlyProductionId": 5,
            "projectId": 1,
            "mineralId": 7,
            "year": 2024,
            "totalTargetProduction": 6000000,
            "totalActualProduction": 5700000,
            "variance": -300000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 6,
            "projectId": 2,
            "mineralId": 7,
            "year": 2024,
            "totalTargetProduction": 4800000,
            "totalActualProduction": 4560000,
            "variance": -240000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 7,
            "projectId": 5,
            "mineralId": 3,
            "year": 2024,
            "totalTargetProduction": 600000,
            "totalActualProduction": 570000,
            "variance": -30000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 8,
            "projectId": 7,
            "mineralId": 3,
            "year": 2024,
            "totalTargetProduction": 720000,
            "totalActualProduction": 684000,
            "variance": -36000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 9,
            "projectId": 12,
            "mineralId": 3,
            "year": 2024,
            "totalTargetProduction": 540000,
            "totalActualProduction": 513000,
            "variance": -27000,
            "percentToGoal": 95
        },
        {
            "yearlyProductionId": 10,
            "projectId": 4,
            "mineralId": 5,
            "year": 2024,
            "totalTargetProduction": 720000,
            "totalActualProduction": 684000,
            "variance": -36000,
            "percentToGoal": 95
        }
    ]
}
*/
