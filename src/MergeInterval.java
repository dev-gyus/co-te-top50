import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval1 {
    int start;
    int end;

    Interval1() {
        start = 0;
        end = 0;
    }

    Interval1(int s, int e) {
        start = s;
        end = e;
    }

    public void print(){
        System.out.println("start = " + start + " end = " + end);
    }
}

public class MergeInterval {
    public static void main(String[] args) {
        Interval1 int1 = new Interval1(1, 3);
        Interval1 int2 = new Interval1(2, 6);
        Interval1 int3 = new Interval1(8, 10);
        Interval1 int4 = new Interval1(15, 18);

        List<Interval1> interval1s = new ArrayList<>();
        interval1s.add(int1);
        interval1s.add(int2);
        interval1s.add(int3);
        interval1s.add(int4);

        MergeInterval a = new MergeInterval();
        List<Interval1> list = a.merge(interval1s);

        for (Interval1 interval1 : list) {
            interval1.print();
        }
    }

    public List<Interval1> merge(List<Interval1> interval1s) {
        // error, empty check
        if (interval1s.isEmpty()) return interval1s;

        // 1
        List<Interval1> result = new ArrayList<>();

        // 시작히간에 대한 오름차순 정렬해놓고 시작
        Collections.sort(interval1s, (a, b) -> {
            return a.start - b.start;
        });

        for (int i = 1; i < interval1s.size(); i++) {
            Interval1 interval1 = interval1s.get(i);
            if (interval1s.get(i-1).end > interval1s.get(i).start) {
                Interval1 newInterval = new Interval1(interval1s.get(i - 1).start, interval1s.get(i).end);
                result.add(newInterval);
            }else{
                result.add(interval1s.get(i));
            }
        }
        return result;
    }
}
