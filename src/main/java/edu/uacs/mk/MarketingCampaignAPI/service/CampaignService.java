package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    CampaignTypeRepository campaignTypeRepository;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private TargetAudienceRepository targetAudienceRepository;

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign with id " + id + " not found."));
    }

    public Campaign create(Campaign campaign, Long goalId, Long campaignTypeId, Long targetAudienceId) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal with id " + goalId + " not found."));

        campaign.setGoal(goal);

        CampaignType campaignType = campaignTypeRepository.findById(campaignTypeId)
                .orElseThrow(() -> new RuntimeException("Campaign type with id " + campaignTypeId + " not found."));

        campaign.setCampaignType(campaignType);

        TargetAudience targetAudience = targetAudienceRepository.findById(targetAudienceId)
                .orElseThrow(() -> new RuntimeException("Target audience with id " + targetAudienceId + " not found."));

        campaign.setTargetAudience(targetAudience);

        return campaignRepository.save(campaign);
    }

    public Campaign update(Long id, Campaign campaign) {
        Campaign oldCampaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign with id " + id + " not found."));

        oldCampaign.setBudget(campaign.getBudget());
        oldCampaign.setStartDate(campaign.getStartDate());
        oldCampaign.setEndDate(campaign.getEndDate());
        oldCampaign.setCampaignName(campaign.getCampaignName());

        return campaignRepository.save(oldCampaign);
    }

    public void delete(Long id) {
        campaignRepository.deleteById(id);
    }

    public Campaign updateCampaignGoal(Long campaignId, Long goalId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign with id " + campaignId + " not found."));

        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal with id " + goalId + " not found."));

        campaign.setGoal(goal);

        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaignType(Long campaignId, Long typeId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign with id " + campaignId + " not found."));

        CampaignType type = campaignTypeRepository.findById(typeId)
                .orElseThrow(() -> new RuntimeException("CampaignType with id " + typeId + " not found."));

        campaign.setCampaignType(type);

        return campaignRepository.save(campaign);
    }

//    public Campaign updateTargetAudience(Long campaignId, Long targetAudienceId) {
//        Campaign campaign = campaignRepository.findById(campaignId)
//                .orElseThrow(() -> new RuntimeException("Campaign with id " + campaignId + " not found."));
//
//        TargetAudience targetAudience = targetAudienceRepository.findById(targetAudienceId)
//                .orElseThrow(() -> new RuntimeException("CampaignType with id " + targetAudienceId + " not found."));
//
//        campaign.setTargetAudience(targetAudience);
//
//        return campaignRepository.save(campaign);
//    }

    public List<Campaign> getCampaignsByName(String name) {
        return campaignRepository.findCampaignsByCampaignNameContaining(name);
    }

    public List<Campaign> getCampaignsByRegion(String region) {
        return campaignRepository.findCampaignsByTargetAudience_Region(region);
    }
}
