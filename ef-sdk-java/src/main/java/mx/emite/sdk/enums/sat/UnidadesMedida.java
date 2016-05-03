package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum UnidadesMedida implements Sat{
	
	NOAPLICA(0,"NO APLICA"),
	BARRIL(15,"BARRIL"),
	BOTELLA(21,"BOTELLA"),
	CABEZA(7,"CABEZA"),
	CAJA(20,"CAJA"),
	CIENTOS(18,"CIENTOS"),
	DECENAS(17,"DECENAS"),
	DOCENAS(19,"DOCENAS"),
	GRAMO(2,"GRAMO"),
	GRAMONETO  (16,"GRAMO NETO"),
	JUEGO(12,"JUEGO"),
	KILO(1,"KILO"),
	KILOWATT(10,"KILOWATT"),
	KILOWATTHORA(13,"KILOWATT/HORA"),
	LITRO(8,"LITRO"),
	METROCUADRADO(4,"METRO CUADRADO"),
	METROCUBICO(5,"METRO CUBICO"),
	METROLINEAL(3,"METRO LINEAL"),
	MILLAR(11,"MILLAR"),
	PAR(9,"PAR"),
	PIEZA(6,"PIEZA",new String[]{"PZA"}),
	SERVICIO(99,"SERVICIO"),
	TONELADA(14,"TONELADA"),
	COP(98,"COP"),
	;
	
	final Integer idSat;
	final String descripcion;
	final String[] sinonimo;
	
	UnidadesMedida(Integer idSat,String descripcion){
		this(idSat,descripcion,null);
	}
	
	UnidadesMedida(Integer idSat,String descripcion,String[] sinonimo){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimo=sinonimo;
	}
	
	
	/**
	 * Busca una unidad de medida de acuerdo a su id del SAT
	 * @param idSat de acuerdo al catalogo del SAT
	 * @return unidadesMedida valor del enum de acuerdo a la unidad de medida
	 */
	public static UnidadesMedida id(Integer idSat) {
		for(UnidadesMedida m:values()){
			if(m.idSat.equals(idSat))
				return m;
		}
		return null;
	}

	public static UnidadesMedida busca(String metodo) {
		for(UnidadesMedida m:values()){
			if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(Utilerias.compara(m.idSat.toString(),metodo))
				return m;
			else if(m.getSinonimo()!=null){
				for(String s:m.getSinonimo()){
					if(Utilerias.compara(s, metodo))
						return m;	
				}
				
			}
				
		}
		return null;
	}


	public static UnidadesMedida[] unidades() {
		 return values();
	}
	
	public Integer getIdUnidadMedida(){
		return idSat;
	}
	
	public static UnidadesMedida unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final UnidadesMedida estado =  UnidadesMedida.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"La unidad "+metodo+" no se encuentra en el catálogo de unidades de medida del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(UnidadesMedida v) throws Exception {
		if(v==null)
			return null;
		return v.getDescripcion();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
}
