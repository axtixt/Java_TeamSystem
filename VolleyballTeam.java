import java.util.Enumeration;

public class VolleyballTeam extends Team{
    private final int ATTACKER_POSITION = 1;
    private final int DEFENDER_POSITION = 2;

    public VolleyballTeam(String teamID){
		super(teamID);
	}

    public void updatePlayerPosition() {
        System.out.println("Position is updated.");
    }
    
    public void displayTeam() {
        System.out.println("Volleyball Team " + getName() + " (" + getTeamID() + ")");
        System.out.println("Attacker:");
        Enumeration<Player> playerEnumeration = getAllPlayers();
        while (playerEnumeration.hasMoreElements()) {
            Player player = playerEnumeration.nextElement();
            if (player.getPosition() == ATTACKER_POSITION) {
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
}
}