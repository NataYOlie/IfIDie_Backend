INSERT INTO `roles` (`id_role`, `role_name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `roles` (`id_role`, `role_name`) VALUES (2, 'ROLE_USER');

INSERT INTO `user` (`id_user`, `login`, `password`, `lastname`, `surname`) VALUES (1, 'admin', '$2a$12$m62bGQJLYx8q8MrYj4b0G.exOm2aUqPY7A2chM2Upe0NdcUlodJyu', 'Tramier', 'Nathalie');
INSERT INTO `user_roles` (`user_id_user`, `roles_id_role`)VALUES (1,1);

INSERT INTO `countries` (`id_country`, `country_name`) VALUES (1, 'FRANCE');

INSERT INTO `cities` (`id_city`, `city_name`) VALUES (1, 'Paris');
INSERT INTO `cities` (`id_city`, `city_name`) VALUES (2, 'Chevilly-Larue');
INSERT INTO `cities` (`id_city`, `city_name`) VALUES (3, 'Marseille');
INSERT INTO `cities` (`id_city`, `city_name`) VALUES (4, 'Strasbourg');
INSERT INTO `cities` (`id_city`, `city_name`) VALUES (5, 'Tours');

INSERT INTO `list_type` (`id_task_type`, `list_name`) VALUES (1, 'StepList');
INSERT INTO `list_type` (`id_task_type`, `list_name`) VALUES (2, 'EnVieList');
INSERT INTO `list_type` (`id_task_type`, `list_name`) VALUES (3, 'WebFindMeList');


