package mx.emite.sdk.pruebas.ejemplos.integradores;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import mx.emite.sdk.IntegradorAPI;
import mx.emite.sdk.enums.Ambiente;
import mx.emite.sdk.enums.sat.Estados;
import mx.emite.sdk.enums.sat.MetodosPago;
import mx.emite.sdk.enums.sat.Paises;
import mx.emite.sdk.enums.sat.RegimenesFiscales;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.pruebas.ejemplos.Ejemplo;
import mx.emite.sdk.scot.request.SucursalesModificacionRequest;
import mx.emite.sdk.scot.request.TokenRequest;
import mx.emite.sdk.scot.request.extra.SucursalInfo;
import mx.emite.sdk.scot.response.SucursalesModificacionResponse;
import mx.emite.sdk.scot.response.TokenResponse;

@Slf4j
public class SucursalesModificacionEjemplo extends Ejemplo {

	
	@Test public void prueba(){
		try{
			final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
			final TokenRequest tr = TokenRequest.builder()
					.usuario(props.getProperty("integrador.usuario"))
					.contrasena(props.getProperty("integrador.contrasena"))
					.build();
			final TokenResponse tokenresp = api.token().ejecuta(tr);	
			final SucursalesModificacionRequest timbresreq = SucursalesModificacionRequest.builder()
				.token(tokenresp.getToken())
				.rfc("XAXX010101000")
				.sucursal(SucursalInfo.builder()
						.nombre("nombresucursal")
						.correo("test@test.com")
						.razonSocial("Razon Social")
						.calle("calle")
						.cp("04300")
						.municipio("Benito Juarez")
						.idEstado(Estados.DISTRITOFEDERAL )
						.idPais(Paises.MEXICO )
						.idRegimen(RegimenesFiscales.GENERALDELEYPERSONASMORALES)
						.idFormaPago(MetodosPago.TRANSFERENCIA)
						.cuentapago("1234")								
						.build())				
				.build();
			final SucursalesModificacionResponse respuesta = api.sucursalesmodificacion().ejecuta(timbresreq);
		log.debug(respuesta.toString());
		}catch(ApiException ae){
			log.error("error",ae);
		}
	}
}
