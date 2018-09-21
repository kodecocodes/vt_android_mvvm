# Android MVVM
# 02 - Model-View-ViewModel

As you start to build more complicated apps, the way in which you structure the app code becomes more and more important. Many introductions to Android app development ignore the structure of the project code in favor of focusing on specific things, like building the app user interface or working with a specific Android API. The end result is that many educational resources put a good portion of the app code into Activity or Fragment classes. Many newer developers then start building apps in a similar way.

[Slide 1 - "Massive View Controller"]

But having the bulk of your code in Activities and Fragments is problematic for many reasons. The code does not follow the principle of separation of concerns, which recommends that each class stay focused on a small number of separate responsibilities. For example, one main responsibility of Activity classes is responding to lifecycle events from the operating system. Adding in non-lifecycle business logic to an Activity breaks separation of concerns. It also becomes difficult to unit test your business logic, since you typically must run Activity tests on a device or emulator, whereas you'd prefer to run unit tests outside of a device or emulator and solely on the JVM. Your code also becomes difficult to maintain, since it's all piled into a small number of large Activity or Fragment classes. In the iOS world, building your code this way is nicknamed Massive View Controller, since iOS view controllers, the equivalents in some ways to Android Activities, are often created with too much code that goes beyond their prime responsibilties.

[Slide 2 - Model-View-Controller]

The term Massive View Controller is a play on Model-View-Controller or MVC, one of the fundamental architecural patterns for software development. Developers use the MVC pattern across many different domains in the software world, from backend to web, mobile, and others.

[Slide 3 - MVC View]

Mobile developers tend to think of the View in MVC as view classes in the user interface, but you can also consider the View in a more abstract way as the interface with user of the software. The View could be textual in a command line app, or it may be audio-based.

[Slide 4 - MVC Model]

You can think of the Model layer as the data or information in the software. The Model layer contains classes for creating the objects that form the content of your app, such as songs in a music app or photos in a photo app.

[Slide 5 - MVC Controller]

The controller mediates interactions between the View and the Model. The View shows app data to a user. When the user interacts with the app, the Controller then updates the app data in some way. Conversely, the Controller propagates any changes that occur in the Model layer to the View. MVC is a proven approach to user interface architecture, but it can be vulnerable to issues like having too much responsibilites placed on the Controller classes, such as handling business logic, making network calls, and communicating with a database. As a consequence, developers have created a number of variations on MVC over time.

[Slide 6 - Model-View-ViewModel]

One of those variations is MVVM. MVVM handles the interaction between the View and ViewModel layers in a specific way. The ViewModel gathers data from the Model layer and provides that data to the View for display. The View sends user events to the ViewModel, which then updates the Model as needed.

[Slide 7 - Repository]

MVVM can be easily augmented with additional patterns, like the Repository pattern. A Repository helps to manage data updates in local databases or remote data stores. We'll use a Repository in the course to store our data locally in a Room database.

[Slide 8 - UI Updates: Data Binding]

There a few different ways to handle view updates in the View layer. A common one on Android is to use Data Binding, in which you add code to your XML layout files that binds the View to properties in the ViewModel. If the data in the ViewModel changes, the View is automatically updated.

[Slide 9 - UI Updates: LiveData]

An alternative approach, and the one we'll use in this course, is to use the LiveData class in the Android Architecture Components library from Google. We'll also use the ViewModel Architecture Component for our view models. The View layer observes the LiveData in the ViewModel, and new data sent along in the LiveData object causes the View to update with the new data. One of the main benefits of using the Architecture Components in general is that they are lifecycle-aware, and allow you to avoid the need to add code to handle configuration changes such as device rotation.

Ok, that's enough theory for now. In the next video, we'll start coding by building out the Model layer of the Creaturemon app.