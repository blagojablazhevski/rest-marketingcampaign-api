package edu.uacs.mk.MarketingCampaignAPI.dao;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PerformanceTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trackingId;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    private int clicks;

    private int impressions;

    private BigDecimal cost;

    private BigDecimal costPerClick;

    // Getters and setters
}