package com.example.artspace

import java.io.File

class King(
    private val nameEn: String = "",
    private val name: String = "",
    private val otherNames: String = "",
    private val empire: String = "",
    private val kaala: String = "",
    private val avadhi: String = "") {

    fun printStringResource() {
        println("<string name=\"$nameEn\">$name</string>")
        println("<string name=\"${nameEn + "_OtherNames"}\">($otherNames)</string>")
        println("<string name=\"${nameEn + "_Empire"}\">ಸಾಮ್ರಾಜ್ಯ: $empire</string>")
        println("<string name=\"${nameEn + "_Kaala"}\">ಕಾಲ: $kaala</string>")
        println("<string name=\"${nameEn + "_Avadhi"}\">ಅವಧಿ: $avadhi</string>")
    }

    fun singleString(): String {
        val str1 = "\t<string name=\"$nameEn\">$name</string>\n"
        val str2 = "\t<string name=\"${nameEn + "_OtherNames"}\">($otherNames)</string>\n"
        val str3 = "\t<string name=\"${nameEn + "_Empire"}\">ಸಾಮ್ರಾಜ್ಯ: $empire</string>\n"
        val str4 = "\t<string name=\"${nameEn + "_Kaala"}\">ಕಾಲ: $kaala</string>\n"
        val str5 = "\t<string name=\"${nameEn + "_Avadhi"}\">ಅವಧಿ: $avadhi</string>\n"

        val finalString = str1 + str2 + str3 + str4 + str5

        return finalString
    }

}

fun main() {
    val kings: MutableList<King> = mutableListOf()

    updateKingsList(kings = kings)

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

fun updateKingsList(kings: MutableList<King>) {
    kings.add(King(nameEn = "Simuka", name = "ಸಿಮುಕ", otherNames = "ಸಿಸುಕ", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಪೂ. ೨೩೦-೨೦೭ (ಕ್ರಿ.ಪೂ. ೨೭೧-೨೪೮)", avadhi = "೨೩ (೨೪)"))
    kings.add(King(nameEn = "Krishna", name = "ಕೃಷ್ಣ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಪೂ. ೨೦೭-೧೮೯", avadhi = "೧೮"))
    kings.add(King(nameEn = "SriMallakarni", name = "ಶ್ರೀ ಮಲ್ಲಕರ್ಣಿ", otherNames = "ಶ್ರೀ ಸಾತಕರ್ಣಿ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೦"))
    kings.add(King(nameEn = "Purnotsanga", name = "ಪೂರ್ಣೋತ್ಸಂಗ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೮"))
    kings.add(King(nameEn = "Skandhastambhi", name = "ಸ್ಕಂದಸ್ತಂಭಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೮"))
    kings.add(King(nameEn = "Saatakarni1", name = "ಸಾತಕರ್ಣಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಪೂ. ೧೯೫", avadhi = "೫೬"))
    kings.add(King(nameEn = "Lambodara", name = "ಲಂಬೋದರ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಪೂ. ೮೭-೬೭", avadhi = "೮೭-೫೬"))
    kings.add(King(nameEn = "Apilaka", name = "ಅಪಿಲಕ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೨"))
    kings.add(King(nameEn = "Meghasvati", name = "ಮೇಘಸ್ವತಿ", otherNames = "ಸೌದಸ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೮"))
    kings.add(King(nameEn = "Svati", name = "ಸ್ವಾತಿ", otherNames = "ಸ್ವಾಮಿ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೮"))
    kings.add(King(nameEn = "Skandasvati", name = "ಸ್ಕಂದಸ್ವಾತಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೭"))
    kings.add(King(nameEn = "MahendraShaatakarni", name = "ಮಹೇಂದ್ರ ಸಾತಕರ್ಣಿ", otherNames = "ಮೃಗೇಂದ್ರ ಸ್ವಾತಿಕರ್ಣ, ಸಾತಕರ್ಣಿ ೨", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೮"))
    kings.add(King(nameEn = "KuntalaShaatakarni", name = "ಕುಂತಲ ಸಾತಕರ್ಣಿ", otherNames = "ಕುಂತಲ ಸ್ವಾತಿಕರ್ಣ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೮"))
    kings.add(King(nameEn = "Svatikarna", name = "ಸ್ವಾತಿಕರ್ಣ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧"))
    kings.add(King(nameEn = "Pulomavi", name = "ಪುಲೋಮಾವಿ", otherNames = "ಪತುಮಾವಿ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೩೬"))
    kings.add(King(nameEn = "Riktavarna", name = "ರಿಕ್ತವರ್ಣ", otherNames = "ಅರಿಷ್ಟಕರ್ಮನ್", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೨೫"))
    kings.add(King(nameEn = "Haala", name = "ಹಾಲ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಶ. ೨೦-೨೪", avadhi = "೫"))
    kings.add(King(nameEn = "Mandalaka", name = "ಮಂಡಲಕ", otherNames = "ಭಾವಕ, ಪುಟ್ಟಲಕ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೫"))
    kings.add(King(nameEn = "Purindrasena", name = "ಪುರಿಂದ್ರಸೇನ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೫"))
    kings.add(King(nameEn = "SundaraShaatakarni", name = "ಸುಂದರ ಸಾತಕರ್ಣಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧"))
    kings.add(King(nameEn = "CakoraShaatakarni", name = "ಚಕೋರ ಸಾತಕರ್ಣಿ", otherNames = "ಚಕೋರ ಸ್ವಾತಿಕರ್ಣ", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೬"))
    kings.add(King(nameEn = "Shivasvati", name = "ಶಿವಸ್ವಾತಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೨೮"))
    kings.add(King(nameEn = "GautamiputraSaatakarni", name = "ಗೌತಮೀಪುತ್ರ ಸಾತಕರ್ಣಿ", otherNames = "ಗೌತಮೀಪುತ್ರ ಶಾಲಿವಾಹನ", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಶ. ೨೫-೭೮", avadhi = "೨೧"))
    kings.add(King(nameEn = "VasisthiputraSriPulamavi", name = "ವಾಸಿಷ್ಠಿಪುತ್ರ ಶ್ರೀ ಪುಲೋಮಾವಿ", otherNames = "ಪುಲೋಮ, ಪುಲಿಮನ್", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಶ. ೭೮-೧೧೪", avadhi = "೨೮"))
    kings.add(King(nameEn = "VashishtiputraSaatakarni", name = "ವಾಸಿಷ್ಠಿಪುತ್ರ ಸಾತಕರ್ಣಿ", otherNames = "ಶಿವ ಶ್ರೀ, ಶಿವಸ್ರಿ", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಶ. ೧೩೦-೧೬೦", avadhi = "೭"))
    kings.add(King(nameEn = "ShivaskandaShaatakarni", name = "ಶಿವಸ್ಕಂದ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಶ. ೧೫೨-೧೫೯", avadhi = "೭"))
    kings.add(King(nameEn = "YajnaSriShaatakarni", name = "ಯಜ್ಞ ಶ್ರೀ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "ಕ್ರಿ.ಶ. ೧೬೭-೧೯೬", avadhi = "೨೯"))
    kings.add(King(nameEn = "Vijaya", name = "ವಿಜಯ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೬"))
    kings.add(King(nameEn = "CandaSriShaatakarni", name = "ಚಂದ ಶ್ರೀ ಶಾತಕರ್ಣಿ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೧೦"))
    kings.add(King(nameEn = "Puloma", name = "ಪುಲೋಮ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "೭"))
    kings.add(King(nameEn = "MadhariputraSvamiSakasena", name = "ಮಧರಿಪುತ್ರ ಸ್ವಾಮಿ ಸಕಸೇನ", otherNames = "---", empire = "ಶಾತವಾಹನ", kaala = "---", avadhi = "---"))
}
