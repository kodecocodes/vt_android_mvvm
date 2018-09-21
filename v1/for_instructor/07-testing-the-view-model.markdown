```gradle
  testImplementation "org.mockito:mockito-core:2.11.0"
```



```grad
testImplementation "android.arch.core:core-testing:$arch_comp_version"
```





```kotlin
class CreatureViewModelTest {
}
```



```kotlin
  private lateinit var creatureViewModel: CreatureViewModel
```



```kotlin
  @get:Rule
  var rule: TestRule = InstantTaskExecutorRule()
```



```kotlin
  @Mock
  lateinit var mockGenerator: CreatureGenerator
  
```



```kotlin
  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
    creatureViewModel = CreatureViewModel(mockGenerator)
  }
```



```kotlin
  @Test
  fun testSetupCreature() {
    val attributes = CreatureAttributes(10, 3, 7)
    val stubCreature = Creature(attributes, 87, "Test Creature")
    `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)
    
    creatureViewModel.intelligence = 10
    creatureViewModel.strength = 3
    creatureViewModel.endurance = 7
  }
```



```kotlin
 
    creatureViewModel.updateCreature()
   
```



```kotlin
    assertEquals(stubCreature, creatureViewModel.creature)
```

