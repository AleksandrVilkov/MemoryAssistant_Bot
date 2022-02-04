/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим "О боте"
 */
package States;

import bot.Bot;
import bot.UserInteraction;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

public class About extends State {
private static final Logger logger = Logger.getLogger(About.class);
    public About(Bot bot) {
        super(bot);
        bot.getPrintInformationAboutThisBot();
        bot.setState(new Wait(bot));
    }

    @Override
    public void actionMode(String message) {
        logger.error("Not correct msg by " + this.bot.getId() + " user");
        UserInteraction.sendMessageWithCommands("Ты написал \"" + message + "\", но к сожалению, " +
                        "я не знаю что это такое", this.bot.getId(),
                "Помощь", EDIT);
    }
}
