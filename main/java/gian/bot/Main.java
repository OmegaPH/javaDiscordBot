package gian.bot;

import gian.bot.commands.Ping;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static String Prefix = ">";

    public static void main(String[] args) {

        DiscordApi Bot = new DiscordApiBuilder() // note: listeners first before login and join to avoid Webpacket error
                .addListener(new Ping())
                .setToken("ODI0Njc4NDYzMzkwMzUxNDEw.YFy3qw.aeMO_JosdVgLwac-8fuzEV2WuIY")
                .login()
                .join();

        System.out.println("Bot is active!");





    }

}
