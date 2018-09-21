

app build.gradle in android block

```groovy
dataBinding {
  enabled = true
}
```



```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools">

  <data>
    <variable
      name="viewmodel"
      type="com.raywenderlich.android.creaturemon.viewmodel.CreatureViewModel" />
  </data>
```







```xml
android:onClick="@{() -> viewmodel.saveCreature()}"
```



```kotlin
lateinit var binding: ActivityCreatureBinding
```



```kotlin
binding = DataBindingUtil.setContentView(this, R.layout.activity_creature)
```



???

```kotlin
binding.viewmodel = viewModel
```



```kotlin
  private val saveLiveData = MutableLiveData<Boolean>()
```



```kotlin
  fun getSaveLiveData(): LiveData<Boolean> = saveLiveData
```



```kotlin
  fun saveCreature() {
    return if (canSaveCreature()) {
      repository.saveCreature(creature)
      saveLiveData.postValue(true)
    } else {
      saveLiveData.postValue(true)
    }
  }
```



REMOVE from CreatureActivity

```kotlin
    saveButton.setOnClickListener {
      if (viewModel.saveCreature()) {
        Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
        finish()
      } else {
        Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
      }
    }
```

Add

```kotlin
    viewModel.getSaveLiveData().observe(this, Observer { saved ->
      saved?.let {
        if (saved) {
          Toast.makeText(this, getString(R.string.creature_saved), Toast.LENGTH_SHORT).show()
          finish()
        } else {
          Toast.makeText(this, getString(R.string.error_saving_creature), Toast.LENGTH_SHORT).show()
        }
      }
    })
```

