package ru.hfm.convertor;

/*
 * Class implements data entity
 *
 * @author imataras
 * @since 06.04.2017
 */

import java.math.BigDecimal;

class DataRecord {

    private String SourceFMEntity;
    private String SourceFMAccount;
    private String SourceICP;
    private String SourceCustom1;
    private String SourceCustom2;
    private String SourceCustom3;
    private String SourceCustom4;
    private BigDecimal Amount;

    DataRecord() {

    }

    String getSourceFMEntity() {
        return SourceFMEntity;
    }

    void setSourceFMEntity(String sourceFMEntity) {
        SourceFMEntity = sourceFMEntity;
    }

    String getSourceFMAccount() {
        return SourceFMAccount;
    }

    void setSourceFMAccount(String sourceFMAccount) {
        SourceFMAccount = sourceFMAccount;
    }

    String getSourceICP() {
        return SourceICP;
    }

    void setSourceICP(String sourceICP) {
        SourceICP = sourceICP;
    }

    String getSourceCustom1() {
        return SourceCustom1;
    }

    void setSourceCustom1(String sourceCustom1) {
        SourceCustom1 = sourceCustom1;
    }

    String getSourceCustom2() {
        return SourceCustom2;
    }

    void setSourceCustom2(String sourceCustom2) {
        SourceCustom2 = sourceCustom2;
    }

    String getSourceCustom3() {
        return SourceCustom3;
    }

    void setSourceCustom3(String sourceCustom3) {
        SourceCustom3 = sourceCustom3;
    }

    String getSourceCustom4() {
        return SourceCustom4;
    }

    void setSourceCustom4(String sourceCustom4) {
        SourceCustom4 = sourceCustom4;
    }

    BigDecimal getAmount() {
        return Amount;
    }

    void setAmount(BigDecimal amount) {
        Amount = amount;
    }
}
