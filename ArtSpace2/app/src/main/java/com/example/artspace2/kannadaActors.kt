package com.example.artspace2

class Actor(
    private val image: Int = 0,
    private val nameEn: String = "",
    private val nameKn: String = "",
    private val otherNames: String = "",
    private val birth: String = "",
    private val death: String = "",
    private val firstKannadaMovie: String = "",
    private val titles: String = "",
    private val readMore: String = ""
) {
    private val contributionForms: MutableList<ContributionForm> = mutableListOf()

    fun getImage(): Int { return image }
    fun getNameEn(): String { return nameEn }
    fun getNameKn(): String { return nameKn }
    fun getOtherNames(): String { return otherNames }
    fun getBirth(): String { return birth }
    fun getDeath(): String { return death }
    fun getFirstKannadaMovie(): String { return firstKannadaMovie }
    fun getTitles(): String { return titles }
    fun getReadMore(): String { return readMore }
    fun getContributionForms(): MutableList<ContributionForm> { return contributionForms }

    fun getContributionFormsAsOneString(): String {
        var contributionFormsAsOneString = ""

        for(contributionForm in contributionForms) {
            contributionFormsAsOneString += contributionForm.getNameKn() + ", "
        }
        contributionFormsAsOneString = contributionFormsAsOneString.dropLast(2)
        return contributionFormsAsOneString
    }

    fun contributionFormsUpdater(
        sangrahaList: MutableList<ContributionForm>,
        isNaayakatva: Boolean = false,
        isGaayana: Boolean = false,
        isNirmaapane: Boolean = false,
        isSahaNirmaapane: Boolean = false,
        isNirdeshana: Boolean = false,
        isSahaNirdeshana: Boolean = false,
        isSahaNatane: Boolean = false,
        isHaasyaNatane: Boolean = false,
        isKhalanaayakatva: Boolean = false,
    ) {
        for(sangraha in sangrahaList) {
            if(isNaayakatva && sangraha.getNameEn() == "naayakatva") {
                contributionForms.add(sangraha)
            }
            if(isGaayana && sangraha.getNameEn() == "gaayana") {
                contributionForms.add(sangraha)
            }
            if(isNirmaapane && sangraha.getNameEn() == "nirmaapane") {
                contributionForms.add(sangraha)
            }
            if(isSahaNirmaapane && sangraha.getNameEn() == "sahaNirmaapane") {
                contributionForms.add(sangraha)
            }
            if(isNirdeshana && sangraha.getNameEn() == "nirdeshana") {
                contributionForms.add(sangraha)
            }
            if(isSahaNirdeshana && sangraha.getNameEn() == "sahaNirdeshana") {
                contributionForms.add(sangraha)
            }
            if(isSahaNatane && sangraha.getNameEn() == "sahaNatane") {
                contributionForms.add(sangraha)
            }
            if(isHaasyaNatane && sangraha.getNameEn() == "haasyaNatane") {
                contributionForms.add(sangraha)
            }
            if(isKhalanaayakatva && sangraha.getNameEn() == "khalanaayakatva") {
                contributionForms.add(sangraha)
            }
        }
    }
}

class ContributionForm(
    private val nameEn: String = "",
    private val nameKn: String = ""
) {
    fun getNameEn(): String { return nameEn }
    fun getNameKn(): String { return nameKn }
}

class ActorCategoryID {
    var theIDs: MutableList<MutableList<Int>> = mutableListOf(mutableListOf())
}

fun main() {
    val sangrahaList = mutableListOf<ContributionForm>()
    val actorsList = mutableListOf<Actor>()
    val actorCategoryID = ActorCategoryID()

    updateKannadaActorsData(sangrahaList, actorsList, actorCategoryID)
}

fun updateKannadaActorsData(sangrahaList: MutableList<ContributionForm>, actorsList: MutableList<Actor>, actorCategoryID: ActorCategoryID) {
    updateSangrahaList(sangrahaList = sangrahaList)
    updateActorsList(actorsList = actorsList, sangrahaList = sangrahaList)
    updateActorCategoryID(actorCategoryID = actorCategoryID, sangrahaList= sangrahaList, actorsList = actorsList)
}

fun updateActorCategoryID(
    actorCategoryID: ActorCategoryID,
    sangrahaList: MutableList<ContributionForm>,
    actorsList: MutableList<Actor>
) {
    for(sangraha in sangrahaList) {
        actorCategoryID.theIDs.add(mutableListOf())
    }
    for(actor in actorsList){
        for(category in actor.getContributionForms()) {
            for(sangraha in sangrahaList) {
                if(category.getNameEn() == sangraha.getNameEn()) {
                    actorCategoryID.theIDs[sangrahaList.indexOf(sangraha)].add(actorsList.indexOf(actor))
                }
            }
        }
    }

}

fun updateSangrahaList(sangrahaList: MutableList<ContributionForm>) {
    sangrahaList.add(ContributionForm(nameEn = "naayakatva", nameKn = "ನಾಯಕತ್ವ"))
    sangrahaList.add(ContributionForm(nameEn = "gaayana", nameKn = "ಗಾಯನ"))
    sangrahaList.add(ContributionForm(nameEn = "nirmaapane", nameKn = "ನಿರ್ಮಾಪಣೆ"))
    sangrahaList.add(ContributionForm(nameEn = "sahaNirmaapane", nameKn = "ಸಹ-ನಿರ್ಮಾಪಣೆ"))
    sangrahaList.add(ContributionForm(nameEn = "nirdeshana", nameKn = "ನಿರ್ದೇಶನ"))
    sangrahaList.add(ContributionForm(nameEn = "sahaNirdeshana", nameKn = "ಸಹ-ನಿರ್ದೇಶನ"))
    sangrahaList.add(ContributionForm(nameEn = "sahaNatane", nameKn = "ಸಹ-ನಟನೆ"))
    sangrahaList.add(ContributionForm(nameEn = "haasyaNatane", nameKn = "ಹಾಸ್ಯ ನಟನೆ"))
    sangrahaList.add(ContributionForm(nameEn = "khalanaayakatva", nameKn = "ಖಳನಾಯಕತ್ವ"))
}

fun updateActorsList(actorsList: MutableList<Actor>, sangrahaList: MutableList<ContributionForm>) {
    // ----------------------------------------------
    actorsList.add(Actor(
        image = R.drawable.rajkumar,
        nameEn = "rajkumar",
        nameKn = "ರಾಜ್ ಕುಮಾರ್",
        otherNames = "ಸಿಂಗಾನಲ್ಲೂರು ಪುಟ್ಟಸ್ವಾಮಯ್ಯ ಮುತ್ತುರಾಜು",
        birth = "೨೪ ಏಪ್ರಿಲ್, ೧೯೨೯\nಗಾಜನೂರು, ಮೈಸೂರು ಸಂಸ್ಥಾನ, ಬ್ರಿಟಿಷ್ ಭಾರತ",
        death = "೧೨ ಏಪ್ರಿಲ್ ೨೦೦೬ (ವಯಸ್ಸು: ೭೬)\nಬೆಂಗಳೂರು, ಕರ್ನಾಟಕ, ಭಾರತ",
        firstKannadaMovie = "ಬೇಡರ ಕಣ್ಣಪ್ಪ",
        titles = "ನಟಸಾರ್ವಭೌಮ, ಕರ್ನಾಟಕ ರತ್ನ, ವರನಟ, ಅಣ್ಣಾವ್ರು, ಮುತ್ತುರಾಜ",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%B0%E0%B2%BE%E0%B2%9C%E0%B3%8D%E2%80%8C%E0%B2%95%E0%B3%81%E0%B2%AE%E0%B2%BE%E0%B2%B0%E0%B3%8D"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = true,
        isNirmaapane = true,
        isSahaNatane = true
    )
    // --------------------------------------------------
    actorsList.add(Actor(
        image = R.drawable.vishnuvardhan,
        nameEn = "vishnuvardhan",
        nameKn = "ವಿಷ್ಣುವರ್ಧನ್",
        otherNames = "ಸಂಪತ್ ಕುಮಾರ್",
        birth = "೧೮ ಸೆಪ್ಟೆಂಬರ್ ೧೯೫೦\nಮೈಸೂರು",
        death = "೩೦ ಡಿಸೆಂಬರ್ ೨೦೦೯ (ವಯಸ್ಸು: ೫೯)\nಮೈಸೂರು, ಭಾರತ",
        firstKannadaMovie = "ವಂಶವೃಕ್ಷ",
        titles = "ಸಾಹಸ ಸಿಂಹ, ಅಭಿನಯ ಚಕ್ರವರ್ತಿ, ನಟ ರತ್ನ",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%B5%E0%B2%BF%E0%B2%B7%E0%B3%8D%E0%B2%A3%E0%B3%81%E0%B2%B5%E0%B2%B0%E0%B3%8D%E0%B2%A7%E0%B2%A8%E0%B3%8D_(%E0%B2%A8%E0%B2%9F)"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = true,
        isNirmaapane = true,
        isSahaNatane = true,
        isSahaNirdeshana = true,
        isKhalanaayakatva = true
    )
    // -------------------------------------------
    actorsList.add(Actor(
        image = R.drawable.ravichandran,
        nameEn = "ravichandran",
        nameKn = "ರವಿಚಂದ್ರನ್",
        otherNames = "ವೀರಾಸ್ವಾಮಿ ರವಿಚಂದ್ರನ್",
        birth = "೩೦ ಮೇ ೧೯೬೧ (ವಯಸ್ಸು ೬೩)",
        death = "---",
        firstKannadaMovie = "ಖದೀಮ ಕಳ್ಳರು",
        titles = "ಕ್ರೇಜಿಸ್ಟಾರ್, ಕನಸುಗಾರ, ಚಿತ್ರಬ್ರಹ್ಮ, ತಾಂತ್ರಿಕತೆಯ ಮಾಂತ್ರಿಕ, ರವಿಮಾಮ, ಕನ್ನಡದ ಶೋಮ್ಯಾನ್",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%B0%E0%B2%B5%E0%B2%BF%E0%B2%9A%E0%B2%82%E0%B2%A6%E0%B3%8D%E0%B2%B0%E0%B2%A8%E0%B3%8D#%E0%B2%B0%E0%B2%B5%E0%B2%BF%E0%B2%9A%E0%B2%82%E0%B2%A6%E0%B3%8D%E0%B2%B0%E0%B2%A8%E0%B3%8D_%E0%B2%9A%E0%B2%BF%E0%B2%A4%E0%B3%8D%E0%B2%B0%E0%B2%97%E0%B2%B3%E0%B3%81"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = false,
        isNirmaapane = true,
        isSahaNirmaapane = false,
        isNirdeshana = true,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = false,
        isKhalanaayakatva = false
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.manjula,
        nameEn = "manjula",
        nameKn = "ಮಂಜುಳ",
        otherNames = "ಹೊನ್ನೇನಹಳ್ಳಿ ಶಿವಣ್ಣ, ಮಂಜುಳಾ",
        birth = "೮ ನವೆಂಬರ್ ೧೯೫೪\nತುಮಕೂರು, ಮೈಸೂರು ರಾಜ್ಯ, ಭಾರತ",
        death = "೧೨ ಸೆಪ್ಟೆಂಬರ್ ೧೯೮೬ (ವಯಸ್ಸು ೩೧)\nಬೆಂಗಳೂರು, ಭಾರತ",
        firstKannadaMovie = "ಮನೆಕಟ್ಟಿ ನೋಡು",
        titles = "---",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%AE%E0%B2%82%E0%B2%9C%E0%B3%81%E0%B2%B3"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = false,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = false,
        isKhalanaayakatva = false
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.kalpana,
        nameEn = "kalpana",
        nameKn = "ಕಲ್ಪನಾ",
        otherNames = "ಶರತ್ ಲತಾ",
        birth = "೧೮ ಜುಲೈ ೧೯೪೩\nದಕ್ಷಿಣ ಕನ್ನಡ, ಬ್ರಿಟಿಷ್ ಭಾರತ",
        death = "೧೨ ಮೇ ೧೯೭೯ (ವಯಸ್ಸು ೩೬)\nಗೋಟೂರು ಪ್ರವಾಸಿ ಮಂದಿರ. ಬೆಳಗಾವಿ, ಕರ್ನಾಟಕ.",
        firstKannadaMovie = "ಸಾಕು ಮಗಳು",
        titles = "ಮಿನುಗು ತಾರೆ",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%95%E0%B2%B2%E0%B3%8D%E0%B2%AA%E0%B2%A8%E0%B2%BE"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = false,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = false,
        isKhalanaayakatva = false
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.aarathi,
        nameEn = "aarathi",
        nameKn = "ಆರತಿ",
        otherNames = "ಭಾರತಿ",
        birth = "೧೯೫೪ ಮೈಸೂರು, ಮೈಸೂರು ರಾಜ್ಯ, ಬ್ರಿಟಿಷ್ ಇಂಡಿಯಾ",
        death = "---",
        firstKannadaMovie = "ಗೆಜ್ಜೆಪೂಜೆ",
        titles = "---",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%86%E0%B2%B0%E0%B2%A4%E0%B2%BF"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = true,
        isSahaNirdeshana = false,
        isSahaNatane = false,
        isHaasyaNatane = false,
        isKhalanaayakatva = false
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.vajramuni,
        nameEn = "vajramuni",
        nameKn = "ವಜ್ರಮುನಿ",
        otherNames = "ಸದಾನಂದ ಸಾಗರ್",
        birth = "೧೧ ಮೇ ೧೯೪೪\nಕನಕನಪಾಳ್ಯ, ಜಯನಗರ, ಬೆಂಗಳೂರು, ಬೆಂಗಳೂರು, ಮೈಸೂರು ಸಾಮ್ರಾಜ್ಯ",
        death = "೫ ಜನೇವರಿ ೨೦೦೬ (ವಯಸ್ಸು ೬೧)\nಬೆಂಗಳೂರು, ಭಾರತ",
        firstKannadaMovie = "ಮಲ್ಲಮ್ಮನ ಪವಾಡ",
        titles = "---",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%B5%E0%B2%9C%E0%B3%8D%E0%B2%B0%E0%B2%AE%E0%B3%81%E0%B2%A8%E0%B2%BF"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = false,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = false,
        isSahaNirdeshana = false,
        isSahaNatane = false,
        isHaasyaNatane = false,
        isKhalanaayakatva = true
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.toogudeepashreenivaasa,
        nameEn = "toogudeepaShreenivaasa",
        nameKn = "ತೂಗುದೀಪ ಶ್ರೀನಿವಾಸ",
        otherNames = "---",
        birth = "೧೯೪೩, ಬ್ರಿಟಿಷ್ ಇಂಡಿಯಾ",
        death = "೧೬ ಅಕ್ಟೋಬರ್, ೧೯೯೫ (ವಯಸ್ಸು ೫೧-೫೨)",
        firstKannadaMovie = "ತೂಗುದೀಪ",
        titles = "---",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%A4%E0%B3%82%E0%B2%97%E0%B3%81%E0%B2%A6%E0%B3%80%E0%B2%AA_%E0%B2%B6%E0%B3%8D%E0%B2%B0%E0%B3%80%E0%B2%A8%E0%B2%BF%E0%B2%B5%E0%B2%BE%E0%B2%B8"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = false,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = false,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = false,
        isKhalanaayakatva = true
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.tigerprabhaakar,
        nameEn = "tigerPrabhaakar",
        nameKn = "ಟೈಗರ್ ಪ್ರಭಾಕರ್",
        otherNames = "---",
        birth = "೩೦ ಮಾರ್ಚ್, ೧೯೪೮",
        death = "೨೫ ಮಾರ್ಚ್, ೨೦೦೧",
        firstKannadaMovie = "ಕಾಡಿನ ರಹಸ್ಯ",
        titles = "ಕನ್ನಡ ಚಿತ್ರರಂಗದ ಟೈಗರ್",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%9F%E0%B3%88%E0%B2%97%E0%B2%B0%E0%B3%8D_%E0%B2%AA%E0%B3%8D%E0%B2%B0%E0%B2%AD%E0%B2%BE%E0%B2%95%E0%B2%B0%E0%B3%8D"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = false,
        isNirmaapane = true,
        isSahaNirmaapane = false,
        isNirdeshana = true,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = false,
        isKhalanaayakatva = true
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.saadhukokila,
        nameEn = "saadhuKokila",
        nameKn = "ಸಾಧು ಕೋಕಿಲ",
        otherNames = "ಕೋಕಿಲ ಸಾಧು",
        birth = "೨೪ ಮಾರ್ಚ್ ೧೯೬೬ (ವಯಸ್ಸು ೫೮)",
        death = "---",
        firstKannadaMovie = "ಶ್!!!",
        titles = "ಸಾಧು ಮಹಾರಾಜ್",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%B8%E0%B2%BE%E0%B2%A7%E0%B3%81_%E0%B2%95%E0%B3%8B%E0%B2%95%E0%B2%BF%E0%B2%B2"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = true,
        isGaayana = true,
        isNirmaapane = true,
        isSahaNirmaapane = false,
        isNirdeshana = true,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = true,
        isKhalanaayakatva = false
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.doddanna,
        nameEn = "doddanna",
        nameKn = "ದೊಡ್ಡಣ್ಣ",
        otherNames = "---",
        birth = "೧೫ ನವೆಂಬರ್ ೧೯೪೯",
        death = "---",
        firstKannadaMovie = "ಕೂಡಿ ಬಾಳಿದರೆ ಸ್ವರ್ಗ ಸುಖ",
        titles = "---",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%A6%E0%B3%8A%E0%B2%A1%E0%B3%8D%E0%B2%A1%E0%B2%A3%E0%B3%8D%E0%B2%A3"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = false,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = false,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = true,
        isKhalanaayakatva = true
    )
    // --------------------------------------
    actorsList.add(Actor(
        image = R.drawable.umaashree,
        nameEn = "umaashree",
        nameKn = "ಉಮಾಶ್ರೀ",
        otherNames = "---",
        birth = "ಮೇ ೧೦, ೧೯೫೭\nತುಮಕೂರು ಜಿಲ್ಲೆಯ ಮುನಿಯುರು",
        death = "---",
        firstKannadaMovie = "ಅನುಭವ",
        titles = "---",
        readMore = "https://kn.wikipedia.org/wiki/%E0%B2%89%E0%B2%AE%E0%B2%BE%E0%B2%B6%E0%B3%8D%E0%B2%B0%E0%B3%80"
    ))
    actorsList[actorsList.size - 1].contributionFormsUpdater(
        sangrahaList,
        isNaayakatva = false,
        isGaayana = false,
        isNirmaapane = false,
        isSahaNirmaapane = false,
        isNirdeshana = false,
        isSahaNirdeshana = false,
        isSahaNatane = true,
        isHaasyaNatane = true,
        isKhalanaayakatva = true
    )
    // --------------------------------------
}