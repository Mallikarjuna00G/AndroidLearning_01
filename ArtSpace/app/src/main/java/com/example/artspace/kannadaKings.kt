package com.example.artspace

import java.io.File

class King(
    private val nameEn: String = "",
    private val name: String = "",
    private val otherNames: String = "",
    private val empire: Empire = Empire("", ""),
    private val kaala: String = "",
    private val avadhi: String = "",
    private val readMoreLinks: Array<String> = arrayOf()) {

    fun getNameEn(): String { return nameEn }
    fun getName(): String { return name }
    fun getOtherNames(): String { return otherNames }
    fun getEmpireEn(): String { return empire.getNameEn() }
    fun getEmpire(): String { return empire.getName() }
    fun getKaala(): String { return kaala }
    fun getAvadhi(): String { return avadhi }

    fun printStringResource() {
        println("<string name=\"$nameEn\">$name</string>")
        println("<string name=\"${nameEn + "_OtherNames"}\">($otherNames)</string>")
        println("<string name=\"${nameEn + "_Empire"}\">ಸಾಮ್ರಾಜ್ಯ: ${getEmpire()}</string>")
        println("<string name=\"${nameEn + "_Kaala"}\">ಕಾಲ: $kaala</string>")
        println("<string name=\"${nameEn + "_Avadhi"}\">ಅವಧಿ: $avadhi</string>")
    }

    fun singleString(): String {
        val str1 = "\t<string name=\"$nameEn\">$name</string>\n"
        val str2 = "\t<string name=\"${nameEn + "_OtherNames"}\">($otherNames)</string>\n"
        val str3 = "\t<string name=\"${nameEn + "_Empire"}\">ಸಾಮ್ರಾಜ್ಯ: ${getEmpire()}</string>\n"
        val str4 = "\t<string name=\"${nameEn + "_Kaala"}\">ಕಾಲ: $kaala</string>\n"
        val str5 = "\t<string name=\"${nameEn + "_Avadhi"}\">ಅವಧಿ: $avadhi</string>\n"

        val finalString = str1 + str2 + str3 + str4 + str5

        return finalString
    }

}

class Empire(
    private val nameEn: String = "",
    private val name: String = "", ) {

    fun getNameEn(): String {
        return nameEn
    }

    fun getName(): String {
        return name
    }
}

fun main() {
    val kings: MutableList<King> = mutableListOf()
    val empire: MutableList<Empire> = mutableListOf()

    updateKingsList(kings = kings)
    updateEmpireList(empire = empire)

//    for (king in kings) {
//        king.printStringResource()
//    }

    val fileName = "KannadaKings.xml"
    val folder = "./"
    val file = File(folder, fileName)

    file.writeText("<data>\n")

    for (king in kings) {
        file.appendText(king.singleString())
    }
    file.appendText("</data>")

}

fun updateEmpireList(empire: MutableList<Empire>) {
    empire.add(Empire(nameEn = "Shaatavaahana", name = "ಶಾತವಾಹನ"))
}

fun updateKingsList(kings: MutableList<King>) {
    /* Empire: Shaatavaahana */
    kings.add(King(nameEn = "Simuka", name = "ಸಿಮುಕ", otherNames = "ಸಿಸುಕ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಪೂ. ೨೩೦-೨೦೭ (ಕ್ರಿ.ಪೂ. ೨೭೧-೨೪೮)", avadhi = "೨೩ (೨೪)", readMoreLinks = arrayOf("https://en.wikipedia.org/wiki/Simuka")))
    kings.add(King(nameEn = "Krishna", name = "ಕೃಷ್ಣ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಪೂ. ೨೦೭-೧೮೯", avadhi = "೧೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "SriMallakarni", name = "ಶ್ರೀ ಮಲ್ಲಕರ್ಣಿ", otherNames = "ಶ್ರೀ ಶಾತಕರ್ಣಿ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೦", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Purnotsanga", name = "ಪೂರ್ಣೋತ್ಸಂಗ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Skandhastambhi", name = "ಸ್ಕಂದಸ್ತಂಭಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Saatakarni1", name = "ಶಾತಕರ್ಣಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಪೂ. ೧೯೫", avadhi = "೫೬", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Lambodara", name = "ಲಂಬೋದರ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಪೂ. ೮೭-೬೭", avadhi = "೮೭-೫೬", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Apilaka", name = "ಅಪಿಲಕ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೨", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Meghasvati", name = "ಮೇಘಸ್ವತಿ", otherNames = "ಸೌದಸ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Svati", name = "ಸ್ವಾತಿ", otherNames = "ಸ್ವಾಮಿ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Skandasvati", name = "ಸ್ಕಂದಸ್ವಾತಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೭", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "MahendraShaatakarni", name = "ಮಹೇಂದ್ರ ಶಾತಕರ್ಣಿ", otherNames = "ಮೃಗೇಂದ್ರ ಸ್ವಾತಿಕರ್ಣ, ಶಾತಕರ್ಣಿ ೨", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "KuntalaShaatakarni", name = "ಕುಂತಲ ಶಾತಕರ್ಣಿ", otherNames = "ಕುಂತಲ ಸ್ವಾತಿಕರ್ಣ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Svatikarna", name = "ಸ್ವಾತಿಕರ್ಣ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Pulomavi", name = "ಪುಲೋಮಾವಿ", otherNames = "ಪತುಮಾವಿ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೩೬", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Riktavarna", name = "ರಿಕ್ತವರ್ಣ", otherNames = "ಅರಿಷ್ಟಕರ್ಮನ್", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೨೫", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Haala", name = "ಹಾಲ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಶ. ೨೦-೨೪", avadhi = "೫", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Mandalaka", name = "ಮಂಡಲಕ", otherNames = "ಭಾವಕ, ಪುಟ್ಟಲಕ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೫", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Purindrasena", name = "ಪುರಿಂದ್ರಸೇನ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೫", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "SundaraShaatakarni", name = "ಸುಂದರ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "CakoraShaatakarni", name = "ಚಕೋರ ಶಾತಕರ್ಣಿ", otherNames = "ಚಕೋರ ಸ್ವಾತಿಕರ್ಣ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೬", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Shivasvati", name = "ಶಿವಸ್ವಾತಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೨೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "GautamiputraSaatakarni", name = "ಗೌತಮೀಪುತ್ರ ಶಾತಕರ್ಣಿ", otherNames = "ಗೌತಮೀಪುತ್ರ ಶಾಲಿವಾಹನ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಶ. ೨೫-೭೮", avadhi = "೨೧", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "VasisthiputraSriPulamavi", name = "ವಾಸಿಷ್ಠಿಪುತ್ರ ಶ್ರೀ ಪುಲೋಮಾವಿ", otherNames = "ಪುಲೋಮ, ಪುಲಿಮನ್", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಶ. ೭೮-೧೧೪", avadhi = "೨೮", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "VashishtiputraSaatakarni", name = "ವಾಸಿಷ್ಠಿಪುತ್ರ ಶಾತಕರ್ಣಿ", otherNames = "ಶಿವ ಶ್ರೀ, ಶಿವಸ್ರಿ", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಶ. ೧೩೦-೧೬೦", avadhi = "೭", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "ShivaskandaShaatakarni", name = "ಶಿವಸ್ಕಂದ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಶ. ೧೫೨-೧೫೯", avadhi = "೭", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "YajnaSriShaatakarni", name = "ಯಜ್ಞ ಶ್ರೀ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "ಕ್ರಿ.ಶ. ೧೬೭-೧೯೬", avadhi = "೨೯", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Vijaya", name = "ವಿಜಯ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೬", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "CandaSriShaatakarni", name = "ಚಂದ ಶ್ರೀ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೧೦", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "Puloma", name = "ಪುಲೋಮ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "೭", readMoreLinks = arrayOf("")))
    kings.add(King(nameEn = "MadhariputraSvamiSakasena", name = "ಮಧರಿಪುತ್ರ ಸ್ವಾಮಿ ಸಕಸೇನ", otherNames = "---", empire = Empire(name = "ಶಾತವಾಹನ", nameEn = "Shaatavaahana"), kaala = "---", avadhi = "---", readMoreLinks = arrayOf("")))

    /* */

}
