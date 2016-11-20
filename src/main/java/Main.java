package hello_telegram_bot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.BotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.logging.BotLogger;

import handlers.CommandsHandler;

public class Main {
	public static final Calendar date = Calendar.getInstance();
	private static final String LOGTAG = "MAIN";
	public static void main(String[] args) {

		TelegramBotsApi api = new TelegramBotsApi();
		try {
			api.registerBot(new CommandsHandler());
		} catch (TelegramApiRequestException e) {
			BotLogger.severe(LOGTAG, e);

		}
		Scanner message = new Scanner(System.in);
		String mm = "";
		TelegramLongPollingBot chat = new TelegramLongPollingBot(new BotOptions()) {

			public void onUpdateReceived(Update update) {
				
			}

			public String getBotUsername() {
				return botConfig.USER;
			}

			@Override
			public String getBotToken() {
				// TODO 자동 생성된 메소드 스텁
				return botConfig.TOKEN;
			}
		};
		//try {
		//	api.registerBot(chat);
		//} catch (TelegramApiRequestException e1) {
			// TODO 자동 생성된 catch 블록
		//	e1.printStackTrace();
		//}
		while (message.hasNextLine()) {
			mm = message.nextLine();
			
			SendMessage m = new SendMessage();

			m.setText(mm);
			m.setChatId("채팅방id");
			m.enableMarkdown(true);
			try {
				chat.sendMessage(m);
				
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

			System.out.print("message: \n");
		
		}
	}
}
