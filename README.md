# Modularity demos for JavaOne 2015

## Introduction

The commits in this repository represent a series of steps in a live (or recorded) demonstration. What follows are instructions as to how to use this repository as an interactive demo script.

### Prerequisites

 - JDK 1.8

### Caveats

 - IDEA raises DSL-related errors on project import. As a workaround, comment out the contents of all build.gradle files, import the project, and then uncomment once again.


## View all steps at once

To view all the steps and their changes in order, clone the repository locally run the following command:

    git log -p --reverse step1^..step12


## View and execute each step in order

To walk through and execute each step, first do the following:

    git config alias.steps 'log --reverse --oneline --decorate step1^..step12'

This makes available the convenient alias `git steps`, which can now be run to display the steps in order:

    $ git steps
    3d9fe7b (tag: step1) Add a Java library named foo
    c3241a6 (tag: step2) Add a Java library named bar
    ab5ba99 (tag: step3) Break the build by referencing bar from foo
    a97717e (tag: step4) Fix the build by declaring foo depends on bar
    fae6108 (tag: step5) Refactor foo and bar libs as Gradle submodules
    e11e4ec (tag: step6) Generate Java 7 and 8 binaries for both libraries
    89abd14 (tag: step7) Break the build by targeting Java 6 for foo only
    3555473 (tag: step8) Fix the build by targeting Java 6 for bar as well
    a46f226 (tag: step9) Add a class intended for internal use only by bar
    7d8e9b1 (tag: step10) Reference bar internals from foo (w/out breakage)
    a00c5d3 (tag: step11) Break the build by declaring bar's public API
    ae66547 (tag: step12) Fix the build by removing reference to bar internals

### Check out a step

As seen above, each step is tagged, making it simple to check out. To start at the first step, simply type:

    $ git checkout step1

### Explain and display what changed

Then use `git show` to explain and display the changes in this step:

    $ git show

### Run the build

Finally, run `./gradlew assemble` to run the build and demonstrate the effect of the change:

    $ ./gradlew assemble

### What to expect when running the build

Each step's commit message indicates whether the build should succeed or fail when `./gradlew assemble` is invoked. This can be seen in commit message subject lines that read _Break the build by doing X_ or _Fix the build by doing Y_. If the commit message subject does not explicitly state that it breaks or fixes the build, then the build should succeed.

### Move to the next step and repeat

    $ git checkout step2
    $ git show
    $ ./gradlew assemble


## Maintainer's notes

 - Preserve the one-commit-per-step structure of this repository by rebasing and force pushing as necessary
 - Re-apply `step#` tags following a rebase with `./.retag.sh`
 - When adding new steps:
   - include the string 'This step' in the body of the commit message
   - add new `step#` tags with `./.retag.sh`
   - update git commands in this README that have `step1^..step#` tag ranges
 - Remember to push changes to tags with `git push -f --tags`
