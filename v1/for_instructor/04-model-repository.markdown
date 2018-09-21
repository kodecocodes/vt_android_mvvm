

```gradle
arch_comp_version = '1.1.1'
```



```gradle
  // ViewModel and LiveData
  implementation "android.arch.lifecycle:extensions:$arch_comp_version"
```







```kotlin
interface CreatureRepository {
  fun saveCreature(creature: Creature)
  fun getAllCreatures(): LiveData<List<Creature>>
  fun clearAllCreatures()
}
```



```kotlin
@Entity(tableName = "creature_table")
data class Creature(
    val attributes: CreatureAttributes = CreatureAttributes(),
    val hitPoints: Int = 0,
    @PrimaryKey @NonNull val name: String,
    val drawable: Int = 0
)
```





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





```kotlin
@Database(entities = [(Creature::class)], version = 1)
@TypeConverters(CreatureAttributesConverter::class)
```



```kotlin
  private val allCreatures: LiveData<List<Creature>>
   init {
    allCreatures = creatureDao.getAllCreatures()
  }
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



```kotlin
dao.insert(params[0])
```



```kotlin
dao.clearCreatures(*params)
```



```kotlin
    database = Room.databaseBuilder(this, CreatureDatabase::class.java, "creature_database")
        .build()
```



Build and run to make sure all is ok.