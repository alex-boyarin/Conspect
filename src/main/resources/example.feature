@Smoke
Feature: UI tests for example

  Background: Entry page is opened
    Given User open mobile app Parcel Tracker

  Scenario Outline: Create new tracking for shipment
# В <...> будет подставляться значения из таблицы Examples:
    When User fills form with parameters
      | trackingId    | <trackingId>    |
      | packerCompany | <packerCompany> |
    And User submits form
    And User returns to main page after redirection
    Then New parcel tracker appears with tracking id "<trackingId>" and packer company "<packerCompany>"

    Examples:
      | trackingId | packerCompany |
      | 555555     | Hermes        |

  Scenario Outline: Delete parcel

    When User fills form with parameters
      | trackingId    | <trackingId>    |
      | packerCompany | <packerCompany> |
    And User submits form
    And  User returns to main page after redirection
    Then New parcel tracker appears with tracking id "<trackingId>" and packer company "<packerCompany>"
    And User delete parcel with tracking id "<trackingId>" and packer company "<packerCompany>"
    And Parcel with tracking id "<trackingId>" and packer company "<packerCompany>" appears in archive

    Examples:
      | trackingId | packerCompany |
      | 55555      | DHL           |

  Scenario Outline: Change shipment name

    When User fills form with parameters
      | trackingId    | <trackingId>    |
      | packerCompany | <packerCompany> |
    And User submits form
    And User returns to main page after redirection
    And New parcel tracker appears with tracking id "<trackingId>" and packer company "<packerCompany>"
    And Click on edit button
    And Clear input field
    And Write new shipment name
      | parcelName | <parcelName> |
    And Click on ok button
    Then Check if parcel with such name exists

    Examples:
      | trackingId    | packerCompany  | parcelName         |
      | 55555         | DHL            | Good parcel        |
      | Ra123456789CH | China Packages | Interesting parcel |