package com.inovia.magnifier.reports;

import java.util.*;
import com.inovia.magnifier.rule.Rule;

/**
 * it is a report about the execution of a rule on the database.
 * it includes a set of report entries
 */
public class RuleReport {
	private final static Float MAX_SCORE = 100.0F;
	private final static Float MIN_SCORE =   0.0F;
	
	private Class<? extends Rule> ruleClass;
	private String suggestion;
	private Float score;
	private List<ReportEntry> entries;
	private Float debt;
	
	public RuleReport(Class<? extends Rule> ruleClass, String suggestion, Float debt) {
		entries = new Vector<ReportEntry>();
		this.suggestion = suggestion;
		this.debt = debt;
		this.ruleClass = ruleClass;
	}

	public Float getScore() {
		if(entries.size() == 0) {
			return MAX_SCORE;
		}
		
		Float tmp = MIN_SCORE;
		
		for(ReportEntry e : entries) {
			if(e.isSuccess()) {
				tmp++;
			}
		}
			
		score = tmp * MAX_SCORE / ((float) entries.size());
		
		return score;
	}
	
	public boolean addEntry(ReportEntry entry) {
		return entries.add(entry);
	}
	
	public List<ReportEntry> getEntries() {
		return entries;
	}
	
	public String getSuggestion() {
		return suggestion;
	}
	
	public String getRuleName() {
		try {
			return (String) ruleClass.getField("RULE_NAME").get(null);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public Float getDebt() {
		Integer failingEntityCount = 0;
		
		for(ReportEntry e : entries) {
			if(!e.isSuccess()) {
				failingEntityCount++;
			}
		}
		
		return debt * failingEntityCount;
	}
	
	public String[] getColumns() {
		try {
			return (String[]) ruleClass.getMethod("getFormat").invoke(ruleClass.newInstance(), (Object[]) null);
		}
		catch(Exception e)  {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		return null; // ?
	}
}
