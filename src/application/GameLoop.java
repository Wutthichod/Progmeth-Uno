package application;

import logic.card.BaseCard;
import logic.game.Deck;
import logic.game.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameLoop {
    private Deck deck;
    private Player[] players;
    private BaseCard topDiscard;
    private int currentPlayerIndex;
    private static GameLoop gameInstance;
    private int direction = 1;

    public GameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the Number of Players (2-5): ");
                int numberOfPlayers = scanner.nextInt();
                if (numberOfPlayers > 1 && numberOfPlayers <= 5) {
                    deck = new Deck();
                    topDiscard = deck.drawFirstCard();
                    players = new Player[numberOfPlayers];
                    for (int i = 0; i < numberOfPlayers; i++) {
                        players[i] = new Player("Player " + (i + 1));
                    }
                    currentPlayerIndex = 0;
                    dealCards();
                    break;
                } else {
                    System.out.println("Invalid Number..");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input..");
                scanner.nextLine();
            }
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver()) {
            Player currentPlayer = players[currentPlayerIndex];
            GameIO.printTurnStartInfo(currentPlayer, topDiscard);
            GameIO.printHand(currentPlayer);
            System.out.println("0 to draw a card...");
            boolean hasDrawn = false;

            while (true) {
                try {
                    int actionNumber = scanner.nextInt();
                    if (actionNumber > 0) {
                        BaseCard cardToPlay = currentPlayer.getHand().get(actionNumber - 1);
                        if (topDiscard.isPlayable(cardToPlay)) {
                            currentPlayer.playCard(cardToPlay);
                            topDiscard = cardToPlay;
                            break;
                        } else {
                            GameIO.printInvalidCardMessage();
                        }
                    } else if (actionNumber == 0 && !hasDrawn) {
                        BaseCard drawnCard = deck.drawCard();
                        currentPlayer.drawCard(drawnCard);
                        GameIO.printDrawResult(currentPlayer, drawnCard);
                        GameIO.printTopCard(topDiscard);
                        GameIO.printHand(currentPlayer);
                        System.out.println("0 to skip this turn...");
                        hasDrawn = true;
                    } else if (actionNumber == 0) {
                        break;
                    } else {
                        System.out.println("Invalid Input!!");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("You don't have that many cards!!");

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!!");
                    scanner.nextLine();
                }
            }
            currentPlayerIndex = (currentPlayerIndex + players.length + direction) % players.length;
        }
        System.out.println(players[currentPlayerIndex].getName() + "Won !!");
    }

    private void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                BaseCard card = deck.drawCard();
                player.drawCard(card);
            }
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public Player getNextPlayer() {
        return players[(currentPlayerIndex + players.length + direction) % players.length];
    }

    public static GameLoop getGameInstance() {
        if (gameInstance == null) {
            gameInstance = new GameLoop();
        }
        return gameInstance;
    }

    public void reverse() {
        GameLoop.getGameInstance().setDirection(-GameLoop.getGameInstance().getDirection());
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player[] getPlayers() {
        return players;
    }
}

