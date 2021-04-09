Feature: registration

  Scenario Outline: 
    Given browser is open
    And user fills email "<email>"
    And user enters username "<username>"
    And user enters password "<password>"
    When user clicks sign up button
    

    @creatnewuser
    Examples: 
      | email                 | username                                                                                                                 | password   | result                                                                            |
      | khaled.safi@test.com  | user                                                                                                                     | Admin_b123 | Check your email                                                              |
      | khaled.safi@test.com  | longUserNamelongUserNamelongUserNamelongUserNamelongUserNamelongUserNamelongUserNamelongUserNamelongUserNamelongUserName | Admin_b123 | Enter a value less than 100 characters long                                       |
      | khaled.safi1@test.com | mark                                                                                                                     | Admin_b123 | Another user with this username already exists. Maybe it's your evil twin. Spooky |
      |                       | afgbacha18                                                                                                               | Admin_b123 | Please enter a value                                                              |
