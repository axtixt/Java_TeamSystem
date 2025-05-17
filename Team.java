import java.util.Vector;
import java.util.Enumeration;

public abstract class Team {
    private String teamID;
    private String name;
    private Vector<Player> players;

    public Team(String teamID) {
        this.teamID = teamID;
        this.players = new Vector<>();
    }

    public String getTeamID() {
        return teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void remove(Player player) {
        players.remove(player);
    }

    public Enumeration<Player> getAllPlayers() {
        return players.elements();
    }

    public abstract void updatePlayerPosition();
    public abstract void displayTeam();
}