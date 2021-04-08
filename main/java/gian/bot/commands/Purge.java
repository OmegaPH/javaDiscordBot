package gian.bot.commands;

import gian.bot.Main;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.util.event.ListenerManager;
import org.javacord.api.util.logging.ExceptionLogger;

public class Purge implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) { //global
        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "purge")) {
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
                                                event.getChannel().sendMessage("Success! " + casualties + " number of messages are now gone.");
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
                            event.getChannel().sendMessage("**Please input a valid** **__number__**");
                            }
                        lm[0].remove();
                    }
                });
            });
        }
    }
}