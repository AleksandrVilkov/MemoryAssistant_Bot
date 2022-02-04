/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состоняние настройки бота. Устанавливанет таймер - переодичность рассылки списка сообщений
 */

package States.Setting;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import States.State;
import States.Wait;
import bot.Bot;
import bot.UserInteraction;
import org.apache.log4j.Logger;

public class SetTimer extends State {
    private static final Logger logger = Logger.getLogger(SetTimer.class);
    private final String INSTALL_FIVE_MIN = "/install_five_min";
    private final String INSTALL_TEN_MIN = "/install_ten_min";
    private final String INSTALL_FIFTEEN_MIN = "/install_fifteen_min";
    private final String INSTALL_TWENTY_MIN = "/install_twenty_min";
    private final String INSTALL_HALF_HOUR_TIMER = "/install_half_hour_timer";
    private final String INSTALL_ONE_HOUR_TIMER = "/install_one_hour_timer";
    private final String INSTALL_ONE_AND_HALF_HOUR_TIMER = "/install_one_and_half_hour_timer";
    private final String INSTALL_TWO_HOUR_TIMER = "/install_two_hour_timer";
    private final String INSTALL_THREE_HOUR_TIMER = "/install_three_hour_timer";
    private final String INSTALL_FOUR_HOUR_TIMER = "/install_four_hour_timer";

    public SetTimer(Bot bot) {
        super(bot);
        UserInteraction.sendMessage(Emodji.SETTING + "Настройка значения таймера", super.getBot().getId());
        UserInteraction.sendMessageWithCommands("Выбери, с каким интервалом присылать тебе сообщения:",
                super.getBot().getId(),
                Emodji.STOP_WATCH + " 5 мин", INSTALL_FIVE_MIN,
                Emodji.STOP_WATCH + " 10 мин", INSTALL_TEN_MIN,
                Emodji.STOP_WATCH + " 15 мин", INSTALL_FIFTEEN_MIN,
                Emodji.STOP_WATCH + " 20 мин", INSTALL_TWENTY_MIN,
                Emodji.STOP_WATCH + " 30 мин", INSTALL_HALF_HOUR_TIMER,
                Emodji.STOP_WATCH + " 1 час", INSTALL_ONE_HOUR_TIMER,
                Emodji.STOP_WATCH + " 1.5 часа", INSTALL_ONE_AND_HALF_HOUR_TIMER,
                Emodji.STOP_WATCH + " 2 часа", INSTALL_TWO_HOUR_TIMER,
                Emodji.STOP_WATCH + " 3 часа", INSTALL_THREE_HOUR_TIMER,
                Emodji.STOP_WATCH + " 4 часа", INSTALL_FOUR_HOUR_TIMER);
    }

    @Override
    public void actionMode(String message) {
        int newTimer;
        switch (message) {
            case INSTALL_FIVE_MIN -> newTimer = 5;
            case INSTALL_TEN_MIN -> newTimer = 10;
            case INSTALL_FIFTEEN_MIN -> newTimer = 15;
            case INSTALL_TWENTY_MIN -> newTimer = 20;
            case INSTALL_HALF_HOUR_TIMER -> newTimer = 30;
            case INSTALL_ONE_HOUR_TIMER -> newTimer = 60;
            case INSTALL_ONE_AND_HALF_HOUR_TIMER -> newTimer = 90;
            case INSTALL_TWO_HOUR_TIMER -> newTimer = 120;
            case INSTALL_THREE_HOUR_TIMER -> newTimer = 180;
            case INSTALL_FOUR_HOUR_TIMER -> newTimer = 240;
            default -> {
                UserInteraction.sendMessage(SystemMessages.ERROR_MESSAGE, super.getBot().getId());
                logger.error("Error value by " + getBot().getId());
                super.getBot().setState(new Wait(super.getBot()));
                return;
            }
        }
        super.getBot().getSettings().setTimer(newTimer);
        UserInteraction.sendMessage(SystemMessages.SUCCESSFULLY_ADDED, super.getBot().getId());
        super.getBot().setState(new Setting(super.getBot()));
    }
}

