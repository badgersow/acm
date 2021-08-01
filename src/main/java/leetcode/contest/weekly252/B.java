package leetcode.contest.weekly252;

public class B {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
        }

        long cantWork = 0L;
        for (int i = 0; i < milestones.length; i++) {
            cantWork = Math.max(cantWork, milestones[i] - (sum - milestones[i]) - 1);
        }

        return sum - cantWork;
    }
}
