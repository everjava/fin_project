package br.com.ever.fin.client;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class FinMsBCBClientFallbackFactory implements FallbackFactory<FinMsBCBFeignClient> {

	@Override
	public FinMsBCBFeignClient create(Throwable cause) {
		return new FinMsBCBClientFallback(cause);
	}

}
