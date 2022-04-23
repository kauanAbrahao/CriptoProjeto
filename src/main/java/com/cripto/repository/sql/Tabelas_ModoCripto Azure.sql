CREATE TABLE TAB_CRIPTO
(
    ID_Cripto VARCHAR(100) PRIMARY KEY,
    Nome_Cripto VARCHAR(20),
    MKT_Cap_Rank SMALLINT
);

CREATE TABLE TAB_VALOR
(
    ID_Cripto VARCHAR(100),
    CRT_Price DECIMAL(16,8),
    MKT_Cap BIGINT,
    Total_Volume BIGINT,
    DataHR_Inc DATETIME,
    CONSTRAINT PK_TAB_VALOR PRIMARY KEY (ID_Cripto,DataHR_Inc)
);
DROP TABLE TAB_VALOR;


CREATE TABLE TAB_VALOR_HIST
(
    ID_Cripto VARCHAR(100),
    Open_Price DECIMAL(16,8),
    Avg_Price DECIMAL(16,8),
    Close_Price DECIMAL(16,8),
    Open_Mkt_Cap BIGINT,
    Avg_Mkt_Cap BIGINT,
    Close_Mkt_Cap BIGINT,
    Total_Volume BIGINT,
    DataHR_Inc DATETIME,
    CONSTRAINT PK_TAB_VALOR_HIST PRIMARY KEY (ID_Cripto,DataHR_Inc)
);

drop table tab_valor_hist;

CREATE TABLE TAB_EXTREMOS
(
    ID_Cripto VARCHAR(100),
    HIGH decimal(16,8),
    Low decimal(16,8),
    DataHR_Inc DATETIME,
    CONSTRAINT PK_TAB_EXTREMOS PRIMARY KEY (ID_Cripto,DataHR_Inc)
);



ALTER TABLE TAB_VALOR
    ADD CONSTRAINT FK_TAB_CRIPTO_VALOR FOREIGN KEY (ID_Cripto) REFERENCES TAB_CRIPTO(ID_CRIPTO);

ALTER TABLE TAB_EXTREMOS
    ADD CONSTRAINT FK_TAB_CRIPTO_EXTREMOS FOREIGN KEY (ID_Cripto) REFERENCES TAB_CRIPTO(ID_CRIPTO);

ALTER TABLE TAB_VALOR_HIST
    ADD CONSTRAINT FK_TAB_CRIPTO_HIST FOREIGN KEY (ID_Cripto) REFERENCES TAB_Cripto(ID_Cripto);

ALTER TABLE tab_cripto ADD Symbol Varchar(10);

INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('aave', 'Aave', 46, 'aave');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('algorand', 'Algorand', 20, 'algo');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('avalanche-2', 'Avalanche', 13, 'AVAX');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('axie-infinity', 'Axie Infinity', 26, 'axs');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('binance-usd', 'Binance USD', 18, 'busd');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('binancecoin', 'Binance Coin', 3, 'bnb');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('bitcoin', 'Bitcoin', 1, 'btc');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('bitcoin-cash', 'Bitcoin Cash', 19, 'bch');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('bitcoin-cash-sv', 'Bitcoin SV', 56, 'bsv');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('cardano', 'Cardano', 5, 'ada');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('cdai', 'cDAI', 50, 'cdai');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('chainlink', 'Chainlink', 14, 'link');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('compound-ether', 'cETH', 34, 'ceth');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('compound-usd-coin', 'cUSDC', 52, 'cusdc');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('cosmos', 'Cosmos', 22, 'atom');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('crypto-com-chain', 'Crypto.com Coin', 40, 'cro');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('dai', 'Dai', 29, 'dai');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('dogecoin', 'Dogecoin', 9, 'doge');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('ecash', 'eCash', 53, 'xec');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('elrond-erd-2', 'Elrond', 39, 'egld');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('eos', 'EOS', 44, 'eos');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('ethereum', 'Ethereum', 2, 'eth');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('ethereum-classic', 'Ethereum Classic', 30, 'etc');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('fantom', 'Fantom', 33, 'ftm');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('filecoin', 'Filecoin', 28, 'fil');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('flow', 'Flow', 47, 'flow');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('ftx-token', 'FTX Token', 27, 'ftt');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('harmony', 'Harmony', 59, 'one');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('hedera-hashgraph', 'Hedera', 38, 'hbar');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('internet-computer', 'Internet Computer', 25, 'icp');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('iota', 'IOTA', 51, 'miota');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('klay-token', 'Klaytn', 48, 'klay');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('kusama', 'Kusama', 54, 'ksm');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('leo-token', 'LEO Token', 58, 'leo');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('litecoin', 'Litecoin', 17, 'ltc');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('matic-network', 'Polygon', 21, 'matic');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('monero', 'Monero', 42, 'xmr');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('near', 'Near', 41, 'near');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('neo', 'NEO', 57, 'neo');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('okb', 'OKB', 32, 'okb');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('olympus', 'Olympus', 55, 'ohm');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('pancakeswap-token', 'PancakeSwap', 43, 'cake');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('polkadot', 'Polkadot', 8, 'dot');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('quant-network', 'Quant', 49, 'qnt');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('ripple', 'XRP', 7, 'xrp');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('shiba-inu', 'Shiba Inu', 12, 'shib');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('solana', 'Solana', 6, 'sol');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('staked-ether', 'Lido Staked Ether', 36, 'steth');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('stellar', 'Stellar', 24, 'xlm');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('terra-luna', 'Terra', 11, 'luna');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('tether', 'Tether', 4, 'usdt');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('tezos', 'Tezos', 37, 'xtz');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('the-graph', 'The Graph', 45, 'grt');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('theta-token', 'Theta Network', 35, 'theta');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('thorchain', 'THORChain', 60, 'rune');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('tron', 'TRON', 31, 'trx');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('uniswap', 'Uniswap', 15, 'uni');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('usd-coin', 'USD Coin', 10, 'usdc');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('vechain', 'VeChain', 23, 'vet');
INSERT INTO tab_cripto (ID_Cripto, Nome_Cripto, MKT_Cap_Rank, Symbol) VALUES ('wrapped-bitcoin', 'Wrapped Bitcoin', 16, 'wbtc');


s


