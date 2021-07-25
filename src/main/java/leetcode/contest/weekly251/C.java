package leetcode.contest.weekly251;

public class C {

    private int n;

    int[] perm;

    int maxCompat = 0;

    int[][] students;

    int[][] mentors;

    public int maxCompatibilitySum(
            int[][] students,
            int[][] mentors) {
        n = students.length;
        this.students = students;
        this.mentors = mentors;
        perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        nextPermut(0, 0);
        return maxCompat;
    }

    private void nextPermut(int index, int mask) {
        if (index == n) {
            // No more permutations. Do something here.
            apply(perm);
        }

        // I'm trying to put all numbers here
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                // I can put this number
                perm[index] = i;
                nextPermut(index + 1, mask | (1 << i));
            }
        }
    }

    private void apply(int[] perm) {
        int result = 0;

        for (int i = 0; i < students.length; i++) {
            int[] student = students[i];
            int[] mentor = mentors[perm[i]];

            for (int k = 0; k < student.length; k++) {
                result += (student[k] == mentor[k] ? 1 : 0);
            }
        }

        maxCompat = Math.max(maxCompat, result);
    }


}
