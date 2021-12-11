# Tests for PMD GitHub Action

This repository contains test cases / samples for [pmd/pmd-github-action](https://github.com/pmd/pmd-github-action).

This tests a sample Java project.

See the builds at <https://github.com/pmd/pmd-github-action-tests/actions?query=branch%3Ajava>

Active Rules:

*   [AbstractClassWithoutAnyMethod](https://pmd.github.io/latest/pmd_rules_java_design.html#abstractclasswithoutanymethod), at default priority 1
*   [AvoidCatchingThrowable](https://pmd.github.io/latest/pmd_rules_java_errorprone.html#avoidcatchingthrowable), at manual priority 2
*   [ReturnFromFinallyBlock](https://pmd.github.io/latest/pmd_rules_java_errorprone.html#returnfromfinallyblock), at default priority 3
*   [UnconditionalIfStatement](https://pmd.github.io/latest/pmd_rules_java_errorprone.html#unconditionalifstatement), at manual priority 4
*   [UseCollectionIsEmpty](https://pmd.github.io/latest/pmd_rules_java_bestpractices.html#usecollectionisempty), at manual priority 5

Note: The chosen priorities are arbitrary and just used to test different priorities. They are in no way a recommendation.

