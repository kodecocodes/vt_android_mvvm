# Android MVVM
# 11 - Data Binding Part 1

## [Slide 1 - Data Binding]

On the Add Creature screen we've used LiveData to communicate between the CreatureViewModel and CreatureActivity.

There is an alternative way to let the View layer and ViewModel communicate, and that's using Data Binding.

When using Data Binding, you directly connect views in the XML file with properties on the viewmodel. You also connect actions like button clicks with functions in the viewmodel.

In this video, we'll refactor CreatureViewModel to use data binding to handle the save action on the Add Creature screen. In the next video, we'll bind the EditText in the View to the name property on the view model.

## Demo

To use data binding, you first need to enable it in your build.gradle file.

In the app module build.gradle file, in the android block, use a dataBinding call to enable data binding.

```groovy
dataBinding {
  enabled = true
}
```

Then be sure to sync your Gradle files.

Open up the portrait version of activity_creature.xml.

To connect the XML file to the viewmodel, you need to wrap the root layout in a layout tag. With the cursor on the root ConstraintLayout, hit option+return on Mac or Alt+Enter on PC and choose "Convert to data binding layout" from the popup menu.

This will add a layout tag wrapper and also a data tag to the layout file.

Inside the data tag, we add a variable tag to hold the viewmodel, and we specify its name and type attributes. The name is the one we'll use to refer to the view model in the layout file.

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools">

  <data>
    <variable
      name="viewmodel"
      type="com.raywenderlich.android.creaturemon.viewmodel.CreatureViewModel" />
  </data>
```

Next, in the saveButton tag, add an onClick attribute that uses data binding syntax to call the viewmodel saveCreature() method.

```xml
android:onClick="@{() -> viewmodel.saveCreature()}"
```

The empty parentheses are a spot you could add an argument for the view being clicked, but we don't need that so we leave them empty.

I'll leave it as an unofficial challenge for you to make the same changes to the landscape version of activity_creature.xml.

In CreatureActivity, add a property to represent the binding between the view and viewmodel.

```kotlin
lateinit var binding: ActivityCreatureBinding
```

The ActivityCreatureBinding class was generated when we converted the layout to use data biding.

We can use DataBindingUtil to replace the usual setContentView call in onCreate() and also set the value for the binding property.

```kotlin
binding = DataBindingUtil.setContentView(this, R.layout.activity_creature)
```

We need to set the value for the binding viewmodel to our CreatureViewModel property.

```kotlin
binding.viewmodel = viewModel
```

When the user clicks the save button, the saveCreature() method will be called on the ViewModel through data binding. We need to communicate back to the activity when that save is complete.

Add a saveLiveData property to CreatureViewModel to handle this communication. It's a LiveData of Boolean.

```kotlin
  private val saveLiveData = MutableLiveData<Boolean>()
```

And add an associated getter method.

```kotlin
  fun getSaveLiveData(): LiveData<Boolean> = saveLiveData
```

We need to update the SaveCreature method to post to the saveLiveData when the creature is saved. We can also remove the return value for this method.

```kotlin
  fun saveCreature() {
    return if (canSaveCreature()) {
      repository.saveCreature(creature)
      saveLiveData.postValue(true)
    } else {
      saveLiveData.postValue(true)
    }
  }
```

In CreatureActivity, we can remove the click listener for the save button, since the button click is now being handled by data binding.

REMOVE from CreatureActivity

```kotlin
    saveButton.setOnClickListener {
      if (viewModel.saveCreature()) {
        Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
        finish()
      } else {
        Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
      }
    }
```

In configureLiveDataObservers, we observe saveLiveData on the viewmodel, and in the observer we perform the same actions as before, either showing a success toast and finishing, or showing an error toast.

```kotlin
    viewModel.getSaveLiveData().observe(this, Observer { saved ->
      saved?.let {
        if (saved) {
          Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
          finish()
        } else {
          Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
        }
      }
    })
```

Now build and run the app.

And go ahead and add a new creature, to see that our refactored save action using data binding is working.