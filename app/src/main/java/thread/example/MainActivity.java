package thread.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private Button thread,mainthread;
    private ProgressBar loadingbar;
    private TextView terminal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting up layout componants
        setContentView(R.layout.main_layout);
        thread=(Button) findViewById(R.id.Thread_1);
        mainthread=(Button) findViewById(R.id.MainTHread);
        loadingbar=(ProgressBar) findViewById(R.id.progressBar);
        terminal=(TextView) findViewById(R.id.Terminal);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void Thread_1_Clicked(View v){
        Log.println(Log.INFO,"Main","Thread_1 CLicked");
        loadingbar.setVisibility(View.VISIBLE);
        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() {
                double counter=1;
                terminal.append(">>Starting Thread_1\n");
                while(counter<100){
                    loadingbar.setProgress((int)counter);
                    counter+=0.00001;
                }
                loadingbar.setProgress(0);
                loadingbar.setVisibility(View.INVISIBLE);
                terminal.append(">>Progress is finished\n>>hiding progressbar\n");
            }

        });
        thread.start();
    }
    public void Main_Thread_Clicked(View v){
        Log.println(Log.INFO,"Main","Main_Thread_Clicked");
        loadingbar.setVisibility(View.VISIBLE);
        terminal.append(">>Main Thread is running\n>>Crushing is expected\n");
        double counter=1;
        while(counter<100){
            loadingbar.setProgress((int)counter);
            counter+=0.0000000001;
        }
    }

}