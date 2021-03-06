package com.inovia.magnifier.rule;

import com.inovia.magnifier.database.*;
import com.inovia.magnifier.reports.*;

/**
 * Checks if view names follow the convention
 */
public class ViewName implements Rule {
	public static final String RULE_NAME = "ViewName";
	public static final String SUGGESTION = "Each view should have a name ending with _view";
	public static final Float DEBT = 1F;
	public static final String[] FORMAT = {"schema", "view"};
	
	private static final String SUFFIX = "_view";

	public ViewName() { }
	
	public RuleReport run(Database database) {
		RuleReport ruleReport = new RuleReport(this, SUGGESTION, DEBT);

		for(View v : database.getViews()) {
			Boolean isSuccess = assertion(v);
			String[] dataToDisplay = {v.getSchemaName(), v.getName()};
			ruleReport.addEntry(new ReportEntry(dataToDisplay, isSuccess));
		}

		return ruleReport;
	}

	private Boolean assertion(View view) {
		if(view.getName().endsWith(SUFFIX)) {
			return true;
		}

		return false;
	}
	
	public String[] getRuleReportFormat() {
		return FORMAT;
	}

	public String getName() {
		return RULE_NAME;
	}
}
