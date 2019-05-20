public class StepTracker {
    private int goal, steps, days, active;

    public StepTracker(int goal) {
        this.goal = goal;
    }

    /**
     * @return the number of active days
     */
    public int activeDays() {
        return active;
    }

    /**
     * @return the average number of steps per day, calculated by dividing the
     * total number of steps taken by the number of days tracked
     */
    public double averageSteps() {
        if (days == 0)
            return 0.0;
        return ((double) steps) / days;
    }

    /**
     * accumulates information about steps, in readings taken once per day
     * @param steps the steps to add
     */
    public void addDailySteps(int steps) {
        this.steps += steps;
        days++;
        if (steps >= goal)
            active++;
    }

    public static void main(String[] args) {
        StepTracker tr = new StepTracker(10000);
        // Days with at least 10,000 steps are considered
        // active. Assume that the parameter is positive.

        System.out.println(tr.activeDays()); // -> 0
        // No data have been recorded yet.

        System.out.println(tr.averageSteps()); // -> 0.0
        // When no step data have been recorded, the
        // averageSteps method returns 0.0.

        tr.addDailySteps(9000);
        // This is too few steps for the day to be considered
        // active.

        tr.addDailySteps(5000);
        // This is too few steps for the day to be considered
        // active.

        System.out.println(tr.activeDays()); // -> 0
        // No day had at least 10,000 steps.

        System.out.println(tr.averageSteps()); // -> 7000.0
        // The average number of steps per day is (14000 / 2).

        tr.addDailySteps(13000);
        // This represents an active day.

        System.out.println(tr.activeDays()); // -> 1
        // Of the three days for which step data were entered,
        // one day had at least 10,000 steps.

        System.out.println(tr.averageSteps()); // -> 9000.0
        // The average number of steps per day is (27000 / 3).

        tr.addDailySteps(23000);
        // This represents an active day.

        tr.addDailySteps(1111);
        // This is too few steps for the day to be considered
        // active.

        System.out.println(tr.activeDays()); // -> 2
        // Of the five days for which step data were entered,
        // two days had at least 10,000 steps.

        System.out.println(tr.averageSteps()); // -> 10222.2
        // The average number of steps per day is (51111 / 5).
    }
}
