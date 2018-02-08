package com.johnpetitto.realmbug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.johnpetitto.library.LibraryModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        try (Realm realm = Realm.getDefaultInstance()) {
            realm.executeTransaction(r -> r.deleteAll());
        }

        RealmConfiguration libraryConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .modules(new LibraryModule())
                .build();

        try (Realm realm = Realm.getInstance(libraryConfig)) {
            realm.executeTransaction(r -> r.deleteAll());
        }
    }
}
