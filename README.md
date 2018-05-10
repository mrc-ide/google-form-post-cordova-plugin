# Google Form Post Cordova Plugin
Apache Cordova plugin to allow a JavaScript app to use a native Java plugin on
Android to submit data to a Google Form.

This allows you to get around the cross-origin problem you would have if you
directly posted from the JavaScript.

```
 ________          ________          ________
|        |  Call  |  This  |  Post  | Google |
|   JS   |  --->  | Plugin |  --->  |  Form  |
|________|        |________|        |________|

```

Used by:

* https://github.com/mrc-ide/zimbabwe-hiv-survey

## Local development
For local development this is a gradle project. When used in the context of a Cordova app, Cordova
handles the build, so the gradle file here is only for local development and debugging. Similarly,
the Android manifest file in `./src/main` is just to get things to play nicely while building
locally, and is not used by Cordova.

Steps to set up your environment for local development:

1. Install and run Android Studio (making sure an SDK is installed)
1. Add `export ANDROID_HOME=/some/path` to your .profile file
1. Run `./gradlew build`

## Tests
JUnit tests can be run through the IDE or by running `./gradlew test`. There are no
javscript tests right now, as the interface is so simple.