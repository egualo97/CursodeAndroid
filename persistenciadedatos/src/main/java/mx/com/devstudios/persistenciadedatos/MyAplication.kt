package mx.com.devstudios.persistenciadedatos

import android.app.Application
import io.realm.Realm
import io.realm.RealmCollection
import io.realm.RealmConfiguration

/**
 * Created by egual on 23/10/2017.
 */
class MyAplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config =RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }
}