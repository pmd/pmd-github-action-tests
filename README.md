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

## Test Cases

Some test cases...

### Violations in new files

**Description:**

* Integrated as "build" workflow on push
* Only "rulesets" is configured, everything else is default
* rulesets is a combination of two: the rulesets in the same project and a single selected built-in rule.
* Changes are all new files

**Execution steps:**

1. Update version in `build.yml` to be `pmd/pmd-github-action@main` or whatever version to test
2. Copy folder `src/classes` to `src/classes2` - these are the "changed" files
3. Push - that's the build that must be verified
4. Revert and push - restore for next test case

**Expected:**

* The latest PMD version should be used (check build logs)
* In total, there should be 10 reported violations - 5 in `AllInOne.cls` and for each other file one.
* All files should be from `src/classes2` - violations in `src/classes` should *not* be reported.
* The violations should appear inline on the commit view on github (annotations)
    * note: the build is run 3 times for each OS - so every annotation should repeat 3 times
    * the violation should appear on the correct line. annotations are created at "end line" by github.
      The comment in the file is at begin line and can be earlier.
* The violations should appear as build annotations for the build
    * note: the build is run 3 times for each OS
    * in total there are 30 violations: 12 errors, 12 warnings, 6 notices
* There is a "PMD Report" artifact on the build that contains the SARIF report.

### Violations in existing files

**Description:**

* Integrated as "build" workflow on push
* Only "rulesets" is configured, everything else is default
* Two changes in two existing files

**Execution steps:**

1. Update version in `build.yml` to be `pmd/pmd-github-action@main` or whatever version to test
2. Change file `src/classes/LocalVariableNamingConventionsSample.cls` - copy method `bar` as `foo`.
3. Change file `src/classes/UnusedLocalVariableSample.cls` - copy method `bar` as `foo`.
4. Push - that's the build that must be verified
5. Revert and push - restore for next test case

**Expected:**

* In total, there should be 4 reported violations - two in each changed file. One new (foo) and one
  that previously existed (bar).
* The violations should appear inline on the commit view on github (annotations)
    * note: the build is run 3 times for each OS - so every annotation should repeat 3 times
    * the violation should appear on the correct line. annotations are created at "end line" by github.
      The comment in the file is at begin line and can be earlier.
* The violations should appear as build annotations for the build
    * note: the buils is run 3 times for each OS
    * in total there are 12 violations: 6 errors, 6 warnings

### Code scanning alerts

**Description:**

* If the SARIF file is uploaded, the violations should appear in the project's security tab
  under "Code scanning alerts".
* It uses the quickstart.xml ruleset
* it checks always all files under `src/classes`

**Execution steps:**

1. Update version in `pmd-analysis.yml` to be `pmd/pmd-github-action@main` or whatever version to test
2. Push - that's the build that must be verified
3. Revert and push - restore for next test case

**Expected:**

* Build with name "pmd" is successful. There are some build annotations.
* There is a "PMD Report" artifact on the build that contains the SARIF report.
* Code scanning alerts are there under the project's security tab
    * <https://github.com/pmd/pmd-github-action-tests/security/code-scanning?query=is%3Aopen+branch%3Ajava>
    * Note: these are rule violations from the quickstart ruleset

### Pull requests

**Description:**

* Changes from pull request should be analyzed

**Execution steps:**

1. Create a new branch in your personal fork
2. Update version in `build.yml` to be `pmd/pmd-github-action@main` or whatever version to test
2. Change file `src/classes/LocalVariableNamingConventionsSample.cls` - copy method `bar` as `foo`.
4. Push branch and create a PR

**Expected:**

* There should be at least two reported violations in the build (bar and foo)
    * note: the buils is run 3 times for each OS
    * in total there are 6 violations (errors), two per OS
* Two annotated locations in the pull request "Files changed" tab for (changed) file "AvoidCatchingThrowableSample.java"
    * note: the build is run 3 times for each OS - so every annotation should repeat 3 times

