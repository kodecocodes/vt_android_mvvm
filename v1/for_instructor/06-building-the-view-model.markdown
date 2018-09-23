# Android MVVM
# 06 - Building the View Model

## [Slide - ViewModel]

With our Model and View in place, we'll now turn to creating a ViewModel for the Add Creature screen named CreatureActivity.

## Demo

First, create a new package in the project named viewmodel.

Next, create a CreatureViewModel class in the package, and have it extend the ViewModel Android Architecture Component class .


```kotlin
class CreatureViewModel : ViewModel() {
 
  

}
```

The ViewModel will need access to a CreatureGenerator, so add a CreatureGenerator property to the constructor and assign it a default value.

```kotlin
class CreatureViewModel(private val generator: CreatureGenerator = CreatureGenerator()) : ViewModel() {
 
  

}
```

The ViewModel will use LiveData to send generated creatures to the View layer, so add a creatureLiveData property and an associated getter function.

```kotlin
  private val creatureLiveData = MutableLiveData<Creature>()
  
  fun getCreatureLiveData(): LiveData<Creature> = creatureLiveData
```

The ViewModel needs to keep track of the selected name and other properties for the creature being created, so add properties for each of those now, using type inference to set the types.

```kotlin
  var name = ""
  var intelligence = 0
  var strength = 0
  var endurance = 0
  var drawable = 0
```

Also add a lateinit property for the Creature being created.

```kotlin
lateinit var creature: Creature
```

Now add a function updateCreatures() to set the creature value for the view model, and post it to the LiveData for the creature.

```kotlin
  fun updateCreature() {
    val attributes = CreatureAttributes(intelligence, strength, endurance)
    creature = generator.generateCreature(attributes, name, drawable)
    creatureLiveData.postValue(creature)
  }
```

Add a method that the View layer will call when the user selects a value in the creature attibute drop downs.

```kotlin
  fun attributeSelected(attributeType: AttributeType, position: Int) {
    when (attributeType) {
      AttributeType.INTELLIGENCE ->
        intelligence = AttributeStore.INTELLIGENCE[position].value
      AttributeType.STRENGTH ->
        strength = AttributeStore.STRENGTH[position].value
      AttributeType.ENDURANCE ->
        endurance = AttributeStore.ENDURANCE[position].value
    }
    updateCreature()
  }
```

When an attribute is selected, we also call the udpateCreatrure method, which will pass the new creature along with it's selected attribute in the LiveData.

Add a similar function attribute for the view layer to call when the creature avatar is selected.

```kotlin
  fun drawableSelected(drawable: Int) {
    this.drawable = drawable
    updateCreature()
  }
```

Now head over the the View layer, CreatureActivity.

Add a property for the viewmodel.

```kotlin
private lateinit var viewModel: CreatureViewModel
```

When using Architecture Component view models, you use ViewModelProviders to connect to the viewmodel, so add that call into onCreate()

```kotlin
viewModel = ViewModelProviders.of(this).get(CreatureViewModel::class.java)
```

Next, replace the TODOs in the configureSpinnerListeners methods with calls to the viewmodel method we added.

```kotlin
viewModel.attributeSelected(AttributeType.INTELLIGENCE, position)
...
viewModel.attributeSelected(AttributeType.STRENGTH, position)
...
viewModel.attributeSelected(AttributeType.ENDURANCE, position)
```

In the text changed listener for the name edit text, replace the todo with a call to update the viewmodel name value.

```kotlin
viewModel.name = s.toString()
```

In the avatareClicked override, set the value of the viewmodel drawable using drawableSelected.

```kotlin
viewModel.drawableSelected(avatar.drawable)
```

Back up in configureUI(), add a call to hideTapLabel() if the drawable value on the viewmodel is non-zero.

```kotlin
if (viewModel.drawable != 0) hideTapLabel()
```

Next we need to handle events being sent on the LiveData in the ViewModel. Add a new method configureLiveDataObservers() and observer creatureLiveData from the viewmodel.

```kotlin
  private fun configureLiveDataObservers() {
    viewModel.getCreatureLiveData().observe(this, Observer { creature ->

    })
  }
```

Inside the observer, update the hitPoints value for the creature, and the avatar image and name views.

```kotlin
    
      hitPoints.text = creature.hitPoints.toString()
        avatarImageView.setImageResource(creature.drawable)
        nameEditText.setText(creature.name)
     
```

We need to wrap these in a let expression since the creature passed to the observer is nullable.

```kotlin
creature?.let {
    ...
}
```

Now add a call to configureLiveDataObservers() in onCreate():

```kotlin
configureLiveDataObservers()
```

Now we can build and run the app and create a new creature.

Notice that when we select attributes in the drop downs, the hitpoints value is immediately updated using the value from the viewmodel.

