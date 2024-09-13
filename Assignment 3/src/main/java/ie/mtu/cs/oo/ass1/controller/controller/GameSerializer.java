package ie.mtu.cs.oo.ass1.controller.controller;

import ie.mtu.cs.oo.ass1.model.Game;

import java.io.*;

/**
 * The GameSerializer class is responsible for managing the serialization and deserialization of Game objects.
 * The serializer only allows for one instance to exist by following the Singleton pattern.
 */
public class GameSerializer implements Serializable {

    // File name for saving the serialized game
    private static final String SAVE_FILE_NAME = "Game.ser";

    // Singleton instance of GameSerializer
    private static GameSerializer instance;

    // Private constructor to prevent instantiation from outside the class
    private GameSerializer() {
    }

    /**
     * Returns the singleton instance of GameSerializer.
     *
     * @return The singleton instance of GameSerializer.
     */
    public static GameSerializer getInstance() {
        if (instance == null) {
            instance = new GameSerializer();
        }
        return instance;
    }

    /**
     * Saves the given Game object to a file.
     *
     * @param game The Game object to be saved.
     */
    public void saveGame(Game game) {
        try (FileOutputStream fileOut = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(game);
            System.out.println("SUCCESSFULLY SAVED");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while saving game: " + e.getMessage());
        }
    }

    /**
     * Loads a Game object from a file.
     *
     * @return The loaded Game object, or null if loading fails.
     */
    public Game loadGame() {
        try (FileInputStream fileIn = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Game loadedGame = (Game) in.readObject();
            System.out.println("SUCCESSFULLY LOADED");
            return loadedGame;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + SAVE_FILE_NAME);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
