package com.fangrongfu.myfirstapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fangrongfu.myfirstapp.Bean.User;
import com.fangrongfu.myfirstapp.Controller.Impl.UserControllerImpl;
import com.fangrongfu.myfirstapp.R;

import java.io.IOException;

/**
 * 作者：方荣福
 * View层
 * 操作Controller获取数据（登陆结果），显示在TextView上
 */
public class LoginActivity extends AppCompatActivity {

    private UserControllerImpl userControllerImpl;

    private EditText et_user;
    private EditText et_password;
    private Button bt_login;
    private TextView tv_result_value;
    private ImageView iv_loging_result;

    private User user;

    private Handler handler = new Handler() {
      public void handleMessage(Message msg){
          String url;
          switch (msg.what){
              case 1:
                  tv_result_value.setText("登陆成功！");
                  url = "http://pic.51yuansu.com/pic3/cover/01/04/89/5900f387d5035_610.jpg";
                  userControllerImpl.loadImage(url,iv_loging_result);
                  break;
              case 0:
                  tv_result_value.setText("登陆失败！");
                  url = "https://images.669pic.com/element_pic/31/79/81/65/e1e515684e9594678816f98d57d32c78.jpg_w700wb";
                  userControllerImpl.loadImage(url,iv_loging_result);
                  break;
              default:
                  break;
          }
      }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_user = findViewById(R.id.editText_user);
        et_password = findViewById(R.id.editText_password);
        tv_result_value = findViewById(R.id.textView_result_value);
        bt_login = findViewById(R.id.button_login);
        iv_loging_result = findViewById(R.id.imageView_login_result);

        userControllerImpl = new UserControllerImpl();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = new User(et_user.getText().toString(),et_password.getText().toString());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        try {
                            if(userControllerImpl.login(user)){
                                message.what = 1;
                            }else{
                                message.what = 0;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        handler.sendMessage(message);//将Message对象发送出去
                    }
                }).start();
            }
        });
    }
}
