package edu.uacs.mk.MarketingCampaignAPI.dao;

import jakarta.persistence.*;

@Entity
public class CampaignType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;

    private String name;

    private String description;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}