Feature: add providers

Scenario: the id already exists
When Admin enters wrong id for provider
Then Admin should see wrong id

Scenario: Provider added successfully
When Admin enters correct id for provider
Then Admin should see Provider added successfully