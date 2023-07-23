Feature: Sprint Management

  Scenario Outline: Sprint Management
    When As a team leader user, I can create and start a new sprint. <tl_username> and <tl_password>
    When As a team leader user, I can move issues from the backlog to the current sprint.
    When As a developer user, I can view all the issues in the current sprint. <de_username> and <de_password>
    When As a team lead user, I can end the current active sprint. <tl_username> and <tl_password>
    When As a team lead user, I can download the velocity chart of the last 6 months as an image.
    Examples:
      | tl_username | tl_password | de_username | de_password |
      | teamlead    | teamlead    | developer   | developer   |