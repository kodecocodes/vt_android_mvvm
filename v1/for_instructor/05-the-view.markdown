# Android MVVM
# 05 - The View

## [Slide - View]

Before we build out the view model, let's take a look at the view class and layout setup in the starter project for the Add Creature screen.

# Demo

Here we have the app running and are on the Add Creature screen. There's an ImageView at the top to select and show the Creature avatar. 

There's an EditText for the Creature name.

There are three spinner drop downs for setting the Creature attributes. These are pre-populated with static attribute data.

There's a text view to show the creature hitPoints based on the selected attributes.

And there's a save button for saving the creature once all the attributes have been entered.

We'll hook up these views to the view model in the next video.

Switching to Android Studio, open up the layout file for the Add Creature screen, res/layout/activity_creature.xml. There are two versions of the file, one for portrait mode and the other for landscape. We'll just look at the portrait mode file.

You see here that the root layout is a ConstraintLayout, and each of the creature property views are child views of the ConstraintLayout.

The view class for the Add Creature screen is CreatureActivity, in the view.creature package. 

CreatureActivity implements the AvatarAdapter.AvatarListener interface, which is just used for when a user selects an avatar in the avatar chooser.

In onCreate(), there are a number of configure methods for setting up the screen. 

configureUI() just sets up some the screen chrome like the back button and title.

configureSpinnerAdpaters() just sets up the attribute spinners with static data from a Kotlin object named AttributeStore.

configureSpinnerListeners sets up listeners that get called when choices are made in the attribute drop downs. There are todos that we'll handle in the next video.

configureEditText() sets up a text changed listener for the name EditText, with another todo for us to implement.

And configureClickListeners() sets up click listeners for showing the avatar chooser and for the save button.

The bottom of the file has the AvatarAdapter listener override and a private helper function to hide the label that says to tap to select an avatar.

That's pretty much it for the View layer. In the next video, we'll see how to create a ViewModel to handle user interaction with this View.