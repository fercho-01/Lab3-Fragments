package co.edu.udea.cmovil.gr1.yambagr1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.thenewcircle.yamba.client.YambaClient;
//import com.marakana.android.yamba.clientlib.YambaClient;
/**
 * Created by telematica on 15/09/15.
 */
public class PostTask extends AsyncTask<String, Void, String> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog progress;
    Context aux;
    public PostTask(Context x){
        this.aux = x;
        progress = new ProgressDialog(x);
    }
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
            Toast.makeText(aux, result, Toast.LENGTH_LONG).show();
        }
    }
}
