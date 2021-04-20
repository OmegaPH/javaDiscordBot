package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.Date;

public class commands implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        Date dateTime = new Date();

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "commands")) {
            event.getChannel().type();
            event.getChannel().sendMessage("```\nCommand list:\n" +
                    ">ping\n" +
                    ">who am i?\n" +
                    ">WHO AM I?\n" +
                    ">play add\n" +
                    ">guess\n" +
                    ">guess top\n" +
                    ">modules\n" +
                    ">notes\n" +
                    ">roll\n" +
                    ">version\n" +
                    ">purge\n" +
                    ">markdown\n" +
                    ">notes update\n" +
                    ">mili```");
        }
        EmbedBuilder git = new EmbedBuilder()
                .setTitle("Git Bash")
                .addField("You can offer your own Pull request and get a copy of my code here:", "[gian.Discord.JavaBot's Github Repository here](<https://www.github.com/OmegaPH/javaDiscordBot>)")
                .setThumbnail("https://cdn.discordapp.com/attachments/698520297585770536/829780742665142343/mIbh5pT57HbVn16mRL9aPfGECv8Bsc18pywqBGEAAAAASUVORK5CYII.png");

        EmbedBuilder brad = new EmbedBuilder()
                .setTitle("NOTES HAVE BEEN UPDATED\n||" + dateTime + "||")
                .setDescription("Added...")
                .addField("**__OralCom Week 4__**", "Barriers and Dimensions of Communication")
                .setColor(Color.YELLOW)
                .setThumbnail("https://cdn.discordapp.com/attachments/698520297585770536/833878361880657941/check.png")
                .setImage("https://cdn.substack.com/image/fetch/w_1456,c_limit,f_auto,q_auto:good,fl_lossy/https%3A%2F%2Fbucketeer-e05bbc84-baa3-437e-9518-adb32be77984.s3.amazonaws.com%2Fpublic%2Fimages%2F0cb69658-ec7f-4f53-b622-df2e7661c89d_500x500.gif");

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "github")) {
            event.getChannel().type();
            event.getChannel().sendMessage(git);
        }
    }

}

