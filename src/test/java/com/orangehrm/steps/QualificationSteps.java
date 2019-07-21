package com.orangehrm.steps;

import com.orangehrm.pages.QualificationPage;
import com.orangehrm.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class QualificationSteps extends CommonMethods {
	QualificationPage quli_Page;

	@Given("I click qualifications link")
	public void i_click_qualifications_link() throws InterruptedException {
		quli_Page = new QualificationPage();
		jsClick(quli_Page.qualificationLink);

	}

	@Given("I click on languages link")
	public void i_click_on_languages_link() {
		jsClick(quli_Page.languagesLink);
	}

	@Then("I click on add button indicated with plus sign")
	public void i_click_on_add_button_indicated_with_plus_sign() throws InterruptedException {
		jsClick(quli_Page.addButtonQulifiPage);

	}

	@Then("I enter a language {string}")
	public void i_enter_a_language_name(String language) throws InterruptedException {
		sendText(quli_Page.addLanguageName, language);

	}

	@Then("I click on save button to save the language")
	public void i_click_on_save_button_to_save_the_language() {
		jsClick(quli_Page.saveBtnQuliPage);

	}

	@Then("I verify that the language {string} is successfully added")
	public void i_verify_that_the_language_is_successfully_added(String language) {

		int row = quli_Page.tableRow.size();

		for (int i = 0; i < row; i++) {
			String rowText = quli_Page.tableRow.get(i).getText();

			if (rowText.contains(language)) {

				System.out.println("Language added successfully");
			}
		}
	}
}