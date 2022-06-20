package com.naldana.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {
    /**
     * The SensorManager allow to access to all sensor on device.
     * To get a instance we need execute getSystemService in onCreate function
     * but to make more easy read code we use lazy delegation
     */
    private val sensorManager: SensorManager by lazy {
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    /**
     * All sensor are the same type, in this instance will save a light default sensor
     */
    private var lightSensor: Sensor? = null

    /**
     * Use to display values read from  lightSensor
     */
    private lateinit var displayLightSensorData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        logAllSensors()
        setUpLightSensor()
    }

    /**
     * Bind all view for this activity
     */
    private fun bind() {
        displayLightSensorData = findViewById(R.id.light_data_text)
    }

    /**
     * List on logcat all sensor of the device whit format
     *      name type vendor
     * this function its only pedagogic
     */
    private fun logAllSensors() {
        // Get list all hardware and software sensors
        val deviceSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        deviceSensors.forEach { sensor ->
            Log.d(TAG, "${sensor.name} \t ${sensor.type} \t ${sensor.vendor}")
        }
    }

    /**
     * Get the default light sensor.
     * This is the correct place to select a specific vendor light sensor instance the default
     */
    private fun setUpLightSensor() {
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        if (lightSensor == null) {
            Log.d(TAG, "The light sensor is not present")
        }
    }

    override fun onResume() {
        super.onResume()
        // When the screen is complete visibly for the user we subscribe to get data of the sensor
        // for that reason is implemented SensorEventListener
        // can be implement outside de class
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LIGHT) {
            val light = event.values[0]
            displayLightInfo(light)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    /**
     * Show in the display textView the light info
     */
    private fun displayLightInfo(light: Float) {
        displayLightSensorData.text = "Sensor: $light\n${getLightingCondition(light)}"
    }

    /**
     * Level o light in text format
     * @see <a href="https://docs.microsoft.com/en-us/windows/win32/sensorsapi/understanding-and-interpreting-lux-values">Understanding lux values</a>
     */
    private fun getLightingCondition(lux: Float) = when (lux.toInt()) {
        in 0..10 -> "Pitch Black"
        in 11..50 -> "Very Dark"
        in 51..200 -> "Dark Indoors"
        in 201..400 -> "Dim Indoors"
        in 401..1_000 -> "Normal Indoors"
        in 1_001..5_000 -> "Bright Indoors"
        in 5_001..10_000 -> "Dim Outdoors"
        in 10_001..30_000 -> "Cloudy Outdoors"
        in 30_001..100_000 -> "Direct Sunlight"
        else -> "This light will blind you"
    }



    companion object {
        private const val TAG = "MainActivity"
    }

}