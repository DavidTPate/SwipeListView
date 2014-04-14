SwipeListView [![Build Status](https://travis-ci.org/DavidTPate/SwipeListView.svg)](https://travis-ci.org/DavidTPate/SwipeListView)
=================

SwipeListView is a standalone library that is designed to facilitate using 
swipe motions in an Android ListView to reveal something behind the item.

*For usage instructions please see [the website][1].*

Continuous integration is provided by [Travis CI][2].

Gradle
======
```groovy

repositories {
    mavenCentral()
}

dependencies {
    compile('com.davidtpate:swipelistview:0.+@aar')
}

```

Maven
=====

Downloadable .jars can be found on [Maven][3].

You can also depend on the .jar through Maven:

```xml
<dependency>
    <groupId>com.davidtpate</groupId>
    <artifactId>swiplistview</artifactId>
    <version>(insert latest version)</version>
</dependency>
```

Usage
=====
**List**
```xml
<com.davidtpate.swipelistview.SwipeListView
        xmlns:swipeListView="http://schemas.android.com/apk/res-auto"
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        swipeListView:frontViewId="@+id/front"
        swipeListView:backViewId="@+id/back"
        swipeListView:closeAllWhenScrolling="[true | false]"
        swipeListView:openOnLongPress="[true | false]"
        swipeListView:swipeDirection="[both | left | right]"/>
```

* `frontViewId` - **Required** - The generated id of the front of the list item.
* `backViewId` - **Required** - The generated id of the back of the list item to be revealed.
* `closeAllWhenScrolling` - *Optional* - Enable/disable closing all currently revealed items when the list is scrolled. Default - true
* `openOnLongPress` - *Optional* - Enable/disable long press revealing and hiding the list item that was long pressed. Default - true
* `swipeDirection` - *Optional* - Enable/disable directional gestures. Setting this to `left` only allows swiping items left, etc. Default - both

**List Item**
```xml 
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:descendantFocusability="blocksDescendants">

    <LinearLayout
        android:id="@+id/back"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"
        android:visibility="gone">

        <ImageButton
            android:id="@+id/ib_view"
            android:src="@drawable/ic_action_picture"/>

        <ImageButton
            android:id="@+id/ib_save"
            android:src="@drawable/ic_action_save"/>

        <ImageButton
            android:id="@+id/ib_share"
            android:src="@drawable/ic_action_share"/>

        <ImageButton
            android:id="@+id/ib_open"
            android:src="@drawable/ic_action_globe"/>

    </LinearLayout>

    <LinearLayout
        android:id="@+id/front"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal">
        <TextView
            android:id="@+id/tv_text"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:padding="15dp"/>

    </LinearLayout>
</FrameLayout>
```

Developed By
============

* David Pate - <me@davidtpate.com>

License
=======

    Copyright 2014 David Pate

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [1]: http://swipelistview.davidtpate.com/
 [2]: https://travis-ci.org/DavidTPate/SwipeListView
 [3]: http://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.davidtpate&a=swipelistview&v=LATEST