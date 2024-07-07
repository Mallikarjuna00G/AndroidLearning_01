package com.example.kotlinlearning_01

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// primary constructor
open class SmartDevice(val name: String, val category: String) {
    // properties
    var deviceStatus = "off"
        protected set
    open val deviceType = "unknown"

//    // Secondary Constructors
//    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
//        println("Secondary constructor is called")
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }

    // methods
    open fun turnOn() {
        deviceStatus = "on"
    }
    open fun turnOff() {
        deviceStatus = "off"
    }
    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType, status: $deviceStatus")
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
): ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

class SmartTvDevice (deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    // properties
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    override val deviceType = "Smart TV"

    // methods
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }
    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }
    override fun turnOn() {
        super.turnOn()
        println("$name turned on. Speaker volume is $speakerVolume and channel number is $channelNumber.")
    }
    override fun turnOff() {
        super.turnOff()
        println("$name turned off.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : SmartDevice(name = deviceName, category = deviceCategory) {
    // properties
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    override val deviceType = "Smart Light"

    // methods
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel")
    }
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off.")
    }
}

class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {
    // Properties
    var deviceTurnOnCount = 0
        private set

    // Methods
    fun turnOnTv() {
        if(smartTvDevice.deviceStatus == "off") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
        else {
            println("TV is already on")
        }
    }
    fun turnOffTv() {
        if(smartTvDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
        else {
            println("TV is already off")
        }
    }
    fun increaseTvVolume() {
        if(smartTvDevice.deviceStatus == "on") {
            smartTvDevice.increaseSpeakerVolume()
        }
        else {
            println("TV is off")
        }
    }
    fun decreaseTvVolume() {
        if(smartTvDevice.deviceStatus == "on") {
            smartTvDevice.decreaseSpeakerVolume()
        }
        else {
            println("TV is off")
        }
    }
    fun changeTvChannelToNext() {
        if(smartTvDevice.deviceStatus == "on") {
            smartTvDevice.nextChannel()
        }
        else {
            println("TV is off")
        }
    }
    fun changeTvChannelToPrevious() {
        if(smartTvDevice.deviceStatus == "on") {
            smartTvDevice.previousChannel()
        }
        else {
            println("TV is off")
        }
    }
    fun turnOnLight() {
        if(smartLightDevice.deviceStatus == "off") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
        else {
            println("Light is already on")
        }
    }
    fun turnOffLight() {
        if(smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
        else {
            println("Light is already off")
        }
    }
    fun increaseLightBrightness() {
        if(smartLightDevice.deviceStatus == "on") {
            smartLightDevice.increaseBrightness()
        }
        else {
            println("Light is off")
        }
    }
    fun decreaseLightBrightness() {
        if(smartLightDevice.deviceStatus == "on") {
            smartLightDevice.decreaseBrightness()
        }
        else {
            println("Light is off")
        }
    }
    fun turnOffAllDevices() {
        println("Turning off all devices...")
        turnOffTv()
        turnOffLight()
    }
    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }
    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }
}

fun main() {
    val hr_line = "******************************"
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()

    var smartHome = SmartHome(smartTvDevice = SmartTvDevice("Android TV", "Entertainment"), smartLightDevice = SmartLightDevice("Google Light", "Utility"))

    println(hr_line)
    smartHome.turnOffAllDevices()
    println(hr_line)
    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println(hr_line)
    smartHome.turnOnTv()
    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    println(hr_line)
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToPrevious()
    smartHome.turnOnTv()
    smartHome.turnOffTv()
    smartHome.changeTvChannelToPrevious()
    println(hr_line)

    smartHome.turnOnLight()
    smartHome.increaseLightBrightness()
    println(hr_line)
    smartHome.decreaseLightBrightness()
    smartHome.turnOnLight()
    smartHome.turnOffLight()
    smartHome.increaseLightBrightness()

    println(hr_line)
    smartHome.turnOffAllDevices()
}