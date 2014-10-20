package com.inovia.magnifier.rules;

import java.util.List;

import com.inovia.magnifier.*;
import com.inovia.magnifier.database.objects.*;
import com.inovia.magnifier.reports.*;

/**
 * The TriggerHasComment class aims at checking if
 * the provided triggers all have a comment
 */
public class TriggerHasComment extends Rule {
	public static final String RULE_NAME = "TriggerHasComment";
	public static final String SUGGESTION = "Each trigger should have a comment explaining what it contains";
	public static final Float DEBT = 1F;

	public TriggerHasComment(Ruleset ruleset) {
		super(ruleset);
	}
	
	public RuleReport run() {
		RuleReport ruleReport = new RuleReport(RULE_NAME, SUGGESTION, DEBT);
		
		for(Trigger t : getDatabase().getTriggers()) {
			Boolean isSuccess = assertion(t, getDatabase().getComments());
			ruleReport.addEntry(new ReportEntry(t.getEntityDescription(), isSuccess));
		}
		
		return ruleReport;
	}
	
	private Boolean assertion(Trigger trigger, List<Comment> comments) {
		for(Comment c : comments) {
			if(c.getEntityType().equals("trigger") && c.getSchemaName().equals(trigger.getSchemaName()) && c.getEntityName().equals(trigger.getName())) {
				return true;
			}
		}
		
		return false;
	}
}
