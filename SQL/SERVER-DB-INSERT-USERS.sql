-- Insert initial users
INSERT INTO users (username, password, role) VALUES 
('admin', '$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2', 'ADMIN'),  -- password: admin123
('mine_admin', '$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2', 'MINE_ADMIN'),  -- password: admin123
('user', '$2a$10$xP3Zdv0tV0FCJHvmWPo3MONuEKwmBRPXxXwHlhQNo7C2uHHg6dTu2', 'USER');  -- password: admin123