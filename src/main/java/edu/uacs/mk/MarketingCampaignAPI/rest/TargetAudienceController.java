package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.TargetAudience;
import edu.uacs.mk.MarketingCampaignAPI.service.TargetAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("targetaudience")
public class TargetAudienceController {
    @Autowired
    TargetAudienceService targetAudienceService;

    @GetMapping
    List<TargetAudience> findAll(){
        return targetAudienceService.getAllTargetAudiences();
    }

    @GetMapping("/{id}")
    TargetAudience findById(@PathVariable("id") Long id){
        return targetAudienceService.getTargetAudienceById(id);
    }

    @PostMapping
    TargetAudience create(@RequestBody TargetAudience targetAudience){
        return targetAudienceService.create(targetAudience);
    }

}
