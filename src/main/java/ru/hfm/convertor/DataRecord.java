package ru.hfm.convertor;

/*
 * Class implements data entity
 *
 * @author imataras
 * @since 06.04.2017
 */

class DataRecord {

    private String Entity;
    private String FMAccount;
    private String SourceICP;
    private String SourceCustom1;
    private String SourceCustom2;
    private String SourceCustom3;
    private String SourceCustom4;
    private String Amount;

    String getEntity() {
        return Entity;
    }

    void setEntity(String entity) {
        Entity = entity;
    }

    String getFMAccount() {
        return FMAccount;
    }

    void setFMAccount(String FMAccount) {
        this.FMAccount = FMAccount;
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

    String getAmount() {
        return Amount;
    }

    void setAmount(String amount) {
        Amount = amount;
    }
}
