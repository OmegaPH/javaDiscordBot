package gian.bot;

import gian.bot.commands.*;
import gian.bot.commands.guessGame.guessReadNLB;
import gian.bot.commands.guessGame.guessWrite;
import gian.bot.commands.guessGame.guessingGame;
import gian.bot.commands.school.Notes_announce_update;
import gian.bot.commands.school.modules;
import gian.bot.commands.school.notes;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.user.UserStatus;

public class Main {

    public static String Prefix = ">";
    public static long start = System.currentTimeMillis();
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
                .addListener(new Notes_announce_update())
                .addListener(new version())
                .addListener(new Purge())
                .addListener(new commands())
                .addListener(new guessWrite())
                .addListener(new guessReadNLB())
                .addListener(new welcome())
                .setToken(token.token)
                .login()
                .join();
        Bot.updateStatus(UserStatus.ONLINE);
        Bot.updateActivity(ActivityType.WATCHING, "ICTHS students study");


        System.out.println("Bot is active!");






    }

}
