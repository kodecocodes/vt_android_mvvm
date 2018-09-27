# Course Metadata

### Course Title:
MVVM on Android

### Course Description:
In this course, you will learn how to build an Android app using the Model-View-ViewModel presentation architecture pattern, including testing and data binding.

### Difficulty Level:
Intermediate

## Language, Editor and Platform versions used in this course:

* **Language:** Kotlin 1.2
* **Platform:** Android 4.4+
* **Editor**: Android Studio 3.1.4

-----

# Video Metadata

[TODO: List out each section and each video within that section. For each video, provide a description that is **between 100 and 160 characters long**.

If a video uses a different language, platform, or editor than is used in the rest of the course, specify in brackets at the end of the description.

The first video in each course is automatically free to non-subscribers. Choose one other video that you think might entice people to subscribe and watch the entire course, and mark it with [FREE] at the end of the description.]

## Single Part Course

1. **Introduction**: Let's review what you will be learning in this course, including a brief discussion of benefits of MVVM and the course sample project.

2. **MVVM**: Learn about the need for architecture patterns like MVVM and define the layers of an MVVM app.

3. **Building the Model**: Create the Model layer for the course sample project, including adding JUnit tests of Model layer classes.

4. **Model Repository**: Create a repository interface for saving your Model data, and implement a concrete version of the repository using the Room database library.

5. **The View**: Examine the XML layout file and Kotlin class that constitute the View layer of the Add Creature screen.

6. **Building the ViewModel**: See how to use the Android Architecture Component ViewModel and LiveData classes to create a ViewModel layer for your app.

7. **Testing the ViewModel**: Use JUnit to add unit tests for the functionality of the ViewModel layer, while utilizing Mockito to mock dependent classes. 

8. **Saving to the Repository**: Add the ability for the ViewModel to save Model data into the repository when receiving user events from the View layer.

9. **Challenge: ViewModel Test**: Prove out your understanding of writing ViewModel tests by adding a test to ensure that a Creature without defined attributes cannot be saved.

10. **Challenge: ViewModel**: Put your new MVVM skills to work by creating a ViewModel for the All Creatures screen that shows a list of all creatures in the repository.

11. **Data Binding 1**: See how to add Data Binding to your Android app and how to bind user actions in the View to methods in the ViewModel.

12. **Data Binding 2**: Learn how to setup two-way data binding between an element in the View layer and a property on the ViewModel.

13. **Conclusion**: Review what you learned in the course and learn about other potential architecture patterns for your Android apps.
