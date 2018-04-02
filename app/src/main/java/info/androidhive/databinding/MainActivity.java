package info.androidhive.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import info.androidhive.databinding.databinding.ActivityMainBinding;
import info.androidhive.databinding.model.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    MyHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        handlers = new MyHandlers(this);

        User user = new User();
        user.setName("Ravi Tamada");
        user.setEmail("ravi8x@gmail.com");
        user.setProfileImage("https://avatars2.githubusercontent.com/u/497670?s=400&v=4");
        user.setWebsite("www.rxjava.wtf");
        user.setNumberOfFollowers(100);
        user.setNumberOfFollowing(200);
        user.setNumberOfPosts(2400);

        binding.setUser(user);
        binding.content.setHandlers(handlers);
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

    public class MyHandlers {

        Context context;

        public MyHandlers(Context context) {
            this.context = context;
        }


        public void onButtonClick(View view) {
            Toast.makeText(context, "Button is clicked!", Toast.LENGTH_SHORT).show();
        }

        public boolean onButtonLongPressed(View view, String name) {
            Toast.makeText(context, "Button is long pressed! " + name, Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
