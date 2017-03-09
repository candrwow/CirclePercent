package candrwow.cn.circlepercent;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * TODO 仿照新浪微博加载遮罩
 */
public class MainActivity extends AppCompatActivity {

    CoverPercentProgressBar cpp;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            cpp.sweepAngle = (int) msg.obj;
            cpp.invalidate();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpp = (CoverPercentProgressBar) this.findViewById(R.id.cpp);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Message message = Message.obtain();
                    message.what = 1;
                    message.obj = i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }
}
