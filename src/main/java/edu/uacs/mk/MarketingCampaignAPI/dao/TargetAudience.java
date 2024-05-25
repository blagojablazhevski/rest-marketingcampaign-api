package edu.uacs.mk.MarketingCampaignAPI.dao;

import jakarta.persistence.*;

@Entity
public class TargetAudience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long targetingId;

    @OneToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    private String region;

    private String ageRange;

    public Long getTargetingId() {
        return targetingId;
    }

    public void setTargetingId(Long targetingId) {
        this.targetingId = targetingId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}
