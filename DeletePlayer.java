import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Vector;

public class DeletePlayer implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector<Team> teams;
    NowCurrentTeam currentTeam;
    GetSetHistory history;
    private Player deletedPlayer;
    private String playerID;

    public DeletePlayer(Vector<Team> teams, NowCurrentTeam currentTeam) {
        this.teams = teams;
        this.currentTeam = currentTeam;
    }

    @Override
    public void execute() {
        try {
                System.out.print("Please input player ID: ");
                playerID = br.readLine();
            Enumeration<Player> players = currentTeam.getCurrentTeam().getAllPlayers();
            while (players.hasMoreElements()) {
                Player player = players.nextElement();
                if (player.getPlayerID().equals(playerID)) {
                    currentTeam.getCurrentTeam().remove(player);
                    GetSetHistory history = new GetSetHistory();
                    history.setDeletedPlayer(player);
                    System.out.println("Player is deleted.");
                    return;
                }
            }

            System.out.println("Player not found.");

        } catch (Exception e) {
            System.out.println("*** Error: " + e.getMessage());
        }
    }
    @Override
    public boolean match(String input) {
        return "d".equalsIgnoreCase(input);
    }
    @Override
    public void undo() {
        deletedPlayer = history.getDeletedPlayer();
        if (deletedPlayer != null) {
            currentTeam.getCurrentTeam().addPlayer(deletedPlayer);
            System.out.println("Player is added back.");
        }
    }

    @Override
    public void redo() {
        deletedPlayer = history.getDeletedPlayer();
        currentTeam.getCurrentTeam().remove(deletedPlayer);
    }
}