package edu.mercer.projectcannonball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends ActionBarActivity {
    TextView infoTxt;
    Button yesBtn, noBtn;
    Bundle bndlFromMain;
    int likeNum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        infoTxt=(TextView)findViewById(R.id.info);
        yesBtn=(Button)findViewById(R.id.yesBtn);
        noBtn=(Button)findViewById(R.id.noBtn);
        bndlFromMain=getIntent().getExtras();
        String[]titles=getResources().getStringArray(R.array.titles);
        String[]infos=getResources().getStringArray(R.array.infos);
        setTitle(titles[bndlFromMain.getInt("spotKey")-1]);
        infoTxt.setText(infos[bndlFromMain.getInt("spotKey")-1]);
    }



    public void onLike(View v) {
        if (v==yesBtn) {
            likeNum=1;
            yesBtn.setEnabled(false);
            noBtn.setEnabled(true);
        }

        else if (v==noBtn) {
            likeNum=-1;
            noBtn.setEnabled(false);
            yesBtn.setEnabled(true);
        }
    }


    @Override
    public void onBackPressed() {
        super.onStop();
        Intent mainActivity=new Intent();
        bndlFromMain.putInt("likedKey",likeNum);
        mainActivity.putExtras(bndlFromMain);
        setResult(RESULT_OK,mainActivity);
        finish();
    }
}
