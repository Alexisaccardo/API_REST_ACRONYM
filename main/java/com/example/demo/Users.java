package com.example.demo;

public class Users {
    public String codeId;
    public String thirdapp;
    public String relation;
    public String acronym;


    public Users(String codeId, String thirdapp, String relation, String acronym) {
        this.codeId = codeId;
        this.thirdapp = thirdapp;
        this.relation = relation;
        this.acronym = acronym;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getThirdapp() {
        return thirdapp;
    }

    public void setThirdapp(String thirdapp) {
        this.thirdapp = thirdapp;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
