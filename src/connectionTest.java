import java.sql.*;

public class connectionTest {
    public static void main(String[] args){

        Connection conn=null;
        Statement st=null;
        ResultSet rs = null;

        String url = "jdbc:postgresql://127.0.0.1:5432/Study_DDD";
        String user = "dev_eer";
        String password = "dev_eer";

        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            //st.executeUpdate("insert into members (seq,username,userid) values(1,'kim','soul')");
            rs = st.executeQuery("select * from members");
            String tmp=null;
            while (rs.next())
            {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException sqlEX) {
                System.out.println(sqlEX);

            }
        }


    }
}
