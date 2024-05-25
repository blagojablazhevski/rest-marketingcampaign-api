package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.TargetAudience;
import edu.uacs.mk.MarketingCampaignAPI.dao.TargetAudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetAudienceService {
    @Autowired
    private TargetAudienceRepository targetAudienceRepository;

    public List<TargetAudience> getAllTargetAudiences() {
        return targetAudienceRepository.findAll();
    }

    public TargetAudience getTargetAudienceById(Long id) {
        return targetAudienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Target Audience with id " + id + " not found."));
    }

    public TargetAudience create(TargetAudience targetAudience){
        return targetAudienceRepository.save(targetAudience);
    }

    public TargetAudience update(Long id, TargetAudience targetAudience) {
        TargetAudience oldTargetAudience = getTargetAudienceById(id);

        oldTargetAudience.setRegion(targetAudience.getRegion());
        oldTargetAudience.setAgeRange(targetAudience.getAgeRange());

        return targetAudienceRepository.save(oldTargetAudience);
    }
    public void delete(Long id) {
       targetAudienceRepository.deleteById(id);
    }
}
