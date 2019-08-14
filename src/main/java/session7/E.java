package session7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// E. Greedy Elevator
public class E {
    private static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static PrintWriter out = new PrintWriter(System.out);

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        final int n = nextInt(), m = nextInt();
        final Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            people[i] = new Person(i, nextInt(), nextInt(), nextInt());
        }

        Arrays.sort(people, Comparator.comparing(person -> person.time));
        final List<Person>[] peopleOnTheFloor = new ArrayList[n];
        final List<Person>[] peopleInTheElevatorByTargetFloor = new ArrayList[n];

        int[] finalTimes = new int[n];
        int peopleProcessed = 0;
        int peopleIndex = 0;
        int currentTime = people[peopleIndex].time;
        int currentFloor = 1;
        while (peopleProcessed < n) {
            // People are coming to the floor
            while (peopleIndex < n && people[peopleIndex].time <= currentTime) {
                peopleOnTheFloor[currentFloor].add(people[peopleIndex]);
                peopleIndex++;
            }

            // People are going from the elevator
            for (Person outgoing : peopleInTheElevatorByTargetFloor[currentFloor]) {
                finalTimes[outgoing.index] = currentTime;
            }
            peopleInTheElevatorByTargetFloor[currentFloor].clear();

        }

        for (int finalTime : finalTimes) {
            out.println(finalTime);
        }

        out.flush();
    }

    static class Person {
        int index, time, source, target;

        public Person(int index, int time, int source, int target) {
            this.index = index;
            this.time = time;
            this.source = source;
            this.target = target;
        }
    }
}
