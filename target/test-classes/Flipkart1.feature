Feature: RedBus Buy Tickets

Background:
Given launch the browser and url "https://www.redbus.in"

Scenario: Buy Ticket
    Given users enters value or clicks on from field with one dim map
    |location1|Chennai|
    |location2|Koyambedu|
    |location3|Central|
    When users enters value or clicks on to field with one dim list
    |Maharastra|Kada|
    Then validate the date
    When user clicks on search
    And user gets the result

#Scenario Outline: Buy Ticket
    #Given users enters value or clicks on from field "<Start>"
    #When users enters value or clicks on to field "<End>"
    #|Maharastra|Kada|
    #Then validate the date
    #When user clicks on search
    #
#Examples:
    #|Start|End|
    #|Chennai|Maharastra|
    #|Koyambedu|Delhi|
    #|Central|Pune|
    
#Scenario: Buy Ticket2
    #Given users enters value or clicks on from fields "Koyambedu"
    #When users enters value or clicks on to fields "Kada"
    #Then validating the date
    #When user click on search

#Scenario Outline:
#Examples: 