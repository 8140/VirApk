package cm.mfdog.virapk;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button load;
    Button tiaozhuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }
    FrameLayout fragment;
    void loadfragment(){

    }
    void  initview(){
        load=findViewById(R.id.loadplugin);
        tiaozhuan=findViewById(R.id.tiaozhuan);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPlugin();
            }
        });


        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClassName("cm.mfdog.virapk","cm.mfdog.plugindemo.PluginActivity");
                        intent.putExtra("data","aaaaaaaaaaa");
                startActivity(intent);
            }
        });


    }

    public void loadPlugin() {
        PluginManager pluginManager = PluginManager.getInstance(this);
        //此处是当查看插件apk是否存在,如果存在就去加载(比如修改线上的bug,把插件apk下载到sdcard的根目录下取名为plugin-release.apk)
        File apk = new File(Environment.getExternalStorageDirectory(), "ppp.apk");
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
                Toast.makeText(this, "插件加载成功", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "插件加载异常！", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
