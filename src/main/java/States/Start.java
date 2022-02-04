/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Основной режим, в котором реализована отпрвака сообщений пользователю
 * с установленными настройками рассылки.
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import bot.Bot;
import bot.UserInteraction;
import org.apache.log4j.Logger;

import java.util.Date;

public class Start extends State {
    private static final Logger logger = Logger.getLogger(Start.class);
    private static final String IS_START_MODE_MESSAGE = Emodji.WARNING + " Запущен рабочий режим";

    public Start(Bot bot) {
        super(bot);
        UserInteraction.sendMessage(IS_START_MODE_MESSAGE, bot.getId());
        startBot(this.bot);
    }

    public void startBot(Bot bot) {
        int finalTime = bot.getSettings().getTimer() * 1000 * 60; //переводим в милесекунды
        Runnable task = () -> {
            logger.info("Crate Runnable by user " + bot.getId());
            while (bot.getState() instanceof Start) {
                int currentHour = new Date().getHours() + bot.getSettings().getTimezone(); //текущий час у пользователя
                int morning = bot.getSettings().getMorningHour(); //утренний час у пользователя

                int night = bot.getSettings().getNightHour(); //вечерний час у пользователя

                if (currentHour >= morning && currentHour < night) {
                    for (int i = 0; i < bot.getMessageList().size(); i++) {
                        if (!(bot.getState() instanceof Start))
                            return;
                        UserInteraction.sendMessage(bot.getMessageList().get(i), bot.getId());
                        if (i == bot.getMessageList().size()) {
                            i = 0;
                        }
                        try {
                            Thread.sleep(finalTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        if (!bot.getMessageList().isEmpty()) {
            Thread thread = new Thread(task);
            thread.start();
            logger.info("Runnable STOP by user " + bot.getId());
        } else {
            UserInteraction.sendMessage(SystemMessages.DICTIONARY_IS_EMPTY_MESSAGE, this.bot.getId());
            this.bot.setState(new Wait(this.bot));
        }
    }
}



