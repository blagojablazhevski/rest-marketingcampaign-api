package edu.uacs.mk.MarketingCampaignAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findCampaignsByCampaignNameContaining(String campaignName);

    List<Campaign> findCampaignsByTargetAudience_Region(String region);
}