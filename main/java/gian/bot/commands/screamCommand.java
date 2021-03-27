package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.File;

public class screamCommand implements MessageCreateListener {


    @Override
    public void onMessageCreate(MessageCreateEvent whisper) {

        if(whisper.getMessageContent().equalsIgnoreCase(Main.Prefix + "scream")){
            whisper.getChannel().type();
            whisper.getChannel().sendMessage(":o");
        }

    }
}
