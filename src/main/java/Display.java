public class Display {
    public String greeting() {
        String x = "Welcome!";
        System.out.println(x);
        return x;
    }

    public String promptPlayer(String playerMark) {
        String prompt = String.format("Make a move: %s", playerMark);
        System.out.println(prompt);
        return prompt;
    }
}
