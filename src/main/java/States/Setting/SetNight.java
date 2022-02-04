/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состоняние настройки бота. Устанавливанет время приостановки рассылки списка сообщений
 */

package States.Setting;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import States.State;
import States.Wait;
import bot.Bot;
import bot.UserInteraction;
import org.apache.log4j.Logger;

public class SetNight extends State {
    private static final Logger logger = Logger.getLogger(SetNight.class);
    private final String FOURTEEN = "/fourteen";
    private final String FIFTEEN = "/fifteen";
    private final String SIXTEEN = "/sixteen";
    private final String SEVENTEEN = "/seventeen";
    private final String EIGHTEEN = "/eighteen";
    private final String NINETEEN = "/nineteen";
    private final String TWENTY = "/twenty";
    private final String TWENTY_ONE = "/twenty_one";
    private final String TWENTY_TWO = "/twenty_two";
    private final String TWENTY_THREE = "/twenty_three";

    public SetNight(Bot bot) {
        super(bot);
        UserInteraction.sendMessageWithCommands(Emodji.SETTING +
                        "Выбери с какого времени мне приостанавливать свою работу:", super.getBot().getId(),
                "14:00", FOURTEEN,
                "15:00", FIFTEEN,
                "16:00", SIXTEEN,
                "17:00", SEVENTEEN,
                "18:00", EIGHTEEN,
                "19:00", NINETEEN,
                "20:00", TWENTY,
                "21:00", TWENTY_ONE,
                "22:00", TWENTY_TWO,
                "23:00", TWENTY_THREE);
    }

    @Override
    public void actionMode(String message) {
        int morningHour;
        switch (message) {
            case FOURTEEN -> morningHour = 14;
            case FIFTEEN -> morningHour = 15;
            case SIXTEEN -> morningHour = 16;
            case SEVENTEEN -> morningHour = 17;
            case EIGHTEEN -> morningHour = 18;
            case NINETEEN -> morningHour = 19;
            case TWENTY -> morningHour = 20;
            case TWENTY_ONE -> morningHour = 21;
            case TWENTY_TWO -> morningHour = 22;
            case TWENTY_THREE -> morningHour = 23;

            default -> {
                UserInteraction.sendMessage(Emodji.EXCLAMATION_POINT +
                        "Ты ввел не верное значение!", super.getBot().getId());
                logger.error("Error value by " + getBot().getId());
                super.getBot().setState(new SetNight(super.getBot()));
                return;
            }
        }
        super.getBot().getSettings().setNightHour(morningHour);
        UserInteraction.sendMessage(SystemMessages.SUCCESSFULLY_ADDED, super.getBot().getId());
        super.getBot().setState(new Wait(super.getBot()));
    }
}
