DELIMITER //
CREATE PROCEDURE TO_VALOR_HIST()
BEGIN
INSERT INTO Tab_valor_hist(ID_Cripto, Open_Price, Avg_Price, Close_Price, Open_Mkt_Cap, Avg_Mkt_Cap, Close_Mkt_Cap, Total_Volume, DataHR_Inc)
WITH CTE_MIN_PRICE AS (
    SELECT
        ID_Cripto,
        CRT_Price as Lower_Price,
        ROW_NUMBER() over (PARTITION BY ID_Cripto ORDER BY CRT_Price asc) row_num
    FROM
        tab_valor
),
CTE_MAX_PRICE AS (
    SELECT
        ID_Cripto,
        CRT_Price as Higher_Price,
        ROW_NUMBER() over (PARTITION BY ID_Cripto ORDER BY CRT_Price DESC) row_num
    FROM
        tab_valor
     ),
CTE_AVG_PRICE AS (
    SELECT
        ID_Cripto,
        AVG(CRT_PRICE) AS AVG_PRICE
    FROM
        TAB_VALOR
    GROUP BY
        ID_Cripto
),
CTE_MIN_MKT_CAP AS (
    SELECT
        ID_Cripto,
        MKT_Cap as Min_Mkt_Cap,
        ROW_NUMBER() over (PARTITION BY ID_Cripto ORDER BY CRT_Price ASC) row_num
    FROM
        tab_valor
),
CTE_AVG_MKT_CAP AS (
    SELECT
        ID_Cripto,
        AVG(MKT_Cap) as Avg_Mkt_Cap
    FROM
        tab_valor
    GROUP BY
        ID_CRIPTO
),
CTE_MAX_MKT_CAP AS (
    SELECT
        ID_Cripto,
        MKT_Cap as Max_Mkt_Cap,
        ROW_NUMBER() over (PARTITION BY ID_Cripto ORDER BY CRT_Price DESC) row_num
    FROM
        tab_valor
),
CTE_TOTAL_VOLUME AS (
    SELECT
        ID_Cripto,
        MAX(Total_Volume) as Total_Volume
    FROM
        tab_valor
    GROUP BY
        ID_Cripto
)
select p_min.id_cripto,
       p_min.lower_price,
       p_avg.avg_price,
       p_max.higher_price,
       m_min.Min_Mkt_Cap,
       m_avg.Avg_Mkt_Cap,
       m_max.Max_Mkt_Cap,
       tv.total_volume,
       DATE_FORMAT(current_timestamp(),'%Y/%m/%d')
from
     cte_min_price p_min
inner join
    cte_max_price p_max on p_min.id_cripto = p_max.id_cripto
inner join
    cte_avg_price p_avg on p_min.id_cripto = p_avg.id_cripto
inner join
    CTE_MIN_MKT_CAP m_min on p_min.ID_Cripto = m_min.ID_Cripto
inner join
    CTE_AVG_MKT_CAP m_avg on p_min.ID_Cripto = m_avg.ID_Cripto
inner join
    CTE_MAX_MKT_CAP m_max on p_min.ID_Cripto = m_max.ID_Cripto
inner join
    CTE_TOTAL_VOLUME tv on p_min.ID_Cripto = tv.ID_Cripto
where
    p_min.row_Num <= 1
and p_max.row_num <= 1
and m_min.row_num <= 1
and m_max.row_num <= 1
order by
    p_min.lower_price;

END //
DELIMITER ;