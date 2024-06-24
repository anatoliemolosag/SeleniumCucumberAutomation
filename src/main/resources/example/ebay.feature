Feature: Search Functionality

  Background:
    Given User navigates to 'https://www.ebay.com/'

 Scenario: Validate all items contains text
   When User inputs 'Iphone'  text in search box
   Then All items cointains 'iPhone' text

   Scenario: Validate page title
     When User inputs 'iPhone' in search box
     And User clicks search buttom
     Then the page title should be 'iPhone for sale | eBay'




