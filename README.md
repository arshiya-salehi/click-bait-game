# Click Bait Game

This project is a simple "click-bait" game built in Java using the Swing GUI library. The objective is to click a moving image as many times as possible within a time limit.

## How to Play

1.  **Run the Game**: Compile and run `Main.java`.
2.  **Objective**: A window will appear with an image (`rick astley.jpg`) at a random location.
3.  **Click**: Click the image to score a point. Each successful click increases your score by 1 and immediately moves the target to a new random location.
4.  **Timer**: The target also moves to a new random location every second, whether you click it or not.
5.  **Game Over**: The game lasts for 10 seconds (10 ticks). After 10 seconds, the game stops, and clicks will no longer register.
6.  **Reset**: Press the **'r'** key at any time to reset the game. This will reset the score and the timer to zero.

## Project Structure

* **`Main.java`**: The entry point for the application. It creates the main `JFrame` (the game window) and adds the `Canvas` component to it.
* **`Canvas.java`**: This class extends `JComponent` and contains all the core game logic:
    * **Painting**: Draws the target image and the score string.
    * **Timer**: Uses a `javax.swing.Timer` to move the target every second and to end the game after 10 ticks (`MAX_TICKS`).
    * **MouseListener**: Detects mouse clicks, checks if the click coordinates are within the image bounds, and increments the score if it's a hit.
    * **KeyListener**: Listens for the 'r' key to call the `reset()` method.

## Dependencies

* Java SE (Swing library)
* An image file named `rick astley.jpg` must be present in the same directory as the compiled classes for the game to run correctly.
