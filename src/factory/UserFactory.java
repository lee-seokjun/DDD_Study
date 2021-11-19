package factory;

import Interface.IUserFactory;
import User.Member;
import User.userId;
import User.userName;

import java.sql.*;

public class UserFactory implements IUserFactory {

    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private final String url = "jdbc:postgresql://127.0.0.1:5432/Study_DDD";
    private final String user = "dev_eer";
    private final String password = "dev_eer";

    @Override
    public Member creatUser(userId userId, userName userName) {

        long seq = 0;
        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            String selectSeqQuery = "select max(seq) from members ";
            rs = st.executeQuery(selectSeqQuery);
            rs.next();
            if (rs.isLast()) {
                seq = Long.parseLong(rs.getString(1)) + 1;
            }

            selectSeqQuery = String.format("select userid from members where userid = '%s'",userId);
            rs = st.executeQuery(selectSeqQuery);
            rs.next();
            if(rs.isLast())
            {
                throw new Exception("이미 있음");
            }
        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                st.close();
                rs.close();
                conn.close();
            } catch (SQLException sqlEX) {
                System.out.println(sqlEX);
            }
        }
        return new Member(userName, userId, seq);
    }

}
