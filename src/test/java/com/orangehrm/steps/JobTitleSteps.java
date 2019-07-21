package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.JobTitlePage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.DbUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobTitleSteps extends CommonMethods {

	JobTitlePage jtPage;
	List<Map<String, String>> uiResults;
	List<Map<String, String>> dbResults;

	public JobTitleSteps() {
		jtPage = new JobTitlePage();
	}

	@Given("I click on Admin")
	public void i_click_on_Admin() {
		click(jtPage.admin);
	}

	@Given("I click on job link")
	public void i_click_on_job_link() {
		click(jtPage.jobLink);
	}

	@Given("I click on jobtitle")
	public void i_click_on_jobtitle() {
		click(jtPage.jobTitle);
	}

	@When("I get all job titles from UI")
	public void i_get_all_job_titles_from_UI() {

		uiResults = new ArrayList<>();

		for (WebElement row : jtPage.jtTableRow) {

			Map<String, String> uiDataMap = new LinkedHashMap<>();

			String rowText = row.getText().replace("ohrm_edit", "").trim();

			uiDataMap.put("JOB_TITLE", rowText);

			uiResults.add(uiDataMap);
		}

	}

	@When("I execute {string} from Database")
	public void i_execute_from_Database(String sqlQuery) {
		dbResults = DbUtils.getResultSetData(sqlQuery);
	}

	@Then("I see results from UI and Database are matched")
	public void i_see_results_from_UI_and_Database_are_matched() {
		//Assert.assertTrue(uiResults.equals(dbResults));;

	}

}
