package com.example.CriptoProjeto.entity.enums;

import java.util.Arrays;

public enum EnumCripto {
    AAVE("aave","aave","Aave"),
    ALGORAND("algorand","algo","Algorand"),
    AMPTOKEN("amp-token","amp","Amp"),
    ARWEAVE("arweave","ar","Arweave"),
    AVALANCHE("avalanche-2","AVAX","Avalanche"),
    AXIEINFINITY("axie-infinity","axs","Axie Infinity"),
    BINANCEUSD("binance-usd","busd","Binance USD"),
    BINANCECOIN("binancecoin","bnb","Binance Coin"),
    BITCOIN("bitcoin","btc","Bitcoin"),
    BITCOINCASH("bitcoin-cash","bch","Bitcoin Cash"),
    BITCOINCASHABC2("bitcoin-cash-abc-2","bcha","Bitcoin Cash ABC"),
    BITCOINCASHSV("bitcoin-cash-sv","bsv","Bitcoin SV"),
    BITTORRENT2("bittorrent-2","btt","BitTorrent"),
    BLOCKSTACK("blockstack","stx","Stacks"),
    CARDANO("cardano","ada","Cardano"),
    CDAI("cdai","cdai","cDAI"),
    CELO("celo","celo","Celo"),
    CELSIUSDEGREETOKEN("celsius-degree-token","cel","Celsius Network"),
    CHAINLINK("chainlink","link","Chainlink"),
    CHILIZ("chiliz","chz","Chiliz"),
    COMPOUNDETHER("compound-ether","ceth","cETH"),
    COMPOUNDGOVERNANCETOKEN("compound-governance-token","comp","Compound"),
    COMPOUNDUSDCOIN("compound-usd-coin","cusdc","cUSDC"),
    COSMOS("cosmos","atom","Cosmos"),
    CRYPTOCOMCHAIN("crypto-com-chain","cro","Crypto.com Coin"),
    CURVEDAOTOKEN("curve-dao-token","crv","Curve DAO Token"),
    DAI("dai","dai","Dai"),
    DASH("dash","dash","Dash"),
    DECRED("decred","dcr","Decred"),
    DOGECOIN("dogecoin","doge","Dogecoin"),
    ECASH("ecash","xec","eCash"),
    ECOMI("ecomi","omi","ECOMI"),
    ELRONDERD2("elrond-erd-2","egld","Elrond"),
    ENJINCOIN("enjincoin","enj","Enjin Coin"),
    EOS("eos","eos","EOS"),
    ETHEREUM("ethereum","eth","Ethereum"),
    ETHEREUMCLASSIC("ethereum-classic","etc","Ethereum Classic"),
    FANTOM("fantom","ftm","Fantom"),
    FILECOIN("filecoin","fil","Filecoin"),
    FLOW("flow","flow","Flow"),
    FTXTOKEN("ftx-token","ftt","FTX Token"),
    HARMONY("harmony","one","Harmony"),
    HAVVEN("havven","snx","Synthetix Network Token"),
    HEDERAHASHGRAPH("hedera-hashgraph","hbar","Hedera"),
    HELIUM("helium","hnt","Helium"),
    HOLOTOKEN("holotoken","hot","Holo"),
    HUOBIBTC("huobi-btc","hbtc","Huobi BTC"),
    HUOBITOKEN("huobi-token","ht","Huobi Token"),
    INTERNETCOMPUTER("internet-computer","icp","Internet Computer"),
    IOTA("iota","miota","IOTA"),
    KLAYTOKEN("klay-token","klay","Klaytn"),
    KUSAMA("kusama","ksm","Kusama"),
    LEOTOKEN("leo-token","leo","LEO Token"),
    LITECOIN("litecoin","ltc","Litecoin"),
    MAGICINTERNETMONEY("magic-internet-money","mim","Magic Internet Money"),
    MAKER("maker","mkr","Maker"),
    MATICNETWORK("matic-network","matic","Polygon"),
    MONERO("monero","xmr","Monero"),
    NEAR("near","near","Near"),
    NEM("nem","xem","NEM"),
    NEO("neo","neo","NEO"),
    NEXO("nexo","nexo","NEXO"),
    OKB("okb","okb","OKB"),
    OLYMPUS("olympus","ohm","Olympus"),
    OMISEGO("omisego","omg","OMG Network"),
    PANCAKESWAPTOKEN("pancakeswap-token","cake","PancakeSwap"),
    POLKADOT("polkadot","dot","Polkadot"),
    QUANTNETWORK("quant-network","qnt","Quant"),
    RIPPLE("ripple","xrp","XRP"),
    SHIBAINU("shiba-inu","shib","Shiba Inu"),
    SOLANA("solana","sol","Solana"),
    SPELLTOKEN("spell-token","spell","Spell Token"),
    STAKEDETHER("staked-ether","steth","Lido Staked Ether"),
    STELLAR("stellar","xlm","Stellar"),
    SUSHI("sushi","sushi","Sushi"),
    TERRALUNA("terra-luna","luna","Terra"),
    TERRAUSD("terrausd","ust","TerraUSD"),
    TETHER("tether","usdt","Tether"),
    TEZOS("tezos","xtz","Tezos"),
    THEGRAPH("the-graph","grt","The Graph"),
    THETAFUEL("theta-fuel","tfuel","Theta Fuel"),
    THETATOKEN("theta-token","theta","Theta Network"),
    THORCHAIN("thorchain","rune","THORChain"),
    TRON("tron","trx","TRON"),
    UNISWAP("uniswap","uni","Uniswap"),
    USDCOIN("usd-coin","usdc","USD Coin"),
    VECHAIN("vechain","vet","VeChain"),
    WAVES("waves","waves","Waves"),
    WRAPPEDBITCOIN("wrapped-bitcoin","wbtc","Wrapped Bitcoin"),
    ZCASH("zcash","zec","Zcash");

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
