package com.phayarsar.data.mapper

import com.phayarsar.data.responsemodel.LocalizationResponseModel
import com.phayarsar.localization.model.LocalizationModel

fun LocalizationResponseModel.toLocalizationModel(): LocalizationModel {
    return LocalizationModel().also {
        phayarsar = it.phayarsar

        welcome_to_phayarsar = it.welcome_to_phayarsar

        onboarding_desc = it.onboarding_desc

        btn_get_started = it.btn_get_started

        choose_a_language = it.choose_a_language

        next = it.next

        finished = it.finished

        today_pray_time_x = it.today_pray_time_x

        today_pray_time = it.today_pray_time

        x_min = it.x_min

        x_sec = it.x_sec

        x_hour_y_min = it.x_hour_y_min

        btn_add = it.btn_add

        btn_pray = it.btn_pray

        home = it.home

        settings = it.settings

        app_language = it.app_language

        app_accent_color = it.app_accent_color

        choose_accent_color = it.choose_accent_color

        haptic_on = it.haptic_on

        themes_and_settings = it.themes_and_settings

        about_x = it.about_x

        jasmine = it.jasmine

        panglong = it.panglong

        msquare = it.msquare

        yoeyar = it.yoeyar

        page_white = it.page_white

        page_yellow = it.page_yellow

        page_grey = it.page_grey

        page_black = it.page_black

        font = it.font

        background_and_color = it.background_and_color

        letter_and_line_spacing = it.letter_and_line_spacing

        letter_spacing = it.letter_spacing

        line_spacing = it.line_spacing

        paragraph_spacing = it.paragraph_spacing

        text_size_and_alignment = it.text_size_and_alignment

        align_left = it.align_left

        align_right = it.align_right
        align_center = it.align_center

        justify = it.justify

        show_pronunciation = it.show_pronunciation

        scrolling_speed = it.scrolling_speed

        spotlight_text = it.spotlight_text
        tap_to_scroll = it.tap_to_scroll

        x0_5 = it.x0_5

        x0_75 = it.x0_75

        x1 = it.x1

        x1_25 = it.x1_25
        x1_5 = it.x1_5

        x2 = it.x2

        mode = it.mode

        reader_mode = it.reader_mode

        player_mode = it.player_mode
        selected = it.selected

        add_new = it.add_new

        worship_plan_helps_you_pray = it.worship_plan_helps_you_pray

        view_collection = it.view_collection

        plus_x_more = it.plus_x_more

        other_prayers = it.other_prayers

        new_plan = it.new_plan

        name_your_worship_plan = it.name_your_worship_plan

        plan_name = it.plan_name

        add_new_prayer = it.add_new_prayer

        btn_close = it.btn_close

        btn_save = it.btn_save

        select_prayers = it.select_prayers

        everyday = it.everyday

        sun = it.sun

        mon = it.mon

        tue = it.tue

        wed = it.wed

        thu = it.thu

        fri = it.fri
        sat = it.sat

        selectDay = it.selectDay

        selectTime = it.selectTime

        selectTagColor = it.selectTagColor

        setReminder = it.setReminder

        do_you_have_praying_time = it.do_you_have_praying_time

        yes_i_do = it.yes_i_do

        no_i_dont = it.no_i_dont

        time = it.time

        remind = it.remind

        before = it.before

        x_min_s = it.x_min_s

        su = it.su

        mo = it.mo

        tu = it.tu

        we = it.we

        th = it.th

        fr = it.fr

        sa = it.sa

        worship_plan = it.worship_plan
        view_more = it.view_more

        notify_x_mins_before = it.notify_x_mins_before

        x_prayers = it.x_prayers

        not_specified = it.not_specified

        new_worship_plan = it.new_worship_plan
        all_worship_plans = it.all_worship_plans

        edit_plan = it.edit_plan

        plan_detail = it.plan_detail

        prayers_x = it.prayers_x

        selected_days = it.selected_days
        remind_me_before = it.remind_me_before

        edit = it.edit

        delete = it.delete

        plan_deleted_successfully = it.plan_deleted_successfully

        x_of_y = it.x_of_y

        reset_prayers_theme = it.reset_prayers_theme

        reset_prayers_theme_desc = it.reset_prayers_theme_desc

        prayers_theme_data_reset_successfully = it.prayers_theme_data_reset_successfully

        delete_confirmation = it.delete_confirmation

        cancel = it.cancel

        disable_worship_reminders = it.disable_worship_reminders

        disable_worship_reminders_desc = it.disable_worship_reminders_desc

        enable_worship_reminders = it.enable_worship_reminders

        enable_worship_reminders_desc = it.enable_worship_reminders_desc

        disable_worship_reminders_success = it.disable_worship_reminders_success

        disabled = it.disabled

        seconds = it.seconds

        minutes = it.minutes

        hours = it.hours

        second = it.second

        minute = it.minute

        hour = it.hour

        within_this_week = it.within_this_week

        weekly = it.weekly

        monthly = it.monthly

        yearly = it.yearly

        within_this_month = it.within_this_month

        jan = it.jan

        feb = it.feb

        mar = it.mar

        apr = it.apr

        may = it.may

        jun = it.jun

        jul = it.jul

        aug = it.aug

        sep = it.sep

        oct = it.oct

        nov = it.nov

        dec = it.dec

        within_this_year = it.within_this_year

        search = it.search

        search_placeholder = it.search_placeholder

        x_found = it.x_found

        prayers = it.prayers

        plans = it.plans

        rate_app = it.rate_app

        tell_friends = it.tell_friends

        send_feedback = it.send_feedback

        licenses = it.licenses

        websites_referenced_for_prayers = it.websites_referenced_for_prayers
    }
}