Feature: Testing SpringBoot Application
 
	Background: Fetching the API base address
		Given User enters the correct address

 
  @getAllEmployee
  Scenario: Fetching list employee
    When User hits the getAPI
    Then It must show all users
 
  @createEmployee
  Scenario Outline: Creating employee
    When User enters "<empId>" and "<empName>" and "<empSal>"
    And User hits the postAPI
    Then Employee should be created
 
    Examples: 
      | empId | empName  | empSal  |
      |  122  | Devang |  38000  |
      |  123  | Kevin |  42000  |
      |  124  |  Atharva   |  63000  |
      |  125  |  Hitesh   |  29000  |
      |  126  |  Aftab   |  50000  |
    @getSingleEmployee
    Scenario: Getting single employee
    	When User hits the GetAPI with single employee id
    	Then It should show employee details

    @updateEmployee
    Scenario: Updating employee
    	When user enters empId,empName,empSal
    			|  122  |  Devang  |  38000  |
    	And User hits the putAPI with employee id
    	Then Employee should be updated

    @deleteEmployee
    Scenario: Deleting employee
    	When User hits the deleteAPI with employee id
    	Then Employee should be deleted
