package Parsers;

import bot.BotAuthorization;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonSimpleParser implements Parser {
private static final Logger logger = Logger.getLogger(JsonSimpleParser.class);
    @Override
    public BotAuthorization parse() {
        BotAuthorization botAuthorizationObject = new BotAuthorization();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/resources/Autorization.json")) {
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) jsonParser.parse(reader);

            String token = (String) jsonObject.get("token");
            String username = (String) jsonObject.get("username");

            botAuthorizationObject.setToken(token);
            botAuthorizationObject.setUsername(username);
            return botAuthorizationObject;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error create " + BotAuthorization.class);
        }
        return null;
    }
}
