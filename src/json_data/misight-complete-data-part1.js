/*
===================================
MISIGHT API AND DATA REFERENCE
===================================

1. USERS
-------------------------
Description: Manages user accounts and authentication for the MiSight system
Primary Key: user_id

Endpoints:
GET    /api/users             - Retrieve all users
GET    /api/users/{id}        - Retrieve specific user
POST   /api/users             - Create new user
PUT    /api/users/{id}        - Update user
DELETE /api/users/{id}        - Delete user

Data:
{
    "users": [
        {
            "userId": 1,
            "username": "admin",
            "role": "ADMIN",
            "password": "$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2"
        },
        {
            "userId": 2,
            "username": "mine_admin",
            "role": "MINE_ADMIN",
            "password": "$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2"
        },
        {
            "userId": 3,
            "username": "user",
            "role": "USER",
            "password": "$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2"
        }
    ]
}

2. PRIVILEGES
-------------------------
Description: Defines access rights and permissions within the system
Primary Key: privilege_id

Endpoints:
GET    /api/privileges             - Retrieve all privileges
GET    /api/privileges/{id}        - Retrieve specific privilege
POST   /api/privileges             - Create new privilege
PUT    /api/privileges/{id}        - Update privilege
DELETE /api/privileges/{id}        - Delete privilege

Data:
{
    "privileges": [
        { "privilegeId": 1, "privilegeName": "ROLE_ADMIN" },
        { "privilegeId": 2, "privilegeName": "ROLE_USER" },
        { "privilegeId": 3, "privilegeName": "ROLE_MINE_ADMIN" },
        { "privilegeId": 4, "privilegeName": "VIEW_ENVIRONMENTAL_DATA" },
        { "privilegeId": 5, "privilegeName": "EDIT_ENVIRONMENTAL_DATA" },
        { "privilegeId": 6, "privilegeName": "VIEW_SAFETY_DATA" },
        { "privilegeId": 7, "privilegeName": "EDIT_SAFETY_DATA" },
        { "privilegeId": 8, "privilegeName": "VIEW_PRODUCTION_DATA" },
        { "privilegeId": 9, "privilegeName": "EDIT_PRODUCTION_DATA" }
    ]
}

3. USER_PRIVILEGES
-------------------------
Description: Links users to their assigned privileges
Primary Keys: user_id, privilege_id

Endpoints:
GET    /api/user-privileges                    - Get all user privilege assignments
POST   /api/user-privileges                    - Assign privilege to user
DELETE /api/user-privileges/{userId}/{privId}  - Remove privilege from user

Data:
{
    "user_privileges": [
        {"userId": 1, "privilegeId": 1},
        {"userId": 1, "privilegeId": 2},
        {"userId": 1, "privilegeId": 3},
        {"userId": 1, "privilegeId": 4},
        {"userId": 1, "privilegeId": 5},
        {"userId": 1, "privilegeId": 6},
        {"userId": 1, "privilegeId": 7},
        {"userId": 1, "privilegeId": 8},
        {"userId": 1, "privilegeId": 9},
        {"userId": 2, "privilegeId": 3},
        {"userId": 2, "privilegeId": 4},
        {"userId": 2, "privilegeId": 6},
        {"userId": 2, "privilegeId": 7},
        {"userId": 2, "privilegeId": 8},
        {"userId": 2, "privilegeId": 9},
        {"userId": 3, "privilegeId": 2},
        {"userId": 3, "privilegeId": 4},
        {"userId": 3, "privilegeId": 6},
        {"userId": 3, "privilegeId": 8}
    ]
}

4. PROVINCES
-------------------------
Description: Contains all Canadian provinces where mining operations are located
Primary Key: province_id

Endpoints:
GET    /api/provinces             - Retrieve all provinces
GET    /api/provinces/{id}        - Retrieve specific province
POST   /api/provinces             - Create new province
PUT    /api/provinces/{id}        - Update province
DELETE /api/provinces/{id}        - Delete province

Data:
{
    "provinces": [
        { "provinceId": 1, "provinceName": "Newfoundland and Labrador" },
        { "provinceId": 2, "provinceName": "British Columbia" },
        { "provinceId": 3, "provinceName": "Ontario" },
        { "provinceId": 4, "provinceName": "Quebec" },
        { "provinceId": 5, "provinceName": "Alberta" },
        { "provinceId": 6, "provinceName": "Saskatchewan" },
        { "provinceId": 7, "provinceName": "Nova Scotia" },
        { "provinceId": 8, "provinceName": "Manitoba" },
        { "provinceId": 9, "provinceName": "Yukon" },
        { "provinceId": 10, "provinceName": "Northwest Territories" },
        { "provinceId": 11, "provinceName": "Nunavut" }
    ]
}

