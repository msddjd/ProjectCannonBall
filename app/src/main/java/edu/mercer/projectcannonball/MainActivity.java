package edu.mercer.projectcannonball;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {
    Button cmtBtn;
    TextView cmtPrmpt;
    boolean[]viewed=new boolean[5];
    int[]liked=new int[5];
    private int spot_id=1;
    private boolean[]allViewed={true,true,true,true,true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmtBtn=(Button)findViewById(R.id.commentBtn);
        cmtPrmpt=(TextView)findViewById(R.id.commentPrompt);
    }

    protected void onBtnClick(View v) {
        if (v.getId()==R.id.commentBtn) {
            cmtBtn.setEnabled(false);
            Intent commentIntent=new Intent(this,CommentActivity.class);
            Bundle cmtBndl=new Bundle();
            cmtBndl.putIntArray("likedKey",liked);
            commentIntent.putExtras(cmtBndl);
            startActivity(commentIntent);
        }
        else {
            Intent infoIntent=new Intent(this,InfoActivity.class);
            Bundle spotBndl=new Bundle();
            switch (v.getId()) {
                case R.id.spot1Btn:
                    spotBndl.putInt("spotKey", 1);
                    infoIntent.putExtras(spotBndl);
                    startActivityForResult(infoIntent, spot_id);
                    break;
                case R.id.spot2Btn:
                    spotBndl.putInt("spotKey",2);
                    infoIntent.putExtras(spotBndl);
                    startActivityForResult(infoIntent, spot_id);
                    break;
                case R.id.spot3Btn:
                    spotBndl.putInt("spotKey",3);
                    infoIntent.putExtras(spotBndl);
                    startActivityForResult(infoIntent, spot_id);
                    break;
                case R.id.spot4Btn:
                    spotBndl.putInt("spotKey",4);
                    infoIntent.putExtras(spotBndl);
                    startActivityForResult(infoIntent, spot_id);
                    break;
                case R.id.spot5Btn:
                    spotBndl.putInt("spotKey",5);
                    infoIntent.putExtras(spotBndl);
                    startActivityForResult(infoIntent, spot_id);
                    break;
            }
        }
    }

    public void onActivityResult(int rcvdRsltId, int rcvdRsltCode, Intent rcvdData) {
        if   (rcvdRsltId ==spot_id   ) {
            if (rcvdRsltCode == RESULT_OK)    {
                viewed[rcvdData.getExtras().getInt("spotKey")]=true;
                liked[rcvdData.getExtras().getInt("spotKey")]=rcvdData.getExtras().getInt("likedKey");
                if (cmtBtn.getVisibility()==View.GONE&&Arrays.equals(viewed,allViewed)) {
                    cmtBtn.setVisibility(View.VISIBLE);
                    cmtPrmpt.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
