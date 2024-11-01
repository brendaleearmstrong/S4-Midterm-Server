/*
5. MINERALS
-------------------------
Description: Catalog of minerals being mined or processed at various locations
Primary Key: mineral_id

Endpoints:
GET    /api/minerals             - Retrieve all minerals
GET    /api/minerals/{id}        - Retrieve specific mineral
POST   /api/minerals             - Create new mineral
PUT    /api/minerals/{id}        - Update mineral
DELETE /api/minerals/{id}        - Delete mineral

Data:
{
    "minerals": [
        { "mineralId": 1, "mineralName": "Gold" },
        { "mineralId": 2, "mineralName": "Silver" },
        { "mineralId": 3, "mineralName": "Copper" },
        { "mineralId": 4, "mineralName": "Iron Ore" },
        { "mineralId": 5, "mineralName": "Zinc" },
        { "mineralId": 6, "mineralName": "Lead" },
        { "mineralId": 7, "mineralName": "Nickel" },
        { "mineralId": 8, "mineralName": "Aluminum" },
        { "mineralId": 9, "mineralName": "Lithium" },
        { "mineralId": 10, "mineralName": "Cobalt" },
        { "mineralId": 11, "mineralName": "Manganese" }
    ]
}

6. MINES
-------------------------
Description: Core information about mining operations and facilities
Primary Key: mine_id
Foreign Key: province_id references provinces(province_id)

Endpoints:
GET    /api/mines             - Retrieve all mines
GET    /api/mines/{id}        - Retrieve specific mine
POST   /api/mines             - Create new mine
PUT    /api/mines/{id}        - Update mine
PATCH  /api/mines/{id}        - Partial update of mine
DELETE /api/mines/{id}        - Delete mine

Data:
{
    "mines": [
        {
            "mineId": 1,
            "mineName": "Voiseys Bay Mine",
            "location": "Labrador City, NL",
            "company": "Vale Canada Limited",
            "provinceId": 1
        },
        {
            "mineId": 2,
            "mineName": "Long Harbour Processing Plant",
            "location": "Long Harbour, NL",
            "company": "Vale Canada Limited",
            "provinceId": 1
        },
        {
            "mineId": 3,
            "mineName": "Scully Mine",
            "location": "Wabush, NL",
            "company": "Tacora Resources",
            "provinceId": 1
        },
        {
            "mineId": 4,
            "mineName": "Brunswick Mine",
            "location": "Bathurst, NB",
            "company": "Glencore",
            "provinceId": 1
        },
        {
            "mineId": 5,
            "mineName": "Duck Pond Mine",
            "location": "Pilleys Island, NL",
            "company": "Teck Resources",
            "provinceId": 1
        },
        {
            "mineId": 6,
            "mineName": "Pine Cove Mine",
            "location": "Point Rousse, NL",
            "company": "Signal Gold",
            "provinceId": 1
        },
        {
            "mineId": 7,
            "mineName": "Little Deer Mine",
            "location": "Baie Verte, NL",
            "company": "Signal Gold",
            "provinceId": 1
        },
        {
            "mineId": 8,
            "mineName": "Hammerdown Mine",
            "location": "Baie Verte, NL",
            "company": "Marble Mountain Resources",
            "provinceId": 1
        },
        {
            "mineId": 9,
            "mineName": "Labrador Iron Mines",
            "location": "Sandy Lake, NL",
            "company": "Labrador Iron Mines Holdings Limited",
            "provinceId": 1
        },
        {
            "mineId": 10,
            "mineName": "Stoger Tight Mine",
            "location": "Baie Verte, NL",
            "company": "Signal Gold",
            "provinceId": 1
        },
        {
            "mineId": 11,
            "mineName": "Kami Project",
            "location": "Shemogue, NL",
            "company": "Champion Iron",
            "provinceId": 1
        },
        {
            "mineId": 12,
            "mineName": "Gullbridge Mine",
            "location": "Gullbridge, NL",
            "company": "Fjordland Exploration",
            "provinceId": 1
        },
        {
            "mineId": 13,
            "mineName": "Red Moon Potash",
            "location": "Grand Falls-Windsor, NL",
            "company": "Red Moon Resources",
            "provinceId": 1
        },
        {
            "mineId": 14,
            "mineName": "Crown Pillar Mine",
            "location": "Buchans, NL",
            "company": "Buchans Minerals",
            "provinceId": 1
        },
        {
            "mineId": 15,
            "mineName": "Sunnyside Mine",
            "location": "Sunnyside, NL",
            "company": "Sunnyside Mining Company",
            "provinceId": 1
        }
    ]
}

7. MINE_MINERALS
-------------------------
Description: Maps which minerals are extracted at each mine (Many-to-Many relationship)
Primary Keys: mine_id, mineral_id

Endpoints:
GET    /api/mine-minerals                    - Get all mine-mineral relationships
POST   /api/mine-minerals                    - Add mineral to mine
DELETE /api/mine-minerals/{mineId}/{minId}   - Remove mineral from mine

Data:
POST http://localhost:8080/api/mine-minerals?mineId=1&mineralId=7
POST http://localhost:8080/api/mine-minerals?mineId=1&mineralId=3
POST http://localhost:8080/api/mine-minerals?mineId=2&mineralId=7
POST http://localhost:8080/api/mine-minerals?mineId=3&mineralId=4
POST http://localhost:8080/api/mine-minerals?mineId=4&mineralId=5
POST http://localhost:8080/api/mine-minerals?mineId=5&mineralId=3
POST http://localhost:8080/api/mine-minerals?mineId=6&mineralId=1
POST http://localhost:8080/api/mine-minerals?mineId=7&mineralId=3
POST http://localhost:8080/api/mine-minerals?mineId=8&mineralId=1
POST http://localhost:8080/api/mine-minerals?mineId=9&mineralId=4
POST http://localhost:8080/api/mine-minerals?mineId=10&mineralId=1
POST http://localhost:8080/api/mine-minerals?mineId=11&mineralId=4
POST http://localhost:8080/api/mine-minerals?mineId=12&mineralId=3
POST http://localhost:8080/api/mine-minerals?mineId=13&mineralId=4
POST http://localhost:8080/api/mine-minerals?mineId=14&mineralId=2
POST http://localhost:8080/api/mine-minerals?mineId=15&mineralId=1

*/
