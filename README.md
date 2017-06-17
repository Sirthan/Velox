# Velox
Want a way to quickly quiz you or your friends with user created questions? Try Velox!

# Create your own questions!
Velox was originally created to help me and some close friends study for an AP Psychology exam, so the program comes with 80 or so AP Psychology questions built in, but creating your own questions and using them is easy with Velox! To start, open the "Questions.Velox" file in the res folder. This is the location from which the game pulls all of its questions, and, using notepad or any other simple plaintext editor, you can easily add your own questions for the game to follow. Simply open the file, erase the pre-packed questions, and write your own using this formatting:

[Question]|[Correct Answer]|[Distractor Answer]|[Distractor Answer]|[Distractor Answer]

Followed by a newline, as whitespace matters for the Velox question interpreter. Don't worry about the positioning of the answer choices, as the game automatically shuffles both the question list and answer choices. When done, save and run the jar to see your questions come to life!

# How does the game score your answers?
Velox was created to be a game focused on answering as many questions as quickly as possible, and the way the game scores correct answers definitely mirrors this belief! When a user selects a correct answer, the game adds points to your score equal to the amount of time left on the clock times 10. This ensures the winning player is the one who answers as quickly and as accurately as possible!

# How do I clear the highscore list?
Velox's highscore list can easily be cleared by opening the "highscores.Velox" file in the res folder and clearing out the text there. To prevent cheaters from simply adding their name to the top of the leaderboards, the file is compiled as a binary, so the list is near impossible to edit without changing the source code to the game.

