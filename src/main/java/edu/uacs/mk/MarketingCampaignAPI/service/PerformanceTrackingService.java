package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.PerformanceTracking;
import edu.uacs.mk.MarketingCampaignAPI.dao.PerformanceTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceTrackingService {
    @Autowired
    private PerformanceTrackingRepository performanceTrackingRepository;

    public List<PerformanceTracking> getAllPerformanceTracking() {
        return performanceTrackingRepository.findAll();
    }

    public PerformanceTracking getPerformanceTrackingById(Long id) {
        return performanceTrackingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tracking with id " + id + " not found."));
    }
}
