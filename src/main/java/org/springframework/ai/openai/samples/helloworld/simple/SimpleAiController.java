package org.springframework.ai.openai.samples.helloworld.simple;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SimpleAiController {

	private final ChatClient chatClient;

	public SimpleAiController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping("/ai/simple")
	public Map<String,String> completion(@RequestParam(defaultValue = "Tell me a joke") String message) {
		return Map.of("generation", chatClient.call(message));
	}
}
