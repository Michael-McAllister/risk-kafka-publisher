package hello;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by michael on 25/10/2018.
 */
public class RiskMessage implements Serializable{

    private String tradeRef;
    private LocalDate tradeDate;
    private String businessDate;
    private BigDecimal delta;
    private String riskType;
    private String firmAccount;
    private String region;
    private String party;
    private String cpty;
    private String csa;
    private String jobName;
    private LocalDateTime timestamp;

    public RiskMessage(String tradeRef, LocalDate tradeDate, String businessDate, BigDecimal delta, String riskType, String firmAccount, String region, String party, String cpty, String csa, String jobName) {
        this.tradeRef = tradeRef;
        this.tradeDate = tradeDate;
        this.businessDate = businessDate;
        this.delta = delta;
        this.riskType = riskType;
        this.firmAccount = firmAccount;
        this.region = region;
        this.party = party;
        this.cpty = cpty;
        this.csa = csa;
        this.jobName = jobName;
        this.timestamp = LocalDateTime.now();
    }

    public static RiskMessage RANDOM_RISK_NOTIFICATION(String businessDate, String riskType) {
        return new RiskMessage(UUID.randomUUID().toString(),
                LocalDate.now(), businessDate,
                BigDecimal.valueOf((int)(Math.random() * 10 + 1) * 1000000),
                riskType, "firmAccount"+(int)(Math.random()*200),
                "region"+(int)(Math.random()*10),
                "party"+(int)(Math.random()*15),
                "cpty"+(int)(Math.random()*150),
                "csa"+(int)(Math.random()*20),
                "jobName"+(int)(Math.random()*10)
                );
    }

    public String getTradeRef() {
        return tradeRef;
    }

    public void setTradeRef(String tradeRef) {
        this.tradeRef = tradeRef;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public BigDecimal getDelta() {
        return delta;
    }

    public void setDelta(BigDecimal delta) {
        this.delta = delta;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public String getFirmAccount() {
        return firmAccount;
    }

    public void setFirmAccount(String firmAccount) {
        this.firmAccount = firmAccount;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCpty() {
        return cpty;
    }

    public void setCpty(String cpty) {
        this.cpty = cpty;
    }

    public String getCsa() {
        return csa;
    }

    public void setCsa(String csa) {
        this.csa = csa;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTimestamp() {
        return "2015-09-12T00:46:58.771Z";
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }
}
