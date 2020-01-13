-- Movie table items
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2017-03-15', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2017-12-23', 'Superhero', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2020-08-21', 'Romance', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2021-07-02', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', '1', '2022-11-02', 'Superhero', '1');


-- user table items
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Siva');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ajay');


-- favorites table items
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '1');
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '3');
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '5');

/*View Movies List Admin (TYUC001)*/
select * from moviecruiser.movies;

/*View Movies List Customer (TYUC002)*/
select * from moviecruiser.movies where mo_active=1 and mo_date_of_launch>(select CURDATE());

/*Edit Movies (TYUC003)*/
select * from moviecruiser.movies where mo_id=1;

update moviecruiser.movies set mo_title='Avengers' where mo_id=5;

select mo_title,mo_gross,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from moviecruiser.movies inner join moviecruiser.favorites on ft_mo_id=mo_id where ft_us_id=1;

select count(*) as Number_of_favorites from moviecruiser.movies inner join moviecruiser.favorites on ft_mo_id=mo_id;

/*Remove Item from Cart (TYUC006)*/
use moviecruiser;
DELETE favorites FROM favorites
WHERE ft_us_id=1 AND ft_mo_id = 5 limit 1;