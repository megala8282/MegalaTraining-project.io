/*menuitem tabel details*/
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99', '1', '2017-03-15', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2020-12-23', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2021-08-21', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', '0', '2022-07-02', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32', '1', '2022-11-02', 'Dessert', '1');

/*user tabel details*/
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'Siva');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ajay');

/*Add to Cart (TYUC004)*/
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES (1,1);
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES (1,3);
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES (1,5);

/*View Menu Item List Admin (TYUC001)*/
select * from truyum.menu_item;

/*View Menu Item List Customer (TYUC002)*/
select * from truyum.menu_item where me_active=1 and me_date_of_launch>(select CURDATE());

/*Edit Menu Item (TYUC003)*/
select * from truyum.menu_item where me_id=1;

update truyum.menu_item set me_name='Fries' where me_id=4;
update truyum.menu_item set me_active='0' where me_id=4;



select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from truyum.menu_item inner join truyum.cart on ct_me_id=me_id where ct_us_id=1;

select sum(me_price)as Total from truyum.menu_item inner join truyum.cart on ct_me_id=me_id;

/*Remove Item from Cart (TYUC006)*/
use truyum;
DELETE cart FROM cart WHERE ct_us_id=1 AND ct_me_id = 5 limit 1;

