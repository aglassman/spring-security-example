INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred, can_report) VALUES (1, 'admin', 'pw', true, false, false, true);
INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred, can_report) VALUES (2, 'intern', 'pw', true, false, false, false);
INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred, can_report) VALUES (3, 'vendor', 'pw', false, true, false, false);
INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred, can_report) VALUES (4, 'vendor_preferred', 'pw', false, true, true, false);


INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (1, 'b-wid-orn','61056974352','Basic Orange Widget', 'A basic orange widget.', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (2, 'b-wid-blu','31318928313','Basic Blue Widget', 'A basic blue widget.', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (3, 'b-wid-gre','94726562387','Basic Green Widget', 'A basic green widget.', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (4, 'b-wid-yel','66123713600','Basic Yellow Widget', 'A basic yellow widget.', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (5, 'p-wid-orn','02286724312','Basic Orange Widget', 'A premium orange widget.', true);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (6, 'p-wid-blu','59320680250','Basic Blue Widget', 'A premium blue widget.', true);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (7, 'p-wid-grn','62510219396','Basic Green Widget', 'A premium green widget.', true);


INSERT INTO STOCK(id, location, item_id) VALUES (1, 'Milwaukee, WI', 1);
INSERT INTO STOCK(id, location, item_id) VALUES (2, 'Milwaukee, WI', 1);
INSERT INTO STOCK(id, location, item_id) VALUES (3, 'Madison, WI', 1);
INSERT INTO STOCK(id, location, item_id) VALUES (4, 'Chicago, IL', 1);
INSERT INTO STOCK(id, location, item_id) VALUES (5, 'Minneapolis, MN', 2);
INSERT INTO STOCK(id, location, item_id) VALUES (6, 'Milwaukee, WI', 2);
INSERT INTO STOCK(id, location, item_id) VALUES (7, 'Milwaukee, WI', 6);
INSERT INTO STOCK(id, location, item_id) VALUES (8, 'Chicago, IL', 6);