/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим ожидания.
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import States.Setting.*;
import bot.Bot;
import bot.UserInteraction;

public class Wait extends State {

    public Wait(Bot bot) {
        super(bot);
        UserInteraction.sendMessageWithCommands(Emodji.WARNING + " Запущен режим ожидания.\n", this.bot.getId(),
                Emodji.MAIL + " Запустить работу", START,
                Emodji.SETTING + " Настройки", SET_SETTING,
                Emodji.MEMO + " Посмотреть список", SHOW,
                Emodji.MEMO + "Редактировать список", EDIT,
                Emodji.QUESTION + "О боте", ABOUT
        );
    }

    @Override
    public void actionMode(String message) {
        State stateSetting;
        switch (message) {
            case START -> this.bot.setState(new Start(this.bot));
            case SET_SETTING -> this.bot.setState(new Setting(this.bot));
            case SHOW -> this.bot.setState(new Show(this.bot));
            case EDIT -> this.bot.setState(new Edit(this.bot));
            case ABOUT -> this.bot.setState(new About(this.bot));
            default -> {
                UserInteraction.sendMessage(SystemMessages.ERROR_MESSAGE, this.bot.getId());
                stateSetting = new Wait(this.bot);
                this.bot.setState(stateSetting);
            }
        }
    }


}
