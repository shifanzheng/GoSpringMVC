# Project Plan

*Project Description*

The web application being developed will be an online multiplayer game based on the ancient Chinese board game called Go, or Wei Qi. This is a popular game played by people all over the world, and matches are played with two players where one player places white stones and the other player places black stones on a 19 by 19 square board.

*Project Design*

Technologies Used: Javascript (Front-end), Spring (Back-end) and Spring Security, MySQL (Database), 

Use Cases: Players will be able to play the Go board game with all all of its rules.
A history of moves made by the player will be displayed during the match. 
Players can challenge other players to matches, and there will be two game modes available, a standard 19 by 19 board and a smaller 9 by 9 board. 
Each game will be played on a board and it will have two players who are able to place stones on the board. 
Players will create accounts to play the game. To play games, players will be placed in a lobby after logging in to their account and will then be able to select other players in the lobby to play a game with.

Design docs needed to understand project:

https://en.wikipedia.org/wiki/Rules_of_Go

https://senseis.xmp.net/?BasicRulesOfGo

*Project Schedule*

*Completed
Checkpoint 1: Work on setting up the base for the application such as the back end to hold the data and begin development of the board. By the end of this checkpoint a player should be able to place pieces on a board, capture pieces, and have the other rules of Go applied to the board.*

For this first checkpoint I am able to serve to the user a functional Go board, with functionality such as placing black and white pieces, capturing territory, passing, and calculating score using an external library. I have began development of a simple account creation and login interface with form validation. For the next checkpoint I will work on two player useability and displaying a history of moves played during the game.

*Completed
Checkpoint 2: Work on displaying a history of moves during the game and implementing Ajax for two players to access the same board and have the board display the same information (position of stones and captured stones) to both players.*

For the second checkpoint I was able to get almost everything done except for properly rendering the board between two different windows. I made a scrollable list for the user to see a history of moves, and implemented ajax GET and POST functions. Currently the ajax functions are working but I am unable to take the data from the GET request and properly render the board with that data. That will be pushed to the next checkpoint.

*Completed
Checkpoint 3: Using the data from the Ajax GET request, properly render the board so that from another window the same game board can be displayed. Add a 9x9 game mode and create an option for users to select the regular 19x19 board size or the 9x9 board size.*

For checkpoint 3 I now have a fully functional game that can be played between two people. Spring security is implemented for sign-in, and a separate 9x9 board can be accessed with /board9. Players will select a color before placing pieces on the board. Players are no longer able to place pieces when it is not their turn. 

Final Project: The final project will be a web application of the Go board game where players will be able to log in using an account and play with other players. Players will be playing on the same board. There will be two modes that players can play, one with a normal game with a 19 by 19 board, and one with a 9 by 9 board for faster games. Completed games are saved to a database where previous game data can be viewed in a results page.

*Project Justification*

Novelty: Go is a very popular board game people play all over the world but bringing a set around can be tedious and also not affordable for some people. By making it in to a web service, players can have matches with anyone and also have the ability to see a history of the moves made during a match as well as previous matches to analyze gameplay. This cannot be easily done in a physical game because it is tedious and can disrupt player concentration. Finding players is also a problem for many, so by creating an online version where anyone can play anytime will be easy and convenient. There will also be an additional mode for players who wish to play but do not wish to dedicate a long period of time to play one game. The 9 by 9 board will be suitable for beginners as well as those who wish to just play a quick game.

Complexity: Angular, Spring, and MySQL are all technologies I have never worked with previously before this class. There will be a challenge in learning the use of all of these technologies and properly implementing them in a way that makes sense for this project. There will be many challenges in creating the game and making sure it follows all the rules of the actual game, as well as making sure that interactions on the board are dynamic so that players do not have to reload the page each time a move is made. Besides the mechanics involved in the game, I must also properly be able to store and display data of previous matches for players to see in the future, as well as the challenge of creating a matchmaking system so that players can play with each other. There are many tasks in both the front end and back end of the application that require learning for me to accomplish, so this will be a great challenge for me as a final project.

Github Page: https://github.com/shifanzheng/GoSpringMVC
