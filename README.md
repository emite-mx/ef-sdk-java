![alt text](https://github.com/emitefacturacion/ef-sdk-java/blob/master/emite.png "Emite Facturacion")
# EmiteFacturacion [emite.mx](https://www.emite.mx)

## ef-sdk-java-0.0.6
**** Kit de consumo de servicios Emite Facturación

### Instalación Maven
-------------------------------------------------------
Para instalar esta libreria es necesario que agregue el siguiente codigo en su archivo pom.xml

```xml
<dependency>
	<groupId>mx.emite</groupId>
	<artifactId>ef-sdk-java</artifactId>
	<version>0.0.6</version>
</dependency>
```
### Requerimientos Técnicos
-------------------------------------------------------
- Java 1.8

## Servicios de Emisor 
-------------------------------------------------------
- Timbrado de CFDI 3.2
- Sellado y Timbrado de CFDI 3.2
- Generación completa de CFDI (Xml + Sellado + Timbrado)
- Cancelación de CFDI 3.2
- Descarga de Xml
- Descarga de Acuses de Cancelación
- Descarga de Pdf
- Descarga de Pdf de Acuse de Cancelación
- Envio de Xml y Pdf por correo
- Descarga Masiva de Xml, Pdf y Acuses de Cancelación

### Servicios de Integrador 
-------------------------------------------------------
- Generación de Token de Consumo
- Consulta de Tarifa y Timbres Disponibles
- Consulta de Emisores Registrados
- Consulta de Sucursales por Emisor
- Alta de Emisores
- Modificación de Emisores
- Carga de CSD
- Consulta de CSD
- Consulta de Estatus de Emisores
- Alta / Modificación de Sucursales
- Servicio de carga de documentación

### Requerimientos de utilización
-------------------------------------------------------
- Contar con registro de Integrador en nuestro portal de Integradores

	[Portal de Integradores: https://scot.emite.mx](https://scot.emite.mx)
    
### Documentación adicional de nuestros servicios
-------------------------------------------------------

- [Documentacion Técnica Api Servicios Web de Emisores: https://proxy.emite.mx/api/](https://proxy.emite.mx/api/)

- [Documentacion Técnica Api Servicios Web de Integradores: https://scot.emite.mx/api/](https://scot.emite.mx/api/)

# Ejemplos de utilización
-------------------------------------------------------
Dentro de la carpeta [ef-sdk-java/src/test/java/mx/emite/sdk/pruebas/ejemplos](https://github.com/emitefacturacion/ef-sdk-java/tree/master/ef-sdk-java/src/test/java/mx/emite/sdk/pruebas/ejemplos) podrá encontrar ejemplos sobre los servicios que estan soportados por la libreria, para su referencia se muestra a continuación un ejemplo de generación, sellado y timbrado de un CFDI:

## Servicios de Emisor
-------------------------------------------------------
-------------------------------------------------------

### Ejemplo de Timbrado de CFDI 3.2
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final TimbrarRequest request = TimbrarRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.xml(props.getProperty("xml.base64"))
			.build();
	final TimbrarResponse respuesta = api.timbrador32().ejecuta(request);
```

### Sellado y Timbrado de CFDI 3.2
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.xml(props.getProperty("xml.base64"))
			.build();
	final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);
```


### Ejemplo de Generación completa de CFDI (Xml + Sellado + Timbrado)
-------------------------------------------------------
```java
	final Comprobante comprobante = Comprobante.builder()
				.lugarExpedicion("México, D.F.")
				.fecha(LocalDateTime.now())
				.folio(1000)
				.formaDePago(TipoPago.PAGOENUNASOLAEXHIBICION)
				.metodoDePago(MetodosPago.CANCELACION)
				.tipoDeComprobante(TipoDeComprobante.INGRESO)
				.subTotal(BigDecimal.ZERO)
				.total(BigDecimal.ZERO)
				.moneda(Monedas.MXN)
				.numCtaPago("NO IDENTIFICADO")
				.emisor(Emisor.builder()
						.nombre(props.getProperty("emisor.nombre"))
						.rfc(props.getProperty("emisor.usuario"))
						.domicilioFiscal(TUbicacionFiscal.builder()
										.calle("CALLE")
										.codigoPostal("00000")
										.municipio("MUNICIPIO")
										.estado(Estados.DISTRITOFEDERAL)
										.pais(Paises.MEXICO)
								.build())
						.regimenFiscal(RegimenFiscal.builder()
								.Regimen(RegimenesFiscales.GENERALDELEYPERSONASMORALES)
								.build())
						.build())				
				.receptor(Receptor.builder()
						.nombre("RECEPTOR SA DE CV")
						.rfc("XAXX010101000")
						.domicilio(TUbicacion.builder()
										.calle("CALLE")
										.codigoPostal("00000")
										.municipio("MUNICIPIO")
										.estado(Estados.DISTRITOFEDERAL)
										.pais(Paises.MEXICO)
								.build())
						.build())
				.conceptos(Conceptos.builder()
							.concepto(Concepto.builder()
										.cantidad(BigDecimal.ONE)
										.descripcion("DESCRIPCION")
										.importe(BigDecimal.ZERO)
										.valorUnitario(BigDecimal.ZERO)
										.unidad(UnidadesMedida.SERVICIO)
									.build())
						.build())
				.impuestos(Impuestos.builder()
							.totalImpuestosRetenidos(BigDecimal.valueOf(0))
							.totalImpuestosTrasladados(BigDecimal.ZERO)
							.retenciones(Retenciones.builder()
											.retencion(Retencion.builder()
											.importe(BigDecimal.ZERO)
											.impuesto(TiposImpuesto.ISR)
											.build())
									.build())
							.traslados(Traslados.builder()
											.traslado(Traslado.builder()
											.tasa(BigDecimal.valueOf(16))
											.importe(BigDecimal.ZERO)
											.impuesto(TiposImpuesto.IVA)
											.build())
									.build())
						.build())
				.build()
				;
		final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
		final SellarYTimbrarRequest request = SellarYTimbrarRequest.builder()
				.usuario(props.getProperty("emisor.usuario"))
				.contrasena(props.getProperty("emisor.contrasena"))
				.comprobante(comprobante)
				.build();
		final SellarYTimbrarResponse respuesta = api.selladorytimbrador32().ejecuta(request);

```

### Ejemplo de Cancelación de CFDI 3.2
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final CancelarRequest request = CancelarRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.uuid("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
			.build()
			; 
	final CancelarResponse respuesta = api.cancelador32().ejecuta(request);
```

### Ejemplo de Descarga de Xml
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final XmlRequest request = XmlRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.uuid("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
			.build()
			; 
	final XmlResponse respuesta = api.descargaxml().ejecuta(request);
```

### Ejemplo de Descarga de Acuses de Cancelación
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final XmlRequest request = XmlRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.uuid("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX")
			.build()
			; 
	final XmlResponse respuesta = api.descargaacusexml().ejecuta(request);
```

### Ejemplo de Descarga de Pdf
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final PdfRequest request = PdfRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.uuid(props.getProperty("xml.uuid"))
			.plantilla("EMITE")
			.build()
			; 
	final PdfResponse respuesta = api.pdf().ejecuta(request);
	respuesta.guardaPdf(props.getProperty("pdf.ruta"));
```

### Ejemplo de Descarga de Pdf de Acuse de Cancelación
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final PdfRequest request = PdfRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.uuid(props.getProperty("xml.uuid"))
			.build()
			; 
	final PdfResponse respuesta = api.pdfacuse().ejecuta(request);
	respuesta.guardaPdf(props.getProperty("pdf.ruta"));
```

### Ejemplo de Envio de Xml y Pdf por correo
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final CorreoRequest request = CorreoRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.uuid(props.getProperty("xml.uuid"))
			.plantilla("EMITE")
			.recuperarArchivos(true)
			.correo(CorreoParametros.builder()
					.asunto("asunto")
					.para(Correo.builder()
							.correo(props.getProperty("destinatario"))
						 	.build())
					.build())
			.build(); 
	final CorreoResponse respuesta = api.correos().ejecuta(request);
```

### Ejemplo de Descarga Masiva de Xml, Pdf y Acuses de Cancelación
-------------------------------------------------------
```java
	final EmiteAPI api = new EmiteAPI(Ambiente.PRUEBAS);
	final ZipRequest request = ZipRequest.builder()
			.usuario(props.getProperty("emisor.usuario"))
			.contrasena(props.getProperty("emisor.contrasena"))
			.xml(true)
			.filtro(ConsultaFiltro.builder()
					.rango(LocalDate.of(2016, 01, 01), LocalDate.of(2016, 01, 31))
					.build())
			.build()
			; 		
	final ZipResponse respuesta = api.descargamasiva().ejecuta(request);
	respuesta.guardaZip(props.getProperty("zip.ruta"));
```

## Servicios de Integrador
-------------------------------------------------------


### Ejemplo de Generación de Token de Consumo
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse respuesta = api.token().ejecuta(tr);		
```

### Ejemplo de Consulta de Tarifa y Timbres Disponibles
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
				.usuario(props.getProperty("integrador.usuario"))
				.contrasena(props.getProperty("integrador.contrasena"))
				.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final TimbresRequest timbresreq = TimbresRequest.builder()
			.token(tokenresp.getToken())
			.build();
	final TimbresResponse respuesta = api.timbres().ejecuta(timbresreq);	
```

### Ejemplo de Consulta de Emisores Registrados
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
				.usuario(props.getProperty("integrador.usuario"))
				.contrasena(props.getProperty("integrador.contrasena"))
				.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresRequest timbresreq = EmisoresRequest.builder()
			.token(tokenresp.getToken())
			.build();
	final EmisoresResponse respuesta = api.emisores().ejecuta(timbresreq);	
```

### Ejemplo de Consulta de Sucursales por Emisor
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
				.usuario(props.getProperty("integrador.usuario"))
				.contrasena(props.getProperty("integrador.contrasena"))					
				.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final SucursalesRequest timbresreq = SucursalesRequest.builder()
			.token(tokenresp.getToken())
			.rfc(props.getProperty("emisor.rfc"))
			.build();
	final SucursalesResponse respuesta = api.sucursales().ejecuta(timbresreq);
```

### Ejemplo de Alta de Emisores
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresAltaRequest timbresreq = EmisoresAltaRequest.builder()
		.token(tokenresp.getToken())
		.rfc("XAXX010101000")
		.tipoEmisor(TipoIntegradorEmisor.POSTPAGO)
		.usuario("usuarioWs")
		.contrasena("contrasenaWs")
		.correo("test@test.com")
		.razonSocial("Razon Social")
		.calle("calle")
		.cp("04300")
		.municipio("Benito Juarez")
		.idEstado(Estados.DISTRITOFEDERAL )
		.idPais(Paises.MEXICO )
		.idRegimen(RegimenesFiscales.GENERALDELEYPERSONASMORALES)
		.idFormaPago(FormasPago.TRANSFERENCIA)
		.cuentapago("1234")
		.build();
	final EmisoresAltaResponse respuesta = api.emisoresalta().ejecuta(timbresreq);
```

### Ejemplo de Modificación de Emisores
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresModificacionRequest timbresreq = EmisoresModificacionRequest.builder()
		.token(tokenresp.getToken())
		.rfc("XAXX010101000")
		.correo("test@test.com")
		.razonSocial("Razon Social")
		.calle("calle")
		.cp("04300")
		.municipio("Benito Juarez")
		.idEstado(Estados.DISTRITOFEDERAL )
		.idPais(Paises.MEXICO )
		.idRegimen(RegimenesFiscales.GENERALDELEYPERSONASMORALES)
		.idFormaPago(FormasPago.TRANSFERENCIA)
		.cuentapago("1234")
		.build();
	final EmisoresModificacionResponse respuesta = api.emisoresmodificacion().ejecuta(timbresreq);
```

### Ejemplo de Carga de CSD
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresCsdRequest timbresreq = EmisoresCsdRequest.builder()
		.token(tokenresp.getToken())
		.rfc("XAXX010101000")
		.cer(props.getProperty("cer"))
		.key(props.getProperty("key"))
		.contrasenaCsd("contrasenaWs")
		.build();
	final EmisoresCsdResponse respuesta = api.emisorescsd().ejecuta(timbresreq);
```

### Ejemplo de Consulta de CSD
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
					.usuario(props.getProperty("integrador.usuario"))
					.contrasena(props.getProperty("integrador.contrasena"))
					.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresCsdConsultaRequest timbresreq = EmisoresCsdConsultaRequest.builder()
				.token(tokenresp.getToken())
				.rfc(props.getProperty("emisor.rfc")
				.build();
	final EmisoresCsdConsultaResponse respuesta = api.emisorescsdconsulta().ejecuta(timbresreq);
```

### Ejemplo de Consulta de Estatus de Emisores
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresEstatusRequest timbresreq = EmisoresEstatusRequest.builder()
		.token(tokenresp.getToken())
		.rfc(props.getProperty("emisor.rfc")
		.build();
	final EmisoresEstatusResponse respuesta = api.emisoresestatus().ejecuta(timbresreq);
```

### Ejemplo de Alta / Modificación de Sucursales
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final SucursalesAltaRequest timbresreq = SucursalesAltaRequest.builder()
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
				.idFormaPago(FormasPago.TRANSFERENCIA)
				.cuentapago("1234")								
				.build())				
		.build();
	final SucursalesAltaResponse respuesta = api.sucursalesalta().ejecuta(timbresreq);
```

### Ejemplo de Servicio de Carga de Documentación
-------------------------------------------------------
```java
	final IntegradorAPI api = new IntegradorAPI(Ambiente.PRUEBAS);
	final TokenRequest tr = TokenRequest.builder()
			.usuario(props.getProperty("integrador.usuario"))
			.contrasena(props.getProperty("integrador.contrasena"))
			.build();
	final TokenResponse tokenresp = api.token().ejecuta(tr);	
	final EmisoresDocumentosRequest edr = EmisoresDocumentosRequest.builder()
		.token(tokenresp.getToken())
		.rfc("XAXX010101000")
		.pdf("PDFBASE64")
		.idTipoDocumento(1)
		.build();
	final EmisoresDocumentosResponse respuesta = api.emisoresdocumentos().ejecuta(edr);
```