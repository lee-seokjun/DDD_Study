package Repository;

import Circle.CircleId;
import Circle.CircleName;
import Circle.CircleTeam;
import Interface.ICircleRepository;
import Interface.IUserFactory;
import User.Member;
import factory.UserFactory;

import java.sql.*;
import java.util.List;

public class CircleRepositoryUserPostgres implements ICircleRepository {
    private Connection conn=null;
    private Statement st=null;
    private ResultSet rs = null;
    IUserFactory userFactory = new UserFactory();
    private final String url = "jdbc:postgresql://127.0.0.1:5432/Study_DDD";
    private final String user = "dev_eer";
    private final String password = "dev_eer";
    @Override
    public void save(CircleTeam circle) {

        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            String InsertQuery = String.format("insert into circle (circleId,circleName,ownerId,members) values('%s','%s','%s','%s')",
                    circle.getCircleId(),circle.getCircleName(),circle.getOwner().getUserId(),circle.getMembers() );
            st.executeUpdate(InsertQuery);
            System.out.println("save circle");
        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException sqlEX) {
                System.out.println(sqlEX);
            }
        }
    }

    @Override
    public CircleTeam Find(CircleId id) {
        return null;
    }

    @Override
    public CircleTeam Find(CircleName name) {
        return null;
    }

    @Override
    public int CircleCount() {
        return 0;
    }

    @Override
    public List<CircleTeam> getTeams() {
        return null;
    }
}
