INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (1, 'sku-1','upc-1','Name 1', 'Description 1', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (2, 'sku-2','upc-2','Name 2', 'Description 2', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (3, 'sku-3','upc-3','Name 3', 'Description 3', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (4, 'sku-4','upc-4','Name 4', 'Description 4', false);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (5, 'sku-5','upc-5','Name 5', 'Description 5', true);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (6, 'sku-6','upc-6','Name 6', 'Description 6', true);
INSERT INTO ITEM(id, sku, upc, item_name, description, preferred_only) VALUES (7, 'sku-7','upc-7','Name 7', 'Description 7', true);

INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred) VALUES (1, 'admin', 'pw', true, false, false);
INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred) VALUES (2, 'vendor', 'pw', false, true, false);
INSERT INTO USER(id, username, password, is_employee, is_vendor, is_preferred) VALUES (3, 'vendor_preferred', 'pw', false, true, true);