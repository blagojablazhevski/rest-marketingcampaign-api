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

    public void delete (Long id){
        adRepository.deleteById(id);
    }
}
