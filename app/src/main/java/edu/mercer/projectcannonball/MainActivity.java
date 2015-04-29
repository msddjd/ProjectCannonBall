package edu.mercer.projectcannonball;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    Button cmtBtn;
    TextView cmtPrmpt;
    boolean[]viewed=new boolean[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmtBtn=(Button)findViewById(R.id.commentBtn);
        cmtPrmpt=(TextView)findViewById(R.id.commentPrompt);
    }

    protected void onBtnClick(View v) {
        if (v.getId()==R.id.commentBtn) {

        }
        else {
            Intent infoIntent=new Intent(this,InfoActivity.class);
            Bundle spotBndl=new Bundle();
            switch (v.getId()) {
                case R.id.spot1Btn:
                    spotBndl.putInt(getResources().getString(R.id.spotKey),1);
                    infoIntent.putExtras(spotBndl);
                case R.id.spot2Btn:
                case R.id.spot3Btn:
                case R.id.spot4Btn:
                case R.id.spot5Btn:
            }
        }
    }
}
