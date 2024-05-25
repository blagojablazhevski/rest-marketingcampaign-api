package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.PerformanceTracking;
import edu.uacs.mk.MarketingCampaignAPI.dao.PerformanceTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public PerformanceTracking getPerformanceTrackingByAdId(Long adId) {
        return performanceTrackingRepository.findByAd_AdId(adId);
    }

    public List<PerformanceTracking> getPerformanceTrackingByCampaignId(Long campaignId) {
        return performanceTrackingRepository.findPerformanceTrackingByAd_Campaign_CampaignId(campaignId);
    }

    public PerformanceTracking updateTrackingById(Long id, PerformanceTracking performanceTracking) {
        PerformanceTracking oldPerformanceTracking = getPerformanceTrackingById(id);

        return getPerformanceTracking(performanceTracking, oldPerformanceTracking);
    }

    public PerformanceTracking updateTrackingByAdId(Long adId, PerformanceTracking performanceTracking) {
        PerformanceTracking oldPerformanceTracking = getPerformanceTrackingByAdId(adId);

        return getPerformanceTracking(performanceTracking, oldPerformanceTracking);
    }

    private PerformanceTracking getPerformanceTracking(PerformanceTracking performanceTracking, PerformanceTracking oldPerformanceTracking) {
        oldPerformanceTracking.setCost(performanceTracking.getCost());
        oldPerformanceTracking.setClicks(performanceTracking.getClicks());
        oldPerformanceTracking.setImpressions(performanceTracking.getImpressions());

        try{
            BigDecimal cost = performanceTracking.getCost();
            BigDecimal clicks = new BigDecimal(performanceTracking.getClicks());
            BigDecimal costPerClick = cost.divide(clicks, 2, RoundingMode.HALF_UP);
            oldPerformanceTracking.setCostPerClick(costPerClick);
        } catch (ArithmeticException e){
            System.out.println("Exception caught: " + e.getMessage());
            oldPerformanceTracking.setCostPerClick(BigDecimal.ZERO);
        }

        return oldPerformanceTracking;
    }
}
