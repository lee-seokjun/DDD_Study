package Circle;

import User.userId;

public class CircleJoinCommand {
    private userId userid;
    private CircleName circleName;

    public CircleJoinCommand(CircleName circleName,userId userId) {
        this.circleName = circleName;
        this.userid=userId;
    }

    public userId getUserid() {
        return userid;
    }

    public CircleName getCircleName() {
        return circleName;
    }
}
