package BotTelegram;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class tareaBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TinlingBot";
    }

    @Override
    public String getBotToken() {
        return "7148514782:AAFkEDipQnwGpIsJGzdn0EQ_1eJEGoQR5n0";
    }


    @Override
    public void onUpdateReceived(Update update) {

        String nombre = update.getMessage().getFrom().getUserName();
        String apellido = update.getMessage().getFrom().getLastName();
        String nickname = update.getMessage().getFrom().getFirstName();
        LocalDateTime now = LocalDateTime.now();

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            if (message_text.startsWith("/info")) {
                sendText(chat_id, "Bryan Josue Rivera Hernandez, 4to semestre, 0905-23-1623");
                System.out.println("Bryan Josue Rivera Hernandez, 4to semestre, 0905-23-1623");
            }
            if (message_text.startsWith("/progra")) {
                sendText(chat_id, "Es una clase donde aprendemos varias cosas que nos serviran para un futuro y que las hermanas lo son todo");
                System.out.println("Es una clase donde aprendemos varias cosas que nos serviran para un futuro y que las hermanas lo son todo");
            }
            if (message_text.startsWith("/hola")) {
                sendText(chat_id, "Hola " + nickname + apellido + " que te trae por aqui en " + now);
                System.out.println("Hola " + nickname + apellido + " que te trae por aqui en " + now);
            }
            if (message_text.startsWith("/cambio")) {
                String[] parts = message_text.split(" ");
                if (parts.length == 2) {
                    try {
                        double euros = Double.parseDouble(parts[1]);
                        double quetzales = euros * 8.53;
                        sendText(chat_id, euros + " euros son " + quetzales + " quetzales.");
                        System.out.println(euros + " euros son " + quetzales + " quetzales.");
                    } catch (NumberFormatException e) {
                        sendText(chat_id, "Por favor, ingresa un número válido.");
                    }
                } else {
                    sendText(chat_id, "Por favor, usa el formato: /cambio [cantidad en euros]");
                }
            }
            if (message_text.startsWith("/grupo")) {
                String message = "Como tan muchacho";
                    List<Long> CHAT_IDS = Arrays.asList(6688363556L, 6597569075L, 6710213754L, 6709392176L);
                    for (Long chatId : CHAT_IDS) {
                        try {
                            sendText(chatId, message);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
            }
            if (update.hasMessage() && update.getMessage().hasText()) {
                System.out.println("Hola" + nickname + "Tu nombre es " + nombre + " apellido " + apellido);
                String message = update.getMessage().getText();
                long chatid = update.getMessage().getChatId();

                if (message_text.toLowerCase().equals("hola")) {
                    System.out.println("User id: " + chatid + " Message: " + message);
                }
            }
        } //end fun
    }

        public void sendText (Long who, String what){
            SendMessage sm = SendMessage.builder()
                    .chatId(who.toString()) //Who are we sending a message to
                    .text(what).build();    //Message content
            try {
                execute(sm); // Este método podría no lanzar TelegramApiException en tu versión
            } catch (Exception e) { // Captura cualquier excepción genérica
                e.printStackTrace(); // Imprime el error en la consola para depuración
            }

        }
}