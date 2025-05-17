import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class AddPlayer implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector<Team> teams;
    NowCurrentTeam currentTeam;
    GetSetHistory history;
    String playerId, playerName;
    int position;

    public AddPlayer(Vector<Team> teams, NowCurrentTeam currentTeam) {
        this.teams = teams;
        this.currentTeam = currentTeam;
    }

    @Override
    public void execute() {
        try {
                System.out.print("Please input player information (id, name):- ");
                String playerInformation = br.readLine();
                String[] playerInfo = playerInformation.split(",");
                playerId = playerInfo[0].trim();
                playerName = playerInfo[1].trim();

            PlayerFactory factory = new PlayerFactory();
            Player player = factory.createPlayer(playerId, playerName);
            GetSetHistory history = new GetSetHistory();
            history.setplayerHistory(player);

            if (currentTeam.getCurrentTeam().getClass() == VolleyballTeam.class) {
                    System.out.print("Position (1 = attacker | 2 = defender):- ");
                    position = Integer.parseInt(br.readLine());
                
                player.setPosition(position);
                history.setpositionHistory(position);
            } else if (currentTeam.getCurrentTeam().getClass() == FootballTeam.class) {
                    System.out.print("1 = goal keeper | 2 = defender | 3 = midfielder | 4 = forward):- ");
                    position = Integer.parseInt(br.readLine());
                player.setPosition(position);
            }

            currentTeam.getCurrentTeam().addPlayer(player);
            System.out.println("Player is added.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean match(String input) {
        return "a".equalsIgnoreCase(input);
    }

    public void undo() {
        Player lastAddedPlayer = history.getplayerHistory();
        currentTeam.getCurrentTeam().remove(lastAddedPlayer);
    }

    public void redo() {
            Player lastAddedPlayer = history.getplayerHistory();
            if (currentTeam.getCurrentTeam().getClass() == VolleyballTeam.class) {
                
                lastAddedPlayer.setPosition(position);
            }

            currentTeam.getCurrentTeam().addPlayer(lastAddedPlayer);
            System.out.println("Player is added.");

    }
}