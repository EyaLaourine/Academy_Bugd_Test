
Feature: Type Of Bugs

  Scenario Outline: Découvrez les différents types de bugs qui surviennent couramment sur les sites Web et les applications.
    Given accéder à la page Type of bugs
    When sélectionner  le conteneur du type de bug
    And cliquer sur mot cliquable pour accéder à la page convenante
    And  Appuyer sur le bouton Read More
    And Retourner vers la page web précédente immédiate
    Then Fermer l'onglet et revenir à la page d'accueil du site
    Examples:
      | type de bug  |
      |Visual        |

