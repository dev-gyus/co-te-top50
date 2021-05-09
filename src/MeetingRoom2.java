import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval2 {
    int start;
    int end;

    public Interval2() {
    }

    public Interval2(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRoom2 {
    public static void main(String[] args) {
        MeetingRoom2 a = new MeetingRoom2();
        Interval2 int3 = new Interval2(0, 30);
        Interval2 int1 = new Interval2(4, 9);
        Interval2 int4 = new Interval2(10, 16);
        Interval2 int2 = new Interval2(5, 15);

        Interval2[] interval2s = {int1, int2, int3, int4};
        System.out.println(a.solve1(interval2s));
    }

    public int solve1(Interval2[] intervals) {
        //1 error, empty check
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });

        // Min Heap ( 첫번째부터 오름차순으로 이진트리구조 채워짐 )
        Queue<Interval2> pq = new PriorityQueue<>((a, b) -> {
            return a.end - b.end;
        });
        pq.offer(intervals[0]);
        //2 for OR while
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek().end <= intervals[i].start) {
                // 회의실의 갯수만 물어본 것이므로 방금 추가한거 poll해서 버리고 새로추가하는것
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
}
