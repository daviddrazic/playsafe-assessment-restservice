package com.playsafeholding.assessment.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.playsafeholding.assessment.restservice.model.Distance;
import com.playsafeholding.assessment.restservice.model.Temperature;

@WebMvcTest(ConversionController.class)
class RestserviceApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Temperature temp;

	@MockBean
	private Distance dist;

	@Test
	public void temperatureShouldReturnCelsiusFromKelvin() throws Exception {
		this.mockMvc.perform(get("/conversions/ktoc?kelvin=278")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":4.8500000000000227373675443232059478759765625,\"kelvin\":278}"));
	}

	@Test
	public void temperatureShouldReturnCelsiusFromInvalidKelvin() throws Exception {
		this.mockMvc.perform(get("/conversions/ktoc?kelvin=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":-273.15,\"kelvin\":0}"));
	}

	@Test
	public void temperatureShouldReturnCelsiusFromUnsuppliedKelvin() throws Exception {
		this.mockMvc.perform(get("/conversions/ktoc")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":-273.15,\"kelvin\":0}"));
	}

	@Test
	public void temperatureShouldReturnKelvinFromCelsius() throws Exception {
		this.mockMvc.perform(get("/conversions/ctok?celsius=23")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":23,\"kelvin\":296.15}"));
	}

	@Test
	public void temperatureShouldReturnKelvinFromInvalidCelsius() throws Exception {
		this.mockMvc.perform(get("/conversions/ctok?celsius=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":0,\"kelvin\":273.15}"));
	}

	@Test
	public void temperatureShouldReturnKelvinFromUnsuppliedCelsius() throws Exception {
		this.mockMvc.perform(get("/conversions/ctok")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"celsius\":0,\"kelvin\":273.15}"));
	}
	
	@Test
	public void distanceShouldReturnKilometersFromMiles() throws Exception {
		this.mockMvc.perform(get("/conversions/mtok?miles=105")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":105,\"kilometers\":168.98112}"));
	}

	@Test
	public void distanceShouldReturnKilometersFromInvalidMiles() throws Exception {
		this.mockMvc.perform(get("/conversions/mtok?miles=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}

	@Test
	public void distanceShouldReturnKilometersFromUnsuppliedMiles() throws Exception {
		this.mockMvc.perform(get("/conversions/mtok")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}
	
	@Test
	public void distanceShouldReturnMilesFromKilometers() throws Exception {
		this.mockMvc.perform(get("/conversions/ktom?kilometers=105")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":65.24397518492006,\"kilometers\":105}"));
	}

	@Test
	public void distanceShouldReturnMilesFromInvalidKilometers() throws Exception {
		this.mockMvc.perform(get("/conversions/ktom?kilometers=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}

	@Test
	public void distanceShouldReturnMilesFromUnsuppliedKilometers() throws Exception {
		this.mockMvc.perform(get("/conversions/ktom?kilometers=invalid")).andDo(print()).andExpect(status().isOk())
				.andExpect(content()
						.json("{\"miles\":0,\"kilometers\":0}"));
	}
	
	@Test
	   public void main() {
		RestserviceApplication.main(new String[] {});
	   }
}
