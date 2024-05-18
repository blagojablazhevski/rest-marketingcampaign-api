package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.CampaignType;
import edu.uacs.mk.MarketingCampaignAPI.dao.CampaignTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignTypeService {

    @Autowired
    private CampaignTypeRepository campaignTypeRepository;

    public List<CampaignType> getAllCampaignTypes() {
        return campaignTypeRepository.findAll();
    }

    public CampaignType getCampaignTypeById(Long id) {
        return campaignTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign Type with id " + id + " not found."));
    }

}
