package edu.uacs.mk.MarketingCampaignAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}