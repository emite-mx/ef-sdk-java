![alt text](https://github.com/emitefacturacion/ef-sdk-java/blob/0.0.3/ef-sdk-java/src/main/resources/logo.png "Emite Facturacion")
# EmiteFacturacion [emitefacturacion.mx](https://www.emitefacturacion.mx)

## ef-sdk-java-0.0.2
**** Kit de consumo de servicios Emite Facturación

### Instalación Maven
-------------------------------------------------------
Para instalar esta libreria es necesario que agregue el siguiente codigo en su archivo pom.xml

```xml
<dependency>
	<groupId>mx.emite</groupId>
	<artifactId>ef-sdk-java</artifactId>
	<version>0.0.2</version>
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


### Requerimientos de utilización
-------------------------------------------------------
- Contar con registro de Integrador en nuestro portal de Integradores

	[Portal de Integradores: https://scot.emitefacturacion.mx](https://scot.emitefacturacion.mx)
    
### Documentación adicional de nuestros servicios
-------------------------------------------------------

- [Documentacion Técnica Api Servicios Web de Emisores: https://proxy.emitefacturacion.mx/api/](https://proxy.emitefacturacion.mx/api/)

- [Documentacion Técnica Api Servicios Web de Integradores: https://scot.emitefacturacion.mx/api/](https://scot.emitefacturacion.mx/api/)

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
				.formaDePago(FormasPago.PAGOENUNASOLAEXHIBICION)
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