$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/BaseScenarios.feature");
formatter.feature({
  "name": "Navigation Scenarios",
  "description": "  As a user of Reddit, I can navigate around the Reddit app",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Pixel"
    }
  ]
});
formatter.scenario({
  "name": "01. View the \u0027Home\u0027 tab whilst logged out",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Pixel"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the welcome screen has been skipped without logging in",
  "keyword": "Given "
});
formatter.match({
  "location": "BaseScenariosSteps.theWelcomeScreenHasBeenSkippedWithoutLoggingIn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I view the Home tab",
  "keyword": "When "
});
formatter.match({
  "location": "BaseScenariosSteps.iSelectTheHomeTab()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\n\tat pages.PopularTabPage.popularLandingPage(PopularTabPage.java:29)\n\tat steps.BaseScenariosSteps.iSelectTheHomeTab(BaseScenariosSteps.java:34)\n\tat ✽.I view the Home tab(file:src/test/resources/features/BaseScenarios.feature:21)\n",
  "status": "failed"
});
formatter.step({
  "name": "I see new posts and information pertaining to the Home tab",
  "keyword": "Then "
});
formatter.match({
  "location": "BaseScenariosSteps.i_see_new_posts_and_information_pertaining_to_the_Home_tab()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});