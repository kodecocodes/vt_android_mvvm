# Android MVVM
# 08 - Saving to the Repository

# Demo

In this video, we'll save new creatures into the repository we previously setup.

We don't want the user to be able to save creatures with blank attributes, for example, a blank name. Let's write a test to make creatures with blank names can't be saved.


```kotlin
  @Test
  fun testCantSaveCreatureWithBlankName() {
    creatureViewModel.intelligence = 10
    creatureViewModel.strength = 3
    creatureViewModel.endurance = 7
    creatureViewModel.drawable = 1
    creatureViewModel.name = ""
     val canSaveCreature = creatureViewModel.canSaveCreature()
     assertEquals(false, canSaveCreature)
  }
```

The canSaveCreature method does not exist yet, so we'll add it next.

In CreatureViewModel, add a repository property to connect the viewmodel to the creature repository.

```kotlin
private val repository: CreatureRepository = RoomRepository()
```

The type on the repository property is the CreatureRepository interface, but the default value for it is the concrete RoomRepository. If your app is sufficiently complex, you may want to use a dependency injection framework like Dagger 2 or Koin to inject the repository into the viewmodel. Having the repository be passed in to the viewmodel as a constructor property is enough injection for our case.

In CreatureViewModelTest, add a mock for the creature repository.

```kotlin
  @Mock
  lateinit var repository: CreatureRepository
```

And update thge setup method to add the mock into the constructor call for the view model.

```kotlin
creatureViewModel = CreatureViewModel(mockGenerator, repository)
```

Now we add canSaveCreature() into the viewmodel.

```kotlin
   fun canSaveCreature(): Boolean {
    return intelligence != 0 && strength != 0 && endurance != 0 &&
        name.isNotEmpty() && drawable != 0
  }
```

We have a condition that none of intelligence, strength, endurance and drawable can be zero, and the name cannot be empty.

Add a saveCreature() method to the viewmodel that calls canSaveCreature() and saves the creature to the repository if the creature can be saved.

```kotlin
  fun saveCreature(): Boolean {
    return if (canSaveCreature()) {
      repository.saveCreature(creature)
      true
    } else {
      false
    }
  }

```

Now we'll run our new test for the viewmodel and see that they pass.

We'll leave writing more tests for other empty properties in the viewmodel as a challenge for you.

In CreatureActivity, in the click listener for the save button, we can now ask the view model to save the creature.

```kotlin
      if (viewModel.saveCreature()) {
        Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
        finish()
      } else {
        Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
      }
```

If the creature saves, we show a toast and finish, otherwise, we show an error toast.

Build and run the app now.

I'll create and save a couple of new creatures.

We can use Device File Explorer to see that the Room database file for storing creratures has been created. In a later video, we'll pull creatures out of the database for display.