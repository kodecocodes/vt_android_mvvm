



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

