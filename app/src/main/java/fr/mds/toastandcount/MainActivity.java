package fr.mds.toastandcount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mShowCount ;
    int mCount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mShowCount = (TextView) findViewById(R.id.TV_show_count);
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }

    public void showToast(View view) {
        Toast.makeText(this , "hey, that's a toast !"  , Toast.LENGTH_SHORT).show();
    }


    // manage rotation


    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putInt("theCount" , this.mCount);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.mCount = savedInstanceState.getInt("theCount");
        this.mShowCount.setText(Integer.toString(this.mCount));
    }


}