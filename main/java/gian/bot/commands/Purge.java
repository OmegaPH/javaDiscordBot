package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
import org.javacord.api.util.logging.ExceptionLogger;

import java.util.concurrent.TimeUnit;

public class Purge implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) { //global
        boolean admin = false;

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "purge")) {

            if (event.getMessageAuthor().isServerAdmin()) {
                admin = true;
            } else {
                admin = false;
            }

            if (admin == true) {
                event.getChannel().type();
                event.getChannel().sendMessage("*Roger that captain!*... how many casualties?");

                event.getMessageAuthor().asUser().ifPresent(user -> {
                    final ListenerManager[] lm = new ListenerManager[1];
                    lm[0] = user.addMessageCreateListener(new MessageCreateListener() {
                        @Override
                        public void onMessageCreate(MessageCreateEvent event) { //private

                            try {
                                int casualties = Integer.parseInt(String.valueOf(event.getMessageContent()));

                                if (casualties > 0) {
                                    event.getChannel().type();
                                    event.getChannel().sendMessage(casualties + " of messages are about to get wiped out of the server, are you sure about this, *Captain*?");

                                    event.getMessageAuthor().asUser().ifPresent(user -> {
                                        final ListenerManager[] lm = new ListenerManager[1];
                                        lm[0] = user.addMessageCreateListener(new MessageCreateListener() {
                                            @Override
                                            public void onMessageCreate(MessageCreateEvent event) {
                                                if (event.getMessageContent().equalsIgnoreCase("yes")) {
                                                    event.getChannel().getMessages(casualties + 5).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                                                    event.getChannel().type();
                                                    event.getChannel().sendMessage("> Success! " + casualties + " number of messages are now gone.");
                                                    try {
                                                        TimeUnit.SECONDS.sleep(2);
                                                    } catch (Exception e) {

                                                    }
                                                    event.getChannel().getMessages(1).thenCompose(MessageSet::deleteAll).exceptionally(ExceptionLogger.get());
                                                } else {
                                                    event.getChannel().type();
                                                    event.getChannel().sendMessage("What was that sir? You glitched out of the radio!\nEither you gave us an invalid value or you wanna cancel the mission.\nMission cancelled.");
                                                }
                                                lm[0].remove();
                                            }
                                        });
                                    });

                                } else {
                                    event.getChannel().sendMessage("Get your math right, I don't think that's a number :v");
                                }
                            } catch (NumberFormatException e) {
                                event.getChannel().type();
                                event.getChannel().sendMessage(String.valueOf("```java\n" + e + "\n```"));
                                event.getChannel().type();
                                event.getChannel().sendMessage("**Please call out >purge again and input a valid** **__number__**");
                            }
                            lm[0].remove();
                        }
                    });
                });
            } else {
                event.getChannel().sendMessage("You're not an Admin :/");
            }
        }

    }
}