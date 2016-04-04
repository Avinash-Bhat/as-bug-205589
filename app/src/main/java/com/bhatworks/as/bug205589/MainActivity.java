package com.bhatworks.as.bug205589;

import com.bhatworks.as.bug205589.databinding.ActivityMainBinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Named;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        binding.setMessage("Hello World!!");
    }

    @Component
    public interface MainComponent {

        void inject(MainActivity activity);
    }

    @Module
    public static class MainModule {

        @Provides
        @Named("message")
        CharSequence provideMessage() {
            return "Hello World!!";
        }
    }
}
