package assignment1;

import java.util.ArrayList;

class Poker {
    PlayingCards deck;
    ArrayList<String> hand1 = new ArrayList<String>();
    ArrayList<String> hand2 = new ArrayList<String>();

    public Poker() {
        deck = new PlayingCards();
        deck.Shuffle();
        dealHands();
    }

    public Poker(ArrayList<String> Hand1, ArrayList<String> Hand2) {
        deck = new PlayingCards();
        hand1 = Hand1;
        hand2 = Hand2;
    }

    public void dealHands() {
        int handNum = 1; //used to swap between hands
        boolean h1 = false; //tracks length of hands
        boolean h2 = false;
        for (int i = 0; i < 10; i++) {
            if (h1 && h2) {
                break;
            } else if (handNum == 1) {
                hand1.add(deck.getNextCard());
                if (hand1.size() > 4) {
                    h1 = true;
                }
                handNum += 1;
            } else if (handNum == 2) {
                hand2.add(deck.getNextCard());
                if (hand2.size() > 4) {
                    h2 = true;
                }
                handNum -= 1;
            }
        }
    }

    public void showHand(int hand) {
        if (hand == 1) {
            System.out.println("Player 1's hand:");
            for (String cards : hand1) {
                System.out.print(cards);
            }
            System.out.println();
        } else if (hand == 2) {
            System.out.println("Player 2's hand: ");
            for (String cards : hand2) {
                System.out.print(cards);
            }
            System.out.println();
        }
    }

    public int[] countSuite (ArrayList<String> hand) {
        int[] cardSuiteCounter = new int[4];
        for(String cards : hand) { //iterate through the input array, & split by spaces
            String[] suite = cards.split(" ");
            if(suite[2].equals("Clubs")) {
                cardSuiteCounter[0] = cardSuiteCounter[0] + 1;
            }
            else if(suite[2].equals("Diamonds")) {
                cardSuiteCounter[1] = cardSuiteCounter[1] + 1;
            }
            else if(suite[2].equals("Hearts")) {
                cardSuiteCounter[2] = cardSuiteCounter[2] + 1;
            }
            else if(suite[2].equals("Spades")) {
                cardSuiteCounter[3] = cardSuiteCounter[3] + 1;
            }
        }
        return cardSuiteCounter;
    }

    public int[] countValues(ArrayList<String> hand) {
        int[] cardValuesCounter = new int[14];
        for(String cards : hand) { //iterate through the input array, & split by spaces
            String[] value = cards.split(" ");
            switch (value[0]) {
                case "A" -> cardValuesCounter[1] = cardValuesCounter[1] + 1;
                case "2" -> cardValuesCounter[2] = cardValuesCounter[2] + 1;
                case "3" -> cardValuesCounter[3] = cardValuesCounter[3] + 1;
                case "4" -> cardValuesCounter[4] = cardValuesCounter[4] + 1;
                case "5" -> cardValuesCounter[5] = cardValuesCounter[5] + 1;
                case "6" -> cardValuesCounter[6] = cardValuesCounter[6] + 1;
                case "7" -> cardValuesCounter[7] = cardValuesCounter[7] + 1;
                case "8" -> cardValuesCounter[8] = cardValuesCounter[8] + 1;
                case "9" -> cardValuesCounter[9] = cardValuesCounter[9] + 1;
                case "10" -> cardValuesCounter[10] = cardValuesCounter[10] + 1;
                case "J" -> cardValuesCounter[11] = cardValuesCounter[11] + 1;
                case "Q" -> cardValuesCounter[12] = cardValuesCounter[12] + 1;
                case "K" -> cardValuesCounter[13] = cardValuesCounter[13] + 1;
            }
        }
        return cardValuesCounter;
    }
}
