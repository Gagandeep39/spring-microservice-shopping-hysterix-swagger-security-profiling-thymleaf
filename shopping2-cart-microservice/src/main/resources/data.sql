-- Insert data to cart

INSERT INTO  `cart` (`cart_id`,`status`,`user_id`) VALUES (22,'Completed',1);
INSERT INTO  `cart` (`cart_id`,`status`,`user_id`) VALUES (27,'Shopping',2);
INSERT INTO  `cart` (`cart_id`,`status`,`user_id`) VALUES (33,'Completed',1);
INSERT INTO  `cart` (`cart_id`,`status`,`user_id`) VALUES (36,'Completed',1);
INSERT INTO  `cart` (`cart_id`,`status`,`user_id`) VALUES (42,'Completed',1);
INSERT INTO  `cart` (`cart_id`,`status`,`user_id`) VALUES (43,'Completed',1);

-- Insert item to cart

INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (30,3,22,4);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (31,2,22,6);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (32,1,22,3);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (34,3,33,4);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (35,1,33,3);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (38,2,36,3);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (39,4,36,4);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (40,4,36,5);
INSERT INTO  `cart_item` (`cart_item_id`,`quantity`,`cart_id`,`product_details_id`) VALUES (41,14,36,6);