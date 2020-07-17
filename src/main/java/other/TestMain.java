package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class:
 *
 * @author 秦超
 * 2018/7/23
 */
public class TestMain {
    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;

        System.out.println(i);
    }

    String[] ss = new String[3];

    List<String> ls = new ArrayList<String>();
    List<String> ls2 = Arrays.asList(ss);

    String a = String.valueOf(2);
}
