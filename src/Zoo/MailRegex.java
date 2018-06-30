package Zoo;

public class MailRegex {

    public boolean gmailMatch(String input){
        return input.matches("[a-zA-Z][a-zA-Z0-9]+[@][g][m][a][i][l][.][c][o][m]");
    }

    public boolean yahooMatch(String input){
        return input.matches("[a-zA-Z][a-zA-Z0-9]+[@][y][a][h][o][o][.][c][o][m]");
    }
}
