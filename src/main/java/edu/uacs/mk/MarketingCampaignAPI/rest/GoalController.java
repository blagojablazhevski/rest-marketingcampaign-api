package edu.uacs.mk.MarketingCampaignAPI.rest;

import edu.uacs.mk.MarketingCampaignAPI.dao.Goal;
import edu.uacs.mk.MarketingCampaignAPI.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goal")
public class GoalController {
    @Autowired
    GoalService goalService;

    @GetMapping
    List<Goal> getGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    Goal findById(@PathVariable("id") Long id) {
        return goalService.getGoalById(id);
    }
}
