

```kotlin
class CreatureViewModel(private val generator: CreatureGenerator = CreatureGenerator()) : ViewModel() {
 
  

}
```



```kotlin
  private val creatureLiveData = MutableLiveData<Creature>()
  
  fun getCreatureLiveData(): LiveData<Creature> = creatureLiveData
```



```kotlin
  var name = ""
  var intelligence = 0
  var strength = 0
  var endurance = 0
  var drawable = 0
  
  lateinit var creature: Creature
```





```kotlin
  fun updateCreature() {
    val attributes = CreatureAttributes(intelligence, strength, endurance)
    creature = generator.generateCreature(attributes, name, drawable)
    creatureLiveData.postValue(creature)
  }
```



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



```kotlin
  fun drawableSelected(drawable: Int) {
    this.drawable = drawable
    updateCreature()
  }
```



CreatureActivity



```kotlin
private lateinit var viewModel: CreatureViewModel
```



```kotlin
viewModel = ViewModelProviders.of(this).get(CreatureViewModel::class.java)
```



```kotlin
viewModel.attributeSelected(AttributeType.INTELLIGENCE, position)
...
viewModel.attributeSelected(AttributeType.STRENGTH, position)
...
viewModel.attributeSelected(AttributeType.ENDURANCE, position)
```



```kotlin
viewModel.name = s.toString()
```



```kotlin
viewModel.drawableSelected(avatar.drawable)
```



In configureUI()

```kotlin
if (viewModel.drawable != 0) hideTapLabel()
```



```kotlin
  private fun configureLiveDataObservers() {
    viewModel.getCreatureLiveData().observe(this, Observer { creature ->
      creature?.let {
        hitPoints.text = creature.hitPoints.toString()
        avatarImageView.setImageResource(creature.drawable)
        nameEditText.setText(creature.name)
      }
    })
  }
```

onCreate()

```kotlin
configureLiveDataObservers()
```

