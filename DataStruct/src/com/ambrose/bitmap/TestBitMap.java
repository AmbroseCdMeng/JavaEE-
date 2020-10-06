package bitmap;

import org.junit.Test;

public class TestBitMap {
    @Test
    public void test() {

        Bitmap bitmap = new Bitmap(16);
        bitmap.set(0, false);
        bitmap.set(1, true);
        bitmap.set(2, false);
        bitmap.set(3, true);
        bitmap.set(4, false);
        bitmap.set(5, false);
        bitmap.set(6, true);
        bitmap.set(7, false);
        bitmap.set(8, false);
        bitmap.set(9, false);
        bitmap.set(10, true);
        bitmap.set(11, false);
        bitmap.set(12, false);
        bitmap.set(13, false);
        bitmap.set(14, false);
        bitmap.set(15, true);
        for (int i = 0; i <= 15; i++) {
            System.out.print(bitmap.get(i) + "\t");
        }
    }
}
