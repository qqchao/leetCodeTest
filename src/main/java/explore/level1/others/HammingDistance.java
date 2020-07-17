package explore.level1.others;

/**
 * Class:
 *
 * @author 秦超
 * 2018/7/23
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(23, 42));
    }

    public static int hammingDistance(int x, int y) {
        int temp;
        if(x > y){
            temp = x;
            x = y;
            y = temp;
        }
        int count = 0;

        char[] cx = Integer.toBinaryString(x).toCharArray();
        char[] cy = Integer.toBinaryString(y).toCharArray();

        for(int i = 0; i < (cy.length - cx.length); i++){
            if(cy[i] == '1') count++;
        }
        for(int i = cy.length - cx.length; i < cy.length; i++){
            if(cy[i] != cx[i + cx.length - cy.length]) count++;
        }

        return count;
    }
}
