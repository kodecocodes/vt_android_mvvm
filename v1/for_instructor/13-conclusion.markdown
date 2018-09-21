# Android MVVM
# 10 - Conclusion

You've reached the end of this course on Android MVVM. Great job getting through the course!

[Slide 1 - Android MVVM]

You've built out two screens of an app that each utilize a ViewModel to connect the Model and View layers. You've used JUnit and Mockito to add unit tests that run directly on the JVM. You used LiveData to allow your View to observe changes in your ViewModel. You've used the Repository pattern to connect to a Room database as your datasource. And, you've used Data Binding to connect the View to a ViewModel.

[Slide 2 - Where to go from here?]

MVVM is just one of several architecture patterns to consider using for your Android app. Another is Model View Presenter or MVP, which is like MVVM but instead uses a Presenter class to mediate the interaction between the Model and View. There is also Model View Intent or MVI, which is a newer pattern that many teams are starting to adopt instead of MVP or MVVM. MVI is a unidirectional pattern that helps you effectively manage app state. You can also combine aspects of these patterns, for example, by including both a ViewModel and a Presenter into something like MVVMP.  That can further help separate the responsibilities of managing the View versus other business logic.

Finally, an architectural pattern you definitely want to check out is Clean Architecture. Clean Architecture helps you manage more complicated systems, ones that have many layers beyond the user interface. As your Android app grows, you may want to combine Clean Architecture with one of the other presentation-related architectures such as MVP or MVVM.

I hope you enjoyed this introduction to MVVM on Android. Look for more courses and tutorials on architecture patterns coming soon, and thanks for watching.
