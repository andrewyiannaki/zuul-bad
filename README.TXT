Project: zuul-bad
Authors: Michael Kölling and David J. Barnes

This project is part of the material for the book

   Objects First with Java - A Practical Introduction using BlueJ
   Fifth edition
   David J. Barnes and Michael Kölling
   Pearson Education, 2012

This project is a simple framework for an adventure game. In this version,
it has a few rooms and the ability for a player to walk between these rooms.
That's all.

To start this application, create an instance of class "Game" and call its
"play" method.

This version of the game contains some very bad class design. It should NOT
be used as a basis for extending the project without fixing these design
problems. It serves as an example to discuss good and bad design (chapter 7
of the book).

Chapter 7 of the book contains a detailed description of the problems in this
project, and how to fix them.

The project 'zuul-better' contains a version of this project with better
designed class structure. It includes the fixes discussed in the book.


v1.1 (currently working on)
A modification to the game that will allow a player to do a task whilst in a room. If the player 
accepts the task, the door is locked and the player cant get out until the task is completed.  The room 
unlock if the task if completed successfully within the time allowed.  If the time runs out or the task
is not complete, the player stays locked in
