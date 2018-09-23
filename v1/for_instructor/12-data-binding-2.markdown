# Android MVVM
# 12 - Data Binding Part 2

For our last video in this MVVM course, we'll use data binding to connect the name EditText on the Add Creature screen to the view model.

We've already added the viewmodel as a data value in the activity_creature.xml file. Now add an android:text attribute to the nameEditText view, using the @= data binding syntax.

```xml
    <EditText
      android:id="@+id/nameEditText"
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:layout_margin="@dimen/dp_16"
      android:hint="@string/creature_name"
      android:inputType="text"
      android:text="@={viewmodel.name}"
      app:layout_constraintBaseline_toBaselineOf="@+id/nameLabel"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toEndOf="@+id/nameLabel" />
```

This sets up one-way databinding so that the view will show the value stored in the viewmodel name property.

## [Slide - Two-way data binding]

To go to two-way data binding, where the viewmodel value is updated to whatever the user types into the EditText, there are two options. You can wrap the viewmodel properties in ObservableField, or you can make the ViewModel extend from BaseObservable, which will handle all viewmodel properties at once.

Since we're already extending the architecture component ViewModel class, we'll go with the first option, and use ObservableField.

## Demo

In CreatureViewModel, wrape the name property with ObservableField, and give it a default value of an empty String.

```kotlin
var name = ObservableField<String>("")
```

In updateCreature(), we need to use get() on the name, and use the ElvisOperator to handle null values.

```kotlin
  fun updateCreature() {
    val attributes = CreatureAttributes(intelligence, strength, endurance)
    creature = generator.generateCreature(attributes, name.get() ?: "", drawable)
    creatureLiveData.postValue(creature)
  }
```

Our canSaveCreature method will prevent us from saving creatures with blank names into the database.

But we do need to update canSaveCreature() to convert the extract the from the observable field and use let to handle the null case. 

```kotlin
  fun canSaveCreature(): Boolean {
    val name = this.name.get()
    name?.let {
      return intelligence != 0 && strength != 0 && endurance != 0 &&
          name.isNotEmpty() && drawable != 0
    }
    return false
  }
```

In CreatureActivity, we can remove the configureEditText() method with its on changed listener for the EditText, since we're now using two-way databinding for the name.

REMOVE

```kotlin
    configureEditText()
```

We need to update CreatureViewModelTest to handle the switch to ObservableField.

We use set() to set the name values in two of our tests

```kotlin
creatureViewModel.name.set("")
```

```kotlin
creatureViewModel.name.set("My Creature")
```

Let's run the view model tests again to make sure they're still all passing.

Ok, now we can build and run app one last time.

Let's add one more creature and make sure our name two-way data binding is working as expected.