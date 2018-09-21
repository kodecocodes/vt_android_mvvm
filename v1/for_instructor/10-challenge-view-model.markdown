



```kotlin
class AllCreaturesViewModel(private val repository: CreatureRepository = RoomRepository()) : ViewModel() {
  
  private val allCreaturesLiveData = repository.getAllCreatures()

  fun getAllCreaturesLiveData() = allCreaturesLiveData

  fun clearAllCreatures() = repository.clearAllCreatures()
}
```



AllCreaturesActivity



```kotlin
private lateinit var viewModel: AllCreaturesViewModel
```



```kotlin
viewModel = ViewModelProviders.of(this).get(AllCreaturesViewModel::class.java)
```



```kotlin
    viewModel.getAllCreaturesLiveData().observe(this, Observer { creatures ->
      creatures?.let {
        adapter.updateCreatures(creatures)
      }
    })
```



```kotlin
viewModel.clearAllCreatures()
```



CreatureAdapter

```kotlin
      itemView.avatarListItem.setImageDrawable(itemView.context.getDrawable(creature.drawable))
      itemView.name.text = creature.name
      itemView.hitPoints.text = creature.hitPoints.toString()
```

