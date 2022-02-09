package model.players;

public class PlayerStatistics {

    private int statistic;

    public PlayerStatistics() {
        statistic = 0;
    }

    public int getStatistics() {
        return statistic;
    }

    public void setStatistics(int newStatistics) {
        this.statistic = newStatistics;
    }

    @Override
    public String toString() {
        return statistic + "";
    }
}
