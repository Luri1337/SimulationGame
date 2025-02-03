# Project Title 
## Simulation game. 10x10 World where Herbivore and Predators survive
___

# Description

## How it works? 🧑‍🏭
In the start of the game in map appear 5 predators :wolf: , 5 herbivores :rabbit: and 5 units of grass :seedling: (Herbivores eat them) . Also in map I render 15 obstacles :palm_tree: :rock: , Creatures must go around of them. 

Simulation works endlessly, it means that if any Herbivore is dying due to Predator attack, in map appear new Herbivore. And also if Herbivore eat grass, appear new Grass. 

In game there is a pause, you can pause it by pressing ENTER, and clearly look what is happening now. 
## Movement :runner:
Creatures can move only right left down and up per one square.

Each creature using same algorithm for calculating next move. But there are some specificity, Predators can spend their turn attacking Herbivores, I did this so that they wouldn't chase Herbivore endlessly.

There is also some kind of collision check, Predators can't go on cell where is other Predator or Herbivore stay. They can go on Herbivore square only if they completely eat Herbivore.  

This rule works for Herbivores in same way, Herbivore can't go on cell where is other Predator or Herbivore stay. They only move is empty cell or grass. 

And of course they can't go on an obstacle.

## Eating :fork_and_knife:

Herbivores just find grass, and eat it, every time they eat grass, it adds 25hp.

Predators follow Herbivores and eat them, nothing new. 

___



# Classes and Packages
## In this Project I have only two packages: entities and utils. 

## entities package
____
In entitites I have abstract class Entity, it is base class for all type of entities.
Creature abstract class, base class for Herbivores and Predators.

In this package actually nothing interesting, just realization of entitties.

## utils package
____
In this package I have BFS, Actions, Coordinates, GameMap classes.

#### **GameMap class**
In this class I have a logic of Map, and storing entitties. 
For store entitties I used HashMap <Coordinates, Entity> 

Also in this class I create, set, move, remove entitties. 

#### **MapConsoleRenderer class**

This class is able for render map in console

#### **Coordinates class**

The Coordinates class represents a point on a 2D grid. It stores X and Y values and is used to define positions of entities.
Each entity has a Coordinates field.

#### **BFS class**
This class is able for computing the shortest way to food for Creatures. 

it implemented by using breadth-first search algorithm. 

#### **Actions class**

This class is able only for turn action in our simulation. 

____
### **Simulation class**

Kinda main class that start, pause game. 







