package hackathonbootcamp.littlehelp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class finish extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

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

}
