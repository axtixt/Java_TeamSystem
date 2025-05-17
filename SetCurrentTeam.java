import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class SetCurrentTeam implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector<Team> teams;
    NowCurrentTeam currentTeam;
    GetSetHistory history;
    private String teamId;
    private Team oldTeam;

    public SetCurrentTeam(Vector<Team> teams, NowCurrentTeam currentTeam) {
    this.teams = teams;
	this.currentTeam = currentTeam;
}

@Override
public void execute() {
    try {
		    System.out.print("Please input team ID:- ");
		    teamId = br.readLine();
        GetSetHistory history = new GetSetHistory();
        history.setSetCurrentTeam(currentTeam.getCurrentTeam());
		for (Team team : teams) {
            if (team.getTeamID().equals(teamId)) {
                currentTeam.setCurrentTeam(team);
                System.out.println("Changed current team to " + teamId);
            }
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
    @Override
    public boolean match(String input) {
        return "g".equalsIgnoreCase(input);
    }

    @Override
    public void undo() {
        oldTeam = history.getSetCurrentTeam();
        if (oldTeam != null) {
            currentTeam.setCurrentTeam(oldTeam);
            System.out.println("Reverted current team to " + oldTeam.getTeamID());
        }
    }

    @Override
    public void redo() {
        oldTeam = history.getSetCurrentTeam();
        currentTeam.setCurrentTeam(oldTeam);
    }
}