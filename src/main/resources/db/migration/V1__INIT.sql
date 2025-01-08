CREATE TABLE `clients` (
  `id` serial PRIMARY KEY,
  `name` varchar(200),
  `lastname` varchar(200),
  `birthdate` datetime,
  `age` integer,
  `create_at` datetime
);
