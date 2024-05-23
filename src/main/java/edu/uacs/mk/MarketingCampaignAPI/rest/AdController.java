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

    @GetMapping("/region/{region}")
    List<Ad> getAdsByRegion(@PathVariable("region") String region) {
        return adService.getAllAdsByRegion(region);
    }

    @GetMapping("/campaign/{campaignId}")
    List<Ad> getAdsByRegion(@PathVariable("campaignId") Long campaignId) {
        return adService.getAllAdsByCampaignId(campaignId);
    }

    @GetMapping("/{id}")
    Ad getAdById(@PathVariable("id") Long id) {
        return adService.getAdById(id);
    }

    @PostMapping
    Ad create(@RequestBody Ad ad, @RequestParam Long campaignId){
        return adService.create(ad, campaignId);
    }

    @PutMapping("/{id}")
    Ad update(@PathVariable("id") Long id, @RequestBody Ad ad) {
        return adService.update(id, ad);
    }

    @DeleteMapping({"/{id}"})
    void delete(@PathVariable("id") Long id) {
        adService.delete(id);
    }
}
