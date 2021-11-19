package Interface;

import User.Member;
import User.userId;
import User.userName;

import java.util.List;

public interface IRepository {

    public Member getUserById(userId userId);
    public void addUser(userId id, userName name);
    public void deleteUser(userId id);
    public List<Member> getUsers();
}
