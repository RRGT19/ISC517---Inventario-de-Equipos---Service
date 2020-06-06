/*Roles*/
INSERT INTO roles (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO roles (role_id, role) VALUES (2, 'USER');

/*Users*/
INSERT INTO users (active, last_name, name, password, username, created_at)
  values (1, 'Gomez', 'Robert', '$2y$12$hbKAmhOYmhUeM3YHlwUx7uX4rRiIThj1LkRfngOEl1bIHY7RG3s.a', 'admin', '2020-6-1');

INSERT INTO user_role (user_id, role_id) values (1, 1);

/*Clients*/
INSERT INTO clients (identification, name, phone, photo, created_at) VALUES('00199887710', 'María Pimentel', '8293334444', null, '2020-6-1');
INSERT INTO clients (identification, name, phone, photo, created_at) VALUES('00199887112', 'Jose Berroa', '8098781043', null, '2020-6-1');
INSERT INTO clients (identification, name, phone, photo, created_at) VALUES('00190897658', 'Marta Cuello', '8092327843', null, '2020-6-1');
INSERT INTO clients (identification, name, phone, photo, created_at) VALUES('00119283329', 'Pedro Lora', '8493237654', null, '2020-6-1');

/*Families*/
INSERT INTO families (name, created_at) VALUES('Procesadores', '2020-6-1');
INSERT INTO families (name, created_at) VALUES('Sonido', '2020-6-1');
INSERT INTO families (name, created_at) VALUES('Discos Duros', '2020-6-1');
INSERT INTO families (name, created_at) VALUES('Memorias', '2020-6-1');
INSERT INTO families (name, created_at) VALUES('Tarjeta de Video', '2020-6-1');
INSERT INTO families (name, created_at) VALUES('Motherboard', '2020-6-1');
INSERT INTO families (name, created_at) VALUES('Monitores', '2020-6-1');

/*Subfamilies*/
INSERT INTO subfamilies (name, family_id, created_at) VALUES('Intel', 1, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('AMD', 1, '2020-6-1');

INSERT INTO subfamilies (name, family_id, created_at) VALUES('Bocinas', 2, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('Audífonos', 2, '2020-6-1');

INSERT INTO subfamilies (name, family_id, created_at) VALUES('Sata 3.5', 3, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('Sata 2.5', 3, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('SSD', 3, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('M2', 3, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('NVMe', 3, '2020-6-1');

INSERT INTO subfamilies (name, family_id, created_at) VALUES('DDR4', 4, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('DDR3', 4, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('DDR2', 4, '2020-6-1');

INSERT INTO subfamilies (name, family_id, created_at) VALUES('NVIDIA', 5, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('ATI', 5, '2020-6-1');

INSERT INTO subfamilies (name, family_id, created_at) VALUES('Intel', 6, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('AMD', 6, '2020-6-1');

INSERT INTO subfamilies (name, family_id, created_at) VALUES('27"', 7, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('25"', 7, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('24"', 7, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('23"', 7, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('22"', 7, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('20"', 7, '2020-6-1');
INSERT INTO subfamilies (name, family_id, created_at) VALUES('19"', 7, '2020-6-1');

/*Equipments*/
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(1, 'Intel Core i3', null, 100, 10, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(1, 'Intel Core i5', null, 200, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(1, 'Intel Core i7', null, 300, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(2, 'Ryzen 3 3400G', null, 50, 10, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(2, 'Ryzen 5 3400G', null, 100, 0, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(2, 'FX 8350 8 Core AM3', null, 250, 10, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(3, 'Logitech Z537', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(4, 'Apple AirPods 2', null, 250, 0, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(4, 'HeadSet Fantech Gaming RGB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(5, 'Seagate BarraCuda 2TB', null, 250, 10, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(5, 'Seagate IronWolf 4TB', null, 250, 0, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(6, 'Seagate BarraCuda 1TB', null, 250, 12, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(7, 'WD Blue 3D NAND 500GB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(7, 'Samsung SSD 860 EVO 1TB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(7, 'ADATA SU635 240GB', null, 250, 12, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(8, 'Kingston 1TB A2000', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(9, 'Samsung 970 EVO 1TB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(9, 'WD Blue SN550 1TB', null, 250, 12, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(10, 'Corsair Vengeance LPX 4GB', null, 250, 0, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(10, 'Corsair Vengeance LPX 8GB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(11, 'Corsair Vengeance LPX 8GB', null, 250, 28, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(13, 'EVGA GTX1060', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(13, 'EVGA GTX1650', null, 250, 28, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(13, 'EVGA GTX1660', null, 250, 28, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(14, 'RX 550 4GB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(14, 'RX 560 4GB', null, 250, 8, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(14, 'RX 570 4GB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(14, 'RX 580 8GB', null, 250, 8, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(14, 'RX 5700 8GB', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(15, 'Asus H110M-E', null, 250, 8, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(15, 'Biostar TB250-BTC', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(16, 'MSI B350M', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(16, 'Gigabyte 970 AM3', null, 250, 0, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(17, 'Samsung 27 Curvo 398', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(19, 'Acer 24 HDMI Gaming', null, 250, 3, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(19, 'Acer 24 ED242QR', null, 250, 11, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(21, 'Dell 22 P2217HC', null, 250, 20, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(21, 'Acer 22 1080p DVI', null, 250, 18, '2020-6-1');
INSERT INTO equipments (subfamily_id, name, photo, price_by_day, stock, created_at) VALUES(22, 'Dell 23 1080 DVI E2311H', null, 250, 14, '2020-6-1');

/*Rental #1*/
INSERT INTO rentals (rental_id, created_at, cost, date_of_return, status, client_id) VALUES(1, '2020-06-02', 0, '2020-07-22', 'PENDING', 1);
INSERT INTO rented_equipments (rented_equipment_id, created_at, is_returned, equipment_id, rental_id) VALUES(1, '2020-06-02', false, 1, 1);
INSERT INTO rented_equipments (rented_equipment_id, created_at, is_returned, equipment_id, rental_id) VALUES(2, '2020-06-02', false, 2, 1);
INSERT INTO rented_equipments (rented_equipment_id, created_at, is_returned, equipment_id, rental_id) VALUES(3, '2020-06-02', false, 3, 1);
/*Rental #2*/
INSERT INTO rentals (rental_id, created_at, cost, date_of_return, status, client_id) VALUES(2, '2020-06-01', 600, '2020-07-28', 'PAID', 2);
INSERT INTO rented_equipments (rented_equipment_id, created_at, is_returned, equipment_id, rental_id) VALUES(4, '2020-06-01', true, 4, 2);
INSERT INTO rented_equipments (rented_equipment_id, created_at, is_returned, equipment_id, rental_id) VALUES(5, '2020-06-01', true, 5, 2);
