package com.robelseyoum3.jsonparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private var personNames = ArrayList<String>()
    private var emailIds = ArrayList<String>()
    private var mobileNumber = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearManager = LinearLayoutManager(applicationContext)
        recyclerVeiw.layoutManager = linearManager


        try {
            // since we have JSON object, so we are getting the object
            //here we are calling a function and that function is returning the JSON object
            val obj = JSONObject(loadJSONFromAsset())

            // fetch JSONArray named users by using getJSONArray
            val userArray = obj.getJSONArray("users")

            // implement for loop for getting users data i.e. name, email and contact
            for(i in 0 until userArray.length()){

                // create a JSONObject for fetching single user data
                val userDetail = userArray.getJSONObject(i)

                // fetch email and name and store it in arraylist
                personNames.add(userDetail.getString("name"))
                emailIds.add(userDetail.getString("email"))

                // create a object for getting contact data from JSONObject
                val contact = userDetail.getJSONObject("contact")

                // fetch mobile number 1 and store it in arraylist of mobileNumber
                mobileNumber.add(contact.getString("mobile1"))

                }
            //  call the constructor of MyAdapter to send the reference and data to Adapter
            val customAdapter = MyAdapter(this, personNames, emailIds, mobileNumber)
            recyclerVeiw.adapter = customAdapter


        }catch (e: JSONException){
            e.printStackTrace()
        }


    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object

        var json: String? = null

        val charset: Charset = Charsets.UTF_8

        try {

            val `is` = assets.open("example.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset)
        } catch (ex: IOException){
            ex.printStackTrace()
            return null
        }

        return json
    }

//    private fun loadJSONFromAsset(): String? {
//        //function to load the JSON from the Asset and return the object
//        var json: String? = null
//        val charset: Charset = Charsets.UTF_8
//        try {
//            val `is` = assets.open("example.json")
//            val size = `is`.available()
//            val buffer = ByteArray(size)
//            `is`.read(buffer)
//            `is`.close()
//            json = String(buffer, charset)
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            return null
//        }
//        return json
//    }
}
