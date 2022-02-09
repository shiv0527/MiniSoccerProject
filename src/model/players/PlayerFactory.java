package model.players;

import java.awt.*;

public class PlayerFactory {


    public GamePlayer getPlayer(String playerType) {
        GamePlayer gamePlayer = null;
        if (playerType.equals("striker")) {

            gamePlayer = new Striker("Striker", Color.blue);
        }
        if (playerType.equals("goalkeeper")) {

            gamePlayer = new Goalkeeper("GoalKeeper", Color.orange);
        }
        return gamePlayer;
    }
}
