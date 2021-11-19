package Repository;

import Interface.IRepository;
import Interface.IUserFactory;
import User.Member;
import User.userId;
import User.userName;
import factory.UserFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryUsePostgre implements IRepository {
    private Connection conn=null;
    private Statement st=null;
    private ResultSet rs = null;
    IUserFactory userFactory = new UserFactory();
    private final String url = "jdbc:postgresql://127.0.0.1:5432/Study_DDD";
    private final String user = "dev_eer";
    private final String password = "dev_eer";
    @Override
    public Member getUserById(userId userId)
    {
        Member member=null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            rs = st.executeQuery("select * from members where  userid=\'"+userId + "\' ");
            rs.next();
            userId dbUserId = new userId((String)rs.getString(2));
            userName dbUserName = new userName((String)rs.getString(3));
            long seq = Long.parseLong(rs.getString(1));
             member = new Member(dbUserName,dbUserId,seq);
            return member;
        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException sqlEX) {
                System.out.println(sqlEX);
            }
        }

        return null;
    }


    @Override

    public void addUser(userId id, userName name)
    {
        Member saveMember = userFactory.creatUser(id,name);
        if(saveMember ==null)
        {
            return;
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            String InsertQuery = String.format("insert into members (seq,username,userid) values('%d','%s','%s')", saveMember.getSeq(), saveMember.getUserName(), saveMember.getUserId());
            st.executeUpdate(InsertQuery);

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
    public void deleteUser(userId id)
    {
        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            String InsertQuery = String.format("delete from members where userid='%s'",id);
            st.executeUpdate(InsertQuery);

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
    public List<Member> getUsers()
    {
        List<Member> members = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            rs = st.executeQuery("select * from members ");
            while(rs.next()) {
                int seq = Integer.parseInt(rs.getString(1));
                userId dbUserId = new userId((String) rs.getString(2));
                userName dbUserName = new userName((String) rs.getString(3));
                Member member = new Member(dbUserName, dbUserId, seq);
                members.add(member);
            }

        } catch (SQLException sqlEX) {
            System.out.println(sqlEX);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException sqlEX) {
                System.out.println(sqlEX);
            }
        }
        return members;
    }
}
