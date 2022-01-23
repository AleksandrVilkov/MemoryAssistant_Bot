/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим "О боте"
 */
package States;

import bot.Bot;
import bot.UserInteraction;

public class About extends State {

    public About(Bot bot) {
        super(bot);
        bot.getPrintInformationAboutThisBot();
        bot.setState(new Wait(bot));
    }

    @Override
    public void actionMode(String message) {
        UserInteraction.sendMessageWithCommands("Ты написал \"" + message + "\", но к сожалению, " +
                        "я не знаю что это такое", this.bot.getId(),
                "Помощь", EDIT);
    }
}
