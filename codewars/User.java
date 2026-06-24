public class User {
    public int rank = -8;
    public int progress = 0;

    public void incProgress(int activityRank) {
        validateRank(activityRank);

        if (rank == 8) {
            return;
        }

        int points = calculatePoints(activityRank);
        progress += points;

        while (progress >= 100 && rank < 8) {
            progress -= 100;
            rank = nextRank(rank);
        }

        if (rank == 8) {
            progress = 0;
        }
    }

    private static void validateRank(int rank) {
        if (rank == 0 || rank < -8 || rank > 8) {
            throw new IllegalArgumentException("Invalid rank: " + rank);
        }
    }

    private int calculatePoints(int activityRank) {
        int diff = toIndex(activityRank) - toIndex(rank);

        if (diff == 0) {
            return 3;
        }
        if (diff == -1) {
            return 1;
        }
        if (diff <= -2) {
            return 0;
        }

        return 10 * diff * diff;
    }

    private static int toIndex(int rank) {
        return rank < 0 ? rank + 8 : rank + 7;
    }

    private static int nextRank(int rank) {
        return rank == -1 ? 1 : rank + 1;
    }
}