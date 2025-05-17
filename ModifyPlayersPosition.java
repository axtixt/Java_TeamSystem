import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Vector;

public class ModifyPlayersPosition implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector<Team> teams;
    NowCurrentTeam currentTeam;
    private int oldPosition;
    private Player modifiedPlayer;
    private String playerId;
    private int position;
    GetSetHistory history;

    public ModifyPlayersPosition(Vector<Team> teams, NowCurrentTeam currentTeam) {
        this.teams = teams;
        this.currentTeam = currentTeam;
    }

    @Override
    public void execute() {
        try {
                System.out.print("Please input player ID:- ");
                playerId = br.readLine();
            if (currentTeam.getCurrentTeam() instanceof VolleyballTeam) {
                    System.out.print("Position (1 = attacker | 2 = defender):- ");
                    position = Integer.parseInt(br.readLine());
                Enumeration<Player> players = currentTeam.getCurrentTeam().getAllPlayers();
                while (players.hasMoreElements()) {
                    Player player = players.nextElement();
                    if (player.getPlayerID().equals(playerId)) {
                        oldPosition = player.getPosition();
                        player.setPosition(position);
                        modifiedPlayer = player;
                        ((VolleyballTeam)currentTeam.getCurrentTeam()).updatePlayerPosition();
                        System.out.println("Position is updated.");
                        break;
                    }
                }
            } else if (currentTeam.getCurrentTeam() instanceof FootballTeam) {
                    System.out.print("1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):- ");
                    position = Integer.parseInt(br.readLine());
                Enumeration<Player> players = currentTeam.getCurrentTeam().getAllPlayers();
                while (players.hasMoreElements()) {
                    Player player = players.nextElement();
                    if (player.getPlayerID().equals(playerId)) {
                        GetSetHistory history = new GetSetHistory();
                        oldPosition = player.getPosition();
                        history.setoldPosition(oldPosition);
                        player.setPosition(position);
                        history.setmodifiedPlayer(player);
                        ((FootballTeam)currentTeam.getCurrentTeam()).updatePlayerPosition();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public boolean match(String input) {
        return "m".equalsIgnoreCase(input);
    }
    @Override
    public void undo() {
        modifiedPlayer = history.getmodifiedPlayer();
        if (modifiedPlayer != null) {
            oldPosition = history.getoldPosition();
            modifiedPlayer.setPosition(oldPosition);
            System.out.println("Player's position is reverted.");
        }
    }

    @Override
    public void redo() {
        if (currentTeam.getCurrentTeam() instanceof VolleyballTeam) {
            modifiedPlayer = history.getmodifiedPlayer();
            oldPosition = history.getoldPosition();
            ((VolleyballTeam)currentTeam.getCurrentTeam()).updatePlayerPosition();
         } else if (currentTeam.getCurrentTeam() instanceof FootballTeam) {
            modifiedPlayer = history.getmodifiedPlayer();
            oldPosition = history.getoldPosition();
            ((FootballTeam)currentTeam.getCurrentTeam()).updatePlayerPosition();}
}
}