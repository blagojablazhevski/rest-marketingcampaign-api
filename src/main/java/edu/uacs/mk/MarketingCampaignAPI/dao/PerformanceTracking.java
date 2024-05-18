package edu.uacs.mk.MarketingCampaignAPI.dao;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PerformanceTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trackingId;

    @OneToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    private int clicks;

    private int impressions;

    private BigDecimal cost;

    private BigDecimal costPerClick;

    public Long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Long trackingId) {
        this.trackingId = trackingId;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCostPerClick() {
        return costPerClick;
    }

    public void setCostPerClick(BigDecimal costPerClick) {
        this.costPerClick = costPerClick;
    }
}