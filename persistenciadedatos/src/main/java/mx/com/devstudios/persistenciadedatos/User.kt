package mx.com.devstudios.persistenciadedatos

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by egual on 23/10/2017.
 */
open class User : RealmObject() {
    var name: String? = null
    var lastName: String? = null
    var age: Int? = null


    @PrimaryKey
    var id : Int? = null

}