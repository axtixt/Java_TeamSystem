public class TeamFactory {

        public Team createTeam(String type, String teamId) {
            if (type.equalsIgnoreCase("v")) {
                System.out.println("Volleyball team is created.");
                return new VolleyballTeam(teamId);
            } else if (type.equalsIgnoreCase("f")) {
                System.out.println("Football team is created.");
                return new FootballTeam(teamId);
            } else {
                return null;
            }
        }
    }