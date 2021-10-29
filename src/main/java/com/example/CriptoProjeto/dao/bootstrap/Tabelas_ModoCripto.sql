Create Database ModoCripto;

Use ModoCripto;

CREATE TABLE TAB_CRIPTO
(
    ID_Cripto VARCHAR(20) PRIMARY KEY,
    Nome_Cripto VARCHAR(20),
    MKT_Cap_Rank SMALLINT
);

CREATE TABLE TAB_VALOR
(
    ID_Cripto VARCHAR(20),
    CRT_Price DECIMAL,
    MKT_Cap INTEGER,
    Total_Volume INTEGER,
    DataHR_Inc TIMESTAMP,
    CONSTRAINT PK_TAB_VALOR PRIMARY KEY (ID_Cripto,DataHR_Inc)
);

CREATE TABLE TAB_VALOR_HIST
(
    ID_Cripto VARCHAR(20),
    Open_Price DECIMAL(16,8),
    Avg_Price DECIMAL(16,8),
    Close_Price DECIMAL(16,8),
    Open_Mkt_Cap BIGINT,
    Avg_Mkt_Cap BIGINT,
    Close_Mkt_Cap BIGINT,
    Total_Volume BIGINT,
    DataHR_Inc TIMESTAMP,
    CONSTRAINT PK_TAB_VALOR_HIST PRIMARY KEY (ID_Cripto,DataHR_Inc)
);

CREATE TABLE TAB_EXTREMOS
(
    ID_Cripto VARCHAR(20),
    High_Low BOOLEAN,
    Valor DECIMAL,
    DataHR_Inc TIMESTAMP,
    CONSTRAINT PK_TAB_EXTREMOS PRIMARY KEY (ID_Cripto,High_Low,DataHR_Inc)
);

-- Foreign Keys
ALTER TABLE TAB_VALOR
    ADD CONSTRAINT FK_TAB_CRIPTO_VALOR FOREIGN KEY (ID_Cripto) REFERENCES TAB_CRIPTO(ID_CRIPTO);

ALTER TABLE TAB_EXTREMOS
    ADD CONSTRAINT FK_TAB_CRIPTO_EXTREMOS FOREIGN KEY (ID_Cripto) REFERENCES TAB_CRIPTO(ID_CRIPTO);

ALTER TABLE TAB_VALOR_HIST
    ADD CONSTRAINT FK_TAB_CRIPTO_HIST FOREIGN KEY (ID_Cripto,
                                                   DataHR_Inc) REFERENCES TAB_Valor(ID_Cripto,
                                                                                    DataHR_Inc);

ALTER TABLE tab_cripto ADD Symbol Varchar(10);

ALTER TABLE tab_valor_hist MODIFY COLUMN Total_Volume BIGINT;
ALTER TABLE tab_valor_hist MODIFY COLUMN MKT_Cap BIGINT;
ALTER TABLE tab_valor MODIFY COLUMN CRT_Price decimal(16,8);
ALTER TABLE tab_valor_hist MODIFY COLUMN CRT_Price decimal(16,8);
