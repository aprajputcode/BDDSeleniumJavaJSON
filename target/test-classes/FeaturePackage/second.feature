Feature: Login Page..
@sanity
  Scenario: User should login the page..
    Given user should be hit the page "https://opensource-demo.orangehrmlive.com"
    When Text "Admin" on name of textbox is "UserName" 
    And Text "admin123" on name of textbox is "PassWord"
    Then click on "button"
    And user should on Dashboard and title is 'OrangeHRM'