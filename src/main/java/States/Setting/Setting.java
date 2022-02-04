/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Родительский класс состояний настройки бота. Хранит команды для настроек
 */

package States.Setting;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import States.State;
import States.Wait;
import bot.Bot;
import bot.UserInteraction;
import org.apache.log4j.Logger;

public class Setting extends State {
    private static final Logger logger = Logger.getLogger(Setting.class);
    public static final String SET_TIMER_COMMAND = "/set_timer";
    public static final String SET_TIME_ZONE_COMMAND = "/set_time_zone";
    public static final String SET_MORNING_HOUR = "/set_morning_hour";
    public static final String SET_NIGHT_HOUR = "/set_night_hour";

    public Setting(Bot bot) {
        super(bot);
        String IS_SETTING_MESSAGE = Emodji.WARNING + " Запущен режим настроек";
        UserInteraction.sendMessage(IS_SETTING_MESSAGE, bot.getId());
        UserInteraction.sendMessage(super.getBot().getSettings().toString(), super.getBot().getId());
        String SETTING_MENU = "Что нужно изменить?";
        UserInteraction.sendMessageWithCommands(SETTING_MENU, super.getBot().getId(),
                "Изменить таймер", SET_TIMER_COMMAND,
                "Изменить часовой пояс", SET_TIME_ZONE_COMMAND,
                "Изменить час запуска рассылки", SET_MORNING_HOUR,
                "Изменить час приостановки рассылки", SET_NIGHT_HOUR,
                "Выйти из режима настройки", EXIT);
    }

    @Override
    public void actionMode(String message) {
        State stateSetting;
        switch (message) {
            case SET_TIMER_COMMAND -> super.getBot().setState(new SetTimer(super.getBot()));
            case SET_TIME_ZONE_COMMAND -> super.getBot().setState(new SetTimezone(super.getBot()));
            case SET_MORNING_HOUR -> super.getBot().setState(new SetMorning(super.getBot()));
            case SET_NIGHT_HOUR -> super.getBot().setState(new SetNight(super.getBot()));
            case EXIT -> super.getBot().setState(new Wait(super.getBot()));
            default -> {
                UserInteraction.sendMessage(SystemMessages.ERROR_MESSAGE, super.getBot().getId());
                logger.error("Error value by " + getBot().getId());
                stateSetting = new Wait(super.getBot());
                super.getBot().setState(stateSetting);
            }
        }
    }
}