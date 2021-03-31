package gian.bot.commands;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import gian.bot.Main;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.ChainableGloballyAttachableListenerManager;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.listener.user.UserAttachableListenerManager;
import org.javacord.api.util.event.ListenerManager;

public class additionGame implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) { //global
        String displayID = String.valueOf(event.getMessageAuthor().getId());

        if (event.getMessageContent().equalsIgnoreCase(Main.Prefix + "play add")) {

            event.getChannel().type();
            Random number = new Random();
            int num1;
            int num2;
            String sum;
            String userMsg = event.getMessageContent();
            num1 = 1 + number.nextInt(1000);
            num2 = 1 + number.nextInt(800);
            sum = String.valueOf(num1 + num2);

            event.getChannel().sendMessage(String.valueOf(num1 + " + " + num2));

            event.getMessageAuthor().asUser().ifPresent(user ->{ final ListenerManager[] lm = new ListenerManager[1];
            lm[0] = user.addMessageCreateListener(new MessageCreateListener() {

                @Override
                public void onMessageCreate(MessageCreateEvent event) { //private

                    if (event.getMessageContent().equalsIgnoreCase(sum)) {
                        event.getChannel().type();
                        event.getChannel().sendMessage("Good job.");
                        lm[0].remove();

                    } else if (String.valueOf(event.getMessageContent()) != sum) {

                        event.getChannel().sendMessage("Nice try. no. The answer is: " + sum);
                        event.getChannel().sendMessage(displayID);
                        lm[0].remove();

                    }
                }
            });
        });
    }
    }
}



