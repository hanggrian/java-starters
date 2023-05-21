package com.example.app;

import android.app.Application;
import android.util.Log;

public class MyApp extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Log.d("MyApp", "Started");
  }

  @Override
  public void onTerminate() {
    super.onTerminate();
    Log.d("MyApp", "Killed");
  }
}
