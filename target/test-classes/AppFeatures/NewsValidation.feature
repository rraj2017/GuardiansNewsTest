Feature: To Verify News posted on Guardians is valid and not fake

Background: 
Given User navigates to the Guardian News portal

Scenario: Validate that the first news article posted on Guardian News is valid
And User finds the Articles displayed on Guardian News page
When user reads the first News headline displayed
And User navigates to Google Search page in the other tab of the same browser window to perform Search for the same Article
Then verify that the first Guardian News article is actually valid if two or more results found for the same News article
