package cm.mfdog.plugindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

public class PluginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pluginlayout);
        String data = getIntent().getStringExtra("data");
        if (!TextUtils.isEmpty(data)) {
            Toast.makeText(this, "我是宿主app传来的消息"+data, Toast.LENGTH_SHORT).show();


        }
    }
}
