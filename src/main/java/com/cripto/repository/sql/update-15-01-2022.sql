
CREATE PROCEDURE proc_insertTabValor @cripto_id varchar(100), @CRT_Price decimal(16,8), @MKT_Cap bigint, @Total_Volume bigint
AS
IF  (SELECT COUNT(ID_Cripto) FROM TAB_CRIPTO where ID_Cripto = @cripto_id) > 0
  INSERT INTO TAB_VALOR VALUES (@cripto_id, @CRT_Price, @MKT_Cap, @Total_Volume, GETDATE())
GO


CREATE PROCEDURE proc_insertTabExtremos @cripto_id varchar(100), @High decimal(16,8), @Low decimal(16,8)
AS
IF  (SELECT COUNT(ID_Cripto) FROM TAB_CRIPTO where ID_Cripto = @cripto_id) > 0
  INSERT INTO TAB_EXTREMOS VALUES (@cripto_id, @High, @Low, GETDATE())
GO
