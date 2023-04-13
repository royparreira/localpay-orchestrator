package dev.royp.localpayorchestrator.controller.greeting;

import dev.royp.localpayorchestrator.controller.ApiResponse;
import dev.royp.localpayorchestrator.service.GreetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class GreetingController {

  private final GreetingService greetingService;

  @PostMapping(path = "/greetings", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ApiResponse<GreetingResponse>> greet(
      @Valid @RequestBody GreetingRequest greetingRequest) {

    var nameToGreet = greetingRequest.getGreetingName();

    var customGreeting = greetingService.getGreetingFor(nameToGreet);

    return ApiResponse.of(customGreeting);
  }

  @GetMapping("/greetings")
  public Mono<ApiResponse<String>> greetWithDefault() {
    return ApiResponse.of("Hi from Reactive!!");
  }
}
