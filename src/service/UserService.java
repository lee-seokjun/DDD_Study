package service;

import User.Member;

import java.util.Arrays;

public class UserService {

    private final String[] userIds= {
            "seoklee","tester"
    };
    private final String[] userNames= {
            "seok","tester"
    };
    private boolean checker = true;
    public boolean exists(Member member)
    {
        Arrays.stream(userIds).forEach(s->{
            if(s.equals(member.getUserId())){
                checker=false;
            }
        });
        Arrays.stream(userNames).forEach(s->{
            if(s.equals(member.getUserName())){
                checker=false;
            }
        });
        return checker;
    }
}
