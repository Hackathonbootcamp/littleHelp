package hackathonbootcamp.littlehelp;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import org.apache.http.HttpResponse;

public class MainActivity extends Activity implements LoaderCallbacks<HttpResponse> {

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
        return true;
    }

    public void helpRequest(String str) {
        // Bundleにはパラメータを保存する（1）
        Bundle bundle = new Bundle();
        if (str == "1") {
            // 大阪府の天気予報を返すAPIのURLを格納する（2）
            bundle.putString("url", "http://helpme4civictech.herokuapp.com/helpme?user_id=1&severity=" + str + "&latitude=34.7416251&longitude=135.5506565&msg=ああああ");
        } else if (str == "2") {
            // 大阪府の天気予報を返すAPIのURLを格納する（2）
            bundle.putString("url", "http://helpme4civictech.herokuapp.com/helpme?user_id=1&severity=" + str + "&latitude=34.715483&longitude=135.504286&msg=ああああ");
        } else {
            // 大阪府の天気予報を返すAPIのURLを格納する（2）
            bundle.putString("url", "http://helpme4civictech.herokuapp.com/helpme?user_id=1&severity=" + str + "&latitude=34.7010813&longitude=135.4881838&msg=ああああ");
        }
        //
        // LoaderManagerの初期化（3）
        getLoaderManager().initLoader(0, bundle, this);
    }

    public void finished() {
        Intent intent = new Intent(this, finish.class);
        startActivity(intent);
    }
}