package dev.royp.localpayorchestrator.service;

import dev.royp.localpayorchestrator.controller.greeting.GreetingResponse;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

  @Override
  public GreetingResponse getGreetingFor(String name) {
    return GreetingResponse.builder()
        .greetingName(name)
        .greetingMessage(String.format("Hello %s! Greetings from webflux api", name))
        .build();
  }
}
