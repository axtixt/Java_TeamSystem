import java.util.Enumeration;

public class FootballTeam extends Team {
    private final int GOALKEEPER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;
    private final int MIDFIELDER_POSITION = 3;
    private final int FORWARD_POSITION = 4;

    public FootballTeam(String teamID) {
        super(teamID);
    }

    public void updatePlayerPosition() {
        System.out.println("Position is updated.");
    }

    public void displayTeam() {
		System.out.println("Football Team " + getName() + " (" + getTeamID() + ")");
        System.out.println("Goalkeeper:");
        Enumeration<Player> playerEnumeration = getAllPlayers();
        while (playerEnumeration.hasMoreElements()) {
            Player player = playerEnumeration.nextElement();
            if (player.getPosition() == GOALKEEPER_POSITION) {
                System.out.println(player.getPlayerID() + ", " + player.getName());
            }
        }
        System.out.println("Defender:");
        playerEnumeration = getAllPlayers();
        while (playerEnumeration.hasMoreElements()) {
            Player player = playerEnumeration.nextElement();
            if (player.getPosition() == DEFENDER_POSITION) {
                System.out.println(player.getPlayerID() + ", " + player.getName());
            }
        }
		System.out.println("Midfielder:");
        playerEnumeration = getAllPlayers();
        while (playerEnumeration.hasMoreElements()) {
            Player player = playerEnumeration.nextElement();
            if (player.getPosition() == MIDFIELDER_POSITION) {
                System.out.println(player.getPlayerID() + ", " + player.getName());
            }
        }
		System.out.println("Forward:");
        playerEnumeration = getAllPlayers();
        while (playerEnumeration.hasMoreElements()) {
            Player player = playerEnumeration.nextElement();
            if (player.getPosition() == FORWARD_POSITION) {
                System.out.println(player.getPlayerID() + ", " + player.getName());
            }
        }
    }
}