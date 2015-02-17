package hackathonbootcamp.littlehelp;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpResponse;

public class MainActivity extends ActionBarActivity implements LoaderCallbacks<HttpResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = null;
        // クリックイベントを取得したいボタン
        button = (Button) findViewById(R.id.helpRed);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                helpRequest("1");
                finished();
            }
        });
        // クリックイベントを取得したいボタン
        button = (Button) findViewById(R.id.helpYellow);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                helpRequest("2");
                finished();
            }
        });
        // クリックイベントを取得したいボタン
        button = (Button) findViewById(R.id.helpBlue);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                helpRequest("3");
                finished();
            }
        });
    }

    @Override
    public Loader<HttpResponse> onCreateLoader(int id, Bundle bundle) {
        // HttpAsyncLoaderの生成（4）
        HttpAsyncLoader loader = new HttpAsyncLoader(this, bundle.getString("url"));
        // Web APIの呼び出し（5）
        loader.forceLoad();
        return null;
    }

    @Override
    public void onLoadFinished(Loader<HttpResponse> loader, HttpResponse response) {
        // 今回は何も処理しない
    }

    @Override
    public void onLoaderReset(Loader<HttpResponse> loader) {
        // 今回は何も処理しない
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    public void helpRequest(String str) {
        // 助けて通知を投げる
        // URL：http://helpnotice.herokuapp.com/helpme
        // パラメータ1：need_help_id
        // パラメータ2：severity
        // パラメータ3：latitude
        // パラメータ4：longitude
        Bundle bundle = new Bundle();
        String url = "http://helpnotice.herokuapp.com/helpme";
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String needHelpId = sp.getString("needHelpId", null);
        String latitude = "34.645842";
        String longitude = "135.513971";
        bundle.putString("url", url + "?need_help_id=" + needHelpId + "&severity=" + str + "&latitude=" + latitude + "&longitude=" + longitude);
        // LoaderManagerの初期化（3）
        getLoaderManager().initLoader(0, bundle, this);
    }

    public void finished() {
        Intent intent = new Intent(this, finish.class);
        startActivity(intent);
    }
}