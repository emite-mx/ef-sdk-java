package mx.emite.sdk.enums.sat;

import org.apache.commons.lang3.StringUtils;
import org.beanio.types.TypeConversionException;

import lombok.Getter;
import mx.emite.sdk.errores.ApiException;
import mx.emite.sdk.errores.I_Api_Errores;
import mx.emite.sdk.utils.Utilerias;

@Getter
public enum TiposContrato12 implements Sat<String>{
	
	TIEMPOINDETERMINADO("01","Contrato de trabajo por tiempo indeterminado",true),
	POROBRADETERMINADA("02","Contrato de trabajo para obra determinada",true),
	PORTIEMPODETERMINADO("03","Contrato de trabajo por tiempo determinado",true),
	PORTEMPORADA("04","Contrato de trabajo por temporada",true),
	APRUEBA("05","Contrato de trabajo sujeto a prueba",true),
	CAPACITACIONINICIAL("06","Contrato de trabajo con capacitación inicial",true),
	PORHORA("07","Modalidad de contratación por pago de hora laborada",true),
	PORCOMISION("08","Modalidad de trabajo por comisión laboral",true),
	SINRELACION("09","Modalidades de contratación donde no existe relación de trabajo",false),
	JUBILACION("10","Jubilación, pensión, retiro.",false),
	OTROCONTRATO("99","Otro Contrato",false),
	;
	
	final String idSat;
	final String descripcion;
	final String[] sinonimos;
	final Boolean requiereRegistroPatronal;
	
	TiposContrato12(String idSat,String descripcion,Boolean requiereRegistroPatronal){
		this(idSat,descripcion,null,requiereRegistroPatronal);
	}
	
	TiposContrato12(String idSat,String descripcion,String[] sinonimos,Boolean requiereRegistroPatronal){
		this.idSat=idSat;
		this.descripcion=descripcion;
		this.sinonimos=sinonimos;
		this.requiereRegistroPatronal=requiereRegistroPatronal;
	}
	
	public static void main(String[] args){
		int indice=1;
		for(TiposContrato12 p:values()){
				System.out.println("insert into h_sat_tipos_contrato values("+(indice++)+",'"+p.getIdSat()+"','"+p.getDescripcion()+"',"+(p.requiereRegistroPatronal?"1":0)+");");
		}
	}

	public static TiposContrato12 busca(String metodo) {
		for(TiposContrato12 m:values()){
			if(m.idSat.equals(metodo))
				return m;
			else if(Utilerias.compara(m.descripcion,metodo))
				return m;
			else if(m.sinonimos!=null){
				for(String s:m.sinonimos){
					if(Utilerias.compara(s,metodo))
						return m;
				}
			}
		}
		return null;
	}
	
	public static TiposContrato12 unmarshall(String metodo) throws ApiException{
		if(StringUtils.isEmpty(metodo))
			return null;
		final TiposContrato12 estado =  TiposContrato12.busca(metodo);		
		if(estado==null)
			throw new ApiException(I_Api_Errores.CLIENTE_XML_INVALIDO,"El tipo de contrato "+metodo+" no se encuentra en el catálogo de Tipos de Contrato del SAT");
		else
			return estado;
	}
	
	
	public static String marshall(TiposContrato12 v) throws Exception {
		if(v==null)
			return null;
		return v.getIdSat();
	}
	
	public static Object parse(String text) throws TypeConversionException, ApiException {
		return unmarshall(text);
	}
	
	@Override
	public String getIdString() {
		return idSat;
	}
	
	@Override
	public String toString(){
		return descripcion;
	}

	public static TiposContrato12 idSat(String tipo) {
		for(TiposContrato12 m:values()){
			if(m.idSat.equals(tipo))
				return m;
		}
		return null;
	}
}
