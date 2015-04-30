package edu.mercer.projectcannonball;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.FragmentActivity;

public class CommentActivity extends FragmentActivity{
    EditText cmtTxt;
    String webData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        cmtTxt=(EditText)findViewById(R.id.commentBox);
        Bundle finalBndl=getIntent().getExtras();

        String liked=getResources().getString(R.string.liked)+" ";
        String disliked=getResources().getString(R.string.disliked)+" ";
        int[]likedArray=finalBndl.getIntArray("likedKey");

        for (int i=0;i<likedArray.length;i++) {
            if (likedArray[i]==1) {
                liked=liked+Integer.toString(i+1)+", ";
            }
            else if (likedArray[i]==-1) {
                disliked=disliked+Integer.toString(i + 1)+", ";
            }
        }

        if (!((liked).equals(getResources().getString(R.string.liked)+" "))) {
            liked=liked.substring(0,liked.length()-2);
        }

        if (!((disliked).equals(getResources().getString(R.string.disliked)+" "))) {
            disliked=disliked.substring(0,disliked.length()-2);
        }

        webData=liked+"<br></br>"+disliked+"<br></br>"+getResources().getString(R.string.comments)+" ";
    }

    public void onSubmit(View v) {
        webData=webData+cmtTxt.getText().toString()+"<br></br><br></br>--------------<br></br><br></br></body>";
        String[]webArray={webData};
        new UserUploadTask().execute(webArray);
        RateAppAlertDialogFragment rateDiag = new RateAppAlertDialogFragment();
        rateDiag.show(getSupportFragmentManager(),"alertDialogFragmentTag");
        //finish();
    }

    private class UserUploadTask extends AsyncTask<String,Void,Void> {
        @Override
        protected Void doInBackground(String... webdata) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://sse554.herobo.com/commentscript.php");
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("comments", webdata[0]));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                httpclient.execute(httppost);
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
            return null;
        }

    }
}
