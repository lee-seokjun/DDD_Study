package Circle;

import User.userId;

public class CircleCreateCommand {
    private userId userId;
    private CircleName circleName;

    public CircleCreateCommand(userId userId, CircleName circleName) {
        this.userId = userId;
        this.circleName = circleName;
    }

    public User.userId getUserId() {
        return userId;
    }

    public void setUserId(User.userId userId) {
        this.userId = userId;
    }

    public CircleName getCircleName() {
        return circleName;
    }


}
