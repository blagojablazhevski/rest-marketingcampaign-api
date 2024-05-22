package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.Campaign;
import edu.uacs.mk.MarketingCampaignAPI.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("campaign")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @GetMapping
    List<Campaign> getCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    Campaign getCampaignById(@PathVariable("id") Long id) {
        return campaignService.getCampaignById(id);
    }

    @PostMapping
    Campaign create(@RequestBody Campaign campaign, @RequestParam Long goalId, @RequestParam Long campaignTypeId, @RequestParam Long targetAudienceId){
        return campaignService.create(campaign, goalId, campaignTypeId, targetAudienceId);
    }

    @PutMapping
    Campaign update(@RequestBody Campaign campaign) {
        return campaignService.update(campaign);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {
        campaignService.delete(id);
    }

    @PutMapping("/{campaignId}/goal/{goalId}")
    Campaign updateCampaignGoal(@PathVariable Long campaignId, @PathVariable Long goalId) {
        return campaignService.updateCampaignGoal(campaignId, goalId);
    }

    @PutMapping("/{campaignId}/campaignType/{typeId}")
    Campaign updateCampaignType(@PathVariable Long campaignId, @PathVariable Long typeId) {
        return campaignService.updateCampaignType(campaignId, typeId);
    }

    @PutMapping("/{targetAudienceId}/campaignType/{targetAudienceId}")
    Campaign updateTargetAudience(@PathVariable Long campaignId, @PathVariable Long targetAudienceId) {
        return campaignService.updateTargetAudience(campaignId, targetAudienceId);
    }
}


