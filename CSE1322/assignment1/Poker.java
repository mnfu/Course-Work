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
        for(int i = 0; i < 10; i++) {
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
                System.out.print(cards + ", ");
            }
            System.out.println();
        } else if (hand == 2) {
            System.out.println("Player 2's hand: ");
            for (String cards : hand2) {
                System.out.print(cards + ", ");
            }
            System.out.println();
        }
    }

    public int[] countSuite (ArrayList<String> hand) {
        int[] cardSuiteCounter = new int[4];
        for(String cards : hand) { //iterate through the input array, & split by spaces
            String[] suite = cards.split(" ");
            switch (suite[2]) {
                case "Clubs" -> cardSuiteCounter[0] = cardSuiteCounter[0] + 1;
                case "Diamonds" -> cardSuiteCounter[1] = cardSuiteCounter[1] + 1;
                case "Hearts" -> cardSuiteCounter[2] = cardSuiteCounter[2] + 1;
                case "Spades" -> cardSuiteCounter[3] = cardSuiteCounter[3] + 1;
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

    public int numPairs(int[] values) {
        int counter = 0;
        for(int i = 1; i < 14; i++) {
            if(values[i] == 2) {
                counter++;
            }
        }
        return counter;
    }

    public int threeOfAKind(int[] values) {
        for(int i = 1; i < 14; i++) {
            if(values[i] == 3) {
                return i;
            }
        }
        return 0;
    }

    public int fourOfAKind(int[] values) {
        for(int i = 1; i < 14; i++) {
            if(values[i] == 4) {
                return i;
            }
        }
        return 0;
    }

    public boolean fullHouse(int[] values) {
        return (numPairs(values) > 0) && (threeOfAKind(values) > 0);
    }

    public boolean straight(int[] values) {
        for(int i = 0; i < 10; i++) {
            if((values[i] == 1) && (values[i+1] == 1) && (values[i+2] == 1) && (values[i+3] == 1) && (values[i+4] == 1)) {
                return true;
            }
            else if ((values[i+1] == 1) && (values[i+2] == 1) && (values[i+3] == 1) && (values[i+4] == 1) && (values[1] == 1)) { //Ace card catcher
                return true;
            }
        }
        return false;
    }

    public boolean flush(int[] suites) {
        for(int i = 0; i < 4; i++) {
            if(suites[i] == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean straightFlush(int[]values, int[] suites) {
        return straight(values) && flush(suites);
    }

    public boolean royalFlush(int[] values, int[] suites) {
        return (flush(suites)) && (straight(values) && (values[10] == 1) && (values[1] == 1));
    }

    public String scoreHand(int handNum) {
        ArrayList<String> hand = new ArrayList<String>();
        if (handNum == 1) {
            hand = hand1;
        }
        else if (handNum == 2) {
            hand = hand2;
        }
        if (royalFlush(countValues(hand), countSuite(hand))) {
            return "Royal Flush";
        }
        else if (straightFlush(countValues(hand), countSuite(hand))) {
            return "Straight Flush";
        }
        else if (fourOfAKind(countValues(hand)) > 0) {
            return "4 of a kind";
        }
        else if (fullHouse(countValues(hand))) {
            return "Full House";
        }
        else if (flush(countSuite(hand))) {
            return "Flush";
        }
        else if (straight(countValues(hand))) {
            return "Straight";
        }
        else if (threeOfAKind(countValues(hand)) > 0) {
            return "3 of a kind";
        }
        else if (numPairs(countValues(hand)) == 2) {
            return "2 pairs";
        }
        else if (numPairs(countValues(hand)) == 1) {
            return "1 pair";
        }
        else {
            return "High Card";
        }
    }
}
