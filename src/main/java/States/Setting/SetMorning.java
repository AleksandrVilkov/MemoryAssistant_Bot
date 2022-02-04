/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состоняние настройки бота. Устанавливанет время начала рассылки списка сообщений
 */

package States.Setting;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import States.State;
import States.Wait;
import bot.Bot;
import bot.UserInteraction;
import org.apache.log4j.Logger;

public class SetMorning extends State {
    private static final Logger logger = Logger.getLogger(SetMorning.class);
    private final String SEVEN = "/seven";
    private final String EIGHT = "/eight";
    private final String NINE = "/nine";
    private final String TEN = "/ten";
    private final String ELEVEN = "/eleven";
    private final String TWELVE = "/twelve";
    private final String THIRTEEN = "/thirteen";

    public SetMorning(Bot bot) {
        super(bot);
        UserInteraction.sendMessageWithCommands(Emodji.SETTING +
                        "Выбери, с какого времени мне начинать свою работу:", super.getBot().getId(),
                "07:00", SEVEN,
                "08:00", EIGHT,
                "09:00", NINE,
                "10:00", TEN,
                "11:00", ELEVEN,
                "12:00", TWELVE,
                "13:00", THIRTEEN,
                Emodji.EXCLAMATION_POINT + " Завершить", EXIT);
    }


    @Override
    public void actionMode(String message) {
        int morningHour;
        switch (message) {
            case SEVEN -> morningHour = 7;
            case EIGHT -> morningHour = 8;
            case NINE -> morningHour = 9;
            case TEN -> morningHour = 10;
            case ELEVEN -> morningHour = 11;
            case TWELVE -> morningHour = 12;
            case THIRTEEN -> morningHour = 13;
            default -> {
                UserInteraction.sendMessage(Emodji.EXCLAMATION_POINT +
                        "Ты ввел не верное значение!", super.getBot().getId());
                logger.error("Error value by " + getBot().getId());
                super.getBot().setState(new SetMorning(super.getBot()));
                return;
            }
        }
        super.getBot().getSettings().setMorningHour(morningHour);
        UserInteraction.sendMessage(SystemMessages.SUCCESSFULLY_ADDED, super.getBot().getId());
        super.getBot().setState(new Wait(super.getBot()));
    }
}
