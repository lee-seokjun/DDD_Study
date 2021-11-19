import Interface.IRepository;
import Repository.UserRepository;
import Repository.UserRepositoryUsePostgre;
import User.Member;
import User.userId;
import User.userName;

import java.util.List;

public class mainTest {

    public static void main(String[] args) throws Exception {
        IRepository re2 = new UserRepository();
        userId userId = new userId("bang");
        userName userName = new userName("minsu");
        re2.addUser(userId,userName);
        userId = new userId("bong");
        userName = new userName("junsu");
        re2.addUser(userId,userName);
        List <Member> members = re2.getUsers();
        System.out.println("step 1 : size after 2 user add : "+re2.getUsers().size());
        Member member = re2.getUserById(userId);
        System.out.println("step 2 : get user last input : "+member);
        System.out.println("step 3 : get users: "+member);
        for(Member u : members)
        {
            System.out.println("    seq :"+u.getSeq() +" : "+ u);
        }

        re2.deleteUser(userId);
        System.out.println("step 3 : after delete user : "+re2.getUsers().size() );

    }


}
