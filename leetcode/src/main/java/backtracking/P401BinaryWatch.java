package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P401BinaryWatch {
    private List<String> result;
    private boolean[] watch;

    public List<String> readBinaryWatch(int turnedOn) {
        result = new ArrayList<>();
        if (turnedOn >= 9) {
            return result;
        }
        watch = new boolean[10];
        binaryWatch(0, turnedOn);
        return result;
    }

    private void binaryWatch(int index, int on) {
        if (on == 0 && valid()) {
            result.add(formatTime());
        } else if (index < 10 && on > 0 && valid()) {
            binaryWatch(index + 1, on);
            watch[index] = true;
            binaryWatch(index + 1, on - 1);
            watch[index] = false;
        }
    }

    private String formatTime() {
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            if (watch[i]) {
                hour += (1 << (3 - i));
            }
        }
        int minute = 0;
        for (int i = 4; i < 10; i++) {
            if (watch[i]) {
                minute += (1 << (9 - i));
            }
        }
        return String.format("%d:%02d", hour, minute);
    }

    private boolean valid() {
//        int hour = 0;
//        for (int i = 0; i < 4; i++) {
//            if (watch[i]) {
//                hour += (1 << (3 - i));
//            }
//        }
//        int minute = 0;
//        for (int i = 4; i < 10; i++) {
//            if (watch[i]) {
//                minute += (1 << (9 - i));
//            }
//        }
//        System.out.println("   hour->" + hour + ", min-> " + minute);
//        System.out.println("      watch -> " + Arrays.toString(watch));
        boolean invalidHour = (watch[0] && watch[1]);
        boolean invalidMinute = watch[4] && watch[5] && watch[6] && watch[7];
//        System.out.println("        invalid -> "+(invalidHour || invalidMinute));
        return !(invalidMinute || invalidHour);
    }

    public static void main(String[] args) {
        P401BinaryWatch bw = new P401BinaryWatch();
        System.out.println("0-> " + bw.readBinaryWatch(0));
        System.out.println("1-> " + bw.readBinaryWatch(1));
        System.out.println("2-> " + bw.readBinaryWatch(2));
        System.out.println("3-> " + bw.readBinaryWatch(3));
        System.out.println("4-> " + bw.readBinaryWatch(4));
        System.out.println("8-> " + bw.readBinaryWatch(8));
        System.out.println("9-> " + bw.readBinaryWatch(9));
    }
}
