# Android MVVM
# 10 - Challenge: View Model

## [Slide - Challenge]

Your next challenge is to put together all you've learned so far to build a view model for the app's first screen that should show the list of all creatures in the repository.

AllCreaturesActivity is setup already with a RecyclerView and adapter. You'll need to update the view holder in CreatureAdapter, used for the rows of the RecyclerView, to display the data for each creature.

In your view model, create a LiveData object for a List of creatures that AllCreaturesActivity will observe and in the observer, call updateCreatures() on the RecyclerView adapter.

As part of this challenge, you also want to implement the clear all creatures capability in the app menu.

Pause the video and take a shot at building out AllCreaturesViewModel and connecting it to AllCreaturesActivity. When you're ready, unpause to see my solution.

## Demo

First we add AllCreaturesViewModel to the view model package, and put a repository property in its constructor.


```kotlin
class AllCreaturesViewModel(private val repository: CreatureRepository = RoomRepository()) : ViewModel() {
  
}
```

We extend the ArchitectureComponent ViewModel class.

Next we add an allCreaturesLiveData property, and set it equal to the result from calling getAllCreatures() on the repository. We also add a getter for the LiveData.

```kotlin
  private val allCreaturesLiveData = repository.getAllCreatures()

  fun getAllCreaturesLiveData() = allCreaturesLiveData
```

We add a function to clear all creatures in the repository, which we'll call when the user chooses the option in the menu.

```kotlin
fun clearAllCreatures() = repository.clearAllCreatures()
```

In AllCreaturesActivity, we add a viewmodel property.

```kotlin
private lateinit var viewModel: AllCreaturesViewModel
```

And we connect to the viewmodel in onCreate() by using a call to ViewModelProviders.

```kotlin
viewModel = ViewModelProviders.of(this).get(AllCreaturesViewModel::class.java)
```

In onCreate(), we also setup the observer on the all creatures LiveData. In the observer we update the recyclerview adapter.

```kotlin
    viewModel.getAllCreaturesLiveData().observe(this, Observer { creatures ->
      creatures?.let {
        adapter.updateCreatures(creatures)
      }
    })
```

In onOptionsItemSelected for the menu, we call the method on the view model to clear all creatures.

```kotlin
viewModel.clearAllCreatures()
```

Finally, in the view holder of CreatureAdapter, we populate the viewholder itemView with data from the creature in the row.

```kotlin
  itemView.avatarListItem.setImageDrawable(itemView.context.getDrawable(creature.drawable))
itemView.name.text = creature.name
itemView.hitPoints.text = creature.hitPoints.toString()
```

Now we build and run the app.

And sure enough, we see the creatures we've added previously displayed in the RecyclerView.

We can also add a new creature. And it gets added the list straight away.

We can choose the menu option, and all creatures are removed from the repository.

