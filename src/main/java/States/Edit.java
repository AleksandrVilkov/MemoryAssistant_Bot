/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим работы со списком
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import bot.Bot;
import bot.UserInteraction;

public class Edit extends State {

    private static final String IS_EDITOR_MESSAGE = Emodji.WARNING + "Режим работы со списком";

    public Edit(Bot bot) {
        super(bot);
        UserInteraction.sendMessage(IS_EDITOR_MESSAGE, this.bot.getId());
        UserInteraction.sendMessageWithCommands(Emodji.ARROW + "Выбери действие: \n", bot.getId(),
                Emodji.STOP_WATCH + "Запустить", START,
                "Добавить запись", ADD_NODE,
                "Удалить запись", DELETE_WORD,
                "Очистить", CLEAR,
                "Посмотреть список", SHOW,
                "Режим ожидания", EXIT
        );
    }

    @Override
    public void actionMode(String message) {
        State stateSetting;
        switch (message) {
            case START -> this.bot.setState(new Start(this.bot));
            case ADD_NODE -> this.bot.setState(new AddNode(this.bot));
            case EDIT -> this.bot.setState(new Edit(this.bot));
            case DELETE_WORD -> this.bot.setState(new Delete(this.bot));
            case EXIT -> this.bot.setState(new Wait(this.bot));
            case SHOW -> this.bot.setState(new Show(this.bot));
            case CLEAR -> this.bot.setState(new Clear(this.bot));
            default -> {
                UserInteraction.sendMessage(SystemMessages.ERROR_MESSAGE, this.bot.getId());
                stateSetting = new Wait(this.bot);
                this.bot.setState(stateSetting);
            }
        }
    }
}
