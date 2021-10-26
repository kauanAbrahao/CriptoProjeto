SET FOREIGN_KEY_CHECKS = 0;

/* DO WHAT YOU NEED HERE */
ALTER TABLE tab_cripto MODIFY COLUMN ID_Cripto varchar(100);
ALTER TABLE tab_valor MODIFY COLUMN ID_Cripto varchar(100);
ALTER TABLE tab_valor_hist MODIFY COLUMN ID_Cripto varchar(100);
ALTER TABLE tab_extremos MODIFY COLUMN ID_Cripto varchar(100);
ALTER TABLE tab_cripto MODIFY COLUMN Nome_Cripto varchar(50);
ALTER TABLE tab_valor MODIFY COLUMN MKT_Cap BIGINT;
ALTER TABLE tab_valor_hist MODIFY COLUMN MKT_Cap BIGINT;
ALTER TABLE tab_valor MODIFY COLUMN Total_Volume BIGINT;
ALTER TABLE tab_valor_hist MODIFY COLUMN Total_Volume BIGINT;

SET FOREIGN_KEY_CHECKS = 1;

ALTER TABLE tab_cripto ADD Symbol Varchar(10);
ALTER TABLE tab_valor MODIFY COLUMN CRT_Price decimal(16,8);
ALTER TABLE tab_valor_hist MODIFY COLUMN CRT_Price decimal(16,8);

