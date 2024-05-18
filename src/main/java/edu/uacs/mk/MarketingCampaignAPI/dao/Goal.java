package edu.uacs.mk.MarketingCampaignAPI.dao;

import jakarta.persistence.*;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goal_id;

    private String name;

    private String description;

    public void setGoal_id(Long goalId) {
        this.goal_id = goalId;
    }

    public Long getGoal_id() {
        return goal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
