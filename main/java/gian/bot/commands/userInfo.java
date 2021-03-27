package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class userInfo implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent infoEmbed) {
    String username = String.valueOf(infoEmbed.getMessageAuthor().getDisplayName());

    if (username.equalsIgnoreCase("def not gian")) {
        username = "Gian Carlo S. Sitchon";
    }
        

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Your Name is:")
                .setDescription(username)
                .setAuthor("Click me for fun!", "https://youtu.be/j8PxqgliIno", "https://cdn.discordapp.com/attachments/742762009778585631/824317577584836608/26220309_829115467259230_4833775892851768861_o.png")
                .addField("A field", "Some text inside the field")
                .addInlineField("An inline field", "More text")
                .addInlineField("Section: ", "UNKNOWN")
                .setColor(Color.BLUE)
                .setFooter("Now you know who you are...", "https://cdn.discordapp.com/attachments/771182740024328235/825321716418215966/latest.png")
                .setImage(new File("S:\\Pictures\\Pasted Image - 5.png"))
                .setThumbnail(new File("S:\\Pictures\\Pasted Image - 5.png"));

        if (infoEmbed.getMessageContent().equals(Main.Prefix + "who am i?")) {
            infoEmbed.getChannel().type();
            infoEmbed.getChannel().sendMessage("idk :l");

        } if (infoEmbed.getMessageContent().equals(Main.Prefix + "WHO AM I?")) {
            infoEmbed.getChannel().type();
            infoEmbed.getChannel().sendMessage(embed);
            infoEmbed.getChannel().type();
            new MessageBuilder()
                    .append("This is ")
                    .append("WHO", MessageDecoration.BOLD, MessageDecoration.ITALICS, MessageDecoration.UNDERLINE)
                    .append(" you are... ( '-')")
                    .send(infoEmbed.getChannel());

        }
    }
}
