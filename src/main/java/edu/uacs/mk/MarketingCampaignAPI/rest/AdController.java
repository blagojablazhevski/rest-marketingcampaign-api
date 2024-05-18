package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.Ad;
import edu.uacs.mk.MarketingCampaignAPI.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ad")
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping
    List<Ad> getAds() {
        return adService.getAllAds();
    }

    @GetMapping("/{id}")
    Ad getAdById(@PathVariable("id") Long id) {
        return adService.getAdById(id);
    }

    @PostMapping
    Ad create(@RequestBody Ad ad, @RequestParam Long campaignId){
        return adService.create(ad, campaignId);
    }

    @DeleteMapping
    void delete(@PathVariable("id") Long id) {
        adService.delete(id);
    }
}
