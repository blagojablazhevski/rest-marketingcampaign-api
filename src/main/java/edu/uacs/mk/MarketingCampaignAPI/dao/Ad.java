package edu.uacs.mk.MarketingCampaignAPI.dao;

import jakarta.persistence.*;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adId;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    private String headline;

    private String description;

    private String mediaUrl;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}