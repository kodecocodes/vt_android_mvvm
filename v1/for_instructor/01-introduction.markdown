# Android MVVM
# 01 - Introduction

Hey everyone! My name is Joe, and welcome to this course on Android MVVM.

[Slide 1 - MVVM]

MVVM stands for Model-View-ViewModel, and it's one of the more popular patterns for structuring your Android app code. In this course, I'll introduce you to the ideas of MVVM and you'll get to use it hands-on inside an Android app project.

[Slide 2 - Benefits of MVVM]

MVVM helps you separate your code into different layers that each have their own responsibilities. As opposed to, for example, putting most of your app code into Activity or Fragment classes. By using MVVM, you make your code more readable, testable, and maintainable. These are key aspects of building a code base that stands the test of time and frequent app updates.

[Slide 3 - Sample app]

Creaturemon is the name of the sample project we'll use in the course. The app lets you create characters to use in a Creaturemon game. You can assign Intelligence, Strength, and Endurance values to each character. The app calculates a resulting HitPoints value for the characters. 

[Slide 4 - Course Outline]

We'll first build out the screen that lets you create new characters. We'll walk though creating and testing the Model, which will be independent of the ViewModel and View layers. We'll setup a repository to let you store character data in a Room database. Next, we'll create a ViewModel and add unit tests for the logic contained in the ViewModel. Then we'll connect the ViewModel to the repository to allow you to save creatures into app database. And we'll wrap up with a challenge for you to finish the app by creating a ViewModel for the screen that shows a list of all the characters.

There's a lot to do, but before we dive into the code, let's get started in the next video by taking a look at the ideas and concepts behind MVVM.