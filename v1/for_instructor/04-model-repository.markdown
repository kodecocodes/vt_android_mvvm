# Android MVVM
# 04 - Model Repository

## [Slide 1 - Repository]

In this video, we're going to setup Repository in which we'll save our Model data.

Our concrete repository is going to be a Room database, and we're going to use LiveData from the Android Architecture Components library to retrieve data from the database. So first we need to setup our dependency on the Architecture Componets. This same dependency will also be used later when we use the ViewModel class from the library.

## Demo

To add the dependecy, first open the project level build.gradle file, and add the version of the Architecture Components that we'll use, 1.1.1.


```gradle
arch_comp_version = '1.1.1'
```

Now open the app module build.gradle file and add the architecture components dependency.

```gradle
  // ViewModel and LiveData
  implementation "android.arch.lifecycle:extensions:$arch_comp_version"
```

In the model package, open up the file CreatureRepository, which is currently empty. We use an interface for the repository in part becuase it would simplify switching to a different concrete repository other than Room if we needed to for some reason later in our project lifecycle.

We need the ability to save a creature to the repository, get all creatures from the repository, and clear all creatures in the repository, so we add those methods to the interface.

```kotlin
interface CreatureRepository {
  fun saveCreature(creature: Creature)
  fun getAllCreatures(): LiveData<List<Creature>>
  fun clearAllCreatures()
}
```

The return value from the method to getAllCreatures is a LiveData list of creatures.

In order to store our Creatures in Room, we'll make them a Room Entity in the creature_table table.

```kotlin
@Entity(tableName = "creature_table")
data class Creature(
    val attributes: CreatureAttributes = CreatureAttributes(),
    val hitPoints: Int = 0,
    @PrimaryKey @NonNull val name: String,
    val drawable: Int = 0
)
```

We also set the name prooperty as the non-null primary key for a creature. We could have also made a separate class for the Room entity, and then provided mapping functions to convert between Creatures and Creature entities, but for this simple app we'll just make Creature an entity directly. In a production app, you would likely want to create such a mapping layer between the model class and the repository.

Since we're using Room, we need to use a CreatureDao for accessing our creatures. There's an empty Dao in the model room package. We now add insert, clear and getAllCreatures methods to the Dao.

```kotlin
interface CreatureDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(creature: Creature)
   @Delete
  fun clearCreatures(vararg creature: Creature)
   @Query("SELECT * FROM creature_table ORDER BY name ASC")
  fun getAllCreatures(): LiveData<List<Creature>>
}
```

We've used a conflict strategy of replace on the insert method, and we've written the SQL query for getting all creatures from the database. One nice feature of Room is that it validates your SQL code at compile time.

Now we need to open up CreatureDatabase and tell the database about our new Creature entity.

```kotlin
@Database(entities = [(Creature::class)], version = 1)
@TypeConverters(CreatureAttributesConverter::class)
```

We've also added a type converter that for storing CreatureAttributes in the database. The CreatureAttributesConverter class was included in the starter project, and just converts the creature attributes for storage in room.

Next, open up the RoomRepository class, which is a concrete implementation of the CreatureRepositoy interface. The starter code has a property for the CreatureDao and some async tasks to perform the creature insert and delete in the background.

First we add an allCreatures property to the repository, which will ask the Dao for all creatures in the init block.

```kotlin
  private val allCreatures: LiveData<List<Creature>>
   init {
    allCreatures = creatureDao.getAllCreatures()
  }

```

Then we add the methods from the CreatureRepository inteface, using the async tasks as needed.

```kotlin
   override fun saveCreature(creature: Creature) {
    InsertAsyncTask(creatureDao).execute(creature)
  }
   override fun getAllCreatures() = allCreatures
   override fun clearAllCreatures() {
    val creatureArray = allCreatures.value?.toTypedArray()
    if (creatureArray != null) {
      DeleteAsyncTask(creatureDao).execute(*creatureArray)
    }
  }
```

In the InsertAsyncTask, we add a line to insert the creature using the dao.

```kotlin
dao.insert(params[0])
```

We do similar in the DeleteAsyncTask for clearing creatures.

```kotlin
dao.clearCreatures(*params)
```

As a last step for setting up the repository, we open up the application class in the app package and replace the todo in onCreate with a line to build the Room database.

```kotlin
    database = Room.databaseBuilder(this, CreatureDatabase::class.java, "creature_database")
        .build()
```

We build and run app to make sure all is ok.

The app starts up with no errors, so it looks like we've setup Room correctly. In a later video, we'll finish the ability to save creatures into the repository from the app user inteface.