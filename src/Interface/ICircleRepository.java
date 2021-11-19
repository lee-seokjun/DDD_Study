package Interface;

import Circle.CircleId;
import Circle.CircleName;
import Circle.CircleTeam;

import java.util.List;


public interface ICircleRepository {
    void save(CircleTeam circle);
    CircleTeam Find(CircleId id);
    CircleTeam Find(CircleName name);
    int CircleCount();
    List<CircleTeam> getTeams();
}
