package edu.uacs.mk.MarketingCampaignAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceTrackingRepository extends JpaRepository<PerformanceTracking, Long> {
    PerformanceTracking findByAd_AdId(Long adId);

    List<PerformanceTracking> findPerformanceTrackingByAd_Campaign_CampaignId (Long campaignId);
}