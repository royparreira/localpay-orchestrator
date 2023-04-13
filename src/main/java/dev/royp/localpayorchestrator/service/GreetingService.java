package dev.royp.localpayorchestrator.service;

import dev.royp.localpayorchestrator.controller.greeting.GreetingResponse;

public interface GreetingService {
  GreetingResponse getGreetingFor(String name);
}
