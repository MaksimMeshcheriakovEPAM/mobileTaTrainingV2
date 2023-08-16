# For running tests use testNG.xml file

1. **_nativeTNG.xml_** for running tests for native app (put your .apk to src/main/resources folder)
2. **_webTNG.xml_** for running tests for web app

Change parameter 'deviceName' in _testNG.xml_ file if you want to run tests on real device

If you use appium version 1, change <ts.appium> property in pom.xml to http://localhost:4723/wd/hub and remove parameter 'automationName' from _testNG.xml_ files and _BaseTest_ class.
