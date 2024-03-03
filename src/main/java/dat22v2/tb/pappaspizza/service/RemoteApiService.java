package dat22v2.tb.pappaspizza.service;


import dat22v2.tb.pappaspizza.utility.APIkeyHolder;
import dat22v2.tb.pappaspizza.utility.MonoApiCaller;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RemoteApiService {

    APIkeyHolder apiKeyHolder;

    public RemoteApiService(APIkeyHolder apiKeyHolder){
        this.apiKeyHolder = apiKeyHolder;
    }



    /*
    public ChatGPTResponse getChatGPTResponse(ChatGPTRequest body){
        String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
        return MonoApiCaller.callPostApi(ChatGPTResponse.class, OPENAI_API_URL,
            body, headersWithAuthorization(apiKeyHolder.getChatGPTAPIKey())).block();
    }
    */

    private Map<String, String> headersWithAuthorization(String bearerToken) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Authorization","Bearer " + bearerToken);
        return headers;
    }
}
