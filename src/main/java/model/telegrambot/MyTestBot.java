package model.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.BotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyTestBot extends TelegramLongPollingBot{

	public MyTestBot(){
	this(new BotOptions());
	}
	
	public MyTestBot(BotOptions botOptions) {
		// TODO Auto-generated constructor stub
		super(botOptions);
	}

	@Override
	public String getBotUsername() {
		return BotConfig.BOT_USERNAME;
	}

	@Override
	public void onUpdateReceived(Update update) {

		// check if the update has a message
		if(update.hasMessage()){
			Message message = update.getMessage();
			
			//check if message has text. It could also contain example a location (message.hasLocation())
			if(message.hasText()){
				//create an object that contains information to send back the message
				SendMessage sendMessageRequest = new SendMessage();
				sendMessageRequest.setChatId(message.getChatId().toString());
				sendMessageRequest.setText("you said: " + message.getText());
				try {
					sendMessage(sendMessageRequest);
				} catch (TelegramApiException e){
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String getBotToken() {
		return BotConfig.BOT_TOKEN;
	}
	
}