package gian.bot;

import gian.bot.commands.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.user.UserStatus;

public class Main {

    public static String Prefix = ">";

    public static void main(String[] args) {



        DiscordApi Bot = new DiscordApiBuilder() // note: listeners first before login and join to avoid Webpacket error
                .addListener(new Ping())
                .addListener(new userInfo())
                .addListener(new additionGame())
                .addListener(new markDown())
                .addListener(new guessingGame())
                .addListener(new roll())
                .addListener(new modules())
                .addListener(new notes())
                .setToken(token.token)
                .login()
                .join();
        Bot.updateStatus(UserStatus.ONLINE);
        Bot.updateActivity(ActivityType.WATCHING, "Tristan Santos get clapped");


        System.out.println("Bot is active!");






    }

}
