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


INSERT INTO `task` (`id_task`,`default_task`, `description`, `external_link`, `header`,`previsional_date`, `subtype`, `task_color`, `validation_date`, `visible`, `list_type_id_task_type`, `user_id_user`) VALUES (1, true, 'C’est un point du testament mais qui peut être traité individuellement. ', 'https://www.demarches.interieur.gouv.fr/particuliers/peut-on-designer-personne-occuper-enfant-deces ', 'Garde des enfants', null, 'Famille', 'pastille-jaune', null, true, 1, 1);
INSERT INTO `task` (`id_task`,`default_task`, `description`, `external_link`, `header`,`previsional_date`, `subtype`, `task_color`, `validation_date`, `visible`, `list_type_id_task_type`, `user_id_user`) VALUES (2, true, 'Trouver une personne qui pourra les prendre en charge.', '', 'Animaux domestiques', null, 'Famille', 'pastille-jaune', null, true, 1, 1);
INSERT INTO `task` (`id_task`,`default_task`, `description`, `external_link`, `header`,`previsional_date`, `subtype`, `task_color`, `validation_date`, `visible`, `list_type_id_task_type`, `user_id_user`) VALUES (3, true, 'Identité :- carte d’identité, passeport, permis de conduire… - Directives anticipées - testament - Documents relatifs aux comptes bancaires, actifs, assurances vies actes de propriété carte grise carnets de santé / documents liés à la santé des enfants à charge ou des personnes dépendantes carnets de santé / documents liés à la santé des animaux de compagnies.', '', 'Documents à regrouper en un lieu centralisé, faire des copies etc : ', null, 'Administratif', 'pastille-bleu', null, true, 1, 1);



