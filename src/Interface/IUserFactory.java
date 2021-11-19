package Interface;

import User.Member;
import User.userId;
import User.userName;

public interface IUserFactory {
    public Member creatUser(userId userId, userName userName);
}
