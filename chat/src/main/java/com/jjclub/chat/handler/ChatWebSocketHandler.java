package com.jjclub.chat.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//해당 코드는 금지어 로직을 작성한 코드입니다.
@Configuration
@CrossOrigin(originPatterns = {"http://chat.jjclub.pe.kr", "ws://chat.jjclub.pe.kr"})
@RestController
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private static final List<WebSocketSession> sessions = new ArrayList<>(); //WebSocket 세션의 리스트를 저장하기 위한 WebSocketSession 객체의 리스트

    //금지된 단어 목록을 배열로 저장하기 위한 String 리스트. loadForbiddenWords()를 통해 파일에서 금지어를 불러들임.
    private static List<String> forbiddenWords = new ArrayList<>();

    static {
        forbiddenWords = loadForbiddenWords();
    }

    //금지어 사이에 들어갈 수 있는 특수문자를 배열로 저장하여 금지어를 감지하는 폭을 늘림. 예를 들어 금.지!어 로 작성할 경우에도 금지어로 인식할 수 있도록 함.
    private static final List<String> specialCharacters = List.of("!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+", "=", "_", "[", "]", "{", "}", "|", ":", ";", "'", "\"", "<", ">", ",", ".", "?", "/", "`", "~");

    //웹소켓 연결 이후 호출
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.add(session);
    }

    //클라이언트로부터 수신한 텍스트 메시지를 처리해주는 코드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload(); //변수에 수신된 메시지 저장
        String filteredMessage = applyWordFilter(receivedMessage); //메시지에 적용이 가능한 단어 필터링 수행을 위해 필요
        session.sendMessage(new TextMessage(filteredMessage));
    }

    //웹소켓 연결이 끊긴 후 호출되는 코드. 종료한 세션이기 때문에 세션 리스트에서 제거함.
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    //금지어 사이 특수문자 제거 코드
    private String removeSpecialCharacters(String message) {
        StringBuilder sb = new StringBuilder(message);
        for (String character : specialCharacters) {
            int index = sb.indexOf(character);
            while (index != -1) {
                if (index > 0 && index < sb.length() - 1) {
                    char prevChar = sb.charAt(index - 1);
                    char nextChar = sb.charAt(index + 1);
                    if (Character.isLetterOrDigit(prevChar) && Character.isLetterOrDigit(nextChar)) {
                        sb.deleteCharAt(index);
                    }
                }
                index = sb.indexOf(character, index + 1);
            }
        }
        return sb.toString();
    }

    //금지어 필터링 코드
    private String applyWordFilter(String message) {
        message = removeSpecialCharacters(message);
        for (String word : forbiddenWords) {
            String filteredWord = word.replaceAll("[\\p{Z}\\p{P}]", "");

            // 영어의 경우 대소문자를 구분하지 않을 수 있도록 단어 패턴 생성
            String wordPattern = "(?i)\\b" + Pattern.quote(filteredWord) + "\\b";

            // 필터링을 마친 금지어 단어를 *로 바꿈.
            Matcher matcher = Pattern.compile(wordPattern).matcher(message);
            StringBuilder filteredMessage = new StringBuilder();
            int lastEndIndex = 0;

            while (matcher.find()) {
                int startIndex = matcher.start();
                int endIndex = matcher.end();

                // 금지어 앞에 있는 일반 단어에 이 문자열 추가
                filteredMessage.append(message, lastEndIndex, startIndex);

                // 일치하는 단어와 같은 길이의 별표 추가
                filteredMessage.append("*".repeat(endIndex - startIndex));

                //맨 마지막 단어까지 모두 읽어들임.
                lastEndIndex = endIndex;
            }

            // 금지어 뒤에 있는 일반 단어에 이 문자열 추가
            filteredMessage.append(message.substring(lastEndIndex));

            // 필터링된 메시지로 원본 메시지를 최종 업데이트해줌.
            message = filteredMessage.toString();
        }

        return message;
    }

    // "금지어리스트.txt" 파일에서 금지된 단어를 읽어오는 코드
    private static List<String> loadForbiddenWords() {
        List<String> forbiddenWords = new ArrayList<>();

        try {
            Path filePath = Path.of("금지어리스트.txt");
            forbiddenWords = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return forbiddenWords;
    }

    //메시지를 모든 웹소켓 세션에 브로드캐스팅하는 역할(동일하게 열린 세션에는 모두 반영이 되어야 하기 때문)
    private void broadcastMessage(String message) throws IOException {
        for (WebSocketSession session : sessions) {
            session.sendMessage(new TextMessage(message));
        }
    }

    /*@Configuration
    @RequestMapping("/api/v1/chat")
    public class ForbiddenWordsController {

        @GetMapping("/forbiddenWords/view")
        public List<String> getForbiddenWords() {
            return forbiddenWords;
        }

        public void setForbiddenWords(List<String> forbiddenWords) {
            ChatWebSocketHandler.forbiddenWords = forbiddenWords;
        }

        @PostMapping("/forbiddenWords/update")
        public void updateForbiddenWords(@RequestBody List<String> updatedForbiddenWords) {
            ChatWebSocketHandler.forbiddenWords = updatedForbiddenWords;
        }
    }*/
}
