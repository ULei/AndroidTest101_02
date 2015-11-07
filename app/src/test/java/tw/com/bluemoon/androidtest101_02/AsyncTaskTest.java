package tw.com.bluemoon.androidtest101_02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mockit.Mock;
import mockit.MockUp;

/**
 * Created by Chris on 2015/11/7.
 */
public class AsyncTaskTest {
    AsyncTask asyncTask;
    @BeforeMethod
    public void setUp() throws Exception {
        asyncTask = new AsyncTask();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        asyncTask = null;
    }

    @Test
    public void testAsyncTaskSuccess() throws Exception {

        new MockUp<AsyncTask>() {
            @Mock(invocations = 1)
            void call(Callback callback) { callback.success(); }
        };
        asyncTask.call(asyncTask.CallbackImpl);
    }

    @Test
    public void testAsyncTaskFailure() throws Exception {

        new MockUp<AsyncTask>() {
            @Mock(invocations = 1)
            void call(Callback callback) { callback.failure(); }
        };
        asyncTask.call(asyncTask.CallbackImpl);
    }
}