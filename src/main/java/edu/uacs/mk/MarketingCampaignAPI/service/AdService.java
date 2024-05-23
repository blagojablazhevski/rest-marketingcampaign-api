package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    @Autowired
    private AdRepository adRepository;
    @Autowired
    private CampaignRepository campaignRepository;

    public List<Ad> getAllAds(){
        return adRepository.findAll();
    }

    public List<Ad> getAllAdsByRegion(String region){
        return adRepository.findByCampaign_TargetAudience_Region(region);
    }

    public List<Ad> getAllAdsByCampaignId(Long id){
        return adRepository.findByCampaign_CampaignId(id);
    }

    public Ad getAdById(Long id){
        return adRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ad with " + id + " not found."));
    }

    public Ad create(Ad ad){
        return adRepository.save(ad);
    }

    public Ad update(Ad ad){
        return adRepository.save(ad);
    }

    public Ad create(Ad ad, Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign with id " + campaignId + " not found."));

        ad.setCampaign(campaign);

        return adRepository.save(ad);
    }

    public Ad update(Long id, Ad ad) {
        Ad oldAd = adRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ad with id " + id + " not found."));

        oldAd.setHeadline(ad.getHeadline());
        oldAd.setDescription(ad.getDescription());
        oldAd.setMediaUrl(ad.getMediaUrl());

        return adRepository.save(oldAd);
    }

    public void delete (Long id){
        adRepository.deleteById(id);
    }
}
