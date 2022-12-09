package com.demo.javamongo.model;

public class QuestionnaireDTO {

    private String id;
    private String OrgId;
    private String DisplayName;
    private String WelcomeText;

    public QuestionnaireDTO(){

    }
    public QuestionnaireDTO(String id, String OrgId, String DisplayName, String WelcomeText) {
        super();
        this.id = id;
        this.OrgId = OrgId;
        this.DisplayName = DisplayName;
        this.WelcomeText = WelcomeText;
    }

    public String getId() {
        return id;
    }

    public String getOrgId() {
        return OrgId;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public String getWelcomeText() {
        return WelcomeText;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOrgId(String orgId) {
        this.OrgId = orgId;
    }

    public void setDisplayName(String displayName) {
        this.DisplayName = displayName;
    }

    public void setWelcomeText(String welcomeText) {
        this.WelcomeText = welcomeText;
    }
}
