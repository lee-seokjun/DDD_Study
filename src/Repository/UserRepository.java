package Repository;

import Interface.IRepository;
import User.Member;
import User.userId;
import User.userName;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IRepository {

    private static List<Member> members = new ArrayList<>();
    static{
        try {
            userId userId = new userId("kim");
            userName userName = new userName("mang");
            Member member  = new Member(userName,userId,members.size());
            members.add(member);
            userId = new userId("kang");
            userName = new userName("san");
            member = new Member(userName,userId,members.size());
            members.add(member);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static final UserService userService= new UserService();

    @Override
    public Member getUserById(userId userId) {
        Optional<Member> member = members.stream().filter(s->s.getUserId().equals(userId)).findFirst();
        return member.orElse(null);
    }

    @Override
    public void addUser(userId id, userName name) {
        Member newMember = newUser(id,name);
        if(userService.exists(newMember))
        {
            members.add(newMember);
        }

    }

    @Override
    public void deleteUser(userId id) {
        Optional<Member> selectedId= members.stream().filter(s -> s.getUserId().equals(id)).findFirst();
        Member member =selectedId.get();

        if(userService.exists(member))
        {
            int seq = Long.valueOf(Optional.ofNullable(member.getSeq()).orElse(0L)).intValue();
            members.remove(seq);
        }

    }

    @Override
    public List<Member> getUsers() {
        return members;
    }

    public Member newUser(userId id, userName name)
    {
        Member member =null;
        try {
            member =new Member(name,id,members.size());
        }catch(Exception e){
            e.printStackTrace();
        }
        return member;
    }



}
