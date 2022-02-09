package model.players;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class PlayerCollection implements Iterable<GamePlayer> {

    private final ArrayList<GamePlayer> gamePlayers;

    public PlayerCollection() {
        gamePlayers = new ArrayList<>();
    }

    public void add(GamePlayer data) {
        gamePlayers.add(data);
    }

    public GamePlayer get(String playerType) {

        if (playerType.equals("Striker")) {

            for (GamePlayer player : gamePlayers) {
                if (player instanceof Striker) {
                    return player;
                }
            }
        }
        if (playerType.equals("Goalkeeper")) {
            for (GamePlayer player : gamePlayers) {
                if (player instanceof Goalkeeper) {
                    return player;
                }
            }
        }
        return null;
    }


    @Override
    public Iterator<GamePlayer> iterator() {
        return new PlayerCollectionIterator(gamePlayers);
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }


    public void sort() {
        gamePlayers.sort(Comparator.comparingInt(GamePlayer::getPlayerStatistics));
    }
}

class PlayerCollectionIterator implements Iterator<GamePlayer> {

    private ArrayList<GamePlayer> gamePlayers;
    int count = 0;

    public PlayerCollectionIterator(ArrayList<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    @Override
    public boolean hasNext() {
        return count < gamePlayers.size();
    }

    @Override
    public GamePlayer next() {
        GamePlayer gamePlayer = gamePlayers.get(count);
        count++;
        return gamePlayer;
    }

    @Override
    public void remove() {
        gamePlayers.remove(count);
    }

    @Override
    public void forEachRemaining(Consumer<? super GamePlayer> action) {
        Iterator.super.forEachRemaining(action);
    }
}
