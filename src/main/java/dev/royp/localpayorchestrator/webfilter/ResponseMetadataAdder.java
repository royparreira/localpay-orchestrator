package dev.royp.localpayorchestrator.webfilter;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

@Component
public class ResponseMetadataAdder implements WebFilter {

  @NonNull
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    var responseHeaders = exchange.getResponse().getHeaders();

    addRequestPath(responseHeaders, exchange);
    addUtcTimestamp(responseHeaders);

    return chain.filter(exchange);
  }

  private void addUtcTimestamp(HttpHeaders responseHeaders) {
    var utcTimestamp = ZonedDateTime.now(ZoneOffset.UTC).toString();
    responseHeaders.add("x-utc-timestamp", utcTimestamp);
  }

  private void addRequestPath(HttpHeaders responseHeaders, ServerWebExchange exchange) {
    var requestPath = exchange.getRequest().getPath().value();
    responseHeaders.add("x-request-path", requestPath);
  }
}
