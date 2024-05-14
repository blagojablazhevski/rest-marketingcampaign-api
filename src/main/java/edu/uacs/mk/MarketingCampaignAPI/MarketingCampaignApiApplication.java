package edu.uacs.mk.MarketingCampaignAPI;

import edu.uacs.mk.MarketingCampaignAPI.dao.CampaignType;
import edu.uacs.mk.MarketingCampaignAPI.dao.CampaignTypeRepository;
import edu.uacs.mk.MarketingCampaignAPI.dao.Goal;
import edu.uacs.mk.MarketingCampaignAPI.dao.GoalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MarketingCampaignApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MarketingCampaignApiApplication.class, args);

		SetCampaignType(context, "Video", "Reach viewers on multiple streaming platforms.");
		SetCampaignType(context, "Display", "Reach customers across many sites and apps.");
		SetCampaignType(context, "Smart", "Combined video and display solution, perfect for smaller businesses.");

		SetGoal(context, "Purchases", "Someone buys a product or service.");
		SetGoal(context, "Submit Form", "Potential customer fills out a form.");
		SetGoal(context, "Phone Call Lead", "Potential customer calls your business.");
		SetGoal(context, "Page Views", "Someone views a key page (such as an article or product page.");
		SetGoal(context, "Brand Awareness", "Reach a broad audience and build consideration for your brand.");
	}

	static void SetGoal(ConfigurableApplicationContext context, String name, String description) {
		GoalRepository goalRepository = context.getBean(GoalRepository.class);
		Goal goal = new Goal();
		goal.setName(name);
		goal.setDescription(description);
		goalRepository.save(goal);
	}

	static void SetCampaignType(ConfigurableApplicationContext context, String name, String description) {
		CampaignTypeRepository campaignTypeRepository = context.getBean(CampaignTypeRepository.class);
		CampaignType campaignType = new CampaignType();
		campaignType.setName(name);
		campaignType.setDescription(description);
		campaignTypeRepository.save(campaignType);
	}

}
