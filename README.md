# Tests for PMD GitHub Action

This repository contains test cases / samples for [pmd/pmd-github-action](https://github.com/pmd/pmd-github-action).

This tests a sample Apex project.

See the builds at <https://github.com/pmd/pmd-github-action-tests/actions?query=branch%3Aapex>

Active rules:
*   [FieldNamingConventions](https://pmd.github.io/latest/pmd_rules_apex_codestyle.html#fieldnamingconventions) at default priority 1
*   [UnusedLocalVariable](https://pmd.github.io/latest/pmd_rules_apex_bestpractices.html#unusedlocalvariable) at manual priority 2
*   [WhileLoopsMustUseBraces](https://pmd.github.io/latest/pmd_rules_apex_codestyle.html#whileloopsmustusebraces) at default priority 3
*   [OneDeclarationPerLine](https://pmd.github.io/latest/pmd_rules_apex_codestyle.html#onedeclarationperline) at manual priority 4
*   [LocalVariableNamingConventions](https://pmd.github.io/latest/pmd_rules_apex_codestyle.html#localvariablenamingconventions) at manual priority 5

Note: The chosen priorities are arbitrary and just used to test different priorities. They are in no way a recommendation.
