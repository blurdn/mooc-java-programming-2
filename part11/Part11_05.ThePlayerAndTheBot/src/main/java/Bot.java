public class Bot extends Player {
    @Override
    public void play() {
        System.out.println("The bot is playing...");
    }

    public void addMove(String move) {
        System.out.println("The bot made the move: " + move);
    }
}
