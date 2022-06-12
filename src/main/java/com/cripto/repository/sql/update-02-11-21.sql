ALTER TABLE tab_extremos DROP COLUMN High_Low;
ALTER TABLE tab_extremos DROP COLUMN Valor;
ALTER TABLE tab_extremos ADD COLUMN High decimal(16,8);
ALTER TABLE tab_extremos ADD COLUMN Low decimal(16,8);