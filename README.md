# Google Form Post
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