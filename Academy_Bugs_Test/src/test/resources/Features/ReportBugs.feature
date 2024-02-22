Feature: Bug Reporting Feature
  @reportBug
  Scenario Outline: Remplir le formulaire pour apprendre à créer un rapport de bug .
       Given accéder à la page Report Bugs
        When sélectionner Issue Title de la liste déroulante
        And sélectionner Frequency dans le groupe de boutons radio
        And Drag and Drop les étapes
        And sélectionner l'image
        And sélectionner la vidéo
        And sélectionner du fichier journal
        Then l'utilisateur soumet le rapport de bug

        Examples:
            | Issue Title                                                           | Frequency     |
            | The product image is broken when zoomed in                            | Every Time    |
            |Windows – Product Details Page – The product image can't be zoomed in  | Hardly Ever   |
            |Windows 10 – Home Page – The product image is broken when zoomed in    | Occasionally  |


