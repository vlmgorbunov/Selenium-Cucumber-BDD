Feature: search note

  Example: Logging in to site
  Opening main page (you should be logged in for doing that? That's why login page would be opened).
    When open "mainPage" page
    And "logInPage" page opened
    And type text: "u" to input with name "/html/body/div/div/form/div[1]/label/input"
    And type text: "p" to input with name "/html/body/div/div/form/div[2]/label/input"
    And press button with id "submitButton"
    And "mainPage" page should be opened
    And I visit "mainPage" page
    And I enter "note" in the "/html/body/div[3]/form/label/input" field
    And I press the "searchButton" button
    Then I should see the find "note" on the page