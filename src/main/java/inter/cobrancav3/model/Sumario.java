package inter.cobrancav3.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sumario extends ArrayList<ItemSumario> {

}