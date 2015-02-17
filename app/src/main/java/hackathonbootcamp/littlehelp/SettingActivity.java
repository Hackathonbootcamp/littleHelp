package hackathonbootcamp.littlehelp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SettingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button button = null;
        // クリックイベントを取得したいボタン
        button = (Button) findViewById(R.id.backButton);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                back();
            }
        });
        // クリックイベントを取得したいボタン
        button = (Button) findViewById(R.id.registButton);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                regist();
            }
        });
        // 保存されている値の設定
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        EditText edit = (EditText) findViewById(R.id.needHelpIdText);
        edit.setText(sp.getString("needHelpId", null));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    public void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void regist() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        EditText edit = (EditText) findViewById(R.id.needHelpIdText);
        sp.edit().putString("needHelpId", edit.getText().toString()).commit();
        Toast.makeText(SettingActivity.this, "保存しました", Toast.LENGTH_LONG).show();
    }
}
