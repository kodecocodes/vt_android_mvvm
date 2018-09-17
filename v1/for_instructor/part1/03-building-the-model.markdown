

```kotlin
data class Creature(
    val attributes: CreatureAttributes = CreatureAttributes(),
    val hitPoints: Int = 0,
    val name: String,
    val drawable: Int = 0
)
```





```kotlin
class CreatureGeneratorTest {
   private lateinit var creatureGenerator: CreatureGenerator
    
   @Before
  fun setup() {
    creatureGenerator = CreatureGenerator()
  }
    
   @Test
  fun testGenerateHitPoints() {
    val attributes = CreatureAttributes(
        intelligence = 7,
        strength = 3,
        endurance = 10
    )
    val name = "Rikachu"
     val expectedCreature = Creature(attributes, 84, name)
     assertEquals(expectedCreature, creatureGenerator.generateCreature(attributes, name))
   }
}
```





```kotlin

class CreatureGenerator {
    
   fun generateCreature(attributes: CreatureAttributes, name: String = "", drawable: Int = 0): Creature {
    val hitPoints = 5 * attributes.intelligence +
        3 * attributes.strength +
        4 * attributes.endurance
     return Creature(attributes, hitPoints, name, drawable)
  }
}
```

