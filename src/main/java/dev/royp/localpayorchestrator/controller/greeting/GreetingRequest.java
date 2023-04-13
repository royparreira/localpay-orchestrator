package dev.royp.localpayorchestrator.controller.greeting;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreetingRequest {

  @NotBlank private String greetingName;
}
