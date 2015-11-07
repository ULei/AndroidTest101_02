package tw.com.bluemoon.androidtest101_02;

import java.util.Random;

/**
 * Created by Chris on 2015/11/7.
 */
public class AsyncTask {
    Random ran = new Random();
    int  status = ran.nextInt(2) + 1;

    public void call(final Callback callback) {

        System.out.println("" + status);
        new Thread() {

            @Override

            public void run() {
                try {
                    //模擬網路傳輸延遲
                    sleep(1000 * status);
                    switch (status) {
                        case 1:
                            callback.success();
                            break;
                        case 2:
                            callback.failure();
                            break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }.start();
    }

    public Callback CallbackImpl = new Callback() {
        @Override
        public void success() {
            System.out.println("success");
        }

        @Override
        public void failure() {
            System.out.println("failure");
        }
    };
}
