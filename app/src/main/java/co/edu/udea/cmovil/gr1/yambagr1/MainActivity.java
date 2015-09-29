package co.edu.udea.cmovil.gr1.yambagr1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import com.marakana.*;
//import com.marakana.android.yamba.clientlib.YambaClient;
import co.edu.udea.cmovil.gr1.yambagr1.PostTask;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mButtonTweet;
    private EditText mTextStatus;
    private TextView mTextCount;
    private int mDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonTweet= (Button) findViewById(R.id.status_button_tweet);
        mTextStatus = (EditText) findViewById(R.id.status_text);
        mTextCount = (TextView) findViewById(R.id.status_text_count);
        mTextCount.setText(Integer.toString(140));
        mDefaultColor = mTextCount.getTextColors().getDefaultColor();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnToPost(View V){
        String status = mTextStatus.getText().toString();
        PostTask postTask = new PostTask(MainActivity.this);
        postTask.execute(status);
        Log.d(TAG, "onClicked");

    }
    public void desbloquear(View V){
        if(!mTextStatus.getText().toString().equals("")){
            mButtonTweet.setEnabled(true);
        }else{
            mButtonTweet.setEnabled(false);
        }
    }
}
/*
public class PostTask extends AsyncTask <String, Void, String> {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog progress;
    @Override
    protected String doInBackground(String... params) {
        try {
            YambaClient cloud = new YambaClient("student", "password");
            cloud.postStatus(params[0]);
            Log.d(TAG, "successfully posted on the cloud: " + params[0]);
            return "successfully posted";
        }
        catch (Exception e){
            Log.e(TAG, "Failed to post to the cloud", e);
            e.printStackTrace();
            return "Failed to post";
        }
    }
    @Override
    protected void onPreExecute() {

    }

    protected void onPostExecute(String result){
        progress.dismiss();
        if (this != null && result!= null) {
            //Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            
        }
    }

}
*/