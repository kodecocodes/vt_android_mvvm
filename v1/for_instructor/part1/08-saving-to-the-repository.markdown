



```kotlin
  @Test
  fun testCanSaveCreatureBlankName() {
    val attributes = CreatureAttributes(10, 3, 7)
    val stubCreature = Creature(attributes, 87, "", 1)
    `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)
     creatureViewModel.intelligence = 10
    creatureViewModel.strength = 3
    creatureViewModel.endurance = 7
    creatureViewModel.drawable = 1
    creatureViewModel.name = ""
     val canSaveCreature = creatureViewModel.canSaveCreature()
     assertEquals(false, canSaveCreature)
  }
```



CreatureViewModel

```kotlin
private val repository: CreatureRepository = RoomRepository()
```



CreatureViewModelTest

```kotlin
  @Mock
  lateinit var repository: CreatureRepository
```



```kotlin
creatureViewModel = CreatureViewModel(mockGenerator, repository)
```



CreatureViewModel

```kotlin
   fun canSaveCreature(): Boolean {
    return intelligence != 0 && strength != 0 && endurance != 0 &&
        name.isNotEmpty() && drawable != 0
  }
```



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

Run test

Write more tests for other blank properties

CreatureActivity

```kotlin
      if (viewModel.saveCreature()) {
        Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
        finish()
      } else {
        Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
      }
```



Build and run

Create and save creature

Use Device File Explorer to see database file.