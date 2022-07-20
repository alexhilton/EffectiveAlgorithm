package daily;

import java.util.Map;
import java.util.TreeMap;

public class P731MyCalendarTwo {
    private TreeMap<Integer, Integer> overlaps;
    private TreeMap<Integer, Integer> uniques;

    public P731MyCalendarTwo() {
        overlaps = new TreeMap<>();
        uniques = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (inOverlaps(start, end)) {
            return false;
        }

        if (uniques.containsKey(start)) {
            int oldEnd = uniques.get(start);
            int upperEnd = Math.max(oldEnd, end);
            int lowerEnd = Math.min(oldEnd, end);
            overlaps.put(start, lowerEnd);
            uniques.remove(start);
            uniques.put(lowerEnd, upperEnd);
            return true;
        }

        Map.Entry<Integer, Integer> floor = uniques.floorEntry(start);
        if (floor != null && floor.getValue() > start) {
            int lowerEnd = Math.min(floor.getValue(), end);
            int upperEnd = Math.max(floor.getValue(), end);
            overlaps.put(start, lowerEnd);
            uniques.put(floor.getKey(), start);
            uniques.put(lowerEnd, upperEnd);
            return true;
        }

        Map.Entry<Integer, Integer> ceiling = uniques.ceilingEntry(start);
        if (ceiling != null && ceiling.getKey() < end) {
            int lowerStart = Math.min(ceiling.getKey(), start);
            int upperStart = Math.max(ceiling.getKey(), start);
            overlaps.put(upperStart, end);
            uniques.put(end, ceiling.getValue());
            uniques.put(lowerStart, upperStart);
            return true;
        }

        uniques.put(start, end);
        return true;
    }

    private boolean inOverlaps(int start, int end) {
        if (overlaps.containsKey(start)) {
            return true;
        }
        Map.Entry<Integer, Integer> floor = overlaps.floorEntry(start);
        if (floor != null && floor.getValue() > start) {
            return true;
        }

        Map.Entry<Integer, Integer> ceiling = overlaps.ceilingEntry(start);
        if (ceiling != null && ceiling.getKey() < end) {
            return true;
        }

        return false;
    }
}
