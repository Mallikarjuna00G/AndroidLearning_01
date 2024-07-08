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
    val theList: MutableList<String> = mutableListOf<String>()
    initList(theList)
    var choice = choiceFromList(theList)

    when(choice) {
        1 -> {
            println("===================CLASSES AND OBJECTS===================")
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

            println("===================END===================")
        }
        2 -> {
            println("===================FUNCTION TYPES AND LAMBDAS==================")
            println("=====> Function in variable")
            val trickFunction = ::trick    // function reference. Do not include parentheses after 'trick' because you want to store the function in a variable, not call the function.
            // instead user the function reference operator (::)
            trickFunction()
            println("=====> Lambda Expression")
            val trick2Function = trick2    // Here we do not need funtion reference operator (::) as it is a lambda expression.
            trick2()    // Parenthese necessary
            trick2Function()
            println("=====> Function as a data type")
            val trick3Function: () -> Unit = trick3
            trick3Function()
            treat()
            println("=====> Use function as a return type")
            var trickOrTreatFunction = trickOrTreat(isTrick = true)
            trickOrTreatFunction()
            trickOrTreatFunction = trickOrTreat(isTrick = false)
            trickOrTreatFunction()
            println("=====> Pass function as an argument to other functions")
            // declare variable of type function "(Int) -> String"
            // Notice the initialization here. 'quantity' is of type Int and
            // '"$quantity quarters"' is of type String.
            val coins: (Int) -> String = {quantity -> "$quantity quarters"}
            val cupCake: (Int) -> String = {"Have a cupcake"} // Int argument is ignored as we are not using it in the string.

            val trickOrTreat2Function = trickOrTreat2(isTrick = true, extraTreat = cupCake)
            trickOrTreat2Function()
            val trickOrTreat2Function2 = trickOrTreat2(isTrick = false, extraTreat = coins)
            trickOrTreat2Function2()
            println("=====> Nullable function types")
            val trickOrTreat3Function = trickOrTreat3(isTrick = false, extraTreat = coins)
            trickOrTreat3Function()
            // Pass 'null' instead of 'coins' or 'cupCake' to trickOrTreat3Function2
            val trickOrTreat3Function2 = trickOrTreat3(isTrick = false, extraTreat = null)
            trickOrTreat3Function2()
            println("=====> SHORTHAND: Omit parameter name")
            val coins2: (Int) -> String = {"$it quarters"}    // The Int argument, if we are using, can be referenced using 'it' keyword
            val trickOrTreat2Function3 = trickOrTreat2(isTrick = false, extraTreat = coins2)
            trickOrTreat2Function3()
            println("=====> SHORTHAND: Pass lambda expression directly into function")
            val trickOrTreat2Function4 = trickOrTreat2(isTrick = false, {"$it quarters"})
            trickOrTreat2Function4()
            println("=====> SHORTHAND: Use trailing lambda syntax")
            // When a function type is the last parameter of a function you can place the lambda expression
            // after the closing parenthesis to call the function.
            val trickOrTreat2Function5 = trickOrTreat2(isTrick = false) { "$it quarters" }
            trickOrTreat2Function5()
            println("=====> repeat function")
            repeat(times = 3) {
                println("Hello")
                trickOrTreatFunction()
            }
            println("===================END===================")
        }
        3 -> {
            kotlinFundamentals_MobileNotifications()
        }
        4 -> {
            kotlinFundamentals_MovieTicketPrice()
        }
        5 -> {
            kotlinFundamentals_TemperatureConverter()
        }
        6 -> {
            kotlinFundamentals_SongCatalog()
        }
        7 -> {
            kotlinFundamentals_InternetProfile()
        }
        8 -> {
            kotlinFundamentals_FoldablePhones()
        }
        9 -> {
            kotlinFundamentals_SpecialAuction()
        }
        else -> {
            println("Invalid choice. Bye")
        }
    }



}

fun kotlinFundamentals_MobileNotifications() {
    println("====================Practice: Kotlin Fundamentals: Mobile Notifications====================")
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    println("====================END====================")
}

fun printNotificationSummary(numberOfMessages: Int) {
    if(numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

fun kotlinFundamentals_InternetProfile() {
    println("====================Practice: Kotlin Fundamentals: Internet Profile====================")

    println("====================END====================")
}

fun kotlinFundamentals_FoldablePhones() {
    println("====================Practice: Kotlin Fundamentals: Foldable Phones====================")

    println("====================END====================")
}

fun kotlinFundamentals_SpecialAuction() {
    println("====================Practice: Kotlin Fundamentals: Special Auction====================")

    println("====================END====================")
}

fun kotlinFundamentals_SongCatalog() {
    println("====================Practice: Kotlin Fundamentals: Song Catalog====================")

    println("====================END====================")
}

fun kotlinFundamentals_TemperatureConverter() {
    println("====================Practice: Kotlin Fundamentals: Temperature Converter====================")
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", {9.0/5.0 * it + 32})
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    printFinalTemperature(initialMeasurement = 10.0, initialUnit = "Fahrenheit", finalUnit = "Kelvin") { (5.0/9.0) * (it - 32) + 273.15 }
    println("====================END====================")
}

fun printFinalTemperature(initialMeasurement: Double, initialUnit: String, finalUnit: String, conversionFormula: (Double) -> Double) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))  // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

fun kotlinFundamentals_MovieTicketPrice() {
    println("====================Practice: Kotlin Fundamentals: Movie Ticket Price====================")
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
    println("====================END====================")
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    if(age <= 12) {
        return 15
    } else if(age in 13..60 && isMonday) {
        return 25
    } else if(age in 13..60) {
        return 30
    } else if(age in 61..100) {
        return 20
    } else {
        return -1
    }
}

fun trick() {
    println("trick| No treats!")
}

/** With lambda expressions, you can create variables that store functions,
 *call these variables like functions, and store them in other variables that you can call like functions.
 * This is called anonymous functions.
 */
// For demonstrating lambda expression
val trick2 = {
    println("trick2| No treats!")
}

// For demonstrating function as a data type
// Similar to how we explicitly mention the data type for a variable (ex. "val var1: Int = 10"),
// we can also explicitly mention the data type for a function, which we call it function type.
// The format of the function type will be "(input parameters types) -> (function return type)"
// trick3 lambda expression actually does not take any argument and returns nothing. Therefore,
// the function type is "() -> Unit". If it were to have two parameters (say Int and String) and a non-Unit return type,
// (say Int), then the function type would be "(Int, String) -> Int".
val trick3: () -> Unit = {
    println("trick3| No treats!")
}

val treat: () -> Unit = {
    println("treat| Have a Treat!")
}

/** Use Function as a return type
 * A function is a data type, so you can use it like any other data type.
 * We can return functions from other functions.
 *
 */

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick2
    }
    return treat
}

/** Pass Function as an argument to other functions
 * Similar to isTrick variable being a Boolean data type,
 * extraTreat is a variable of Function type (Int) -> String.
 */
fun trickOrTreat2(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick2    // Returning the type "() -> Unit".
    } else {
        println(extraTreat(5))
        return treat    // Returning the type "() -> Unit".
    }
}

/** Nullable function types
 * Similar to known nullable data types we can write the nullable function types for functions.
 * val var1: Int? = 10
 * val func1: ((Int) -> String)? = {null}
 */
fun trickOrTreat3(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick2    // Returning the type "() -> Unit".
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat    // Returning the type "() -> Unit".
    }
}

/** The repeat() function
 * When a function returns a function or takes a function as an argument, it is called as higher-order function.
 * trickOrTreat is an example of higher-order function.
 * repeat() is a higher-order function.
 * repeat function signature: repeat(times: Int, action: (Int) -> Unit): Unit
 */

fun choiceFromList(theList: MutableList<String>): Int {
    for (i in theList.indices) {
        println("${i + 1}. ${theList[i]}")
    }
    println("-------------------------------------------")
    print("Make a choice: ")
    val input = readLine()?.toInt()

    if (input != null &&  input in 1..theList.size) {
        return input
    }else {
        return 0
    }
}

fun initList(theList: MutableList<String>) {
    theList.addAll(
        listOf(
            "Learning: Classes and Objects in Kotlin",
            "Learning: Function types and Lambda expressions",
            "Practice: Kotlin Fundamentals: Mobile Notifications",
            "Practice: Kotlin Fundamentals: Movie-ticket price",
            "Practice: Kotlin Fundamentals: Temperature converter",
            "Practice: Kotlin Fundamentals: Song catalog",
            "Practice: Kotlin Fundamentals: Internet profile",
            "Practice: Kotlin Fundamentals: Foldable phones",
            "Practice: Kotlin Fundamentals: Special auction"
        )
    )
}