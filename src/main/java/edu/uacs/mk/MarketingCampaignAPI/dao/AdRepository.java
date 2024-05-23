package edu.uacs.mk.MarketingCampaignAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByCampaign_TargetAudience_Region(String region);

    List<Ad> findByCampaign_CampaignId(Long id);
}