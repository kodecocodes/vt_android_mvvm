# Android MVVM
# 07 - Testing the View Model

## Demo

In testing the model layer, we used TDD.

For the view model, we'll now add a test for the view model we've just created.

Since the viewmodel depends on CreatureGenerator in the model layer, we'll create a mock creature generator in our view model test, to ensure that we're isolating the test to the view model. We'll create the mock creature generator using the Mockito library.

In the app module build.gradle, add the Mockito dependency to the testImplementation:


```gradle
  testImplementation "org.mockito:mockito-core:2.11.0"
```

Since we're using ViewModel and LiveData from Android Architecture components, we also need to add the associated testing dependency.

```grad
testImplementation "android.arch.core:core-testing:$arch_comp_version"
```

Open CreatureViewModel, select the class name, and hit option+return on Mac or alt+enter on PC to create an associated test class.

```kotlin
class CreatureViewModelTest {
}
```

We confirm that the new file is in the viewmodel subpackage of the test right.

Add a property for the viewmodel being tested.

```kotlin
  private lateinit var creatureViewModel: CreatureViewModel
```

Since our ViewModel uses LiveData, we need to add a test rule that swaps out the background thread executor normally used with a synchronous thread executor.

```kotlin
  @get:Rule
  var rule: TestRule = InstantTaskExecutorRule()
```

Next, we add a property for the mock creature generator for the view model.

```kotlin
  @Mock
  lateinit var mockGenerator: CreatureGenerator
  
```

We add a setup method annotated with @Before, and in the method we init the mocks and setup the creatureViewModel property to be tested.

```kotlin
  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
    creatureViewModel = CreatureViewModel(mockGenerator)
  }
```

Now we'll add a test for the creature being created in the view mode, testSetupCreature(). First we arrange the expected value as a stubCreature.

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

We use the when method for the mock generator to return stubCreature.

Now we perform the action being tested, which is a called to updateCreature on the viewmodel.

```kotlin
 
    creatureViewModel.updateCreature()
   
```

Now we assert that the viewmodel creature is the stubcreature we're expecting.

```kotlin
    assertEquals(stubCreature, creatureViewModel.creature)
```

We can go ahead and run the tests and see that the view model updateCreature method is working correctly.