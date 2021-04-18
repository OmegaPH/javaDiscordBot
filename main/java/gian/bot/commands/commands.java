package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class commands implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "commands")) {
            event.getChannel().type();
            event.getChannel().sendMessage("```\nCommand list:\n" +
                    ">ping\n" +
                    ">who am i?\n" +
                    ">WHO AM I?\n" +
                    ">play add\n" +
                    ">guess\n" +
                    ">modules\n" +
                    ">notes\n" +
                    ">roll\n" +
                    ">version\n" +
                    ">purge\n" +
                    ">markdown\n" +
                    ">mili```");
        }
        EmbedBuilder git = new EmbedBuilder()
                .setTitle("Git Bash")
                .addField("You can offer your own Pull request and get a copy of my code here:", "[gian.Discord.JavaBot's Github Repository here](<https://www.github.com/OmegaPH/javaDiscordBot>)")
                .setThumbnail("https://cdn.discordapp.com/attachments/698520297585770536/829780742665142343/mIbh5pT57HbVn16mRL9aPfGECv8Bsc18pywqBGEAAAAASUVORK5CYII.png");
        EmbedBuilder brad = new EmbedBuilder()
                .setTitle("I am now a ***Huge Success***, thanks to this guy...")
                .setImage("https://cdn.discordapp.com/attachments/698520297585770536/832512145635803156/unknown.png");

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "github")) {
            event.getChannel().type();
            event.getChannel().sendMessage(git);
        }
        if (event.getMessageContent().equalsIgnoreCase("bradley")) {
            event.getChannel().sendMessage(brad);

    }
}
}
