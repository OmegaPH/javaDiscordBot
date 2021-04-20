package gian.bot.commands.school;

import gian.bot.Main;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.Date;

public class Notes_announce_update implements MessageCreateListener {

    //this will notify all of the text channels assigned for >notes that notes have been updated by simply typing an input in just one channel

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        Date dateTime = new Date();
        String Lesson = "**__Prob & Stat Week 4__**";
        String Topic = "Z-score and more";

        //11 - descartes
        if (event.getMessageAuthor().isBotOwner()) { //checks if author is bot owner

            if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "notes update")) {
                event.getApi().getTextChannelById(832124073818718219L).ifPresent(channel -> {
                            channel
                                    .sendMessage(
                                            new EmbedBuilder()
                                                    .setTitle("NOTES HAVE BEEN UPDATED")
                                                    .setDescription(String.valueOf(dateTime))
                                                    .addField("_____________________________", "\nThe following have been added")
                                                    .addInlineField(Lesson, Topic)
                                                    .setColor(Color.YELLOW)
                                                    .setThumbnail("https://cdn.discordapp.com/attachments/698520297585770536/833878361880657941/check.png")
                                                    .setImage("https://cdn.substack.com/image/fetch/w_1456,c_limit,f_auto,q_auto:good,fl_lossy/https%3A%2F%2Fbucketeer-e05bbc84-baa3-437e-9518-adb32be77984.s3.amazonaws.com%2Fpublic%2Fimages%2F0cb69658-ec7f-4f53-b622-df2e7661c89d_500x500.gif")
                                    );

                        }
                );
            }
            //Grade 11 hangout party
            if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "notes update")) {
                event.getApi().getTextChannelById(828955995015348235L).ifPresent(channel -> {
                            channel
                                    .sendMessage(
                                            new EmbedBuilder()
                                                    .setTitle("NOTES HAVE BEEN UPDATED")
                                                    .setDescription(String.valueOf(dateTime))
                                                    .addField("_____________________________", "\nThe following have been added")
                                                    .addInlineField(Lesson, Topic)
                                                    .setColor(Color.YELLOW)
                                                    .setThumbnail("https://cdn.discordapp.com/attachments/698520297585770536/833878361880657941/check.png")
                                                    .setImage("https://cdn.substack.com/image/fetch/w_1456,c_limit,f_auto,q_auto:good,fl_lossy/https%3A%2F%2Fbucketeer-e05bbc84-baa3-437e-9518-adb32be77984.s3.amazonaws.com%2Fpublic%2Fimages%2F0cb69658-ec7f-4f53-b622-df2e7661c89d_500x500.gif")
                                    );

                        }
                );
            }

        } else { //if not, it will ping me in discord and tell the member that he can't access this command.
            if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "update notes")) {
                event.getChannel().type();
                event.getChannel().sendMessage(
                        new EmbedBuilder()
                                .setTitle("That's not the face my owner :l")
                                .setThumbnail(event.getMessageAuthor().getAvatar())
                                .addField("Want to see latest updates on __>notes__?", "Call in <@!414362560909934592> to update and see what's new in __>notes__")
                );
            }
        }
    }
}
