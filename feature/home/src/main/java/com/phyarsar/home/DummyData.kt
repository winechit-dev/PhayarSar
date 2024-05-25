package com.phyarsar.home

import com.phyarsar.home.model.LanguageModel
import com.phyarsar.home.model.PrayerModel

val languageList = listOf(
    LanguageModel(
        languageName = "English",
        languageNotation = "(English)",
        image = R.drawable.ic_uk_flag,
        isChecked = false
    ),
    LanguageModel(
        languageName = "Myanmar",
        languageNotation = "(မြန်မာစာ)",
        image = R.drawable.ic_myanmar_flag,
        isChecked = true
    )
)

val prayerList = listOf(
    "သြကာသ ကန်တော့ချိုး",
    "စိန်ရောင်ခြည် ဘုရားပင့်",
    "နတ်ပင့်",
    "သြကာသ ကန်တော့ချိုး",
    "စိန်ရောင်ခြည် ဘုရားပင့်",
    "နတ်ပင့်"
)

val otherPrayerList = listOf(
    PrayerModel("1", "သမ္ဗုဒ္ဓေ ဂါထာတော်ကြီး"),
    PrayerModel("2", "ရှင်သီဝလိ ဂါထာတော်"),
    PrayerModel("3", "ဓမ္မစကြာ တရားတော်"),
    PrayerModel("4", "သမ္ဗုဒ္ဓေ ဂါထာတော်ကြီး"),
    PrayerModel("5", "ရှင်သီဝလိ ဂါထာတော်"),
    PrayerModel("6", "ဓမ္မစကြာ တရားတော်"),
    PrayerModel("7", "သမ္ဗုဒ္ဓေ ဂါထာတော်ကြီး"),
    PrayerModel("8", "ရှင်သီဝလိ ဂါထာတော်"),
    PrayerModel("9", "ဓမ္မစကြာ တရားတော်"),
    PrayerModel("10", "သမ္ဗုဒ္ဓေ ဂါထာတော်ကြီး")
)
