package io.pivotal.literx;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class MiscTest {

	@Test
	public void zipTwoFluxes() {
		Flux<String> flux1 = Flux.just("{1}", "{2}", "{3}", "{4}");
		Flux<String> flux2 = Flux.just("|A|", "|B|", "|C|");

		Flux.zip(flux2, flux1,
				(itemFlux2, itemFlux1) -> "-[" + itemFlux2 + itemFlux1  + "]-")
		.subscribe(System.out::print);
	}


}
