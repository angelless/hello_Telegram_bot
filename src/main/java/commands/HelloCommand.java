package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

public class HelloCommand extends BotCommand {

	public HelloCommand() {
		super("Hello", "say Hello");

	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

		String m = "hello <b>";
		SendMessage message = new SendMessage();
		message.setChatId(chat.getId().toString());
		message.enableHtml(true);
		message.setText(m + user.getUserName() + "</b>");
		try {
			absSender.sendMessage(message);
		} catch (TelegramApiException e) {

			BotLogger.error("MAIN", e);
		}

	}

}
