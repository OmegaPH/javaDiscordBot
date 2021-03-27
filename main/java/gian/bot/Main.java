package gian.bot;

import gian.bot.commands.Ping;
import gian.bot.commands.screamCommand;
import gian.bot.commands.userInfo;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.user.UserStatus;

public class Main {

    public static String Prefix = ">";

    public static void main(String[] args) {


        DiscordApi Bot = new DiscordApiBuilder() // note: listeners first before login and join to avoid Webpacket error
                .addListener(new Ping())
                .addListener(new userInfo())
                .addListener(new screamCommand())
                .setToken("ODI0Njc4NDYzMzkwMzUxNDEw.YFy3qw.BlBhTkpQCcZAp5PXa2au4clUnGE")
                .login()
                .join();
        Bot.updateStatus(UserStatus.DO_NOT_DISTURB);
        Bot.updateActivity(ActivityType.LISTENING, "ICTzens chatters");



        System.out.println("Bot is active!");






    }

}
