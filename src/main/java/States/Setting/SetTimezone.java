/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состоняние настройки бота. Устанавливанет часовой пояс пользователя.
 * отчет ведется от московского времени.
 */
package States.Setting;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import States.State;
import States.Wait;
import bot.Bot;
import bot.UserInteraction;

import java.util.Date;

public class SetTimezone extends State {

    private final String KALT = "/KALT"; //калинингроад -1
    private final String MSK = "/MSK";   //Москва 0
    private final String SAMT = "/SAMT"; //Самара +1
    private final String YEKT = "/YEKT"; //Екб +2
    private final String OMST = "/OMST"; //Омск +3
    private final String KRAT = "/KRAT"; //Красноярск +4
    private final String IRKT = "/IRKT"; //Иркутск +5
    private final String YAKT = "/YAKT"; //Якутия +6
    private final String VLAT = "/VLAT"; //Владивосток +7
    private final String MAGT = "/MAGT"; //Магадан +8
    private final String PETT = "/PETT"; //Камчатка +9

    public SetTimezone(Bot bot) {
        super(bot);
        UserInteraction.sendMessage(Emodji.SETTING + "Режим установки часового пояса",
                super.getBot().getId());
        UserInteraction.sendMessage("В Москве сейчас " + new Date().getHours() + " часа(ов)",
                super.getBot().getId());
        UserInteraction.sendMessageWithCommands(Emodji.TIME + " Какое у тебя время?\n",
                super.getBot().getId(),
                "(калининградское время)  MSK–1 (UTC+2)", KALT,
                "(московское время)  MSK (UTC+3)", MSK,
                "(самарское время)  MSK+1 (UTC+4)", SAMT,
                "(екатеринбургское время)  MSK+2 (UTC+5)", YEKT,
                "(омское время)  MSK+3 (UTC+6)", OMST,
                "(красноярское время)  MSK+4 (UTC+7)", KRAT,
                "(иркутское время)  MSK+5 (UTC+8)", IRKT,
                "(якутское время)  MSK+6 (UTC+9)", YAKT,
                "(владивостокское время)  MSK+7 (UTC+10)", VLAT,
                "(магаданское время)  MSK+8 (UTC+11)", MAGT,
                "(камчатское время)  MSK+9 (UTC+12)", PETT);
    }

    @Override
    public void actionMode(String message) {
        int newTimeZone;
        switch (message) {
            case KALT -> newTimeZone = -1;
            case MSK -> newTimeZone = 0;
            case SAMT -> newTimeZone = 1;
            case YEKT -> newTimeZone = 2;
            case OMST -> newTimeZone = 3;
            case KRAT -> newTimeZone = 4;
            case IRKT -> newTimeZone = 5;
            case YAKT -> newTimeZone = 6;
            case VLAT -> newTimeZone = 7;
            case MAGT -> newTimeZone = 8;
            case PETT -> newTimeZone = 9;
            default -> {
                UserInteraction.sendMessage(SystemMessages.ERROR_MESSAGE, super.getBot().getId());
                super.getBot().setState(new Wait(super.getBot()));
                return;
            }
        }
        super.getBot().getSettings().setTimezone(newTimeZone);
        UserInteraction.sendMessage(SystemMessages.SUCCESSFULLY_ADDED, super.getBot().getId());
        super.getBot().setState(new Setting(super.getBot()));
    }
}
