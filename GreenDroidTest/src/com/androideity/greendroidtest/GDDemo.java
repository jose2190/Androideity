package com.androideity.greendroidtest;

import greendroid.app.GDApplication;
import android.content.Intent;

public class GDDemo extends GDApplication {
    @Override
   public Class<?> getHomeActivityClass() {
       return GDDemo.class;
   }

   @Override
   public Intent getMainApplicationIntent() {
       return new Intent(Intent.ACTION_DEFAULT);
   }
}
