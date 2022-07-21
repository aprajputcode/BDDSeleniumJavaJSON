Feature: Find Element in WebSite
  I want to use single function to find all element by useing single step defination

  @tag1
  Scenario: Find Element
   Given user should be hit the page "http://automationpractice.com/index.php?controller=authentication&back=my-account"
    When Text "wizkhalifaslimy@gmail.com" on name of textbox is "UserName2" 
    And Text "Selenium@123" on name of textbox is "PassWord2"
    Then click on "button2"
    And user should on Dashboard and title is 'My account - My Store'