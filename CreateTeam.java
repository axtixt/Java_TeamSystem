import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class CreateTeam implements Command {
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector<Team> teams;
    NowCurrentTeam currentTeam;
    GetSetHistory history;
    private String lastSportType;
    private String lastTeamId;
    private String lastTeamName;
    private Team lastteam;

    public CreateTeam(Vector<Team> teams, NowCurrentTeam currentTeam) {
        this.teams = teams;
        this.currentTeam = currentTeam;
    }

    public void execute() {
        try {
            System.out.print("Enter sport type (v = volleyball | f = football): ");
            String sportType = br.readLine();
            System.out.print("Team ID: ");
            String teamId = br.readLine();
            System.out.print("Team Name: ");
            String teamName = br.readLine();
    
            createTeam(sportType, teamId, teamName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTeam(String sportType, String teamId, String teamName) {
        TeamFactory factory = new TeamFactory();
        Team team = factory.createTeam(sportType, teamId);
        if (team != null) {
            team.setName(teamName);
            teams.add(team);
            System.out.println("Current team is changed to " + teamId);
            currentTeam.setCurrentTeam(team);
            GetSetHistory history = new GetSetHistory();
            history.setTeamHistory(team);
            history.setSportTypeHistory(sportType);
            history.setTeamIdHistory(teamId);
            history.setTeamnameHistory(teamName);
        } else {
            System.out.println("Invalid sport type.");
        }
    }

    @Override
    public boolean match(String input) {
        return "c".equalsIgnoreCase(input);
    }

    @Override
    public void undo() {
        lastteam = history.getTeamHistory();
        if (history.getTeamHistory() != null) {
            System.out.println("Undo last created team.");
            teams.remove(lastteam);
            currentTeam.setCurrentTeam(null);
            history.setTeamHistory(null);
        }
    }

    @Override
    public void redo() {
        lastSportType = history.getSportTypeHistory();
        lastTeamId = history.getTeamIdHistory();
        lastTeamName = history.getTeamnameHistory();
        if (lastSportType != null && lastTeamId != null && lastTeamName != null) {
            System.out.println("Redo last created team.");
            createTeam(lastSportType, lastTeamId, lastTeamName);
        }
    }
}