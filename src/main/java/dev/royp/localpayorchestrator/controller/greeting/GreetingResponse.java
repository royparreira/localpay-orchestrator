package dev.royp.localpayorchestrator.controller.greeting;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GreetingResponse {
  private String greetingMessage;
  private String greetingName;
}
