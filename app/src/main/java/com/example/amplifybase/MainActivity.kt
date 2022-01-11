package com.example.amplifybase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.Holder
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Amplify", "Initialized Amplify")
        } catch (failure: AmplifyException) {
            Log.e("Amplify", "Could not initialize Amplify", failure)
        }

        val date = Date()
        val offsetMillis = TimeZone.getDefault().getOffset(date.time).toLong()
        val offsetSeconds = TimeUnit.MILLISECONDS.toSeconds(offsetMillis).toInt()
        val temporalDateTime = Temporal.DateTime(date, offsetSeconds)

        val listL:MutableList<Double> =  mutableListOf()
        for(i in 0..100){
            val temp = ThreadLocalRandom.current().nextDouble(0.0, 100.0)
            listL.add(temp)
        }

        //Connect to the cloud
        Amplify.DataStore.observe(Holder::class.java,
            { Log.i("Amplify", "Observation began.") },
            { Log.i("Amplify", it.item().toString()) },
            { Log.e("Amplify", "Observation failed.", it) },
            { Log.i("Amplify", "Observation complete.") }
        )


        val item: Holder = Holder.builder()
            .completedAt(temporalDateTime)
            .data(listL)
            .build()

        //Create
//        Amplify.DataStore.save(
//            item,
//            { success -> Log.i("Amplify", "Saved item: " + success.item().id) },
//            { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
//        )
        //Update
//        Amplify.DataStore.save(
//            updatedItem,
//            { success -> Log.i("Amplify", "Updated item: " + success.item().name) },
//            { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
//        )
        //Delete
//        Amplify.DataStore.delete(toDeleteItem,
//            { deleted -> Log.i("Amplify", "Deleted item.") },
//            { failure -> Log.e("Amplify", "Delete failed.", failure) }
//        )
        //read
        Amplify.DataStore.query(
            Holder::class.java,
            { items ->
                while (items.hasNext()) {
                    val item = items.next()
                    Log.i("Amplify", "Uploaded time: " + item.completedAt)
                    Log.i("Amplify", "Data Uploaded: " + item.data)
                }
            },
            { failure -> Log.e("Amplify", "Could not query DataStore", failure) }
        )

    }


}