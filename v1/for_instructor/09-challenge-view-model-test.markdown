# Android MVVM
# 09 - Challenge: View Model Test

## [Slide - Challenge]

You first challenge for the course is to add another test on the CreatureViewModel to make sure that a creature without strength cannot be saved. The test will be very similar to the test we already wrote to make sure that a creature without a name cannot be saved.

Go ahead and pause the video, and take a shot at writing this new test. Unpause when you're ready to see a solution.

## Demo

Add a new test method to CreatureViewModelTest named testCantSaveCreatureWithoutStrength()


```kotlin
  @Test
  fun testCantSaveCreatureWithoutStrength() {
    creatureViewModel.intelligence = 10
    creatureViewModel.strength = 0
    creatureViewModel.endurance = 7
    creatureViewModel.drawable = 1
    creatureViewModel.name = "My Creature"
    val canSaveCreature = creatureViewModel.canSaveCreature()
    assertEquals(false, canSaveCreature)
  }
```

We've set the strength to zero, made sure we added a name to the creature, and then called canSaveCreature() on the viewmodel and asserted that the return value is false.

Go ahead and run the tests to see that they all pass.