package com.phayarsar.localization

import java.util.Locale

val MYANMAR = Locale("mm")
val ENGLISH = Locale("en")

val supportedLocalesNow = registerSupportedLocales(MYANMAR, ENGLISH)

// 1nd parameter: string value for default localization
// 2rd parameter: dictionary of locale to string resource
// welcome_to_phayarsar is ext function that finds string in Localization receiver and returns it
val welcome_to_phayarsar = Translatable(
    "Welcome to \nPhayarSar",
    hashMapOf(
        ENGLISH to "Welcome to \nPhayarSar",
        MYANMAR to "ဘုရားစာ App ကနေ\nကြိုဆိုပါတယ်"
    )
)

val onboarding_desc = Translatable(
    "Religion and Generation Z can seamlessly coexist. With the PhayarSar app, you can ergonomically religious.",
    hashMapOf(
        ENGLISH to "Religion and Generation Z can seamlessly coexist. With the PhayarSar app, you can ergonomically religious.",
        MYANMAR to "ဘာသာတရားနဲ့လူငယ် အတူယှဥ်တွဲနေထိုင်လို့ရပါတယ်။ ဘုရားစာ app ကိုသုံးပြီးတော့ ဘာသာတရားကိုင်းရှိုင်းလိုက်ပါ။"
    )
)
val btn_get_started = Translatable(
    "Get started",
    hashMapOf(
        ENGLISH to "Get started",
        MYANMAR to "စသုံးမယ်"
    )
)

val choose_a_language = Translatable(
    "Select a Language",
    hashMapOf(
        ENGLISH to "Select a Language",
        MYANMAR to "ဘာသာစကား ရွေးချယ်ပါ"
    )
)

val next = Translatable(
    "Next",
    hashMapOf(
        ENGLISH to "Next",
        MYANMAR to "ဆက်သွားပါ"
    )
)

val finished = Translatable(
    "Finished!",
    hashMapOf(
        ENGLISH to "Finished!",
        MYANMAR to "စိတ်တိုင်းကျပြီ"
    )
)

val today_pray_time_x = Translatable(
    "Today's Pray Time  {$} min(s)",
    hashMapOf(
        ENGLISH to "Today's Pray Time  {$} min(s)",
        MYANMAR to "ဒီနေ့ဘုရားရှိခိုးချိန်  {$} မိနစ်"
    )
)

val today_pray_time = Translatable(
    "Today's Pray Time  ",
    hashMapOf(
        ENGLISH to "Today's Pray Time  ",
        MYANMAR to "ဒီနေ့ဘုရားရှိခိုးချိန်  "
    )
)

val x_min = Translatable(
    "{$} min",
    hashMapOf(
        ENGLISH to "{$} min",
        MYANMAR to "{$} မိနစ်"
    )
)

val x_sec = Translatable(
    "{$} sec",
    hashMapOf(
        ENGLISH to "{$} sec",
        MYANMAR to "{$} စက္ကန့်"
    )
)

val x_hour_y_min = Translatable(
    "{$} hr {$} min",
    hashMapOf(
        ENGLISH to "{$} hr {$} min",
        MYANMAR to "{$} နာရီ {$} မိနစ်"
    )
)

val btn_add = Translatable(
    "Add",
    hashMapOf(
        ENGLISH to "Add",
        MYANMAR to "ထည့်မယ်"
    )
)

val btn_pray = Translatable(
    "Pray",
    hashMapOf(
        ENGLISH to "Pray",
        MYANMAR to "ရှိခိုးမယ်"
    )
)
val home = Translatable(
    "Home",
    hashMapOf(
        ENGLISH to "Home",
        MYANMAR to "ပင်မစာမျက်နှာ"
    )
)

val settings = Translatable(
    "Settings",
    hashMapOf(
        ENGLISH to "Settings",
        MYANMAR to "ပြင်ဆင်ချက်"
    )
)

val app_language = Translatable(
    "App language",
    hashMapOf(
        ENGLISH to "App language",
        MYANMAR to "ဘာသာစကား"
    )
)

val app_accent_color = Translatable(
    "App accent color",
    hashMapOf(
        ENGLISH to "App accent color",
        MYANMAR to "အဓိက အရောင်"
    )
)

val choose_accent_color = Translatable(
    "Choose accent color",
    hashMapOf(
        ENGLISH to "Choose accent color",
        MYANMAR to "အဓိကအရောင် ရွေးပါ"
    )
)
val haptic_on = Translatable(
    "Haptic on",
    hashMapOf(
        ENGLISH to "Haptic on",
        MYANMAR to "တုန်ခါမှု ဖွင့်မယ်"
    )
)

val themes_and_settings = Translatable(
    "Themes & Settings",
    hashMapOf(
        ENGLISH to "Themes & Settings",
        MYANMAR to "ပုံပန်းအသွင်အပြင်"
    )
)

val about_x = Translatable(
    "About {$}",
    hashMapOf(
        ENGLISH to "About {$}",
        MYANMAR to "{$} အကြောင်း"
    )
)

val jasmine = Translatable(
    "Jasmine",
    hashMapOf(
        ENGLISH to "Jasmine",
        MYANMAR to "စံပယ်"
    )
)

val panglong = Translatable(
    "PangLong",
    hashMapOf(
        ENGLISH to "PangLong",
        MYANMAR to "ပန်းလောင်"
    )
)
val msquare = Translatable(
    "Square",
    hashMapOf(
        ENGLISH to "Square",
        MYANMAR to "လေးထောင့်"
    )
)

val yoeyar = Translatable(
    "YoeYar",
    hashMapOf(
        ENGLISH to "YoeYar",
        MYANMAR to "ရိုးရာ"
    )
)

val page_white = Translatable(
    "White",
    hashMapOf(
        ENGLISH to "White",
        MYANMAR to "အဖြူရောင်"
    )
)

val page_yellow = Translatable(
    "Yellow",
    hashMapOf(
        ENGLISH to "Yellow",
        MYANMAR to "အဝါရောင်"
    )
)

val page_grey = Translatable(
    "Grey",
    hashMapOf(
        ENGLISH to "Grey",
        MYANMAR to "မီးခိုးရောင်"
    )
)
val page_black = Translatable(
    "Black",
    hashMapOf(
        ENGLISH to "Black",
        MYANMAR to "အမဲ(နက်)ရောင်"
    )
)

val font = Translatable(
    "Font",
    hashMapOf(
        ENGLISH to "Font",
        MYANMAR to "ဖောင့်"
    )
)

val background_and_color = Translatable(
    "Background & Color",
    hashMapOf(
        ENGLISH to "Background & Color",
        MYANMAR to "နောက်ခံနှင့် စာသားအရောင်"
    )
)

val letter_and_line_spacing = Translatable(
    "Letter & Line Spacing",
    hashMapOf(
        ENGLISH to "Letter & Line Spacing",
        MYANMAR to "စာလုံးနှင့်စာကြောင်း အကွာအဝေး"
    )
)

val letter_spacing = Translatable(
    "Letter spacing",
    hashMapOf(
        ENGLISH to "Letter spacing",
        MYANMAR to "စာလုံး အကွာအဝေး"
    )
)
val line_spacing = Translatable(
    "Line spacing",
    hashMapOf(
        ENGLISH to "Line spacing",
        MYANMAR to "စာကြောင်း အကွာအဝေး"
    )
)

val paragraph_spacing = Translatable(
    "Paragraph spacing",
    hashMapOf(
        ENGLISH to "Paragraph spacing",
        MYANMAR to "စာပိုဒ် အကွာအဝေး"
    )
)

val text_size_and_alignment = Translatable(
    "Text Size & Alignment",
    hashMapOf(
        ENGLISH to "Text Size & Alignment",
        MYANMAR to "အရွယ်အစားနှင့် အလိုင်းမန့်"
    )
)

val align_left = Translatable(
    "Align left",
    hashMapOf(
        ENGLISH to "Align left",
        MYANMAR to "ဘယ်ကပ်"
    )
)

val align_right = Translatable(
    "Align right",
    hashMapOf(
        ENGLISH to "Align right",
        MYANMAR to "ညာကပ်"
    )
)
val align_center = Translatable(
    "Align center",
    hashMapOf(
        ENGLISH to "Align center",
        MYANMAR to "အလယ်"
    )
)

val justify = Translatable(
    "Justify",
    hashMapOf(
        ENGLISH to "Justify",
        MYANMAR to "အပြည့်နေရာယူ"
    )
)

val show_pronunciation = Translatable(
    "Show Pronunciation",
    hashMapOf(
        ENGLISH to "Show Pronunciation",
        MYANMAR to "အသံထွက် ပြမယ်"
    )
)

val scrolling_speed = Translatable(
    "Scrolling Speed",
    hashMapOf(
        ENGLISH to "Scrolling Speed",
        MYANMAR to "အမြန်နှုန်း"
    )
)

val spotlight_text = Translatable(
    "Spotlight text (blur others)",
    hashMapOf(
        ENGLISH to "Spotlight text (blur others)",
        MYANMAR to "လက်ရှိစာပိုဒ်ကို ဦးစားပေးပြမယ်"
    )
)
val tap_to_scroll = Translatable(
    "Tap to scroll to that paragraph",
    hashMapOf(
        ENGLISH to "Tap to scroll to that paragraph",
        MYANMAR to "စာပိုဒ်ကိုနှိပ်လိုက်တာနဲ့ ရောက်အောင်သွားမယ်"
    )
)

val x0_5 = Translatable(
    "0.5x",
    hashMapOf(
        ENGLISH to "0.5x",
        MYANMAR to "၀.၅ ဆ"
    )
)

val x0_75 = Translatable(
    "0.75x",
    hashMapOf(
        ENGLISH to "0.75x",
        MYANMAR to "၀.၇၅ ဆ"
    )
)

val x1 = Translatable(
    "Normal",
    hashMapOf(
        ENGLISH to "Normal",
        MYANMAR to "ပုံမှန်"
    )
)

val x1_25 = Translatable(
    "1.25x",
    hashMapOf(
        ENGLISH to "1.25x",
        MYANMAR to "၁.၂၅ ဆ"
    )
)
val x1_5 = Translatable(
    "1.5x",
    hashMapOf(
        ENGLISH to "1.5x",
        MYANMAR to "၁.၅ ဆ"
    )
)

val x2 = Translatable(
    "2x",
    hashMapOf(
        ENGLISH to "2x",
        MYANMAR to "၂ ဆ"
    )
)

val mode = Translatable(
    "Choose Mode",
    hashMapOf(
        ENGLISH to "Choose Mode",
        MYANMAR to "အသုံးပြု ပုံစံ"
    )
)

val reader_mode = Translatable(
    "Reader mode",
    hashMapOf(
        ENGLISH to "Reader mode",
        MYANMAR to "ကိုယ်တိုင် ဖတ်မယ်"
    )
)

val player_mode = Translatable(
    "Player mode",
    hashMapOf(
        ENGLISH to "Player mode",
        MYANMAR to "အလိုအလျောက်"
    )
)
val selected = Translatable(
    "Selected",
    hashMapOf(
        ENGLISH to "Selected",
        MYANMAR to "ရွေးထားသည်"
    )
)

val add_new = Translatable(
    "Add new",
    hashMapOf(
        ENGLISH to "Add new",
        MYANMAR to "အသစ်ထည့်"
    )
)

val worship_plan_helps_you_pray = Translatable(
    "Worship plan helps you pray uninterruptedly.",
    hashMapOf(
        ENGLISH to "Worship plan helps you pray uninterruptedly.",
        MYANMAR to "ဘုရားရှိခိုးအဓိဌာန်သည် အနှောင့်အယှက်ကင်းစွာ ဝတ်ပြုနိုင်စေသည်။"
    )
)

val view_collection = Translatable(
    "View collection",
    hashMapOf(
        ENGLISH to "View collection",
        MYANMAR to "အကုန်ကြည့်မယ်"
    )
)

val plus_x_more = Translatable(
    "+{$} more",
    hashMapOf(
        ENGLISH to "+{$} more",
        MYANMAR to "+{$} ခုကျန်"
    )
)

val other_prayers = Translatable(
    "Others",
    hashMapOf(
        ENGLISH to "Others",
        MYANMAR to "အခြားဂါထာများ"
    )
)

val new_plan = Translatable(
    "New Plan",
    hashMapOf(
        ENGLISH to "New Plan",
        MYANMAR to "အဓိဌာန် အသစ်"
    )
)

val name_your_worship_plan = Translatable(
    "Name your worship plan",
    hashMapOf(
        ENGLISH to "Name your worship plan",
        MYANMAR to "အဓိဌာန်အတွက် နာမည်ပေးပါ"
    )
)

val plan_name = Translatable(
    "Plan name",
    hashMapOf(
        ENGLISH to "Plan name",
        MYANMAR to "အဓိဌာန်နာမည်"
    )
)

val add_new_prayer = Translatable(
    "Add new prayer",
    hashMapOf(
        ENGLISH to "Add new prayer",
        MYANMAR to "ဘုရားစာအသစ် ထည့်မယ်"
    )
)

val btn_close = Translatable(
    "Close",
    hashMapOf(
        ENGLISH to "Close",
        MYANMAR to "ပိတ်မယ်"
    )
)

val btn_save = Translatable(
    "Save",
    hashMapOf(
        ENGLISH to "Save",
        MYANMAR to "သိမ်းမယ်"
    )
)

val select_prayers = Translatable(
    "Select prayers",
    hashMapOf(
        ENGLISH to "Select prayers",
        MYANMAR to "ဘုရားစာ ရွေးမယ်"
    )
)

val everyday = Translatable(
    "Everyday",
    hashMapOf(
        ENGLISH to "Everyday",
        MYANMAR to "နေ့တိုင်း"
    )
)

val sun = Translatable(
    "Sunday",
    hashMapOf(
        ENGLISH to "Sunday",
        MYANMAR to "တနင်္ဂနွေ"
    )
)

val mon = Translatable(
    "Monday",
    hashMapOf(
        ENGLISH to "Monday",
        MYANMAR to "တနင်္လာ"
    )
)

val tue = Translatable(
    "Tuesday",
    hashMapOf(
        ENGLISH to "Tuesday",
        MYANMAR to "အင်္ဂါ"
    )
)

val wed = Translatable(
    "Wednesday",
    hashMapOf(
        ENGLISH to "Wednesday",
        MYANMAR to "ဗုဒ္ဓဟူး"
    )
)

val thu = Translatable(
    "Thursday",
    hashMapOf(
        ENGLISH to "Thursday",
        MYANMAR to "ကြာသာပတေး"
    )
)

val fri = Translatable(
    "Friday",
    hashMapOf(
        ENGLISH to "Friday",
        MYANMAR to "သောကြာ"
    )
)
val sat = Translatable(
    "Saturday",
    hashMapOf(
        ENGLISH to "Saturday",
        MYANMAR to "စနေ"
    )
)

val selectDay = Translatable(
    "1. Select days of week",
    hashMapOf(
        ENGLISH to "1. Select days of week",
        MYANMAR to "၁။ ရက်ရွေးပါ"
    )
)

val selectTime = Translatable(
    "2. Choose time",
    hashMapOf(
        ENGLISH to "2. Choose time",
        MYANMAR to "၂။ အချိန်ရွေးပါ"
    )
)

val selectTagColor = Translatable(
    "3. Choose tag color",
    hashMapOf(
        ENGLISH to "3. Choose tag color",
        MYANMAR to "၃။ အဓိကအရောင် ရွေးပါ"
    )
)

val setReminder = Translatable(
    "3. Set reminder",
    hashMapOf(
        ENGLISH to "3. Set reminder",
        MYANMAR to "၃။ သံပါတ်ပေးထားမယ်"
    )
)
val do_you_have_praying_time = Translatable(
    "Do you have praying time?",
    hashMapOf(
        ENGLISH to "Do you have praying time?",
        MYANMAR to "သင့်မှာ ဘုရားရှိခိုးချိန်ရှိသလား?"
    )
)

val yes_i_do = Translatable(
    "Yes, I do",
    hashMapOf(
        ENGLISH to "Yes, I do",
        MYANMAR to "ရှိပါတယ်"
    )
)

val no_i_dont = Translatable(
    "No, I don't",
    hashMapOf(
        ENGLISH to "No, I don't",
        MYANMAR to "မရှိပါ"
    )
)

val time = Translatable(
    "Time",
    hashMapOf(
        ENGLISH to "Time",
        MYANMAR to "အချိန်"
    )
)

val remind = Translatable(
    "Remind",
    hashMapOf(
        ENGLISH to "Remind",
        MYANMAR to ""
    )
)

val before = Translatable(
    "before.",
    hashMapOf(
        ENGLISH to "before.",
        MYANMAR to "ကြိုသတိပေးပါ။"
    )
)

val x_min_s = Translatable(
    "{$} min(s)",
    hashMapOf(
        ENGLISH to "{$} min(s)",
        MYANMAR to "{$} မိနစ်"
    )
)

val su = Translatable(
    "SU",
    hashMapOf(
        ENGLISH to "SU",
        MYANMAR to "နွေ"
    )
)

val mo = Translatable(
    "MO",
    hashMapOf(
        ENGLISH to "MO",
        MYANMAR to "လာ"
    )
)

val tu = Translatable(
    "TU",
    hashMapOf(
        ENGLISH to "TU",
        MYANMAR to "ဂါ"
    )
)

val we = Translatable(
    "WE",
    hashMapOf(
        ENGLISH to "WE",
        MYANMAR to "ဟူး"
    )
)

val th = Translatable(
    "TH",
    hashMapOf(
        ENGLISH to "TH",
        MYANMAR to "ကြာ"
    )
)

val fr = Translatable(
    "FR",
    hashMapOf(
        ENGLISH to "FR",
        MYANMAR to "သော"
    )
)

val sa = Translatable(
    "SA",
    hashMapOf(
        ENGLISH to "SA",
        MYANMAR to "နေ"
    )
)

val worship_plan = Translatable(
    "Worship plans",
    hashMapOf(
        ENGLISH to "Worship plans",
        MYANMAR to "အဓိဌာန်များ"
    )
)
val view_more = Translatable(
    "See all",
    hashMapOf(
        ENGLISH to "See all",
        MYANMAR to "အကုန်ကြည့်မယ်"
    )
)

val notify_x_mins_before = Translatable(
    "Notify {$} min(s) before",
    hashMapOf(
        ENGLISH to "Notify {$} min(s) before",
        MYANMAR to "{$} မိနစ်ကြိုသတိပေး"
    )
)

val x_prayers = Translatable(
    "{$} Prayers",
    hashMapOf(
        ENGLISH to "{$} Prayers",
        MYANMAR to "{$} ပုဒ်"
    )
)

val not_specified = Translatable(
    "Not specified",
    hashMapOf(
        ENGLISH to "Not specified",
        MYANMAR to "မသတ်မှတ််ထားပါ"
    )
)

val new_worship_plan = Translatable(
    "New worship plan",
    hashMapOf(
        ENGLISH to "New worship plan",
        MYANMAR to "ဘုရားရှိခိုး အဓိဌာန်အသစ်"
    )
)
val all_worship_plans = Translatable(
    "All worship plans",
    hashMapOf(
        ENGLISH to "All worship plans",
        MYANMAR to "ဘုရားရှိခိုး အဓိဌာန်များ"
    )
)

val edit_plan = Translatable(
    "Edit Plan",
    hashMapOf(
        ENGLISH to "Edit Plan",
        MYANMAR to "ပြင်ဆင်မည်"
    )
)

val plan_detail = Translatable(
    "Plan Detail",
    hashMapOf(
        ENGLISH to "Plan Detail",
        MYANMAR to "အဓိဌာန် အသေးစိတ်"
    )
)

val prayers_x = Translatable(
    "Prayers ({$})",
    hashMapOf(
        ENGLISH to "Prayers ({$})",
        MYANMAR to "ဘုရားစာများ ({$} ပုဒ်)"
    )
)

val selected_days = Translatable(
    "Selected days",
    hashMapOf(
        ENGLISH to "Selected days",
        MYANMAR to "ရွေးချယ်ထားသော နေ့များ"
    )
)
val remind_me_before = Translatable(
    "Remind me before",
    hashMapOf(
        ENGLISH to "Remind me before",
        MYANMAR to "ကြိုတင် သတိပေးချိန်"
    )
)

val edit = Translatable(
    "Edit",
    hashMapOf(
        ENGLISH to "Edit",
        MYANMAR to "ပြင်ဆင်မည်"
    )
)

val delete = Translatable(
    "Delete",
    hashMapOf(
        ENGLISH to "Delete",
        MYANMAR to "ဖျက်မည်"
    )
)

val plan_deleted_successfully = Translatable(
    "Plan deleted successfully!",
    hashMapOf(
        ENGLISH to "Plan deleted successfully!",
        MYANMAR to "ဖျက်ပြီးပါပြီ။"
    )
)

val x_of_y = Translatable(
    "{$} of {$}",
    hashMapOf(
        ENGLISH to "{$} of {$}",
        MYANMAR to "{$} / {$}"
    )
)

val reset_prayers_theme = Translatable(
    "Reset prayers theme data",
    hashMapOf(
        ENGLISH to "Reset prayers theme data",
        MYANMAR to "ဘုရားစာပုံပန်းသွင်ပြင်များကို မူလပုံစံပြန်ထားမယ်"
    )
)

val reset_prayers_theme_desc = Translatable(
    "This action will rest all prayers' themes, settings and configurations.",
    hashMapOf(
        ENGLISH to "This action will rest all prayers' themes, settings and configurations.",
        MYANMAR to "ယခုလုပ်ဆောင်ချက်သည် ဘုရားစာအားလုံး၏ အသွင်အပြင်များနှင့် ဆက်တင်များအားလုံးကို မူလပုံစံအတိုင်းပြန်လည်သတ်မှတ်မည်ဖြစ်ပါသည်။"
    )
)

val prayers_theme_data_reset_successfully = Translatable(
    "Prayers theme data reset successfully.",
    hashMapOf(
        ENGLISH to "Prayers theme data reset successfully.",
        MYANMAR to "ပြန်လည်သတ်မှတ်မှု အောင်မြင်ပါသည်။"
    )
)

val delete_confirmation = Translatable(
    "Are you sure you want to delete this plan?",
    hashMapOf(
        ENGLISH to "Are you sure you want to delete this plan?",
        MYANMAR to "အဓိဌာန်ကိုဖျက်မှာ သေချာပြီလား?"
    )
)

val cancel = Translatable(
    "Cancel",
    hashMapOf(
        ENGLISH to "Cancel",
        MYANMAR to "မလုပ်တော့ပါ"
    )
)

val disable_worship_reminders = Translatable(
    "Turn off all worship plan reminders",
    hashMapOf(
        ENGLISH to "Turn off all worship plan reminders",
        MYANMAR to "အဓိဌာန် သတိပေးနှိုးဆော်ချက်များအားလုံးကို ပိတ်မယ်"
    )
)

val disable_worship_reminders_desc = Translatable(
    "This action will turn off(disable) all worship plans' reminder. The app won't remind you anymore.",
    hashMapOf(
        ENGLISH to "This action will turn off(disable) all worship plans' reminder. The app won't remind you anymore.",
        MYANMAR to "ယခုလုပ်ဆောင်ချက်သည် အဓိဌာန်များအားလုံး၏ သတိပေးနှိုးဆော်ချက်များအားလုံးကို ပိတ်ပင်တားမြစ်မည်ဖြစ်ပါသည်။ အဓိဌာန်ချိန်အတွက် သတိပေးချက်များ ပေးပို့တော့မည်မဟုတ်ပါ။"
    )
)

val enable_worship_reminders = Translatable(
    "Turn on all worship plan reminders",
    hashMapOf(
        ENGLISH to "Turn on all worship plan reminders",
        MYANMAR to "အဓိဌာန် သတိပေးနှိုးဆော်ချက်များအားလုံးကို ဖွင့်မယ်"
    )
)

val enable_worship_reminders_desc = Translatable(
    "This action will turn on(enable) all worship plans' reminder. The app will remind you punctually.",
    hashMapOf(
        ENGLISH to "This action will turn on(enable) all worship plans' reminder. The app will remind you punctually.",
        MYANMAR to "ယခုလုပ်ဆောင်ချက်သည် အဓိဌာန်များအားလုံး၏ သတိပေးနှိုးဆော်ချက်များအားလုံးကို ခွင့်ပြုသွားမည်ဖြစ်ပါသည်။ အဓိဌာန်ချိန်အတွက် သတိပေးချက်များ အချိန်မှန်ပေးပို့ပါမည်။"
    )
)

val disable_worship_reminders_success = Translatable(
    "Reminders disabled successfully",
    hashMapOf(
        ENGLISH to "Reminders disabled successfully",
        MYANMAR to "အောင်မြင်ပါသည်"
    )
)

val disabled = Translatable(
    "Disabled",
    hashMapOf(
        ENGLISH to "Disabled",
        MYANMAR to "ပိတ်ထားသည်"
    )
)

val seconds = Translatable(
    "Seconds",
    hashMapOf(
        ENGLISH to "Seconds",
        MYANMAR to "စက္ကန့်"
    )
)

val minutes = Translatable(
    "Minutes",
    hashMapOf(
        ENGLISH to "Minutes",
        MYANMAR to "မိနစ်"
    )
)

val hours = Translatable(
    "Hours",
    hashMapOf(
        ENGLISH to "Hours",
        MYANMAR to "နာရီ"
    )
)

val second = Translatable(
    "Second",
    hashMapOf(
        ENGLISH to "Second",
        MYANMAR to "စက္ကန့်"
    )
)

val minute = Translatable(
    "Minute",
    hashMapOf(
        ENGLISH to "Minute",
        MYANMAR to "မိနစ်"
    )
)

val hour = Translatable(
    "Hour",
    hashMapOf(
        ENGLISH to "Hour",
        MYANMAR to "နာရီ"
    )
)

val within_this_week = Translatable(
    "Within this week",
    hashMapOf(
        ENGLISH to "Within this week",
        MYANMAR to "တစ်ပတ်အတွင်း"
    )
)

val weekly = Translatable(
    "Week",
    hashMapOf(
        ENGLISH to "Week",
        MYANMAR to "အပတ်"
    )
)

val monthly = Translatable(
    "Month",
    hashMapOf(
        ENGLISH to "Month",
        MYANMAR to "လ"
    )
)

val yearly = Translatable(
    "Year",
    hashMapOf(
        ENGLISH to "Year",
        MYANMAR to "နှစ်"
    )
)

val within_this_month = Translatable(
    "Within this month",
    hashMapOf(
        ENGLISH to "Within this month",
        MYANMAR to "တစ်လအတွင်း"
    )
)

val jan = Translatable(
    "JA",
    hashMapOf(
        ENGLISH to "JA",
        MYANMAR to "ဇန်"
    )
)

val feb = Translatable(
    "FE",
    hashMapOf(
        ENGLISH to "FE",
        MYANMAR to "ဖေ"
    )
)

val mar = Translatable(
    "MA",
    hashMapOf(
        ENGLISH to "MA",
        MYANMAR to "မတ်"
    )
)

val apr = Translatable(
    "AP",
    hashMapOf(
        ENGLISH to "AP",
        MYANMAR to "ဧပြီ"
    )
)

val may = Translatable(
    "MA",
    hashMapOf(
        ENGLISH to "MA",
        MYANMAR to "မေ"
    )
)

val jun = Translatable(
    "JU",
    hashMapOf(
        ENGLISH to "JU",
        MYANMAR to "ဇွန်"
    )
)

val jul = Translatable(
    "JL",
    hashMapOf(
        ENGLISH to "JL",
        MYANMAR to "ဇူ"
    )
)

val aug = Translatable(
    "AU",
    hashMapOf(
        ENGLISH to "AU",
        MYANMAR to "သြ"
    )
)

val sep = Translatable(
    "SE",
    hashMapOf(
        ENGLISH to "SE",
        MYANMAR to "စက်"
    )
)

val oct = Translatable(
    "OC",
    hashMapOf(
        ENGLISH to "OC",
        MYANMAR to "အောက်"
    )
)

val nov = Translatable(
    "NO",
    hashMapOf(
        ENGLISH to "NO",
        MYANMAR to "နို"
    )
)

val dec = Translatable(
    "DE",
    hashMapOf(
        ENGLISH to "DE",
        MYANMAR to "ဒီ"
    )
)

val within_this_year = Translatable(
    "Within this year",
    hashMapOf(
        ENGLISH to "Within this year",
        MYANMAR to "တစ်နှစ်အတွင်း"
    )
)

val search = Translatable(
    "Search",
    hashMapOf(
        ENGLISH to "Search",
        MYANMAR to "ရှာမယ်"
    )
)

val search_placeholder = Translatable(
    "Prayer name, plan, keywords...",
    hashMapOf(
        ENGLISH to "Prayer name, plan, keywords...",
        MYANMAR to "ဘုရားစာ၊ အဓိဌာန်၊ စကားလုံး..."
    )
)

val x_found = Translatable(
    "({$}) found",
    hashMapOf(
        ENGLISH to "({$}) found",
        MYANMAR to "({$}) ခုတွေ့"
    )
)

val prayers = Translatable(
    "Prayers",
    hashMapOf(
        ENGLISH to "Prayers",
        MYANMAR to "ဘုရားစာများ"
    )
)

val plans = Translatable(
    "Worship plans",
    hashMapOf(
        ENGLISH to "Worship plans",
        MYANMAR to "အဓိဌာန်များ"
    )
)

val rate_app = Translatable(
    "Rate app",
    hashMapOf(
        ENGLISH to "Rate app",
        MYANMAR to "စတားပေးမယ်"
    )
)

val tell_friends = Translatable(
    "Tell friends",
    hashMapOf(
        ENGLISH to "Tell friends",
        MYANMAR to "သူငယ်ချင်းတွေကို​ ရှဲမယ်"
    )
)

val send_feedback = Translatable(
    "Send feedback",
    hashMapOf(
        ENGLISH to "Send feedback",
        MYANMAR to "အကြံပြုချက်ပေးပို့မယ်"
    )
)

val licenses = Translatable(
    "Swift packages used",
    hashMapOf(
        ENGLISH to "Swift packages used",
        MYANMAR to "အသုံးပြုထားသည့် Swift package များ"
    )
)

val websites_referenced_for_prayers = Translatable(
    "Referenced websites for prayers",
    hashMapOf(
        ENGLISH to "Referenced websites for prayers",
        MYANMAR to "ဂါထာများအတွက် မှီငြမ်းထားသည့် ဝက်ဘ်ဆိုဒ်များ"
    )
)

// non-translatable variant
val nonTrans = NonTranslatable("%1\$d:%2\$02d")