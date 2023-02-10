const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    defaultCommandTimeout: 10_000,
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
