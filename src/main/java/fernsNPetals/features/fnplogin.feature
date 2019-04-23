Feature: FernsNPetals Login Feature

Scenario Outline: FernsNPetals Login Test Scenario

Given user is already on My account Page

Then user enters usermailID "<MailID>" 
Then user clicks on continue button
Then user enters password "<pwd>"
Then user clicks on continue button
Then my account details are shown
Then Close the browser


Examples:
	| MailID                | pwd       |
	| testmeapp1@gmail.com  | test@2018 |