package edu.uacs.mk.MarketingCampaignAPI.service;

import edu.uacs.mk.MarketingCampaignAPI.dao.Goal;
import edu.uacs.mk.MarketingCampaignAPI.dao.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Goal getGoalById(Long id) {
        return goalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal with id " + id + " not found."));
    }
}
