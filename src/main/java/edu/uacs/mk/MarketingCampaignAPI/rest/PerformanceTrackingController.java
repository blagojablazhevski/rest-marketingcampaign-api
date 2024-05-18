package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.PerformanceTracking;
import edu.uacs.mk.MarketingCampaignAPI.service.PerformanceTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
