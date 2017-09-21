# DottedProgressBarDemo

An example implementation of customized Horizontal Progress Bar (DottedProgressBar).

This library has a custom view which acts as a progress bar with dots as demarcation as the progress levels.

Easy to use and highly customizable.

The demo project has implementation with this DottedProgressBar.


<b>NOTEABLE ATTRIBUTES : </b>

    <attr name="emptyDotsColor" format="reference|color"/>
    <attr name="activeDotColor" format="reference|color"/>
    <attr name="dotSize" format="dimension"/>
    <attr name="maxProgress" format="integer"/>
    <attr name="progress" format="integer"/>
    <attr name="strokeWidth" format="integer"/>

All these customizations are available through Java code as well

<b>Integration</b>

Add it on your gradle build:

```groovy
dependencies {
    compile 'com.prashant.android:dottedprogressbar:1.0.1'
}
```

<b>Screenshots</b>

![Alt text](/screenshots/img1.png?raw=true)

![Alt text](/screenshots/img2.png?raw=true "Exception View")


<b>License</b>

Apache-2.0 

<b>Features loved to be added</b>
1. Animation support when switching between dots

