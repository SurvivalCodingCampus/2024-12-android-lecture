package com.surivalcoding.winterandroidstudy

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.surivalcoding.winterandroidstudy.day02.Ingredient
import com.surivalcoding.winterandroidstudy.day02.IngredientItem
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : ComponentActivity() {
    private val userSettings by lazy {
        UserSettings(this)
    }


    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        count++
        println("count: $count")
        setContent {
            IngredientItem(
                ingredient = Ingredient(
                    imageUrl = "https://i.namu.wiki/i/Twln-UKmoTWrVDom5UAE85O-8IiNDR0rZT0A1mrWUfgUVLAPD0wL5k-4wEX5e5iHrfYzi00JwynnoZmW9M7JT9mVTU4CU3qXtczVKOmXWvok_1KCFQMM4cKIRFwYU5xiS3ZMxu50QTl0H59vO6pPGA.webp",
                    name = "TODO()",
                    amount = "TODO()"
                )
            )
        }

        val pref = getSharedPreferences("user_settings", Context.MODE_PRIVATE)


        pref.edit().putString("name", "홍길동").apply()


//        println(pref.getString("name", "기본값"))

//        var name : String by PreferenceDelegate()
//        println(name)

        userSettings.userName = "한석봉"

        println(userSettings.userName)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")

        // UI 에 복원
    }
}


class PreferenceDelegate(
    private val preference: SharedPreferences,
    private val key: String,
    private val default: String,
) : ReadWriteProperty<PreferenceModel, String> {


    override fun getValue(thisRef: PreferenceModel, property: KProperty<*>): String {
        return preference.getString(key, default)!!
    }

    override fun setValue(thisRef: PreferenceModel, property: KProperty<*>, value: String) {
        preference.edit().putString(key, value).apply()
    }
}

interface PreferenceModel {
    val context: Context
}


class UserSettings(override val context: Context) : PreferenceModel {
    var userName by PreferenceLoader("")
    var iconUrl by PreferenceLoader("")
    var photoUrl by PreferenceLoader("")
}

class PreferenceLoader(private val default: String) {

    operator fun provideDelegate(
        thisRef: PreferenceModel,
        property: KProperty<*>
    ): ReadWriteProperty<PreferenceModel, String> {
        return PreferenceDelegate(
            thisRef.context.getSharedPreferences(
                thisRef.javaClass.simpleName,
                Context.MODE_PRIVATE
            ),
            property.name,
            default
        )
    }
}



