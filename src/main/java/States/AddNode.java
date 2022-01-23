/**
 * @author VILKOV ALEKSANDR
 * <p>
 * Класс состояние. Режим добавления новых сообщений для рассылки
 */
package States;

import TextResourses.Emodji;
import TextResourses.SystemMessages;
import bot.Bot;
import bot.UserInteraction;

public class AddNode extends State {

    private static final String IS_ADD_NOTE_MODE_MESSAGE = Emodji.WARNING + " Запущен режим добавления записей. \n" +
            "Присылай мне отдельными сообщениями все то, что мне нужно запомнить. \n";

    public AddNode(Bot bot) {
        super(bot);
        UserInteraction.sendMessageWithCommands(IS_ADD_NOTE_MODE_MESSAGE, this.bot.getId(),
                Emodji.EXCLAMATION_POINT + " Закончить", EXIT);
    }

    @Override
    public void actionMode(String command) {
        if (command.equals(EXIT)) {
            this.bot.setState(new Wait(this.bot));
        } else {
            bot.getMessageList().add(command);
            UserInteraction.sendMessage(SystemMessages.SUCCESSFULLY_ADDED, this.bot.getId());
            this.bot.setState(new AddNode(this.bot));
        }
    }
}
