package com.example.CriptoProjeto.entity.enums;

import java.util.Arrays;

public enum EnumCripto {
    AAVE("aave","aave","Aave"),
    ALGORAND("algorand","algo","Algorand"),
    AVALANCHE2("avalanche-2","AVAX","Avalanche"),
    AXIEINFINITY("axie-infinity","axs","Axie Infinity"),
    BINANCEUSD("binance-usd","busd","Binance USD"),
    BINANCECOIN("binancecoin","bnb","Binance Coin"),
    BITCOIN("bitcoin","btc","Bitcoin"),
    BITCOINCASH("bitcoin-cash","bch","Bitcoin Cash"),
    BITCOINCASHSV("bitcoin-cash-sv","bsv","Bitcoin SV"),
    CARDANO("cardano","ada","Cardano"),
    CDAI("cdai","cdai","cDAI"),
    CHAINLINK("chainlink","link","Chainlink"),
    COMPOUNDETHER("compound-ether","ceth","cETH"),
    COMPOUNDUSDCOIN("compound-usd-coin","cusdc","cUSDC"),
    COSMOS("cosmos","atom","Cosmos"),
    CRYPTOCOMCHAIN("crypto-com-chain","cro","Crypto.com Coin"),
    DAI("dai","dai","Dai"),
    DOGECOIN("dogecoin","doge","Dogecoin"),
    ECASH("ecash","xec","eCash"),
    ELRONDERD2("elrond-erd-2","egld","Elrond"),
    EOS("eos","eos","EOS"),
    ETHEREUM("ethereum","eth","Ethereum"),
    ETHEREUMCLASSIC("ethereum-classic","etc","Ethereum Classic"),
    FANTOM("fantom","ftm","Fantom"),
    FILECOIN("filecoin","fil","Filecoin"),
    FLOW("flow","flow","Flow"),
    FTXTOKEN("ftx-token","ftt","FTX Token"),
    HARMONY("harmony","one","Harmony"),
    HEDERAHASHGRAPH("hedera-hashgraph","hbar","Hedera"),
    INTERNETCOMPUTER("internet-computer","icp","Internet Computer"),
    IOTA("iota","miota","IOTA"),
    KLAYTOKEN("klay-token","klay","Klaytn"),
    KUSAMA("kusama","ksm","Kusama"),
    LEOTOKEN("leo-token","leo","LEO Token"),
    LITECOIN("litecoin","ltc","Litecoin"),
    MATICNETWORK("matic-network","matic","Polygon"),
    MONERO("monero","xmr","Monero"),
    NEAR("near","near","Near"),
    NEO("neo","neo","NEO"),
    OKB("okb","okb","OKB"),
    OLYMPUS("olympus","ohm","Olympus"),
    PANCAKESWAPTOKEN("pancakeswap-token","cake","PancakeSwap"),
    POLKADOT("polkadot","dot","Polkadot"),
    QUANTNETWORK("quant-network","qnt","Quant"),
    RIPPLE("ripple","xrp","XRP"),
    SHIBAINU("shiba-inu","shib","Shiba Inu"),
    SOLANA("solana","sol","Solana"),
    STAKEDETHER("staked-ether","steth","Lido Staked Ether"),
    STELLAR("stellar","xlm","Stellar"),
    TERRALUNA("terra-luna","luna","Terra"),
    TETHER("tether","usdt","Tether"),
    TEZOS("tezos","xtz","Tezos"),
    THEGRAPH("the-graph","grt","The Graph"),
    THETATOKEN("theta-token","theta","Theta Network"),
    THORCHAIN("thorchain","rune","THORChain"),
    TRON("tron","trx","TRON"),
    UNISWAP("uniswap","uni","Uniswap"),
    USDCOIN("usd-coin","usdc","USD Coin"),
    VECHAIN("vechain","vet","VeChain"),
    WRAPPEDBITCOIN("wrapped-bitcoin","wbtc","Wrapped Bitcoin");

    private String id;
    private String symbol;
    private String name;

    EnumCripto(String id, String symbol, String name) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public static boolean isInEnum(String value, Class <EnumCripto> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e.getId().equals(value));
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }




}
