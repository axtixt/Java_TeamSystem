import java.util.Vector;

public class DisplayAllTeams implements Command {
    private Vector<Team> teams;

    public DisplayAllTeams(Vector<Team> teams) {
        this.teams = teams;
    }

    @Override
public void execute() {
    for (Team team : teams) {
        if (team instanceof FootballTeam) {
            System.out.println("Football Team " + team.getName() + " (" + team.getTeamID() + ")");
        } else if (team instanceof VolleyballTeam) {
            System.out.println("Volleyball Team " + team.getName() + " (" + team.getTeamID() + ")");
        }
    }
}
@Override
    public boolean match(String input) {
        return "p".equalsIgnoreCase(input);
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
        this.execute();
    }
}