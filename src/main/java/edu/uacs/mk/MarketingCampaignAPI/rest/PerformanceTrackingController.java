package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.PerformanceTracking;
import edu.uacs.mk.MarketingCampaignAPI.service.PerformanceTrackingService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tracking")
public class PerformanceTrackingController {
    @Autowired
    private PerformanceTrackingService performanceTrackingService;

    @GetMapping
    List<PerformanceTracking> findAll() {
        return performanceTrackingService.getAllPerformanceTracking();
    }

    @GetMapping("/{id}")
    PerformanceTracking findById(@PathVariable("id") Long id){
        return performanceTrackingService.getPerformanceTrackingById(id);
    }

    @GetMapping("/campaign/{id}")
    List<PerformanceTracking> findByCampaignId(@PathVariable("id") Long id){
        return performanceTrackingService.getPerformanceTrackingByCampaignId(id);
    }

    @GetMapping("/ad/{adId}")
    public PerformanceTracking findByAdId(@PathVariable("adId") Long adId){
        return performanceTrackingService.getPerformanceTrackingByAdId(adId);
    }

    @PutMapping("/ad/{adId}")
    public PerformanceTracking updatePerformanceTrackingByAdId(@PathVariable("adId") Long adId, @RequestBody PerformanceTracking performanceTracking){
        return performanceTrackingService.updateTrackingByAdId(adId, performanceTracking);
    }

    @PutMapping("/{id}")
    public PerformanceTracking updatePerformanceTrackingById(@PathVariable("id") Long id, @RequestBody PerformanceTracking performanceTracking){
        return performanceTrackingService.updateTrackingById(id, performanceTracking);
    }
}
