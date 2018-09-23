# Android MVVM
# 03 - Building the Model

## Demo

I have the starter project for the course open up here in Android Studio 3.1.4.

The starter project has three packages: app, model, and view. The starter code is there to give us a head start on building out the Creaturemon app using MVVM.

The app package has an Application subclass for the app, and a file with extension functions for some Kotlin classes.

The view package has Activity, Adapter, and other classes that make up the app UI. We'll talk about the View classes in a later video.

In this video, we'll build out the classes in the model package. The starter code includes some code for persisting to Room database, which will do in a later video.

There are some classes that we'll use for creature attributes, and some blank classes that we'll start filling out in this video.

I'll build a run the starter app now to get a sense of what we want the app to look like.

The first screen will later be used to show the list of creatures we've created. 

There's a menu option we'll later use to clerar all creatures.

Hitting the floating action button, we see the Add Creature screen, which is where we'll work for most of the course.

You see we can tap near the top of the screen to choose an avatar for the creature.

We can assign a name to the creature, as well as intelligence, strength, and endurance attributes.

There's a spot of the bottom to show the creature HitPoints value, based on the attributes.

And there's a button we'll use to save the new creature.

## [Slide 1 - Model]

In this video, we're going to build up the model classes we need for our Creature data. The main class is Creature, which has a set of CreatureAttributes and some other properties for each creature.

## Demo

Back in Android Studio now, open up the CreatureAttributes file. This is a simple data class with an Int value for each of the three Creature attributes.

Next, open the Creature file to see the blank Creature class in the starter project.

Let's convert this model class to a data class, and add properties for the Creature attributes, hitPoints, name, and also an Int for the avatar drawable value.

```kotlin
data class Creature(
    val attributes: CreatureAttributes = CreatureAttributes(),
    val hitPoints: Int = 0,
    val name: String,
    val drawable: Int = 0
)
```

We need a class in our Model to generate a creature based on the values input by the user on the Add Creature screen.

## [Slide 2 - HitPoints]

In particular, we need to calculate the hitpoints value for a creature based on this formula. Hitpoints is equal to 5 times the intelligence attribute, plus 3 times the strength attribute, plus 4 times the endurance attribute. The Creaturemon game favors intelligence over all else.

## [Slide 3 - TDD]

We'll do a little Test-Driven Development and write our test first for the class that will generate a creature. If you've not done TDD before, just know that TDD is a test-first approach we're you peform a Red-Green-Refactor cycle. Red means you first write a failing test, and then write the code that makes the test Green by passing.

## Demo

In the test package, create a new package model.

Now add a new Kotlin file to the package named CreatureGeneratorTest.

```kotlin
class CreatureGeneratorTest {

}
```

Next add a CreatureGenerator property to the test class. CreatureGenerator does not exist yet, so we'll see some compiler errors.

```kotlin
   private lateinit var creatureGenerator: CreatureGenerator
```

We'll initialize creatureGenerator in a setup() method tagged with the @Before annotation:

```kotlin
   @Before
  fun setup() {
    creatureGenerator = CreatureGenerator()
  }
```

Let's go into the model package in the app and create the CreatureGenerator class to clear the compiler error.

```kotlin
class CreatureGenerator
```

Back in the test class, add the test for the hit point calculation. We first arrange the expectedCreature from the generator. 

```kotlin
   @Test
  fun testGenerateHitPoints() {
    val attributes = CreatureAttributes(
        intelligence = 7,
        strength = 3,
        endurance = 10
    )
    val name = "Rikachu"
     val expectedCreature = Creature(attributes, 84, name)
   }
```

We use an intelligence value of 7, strength of 3, and endurance of 10. The resulting hitPoints from the hitPoint formula are 84, so we can create an expectedCreature that we give a name of Rikachu, a raywenderlich version of Pikachu.

We can not perform the action we're testing on the generator, and assert that the result is equal to expectedCreature.

```kotlin
 assertEquals(expectedCreature, creatureGenerator.generateCreature(attributes, name))
```

In the Creature class, create a shell of the generateCreature() method so that we can run the failing test.

```kotlin

class CreatureGenerator {
    
   fun generateCreature(attributes: CreatureAttributes, name: String = "", drawable: Int = 0): Creature {
     return Creature()
  }
}
```

The creature constructor has default values for it's properties.

We can run the test class now and see the expected failure, since we've not added the hitPoints calculation yet.

Now, we can add the hitPoints calculation to CreatureGenerator and return the generated Creature.

```kotlin
    val hitPoints = 5 * attributes.intelligence +
        3 * attributes.strength +
        4 * attributes.endurance
    return Creature(attributes, hitPoints, name, drawable)
```

Finally, we can run our CreatureGenerator test again, and see a green passing test.

With our Creature model class setup, in the next video, we'll start building out the repository in which we'll save Creature data.