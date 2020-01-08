/**
	 * Whether we have been here or not 
	 **/# CSC212 SpookyMansion

SpookyMansion and other Interactive Fiction to explore using and understanding Graphs.

## Learning Objectives
The learning objectives of this assignment are:
 - To practice using Maps with Java.
 - To gain an understanding of Graphs.
 

```
... --- ...
You are in the grand entrance hall of a large building.
The front door is locked. How did you get here?
 0. There are stairs leading down.
 1. There are stairs leading up.
 2. There is a red door.
 3. There is a brown door.
? 2

... --- ...
You've found the kitchen. You smell old food and some kind of animal.
 0. There is a red door.
 1. There is a dumbwaiter.
? 
```

# Lab Challenges (=15)

## (Lab) Play SpookyMansion and Draw a "graph" for yourself
 - Import the starter code. (Don't forget the Maven step).
 - Play SpookyMansion, and sketch out the "game" on paper.
 - Finish the game by finding the "Crypt" place.
 
## (Lab) Get a handle on the SpookyMansion Code
 - Add an Exit from the ``secretRoom`` to the ``basement`` (but not in the other direction).
 - Make the very long hallway even longer.
 - Modify the very long hallway messages to include a number scratched on the wall, so that players can tell how far they've come.
 - Add another room connected to the Attic.
 - Add another room connected to the Basement.
 - Change the solution to the labyrinth as well as the hint.
 - Note on your "map" the changes you've made to the game's "Graph".

## (Lab) Get a sense of the InteractiveFiction Code
 - Find the code in ``InteractiveFiction`` that handles quitting the game.

### Add actions to the game (=6)
 - (3) Allow users to quit with the word "escape" or just the letter "q". (They will still need to press enter).
 - (3) Add a "help" command that explains to type in the number of the room as well as how to quit.
 - You will need ``continue`` OR ``break`` statements!

### "This place feels familiar..." (=9)
When you visit a place for the second time, print out a message indicating to the player that they have been to that place before. This will not carry over between games.
- (3) Add a "boolean visited" flag onto the Place class.
- (3) Update this flag from ``false`` to ``true`` within a ``visit()`` method.
- (3) Call this method from ``InteractiveFiction``.

# Challenges:

Remember that SpookyMansion will be due ***Due Date***: October 4, 2019.

Remember that we will have a new assignment opening on that day, so don't save it until the last minute!

### Rubric and Reflection (=15)

You must complete a Google Form (coming soon) as usual to indicate your expected grade. 

In addition, you will write 10 statements of either:
 - Accomplishments: things that you understand much better now.
 - Challenges: things that you are still working on understanding.

I will provide direct feedback to your writing.

## Program Compiles (=15)
This includes that your code should be professional. 
- Try to proofread your work like an essay! 
- Find all your ``println("stuff")`` statements and remove them, etc.
- Your code looks intentional: don't just fiddle with it until it works. Reason about it! Sketch out the python by hand and then try translating to Java.
- Delete commented out code or experiments that don't work out. Make your submission as small as it needs to be.
- Your code is your own. Respect the honor code.
- Working with others or helping them debug is acceptable - use your best judgment! Make sure that you know what you're working on.

### Commenting Code (only negative points here...)
 - Any methods or class-level variables left without a Javadoc comment (``/** */``) will result in the loss of a point.
 - Have comments explaining tricky code!

## Optional Suggested Challenges

### Implement Your Own Game (=12+?)
Consider building a spooky version of FordHall.
 - (4) Must have at least 8 Places.
 - (4) Must have at least 8 functional Exits.
 - (4) Must have a terminal place (a way to win the game).
 - Be creative?

### Implement SecretExit (=24)
What does this look like? Consider this example: [SecretExit.md](SecretExit.md)
 - (4) Create a class SecretExit that extends Exit.
 - (4) Put a method called "boolean isSecret()" on Exit that works for both classes. Exits are never secret, but SecretExits are until you ``search`` for them.
 - (4) SecretExit should have a private boolean hidden, that starts off as true.
 - (4) Make it so SecretExits are not printed to the user (in ``InteractiveFiction``) when hidden. Change ``Place.getVisibleExits()`` to return only the exits that are not secret.
 - (4) When a user types ``search``, if there is a SecretExit in the room they are currently in, it should be made visible to them. Make a ``void search()`` method on ``Exit`` and ``SecretExit`` that does nothing to ``Exit`` but reveals the ``SecretExit``.
 - (4) Put a SecretExit from the ``basement`` to the ``secretRoom`` in SpookyMansion OR put a SecretExit in your custom game.
 
### Implement Stuff (=20)
What does this look like? Consider part of this example: [LockedExit.md](LockedExit.md)
 - (4) Place must have a method that returns a list of items in a location (maybe just ``List<String>``; don't need an item class)
 - (4) There must be an action to ``take`` an item.
 - (4) Items are part of the description until they are taken from a ``Place``. See the ``getDescription`` method. It might be easier to create a new ``void printDescription()``
 - (4) The player can no longer be represented by just a location. They need to know what key(s) if any they have.
 - (4) Make a ``stuff`` command that prints out the users items or "You have nothing."
 
### LockedExit / Requires Stuff: (=4..20 points; very similar to SecretExit)
What does this look like? Consider this example: [LockedExit.md](LockedExit.md)
 - (4 or 20) Implement a ``LockedExit`` that can only be chosen with the appropriate Key.
 
### Create a time system in your game. (=16)
 - (8) Create a class ``GameTime``, that has an ``int hour`` as state, ranging from 0 to 23 (inclusive). Implement ``int getHour()`` and ``void increaseHour()`` and print out the hour like a 12 or 24-hour watch. Do not change your ``hour`` field in your ***getter*** method.
 - (4) Extend the game's concept of a player with a current time. Increment the hour every time the player moves. Print out the current time after a room description.
 - (4) Tell the player how many hours they spent in your game upon Game-Over. (Not the current time, so you'll need a new ``int`` on your ``GameTime`` class).

#### Implement Different Place Descriptions for Day and Night (=20)
 - (4) Make an action ``rest`` that advances the game 2 hours so that you can test your descriptions.
 - (4) Implement a boolean method called ``isNightTime()``
 - (4) Add GameTime as a parameter to the ``getDescription`` method on ``Place`` (maybe ``printDescription`` now).
 - (8) Create some places with descriptions based whether GameTime ``isNightTime()`` -- maybe specific Places need to be subclasses with their own custom ``printDescription``!

#### Implement NightExit and DayExit that are only available at a particular time. (=12)
 - (12) Challenge: I'm not breaking this down, shares some work with ``SecretExit``.
 
### Implement a new game with some other tool or switch or idea (=?)
 - Check with me to make sure it's not too hard :)
 
