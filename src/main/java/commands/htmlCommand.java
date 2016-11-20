package commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class htmlCommand extends BotCommand {
	public htmlCommand() {
		super("html", "HTML적용후 출력합니다");

	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		SendMessage message = new SendMessage();
		message.setText(String.join(" ", arguments) + "");
		message.enableHtml(true);
		message.setChatId(chat.getId().toString());
		try {
			absSender.sendMessage(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}
}
