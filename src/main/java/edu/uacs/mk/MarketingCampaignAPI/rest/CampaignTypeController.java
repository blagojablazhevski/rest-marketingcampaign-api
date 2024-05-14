package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.CampaignType;
import edu.uacs.mk.MarketingCampaignAPI.service.CampaignTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("campaigntype")
public class CampaignTypeController {

    @Autowired
    CampaignTypeService campaignTypeService;

    @GetMapping
    List<CampaignType> findAll(){
        return  campaignTypeService.getAllCampaignTypes();
    }

    @GetMapping("/{id}")
    CampaignType findById(@PathVariable("id") Long id) {
        return campaignTypeService.getCampaignTypeById(id);
    }
}
