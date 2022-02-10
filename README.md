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
2. Copy folder `src/main/java` to `src/main/java2` - these are the "changed" files
3. Push - that's the build that must be verified
4. Revert and push - restore for next test case

**Expected:**

* The latest PMD version should be used (check build logs)
* In total, there should be 10 reported violations - 5 in `AllInOne.java` and for each other file one.
* All files should be from `src/main/java2` - violations in `src/main/java` should *not* be reported.
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
2. Change file `src/main/java/AvoidCatchingThrowableSample.java` - copy method `bar` as `foo`.
3. Change file `src/main/java/ReturnFromFinallyBlockSample.java` - copy method `bar` as `foo`.
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

### Source path is used

**Description:**

* Integrated as "build" workflow on push
* "rulesets" is configured and "sourcePath", everything else is default
* New files in unrelated folder

**Execution steps:**

1. Update version in `build.yml` to be `pmd/pmd-github-action@main` or whatever version to test
2. Add parameter `sourcePath: 'src/main/java'` in `build.yml`
3. Copy folder `src/main/java` to `src/main/java2` - these are the "changed" files
4. Push - that's the build that must be verified
5. Revert and push - restore for next test case

**Expected:**

* There should be no reported violations.
* There should be no annotations in the commit view
* There should be no annotations for the build

### violations output parameter

**Description:**

* Build can be failed based on number of violations

**Execution steps:**

1. Update version in `build.yml` to be `pmd/pmd-github-action@main` or whatever version to test
2. Add another step in `build.yml`:

```yml
    - name: Fail build if there a violations
      if: steps.pmd.outputs.violations != 0
      run: exit 1
```
3. Change file `src/main/java/AvoidCatchingThrowableSample.java` - copy method `bar` as `foo`.
4. Push - that's the build that must be verified
5. Revert and push - restore for next test case

**Expected:**

* Build build should be failed because of two violations (bar and foo).

### Code scanning alerts

**Description:**

* If the SARIF file is uploaded, the violations should appear in the project's security tab
  under "Code scanning alerts".
* It uses the quickstart.xml ruleset
* it checks always all files under `src/main/java`

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
3. Change file `src/main/java/AvoidCatchingThrowableSample.java` - copy method `bar` as `foo`.
4. Push branch and create a PR

**Expected:**

* There should be at least two reported violations in the build (bar and foo)
    * note: the buils is run 3 times for each OS
    * in total there are 6 violations (errors), two per OS
* Two annotated locations in the pull request "Files changed" tab for (changed) file "AvoidCatchingThrowableSample.java"
    * note: the build is run 3 times for each OS - so every annotation should repeat 3 times

