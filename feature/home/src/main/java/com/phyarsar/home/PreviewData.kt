package com.phyarsar.home

import com.phayarsar.domain.model.LanguageModel
import com.phayarsar.domain.model.PrayerModel
import com.phayarsar.localization.model.ENGLISH
import com.phayarsar.localization.model.MYANMAR

object PreviewData {

    val languageList = listOf(
        LanguageModel(
            languageName = "English",
            languageNotation = "(English)",
            image = R.drawable.ic_uk_flag,
            isChecked = false,
            locale = ENGLISH
        ),
        LanguageModel(
            languageName = "Myanmar",
            languageNotation = "(မြန်မာစာ)",
            image = R.drawable.ic_myanmar_flag,
            isChecked = true,
            locale = MYANMAR
        )
    )

    val previewPrayerList = listOf(
        PrayerModel("1", "သြကာသ ကန်တော့ချိုး"),
        PrayerModel("2", "စိန်ရောင်ခြည် ဘုရားပင့်"),
        PrayerModel("3", "နတ်ပင့်"),
        PrayerModel("4", "သြကာသ ကန်တော့ချိုး"),
        PrayerModel("5", "စိန်ရောင်ခြည် ဘုရားပင့်"),
        PrayerModel("6", "နတ်ပင့်"),
    )

    val previewOtherPrayerList = listOf(
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
}