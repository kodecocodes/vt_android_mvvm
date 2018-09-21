



```xml
    <EditText
      android:id="@+id/nameEditText"
      android:layout_width="0dp"
      android:layout_height="wrap_content"
      android:layout_margin="@dimen/dp_16"
      android:hint="@string/creature_name"
      android:inputType="text"
      android:text="@={viewmodel.name}"
      app:layout_constraintBaseline_toBaselineOf="@+id/nameLabel"
      app:layout_constraintEnd_toEndOf="parent"
      app:layout_constraintStart_toEndOf="@+id/nameLabel" />
```



```kotlin
var name = ObservableField<String>("")
```



```kotlin
  fun updateCreature() {
    val attributes = CreatureAttributes(intelligence, strength, endurance)
    creature = generator.generateCreature(attributes, name.get() ?: "", drawable)
    creatureLiveData.postValue(creature)
  }
```



```kotlin
  fun canSaveCreature(): Boolean {
    val name = this.name.get()
    name?.let {
      return intelligence != 0 && strength != 0 && endurance != 0 &&
          name.isNotEmpty() && drawable != 0
    }
    return false
  }
```



CreatureActivity

REMOVE

```kotlin
    configureEditText()
```







CreatureViewModelTest

```kotlin
creatureViewModel.name.set("")
```



```kotlin
creatureViewModel.name.set("My Creature")
```



Run tests





Run app. Add creature.