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
        System.out.println("\nbooking [" + start + ", " + end + ")");
        dump("Overlaps: ", overlaps);
        dump("Uniques: ", uniques);
        if (inOverlaps(start, end)) {
            System.out.println("cannot book already doubled");
            return false;
        }

        Map.Entry<Integer, Integer> floor = uniques.floorEntry(start);
        Map.Entry<Integer, Integer> ceiling = uniques.ceilingEntry(start + 1);
        boolean offFloor = floor == null || floor.getValue() <= start;
        boolean offCeiling = ceiling == null || ceiling.getKey() >= end;
        System.out.println("floor -> " + floor + ", ceiling -> " + ceiling);
        if (offFloor && offCeiling) {
            // No intersection, put into uniques
            uniques.put(start, end);
        } else if (!offFloor && !offCeiling) {
            // Intersect with floor and ceiling
            uniques.remove(floor.getKey());
            uniques.remove(ceiling.getKey());
            addCalendar(overlaps, start, floor.getValue());
            addCalendar(overlaps, ceiling.getKey(), end);
            addCalendar(uniques, floor.getKey(), start);
            addCalendar(uniques, floor.getValue(), ceiling.getKey());
            addCalendar(uniques, end, ceiling.getValue());
        } else if (!offFloor) {
            // Intersect with floor only
            int lowerEnd = Math.min(floor.getValue(), end);
            int upperEnd = Math.max(floor.getValue(), end);
            uniques.remove(floor.getKey());
            addCalendar(overlaps, start, lowerEnd);
            addCalendar(uniques, floor.getKey(), start);
            addCalendar(uniques, lowerEnd, upperEnd);
        } else {
            // Intersect with ceicling only
            int lowerStart = Math.min(ceiling.getKey(), start);
            int upperStart = Math.max(ceiling.getKey(), start);
            uniques.remove(ceiling.getKey());
            addCalendar(overlaps, upperStart, end);
            addCalendar(uniques, end, ceiling.getValue());
            addCalendar(uniques, lowerStart, upperStart);
        }

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

    private void addCalendar(TreeMap<Integer, Integer> calendar, int start, int end) {
        if (start == end) {
            return;
        } else if (start < end) {
            calendar.put(start, end);
        } else {
            calendar.put(end, start);
        }
        System.out.println("adding " + start + ", " + end);
    }

    private void dump(String msg, TreeMap<Integer, Integer> tmap) {
        System.out.println(msg + tmap);
    }
}
