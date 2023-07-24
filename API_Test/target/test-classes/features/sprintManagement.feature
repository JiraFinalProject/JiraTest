@SprintManagement
Feature: Sprint Management


  Scenario Outline: Sprint Management
    When As a team leader user, I can create and start a new sprint. "<tl_username>" and "<tl_password>"
    And As a team leader user, I can move issues from the backlog to the current sprint. "<tl_username>" and "<tl_password>"
    When As a developer user, I can view all the issues in the current sprint. "<de_username>" and "<de_password>"
    When As a team lead user, I can end the current active sprint. "<tl_username>" and "<tl_password>"
    Examples:
      | tl_username | tl_password | de_username | de_password |
      | Junyu Deng    | 12345678    | Junyu Deng   | 12345678   |