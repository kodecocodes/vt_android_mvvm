# Android MVVM
# 01 - Introduction



Hey everyone! My name is Joe, and welcome to this course on Android MVVM.

MVVM stands for Model-View-ViewModel, and it's one of the more popular patterns for structing your Android app code. In this course, you'll be introduced to the ideas of MVVM and get to use it hands-on inside an Android app project.

As you start to build more complicated apps, the way in which you structure the app code becomes more and more important. Many introductions to Android app development ignore the structure of the project code in favor of focusing on specific things like building the app user interface or working a specific Android API. The end result is that many beginner educational resources put a good portion of the app code, including non-UI code like business logic, into Activity or Fragment classes.

[Slide - "Massive View Controller"]

But having the bulk of your code in Activities and Fragments is problematic for a number of reasons. The code does not follow the principle of separation of concerns, where different components such as classes stay focused on a small number of responsibilities. For example, one main responsibility of Activity classes is responding to lifecycle events from the operating system, so adding in unrelated business logic breaks separation of concerns. It also becomes difficult to unit test your code, since you typically must run Activity tests on a device or emulator, whereas you'd prefer to run unit tests outside of a device or emulator and solely on the JVM for speed. Your code also become difficult to maintain, since it's all piled into a small number of Activity or Fragment classes. In the iOS world, building your code this way is nicknamed Massive View Controller, since iOS view controllers, equivalent in some ways to Android activities, often are created in a similar fashion with too much code that goes beyond their prime responsibilties.

[Slide - Model-View-Controller]

The term Massive View Controller is a play on Model-View-Controller, one of the fundamental architecural patterns for software development. The MVC pattern is used across many different domains in the software world, from backend software, to web and mobile. Mobile developers tend to think of the View as view classes in the user interface, but you can also consider the View in a more abstract way as the interface with the software user. You can think of the model layer as the data or information in the software. The controller mediates interactions between the View and the Model. The View displays the app data, the user interacts with the application, and the controller then updates the app data or model in some way. Conversely, any changes that occur in the model layer are propagated to the view by the controller. MVC is a proven approach to user interface architecture, but it can be vulnerable to issues like having too much responsibilites placed on the Controller classes. As a consequence, numerous variations of MVC have been created over time.

[Slide - Model-View-ViewModel]

One of those variations is MVVM. The differences with MVC can be subtle, but in MVVM the interaction between the View and ViewModel layers is handled in a specific way. The ViewModel gathers data drom the Model layer and provides that data for the View to display, and the View sends user events to the ViewModel, which then updates the model as needed.

[Slide - Repository]

MVVM can be easily augmented with additional patterns like the Repository pattern, which helps to manage data updates in the Model layer in local databases or remote data stores.

[Slide - UI Updates: Data Binding]

There a few different ways to handle view updates in the View layer. A common one on Android is to use data binding, in which you add code to your XML layout files that binds the data displayed in the view to properties in the ViewModel. If the data in the ViewModel changes, the view is automatically updated.

[Slide UI Updates: LiveData]

An alternative approach, and the on we'll use in this course, is to use the ViewModel and LiveData classes in the Android Architecture Components library from Google. The View layer will observe the LiveData in the ViewModel, and new data sent along in the LiveData object allows the View to update with the new data.

[Slide - Sample app]

The sample project we'll use in the course is called Creaturemon. The app lets you create characters to be used in a Creaturemon game, assigning Intelligence, Strength, and Endurance values to each character. The app calculates a resulting HitPoints value for each character. 