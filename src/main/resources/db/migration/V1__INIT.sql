CREATE TABLE `clients` (
  `id` serial PRIMARY KEY,
  `name` varchar(200),
  `lastname` varchar(200),
  `birthdate` datetime,
  `age` integer,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO clients (name, lastname, birthdate, age) values
('Joseph','McKenzie','1987-03-02 00:00:00',37),
('Bertrand','Schmidt','1977-03-02 00:00:00',47),
('Makayla','Lubowitz','1967-03-02 00:00:00',57),
('Curt','Rogahn','1997-03-02 00:00:00',27),
('Rashawn','Hagenes','1985-03-02 00:00:00',39),
('Adrian','Runolfsdottir','1983-03-02 00:00:00',40),
('Devyn','Parker','1987-03-02 00:00:00',37),
('Salvatore','Abbott','1995-03-02 00:00:00',29),
('Johann','Lang','2000-03-02 00:00:00',24),
('Duane','Grimes','2002-03-02 00:00:00',22);

