import { defineConfig } from "cypress";
import createBundler = require("@bahmutov/cypress-esbuild-preprocessor")
import { addCucumberPreprocessorPlugin } from "@badeball/cypress-cucumber-preprocessor";
import createEsbuildPlugin from "@badeball/cypress-cucumber-preprocessor/esbuild";
import { defineConfig } from 'cypress'
export default defineConfig({
  chromeWebSecurity: false,
  reporter: 'mochawesome',
  reporterOptions: {
    "reportDir": "cypress/reports",
    "overwrite": false,
    "html": true,
    "json": false
  },
  e2e: {
    specPattern: "**/*.feature",
    async setupNodeEvents(
        on: Cypress.PluginEvents,
        config: Cypress.PluginConfigOptions
    ): Promise<Cypress.PluginConfigOptions> {
      // This is required for the preprocessor to be able to generate JSON reports after each run, and more,
      await addCucumberPreprocessorPlugin(on, config);

      on(
          "file:preprocessor",
          createBundler({
            plugins: [createEsbuildPlugin(config)],
          })
      );

      // Make sure to return the config object as it might have been modified by the plugin.
      return config;
    },
  },
});